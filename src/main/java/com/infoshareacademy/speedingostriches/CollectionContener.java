package com.infoshareacademy.speedingostriches;

import com.infoshareacademy.speedingostriches.Expense;

import java.util.LinkedList;
import java.util.List;

public class CollectionContener {


    Expense firstExpense = new Expense("2018-02-12", "diary shopping", 125.45);
    Expense secondExpense = new Expense("2018-02-13", "entertainment", 75.45);
    Expense thirdExpense = new Expense("2018-02-14", "cadbury eggs", 25.50);
    Expense fourthExpense = new Expense("2018-02-18","gaspoline", 195.34);
    List<Expense> myList = new LinkedList<Expense>();

    public void addToLinkedList() {

        myList.add(firstExpense);
        myList.add(secondExpense);
        myList.add(thirdExpense);
        myList.add(fourthExpense);

        for (Expense x : myList) {
            System.out.println(x.getRegisterDate() + ";" + x.getCategoryName() + ";" + x.getCategroyValue());
        }


    }


}
