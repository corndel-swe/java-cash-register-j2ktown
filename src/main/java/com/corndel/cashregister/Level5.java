package com.corndel.cashregister;

import com.corndel.cashregister.models.Item;

import java.util.ArrayList;
import java.util.List;

public class Level5 {
  /**
   * Calculates the amount of change the customer is owed based on the cost and
   * the amount paid. Adds the customer's paid amount to the drawer, removes their
   * change from the drawer, and then returns the updated drawer.
   * 
   * <p>
   * The paid items must be added to the drawer before removing the appropriate
   * change.
   * 
   * <p>
   * E.g., if the customer pays for $8.50 worth of goods with a $5 and 4 * $1
   * bills, then `paid` will be given as
   * 
   * List.of(new Item("five", 500, 1), new Item("one", 100, 4))
   * 
   * A "five" and a "one" should be added to the drawer, and two "quarters" should
   * be removed as change.
   * 
   * <p>
   * If you want to re-use some functions from other levels, you can do, e.g.
   * Level1.addItem(...) and so on.
   */
  public static List<Item> transaction(int cost, List<Item> paid, List<Item> drawer) {
    // TODO

    int total = 0;

    // add to draw
    for (Item item : paid) { //iterate over items paid
      total += item.getQuantity() * item.getValue(); // add total paid to total
      for (Item drawItem : drawer) { // iterate over draw
        if (item.name.equals((drawItem.name))) { // if the item paid == item in draw, updat the qty
          drawItem.setQuantity(item.getQuantity() + drawItem.getQuantity());
        }
      }
    }


      int remainder = total - cost;

      List<Item> sortedDrawer = new ArrayList<>(drawer);
      sortedDrawer.sort((a, b) -> b.value - a.value);

      for (Item item : sortedDrawer) {
        while (item.quantity > 0 && remainder >= item.value) {
          remainder -= item.value;
          item.quantity -= 1;
        }

      }
      return drawer;

    }
  }
