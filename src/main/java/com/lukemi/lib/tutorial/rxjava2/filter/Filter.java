package com.lukemi.lib.tutorial.rxjava2.filter;

import io.reactivex.Observable;

public class Filter {
    public static void main(String[] args) {
        Observable.just(0, 3, 4, 6, 9)
                .filter(integer -> integer % 3 != 0)
                .subscribe(aInteger -> {
                    System.out.println(aInteger);
                }, throwable -> {
                    System.out.println(throwable.getMessage());
                });
    }
}
