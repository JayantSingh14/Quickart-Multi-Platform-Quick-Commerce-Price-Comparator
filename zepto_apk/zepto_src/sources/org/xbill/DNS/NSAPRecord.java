package org.xbill.DNS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.xbill.DNS.utils.base16;

/* loaded from: classes5.dex */
public class NSAPRecord extends Record {
    private byte[] address;

    public NSAPRecord() {
    }

    private static byte[] checkAndConvertAddress(String str) {
        if (!str.substring(0, 2).equalsIgnoreCase("0x")) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = false;
        int i2 = 0;
        for (int i3 = 2; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '.') {
                int iDigit = Character.digit(cCharAt, 16);
                if (iDigit == -1) {
                    return null;
                }
                if (z) {
                    i2 += iDigit;
                    byteArrayOutputStream.write(i2);
                    z = false;
                } else {
                    i2 = iDigit << 4;
                    z = true;
                }
            }
        }
        if (z) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String getAddress() {
        return Record.byteArrayToString(this.address, false);
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String string = tokenizer.getString();
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(string);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress != null) {
            return;
        }
        throw tokenizer.exception("invalid NSAP address " + string);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.address = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return "0x" + base16.toString(this.address);
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.address);
    }

    public NSAPRecord(Name name, int i2, long j2, String str) {
        super(name, 22, i2, j2);
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(str);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress == null) {
            throw new IllegalArgumentException(android.support.v4.media.b.C("invalid NSAP address ", str));
        }
    }
}
