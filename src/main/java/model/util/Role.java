package model.util;

public enum Role {
    ADMIN("admin"),
    MANAGER("manager"),
    GUEST("guest");

    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
