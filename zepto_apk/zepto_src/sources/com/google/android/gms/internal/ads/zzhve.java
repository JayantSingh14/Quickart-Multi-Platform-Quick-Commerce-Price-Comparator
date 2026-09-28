package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public final class zzhve {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f34365a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f34366b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f34367c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f34368d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzhig f34369e;

    /* renamed from: f, reason: collision with root package name */
    public static final zzhid f34370f;

    /* renamed from: g, reason: collision with root package name */
    public static final zzhhs f34371g;

    /* renamed from: h, reason: collision with root package name */
    public static final zzhhs f34372h;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey");
        zzhxc zzhxcVarA2 = zzhkl.a("type.googleapis.com/google.crypto.tink.RsaSsaPssPublicKey");
        f34365a = new zzhjj(zzhti.class, zzhvd.f34364a);
        f34366b = new zzhjg(zzhxcVarA, zzhuy.f34357a);
        f34367c = new zzhie(zzhtm.class, zzhuz.f34358a);
        f34368d = new zzhib(zzhxcVarA2, zzhva.f34361a);
        f34369e = new zzhie(zzhtk.class, zzhvb.f34362a);
        f34370f = new zzhib(zzhxcVarA, zzhvc.f34363a);
        zzhhr zzhhrVar = new zzhhr();
        zzhhrVar.a(zzhpw.RAW, zzhth.f34243e);
        zzhhrVar.a(zzhpw.TINK, zzhth.f34240b);
        zzhhrVar.a(zzhpw.CRUNCHY, zzhth.f34241c);
        zzhhrVar.a(zzhpw.LEGACY, zzhth.f34242d);
        f34371g = zzhhrVar.b();
        zzhhr zzhhrVar2 = new zzhhr();
        zzhhrVar2.a(zzhor.SHA256, zzhtg.f34236b);
        zzhhrVar2.a(zzhor.SHA384, zzhtg.f34237c);
        zzhhrVar2.a(zzhor.SHA512, zzhtg.f34238d);
        f34372h = zzhhrVar2.b();
    }

    public static zzhqk a(zzhti zzhtiVar) {
        zzhqj zzhqjVarF = zzhqk.F();
        zzhtg zzhtgVar = zzhtiVar.f34249d;
        zzhhs zzhhsVar = f34372h;
        zzhor zzhorVar = (zzhor) zzhhsVar.a(zzhtgVar);
        zzhqjVarF.j();
        ((zzhqk) zzhqjVarF.f34638b).H(zzhorVar);
        zzhor zzhorVar2 = (zzhor) zzhhsVar.a(zzhtiVar.f34250e);
        zzhqjVarF.j();
        ((zzhqk) zzhqjVarF.f34638b).I(zzhorVar2);
        zzhqjVarF.j();
        ((zzhqk) zzhqjVarF.f34638b).J(zzhtiVar.f34251f);
        return (zzhqk) zzhqjVarF.l();
    }

    public static zzhqo b(zzhtm zzhtmVar) {
        zzhqn zzhqnVarH = zzhqo.H();
        zzhqk zzhqkVarA = a(zzhtmVar.f34269a);
        zzhqnVarH.j();
        ((zzhqo) zzhqnVarH.f34638b).L(zzhqkVarA);
        byte[] bArrA = zzhhe.a(zzhtmVar.f34270b);
        zzhzl zzhzlVar = zzhzl.f34557b;
        zzhzl zzhzlVarV = zzhzl.v(0, bArrA, bArrA.length);
        zzhqnVarH.j();
        ((zzhqo) zzhqnVarH.f34638b).M(zzhzlVarV);
        byte[] bArrA2 = zzhhe.a(zzhtmVar.f34269a.f34247b);
        zzhzl zzhzlVarV2 = zzhzl.v(0, bArrA2, bArrA2.length);
        zzhqnVarH.j();
        ((zzhqo) zzhqnVarH.f34638b).N(zzhzlVarV2);
        zzhqnVarH.j();
        ((zzhqo) zzhqnVarH.f34638b).K(0);
        return (zzhqo) zzhqnVarH.l();
    }

    public static zzhxd c(zzhzl zzhzlVar) {
        return new zzhxd(new BigInteger(1, zzhzlVar.z()));
    }
}
