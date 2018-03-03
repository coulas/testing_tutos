package com.bnpparibas.crafters.tutorial.methods;

import java.util.UUID;

public class DataRef {
    private UUID id;
    private Object preciousInformation;

    @Override
    public String toString() {
        return "DataRef{" +
                "id=" + id +
                ", preciousInformation=" + preciousInformation +
                '}';
    }
}
