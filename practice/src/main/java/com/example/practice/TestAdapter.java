package com.example.practice;

import java.util.ArrayList;

/**
 * Adapter interface: convert interface of a class to that a client class expects
 *
 * e.g. TurkeyAdapter convert Turkey interface to Duck interface for DuckClient
 * e.g. RecyclerView.Adapter convert custom interface to ViewHolder interface for RecyclerView
 */
public class TestAdapter {
}

interface Duck2 {
    void quack();
    void fly();
}

class MallardDuck2 implements Duck2 {
    @Override
    public void quack() {
        System.out.println("Mallard Duck says Quack");
    }
    @Override
    public void fly() {
        System.out.println("Mallard Duck is flying");
    }
}

class DuckClient {

    static ArrayList<Duck2> myDucks;

    public static void main(String[] args){
        myDucks = new ArrayList<>();
        myDucks.add( new MallardDuck2());
        makeDucksFlyQuack();
    }

    static void makeDucksFlyQuack(){
        for(Duck2 duck: myDucks){
            duck.fly();
            duck.quack();
        }
    }
}

interface Turkey {
    public void gobble();
    public void fly();
}

class TurkeyAdapter implements Duck2 {
    Turkey turkey;
    TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }
    @Override
    public void quack() {
        //implement this
    }
    @Override
    public void fly() {
        //implement this
    }
}
