package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfw implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfw f33740a = new zzhfw();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhcu zzhcuVar = (zzhcu) zzgzxVar;
        zzhjl zzhjlVar = zzhfz.f33743a;
        zzhnx zzhnxVarF = zzhny.F();
        byte[] bArrB = zzhcuVar.f33561b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhnxVarF.j();
        ((zzhny) zzhnxVarF.f34638b).H(zzhzlVarV);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzhny) zzhnxVarF.l()).b(), zzhoz.SYMMETRIC, zzhfz.a(zzhcuVar.f33560a.f33573a), zzhcuVar.f33563d);
    }
}
