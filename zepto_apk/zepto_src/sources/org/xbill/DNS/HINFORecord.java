package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class HINFORecord extends Record {
    private byte[] cpu;
    private byte[] os;

    public HINFORecord() {
    }

    public String getCPU() {
        return Record.byteArrayToString(this.cpu, false);
    }

    public String getOS() {
        return Record.byteArrayToString(this.os, false);
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        try {
            this.cpu = Record.byteArrayFromString(tokenizer.getString());
            this.os = Record.byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e2) {
            throw tokenizer.exception(e2.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.cpu = dNSInput.readCountedString();
        this.os = dNSInput.readCountedString();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return Record.byteArrayToString(this.cpu, true) + StringUtils.SPACE + Record.byteArrayToString(this.os, true);
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeCountedString(this.cpu);
        dNSOutput.writeCountedString(this.os);
    }

    public HINFORecord(Name name, int i2, long j2, String str, String str2) {
        super(name, 13, i2, j2);
        try {
            this.cpu = Record.byteArrayFromString(str);
            this.os = Record.byteArrayFromString(str2);
        } catch (TextParseException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }
}
