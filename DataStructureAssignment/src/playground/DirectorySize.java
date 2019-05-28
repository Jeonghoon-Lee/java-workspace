package playground;

import java.io.File;
import java.util.Scanner;

public class DirectorySize {
    public static long getSize(File file) {
        long size = 0;

        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            for (int i=0; i<fileList.length; i++) {
                size += getSize(fileList[i]);
            }
        } else {
            size += file.length();
        }

        return size;
    }

    public static void main(String[] args) {
        // Prompt the user to enter a directory or a file
        System.out.print("Enter a directory or a file: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine();

        // Display the size
        System.out.println(getSize(new File(directory)) + " bytes");
    }
}
