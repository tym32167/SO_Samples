/*
 * Developed by Artem Muradov
 */

package com.company;

import java.io.Serializable;

public class Ser implements Serializable {

    private static final long serialVersionUID = 7986541478968268991L;

    public  Ser(int id)
    {
        this.id = id;
    }

    private int id = 0;
    private String name = "Name";

    private int f = 0;

    @Override
    public String toString() {
        return id + " " + name;
    }
}
