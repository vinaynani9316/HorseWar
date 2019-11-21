package com.accenture.horse1.data;

import java.util.ArrayList;

import com.accenture.horse1.model.Item;

public class ArrayListHolder {

    public final ArrayList<Item> selectedItemsList = new ArrayList<>();

    private ArrayListHolder() {}

    public static ArrayListHolder getInstance() {
        if( instance == null ) {
            instance = new ArrayListHolder();
        }
        return instance;
    }

    private static ArrayListHolder instance;

}
