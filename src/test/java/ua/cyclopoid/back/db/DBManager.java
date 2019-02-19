package ua.cyclopoid.back.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.cyclopoid.back.db.api.DataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class DBManager {

    private static final String DB_DIR = new File("db").getAbsolutePath() + "/";

    private final static Logger LOGGER = LoggerFactory.getLogger(DBManager.class);

    public static boolean restoreDB(DataSource dataSource, String fileName) {
        try {
            Process runtimeProcess = Runtime.getRuntime().exec(DB_DIR + fileName + ".sh");
            int processComplete = runtimeProcess.waitFor();
            int returnValue = runtimeProcess.exitValue();
            LOGGER.debug("returnValue = " + returnValue);

            String s = null;
            if (processComplete == 0) {
                LOGGER.debug("Backup has been restored successfully");
                BufferedReader inputStreamReader = new BufferedReader(new InputStreamReader(runtimeProcess.getInputStream()));
                while ((s = inputStreamReader.readLine()) != null) {
                    System.out.println(s);
                }
                return true;
            } else {
                LOGGER.error("Could not restore the backup");
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
