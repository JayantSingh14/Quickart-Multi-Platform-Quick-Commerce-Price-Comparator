package org.xbill.DNS;

/* loaded from: classes5.dex */
public class DNAMERecord extends SingleNameBase {
    public DNAMERecord() {
    }

    @Deprecated
    public Name getAlias() {
        return getName();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public DNAMERecord(Name name, int i2, long j2, Name name2) {
        super(name, 39, i2, j2, name2, "alias");
    }
}
