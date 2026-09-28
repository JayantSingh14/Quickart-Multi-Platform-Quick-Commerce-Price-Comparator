package org.xbill.DNS;

import java.io.IOException;

/* loaded from: classes5.dex */
public class NSECRecord extends Record {
    private Name next;
    private TypeBitmap types;

    public NSECRecord() {
    }

    public Name getNext() {
        return this.next;
    }

    public int[] getTypes() {
        return this.types.toArray();
    }

    public boolean hasType(int i2) {
        return this.types.contains(i2);
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.next = tokenizer.getName(name);
        this.types = new TypeBitmap(tokenizer);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.next = new Name(dNSInput);
        this.types = new TypeBitmap(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.next);
        if (!this.types.empty()) {
            sb.append(' ');
            sb.append(this.types.toString());
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.next.toWire(dNSOutput, null, false);
        this.types.toWire(dNSOutput);
    }

    public NSECRecord(Name name, int i2, long j2, Name name2, int[] iArr) {
        super(name, 47, i2, j2);
        this.next = Record.checkName("next", name2);
        for (int i3 : iArr) {
            Type.check(i3);
        }
        this.types = new TypeBitmap(iArr);
    }
}
