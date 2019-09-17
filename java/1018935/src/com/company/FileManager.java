package com.company;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

    public class FileManager{
        public Stream<File> getMathcingFiles(File directory, IFileFilter filter){
            return Arrays.stream(directory.listFiles()).filter(f->filter.IsMatch(f));
        }
    }
