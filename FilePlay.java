package app;

import java.io.*;

/**
 * File play class with a method to copy files.
 * FileReader and FileWriter classes used from the Java IO.
 * 
 * @author Nathan Kennedy
 */
public class FilePlay {

	public FilePlay() {
	    // default constructor
	}

    /**
     * Copies the contents of one file to another.
     * 
     * @param inFile  in source file.
     * @param outFile out destination file.
     * @return 0 if the file was copied successfully,
     *         -1 if FileNotFoundException,
     *         -2 if IOException error.
     */
    private static int copyFile(String inFile, String outFile) {
        FileReader in = null;
        FileWriter out = null;
        

        try {
            in = new FileReader(inFile);
            out = new FileWriter(outFile);

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

            in.close();
            out.close();
            return 0;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -2;
        }
    }
    /**
     * main method for the FilePlay class.
     * Calls the copyFile method to copy the content of one file to another 
     * and prints out the result to the console.
     **/
    public static void main(String[] args) {
        int err = FilePlay.copyFile("InUsers.txt", "OutUsers.txt");
        switch (err) {
            case 0:
                System.out.println("File was copied successfully.");
                break;
            case -1:
                System.err.println("File could not be opened.");
                break;
            case -2:
                System.err.println("File I/O error.");
                break;
        }
    }
}
