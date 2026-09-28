package org.xbill.DNS;

/* loaded from: classes5.dex */
public class MGRecord extends SingleNameBase {
    public MGRecord() {
    }

    public Name getMailbox() {
        return getSingleName();
    }

    public MGRecord(Name name, int i2, long j2, Name name2) {
        super(name, 8, i2, j2, name2, "mailbox");
    }
}
