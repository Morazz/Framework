package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_EMAIL = "test.data.user.email";
    public static final String TESTDATA_USER_PASSWORD = "test.data.user.password";

    public User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL), TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public  User withEmptyEmail() {
        return new User("", TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }

    public  User withEmptyPassword() {
        return new User(TestDataReader.getTestData(TESTDATA_USER_EMAIL), "");
    }
}
