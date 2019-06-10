package com.lukemi.lib.tutorial.rxjava2.transform;

import com.lukemi.lib.tutorial.data.Animal;
import com.lukemi.lib.tutorial.data.Fish;
import io.reactivex.Observable;


public class Cast {
    public static void main(String[] args) {
        Observable.just(getAnimal())
                .cast(Fish.class)
                .subscribe(fish -> fish.eat());
    }

    public static Animal getAnimal() {
        return new Fish();
    }
}
