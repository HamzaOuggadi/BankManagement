package ma.atos.ma.atos.bankmanagement.enums;

public enum SensOperation {
    CREDIT(1, "CREDIT"),
    DEBIT(2, "DEBIT");
    int code;
    String value;

    SensOperation(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
