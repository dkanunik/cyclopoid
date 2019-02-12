package ua.cyclopoid.back.db;

import org.springframework.core.io.ClassPathResource;
import ua.cyclopoid.back.db.api.DataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class DBManager {

    public static boolean restoreDB(DataSource dataSource, String fileName) {
        try {
            File file = new ClassPathResource(fileName).getFile();

            String[] executeCmd = new String[]{
                    "mysql"
                    , "--user=" + dataSource.getUserName()
                    , "--password=" + dataSource.getPassword()
                    , dataSource.getDbName()
                    , " source " + file.getAbsolutePath()
            };

            String cmd = "docker exec -i cyclopoid-db ls -al";
            //String cmd = "docker exec cyclopoid-db /usr/bin/mysql -u root --password=root cyclopoid < " + file.getAbsolutePath();
           // String cmd = "cat " + file.getAbsolutePath();


            System.out.println("cmd = " + cmd);
            //System.out.println(Arrays.toString(executeCmd));

            Process runtimeProcess = Runtime.getRuntime().exec(cmd);
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
