package javaFX;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * <h1> PrimeChecker class.</h1>
 * <br>
 * This class tests whether or not a {@link PrimeChecker#number} is a prime using single and multithreaded approach and shows execution time for both of these methods.
 *
 * @author Daniel Aaron Salwerowicz
 * @version 1.0
 * @since 2018-04-06
 */
public class PrimeChecker {

  /**
   * Used to set up all threads and run them when needed {@link ExecutorService}
   */
  private ExecutorService pool = Executors.newCachedThreadPool();

  /**
   * Variable used to define whether or not the {@link PrimeChecker#number} is a prime.
   */
  private boolean isPrime = true;

  /**
   * Number which is suspected to be a prime number.
   */
  private long number = 9223372036854775783L;

  /**
   * Number of threads to be created.
   */
  private int numberOfThreads = 1000;

  /**
   * Array telling threads where to start checking if {@link PrimeChecker#number} is prime.
   */
  private long[] startValues = new long[numberOfThreads];

  /**
   * Array telling threads where to stop checking if {@link PrimeChecker#number} is prime.
   */
  private long[] endValues = new long[numberOfThreads];

  /**
   * Runs program by calling this classes constructor {@link PrimeChecker#PrimeChecker()}
   *
   * @param args Command line arguments, ignored.
   */
  public static void main(String args[]) {
    new PrimeChecker();
  }

  /**
   * Sets up and runs both types of prime tests and displays results.
   */
  private PrimeChecker() {
    System.out.printf("Checking if %d is a prime number, multithreaded. %n%n", number);

    // Start "benchmarking".
    long startTime = System.currentTimeMillis();

    init();
    runThreads();

    // Stop "benchmarking".
    long endTime = System.currentTimeMillis();

    System.out.printf("%d%s a prime number.%n", number, isPrime ? " is" : " is not");
    System.out.printf("Execution time: %d ms. %n%n", endTime - startTime);

    System.out.printf("Checking if %d is a prime number, singlethreaded. %n", number);

    // Start "benchmarking".
    startTime = System.currentTimeMillis();

    isPrime = singlethreadedPrimeCheck();

    // Stop "benchmarking".
    endTime = System.currentTimeMillis();

    System.out.printf("%d%s a prime number.%n", number, isPrime ? " is" : " is not");
    System.out.printf("Execution time: %d ms. %n%n", endTime - startTime);

  } // end PrimeChecker method

  /**
   * Initializes the multiple threads and their division of work loads.
   */
  private void init() {
    // Check if even number.
    if (number % 2 == 0 && number != 2) {
      isPrime = false;
      return;
    }

    // We only compute for divisibility until the square root of the suspect number.
    // Forgive the awful casting, couldn't be fucked to do it differently.
    long limit = ( long ) Math.sqrt(( double ) number) + 1;

    // How many numbers each thread will need to check.
    long size = limit / numberOfThreads;

    // Initialize start and end values.
    startValues[0] = 3;
    endValues[numberOfThreads - 1] = limit;

    for (int i = 0; i < numberOfThreads - 1; i++) {
      // Start value for next each index is equal previous index + size.
      startValues[i + 1] = startValues[i] + size;
      // End value for each index is equal start value at next index - 1.
      endValues[i] = startValues[i + 1] - 1;
    }

    /*
    // Print limits, used for debugging.
    for (int i = 0; i < numberOfThreads; i++)
      System.out.println("Thread #" + (i + 1) + ": " + startValues[i] + "-" + endValues[i]);
    System.out.println();
    //*/

  } // end init method

  /**
   * Runs threads that check for primarity of specified {@link PrimeChecker#number}.
   */
  private void runThreads() {
    try {
      // Initialize and start threads.
      for (int i = 0; i < numberOfThreads && !pool.isShutdown(); i++) {
        PrimeTask thread = new PrimeTask(startValues[i], endValues[i], number);
        pool.execute(thread);
      }

      // Close executor service.
      pool.shutdown();

      // Wait for all tasks in executor service to finish.
      pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  } // end runThreads method

  /**
   * Called from threads to indicate that number is not a prime, stops exection of all threads in pool
   */
  private synchronized void notPrime() {
    // Stop execution of all threads.
    pool.shutdownNow();
    isPrime = false;
  }

  /**
   * Singlethraded prime checking algortihm, same as the one used in multithreaded approach.
   *
   * @return false if {@link PrimeChecker#number} is not a prime, true otherwise.
   */
  private boolean singlethreadedPrimeCheck() {
    // Check if even number.
    if (number % 2 == 0 && number != 2) {
      return false;
    }

    // Find limit.
    long limit = ( long ) Math.sqrt(( double ) number) + 1;

    // Check if prime.
    for (long i = 3; i <= limit; i += 2)
      if (number % i == 0)
        return false;

    return true;

  }// end singlethreadedPrimeCheck method

  /**
   * <h1> PrimeTask class.</h1>
   * <br>
   * This class defines task run by each thread in {@link PrimeChecker#runThreads()} method.
   *
   * @author Daniel Aaron Salwerowicz
   * @version 1.0
   * @since 2018-04-06
   */
  private class PrimeTask implements Runnable {
    /**
     * Specifies number to check.
     */
    private long number;

    /**
     * Specifies where to start checking if number is prime.
     */
    private long startValue;

    /**
     * Specifies where to end checking if number is prime.
     */
    private long endValue;

    /**
     * Creates a PrimeTask that will check if number is prime on specified interval.
     *
     * @param startValue Where to start checking if number is prime.
     * @param endValue   Where to end checking if number is prime.
     * @param number     Number to check.
     */
    PrimeTask(long startValue, long endValue, long number) {
      this.startValue = startValue;
      this.endValue = endValue;
      this.number = number;
    }

    /**
     * Simple prime checking algorithm, if not a prime then notPrime in outer class is called which stops all threads.
     */
    public void run() {
      for (long i = startValue; i <= endValue; i += 2)
        if (number % i == 0)
          notPrime();
    }

  } // end PrimeTask class
}// end PrimeCheck class