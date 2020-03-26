package wdym;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import javax.swing.JFrame;

public class WDYM {

    public static void main(String[] args) throws IOException {
        
        MemoryLS memoryLS = new MemoryLS("./MemoryLS.txt");
        memoryLS.read();
        MemoryDD memoryDD = new MemoryDD("./MemoryDD.txt");
        memoryDD.read();
        MemoryGZIP memoryGZIP = new MemoryGZIP("./MemoryGZIP.txt");
        memoryGZIP.read();
        
        Scanner sc = new Scanner(System.in);
        
        String input;
        do {
            System.out.print("> ");
            input = sc.next();
            
            // ls
            Pattern patternLS = Pattern.compile("[lopñkji][sqwerdfxcza]");
            Matcher matcherLS = patternLS.matcher(input);
            boolean bLS = matcherLS.matches();
            if (bLS) {
                if (input.equals("ls") || remembers(memoryLS.memory, input)) {
                    // System.out.println("Ingresó exactamente ls o recordó un comando");
                    ls();
                    // continue;
                } else {
                    System.out.print("Did you mean \"ls\"? [Y/n]: ");
                    char answer = sc.next().charAt(0);
                    if (answer == 'Y') {
                        memoryLS.addToMemory(input);
                        memoryLS.write();
                        ls();
                        // continue;
                    }
                }
            }
            
            // dd
            Pattern patternDD = Pattern.compile("[dwertfgcvxzsa][dwertfgcvxzsa]");
            Matcher matcherDD = patternDD.matcher(input);
            boolean bDD = matcherDD.matches();
            if (bDD) {
                if (input.equals("dd") || remembers(memoryDD.memory, input)) {
                    // System.out.println("Ingresó exactamente dd o recordó un comando");
                    dd();
                    // continue;
                } else {
                    System.out.print("Did you mean \"dd\"? [Y/n]: ");
                    char answer = sc.next().charAt(0);
                    if (answer == 'Y') {
                        memoryDD.addToMemory(input);
                        memoryDD.write();
                        dd();
                        // continue;
                    }
                }
            }
            
            // gzip
            Pattern patternGZIP = Pattern.compile("[gtryuhjbnvcfd][zaqswdxc][iuyopkljhmn][poilkñ]");
            Matcher matcherGZIP = patternGZIP.matcher(input);
            boolean bGZIP = matcherGZIP.matches();
            if (bGZIP) {
                if (input.equals("gzip") || remembers(memoryGZIP.memory, input)) {
                    // System.out.println("Ingresó exactamente gzip o recordó un comando");
                    gzip();
                } else {
                    System.out.print("Did you mean \"gzip\"? [Y/n]: ");
                    char answer = sc.next().charAt(0);
                    if (answer == 'Y') {
                        memoryGZIP.addToMemory(input);
                        memoryGZIP.write();
                        gzip();
                    }
                }
            }
        } while (true);
        
    }
    
    public static boolean remembers(ArrayList<String> memory, String input) {
        boolean retVal = false;
        for (String command : memory) {
            if (input.equals(command)) {
                retVal = true;
                break;
            }
        }
        return retVal;
    }
    
    public static void ls() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type a word: ");
        String palabra = sc.next();
        System.out.print("Type another word: ");
        String palabra2 = sc.next();
        String nueva_palabra = "";
        if (palabra2.length() == palabra.length()) { // validación
            for (int i = 0; i < palabra.length(); i++) {
                char p = palabra.charAt(i); // char de palabra
                char q = palabra2.charAt(i); // char de palabra2 
                nueva_palabra += p + "" + q; // concatena los chars
            }
            System.out.println("The new word is: " + nueva_palabra);
        } else {
            System.out.println("Both words need to be the same size.");
        }
    }
    
    public static void dd() {
        Scanner sc = new Scanner(System.in);
        int intentos = 3;
        int num = (int) (Math.random() * 10) + 1;
        int numeroingresado;
        while (intentos > 0) {
            System.out.print("Type a number: ");
            numeroingresado = sc.nextInt();
            if (numeroingresado == num) {
                System.out.println("Congratulations! You guessed the number." + " [" + numeroingresado + "]");
                break;
            }
            else {
              System.out.println("Nope...");
            }
            intentos--;
            if (intentos == 0)
                System.out.println("You lost! The number was " + num + ".");
        }
    }
    
    public static void gzip() {
        MetodoFace panel = new MetodoFace(); 
        JFrame aplicacion = new JFrame();
        // aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacion.add(panel); 
        aplicacion.setSize(230, 250);
        aplicacion.setLocationRelativeTo(null);
        aplicacion.setVisible(true);
    }
    
}
