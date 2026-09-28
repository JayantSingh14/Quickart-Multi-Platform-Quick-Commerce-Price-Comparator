package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public class URIRecord extends Record {
    private int priority;
    private byte[] target;
    private int weight;

    public URIRecord() {
        this.target = new byte[0];
    }

    public int getPriority() {
        return this.priority;
    }

    public String getTarget() {
        return Record.byteArrayToString(this.target, false);
    }

    public int getWeight() {
        return this.weight;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.priority = tokenizer.getUInt16();
        this.weight = tokenizer.getUInt16();
        try {
            this.target = Record.byteArrayFromString(tokenizer.getString());
        } catch (TextParseException e2) {
            throw tokenizer.exception(e2.getMessage());
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.priority = dNSInput.readU16();
        this.weight = dNSInput.readU16();
        this.target = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return this.priority + StringUtils.SPACE + this.weight + StringUtils.SPACE + Record.byteArrayToString(this.target, true);
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.priority);
        dNSOutput.writeU16(this.weight);
        dNSOutput.writeByteArray(this.target);
    }

    public URIRecord(Name name, int i2, long j2, int i3, int i4, String str) {
        super(name, 256, i2, j2);
        this.priority = Record.checkU16("priority", i3);
        this.weight = Record.checkU16("weight", i4);
        try {
            this.target = Record.byteArrayFromString(str);
        } catch (TextParseException e2) {
            throw new IllegalArgumentException(e2.getMessage());
        }
    }
}
