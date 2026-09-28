package org.xbill.DNS.dnssec;

import java.util.List;
import lombok.Generated;
import org.xbill.DNS.Name;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;

/* loaded from: classes5.dex */
class SRRset extends RRset {
    private Name ownerName;
    private SecurityStatus securityStatus;

    public SRRset() {
        this.securityStatus = SecurityStatus.UNCHECKED;
    }

    @Override // org.xbill.DNS.RRset
    @Generated
    public boolean canEqual(Object obj) {
        return obj instanceof SRRset;
    }

    @Override // org.xbill.DNS.RRset
    @Generated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SRRset)) {
            return false;
        }
        SRRset sRRset = (SRRset) obj;
        if (!sRRset.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        SecurityStatus securityStatus = getSecurityStatus();
        SecurityStatus securityStatus2 = sRRset.getSecurityStatus();
        if (securityStatus != null ? !securityStatus.equals(securityStatus2) : securityStatus2 != null) {
            return false;
        }
        Name name = this.ownerName;
        Name name2 = sRRset.ownerName;
        return name != null ? name.equals(name2) : name2 == null;
    }

    @Override // org.xbill.DNS.RRset
    public Name getName() {
        Name name = this.ownerName;
        return name == null ? super.getName() : name;
    }

    public SecurityStatus getSecurityStatus() {
        return this.securityStatus;
    }

    public Name getSignerName() {
        List<RRSIGRecord> listSigs = sigs();
        if (listSigs.isEmpty()) {
            return null;
        }
        return listSigs.get(0).getSigner();
    }

    @Override // org.xbill.DNS.RRset
    @Generated
    public int hashCode() {
        int iHashCode = super.hashCode();
        SecurityStatus securityStatus = getSecurityStatus();
        int iHashCode2 = (iHashCode * 59) + (securityStatus == null ? 43 : securityStatus.hashCode());
        Name name = this.ownerName;
        return (iHashCode2 * 59) + (name != null ? name.hashCode() : 43);
    }

    public void setName(Name name) {
        this.ownerName = name;
    }

    public void setSecurityStatus(SecurityStatus securityStatus) {
        this.securityStatus = securityStatus;
    }

    public SRRset(Record record) {
        super(record);
        this.securityStatus = SecurityStatus.UNCHECKED;
    }

    public SRRset(RRset rRset) {
        super(rRset);
        this.securityStatus = SecurityStatus.UNCHECKED;
    }

    public SRRset(SRRset sRRset) {
        super((RRset) sRRset);
        this.securityStatus = sRRset.securityStatus;
        this.ownerName = sRRset.ownerName;
    }
}
