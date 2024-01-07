package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Return the sides of rectangl triangl or empty Array, if no such.
 */
public class TrianglSides {
    public List<Integer> findTriangl(int[] sides) {
        List<Integer> res = new ArrayList<>();
        int n = sides.length;
        if (n < 3) return res;
        for (int num : sides) {
            num = num * num;
        }
        for (int i = 0; i < sides.length; i++) {
            Map<Integer, Integer> katet = new HashMap<>();
            Map<Integer, Integer> hypothenuza = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (katet.containsKey(sides[j])) {
                    res.add(sides[i]);
                    res.add(sides[j]);
                    res.add(katet.get(sides[j]));
                    return res;
                }
                katet.put(sides[i] - sides[j], j);
            }
            for (int j = 0; j < n; j++){
                if (j == i) continue;
                if (hypothenuza.containsKey(sides[j])) {
                    res.add(sides[i]);
                    res.add(sides[j]);
                    res.add(hypothenuza.get(sides[j]));
                    return res;
                }
                hypothenuza.put(sides[i] + sides[j], j);
            }
        }
        return res;
    }
}
