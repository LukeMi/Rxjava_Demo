package com.lukemi.lib.tutorial.rxjava2.filter;

import io.reactivex.Observable;

/**
 * skip skipLast take takeLast
 */
public class Skip {
    public static void main(String[] args) {
        Observable.just(2, 5, 3, 7, 8, 9, 4, 1)
                .skip(4)
                .subscribe(integer -> System.out.print(integer + " , "));
        System.out.println("\n");

        Observable.just(2, 5, 3, 7, 8, 9, 4, 1)
                .skipLast(2)
                .subscribe(integer -> System.out.print(integer + " , "));
        System.out.println("\n");

        Observable.just(2, 5, 3, 7, 8, 9, 4, 1)
                .take(3)
                .subscribe(integer -> System.out.print(integer + " , "));
        System.out.println("\n");

        Observable.just(2, 5, 3, 7, 8, 9, 4, 1)
                .takeLast(3)
                .subscribe(integer -> System.out.print(integer + " , "));
        System.out.println("\n");
    }
}
