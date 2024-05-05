package cyclopoid.db;

import java.io.File;
import java.io.IOException;

public class DBManager {

    private static final String DB_DIR = new File("cyclopoid/db").getAbsolutePath() + "/";

    private static final String SH_FILE_NAME = "restore.sh";

    public static void restoreDB() {
        try {
            Runtime.getRuntime().exec(DB_DIR + SH_FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
