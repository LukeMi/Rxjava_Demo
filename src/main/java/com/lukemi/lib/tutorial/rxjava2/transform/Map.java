package com.lukemi.lib.tutorial.rxjava2.transform;

import io.reactivex.Observable;

public class Map {
    public static void main(String[] args) {
        Observable.just(2)
                .map(integer -> integer + " map operator")
                .subscribe(aString -> {
                    System.out.println(aString);
                });
    }
}
