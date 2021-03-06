package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;

public class Repeat {
    public static void main(String[] args) {
        Observable.range(1, 4)
                .repeat(2)
                .subscribe(integer -> System.out.println(integer));
    }
}
