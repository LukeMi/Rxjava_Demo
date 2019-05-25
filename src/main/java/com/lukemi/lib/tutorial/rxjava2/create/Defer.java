package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.util.concurrent.Callable;

public class Defer {
    public static void main(String[] args) {

        Observable<Long> justObservable = Observable.just(System.currentTimeMillis());
        Observable.defer((Callable<ObservableSource<Long>>) () -> justObservable)
                .subscribe(aLong -> {
                    System.out.println("deferObservable Time : " + aLong);
                });
        justObservable.subscribe(aLong -> {
            System.out.println("justObservable Time : " + aLong);
        });


    }
}
