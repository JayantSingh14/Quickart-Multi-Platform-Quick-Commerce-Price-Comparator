package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhfz {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33743a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33744b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33745c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33746d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        f33743a = new zzhjj(zzhcz.class, zzhfy.f33742a);
        f33744b = new zzhjg(zzhxcVarA, zzhfv.f33739a);
        f33745c = new zzhie(zzhcu.class, zzhfw.f33740a);
        f33746d = new zzhib(zzhxcVarA, zzhfx.f33741a);
    }

    public static zzhpw a(zzhcy zzhcyVar) throws GeneralSecurityException {
        if (zzhcy.f33569b.equals(zzhcyVar)) {
            return zzhpw.TINK;
        }
        if (zzhcy.f33570c.equals(zzhcyVar)) {
            return zzhpw.CRUNCHY;
        }
        if (zzhcy.f33571d.equals(zzhcyVar)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhcyVar.f33572a));
    }

    public static zzhcy b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhcy.f33569b;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhcy.f33571d;
            }
            if (iOrdinal != 4) {
                int iZza = zzhpwVar.zza();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
            }
        }
        return zzhcy.f33570c;
    }
}
