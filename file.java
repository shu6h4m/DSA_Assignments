import java.io.File;

public class file {
    public static void main(String[] args) {
        File f = null;
        String fName, fPath , location ;
        long lastModified , size;
        
        try {
            // create new files
            f = new File("D:\\newFile.txt");
            // get file name 
            fName = f.getName();
            // get the path of file
            fPath = f.getPath();
            // get last modified time
            lastModified = f.lastModified();
            // get size of file
            size = f.length();
            // get absolute path
            location = f.getAbsolutePath();

            // set permisssion
            f.setExecutable(true);
            f.setReadable(true);
            
            // if file exists
            if(f.createNewFile()) {
            
                // prints
                
                System.out.println("File is created\n");
                System.out.println("File name: "+ fName);
                System.out.println("File Path: "+ fPath);
                System.out.println("Last Modified: "+ lastModified);
                System.out.println("Size of file: " + size );
                System.out.println("Location of File: "+ location);

                //check permission
                System.out.println("Check permission");
                System.out.println("Executable: " + f.canExecute());
                System.out.println("Readable: " + f.canRead());

                f.delete();
                System.out.println("File is deleted");

            }     
            
            
        } catch(Exception e) {
            // if any error occurs
            e.printStackTrace();
        }
    }   
}
