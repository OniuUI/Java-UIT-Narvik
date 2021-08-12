package Helper;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import static Helper.Helper.getTextFromTextField;
/**
 * <h1>Helper.ChatClient class.</h1>
 * <br>
 * Class that connect to LoanCalculatorSingleServer that let's user communicate with other clients
 *
 * @author Daniel Aaron Salwerowicz
 * @version 1.0
 * @since 2018-04-16
 */
public class ChatClient extends Application {
  /**
   * {@link TextField} for user input
   */
  private TextField tfUserInput = new TextField();

  /**
   * {@link TextField} for username input
   */
  private TextField tfUsername = new TextField();

  /**
   * {@link TextArea} displaying chat log
   */
  private TextArea taChatLog = new TextArea();

  /**
   * {@link ObjectInputStream} for receiving data from LoanCalculatorSingleServer
   */
  private ObjectInputStream fromServer;

  /**
   * {@link ObjectOutputStream} for sending data to LoanCalculatorSingleServer
   */
  private ObjectOutputStream toServer;

  /**
   * {@link ObjectOutputStream} for sending data to LoanCalculatorSingleServer
   */
  private String username;

  /**
   * {@link Socket} used to communicate back and forth with the LoanCalculatorSingleServer
   */
  private Socket socket;

  /**
   * The entry point of application
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Start method that sets up background processes and displays primary stage with GUI
   */
  @Override
  public void start(Stage primaryStage) {
    initializeUsernameTextField();

    initializeUserInputTextField();

    initializePrimaryStage(primaryStage);
  }

  /**
   * Sets up {@link ChatClient#tfUsername} with prompt text and lambda that reacts to Enter keypress
   */
  private void initializeUsernameTextField() {
    tfUsername.setPromptText("Enter your username and preferred pronouns");
    writeToLog("Enter your username and confirm it with enter");

    // Set up lambda that reacts to Enter key
    tfUsername.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.ENTER) {
        // Save username
        username = tfUsername.getText();
        // Disable username input field so that user cannot change username
        tfUsername.setEditable(false);
        // Connect to LoanCalculatorSingleServer now that user has a username
        connectToServer();
      }
    });
  }

  /**
   * Sets up {@link ChatClient#tfUserInput} with prompt text and lambda that reacts to Enter keypress
   *
   * @see ChatClient#sendToServer(String)
   */
  private void initializeUserInputTextField() {
    tfUserInput.setPromptText("Enter your rant about misogyny");
    // Disable so that user cannot start writing messages before LoanCalculatorClient has connected to LoanCalculatorSingleServer
    tfUserInput.setEditable(false);

    // Set up lambda that reacts to Enter key
    tfUserInput.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.ENTER) {
        try {
          // Send user input from input field to LoanCalculatorSingleServer
          sendToServer(getTextFromTextField(tfUserInput));
        } catch (Exception e) {
          // General error handling, nothing sophisticated
          writeToLog('\n' + e.toString());
          writeToLog("Please restart your chat LoanCalculatorClient.");
          tfUserInput.setEditable(false);
        }
      }
    });
  }

  /**
   * Sets up primary stage with some design and handles window closing
   *
   * @param primaryStage Stage sent in from {@link ChatClient#start(Stage)} method
   */
  private void initializePrimaryStage(Stage primaryStage) {
    // Set up scene
    Scene scene = new Scene(getBorderPane(), 600, 600);
    primaryStage.setTitle("Chat Client");
    primaryStage.setResizable(true);
    primaryStage.setScene(scene);
    primaryStage.show();

    // Close socket and stop program from running in background
    primaryStage.setOnCloseRequest(t -> {
      try {
        socket.close();
      } catch (IOException e) {
        writeToLog('\n' + e.toString());
      }
      Platform.exit();
      System.exit(0);
    });
  }

  /**
   * Creates {@link BorderPane} with design and setup for chat log
   *
   * @return BorderPane with necessary GUI elements for LoanCalculatorClient
   */
  private BorderPane getBorderPane() {
    taChatLog.setEditable(false);
    taChatLog.setWrapText(true);

    VBox box = new VBox();
    box.getChildren().addAll(tfUsername, tfUserInput);
    box.setAlignment(Pos.CENTER);

    BorderPane pane = new BorderPane();
    pane.setCenter(taChatLog);
    pane.setBottom(box);
    return pane;
  }

  /**
   * Starts a new thread that establishes LoanCalculatorSingleServer connection using {@link ChatClient#establishServerConnection()}
   */
  private void connectToServer() {
    new Thread(() -> {
      try {
        establishServerConnection();
      } catch (Exception e) {
        // General error handling, nothing sophisticated
        writeToLog('\n' + e.toString() + "rtyrtyry");
        writeToLog("Please restart your chat LoanCalculatorClient.");
        tfUserInput.setEditable(false);
      }
    }).start();
  }

  /**
   * Connects to LoanCalculatorSingleServer using {@link Socket}
   *
   * @throws IOException if {@link ObjectOutputStream} encounters an error
   * @throws InterruptedException {@link ChatClient#receiveDataFromServer()} encounters an error
   */
  private void establishServerConnection() throws IOException, InterruptedException {
    // Connects to LoanCalculatorSingleServer
    socket = new Socket("localhost", 2341);

    // Sets up input and output streams with LoanCalculatorSingleServer
    fromServer = new ObjectInputStream(socket.getInputStream());
    toServer = new ObjectOutputStream(socket.getOutputStream());

    // Send username to LoanCalculatorSingleServer, registering LoanCalculatorClient in the system
    toServer.writeUTF(username);
    toServer.flush();

    // Enable user input field so that user can start writing messages
    tfUserInput.setEditable(true);

    // Continually receive data from LoanCalculatorSingleServer
    receiveDataFromServer();
  }

  /**
   * Method used to receive data from LoanCalculatorSingleServer
   *
   * @throws IOException if {@link ObjectInputStream} encounters an error
   * @throws InterruptedException if {@link Thread#sleep(long)} encounters an error
   */
  private void receiveDataFromServer() throws IOException, InterruptedException {
    while (true) {
      // Receives data from LoanCalculatorSingleServer
      String message = fromServer.readUTF();

      // Writes message to log
      writeToLog(message);

      // Stops listening to LoanCalculatorSingleServer if denied connection
      if(message .equals("Sorry but we've reached the maximum user capacity.\nTry again later.")) break;

      // Wait for 0.1 sec, used to not overload the LoanCalculatorClient with constant calls to readUTF method
      Thread.sleep(100);
    }
  }

  /**
   * Sends text to LoanCalculatorSingleServer
   *
   * @param text Text to be sent to LoanCalculatorSingleServer
   * @throws IOException if {@link ObjectOutputStream#writeUTF(String)} encounters an error
   */
  private void sendToServer(String text) throws IOException {
    toServer.writeUTF(text);
    toServer.flush();
  }

  /**
   * Uses {@link Platform#runLater(Runnable)} method to update {@link TextArea} with a given message
   *
   * @param message Message to be displayed in TextArea
   */
  private void writeToLog(String message) {
    Platform.runLater(() -> taChatLog.appendText(message + '\n'));
  }
}