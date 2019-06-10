package com.lukemi.lib.tutorial.rxjava2.filter;

import io.reactivex.Observable;

public class Last {
    public static void main(String[] args) {
        Observable.just(1,4,3,6,7)
                .last(3)
                .subscribe(integer -> System.out.println(integer));
    }
}
