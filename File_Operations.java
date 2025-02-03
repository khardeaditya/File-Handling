import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_Operations {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int value;
        String name = "";

        do {
            System.out.println("\nEnter Your Choice");
            System.out.println("1. Create a File");
            System.out.println("2. Write to a File");
            System.out.println("3. Read a File");
            System.out.println("4. Modify the File");
            System.out.println("5. Exit\n");
            value = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            switch (value) {

                case 1: // Create a File
                    System.out.println("Enter the name of the file (with extension):");
                    name = sc.nextLine();
                    try {
                        File fs = new File(name);
                        if (fs.createNewFile()) {
                            System.out.println("File created successfully: " + name);
                        } else {
                            System.out.println("File already exists: " + name);
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while creating the file: " + e.getMessage());
                    }
                    break;

                case 2: // Write to a File
                    if (name.isEmpty()) {
                        System.out.println("No file specified. Please create a file first (Option 1).");
                        break;
                    }
                    File fileToWrite = new File(name);
                    if (fileToWrite.exists()) {
                        try (FileWriter fw = new FileWriter(fileToWrite)) {
                            System.out.println("Enter text to write into the file:");
                            String text = sc.nextLine();
                            fw.write(text);
                            System.out.println("Text has been successfully written to the file.");
                        } catch (IOException e) {
                            System.out.println("An error occurred while writing to the file: " + e.getMessage());
                        }
                    } else {
                        System.out.println("File not found: " + name);
                    }
                    break;

                case 3: // Read a File
                    if (name.isEmpty()) {
                        System.out.println("No file specified. Please create a file first (Option 1).");
                        break;
                    }
                    try (Scanner scFile = new Scanner(new File(name))) {
                        System.out.println("Contents of the file " + name + ":");
                        while (scFile.hasNextLine()) {
                            System.out.println(scFile.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + name);
                    }
                    break;

                case 4: // Modify a File
                    if (name.isEmpty()) {
                        System.out.println("No file specified. Please create a file first (Option 1).");
                        break;
                    }
                    File fileToModify = new File(name);
                    if (fileToModify.exists()) {
                        System.out.println("Do you want to overwrite (1) or append (2) text to the file?");
                        int choice = sc.nextInt();
                        sc.nextLine(); // Consume leftover newline

                        if (choice == 1) {
                            try (FileWriter fw = new FileWriter(fileToModify)) {
                                System.out.println("Enter new text to overwrite the file:");
                                String text = sc.nextLine();
                                fw.write(text);
                                System.out.println("File overwritten successfully.");
                            } catch (IOException e) {
                                System.out.println("An error occurred while overwriting the file: " + e.getMessage());
                            }
                        } else if (choice == 2) {
                            try (FileWriter fw = new FileWriter(fileToModify, true)) {
                                System.out.println("Enter text to append to the file:");
                                String text = sc.nextLine();
                                fw.write("\n" + text);
                                System.out.println("Text appended successfully.");
                            } catch (IOException e) {
                                System.out.println("An error occurred while appending to the file: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Invalid choice. Please select 1 to overwrite or 2 to append.");
                        }
                    } else {
                        System.out.println("File not found: " + name);
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting the program.");
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid choice.");
                    break;
            }
        } while (value != 5);

        sc.close();
    }
}