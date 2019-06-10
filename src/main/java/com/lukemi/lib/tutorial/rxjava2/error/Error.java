package com.lukemi.lib.tutorial.rxjava2.error;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Error {
    public static void main(String[] args) {
    /*    CompletableOp.error(new Throwable("completable is error"))
//                .observeOn(Schedulers.newThread())
//                .subscribeOn(Schedulers.computation())
                .doOnSubscribe(disposable -> {
                    System.out.println("doOnSubscribe thread : " + Thread.currentThread().getName());
                })
                .doOnComplete(() -> {
                    System.out.println("doOnComplete thread : " + Thread.currentThread().getName());
                })
                .doOnError(throwable -> {
                    System.out.println("doOnError thread : " + Thread.currentThread().getName());
                })
                .doOnTerminate(() -> {
                    System.out.println("doOnTerminate thread : " + Thread.currentThread().getName());
                })
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        System.out.println("onSubscribe");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                    }
                });*/


        errorTest();

    }

    private static void errorTest() {
        Observable.error(new Throwable("test onError op"))
                .doOnTerminate(() -> {
                    System.out.println("doOnTerminal : ");
                })
                .subscribe(throwable -> {
                    System.out.println("onNext : " + throwable.getClass().getSimpleName());
                }, throwable -> {
                    System.out.println("onError : " + throwable.getMessage());
                }, () -> {
                    System.out.println("onComplete : ");
                });
    }

    private static void testThread() {
        Observable.just(1)
//                .observeOn(Schedulers.newThread())
//                .subscribeOn(Schedulers.computation())
                .doOnSubscribe(disposable -> {
                    System.out.println("doOnSubscribe thread : " + Thread.currentThread().getName());
                })
                .doOnComplete(() -> {
                    System.out.println("doOnComplete thread : " + Thread.currentThread().getName());
                })
                .doOnError(throwable -> {
                    System.out.println("doOnError thread : " + Thread.currentThread().getName());
                })
                .doOnTerminate(() -> {
                    System.out.println("doOnTerminate thread : " + Thread.currentThread().getName());
                })
                .subscribe(
                        a -> {
                            System.out.println("onNext : " + a);
                        }, throwable -> {
                            System.out.println("onError : " + throwable.getMessage());
                        }, () -> {
                            System.out.println("onCompleted : ");
                        }
                );
    }
}
