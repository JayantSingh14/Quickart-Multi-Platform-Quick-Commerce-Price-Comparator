package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final class zzhdo {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33600a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33601b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33602c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33603d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        f33600a = new zzhjj(zzhdj.class, zzhdn.f33599a);
        f33601b = new zzhjg(zzhxcVarA, zzhdk.f33596a);
        f33602c = new zzhie(zzhdh.class, zzhdl.f33597a);
        f33603d = new zzhib(zzhxcVarA, zzhdm.f33598a);
    }

    public static zzhpw a(zzhdi zzhdiVar) throws GeneralSecurityException {
        if (zzhdi.f33591b.equals(zzhdiVar)) {
            return zzhpw.TINK;
        }
        if (zzhdi.f33592c.equals(zzhdiVar)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhdiVar.f33593a));
    }

    public static zzhdi b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhdi.f33591b;
        }
        if (iOrdinal == 3) {
            return zzhdi.f33592c;
        }
        int iZza = zzhpwVar.zza();
        throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
    }
}
