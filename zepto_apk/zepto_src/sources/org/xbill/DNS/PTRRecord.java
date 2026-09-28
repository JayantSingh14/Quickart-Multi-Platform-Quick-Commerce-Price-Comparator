package org.xbill.DNS;

/* loaded from: classes5.dex */
public class PTRRecord extends SingleCompressedNameBase {
    public PTRRecord() {
    }

    public Name getTarget() {
        return getSingleName();
    }

    public PTRRecord(Name name, int i2, long j2, Name name2) {
        super(name, 12, i2, j2, name2, "target");
    }
}
