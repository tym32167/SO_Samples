package org.maven.tests;

public class FooPrinter{

    private FooMessage message;

    public FooPrinter(FooMessage message) {
        this.message = message;
    }

    public void Print(){
        System.out.println(this.message.Message());
    }
}
