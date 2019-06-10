package com.lukemi.lib.tutorial.rxjava2.transform;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Buffer {
    public static void main(String[] args) {
        Observable.just(2, 3, 57, 9)
                .subscribe(a -> System.out.println(a));
        System.out.println();

        Observable.just(2, 3, 57, 9,17,19)
                .buffer(5, 4)
                .subscribe(a -> System.out.println(a));
        System.out.println();

        Observable.just(2, 3, 57, 9)
                .buffer(1, 2, TimeUnit.SECONDS)
                .subscribe(a -> System.out.println(a));
    }
}
