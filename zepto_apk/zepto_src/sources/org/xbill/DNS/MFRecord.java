package org.xbill.DNS;

/* loaded from: classes5.dex */
public class MFRecord extends SingleNameBase {
    public MFRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }

    public Name getMailAgent() {
        return getSingleName();
    }

    public MFRecord(Name name, int i2, long j2, Name name2) {
        super(name, 4, i2, j2, name2, "mail agent");
    }
}
