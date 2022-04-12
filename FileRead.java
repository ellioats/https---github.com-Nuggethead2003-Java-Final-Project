// Elliot + Amir
// 04-11-22
// Purpose: Class reads from file and parses various info

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class FileRead {

    private Scanner scan;
    private File f;
    private int numOfLines;

    public FileRead(String path) {
        f = new File(path);
        try {
            this.scan = new Scanner(f);
        } catch (FileNotFoundException e) {e.printStackTrace();} 
    }

    private String[] fileRead() {
        String[] ret = new String[(int) f.length()];
        int counter = 0;
        while(scan.hasNextLine()) {
            ret[counter] = scan.nextLine();
            counter++;
        }
        numOfLines = counter;
        return ret;
    }

    // might delete
    private String[] fileSearch(byte option, String content) {
        // option
        // 0: Search by movie name
        // 1: Search by release date
        // 2: Search by location
        // 3: Search by Genere
        // 4: Search by rating
        // 5: Search by duration (in mins)
        // 6: Search by price

        String[] ret = new String[(int) f.length()];
        int counter = 0;

        while(scan.hasNextLine()) {
            if (scan.nextLine().contains(content)) {
                ret[counter] = scan.nextLine();
                counter++;
            }
        }
        return ret;

    }

    private String parse(byte option, String line) {
        String[] parts = line.split(",");
        

        if (option == 0) {
            return parts[0];
        }
        else if (option == 1) {
            return parts[1];
        }
        else if (option == 2) {
            return parts[2];
        }
        else if (option == 3) {
            return parts[3];
        }
        else if (option == 4) {
            return parts[4];
        }
        else if (option == 5) {
            return parts[5];
        }
        else if (option == 6) {
            return parts[6];
        }
        return "";
    }

    // search by specific parameter WORKING
    public String[] searchByName(String movieName) {
        String[] lines = fileRead();
        //String[] ret = new String[numOfLines]; 
        for (int x = 0; x < numOfLines; x++) {

            if (parse((byte) 0, lines[x]).contains(movieName)) {

            }
        }
        return lines;
    }

    public String[] searchByReleaseDate(String releaseDate) {
        String[] lines = fileRead();
        String[] ret = new String[numOfLines]; 
        for (int x = 0; x < numOfLines; x++) {

            if (parse((byte) 1, lines[x]).contains(releaseDate)) {
                ret[x] = parse((byte) 1, lines[x]);
            }
        }
        return ret;
    }

    public String[] searchByLocation(String location) {
        String[] lines = fileRead();
        String[] ret = new String[numOfLines]; 
        for (int x = 0; x < numOfLines; x++) {

            if (parse((byte) 2, lines[x]).contains(location)) {
                ret[x] = parse((byte) 2, lines[x]);
            }
        }
        return ret;
    }

    public String[] searchByGenre(String genre) {
        String[] lines = fileRead();
        String[] ret = new String[numOfLines]; 
        for (int x = 0; x < numOfLines; x++) {

            if (parse((byte) 3, lines[x]).contains(genre)) {
                ret[x] = parse((byte) 3, lines[x]);
            }
        }
        return ret;
    }

    public String[] searchByRating(String rating) {
        String[] lines = fileRead();
        String[] ret = new String[numOfLines]; 
        for (int x = 0; x < numOfLines; x++) {

            if (parse((byte) 4, lines[x]).contains(rating)) {
                ret[x] = parse((byte) 4, lines[x]);
            }
        }
        return ret;
    }

    // working
    public String[] searchByDuration(String duration) {
        String[] lines = fileRead();
        String[] ret = new String[numOfLines]; 
        for (int x = 0; x < numOfLines; x++) {

            if (parse((byte) 5, lines[x]).contains(duration)) {
                ret[x] = parse((byte) 5, lines[x]);
            }
        }
        return ret;
    }

    public String[] searchByPrice(String price) {
        return fileSearch((byte) 6, price);
    }

    // display list of movies WORKING
    public String[] displayMovieList() {
        String[] lines = fileRead();
        String[] ret = new String[numOfLines];
        //System.out.println(numOfLines); 
        for (int x = 0; x < numOfLines; x++) {
            ret[x] = parse((byte) 6, lines[x]);
        }
        return ret;
    }
} 