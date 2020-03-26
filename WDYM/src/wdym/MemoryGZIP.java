package wdym;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoryGZIP {

    public ArrayList<String> memory = new ArrayList();
    private File file = null;

    public MemoryGZIP(String path) {
        file = new File(path);
    }
    
    public void addToMemory(String command) {
        memory.add(command);
    }
    
    public void write() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (String command : memory)
                bw.write(command + ";");
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }
    
    public void read() {
        Scanner sc = null;
        memory = new ArrayList();
        if (file.exists()) {
            try {
                sc = new Scanner(file);
                sc.useDelimiter(";");
                while(sc.hasNext())
                    memory.add(sc.next());
            } catch (Exception e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
    
}
