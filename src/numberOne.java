public class numberOne {

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0; // True if divisible by 400
            }
            return true; // True if divisible by 4 but not by 100
        }
        return false; // Not divisible by 4
    }

    public static int numberOfLeapYears(int year1, int year2) {
        int cnt = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                cnt++;
            }
        }
        return cnt;
    }
    public static int dayOfWeek(int month, int day, int year)
    {

    }
}


