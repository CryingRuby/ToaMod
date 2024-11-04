package classes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class MerchItem {
  private String Type;
  private int MaxStack;
  private double Rate;
  private int Price;
  private int Rarity;
  private ItemStack Item;

  public MerchItem(String type, int maxStack, double rate, int price, int rarity, ItemStack item) {
    Type = type;
    MaxStack = maxStack;
    Rate = rate;
    Price = price;
    Rarity = rarity;
    Item = item;
  }

  public String getType(){
    return Type;
  }
  public int getMaxStack(){
    return MaxStack;
  }
  public double getRate(){
    return Rate;
  }
  public int getPrice(){
    return Price;
  }
  public int getRarity(){
    return Rarity;
  }
  public ItemStack getItem(){
    return Item;
  }
}
