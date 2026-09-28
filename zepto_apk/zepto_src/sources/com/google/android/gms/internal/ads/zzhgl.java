package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhgl implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhgl f33760a = new zzhgl();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhej zzhejVar = (zzhej) zzgzxVar;
        zzhjl zzhjlVar = zzhgo.f33763a;
        zzhqp zzhqpVarG = zzhqq.G();
        byte[] bArrB = zzhejVar.f33658b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhqpVarG.j();
        ((zzhqq) zzhqpVarG.f34638b).I(zzhzlVarV);
        zzhqt zzhqtVarD = zzhqu.D();
        zzheo zzheoVar = zzhejVar.f33657a;
        int i2 = zzheoVar.f33669b;
        zzhqtVarD.j();
        ((zzhqu) zzhqtVarD.f34638b).F(i2);
        zzhqu zzhquVar = (zzhqu) zzhqtVarD.l();
        zzhqpVarG.j();
        ((zzhqq) zzhqpVarG.f34638b).H(zzhquVar);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.XAesGcmKey", ((zzhqq) zzhqpVarG.l()).b(), zzhoz.SYMMETRIC, zzhgo.a(zzheoVar.f33668a), zzhejVar.f33660d);
    }
}
