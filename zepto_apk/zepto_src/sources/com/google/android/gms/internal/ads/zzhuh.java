package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhuh implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhuh f34308a = new zzhuh();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhrp zzhrpVar = (zzhrp) zzgzxVar;
        zzhjl zzhjlVar = zzhuk.f34311a;
        zzhom zzhomVarG = zzhon.G();
        zzhop zzhopVarA = zzhuk.a(zzhrpVar.f34125a);
        zzhomVarG.j();
        ((zzhon) zzhomVarG.f34638b).J(zzhopVarA);
        byte[] bArrB = zzhrpVar.f34126b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhomVarG.j();
        ((zzhon) zzhomVarG.f34638b).I(zzhzlVarV);
        zzhzl zzhzlVarB = ((zzhon) zzhomVarG.l()).b();
        zzhoz zzhozVar = zzhoz.ASYMMETRIC_PRIVATE;
        zzhrv zzhrvVar = zzhrpVar.f34125a;
        return zzhjz.a("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey", zzhzlVarB, zzhozVar, (zzhpw) zzhuk.f34317g.a(zzhrvVar.f34137a.f34124a), zzhrvVar.f34140d);
    }
}
