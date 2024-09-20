package com.corndel.cashregister;

import com.corndel.cashregister.models.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2 {
  /**
   * Goes through the given drawer and counts how many *coins* there are in total
   * 
   * <p>
   * N.b. just the number of coins, not the total value of them
   * 
   * <p>
   * N.b. $1 is a note, not a coin
   */
  public static int countCoins(List<Item> drawer) {
    int count = 0;
    ArrayList<String> coinList = new ArrayList<>(Arrays.asList("quarter", "dime", "nickel", "penny"));

    for (Item item : drawer) {
      if (coinList.contains(item.getName())) {
        count += item.getQuantity();
        System.out.println(item.getName());
        System.out.println(item.getQuantity());
      }
    }
    return count;
  }

  /**
   * Same as count coins but for *notes* instead
   */
  public static int countNotes(List<Item> drawer) {
    // TODO
    ArrayList<String> noteList = new ArrayList<>(Arrays.asList("one","twenty","ten","five", "hundred"));
    int count = 0;

    for (Item item: drawer){
      if (noteList.contains(item.getName())){
          count += item.getQuantity();
        }
      }
    return count;
  }

}
