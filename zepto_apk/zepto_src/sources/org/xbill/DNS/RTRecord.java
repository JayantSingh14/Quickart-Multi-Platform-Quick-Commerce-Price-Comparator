package org.xbill.DNS;

/* loaded from: classes5.dex */
public class RTRecord extends U16NameBase {
    public RTRecord() {
    }

    public Name getIntermediateHost() {
        return getNameField();
    }

    public int getPreference() {
        return getU16Field();
    }

    public RTRecord(Name name, int i2, long j2, int i3, Name name2) {
        super(name, 21, i2, j2, i3, "preference", name2, "intermediateHost");
    }
}
