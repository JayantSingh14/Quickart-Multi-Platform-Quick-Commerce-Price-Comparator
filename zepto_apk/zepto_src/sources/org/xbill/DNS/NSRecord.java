package org.xbill.DNS;

/* loaded from: classes5.dex */
public class NSRecord extends SingleCompressedNameBase {
    public NSRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public NSRecord(Name name, int i2, long j2, Name name2) {
        super(name, 2, i2, j2, name2, "target");
    }
}
