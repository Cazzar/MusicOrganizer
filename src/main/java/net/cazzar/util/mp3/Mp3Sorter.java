package net.cazzar.util.mp3;

import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.File;
import java.io.IOException;

import static java.util.Arrays.asList;

public class Mp3Sorter {
    static boolean recursive = false;
    static File in;
    static File out;

    public static void main(String[] args) throws IOException {
        OptionParser parser = new OptionParser();
        parser.acceptsAll(asList("i", "d", "directory", "dir"), "The directory to read from").withRequiredArg().ofType(File.class).required();
        parser.acceptsAll(asList("r", "recursive"), "Recurse into sub dirs");
        parser.acceptsAll(asList("o", "output"), "Output all files into").withRequiredArg().ofType(File.class).required();

        OptionSet options;
        try {
            options = parser.parse(args);
        } catch (OptionException exception) {
            System.out.println("Missing options");
            parser.printHelpOn(System.out);
            System.exit(1);
            return;
        }

        recursive = options.has("r");
        in = (File) options.valueOf("d");
        out = (File) options.valueOf("o");
    }
}
