package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhuk {

    /* renamed from: a, reason: collision with root package name */
    public static final zzhjl f34311a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzhji f34312b;

    /* renamed from: c, reason: collision with root package name */
    public static final zzhig f34313c;

    /* renamed from: d, reason: collision with root package name */
    public static final zzhid f34314d;

    /* renamed from: e, reason: collision with root package name */
    public static final zzhig f34315e;

    /* renamed from: f, reason: collision with root package name */
    public static final zzhid f34316f;

    /* renamed from: g, reason: collision with root package name */
    public static final zzhhs f34317g;

    static {
        zzhxc zzhxcVarA = zzhkl.a("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey");
        zzhxc zzhxcVarA2 = zzhkl.a("type.googleapis.com/google.crypto.tink.Ed25519PublicKey");
        f34311a = new zzhjj(zzhro.class, zzhuj.f34310a);
        f34312b = new zzhjg(zzhxcVarA, zzhue.f34305a);
        f34313c = new zzhie(zzhrv.class, zzhuf.f34306a);
        f34314d = new zzhib(zzhxcVarA2, zzhug.f34307a);
        f34315e = new zzhie(zzhrp.class, zzhuh.f34308a);
        f34316f = new zzhib(zzhxcVarA, zzhui.f34309a);
        zzhhr zzhhrVar = new zzhhr();
        zzhhrVar.a(zzhpw.RAW, zzhrn.f34122e);
        zzhhrVar.a(zzhpw.TINK, zzhrn.f34119b);
        zzhhrVar.a(zzhpw.CRUNCHY, zzhrn.f34120c);
        zzhhrVar.a(zzhpw.LEGACY, zzhrn.f34121d);
        f34317g = zzhhrVar.b();
    }

    public static zzhop a(zzhrv zzhrvVar) {
        zzhoo zzhooVarF = zzhop.F();
        byte[] bArrB = zzhrvVar.f34138b.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhooVarF.j();
        ((zzhop) zzhooVarF.f34638b).I(zzhzlVarV);
        return (zzhop) zzhooVarF.l();
    }
}
