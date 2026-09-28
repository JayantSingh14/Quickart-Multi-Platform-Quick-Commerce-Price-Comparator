package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhmg implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhmg f34025a = new zzhmg();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhkz zzhkzVar = (zzhkz) zzgzxVar;
        zzhhs zzhhsVar = zzhmj.f34028a;
        zzhos zzhosVarG = zzhot.G();
        zzhli zzhliVar = zzhkzVar.f33962a;
        zzhow zzhowVarE = zzhox.E();
        int i2 = zzhliVar.f33993b;
        zzhowVarE.j();
        ((zzhox) zzhowVarE.f34638b).H(i2);
        zzhor zzhorVar = (zzhor) zzhmj.f34029b.a(zzhliVar.f33995d);
        zzhowVarE.j();
        ((zzhox) zzhowVarE.f34638b).G(zzhorVar);
        zzhox zzhoxVar = (zzhox) zzhowVarE.l();
        zzhosVarG.j();
        ((zzhot) zzhosVarG.f34638b).J(zzhoxVar);
        byte[] bArrB = zzhkzVar.f33963b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhosVarG.j();
        ((zzhot) zzhosVarG.f34638b).K(zzhzlVarV);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.HmacKey", ((zzhot) zzhosVarG.l()).b(), zzhoz.SYMMETRIC, (zzhpw) zzhmj.f34028a.a(zzhkzVar.f33962a.f33994c), zzhkzVar.f33965d);
    }
}
