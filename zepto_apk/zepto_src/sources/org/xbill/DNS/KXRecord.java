package org.xbill.DNS;

/* loaded from: classes5.dex */
public class KXRecord extends U16NameBase {
    public KXRecord() {
    }

    @Override // org.xbill.DNS.Record
    public Name getAdditionalName() {
        return getNameField();
    }

    public int getPreference() {
        return getU16Field();
    }

    public Name getTarget() {
        return getNameField();
    }

    public KXRecord(Name name, int i2, long j2, int i3, Name name2) {
        super(name, 36, i2, j2, i3, "preference", name2, "target");
    }
}
