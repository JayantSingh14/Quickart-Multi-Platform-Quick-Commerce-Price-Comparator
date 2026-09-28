package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhqz {

    /* renamed from: a, reason: collision with root package name */
    public zzhrc f34074a = null;

    /* renamed from: b, reason: collision with root package name */
    public zzhra f34075b = null;

    /* renamed from: c, reason: collision with root package name */
    public zzhrb f34076c = null;

    /* renamed from: d, reason: collision with root package name */
    public zzhrd f34077d = zzhrd.f34093e;

    public final zzhre a() throws GeneralSecurityException {
        zzhrc zzhrcVar = this.f34074a;
        if (zzhrcVar == null) {
            throw new GeneralSecurityException("signature encoding is not set");
        }
        zzhra zzhraVar = this.f34075b;
        if (zzhraVar == null) {
            throw new GeneralSecurityException("EC curve type is not set");
        }
        zzhrb zzhrbVar = this.f34076c;
        if (zzhrbVar == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        zzhrd zzhrdVar = this.f34077d;
        if (zzhraVar == zzhra.f34078c && zzhrbVar != zzhrb.f34083b) {
            throw new GeneralSecurityException("NIST_P256 requires SHA256");
        }
        zzhra zzhraVar2 = zzhra.f34079d;
        zzhrb zzhrbVar2 = zzhrb.f34085d;
        if (zzhraVar == zzhraVar2 && zzhrbVar != zzhrb.f34084c && zzhrbVar != zzhrbVar2) {
            throw new GeneralSecurityException("NIST_P384 requires SHA384 or SHA512");
        }
        if (zzhraVar != zzhra.f34080e || zzhrbVar == zzhrbVar2) {
            return new zzhre(zzhrcVar, zzhraVar, zzhrbVar, zzhrdVar);
        }
        throw new GeneralSecurityException("NIST_P521 requires SHA512");
    }
}
