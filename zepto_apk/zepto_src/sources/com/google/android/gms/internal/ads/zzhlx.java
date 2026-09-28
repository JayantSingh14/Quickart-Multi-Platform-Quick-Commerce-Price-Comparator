package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhlx implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhlx f34008a = new zzhlx();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) {
        zzhkn zzhknVar = (zzhkn) zzgzxVar;
        zzhjl zzhjlVar = zzhma.f34020a;
        zzhmt zzhmtVarG = zzhmu.G();
        zzhku zzhkuVar = zzhknVar.f33936a;
        zzhmx zzhmxVarD = zzhmy.D();
        int i2 = zzhkuVar.f33956b;
        zzhmxVarD.j();
        ((zzhmy) zzhmxVarD.f34638b).F(i2);
        zzhmy zzhmyVar = (zzhmy) zzhmxVarD.l();
        zzhmtVarG.j();
        ((zzhmu) zzhmtVarG.f34638b).J(zzhmyVar);
        byte[] bArrB = zzhknVar.f33937b.f34463a.b();
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhmtVarG.j();
        ((zzhmu) zzhmtVarG.f34638b).I(zzhzlVarV);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzhmu) zzhmtVarG.l()).b(), zzhoz.SYMMETRIC, zzhma.a(zzhknVar.f33936a.f33957c), zzhknVar.f33939d);
    }
}
