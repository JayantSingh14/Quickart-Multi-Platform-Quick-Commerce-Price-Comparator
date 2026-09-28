package org.xbill.DNS;

import java.io.IOException;

/* loaded from: classes5.dex */
public class X25Record extends Record {
    private byte[] address;

    public X25Record() {
    }

    private static byte[] checkAndConvertAddress(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (!Character.isDigit(cCharAt)) {
                return null;
            }
            bArr[i2] = (byte) cCharAt;
        }
        return bArr;
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
        throw tokenizer.exception("invalid PSDN address " + string);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.address = dNSInput.readCountedString();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return Record.byteArrayToString(this.address, true);
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.address);
    }

    public X25Record(Name name, int i2, long j2, String str) {
        super(name, 19, i2, j2);
        byte[] bArrCheckAndConvertAddress = checkAndConvertAddress(str);
        this.address = bArrCheckAndConvertAddress;
        if (bArrCheckAndConvertAddress == null) {
            throw new IllegalArgumentException(android.support.v4.media.b.C("invalid PSDN address ", str));
        }
    }
}
