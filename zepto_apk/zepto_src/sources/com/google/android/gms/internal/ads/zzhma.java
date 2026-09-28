package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhma {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f34020a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f34021b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f34022c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f34023d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.AesCmacKey");
        f34020a = new zzhjj(zzhku.class, zzhlz.f34010a);
        f34021b = new zzhjg(zzhxcVarA, zzhlw.f34007a);
        f34022c = new zzhie(zzhkn.class, zzhlx.f34008a);
        f34023d = new zzhib(zzhxcVarA, zzhly.f34009a);
    }

    public static zzhpw a(zzhkt zzhktVar) throws GeneralSecurityException {
        if (zzhkt.f33950b.equals(zzhktVar)) {
            return zzhpw.TINK;
        }
        if (zzhkt.f33951c.equals(zzhktVar)) {
            return zzhpw.CRUNCHY;
        }
        if (zzhkt.f33953e.equals(zzhktVar)) {
            return zzhpw.RAW;
        }
        if (zzhkt.f33952d.equals(zzhktVar)) {
            return zzhpw.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhktVar)));
    }

    public static zzhkt b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhkt.f33950b;
        }
        if (iOrdinal == 2) {
            return zzhkt.f33952d;
        }
        if (iOrdinal == 3) {
            return zzhkt.f33953e;
        }
        if (iOrdinal == 4) {
            return zzhkt.f33951c;
        }
        int iZza = zzhpwVar.zza();
        throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
    }
}
