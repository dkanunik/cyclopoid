package cyclopoid.config;

public class HostConfig {
    private static HostConfig ourInstance = new HostConfig();

    public static HostConfig getInstance() {
        return ourInstance;
    }

    private HostConfig() {
    }

    public String getBackHost() {
        return System.getenv("BACK_HOST");
    }

    public String getBackPort() {
        return System.getenv("BACK_PORT");
    }

    public String getBackURL() {
        return "http://" + getBackHost() + ":" + getBackPort();
    }
}
