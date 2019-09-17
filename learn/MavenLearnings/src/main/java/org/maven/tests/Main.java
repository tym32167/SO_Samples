package org.maven.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FooPrinter printer = context.getBean("printer", FooPrinter.class);
        printer.Print();
    }
}


