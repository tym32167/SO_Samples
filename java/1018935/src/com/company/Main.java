package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File folder = new File("D:\\Code\\github\\SO_Samples\\java\\1018935\\src\\com\\company");
        FileFilterBuilder builder = new FileFilterBuilder();

        builder.addFilter(f->f.getName().startsWith("File"));

        FileManager manager = new FileManager();
        manager.getMathcingFiles(folder, builder.build())
                .forEach(f-> System.out.println(f.getName()));
    }
}

