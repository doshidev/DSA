/**
 * Created by ddoshi on 2/23/18.
 */
public class DayofTheWeek {
    public static void main(String[] args) {
        System.out.println(findWeekDay(16,6,2018));
    }

    public static String findWeekDay(int day, int month, int year) {
        String[] weekdays = {"FRIDAY", "SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY"};
        int[] daysInMonth = {0, 31, 28, 31, 30, 31,30, 31, 31, 30, 31, 30, 31};
        int daysTillDate = 0;

        // Add days in Years
        for (int i = 2000; i < year; i++) {
            daysTillDate += isLeap(i) ? 366 : 365;
        }

        // Add days months
        for (int i = 1; i < month; i++) {
            if(i == 2 && isLeap(year)) daysTillDate += 1;
            daysTillDate += daysInMonth[i];
        }

        // Add days
        daysTillDate += day;
        System.out.println(daysTillDate);
        return weekdays[daysTillDate % 7];

    }

    public static boolean isLeap(int year) {
        if(year % 100 == 0 && year % 400 != 0) return false;
        if(year % 4 == 0) return true;
        return false;
    }
}
