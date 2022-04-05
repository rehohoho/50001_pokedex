package com.example.practice;

/**
 * Strategy Design Pattern: flexible composition
 *   Delegation: parts of object are handed over to other objects
 *   Flexibility at runtime: composition is more flexible than inheritance
 *
 * e.g. Duck - with different fly and quack
 *
 * Duck, DuckClient:    RecyclerView with different adapter and layout managers
 * TurkeyAdapter:       CharaAdapter extends RecyclerView.Adapter
 * Turkey:              CharaAdapter.CharaViewHolder extends RecyclerView.ViewHolder
 *
 * Respond to clicks:
 *   Can implement View.OnClickListener interface on ViewHolder or CardView layout,
 *   passing in Chara model for former
 * Swipe to delete: attach ItemTouchHelper
 */
public class TestStrategy {
    public static void main(String[] args){
        Duck duck = new MallardDuck("Donald");
        duck.setFlyBehavior(new FlapWings());
        duck.setQuackBehavior(new LoudQuack());
        duck.display();
        duck.performFly();
        duck.performQuack();
    }
}

interface FlyBehavior {
    void fly();
}

interface QuackBehavior {
    void quack();
}

abstract class Duck {
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;
    String name;

    public Duck() {
    }

    public Duck(String name) {
        this.name = name;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public abstract void display();
}

class FlapWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Flapping my Wings");
    }
}

class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I cannot fly :(“");
    }
}

class LoudQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("QUACK");
    }
}

class MallardDuck extends Duck {
    MallardDuck(String name){
        super(name);
    }
    @Override
    public void display() {
        System.out.println("I am " + name + ", the Mallard Duck");
    }
}