import java.util.HashMap;

class ExcelSheetColumnTitle
{

    public String convertToTitle(int columnNumber)
    {
        String rez;
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");
        map.put(8, "H");
        map.put(9, "i");
        map.put(10, "J");
        map.put(11, "K");
        map.put(12, "L");
        map.put(13, "M");
        map.put(14, "N");
        map.put(15, "O");
        map.put(16, "P");
        map.put(17, "Q");
        map.put(18, "R");
        map.put(19, "S");
        map.put(20, "T");
        map.put(21, "U");
        map.put(22, "V");
        map.put(23, "W");
        map.put(24, "X");
        map.put(25, "Y");
        map.put(26, "Z");
        rez = map.get(columnNumber % 26);
        while ( columnNumber > 26 )
        {
            columnNumber = columnNumber / 26;
            rez = map.get(columnNumber % 26) + rez;
        }
        return rez;
    }

    public String convertToTitle1(int columnNumber1)
    {
        return columnNumber1 == 0 ? "" : convertToTitle1(--columnNumber1 / 26) + (char)('A' + (columnNumber1 % 26));
    }
}