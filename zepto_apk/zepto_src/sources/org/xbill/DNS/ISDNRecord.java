package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes5.dex */
public class ISDNRecord extends Record {
    private byte[] address;
    private byte[] subAddress;

    public ISDNRecord() {
    }

    public String getAddress() {
        return Record.byteArrayToString(this.address, false);
    }

    public String getSubAddress() {
        byte[] bArr = this.subAddress;
        if (bArr == null) {
            return null;
        }
        return Record.byteArrayToString(bArr, false);
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        try {
            this.address = Record.byteArrayFromString(tokenizer.getString());
            Tokenizer.Token token = tokenizer.get();
            if (token.isString()) {
                this.subAddress = Record.byteArrayFromString(token.value());
            } else {
                tokenizer.unget();
            }
        } catch (TextParseException e2) {
            throw tokenizer.exception(e2.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.address = dNSInput.readCountedString();
        if (dNSInput.remaining() > 0) {
            this.subAddress = dNSInput.readCountedString();
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Record.byteArrayToString(this.address, true));
        if (this.subAddress != null) {
            sb.append(StringUtils.SPACE);
            sb.append(Record.byteArrayToString(this.subAddress, true));
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.address);
        byte[] bArr = this.subAddress;
        if (bArr != null) {
            dNSOutput.writeCountedString(bArr);
        }
    }

    public ISDNRecord(Name name, int i2, long j2, String str, String str2) {
        super(name, 20, i2, j2);
        try {
            this.address = Record.byteArrayFromString(str);
            if (str2 != null) {
                this.subAddress = Record.byteArrayFromString(str2);
            }
        } catch (TextParseException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }
}
