package com.bnpparibas.crafters.tutorial.methods;

import java.util.UUID;

public class DataSource {
    public DataRef fetchNewData() {
        throw new DependencyCalledException("You have called a costly production system");
    }

    public DataRef fetchDataBy(UUID id) {
        throw new DependencyCalledException("You have called a costly production system");
    }
}
