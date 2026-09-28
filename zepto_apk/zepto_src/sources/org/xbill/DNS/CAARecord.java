package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class CAARecord extends Record {
    private int flags;
    private byte[] tag;
    private byte[] value;

    public static class Flags {
        public static final int IssuerCritical = 128;

        private Flags() {
        }
    }

    public CAARecord() {
    }

    public int getFlags() {
        return this.flags;
    }

    public String getTag() {
        return Record.byteArrayToString(this.tag, false);
    }

    public String getValue() {
        return Record.byteArrayToString(this.value, false);
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.flags = tokenizer.getUInt8();
        try {
            this.tag = Record.byteArrayFromString(tokenizer.getString());
            this.value = Record.byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e2) {
            throw tokenizer.exception(e2.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.flags = dNSInput.readU8();
        this.tag = dNSInput.readCountedString();
        this.value = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return this.flags + StringUtils.SPACE + Record.byteArrayToString(this.tag, false) + StringUtils.SPACE + Record.byteArrayToString(this.value, true);
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.flags);
        dNSOutput.writeCountedString(this.tag);
        dNSOutput.writeByteArray(this.value);
    }

    public CAARecord(Name name, int i2, long j2, int i3, String str, String str2) {
        super(name, Type.CAA, i2, j2);
        this.flags = Record.checkU8("flags", i3);
        try {
            this.tag = Record.byteArrayFromString(str);
            this.value = Record.byteArrayFromString(str2);
        } catch (TextParseException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }
}
