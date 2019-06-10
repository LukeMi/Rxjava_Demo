package com.lukemi.lib.tutorial.rxjava2.transform;

import io.reactivex.Observable;

public class Window {
    public static void main(String[] args) {
        Observable.just(2, 3, 5, 4, 8, 6, 7, 9)
                .window(3)
                .subscribe(observable -> {
                    System.out.println(observable);
                    observable.subscribe(integer -> {
                        System.out.println(integer);
                    });
                    System.out.println();
                });
    }
}
