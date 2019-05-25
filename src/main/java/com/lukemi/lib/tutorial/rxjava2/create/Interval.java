package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class Interval {
    public static void main(String[] args) {
        // ToDo Interval do not work
        Observable.interval(2,2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    public void accept(Long aLong) throws Exception {
                        System.out.println(aLong);
                    }
                });
    }
}
