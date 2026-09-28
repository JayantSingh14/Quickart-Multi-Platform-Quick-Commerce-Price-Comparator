package org.xbill.DNS;

/* loaded from: classes5.dex */
public class MDRecord extends SingleNameBase {
    public MDRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }

    public Name getMailAgent() {
        return getSingleName();
    }

    public MDRecord(Name name, int i2, long j2, Name name2) {
        super(name, 3, i2, j2, name2, "mail agent");
    }
}
