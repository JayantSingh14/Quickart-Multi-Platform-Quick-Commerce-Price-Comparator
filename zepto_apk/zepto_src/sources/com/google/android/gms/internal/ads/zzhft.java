package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhft {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33729a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33730b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33731c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33732d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        f33729a = new zzhjj(zzhct.class, zzhfs.f33728a);
        f33730b = new zzhjg(zzhxcVarA, zzhfp.f33725a);
        f33731c = new zzhie(zzhcm.class, zzhfq.f33726a);
        f33732d = new zzhib(zzhxcVarA, zzhfr.f33727a);
    }

    public static zzhpw a(zzhcs zzhcsVar) throws GeneralSecurityException {
        if (zzhcs.f33554b.equals(zzhcsVar)) {
            return zzhpw.TINK;
        }
        if (zzhcs.f33555c.equals(zzhcsVar)) {
            return zzhpw.CRUNCHY;
        }
        if (zzhcs.f33556d.equals(zzhcsVar)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhcsVar)));
    }

    public static zzhcs b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhcs.f33554b;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhcs.f33556d;
            }
            if (iOrdinal != 4) {
                int iZza = zzhpwVar.zza();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
            }
        }
        return zzhcs.f33555c;
    }
}
