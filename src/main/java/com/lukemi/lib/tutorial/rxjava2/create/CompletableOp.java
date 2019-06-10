package com.lukemi.lib.tutorial.rxjava2.create;

import io.reactivex.Completable;

public class CompletableOp {
    public static void main(String[] args) {
        complete();
        error();
    }

    private static void complete() {
        Completable.complete()
                .subscribe(
                        () -> System.out.println("onComplete" + "\n"),
                        throwable -> System.out.println("onError : " + throwable.getMessage())
                );
    }

    private static void error() {
        Completable.error(new Throwable("fuck"))
                .subscribe(
                        () -> System.out.println("onComplete"),
                        throwable -> System.out.println("onError : " + throwable.getMessage())
                );
    }
}
