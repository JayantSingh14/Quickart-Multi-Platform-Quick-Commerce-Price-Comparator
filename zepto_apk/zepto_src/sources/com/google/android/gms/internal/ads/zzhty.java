package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhty implements zzhif {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhty f34285a = new zzhty();

    @Override // com.google.android.gms.internal.ads.zzhif
    public final zzhjz a(zzgzx zzgzxVar) throws GeneralSecurityException {
        zzhrg zzhrgVar = (zzhrg) zzgzxVar;
        zzhjl zzhjlVar = zzhub.f34288a;
        int iD = zzhub.d(zzhrgVar.f34101a.f34106a.f34096b);
        zzhof zzhofVarG = zzhog.G();
        zzhri zzhriVar = zzhrgVar.f34101a;
        zzhoi zzhoiVarF = zzhub.f(zzhriVar);
        zzhofVarG.j();
        ((zzhog) zzhofVarG.f34638b).I(zzhoiVarF);
        byte[] bArrB = zzhhe.b(zzhrgVar.f34102b.f34462a, iD);
        zzhzl zzhzlVar = zzhzl.f34557b;
        zzhzl zzhzlVarV = zzhzl.v(0, bArrB, bArrB.length);
        zzhofVarG.j();
        ((zzhog) zzhofVarG.f34638b).J(zzhzlVarV);
        return zzhjz.a("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey", ((zzhog) zzhofVarG.l()).b(), zzhoz.ASYMMETRIC_PRIVATE, zzhub.a(zzhriVar.f34106a.f34098d), zzhriVar.f34109d);
    }
}
