package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhtx implements zzhic {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhtx f34284a = new zzhtx();

    @Override // com.google.android.gms.internal.ads.zzhic
    public final zzgzx a(zzhjz zzhjzVar) throws GeneralSecurityException {
        zzhjl zzhjlVar = zzhub.f34288a;
        String str = zzhjzVar.f33909a;
        if (!str.equals("type.googleapis.com/google.crypto.tink.EcdsaPublicKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: ".concat(String.valueOf(str)));
        }
        try {
            zzhzl zzhzlVar = zzhjzVar.f33911c;
            zziab zziabVar = zziab.f34620b;
            int i2 = zzhyy.f34536a;
            zzhoi zzhoiVarG = zzhoi.G(zzhzlVar, zziab.f34621c);
            if (zzhoiVarG.C() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhqz zzhqzVar = new zzhqz();
            zzhqzVar.f34076c = zzhub.b(zzhoiVarG.D().C());
            zzhqzVar.f34074a = zzhub.h(zzhoiVarG.D().H());
            zzhqzVar.f34075b = zzhub.g(zzhoiVarG.D().G());
            zzhqzVar.f34077d = zzhub.c(zzhjzVar.f33913e);
            zzhre zzhreVarA = zzhqzVar.a();
            zzhrh zzhrhVar = new zzhrh();
            zzhrhVar.f34103a = zzhreVarA;
            zzhrhVar.f34104b = new ECPoint(new BigInteger(1, zzhoiVarG.E().z()), new BigInteger(1, zzhoiVarG.F().z()));
            zzhrhVar.f34105c = zzhjzVar.f33914f;
            return zzhrhVar.a();
        } catch (zzibg | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }
}
