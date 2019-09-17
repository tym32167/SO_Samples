package com.company;

    public class FileFilterBuilder {
        private IFileFilter currentFilter;

        public  FileFilterBuilder(IFileFilter initial){
            currentFilter = initial;
        }

        public FileFilterBuilder(){
            this(f->true);
        }

        public void addFilter(IFileFilter filter){
            currentFilter = new AndFileFilter(currentFilter, filter);
        }

        public IFileFilter build(){
            return currentFilter;
        }
    }
