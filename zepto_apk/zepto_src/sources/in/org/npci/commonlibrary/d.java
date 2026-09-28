package in.org.npci.commonlibrary;

import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public enum d {
    KEY_CODE_EMPTY(DateUtils.SEMI_MONTH, "Your organization key is empty. Please provide a organization key."),
    KEY_CODE_INVALID(1002, "Your organization key is invalid. Please contact your system administrator or UPI support team."),
    PUBLICKEY_NOT_FOUND(1003, "Public key file not found please contact your system administrator UPI support team"),
    PARSER_MISCONFIG(1004, "XML Parser configuration error.Keys.xml may not be formatted correctly."),
    XML_PATH_ERROR(1005, "XML File is not found or cannot be read."),
    KEYS_NOT_VALID(1006, "Keys are not valid. Please contact your system administrator UPI support team"),
    UNKNOWN_ERROR(1007, "Unknown error occurred."),
    TRUST_NOT_VALID(1008, "Trust is not valid");


    /* renamed from: i, reason: collision with root package name */
    private final int f49200i;

    /* renamed from: j, reason: collision with root package name */
    private final String f49201j;

    d(int i2, String str) {
        this.f49200i = i2;
        this.f49201j = str;
    }

    public String a() {
        return this.f49201j;
    }

    public int b() {
        return this.f49200i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f49200i + ": " + this.f49201j;
    }
}
