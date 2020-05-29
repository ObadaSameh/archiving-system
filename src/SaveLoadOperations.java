
import archive_sys_project.entities.Archive;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sameh
 */
public class SaveLoadOperations {

    public static boolean saveArchive(File f, Archive archive) {
        StringBuffer strb = new StringBuffer();
        
       
        writeStringToFile(f, strb.toString());
        return true;
    }

    public static boolean loaddArchive(File f) {

    }
    

    private static void writeStringToFile(File f, String str) {

        try {

            FileWriter fw = new FileWriter(f);
            fw.write(str);
            fw.close();

        } catch (IOException iox) {
            throw new RuntimeException(iox);
        }

    }

}
