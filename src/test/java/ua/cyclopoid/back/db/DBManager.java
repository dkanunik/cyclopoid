package ua.cyclopoid.back.db;

import ua.cyclopoid.back.db.api.DataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class DBManager {

    public static final String DB_DIR = new File("db").getAbsolutePath() + "/";

    public static boolean restoreDB(DataSource dataSource, String fileName) {
        try {
            Process runtimeProcess = Runtime.getRuntime().exec(DB_DIR + fileName + ".sh");
            int processComplete = runtimeProcess.waitFor();
            int returnValue = runtimeProcess.exitValue();

            System.out.println("returnValue = " + returnValue);
            String s = null;
            //todo: to use logger
            if (processComplete == 0) {
                System.out.println("Backup restored successfully");
                BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(runtimeProcess.getInputStream()));
                while ((s = inputStreamReader.readLine()) != null) {
                    System.out.println(s);
                }
                return true;
            } else {
                System.out.println("Could not restore the backup");
                BufferedReader errorStreamReader = new BufferedReader(new InputStreamReader(runtimeProcess.getErrorStream()));
                while ((s = errorStreamReader.readLine()) != null) {
                    System.out.println(s);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }
}
