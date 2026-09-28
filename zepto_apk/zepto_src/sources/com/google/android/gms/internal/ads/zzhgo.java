package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzhgo {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33763a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33764b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33765c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33766d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.XAesGcmKey");
        f33763a = new zzhjj(zzheo.class, zzhgn.f33762a);
        f33764b = new zzhjg(zzhxcVarA, zzhgk.f33759a);
        f33765c = new zzhie(zzhej.class, zzhgl.f33760a);
        f33766d = new zzhib(zzhxcVarA, zzhgm.f33761a);
    }

    public static zzhpw a(zzhen zzhenVar) throws GeneralSecurityException {
        if (Objects.equals(zzhenVar, zzhen.f33665b)) {
            return zzhpw.TINK;
        }
        if (Objects.equals(zzhenVar, zzhen.f33666c)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhenVar.f33667a));
    }

    public static zzhen b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhen.f33665b;
        }
        if (iOrdinal == 3) {
            return zzhen.f33666c;
        }
        int iZza = zzhpwVar.zza();
        throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
    }
}
