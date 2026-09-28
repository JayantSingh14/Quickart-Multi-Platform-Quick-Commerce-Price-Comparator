package org.xbill.DNS;

import java.io.IOException;

/* loaded from: classes5.dex */
public class NULLRecord extends Record {
    private byte[] data;

    public NULLRecord() {
    }

    public byte[] getData() {
        return this.data;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        throw tokenizer.exception("no defined text format for NULL records");
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return Record.unknownToString(this.data);
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.data);
    }

    public NULLRecord(Name name, int i2, long j2, byte[] bArr) {
        super(name, 10, i2, j2);
        if (bArr.length > 65535) {
            throw new IllegalArgumentException("data must be <65536 bytes");
        }
        this.data = bArr;
    }
}
