package com.blablacar.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputFile {

    private String filename;

    /**
     * @param filename
     */
    public InputFile(String filename){
        this.filename = filename;
    }

    /**
     * Reading the file and returning the list containing all the lines in the file.
     * @return List<String>
     */
    public List<String> readFile(){
        List<String> lines = new ArrayList<String>();
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            lines = stream.collect(Collectors.toList());
        } catch(NoSuchFileException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
