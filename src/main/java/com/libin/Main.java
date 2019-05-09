package com.libin;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Flux.generate((Consumer<SynchronousSink<String>>) synchronousSink -> synchronousSink.next(" hello"))
                .delayElements(Duration.ofMillis(2000))
                .subscribe(System.out::println);

        Thread.sleep(200000);
    }
}
