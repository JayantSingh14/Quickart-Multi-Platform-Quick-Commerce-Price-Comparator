package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhgh implements zzgzq {

    /* renamed from: a, reason: collision with root package name */
    public final zzgzq f33754a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f33755b;

    public zzhgh(zzgzq zzgzqVar, byte[] bArr) {
        this.f33754a = zzgzqVar;
        int length = bArr.length;
        if (length != 0 && length != 5) {
            throw new IllegalArgumentException("identifier has an invalid length");
        }
        this.f33755b = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f33755b;
        int length = bArr3.length;
        zzgzq zzgzqVar = this.f33754a;
        if (length == 0) {
            return zzgzqVar.zza(bArr, bArr2);
        }
        if (zzhkl.c(bArr3, bArr)) {
            return zzgzqVar.zza(Arrays.copyOfRange(bArr, 5, bArr.length), bArr2);
        }
        throw new GeneralSecurityException("wrong prefix");
    }
}
