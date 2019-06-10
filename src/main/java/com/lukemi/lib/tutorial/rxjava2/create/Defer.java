package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

import java.util.concurrent.Callable;

public class Defer {
    public static void main(String[] args) {

        Observable<Long> deferObservable = getDefer();
        Observable<Long> justObservable = getJust();

        Observable.defer((Callable<ObservableSource<Long>>) () -> deferObservable)
                .subscribe(aLong -> {
                    System.out.println("deferObservable Time1 : " + aLong);
                });

        Observable.defer((Callable<ObservableSource<Long>>) () -> deferObservable)
                .subscribe(aLong -> {
                    System.out.println("deferObservable Time2 : " + aLong);
                });

        justObservable.subscribe(aLong -> {
            System.out.println("justObservable Time : " + aLong);
        });

        justObservable.subscribe(aLong -> {
            System.out.println("justObservable Time : " + aLong);
        });
    }

    public static Observable<Long> getJust() {
        return Observable.just(System.currentTimeMillis());
    }

    public static Observable<Long> getDefer() {
        return Observable.defer(() -> getJust());
    }
}
