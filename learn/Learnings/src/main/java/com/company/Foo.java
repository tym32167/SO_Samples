package com.company;

import java.util.concurrent.Callable;

public class Foo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 10;
    }

    @Override
    public String toString() {
        return "Foo sting";
    }
}
