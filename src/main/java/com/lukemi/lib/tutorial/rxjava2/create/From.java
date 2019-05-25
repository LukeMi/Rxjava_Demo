package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;

public class From {
    public static void main(String[] args) {
        Observable.fromArray(2, 9, 6, 7)
                .subscribe(integer -> System.out.println(integer), throwable -> System.out.println(throwable.getMessage()));
    }
}
