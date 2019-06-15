package com.lukemi.lib.tutorial.rxjava2.combine;

import io.reactivex.Observable;

public class Zip {
    public static void main(String[] args) {
        Observable<Integer> j1 = Observable.just(2);
        Observable<Integer> j2 = Observable.just(3);
        Observable.zip(j1, j2, (integer, s) -> integer != s)
                .subscribe(
                        aBoolean -> System.out.println("aBoolean : " + aBoolean),
                        throwable -> throwable.printStackTrace()
                );
    }
}
