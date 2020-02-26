package com.company.marius.library;

import java.io.Serializable;

public abstract class LibraryItem implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
