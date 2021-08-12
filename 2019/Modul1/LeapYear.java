package Modul1;

public class LeapYear {
    public static boolean isLeapyear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
    }
}