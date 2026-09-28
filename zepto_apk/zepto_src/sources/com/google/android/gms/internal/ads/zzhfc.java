package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfc implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfc f33701a = new zzhfc();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhbv zzhbvVar = (zzhbv) zzgzxVar;
        zzhjl zzhjlVar = zzhff.f33704a;
        zzhnj zzhnjVarG = zzhnk.G();
        zzhcb zzhcbVar = zzhbvVar.f33492a;
        zzhnn zzhnnVarD = zzhno.D();
        int i2 = zzhcbVar.f33511b;
        zzhnnVarD.j();
        ((zzhno) zzhnnVarD.f34638b).F(i2);
        zzhno zzhnoVar = (zzhno) zzhnnVarD.l();
        zzhnjVarG.j();
        ((zzhnk) zzhnjVarG.f34638b).I(zzhnoVar);
        byte[] bArrB = zzhbvVar.f33493b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhnjVarG.j();
        ((zzhnk) zzhnjVarG.f34638b).J(zzhzlVarV);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzhnk) zzhnjVarG.l()).b(), zzhoz.SYMMETRIC, zzhff.a(zzhbvVar.f33492a.f33512c), zzhbvVar.f33495d);
    }
}
