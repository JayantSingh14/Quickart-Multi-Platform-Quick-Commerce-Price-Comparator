package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* loaded from: classes4.dex */
public final class zzhub {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f34288a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f34289b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f34290c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f34291d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzhig f34292e;

    /* renamed from: f, reason: collision with root package name */
    public static final zzhid f34293f;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey");
        zzhxc zzhxcVarA2 = zzhkl.a("type.googleapis.com/google.crypto.tink.EcdsaPublicKey");
        f34288a = new zzhjj(zzhre.class, zzhua.f34287a);
        f34289b = new zzhjg(zzhxcVarA, zzhtv.f34282a);
        f34290c = new zzhie(zzhri.class, zzhtw.f34283a);
        f34291d = new zzhib(zzhxcVarA2, zzhtx.f34284a);
        f34292e = new zzhie(zzhrg.class, zzhty.f34285a);
        f34293f = new zzhib(zzhxcVarA, zzhtz.f34286a);
    }

    public static zzhpw a(zzhrd zzhrdVar) throws GeneralSecurityException {
        if (zzhrd.f34090b.equals(zzhrdVar)) {
            return zzhpw.TINK;
        }
        if (zzhrd.f34091c.equals(zzhrdVar)) {
            return zzhpw.CRUNCHY;
        }
        if (zzhrd.f34093e.equals(zzhrdVar)) {
            return zzhpw.RAW;
        }
        if (zzhrd.f34092d.equals(zzhrdVar)) {
            return zzhpw.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhrdVar.f34094a));
    }

    public static zzhrb b(zzhor zzhorVar) throws GeneralSecurityException {
        int iOrdinal = zzhorVar.ordinal();
        if (iOrdinal == 2) {
            return zzhrb.f34084c;
        }
        if (iOrdinal == 3) {
            return zzhrb.f34083b;
        }
        if (iOrdinal == 4) {
            return zzhrb.f34085d;
        }
        int iZza = zzhorVar.zza();
        throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 26), iZza, "Unable to parse HashType: "));
    }

    public static zzhrd c(zzhpw zzhpwVar) throws GeneralSecurityException {
        int iOrdinal = zzhpwVar.ordinal();
        if (iOrdinal == 1) {
            return zzhrd.f34090b;
        }
        if (iOrdinal == 2) {
            return zzhrd.f34092d;
        }
        if (iOrdinal == 3) {
            return zzhrd.f34093e;
        }
        if (iOrdinal == 4) {
            return zzhrd.f34091c;
        }
        int iZza = zzhpwVar.zza();
        throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iZza).length() + 34), iZza, "Unable to parse OutputPrefixType: "));
    }

    public static int d(zzhra zzhraVar) {
        if (zzhra.f34078c.equals(zzhraVar)) {
            return 33;
        }
        if (zzhra.f34079d.equals(zzhraVar)) {
            return 49;
        }
        if (zzhra.f34080e.equals(zzhraVar)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType ".concat(zzhraVar.f34081a));
    }

    public static zzhoe e(zzhre zzhreVar) {
        zzhor zzhorVar;
        int i2;
        zzhod zzhodVarD = zzhoe.D();
        zzhrb zzhrbVar = zzhreVar.f34097c;
        if (zzhrb.f34083b.equals(zzhrbVar)) {
            zzhorVar = zzhor.SHA256;
        } else if (zzhrb.f34084c.equals(zzhrbVar)) {
            zzhorVar = zzhor.SHA384;
        } else {
            if (!zzhrb.f34085d.equals(zzhrbVar)) {
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(zzhrbVar.f34086a));
            }
            zzhorVar = zzhor.SHA512;
        }
        zzhodVarD.j();
        ((zzhoe) zzhodVarD.f34638b).F(zzhorVar);
        zzhra zzhraVar = zzhra.f34078c;
        zzhra zzhraVar2 = zzhreVar.f34096b;
        int i3 = 4;
        if (zzhraVar.equals(zzhraVar2)) {
            i2 = 4;
        } else if (zzhra.f34079d.equals(zzhraVar2)) {
            i2 = 5;
        } else {
            if (!zzhra.f34080e.equals(zzhraVar2)) {
                throw new GeneralSecurityException("Unable to serialize CurveType ".concat(zzhraVar2.f34081a));
            }
            i2 = 6;
        }
        zzhodVarD.j();
        ((zzhoe) zzhodVarD.f34638b).I(i2);
        zzhrc zzhrcVar = zzhrc.f34087b;
        zzhrc zzhrcVar2 = zzhreVar.f34095a;
        if (zzhrcVar.equals(zzhrcVar2)) {
            i3 = 3;
        } else if (!zzhrc.f34088c.equals(zzhrcVar2)) {
            throw new GeneralSecurityException("Unable to serialize SignatureEncoding ".concat(zzhrcVar2.f34089a));
        }
        zzhodVarD.j();
        ((zzhoe) zzhodVarD.f34638b).J(i3);
        return (zzhoe) zzhodVarD.l();
    }

    public static zzhoi f(zzhri zzhriVar) {
        int iD = d(zzhriVar.f34106a.f34096b);
        zzhoh zzhohVarH = zzhoi.H();
        zzhoe zzhoeVarE = e(zzhriVar.f34106a);
        zzhohVarH.j();
        ((zzhoi) zzhohVarH.f34638b).K(zzhoeVarE);
        ECPoint eCPoint = zzhriVar.f34107b;
        byte[] bArrB = zzhhe.b(eCPoint.getAffineX(), iD);
        zzhzl zzhzlVar = zzhzl.f34557b;
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhohVarH.j();
        ((zzhoi) zzhohVarH.f34638b).L(zzhzlVarV);
        byte[] bArrB2 = zzhhe.b(eCPoint.getAffineY(), iD);
        zzhzl zzhzlVarV2 = zzhzl.v(0, bArrB2, bArrB2.length);
        zzhohVarH.j();
        ((zzhoi) zzhohVarH.f34638b).M(zzhzlVarV2);
        return (zzhoi) zzhohVarH.l();
    }

    public static zzhra g(int i2) throws GeneralSecurityException {
        int i3 = i2 - 2;
        if (i3 == 2) {
            return zzhra.f34078c;
        }
        if (i3 == 3) {
            return zzhra.f34079d;
        }
        if (i3 == 4) {
            return zzhra.f34080e;
        }
        if (i2 != 1) {
            throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i3).length() + 35), i3, "Unable to parse EllipticCurveType: "));
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzhrc h(int i2) throws GeneralSecurityException {
        int i3 = i2 - 2;
        if (i3 == 1) {
            return zzhrc.f34087b;
        }
        if (i3 == 2) {
            return zzhrc.f34088c;
        }
        if (i2 != 1) {
            throw new GeneralSecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i3).length() + 40), i3, "Unable to parse EcdsaSignatureEncoding: "));
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
