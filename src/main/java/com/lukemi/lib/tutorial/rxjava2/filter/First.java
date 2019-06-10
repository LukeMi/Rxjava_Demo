package com.lukemi.lib.tutorial.rxjava2.filter;

import io.reactivex.Observable;

public class First {
    public static void main(String[] args) {
        Observable.just(1,5,3,2,4,9,7)
                .first(5)
                .subscribe(integer -> {
                    System.out.println(integer);
                });
    }
}
