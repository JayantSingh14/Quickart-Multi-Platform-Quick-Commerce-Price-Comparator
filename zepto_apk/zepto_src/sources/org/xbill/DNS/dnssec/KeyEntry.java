package org.xbill.DNS.dnssec;

import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.DClass;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

/* loaded from: classes5.dex */
final class KeyEntry extends SRRset {

    @Generated
    private static final Logger log = LoggerFactory.b(KeyEntry.class);
    private final List<Integer> algo;
    private String badReason;
    private int edeReason;
    private boolean isEmpty;

    private KeyEntry(SRRset sRRset) {
        this(sRRset, null);
    }

    public static KeyEntry newBadKeyEntry(Name name, int i2, long j2) {
        return new KeyEntry(name, i2, j2, true);
    }

    public static KeyEntry newKeyEntry(SRRset sRRset) {
        return new KeyEntry(sRRset);
    }

    public static KeyEntry newNullKeyEntry(Name name, int i2, long j2) {
        return new KeyEntry(name, i2, j2, false);
    }

    @Override // org.xbill.DNS.dnssec.SRRset, org.xbill.DNS.RRset
    @Generated
    public boolean canEqual(Object obj) {
        return obj instanceof KeyEntry;
    }

    @Override // org.xbill.DNS.dnssec.SRRset, org.xbill.DNS.RRset
    @Generated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeyEntry)) {
            return false;
        }
        KeyEntry keyEntry = (KeyEntry) obj;
        if (!keyEntry.canEqual(this) || !super.equals(obj) || this.edeReason != keyEntry.edeReason || this.isEmpty != keyEntry.isEmpty) {
            return false;
        }
        String str = this.badReason;
        String str2 = keyEntry.badReason;
        return str != null ? str.equals(str2) : str2 == null;
    }

    @Generated
    public List<Integer> getAlgo() {
        return this.algo;
    }

    @Override // org.xbill.DNS.dnssec.SRRset, org.xbill.DNS.RRset
    @Generated
    public int hashCode() {
        int iHashCode = (((super.hashCode() * 59) + this.edeReason) * 59) + (this.isEmpty ? 79 : 97);
        String str = this.badReason;
        return (iHashCode * 59) + (str == null ? 43 : str.hashCode());
    }

    public boolean isBad() {
        return this.isEmpty && getSecurityStatus() == SecurityStatus.BOGUS;
    }

    public boolean isGood() {
        return !this.isEmpty && getSecurityStatus() == SecurityStatus.SECURE;
    }

    public boolean isNull() {
        return this.isEmpty && getSecurityStatus() == SecurityStatus.UNCHECKED;
    }

    public void setBadReason(int i2, String str) {
        this.edeReason = i2;
        this.badReason = str;
    }

    public JustifiedSecStatus validateKeyFor(SRRset sRRset) {
        if (sRRset.getSignerName() != null) {
            if (isBad()) {
                return new JustifiedSecStatus(SecurityStatus.BOGUS, this.edeReason, R.get("validate.bogus.badkey", getName(), this.badReason));
            }
            if (!isNull()) {
                return null;
            }
            String str = this.badReason;
            if (str == null) {
                str = R.get("validate.insecure", new Object[0]);
            }
            return new JustifiedSecStatus(SecurityStatus.INSECURE, this.edeReason, str);
        }
        if (sRRset.getType() == 5 && sRRset.getSecurityStatus() == SecurityStatus.SECURE) {
            return new JustifiedSecStatus(sRRset.getSecurityStatus(), -1, null);
        }
        log.g("No signerName for <{}/{}/{}>", sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()));
        if (!isNull()) {
            return isGood() ? new JustifiedSecStatus(SecurityStatus.BOGUS, 10, R.get("validate.bogus.missingsig", new Object[0])) : new JustifiedSecStatus(SecurityStatus.BOGUS, this.edeReason, R.get("validate.bogus", this.badReason));
        }
        String str2 = this.badReason;
        if (str2 == null) {
            str2 = R.get("validate.insecure_unsigned", new Object[0]);
        }
        return new JustifiedSecStatus(SecurityStatus.INSECURE, this.edeReason, str2);
    }

    private KeyEntry(SRRset sRRset, List<Integer> list) {
        super(sRRset);
        this.edeReason = -1;
        this.algo = list;
    }

    public static KeyEntry newKeyEntry(SRRset sRRset, List<Integer> list) {
        return new KeyEntry(sRRset, list);
    }

    private KeyEntry(Name name, int i2, long j2, boolean z) {
        super(new SRRset(Record.newRecord(name, 48, i2, j2)));
        this.edeReason = -1;
        this.isEmpty = true;
        this.algo = null;
        if (z) {
            setSecurityStatus(SecurityStatus.BOGUS);
        }
    }
}
