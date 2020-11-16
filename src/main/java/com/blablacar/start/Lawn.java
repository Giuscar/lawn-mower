package com.blablacar.start;

import com.blablacar.utils.InputFile;
import java.util.ArrayList;
import java.util.List;

public class Lawn {

    private List<Mower> mowers = new ArrayList<Mower>();
    private Coordinates lowerLeftCoordinates, lawnCoordinates;
    private boolean[][] grid;
    private List<String> lines;

    /**
     * @param filename
     */
    public Lawn(String filename){
        if (filename.isEmpty())
            throw new IllegalArgumentException("Invalid argument!");

        lines = new InputFile(filename).readFile();

        lawnCoordinates = new Coordinates(lines.get(0));
        if (lawnCoordinates.getX() < 0 || lawnCoordinates.getY() < 0)
            throw new IllegalArgumentException("Invalid lawn coordinates!");

        this.lowerLeftCoordinates = lawnCoordinates;

        /*The grid is a boolean matrix and its scope is to keep track the position of each
          mower. This grid is updated accordingly to the list of commands executed from each mower.
          The grid contains two possible values:
          1 - True: the position (x,y) is owned by a mower.
          2 - False: the position (x,y) is free.*/
        createGrid();

        // Once the coordinates have been retrieved, a list of mower is created.
        createMowers();
    }

    public void runMowers(){
        try {
            mowers.parallelStream().forEach(mower -> {
                mower.executeCommands(grid);
                System.out.println(mower.getFormattedPosition());
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    /**
     * Instantiating the grid matrix and setting it to false.
     * @return boolean[][]
     */
    private boolean[][] createGrid(){
        grid = new boolean[lowerLeftCoordinates.getX()][lowerLeftCoordinates.getY()];
        for (int i = 0; i < lowerLeftCoordinates.getX(); i++){
            for(int j = 0; j < lowerLeftCoordinates.getY(); j++){
                grid[i][j] = false;
            }
        }
        return grid;
    }

    private void createMowers(){
        int lineSize = lines.size();
        for (int i = 1; i < lineSize; i += 2) {
            try {
                if (i+1 < lineSize && lines.get(i+1) != null) {
                    Mower mower = new Mower(lines.get(i), lines.get(i + 1), lawnCoordinates);
                    this.mowers.add(mower);
                }
            }
            catch(IllegalArgumentException e){
                e.printStackTrace();
            }
        }
    }
}
