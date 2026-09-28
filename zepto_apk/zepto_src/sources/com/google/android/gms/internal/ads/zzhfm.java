package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhfm {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33713a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33714b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33715c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33716d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.AesGcmKey");
        f33713a = new zzhjj(zzhck.class, zzhfl.f33712a);
        f33714b = new zzhjg(zzhxcVarA, zzhfi.f33709a);
        f33715c = new zzhie(zzhcd.class, zzhfj.f33710a);
        f33716d = new zzhib(zzhxcVarA, zzhfk.f33711a);
    }

    public static zzhpw a(zzhcj zzhcjVar) throws GeneralSecurityException {
        if (zzhcj.f33532b.equals(zzhcjVar)) {
            return zzhpw.TINK;
        }
        if (zzhcj.f33533c.equals(zzhcjVar)) {
            return zzhpw.CRUNCHY;
        }
        if (zzhcj.f33534d.equals(zzhcjVar)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhcjVar)));
    }

    public static zzhcj b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhcj.f33532b;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhcj.f33534d;
            }
            if (iOrdinal != 4) {
                int iZza = zzhpwVar.zza();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
            }
        }
        return zzhcj.f33533c;
    }
}
