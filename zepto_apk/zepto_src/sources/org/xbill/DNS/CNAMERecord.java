package org.xbill.DNS;

/* loaded from: classes5.dex */
public class CNAMERecord extends SingleCompressedNameBase {
    public CNAMERecord() {
    }

    @Deprecated
    public Name getAlias() {
        return getName();
    }

    public Name getTarget() {
        return getSingleName();
    }

    public CNAMERecord(Name name, int i2, long j2, Name name2) {
        super(name, 5, i2, j2, name2, "target");
    }
}
