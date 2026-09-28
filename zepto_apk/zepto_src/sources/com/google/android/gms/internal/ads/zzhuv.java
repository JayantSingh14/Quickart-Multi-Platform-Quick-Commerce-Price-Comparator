package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public final class zzhuv {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f34333a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f34334b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f34335c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f34336d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzhig f34337e;

    /* renamed from: f, reason: collision with root package name */
    public static final zzhid f34338f;

    /* renamed from: g, reason: collision with root package name */
    public static final zzhhs f34339g;

    /* renamed from: h, reason: collision with root package name */
    public static final zzhhs f34340h;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey");
        zzhxc zzhxcVarA2 = zzhkl.a("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey");
        f34333a = new zzhjj(zzhsw.class, zzhuu.f34332a);
        f34334b = new zzhjg(zzhxcVarA, zzhup.f34327a);
        f34335c = new zzhie(zzhta.class, zzhuq.f34328a);
        f34336d = new zzhib(zzhxcVarA2, zzhur.f34329a);
        f34337e = new zzhie(zzhsy.class, zzhus.f34330a);
        f34338f = new zzhib(zzhxcVarA, zzhut.f34331a);
        zzhhr zzhhrVar = new zzhhr();
        zzhhrVar.a(zzhpw.RAW, zzhsv.f34189e);
        zzhhrVar.a(zzhpw.TINK, zzhsv.f34186b);
        zzhhrVar.a(zzhpw.CRUNCHY, zzhsv.f34187c);
        zzhhrVar.a(zzhpw.LEGACY, zzhsv.f34188d);
        f34339g = zzhhrVar.b();
        zzhhr zzhhrVar2 = new zzhhr();
        zzhhrVar2.a(zzhor.SHA256, zzhsu.f34182b);
        zzhhrVar2.a(zzhor.SHA384, zzhsu.f34183c);
        zzhhrVar2.a(zzhor.SHA512, zzhsu.f34184d);
        f34340h = zzhhrVar2.b();
    }

    public static zzhqg a(zzhta zzhtaVar) {
        zzhqf zzhqfVarH = zzhqg.H();
        zzhsw zzhswVar = zzhtaVar.f34215a;
        zzhqb zzhqbVarD = zzhqc.D();
        zzhor zzhorVar = (zzhor) f34340h.a(zzhswVar.f34195d);
        zzhqbVarD.j();
        ((zzhqc) zzhqbVarD.f34638b).F(zzhorVar);
        zzhqc zzhqcVar = (zzhqc) zzhqbVarD.l();
        zzhqfVarH.j();
        ((zzhqg) zzhqfVarH.f34638b).K(zzhqcVar);
        byte[] bArrA = zzhhe.a(zzhtaVar.f34216b);
        zzhzl zzhzlVar = zzhzl.f34557b;
        zzhzl zzhzlVarV = zzhzl.v(0, bArrA, bArrA.length);
        zzhqfVarH.j();
        ((zzhqg) zzhqfVarH.f34638b).L(zzhzlVarV);
        byte[] bArrA2 = zzhhe.a(zzhtaVar.f34215a.f34193b);
        zzhzl zzhzlVarV2 = zzhzl.v(0, bArrA2, bArrA2.length);
        zzhqfVarH.j();
        ((zzhqg) zzhqfVarH.f34638b).M(zzhzlVarV2);
        return (zzhqg) zzhqfVarH.l();
    }

    public static zzhxd b(zzhzl zzhzlVar) {
        return new zzhxd(new BigInteger(1, zzhzlVar.z()));
    }
}
