package org.xbill.DNS;

import lombok.Generated;

/* loaded from: classes5.dex */
enum SetResponseType {
    UNKNOWN(false, true),
    NXDOMAIN(false, true),
    NXRRSET(false, true),
    DELEGATION(true, false),
    CNAME(true, false),
    DNAME(true, false),
    SUCCESSFUL(false, false);

    private final boolean isSealed;
    private final boolean printRecords;

    @Generated
    SetResponseType(boolean z, boolean z2) {
        this.printRecords = z;
        this.isSealed = z2;
    }

    @Generated
    public boolean isPrintRecords() {
        return this.printRecords;
    }

    @Generated
    public boolean isSealed() {
        return this.isSealed;
    }
}
