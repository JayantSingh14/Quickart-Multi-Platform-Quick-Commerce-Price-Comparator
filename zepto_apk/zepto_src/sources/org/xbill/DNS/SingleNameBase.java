package org.xbill.DNS;

import java.io.IOException;

/* loaded from: classes5.dex */
abstract class SingleNameBase extends Record {
    protected Name singleName;

    public SingleNameBase() {
    }

    public Name getSingleName() {
        return this.singleName;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.singleName = tokenizer.getName(name);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.singleName = new Name(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return this.singleName.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.singleName.toWire(dNSOutput, null, z);
    }

    public SingleNameBase(Name name, int i2, int i3, long j2) {
        super(name, i2, i3, j2);
    }

    public SingleNameBase(Name name, int i2, int i3, long j2, Name name2, String str) {
        super(name, i2, i3, j2);
        this.singleName = Record.checkName(str, name2);
    }
}
