package com.example.practice;

import java.util.ArrayList;

/**
 * To contain data in certain view component
 * Each instance of static inner class represents a view subcomponent
 */
public class StaticInnerModels {

    private ArrayList<CardData> dataArrayList;

    //rest of class not shown --

    static class CardData{
        private String name;
        private String path;
        //constructors and getters not shown
    }

}
