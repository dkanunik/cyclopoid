package ua.cyclopoid.back.db.api;

public interface DataSource {

    String getUrl();

    String getUserName();

    String getPassword();

    String getDbName();
}
