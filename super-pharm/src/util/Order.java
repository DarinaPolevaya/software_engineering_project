package util;

import java.util.HashMap;

public class Order {
private int id;
private HashMap<Integer, Integer> orderList;
public int getId() {return id;}
public HashMap<Integer, Integer> getOrderList() {return orderList;}
public void setId(int id) {this.id=id;}
public void setOrderList(HashMap<Integer, Integer> orderList) {this.orderList=orderList;}
}
