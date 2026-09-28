package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfq implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfq f33726a = new zzhfq();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhcm zzhcmVar = (zzhcm) zzgzxVar;
        zzhjl zzhjlVar = zzhft.f33729a;
        zzhnt zzhntVarF = zzhnu.F();
        byte[] bArrB = zzhcmVar.f33542b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhntVarF.j();
        ((zzhnu) zzhntVarF.f34638b).H(zzhzlVarV);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzhnu) zzhntVarF.l()).b(), zzhoz.SYMMETRIC, zzhft.a(zzhcmVar.f33541a.f33559b), zzhcmVar.f33544d);
    }
}
