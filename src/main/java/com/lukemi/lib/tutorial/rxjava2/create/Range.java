package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Observable;

public class Range {
    public static void main(String[] args) {
        Observable.range(5, 10)
                .subscribe(integer -> {
                            System.out.println("integer : " + integer);
                            if (integer == 13) {
                                throw new RuntimeException("integer can not be 13");
                            }
                        },
                        throwable -> System.out.println(throwable.getMessage()));
    }
}
