package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Repeat {
    public static void main(String[] args) {
        Observable.range(1, 4)
                .repeat(3)
                .subscribe(new Consumer<Integer>() {
                    public void accept(Integer integer) throws Exception {
                        System.out.println(integer);
                    }
                });
    }
}
