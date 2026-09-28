package org.xbill.DNS;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes5.dex */
public abstract class EDNSOption implements Serializable {
    private final int code;

    public static class Code {
        public static final int CHAIN = 13;
        public static final int CLIENT_SUBNET = 8;
        public static final int COOKIE = 10;
        public static final int DAU = 5;
        public static final int DHU = 6;
        public static final int EDNS_CLIENT_TAG = 16;
        public static final int EDNS_EXPIRE = 9;
        public static final int EDNS_EXTENDED_ERROR = 15;
        public static final int EDNS_KEY_TAG = 14;
        public static final int EDNS_SERVER_TAG = 17;
        public static final int LLQ = 1;
        public static final int N3U = 7;
        public static final int NSID = 3;
        public static final int PADDING = 12;
        public static final int REPORT_CHANNEL = 18;
        public static final int TCP_KEEPALIVE = 11;
        public static final int UL = 2;
        private static final Mnemonic codes;

        static {
            Mnemonic mnemonic = new Mnemonic("EDNS Option Codes", 1);
            codes = mnemonic;
            mnemonic.setMaximum(Message.MAXLENGTH);
            mnemonic.setPrefix("CODE");
            mnemonic.setNumericAllowed(true);
            mnemonic.add(1, "LLQ");
            mnemonic.add(2, "UL");
            mnemonic.add(3, "NSID");
            mnemonic.add(5, "DAU");
            mnemonic.add(6, "DHU");
            mnemonic.add(7, "N3U");
            mnemonic.add(8, "edns-client-subnet");
            mnemonic.add(9, "EDNS_EXPIRE");
            mnemonic.add(10, "COOKIE");
            mnemonic.add(11, "edns-tcp-keepalive");
            mnemonic.add(12, "Padding");
            mnemonic.add(13, "CHAIN");
            mnemonic.add(14, "edns-key-tag");
            mnemonic.add(15, "Extended_DNS_Error");
            mnemonic.add(16, "EDNS-Client-Tag");
            mnemonic.add(17, "EDNS-Server-Tag");
            mnemonic.add(18, "Report-Channel");
        }

        private Code() {
        }

        public static String string(int i2) {
            return codes.getText(i2);
        }

        public static int value(String str) {
            return codes.getValue(str);
        }
    }

    public EDNSOption(int i2) {
        this.code = Record.checkU16("code", i2);
    }

    public static EDNSOption fromWire(DNSInput dNSInput) throws IOException {
        int u16 = dNSInput.readU16();
        int u162 = dNSInput.readU16();
        if (dNSInput.remaining() < u162) {
            throw new WireParseException("truncated option");
        }
        int iSaveActive = dNSInput.saveActive();
        dNSInput.setActive(u162);
        EDNSOption dnssecAlgorithmOption = u16 != 3 ? u16 != 15 ? (u16 == 5 || u16 == 6 || u16 == 7) ? new DnssecAlgorithmOption(u16, new int[0]) : u16 != 8 ? u16 != 10 ? u16 != 11 ? new GenericEDNSOption(u16) : new TcpKeepaliveOption() : new CookieOption() : new ClientSubnetOption() : new ExtendedErrorCodeOption() : new NSIDOption();
        dnssecAlgorithmOption.optionFromWire(dNSInput);
        dNSInput.restoreActive(iSaveActive);
        return dnssecAlgorithmOption;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof EDNSOption)) {
            return false;
        }
        EDNSOption eDNSOption = (EDNSOption) obj;
        if (this.code != eDNSOption.code) {
            return false;
        }
        return Arrays.equals(getData(), eDNSOption.getData());
    }

    public int getCode() {
        return this.code;
    }

    public byte[] getData() {
        DNSOutput dNSOutput = new DNSOutput();
        optionToWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public int hashCode() {
        int i2 = 0;
        for (byte b2 : getData()) {
            i2 += (i2 << 3) + (b2 & 255);
        }
        return i2;
    }

    public abstract void optionFromWire(DNSInput dNSInput) throws IOException;

    public abstract String optionToString();

    public abstract void optionToWire(DNSOutput dNSOutput);

    public String toString() {
        return "{" + Code.string(this.code) + ": " + optionToString() + "}";
    }

    public void toWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(this.code);
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        optionToWire(dNSOutput);
        dNSOutput.writeU16At((dNSOutput.current() - iCurrent) - 2, iCurrent);
    }

    public byte[] toWire() {
        DNSOutput dNSOutput = new DNSOutput();
        toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public static EDNSOption fromWire(byte[] bArr) throws IOException {
        return fromWire(new DNSInput(bArr));
    }
}
