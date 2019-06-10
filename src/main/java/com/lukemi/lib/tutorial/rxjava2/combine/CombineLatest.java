package com.lukemi.lib.tutorial.rxjava2.combine;


import io.reactivex.Observable;

public class CombineLatest {
    public static void main(String[] args) {
        Observable<Integer> just = Observable.just(2);
        Observable<Integer> range = Observable.just(1, 2);
        Observable.combineLatest(just, range, (integer, integer2) -> (integer + integer2) % 2 == 0).subscribe(aBoolean -> {
            System.out.println(aBoolean);
        });

    }
}
