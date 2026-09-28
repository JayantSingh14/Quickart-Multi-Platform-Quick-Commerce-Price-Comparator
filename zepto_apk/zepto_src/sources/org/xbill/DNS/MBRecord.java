package org.xbill.DNS;

/* loaded from: classes5.dex */
public class MBRecord extends SingleNameBase {
    public MBRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getSingleName();
    }

    public Name getMailbox() {
        return getSingleName();
    }

    public MBRecord(Name name, int i2, long j2, Name name2) {
        super(name, 7, i2, j2, name2, "mailbox");
    }
}
