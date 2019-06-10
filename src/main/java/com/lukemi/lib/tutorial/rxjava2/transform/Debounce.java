package com.lukemi.lib.tutorial.rxjava2.transform;


import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Debounce {
    public static void main(String[] args) {
        Observable.just(2, 7, 8, 3)
                .debounce(0, TimeUnit.SECONDS)
                .subscribe(integer -> System.out.println("integer : " + integer));
    }
}
