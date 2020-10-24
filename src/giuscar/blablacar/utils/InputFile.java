package giuscar.blablacar.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFile {

    private String filename;

    public InputFile(String filename){
        this.filename = filename;
    }

    public List<String> readFile(){
        List<String> lines = new ArrayList<String>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            lines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("An error occurred during the read of the file " + filename);
            e.printStackTrace();
        }
        return lines;
    }
}
