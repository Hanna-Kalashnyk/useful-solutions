//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
// of rows like this:
// (you may want to display this pattern in a fixed font for better legibility)
package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.HashMap;

public class ZiigzagConversion6
{
    public String convert(String s, int numRows)
    {
        if (numRows <= 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        int direction = 1;

        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            if (currRow == 0) {
                direction = 1;
            } else if (currRow == numRows - 1) {
                direction = -1;
            }

            currRow += direction;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}