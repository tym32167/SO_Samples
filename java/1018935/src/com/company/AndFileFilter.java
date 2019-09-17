package com.company;

import java.io.File;

    public class AndFileFilter implements IFileFilter {

        private final IFileFilter first;
        private final IFileFilter second;

        public AndFileFilter(IFileFilter first, IFileFilter second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean IsMatch(File file) {
            return first.IsMatch(file) && second.IsMatch(file);
        }
    }

