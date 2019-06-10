package com.lukemi.lib.tutorial.rxjava2.transform;


import io.reactivex.Observable;

public class Scan {
    public static void main(String[] args) {
        Observable.just(2, 6, 9)
                .scan((i1, i2) -> {
                    System.out.println("integer : " + i1 + " ;integer2 : " + i2);
                    return i1 + i2;
                })
                .subscribe(integer -> {
                    System.out.println(integer);
                });

        Observable.just(2, 2, 2, 2, 2, 2, 2, 2, 2, 2)
                .scan((i1, i2) -> i1 * i2)
                .subscribe(integer -> System.out.println("integer : " + integer));
    }
}
