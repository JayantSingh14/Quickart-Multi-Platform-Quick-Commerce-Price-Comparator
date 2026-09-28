package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhgu {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33774a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33775b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33776c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33777d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        f33774a = new zzhjj(zzhev.class, zzhgt.f33773a);
        f33775b = new zzhjg(zzhxcVarA, zzhgq.f33770a);
        f33776c = new zzhie(zzhep.class, zzhgr.f33771a);
        f33777d = new zzhib(zzhxcVarA, zzhgs.f33772a);
    }

    public static zzhpw a(zzheu zzheuVar) throws GeneralSecurityException {
        if (zzheu.f33681b.equals(zzheuVar)) {
            return zzhpw.TINK;
        }
        if (zzheu.f33682c.equals(zzheuVar)) {
            return zzhpw.CRUNCHY;
        }
        if (zzheu.f33683d.equals(zzheuVar)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzheuVar.f33684a));
    }

    public static zzheu b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzheu.f33681b;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzheu.f33683d;
            }
            if (iOrdinal != 4) {
                int iZza = zzhpwVar.zza();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
            }
        }
        return zzheu.f33682c;
    }
}
