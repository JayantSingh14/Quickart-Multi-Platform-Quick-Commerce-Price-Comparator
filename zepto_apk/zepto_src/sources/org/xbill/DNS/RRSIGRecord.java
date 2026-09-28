package org.xbill.DNS;

import j$.time.Instant;
import j$.util.DateRetargetClass;
import java.util.Date;

/* loaded from: classes5.dex */
public class RRSIGRecord extends SIGBase {
    public RRSIGRecord() {
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ Instant getExpire() {
        return super.getExpire();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ int getLabels() {
        return super.getLabels();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ long getOrigTTL() {
        return super.getOrigTTL();
    }

    @Override // org.xbill.DNS.SIGBase, org.xbill.DNS.Record
    public /* bridge */ /* synthetic */ int getRRsetType() {
        return super.getRRsetType();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ byte[] getSignature() {
        return super.getSignature();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ Name getSigner() {
        return super.getSigner();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ Instant getTimeSigned() {
        return super.getTimeSigned();
    }

    @Override // org.xbill.DNS.SIGBase
    public /* bridge */ /* synthetic */ int getTypeCovered() {
        return super.getTypeCovered();
    }

    public RRSIGRecord(Name name, int i2, long j2, int i3, int i4, long j3, Instant instant, Instant instant2, int i5, Name name2, byte[] bArr) {
        super(name, 46, i2, j2, i3, i4, j3, instant, instant2, i5, name2, bArr);
    }

    @Deprecated
    public RRSIGRecord(Name name, int i2, long j2, int i3, int i4, long j3, Date date, Date date2, int i5, Name name2, byte[] bArr) {
        super(name, 46, i2, j2, i3, i4, j3, DateRetargetClass.toInstant(date), DateRetargetClass.toInstant(date2), i5, name2, bArr);
    }
}
