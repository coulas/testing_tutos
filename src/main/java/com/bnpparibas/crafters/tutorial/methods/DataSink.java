package com.bnpparibas.crafters.tutorial.methods;

public class DataSink {
    public void increment() {
        throw new DependencyCalledException("You have called a costly production system");
    }

    public void save(DataRef data) {
        throw new DependencyCalledException("You have called a costly production system");
    }
}
