package com.lukemi.lib.tutorial.rxjava2.filter;

import io.reactivex.Observable;

public class ElementAt {
    public static void main(String[] args) {
        Observable.just(2, 4, 5, 6, 9, 3)
                .elementAt(9, 10)
                .subscribe(integer -> System.out.println("element : " + integer));
    }
}
