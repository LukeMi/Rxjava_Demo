package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Timer {
    public static void main(String[] args) {

        Observable.timer(2, TimeUnit.SECONDS, Schedulers.trampoline())
                .doFinally(() -> {
                    System.out.println("final delay : " + System.currentTimeMillis());
                })
                .doOnSubscribe(disposable -> {
                    System.out.println("delay : " + System.currentTimeMillis());
                })
                .subscribe(aLong -> System.out.println("subscribe delay : " + System.currentTimeMillis()));
    }
}
