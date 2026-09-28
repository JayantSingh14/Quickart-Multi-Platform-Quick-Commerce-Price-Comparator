package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhfa {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f33696a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f33697b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f33698c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f33699d;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        f33696a = new zzhjj(zzhbt.class, zzhez.f33689a);
        f33697b = new zzhjg(zzhxcVarA, zzhew.f33686a);
        f33698c = new zzhie(zzhbl.class, zzhex.f33687a);
        f33699d = new zzhib(zzhxcVarA, zzhey.f33688a);
    }

    public static zzhpw a(zzhbs zzhbsVar) throws GeneralSecurityException {
        if (zzhbs.f33479b.equals(zzhbsVar)) {
            return zzhpw.TINK;
        }
        if (zzhbs.f33480c.equals(zzhbsVar)) {
            return zzhpw.CRUNCHY;
        }
        if (zzhbs.f33481d.equals(zzhbsVar)) {
            return zzhpw.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzhbsVar)));
    }

    public static zzhbs b(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhbs.f33479b;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhbs.f33481d;
            }
            if (iOrdinal != 4) {
                int iZza = zzhpwVar.zza();
                throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
            }
        }
        return zzhbs.f33480c;
    }

    public static zzhbr c(zzhor zzhorVar) throws GeneralSecurityException {
        int iOrdinal = zzhorVar.ordinal();
        if (iOrdinal == 1) {
            return zzhbr.f33473b;
        }
        if (iOrdinal == 2) {
            return zzhbr.f33476e;
        }
        if (iOrdinal == 3) {
            return zzhbr.f33475d;
        }
        if (iOrdinal == 4) {
            return zzhbr.f33477f;
        }
        if (iOrdinal == 5) {
            return zzhbr.f33474c;
        }
        int iZza = zzhorVar.zza();
        throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 26), iZza, "Unable to parse HashType: "));
    }

    public static zzhox d(zzhbt zzhbtVar) {
        zzhor zzhorVar;
        zzhow zzhowVarE = zzhox.E();
        int i2 = zzhbtVar.f33486d;
        zzhowVarE.j();
        ((zzhox) zzhowVarE.f34638b).H(i2);
        zzhbr zzhbrVar = zzhbr.f33473b;
        zzhbr zzhbrVar2 = zzhbtVar.f33488f;
        if (zzhbrVar.equals(zzhbrVar2)) {
            zzhorVar = zzhor.SHA1;
        } else if (zzhbr.f33474c.equals(zzhbrVar2)) {
            zzhorVar = zzhor.SHA224;
        } else if (zzhbr.f33475d.equals(zzhbrVar2)) {
            zzhorVar = zzhor.SHA256;
        } else if (zzhbr.f33476e.equals(zzhbrVar2)) {
            zzhorVar = zzhor.SHA384;
        } else {
            if (!zzhbr.f33477f.equals(zzhbrVar2)) {
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(zzhbrVar2)));
            }
            zzhorVar = zzhor.SHA512;
        }
        zzhowVarE.j();
        ((zzhox) zzhowVarE.f34638b).G(zzhorVar);
        return (zzhox) zzhowVarE.l();
    }
}
