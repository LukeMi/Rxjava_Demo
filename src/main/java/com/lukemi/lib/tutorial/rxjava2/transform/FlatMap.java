package com.lukemi.lib.tutorial.rxjava2.transform;


import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

public class FlatMap {
    public static void main(String[] args) {
        Observable.just(2)
                .doOnNext(aInteger -> {
                    System.out.println("doOnNext : " + aInteger);
                })
                .flatMap((Function<Integer, ObservableSource<String>>) integer -> Observable.just(String.valueOf(integer + " is transform to string")))
                .subscribe(
                        s -> {
                            System.out.println(s);
                        }
                );
    }
}
