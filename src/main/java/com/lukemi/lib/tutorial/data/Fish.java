package com.lukemi.lib.tutorial.data;

public class Fish implements Animal {
    @Override
    public void eat() {
        System.out.println("eat water");
    }

    @Override
    public void specialOp() {
        System.out.println("swim");
    }
}
