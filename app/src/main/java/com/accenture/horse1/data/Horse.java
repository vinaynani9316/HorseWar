package com.accenture.horse1.data;

import java.util.ArrayList;
import com.accenture.horse1.R;
import com.accenture.horse1.model.Item;

public class Horse
{

    public ArrayList<Item> getHorseList() {
        ArrayList<Item> horseList = new ArrayList<>();
        horseList.add(new Item("Sergeant Reckless", R.drawable.sergeant_reckless, "sam",1f ));
        horseList.add(new Item("Comanche",R.drawable.comanche, "ram", 3f));
        horseList.add(new Item("Cincinnati",R.drawable.cincinnati,  "bam", 5f));
        return horseList;
    }
}
