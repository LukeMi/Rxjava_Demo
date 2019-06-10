package com.lukemi.lib.tutorial.rxjava2.filter;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Sample {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS, Schedulers.trampoline())
                .sample(5, TimeUnit.SECONDS)
                .subscribe(aLong -> {
                    System.out.println(aLong);
                });
    }
}
