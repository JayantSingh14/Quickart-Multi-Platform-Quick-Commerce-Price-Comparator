package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhex implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhex f33687a = new zzhex();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhbl zzhblVar = (zzhbl) zzgzxVar;
        zzhjl zzhjlVar = zzhfa.f33696a;
        zzhmz zzhmzVarG = zzhna.G();
        zzhnd zzhndVarF = zzhne.F();
        zzhnh zzhnhVarD = zzhni.D();
        int i2 = zzhblVar.f33454a.f33485c;
        zzhnhVarD.j();
        ((zzhni) zzhnhVarD.f34638b).F(i2);
        zzhni zzhniVar = (zzhni) zzhnhVarD.l();
        zzhndVarF.j();
        ((zzhne) zzhndVarF.f34638b).H(zzhniVar);
        byte[] bArrB = zzhblVar.f33455b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhndVarF.j();
        ((zzhne) zzhndVarF.f34638b).I(zzhzlVarV);
        zzhne zzhneVar = (zzhne) zzhndVarF.l();
        zzhmzVarG.j();
        ((zzhna) zzhmzVarG.f34638b).I(zzhneVar);
        zzhos zzhosVarG = zzhot.G();
        zzhbt zzhbtVar = zzhblVar.f33454a;
        zzhox zzhoxVarD = zzhfa.d(zzhbtVar);
        zzhosVarG.j();
        ((zzhot) zzhosVarG.f34638b).J(zzhoxVarD);
        byte[] bArrB2 = zzhblVar.f33456c.f34463a.b();
        zzhzl zzhzlVarV2 = zzhzl.v(0, bArrB2, bArrB2.length);
        zzhosVarG.j();
        ((zzhot) zzhosVarG.f34638b).K(zzhzlVarV2);
        zzhot zzhotVar = (zzhot) zzhosVarG.l();
        zzhmzVarG.j();
        ((zzhna) zzhmzVarG.f34638b).J(zzhotVar);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzhna) zzhmzVarG.l()).b(), zzhoz.SYMMETRIC, zzhfa.a(zzhbtVar.f33487e), zzhblVar.f33458e);
    }
}
