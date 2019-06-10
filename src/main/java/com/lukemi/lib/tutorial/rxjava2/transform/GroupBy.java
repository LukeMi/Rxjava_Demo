package com.lukemi.lib.tutorial.rxjava2.transform;

import io.reactivex.Observable;

// Todo
public class GroupBy {
    public static void main(String[] args) {
        Observable.just(2, 4, 5, 6, 8, 9)
                .groupBy(integer -> integer % 2)
                .subscribe(a -> {
                    System.out.println(a);
                });
    }
}
