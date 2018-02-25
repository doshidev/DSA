/**
 * Created by ddoshi on 2/11/18.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DayOfTheProgrammer {

    static String solve(int year){
        // Jan to Aug i.e. 215 + days in Feb
        int janToAug = 215 + daysInFeb(year);
        int balance = 256 - janToAug;
        int[] a = new int[5];

        if(balance <= 30) {
            return prefix(balance) + ".09." + year;
        } else {
            return prefix(balance - 30) + ".10." + year;
        }
    }

    static String prefix(int day){
        if (day < 10){
            return "0" + Integer.toString(day);
        } else {
            return Integer.toString(day);
        }
    }

    static int daysInFeb(int year) {
        // Transition Year 1918
        if(year == 1918) {
            return 15;
        }

        // Julian Calendar
        if (year > 1918) {
            return ((year % 4 == 0) ? 29 : 28);
        }

        // Gregorian Calendar
        if(year <= 1917) {
            if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ) {
                return 29;
            }
        }
        return 28;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}

