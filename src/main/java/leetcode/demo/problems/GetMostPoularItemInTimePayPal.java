package leetcode.demo.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * пейпал задачки
 * 1. дано 2 методи
 * item bought(String item, long timestamp, String orderId)
 * getMostPopular(int k)
 * <p>
 * get most popular k items
 * <p>
 * complications: get most popular K items in the last hour, 30 minutes etc
 * getMostPopular(int k, int minutes)
 */

public class GetMostPoularItemInTimePayPal {
    private class Item {
        private String name;

        public Item(String name) {
            this.name = name;
        }
    }

    Item bought(String item, long timestamp, String orderId) {
        Item itemInTime = new Item(String.valueOf(timestamp));
        return itemInTime;
    }

    List<Item> popukarKItems(long startTimestamp, long endtimeStamp, int k){
        List<Item> res = new ArrayList<>();
        Map<Item, Integer> itemFrequency = new HashMap<>();
       // if (bought(item, timestenp))
        return res;
    }
}
