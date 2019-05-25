package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args) {

        // ToDo timer
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    public void accept(Long aLong) throws Exception {
                        System.out.println(aLong);
                    }
                });
    }
}
