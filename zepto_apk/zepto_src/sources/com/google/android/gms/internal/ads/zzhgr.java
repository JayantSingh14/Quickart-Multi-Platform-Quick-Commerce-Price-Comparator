package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhgr implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhgr f33771a = new zzhgr();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhep zzhepVar = (zzhep) zzgzxVar;
        zzhjl zzhjlVar = zzhgu.f33774a;
        zzhqv zzhqvVarF = zzhqw.F();
        byte[] bArrB = zzhepVar.f33671b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhqvVarF.j();
        ((zzhqw) zzhqvVarF.f34638b).H(zzhzlVarV);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzhqw) zzhqvVarF.l()).b(), zzhoz.SYMMETRIC, zzhgu.a(zzhepVar.f33670a.f33685a), zzhepVar.f33673d);
    }
}
