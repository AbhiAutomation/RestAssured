package com.blackrock.qa.api_automation.utils;

public class LoginRequest {
    private User user;

    public LoginRequest() {}

    public LoginRequest(String email, String password) {
        this.user = new User(email, password);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class User {
        private String email;
        private String password;

        public User() {}

        public User(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
