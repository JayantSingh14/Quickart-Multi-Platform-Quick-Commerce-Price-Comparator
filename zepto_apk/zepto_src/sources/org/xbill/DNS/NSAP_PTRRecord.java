package org.xbill.DNS;

/* loaded from: classes5.dex */
public class NSAP_PTRRecord extends SingleNameBase {
    public NSAP_PTRRecord() {
    }

    public Name getTarget() {
        return getSingleName();
    }

    public NSAP_PTRRecord(Name name, int i2, long j2, Name name2) {
        super(name, 23, i2, j2, name2, "target");
    }
}
