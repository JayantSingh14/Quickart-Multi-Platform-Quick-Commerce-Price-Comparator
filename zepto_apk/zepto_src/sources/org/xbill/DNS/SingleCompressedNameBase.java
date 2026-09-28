package org.xbill.DNS;

/* loaded from: classes5.dex */
abstract class SingleCompressedNameBase extends SingleNameBase {
    public SingleCompressedNameBase() {
    }

    @Override // org.xbill.DNS.SingleNameBase, org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        this.singleName.toWire(dNSOutput, compression, z);
    }

    public SingleCompressedNameBase(Name name, int i2, int i3, long j2, Name name2, String str) {
        super(name, i2, i3, j2, name2, str);
    }
}
