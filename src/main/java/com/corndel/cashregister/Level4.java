package com.corndel.cashregister;

import com.corndel.cashregister.models.Item;

import java.util.ArrayList;
import java.util.List;

public class Level4 {
  /**
   * Returns true if it is possible to make the target amount out of the cash in
   * the drawer. Returns false if it is not possible.
   */
  public static boolean canMakeAmount(int target, List<Item> drawer) {
    // TODO

    List<Item> sortedDrawer = new ArrayList<>(drawer);
    sortedDrawer.sort((a, b) -> b.value - a.value);

    for (Item item : sortedDrawer) {
      while (item.quantity > 0 && target >= item.value) {
        target -= item.value;
        item.quantity -= 1;
      }
    }

    return target == 0;

  }
}
