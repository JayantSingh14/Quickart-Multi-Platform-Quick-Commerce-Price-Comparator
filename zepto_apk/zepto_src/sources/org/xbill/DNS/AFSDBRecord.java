package org.xbill.DNS;

import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes5.dex */
public class AFSDBRecord extends U16NameBase {
    public AFSDBRecord() {
    }

    public Name getHost() {
        return getNameField();
    }

    public int getSubtype() {
        return getU16Field();
    }

    public AFSDBRecord(Name name, int i2, long j2, int i3, Name name2) {
        super(name, 18, i2, j2, i3, CLConstants.FIELD_SUBTYPE, name2, "host");
    }
}
