package icc.stud.kotov_av.grep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {
    ArrayList<String> lines;

    public FileHandler(ArgumentsHolder ah) {

    }

    public void print() {
        for (String line : lines) {
            System.out.print(line);
        }
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    private void execute(ArgumentsHolder ah) {
        try(BufferedReader br = new BufferedReader(new FileReader(ah.inputFile)))
        {
            //чтение построчно
            String line;
            while((line=br.readLine())!=null){
                lines.add(line);
            }
        }
        catch(IOException ex){       
            System.out.println(ex.getMessage());
        }
    }
}