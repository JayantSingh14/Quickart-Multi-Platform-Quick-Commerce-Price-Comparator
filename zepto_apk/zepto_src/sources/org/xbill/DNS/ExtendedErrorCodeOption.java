package org.xbill.DNS;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import lombok.Generated;

/* loaded from: classes5.dex */
public class ExtendedErrorCodeOption extends EDNSOption {
    public static final int BLOCKED = 15;
    public static final int CACHED_ERROR = 13;
    public static final int CENSORED = 16;
    public static final int DNSKEY_MISSING = 9;
    public static final int DNSSEC_BOGUS = 6;
    public static final int DNSSEC_INDETERMINATE = 5;
    public static final int FILTERED = 17;
    public static final int FORGED_ANSWER = 4;
    public static final int INVALID_DATA = 24;
    public static final int NETWORK_ERROR = 23;
    public static final int NOT_AUTHORITATIVE = 20;
    public static final int NOT_READY = 14;
    public static final int NOT_SUPPORTED = 21;
    public static final int NO_REACHABLE_AUTHORITY = 22;
    public static final int NO_ZONE_KEY_BIT_SET = 11;
    public static final int NSEC_MISSING = 12;
    public static final int OTHER = 0;
    public static final int PROHIBITED = 18;
    public static final int RRSIGS_MISSING = 10;
    public static final int SIGNATURE_EXPIRED = 7;
    public static final int SIGNATURE_EXPIRED_BEFORE_VALID = 25;
    public static final int SIGNATURE_NOT_YET_VALID = 8;
    public static final int STALE_ANSWER = 3;
    public static final int STALE_NXDOMAIN_ANSWER = 19;
    public static final int SYNTHESIZED = 29;
    public static final int TOO_EARLY = 26;
    public static final int UNABLE_TO_CONFORM_TO_POLICY = 28;
    public static final int UNSUPPORTED_DNSKEY_ALGORITHM = 1;
    public static final int UNSUPPORTED_DS_DIGEST_TYPE = 2;
    public static final int UNSUPPORTED_NSEC3_ITERATIONS_VALUE = 27;
    private static final Mnemonic codes;
    private int errorCode;
    private String text;

    static {
        Mnemonic mnemonic = new Mnemonic("EDNS Extended Error Codes", 1);
        codes = mnemonic;
        mnemonic.setMaximum(Message.MAXLENGTH);
        mnemonic.setPrefix("EDE");
        mnemonic.add(0, "OTHER");
        mnemonic.add(1, "UNSUPPORTED_DNSKEY_ALGORITHM");
        mnemonic.add(2, "UNSUPPORTED_DS_DIGEST_TYPE");
        mnemonic.add(3, "STALE_ANSWER");
        mnemonic.add(4, "FORGED_ANSWER");
        mnemonic.add(5, "DNSSEC_INDETERMINATE");
        mnemonic.add(6, "DNSSEC_BOGUS");
        mnemonic.add(7, "SIGNATURE_EXPIRED");
        mnemonic.add(8, "SIGNATURE_NOT_YET_VALID");
        mnemonic.add(9, "DNSKEY_MISSING");
        mnemonic.add(10, "RRSIGS_MISSING");
        mnemonic.add(11, "NO_ZONE_KEY_BIT_SET");
        mnemonic.add(12, "NSEC_MISSING");
        mnemonic.add(13, "CACHED_ERROR");
        mnemonic.add(14, "NOT_READY");
        mnemonic.add(15, "BLOCKED");
        mnemonic.add(16, "CENSORED");
        mnemonic.add(17, "FILTERED");
        mnemonic.add(18, "PROHIBITED");
        mnemonic.add(19, "STALE_NXDOMAIN_ANSWER");
        mnemonic.add(20, "NOT_AUTHORITATIVE");
        mnemonic.add(21, "NOT_SUPPORTED");
        mnemonic.add(22, "NO_REACHABLE_AUTHORITY");
        mnemonic.add(23, "NETWORK_ERROR");
        mnemonic.add(24, "INVALID_DATA");
        mnemonic.add(25, "SIGNATURE_EXPIRED_BEFORE_VALID");
        mnemonic.add(26, "TOO_EARLY");
        mnemonic.add(27, "UNSUPPORTED_NSEC3_ITERATIONS_VALUE");
        mnemonic.add(28, "UNABLE_TO_CONFORM_TO_POLICY");
        mnemonic.add(29, "SYNTHESIZED");
    }

    public ExtendedErrorCodeOption() {
        super(15);
    }

    public static int code(String str) {
        return codes.getValue(str);
    }

    public static String text(int i2) {
        return codes.getText(i2);
    }

    @Generated
    public int getErrorCode() {
        return this.errorCode;
    }

    @Generated
    public String getText() {
        return this.text;
    }

    @Override // org.xbill.DNS.EDNSOption
    public void optionFromWire(DNSInput dNSInput) throws IOException {
        this.errorCode = dNSInput.readU16();
        if (dNSInput.remaining() > 0) {
            byte[] byteArray = dNSInput.readByteArray();
            int length = byteArray.length;
            if (byteArray[byteArray.length - 1] == 0) {
                length--;
            }
            this.text = new String(byteArray, 0, length, StandardCharsets.UTF_8);
        }
    }

    @Override // org.xbill.DNS.EDNSOption
    public String optionToString() {
        if (this.text == null) {
            return codes.getText(this.errorCode);
        }
        return codes.getText(this.errorCode) + ": " + this.text;
    }

    @Override // org.xbill.DNS.EDNSOption
    public void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(this.errorCode);
        String str = this.text;
        if (str == null || str.isEmpty()) {
            return;
        }
        dNSOutput.writeByteArray(this.text.getBytes(StandardCharsets.UTF_8));
    }

    public ExtendedErrorCodeOption(int i2, String str) {
        super(15);
        this.errorCode = i2;
        this.text = str;
    }

    public ExtendedErrorCodeOption(int i2) {
        this(i2, null);
    }
}
