package org.xbill.DNS;

/* loaded from: classes5.dex */
class EmptyRecord extends Record {
    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) {
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) {
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        return "";
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
    }
}
