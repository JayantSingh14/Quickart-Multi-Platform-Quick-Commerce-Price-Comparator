package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfj implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfj f33710a = new zzhfj();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhcd zzhcdVar = (zzhcd) zzgzxVar;
        zzhjl zzhjlVar = zzhfm.f33713a;
        zzhnp zzhnpVarF = zzhnq.F();
        byte[] bArrB = zzhcdVar.f33517b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhnpVarF.j();
        ((zzhnq) zzhnpVarF.f34638b).H(zzhzlVarV);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzhnq) zzhnpVarF.l()).b(), zzhoz.SYMMETRIC, zzhfm.a(zzhcdVar.f33516a.f33537b), zzhcdVar.f33519d);
    }
}
