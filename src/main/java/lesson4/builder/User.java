package lesson4.builder;

public class User {

    private String name;
    private String address;
    private int age;
    private String email;

    private static Builder builder;

    private User() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String name;
        private String address;
        private int age;
        private String email;

        private Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            User u = new User();
            u.name = this.name;
            u.age = this.age;
            u.address = this.address;
            u.email= this.email;
            return u;
        }
    }
}