/*
 * Developed by Artem Muradov
 */

package com.company;





import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.*;
import java.util.logging.*;


public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException, ClassNotFoundException {

        var s = new Ser(30);

        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get("ser.data"))))
        {
            out.writeObject(s);
        }

        try(ObjectInputStream inp = new ObjectInputStream(Files.newInputStream(Paths.get("ser.data"))))
        {
            var ss = (Ser) inp.readObject();
            System.out.println(ss);
        }

    }



    public static void mt() throws ExecutionException, InterruptedException {


        var cl = Main.class;



        Logger logger
                = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


        var cc = logger.getClass();

        System.out.println(cc);


        var pool = Executors.newFixedThreadPool(10);
        Future<Integer>[] futures = new FutureTask[10];

        for(int i=0; i< futures.length; i++)
        {
            logger.info("Creating futures");
            futures[i] = pool.submit(new Foo());
        }



        for(int i=0; i< futures.length; i++)
        {
            logger.info("Waiting for " + i);
            var f = futures[i];
            var ret = f.get();
            logger.info("Result for " + i + " is " + ret);
        }

        pool.shutdown();
        logger.info("END");
    }





    public  static void Logger()
    {
        // Create a Logger
        Logger logger
                = Logger.getLogger("");


        logger.setLevel(Level.FINER);

        var handler = new ConsoleHandler();

        handler.setLevel(Level.FINER);

        var fmt = new SimpleFormatter();
        handler.setFormatter(fmt);


       // logger.addHandler(handler);


        logger.setLevel(Level.FINER);

        logger.info("lskdhjfsdl");


        logger.entering(Main.class.getName(), "main");
        logger.entering(List.class.getName(), "toString()");

    }


    public static void ImageProc() throws IOException {
        String fname = "D:\\temp\\154800137443598227.png";
        File f = new File(fname);
        BufferedImage image = ImageIO.read(f);
    }

    public static void Props() throws IOException {

        Properties p = new Properties();

        try(Reader r = new InputStreamReader(Main.class.getResourceAsStream("user.properties")) )
        {
            p.load(r);
            System.out.println(p);
        }




        p.setProperty("foo", "bar");

        System.out.println(p.getProperty("foo"));

        try (Writer w = Files.newBufferedWriter(Paths.get("myprops.props"))) {
            p.store(w, "comment");
        }

        try (OutputStream w = Files.newOutputStream(Paths.get("myprops.xml"))) {
            p.storeToXML(w, "comment");
        }
    }


    public static void Foo() {
        List<String> list = new ArrayList<>();

        list.add("1");
        list.add("2");


        list.addAll(Arrays.asList(new String[]{"3", "4"}));


        list.forEach(x -> System.out.println(x));

    }


    public static void Enclosing() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);

        try {
            for (int i : list) {
                list.add(i);
                System.out.println(list.size());
                if (list.size() / 0 > 100) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


