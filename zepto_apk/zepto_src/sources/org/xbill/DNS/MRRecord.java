package org.xbill.DNS;

/* loaded from: classes5.dex */
public class MRRecord extends SingleNameBase {
    public MRRecord() {
    }

    public Name getNewName() {
        return getSingleName();
    }

    public MRRecord(Name name, int i2, long j2, Name name2) {
        super(name, 9, i2, j2, name2, "new name");
    }
}
