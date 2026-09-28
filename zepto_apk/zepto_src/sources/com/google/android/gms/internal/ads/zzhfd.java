package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhfd implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhfd f33702a = new zzhfd();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhff.f33704a;
        if (!zzhjzVar.f33909a.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhnk zzhnkVarF = zzhnk.F(zzhzlVar, zziab.f34621c);
            if (zzhnkVarF.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhbz zzhbzVar = new zzhbz();
            zzhbzVar.a(zzhnkVarF.E().i());
            zzhbzVar.b(zzhnkVarF.D().C());
            zzhbzVar.c();
            zzhbzVar.f33504d = zzhff.b(zzhjzVar.f33913e);
            zzhcb zzhcbVarD = zzhbzVar.d();
            zzhbu zzhbuVar = new zzhbu();
            zzhbuVar.f33489a = zzhcbVarD;
            zzhbuVar.f33490b = zzhxe.a(zzhnkVarF.E().z());
            zzhbuVar.f33491c = zzhjzVar.f33914f;
            return zzhbuVar.a();
        } catch (zzibg unused) {
            throw new GeneralSecurityException("Parsing AesEaxcKey failed");
        }
    }
}
