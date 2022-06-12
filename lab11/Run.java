package lab11;
import java.io.*;
import java.util.Scanner;

public class Run {
    private static Scanner input = new Scanner(System.in);
    public Run(){

    }

    public static void menu(){
        System.out.println("Menu");
        System.out.println("-------------------------------------------------");
        System.out.println("1. Add a list of Students and save to File");
        System.out.println("2. Loading list of Students from a File");
        System.out.println("3. Exit");
    }
    public static void main(String[] args) {


        menu();
        while (true){
            int choice;
            System.out.println("Your choice:");
            choice = input.nextInt();
            if (choice == 1){
                createFile();
                menu();
            } else if (choice == 2) {
                readFile();
                menu();
            } else if (choice == 3) {
                System.exit(0);
            }
        }

    }
    public static void createFile() {
        Scanner sc = new Scanner(System.in);
        long id = 0;
        String name;
        int age;
        double mark;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("student.txt"));
            System.out.println("Id: ");
            id = sc.nextLong();
            writer.write("Id: " + id);
            System.out.println("Name: ");
            name = sc.next();
            writer.write(" - Name: " + name);
            System.out.println("Age: ");
            age = sc.nextInt();
            writer.write(" - Age: " + age);
            System.out.println("Mark: ");
            mark = sc.nextDouble();
            writer.write(" - Mark: " + mark + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("student.txt"));
            String line;
            while ((line = reader.readLine()) !=null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
