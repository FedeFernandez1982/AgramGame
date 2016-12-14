package com.Federico;

import java.util.ArrayList;

/**
 * Created by Federico on 12/5/2016.
 */


public class Player
{

    ArrayList<Card> hand = new ArrayList<>();
    String name;
    String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType(String type) {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

