package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;

public class Just {
    public static void main(String[] args) {
        Observable.just(6,1,9)
                .subscribe(integer -> System.out.println(integer));
    }
}
