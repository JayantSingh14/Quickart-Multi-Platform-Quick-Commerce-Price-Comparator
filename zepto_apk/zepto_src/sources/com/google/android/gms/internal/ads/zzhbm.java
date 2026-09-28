package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzhbm implements zzhhz {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzhbm f33459a = new zzhbm();

    @Override // com.google.android.gms.internal.ads.zzhhz
    public final zzgzx a(zzhan zzhanVar, Integer num) throws GeneralSecurityException {
        zzhbt zzhbtVar = (zzhbt) zzhanVar;
        zzhjs zzhjsVar = zzhbp.f33462a;
        int i2 = zzhbtVar.f33483a;
        if (i2 != 16 && i2 != 32) {
            throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
        }
        zzhbk zzhbkVar = new zzhbk();
        zzhbkVar.f33450a = zzhbtVar;
        zzhbkVar.f33453d = num;
        zzhbkVar.f33451b = zzhxe.b(i2);
        zzhbkVar.f33452c = zzhxe.b(zzhbtVar.f33484b);
        return zzhbkVar.a();
    }
}
