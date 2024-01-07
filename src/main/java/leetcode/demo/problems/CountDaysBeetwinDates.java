package leetcode.demo.problems;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class CountDaysBeetwinDates {
        public int daysBetweenDates(String date1, String date2) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate localDate1 = LocalDate.parse(date1, formatter);
            LocalDate localDate2 = LocalDate.parse(date2, formatter);

            return (int) Math.abs(ChronoUnit.DAYS.between(localDate1, localDate2));
        }
}
