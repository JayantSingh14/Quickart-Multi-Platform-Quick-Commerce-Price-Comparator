package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzhuo implements zzhaq {

    /* renamed from: a, reason: collision with root package name */
    public final zzhaq f34324a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f34325b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f34326c;

    public zzhuo(zzhaq zzhaqVar, byte[] bArr, byte[] bArr2) {
        this.f34324a = zzhaqVar;
        this.f34325b = bArr;
        this.f34326c = bArr2;
    }

    public static byte[] a(zzhjz zzhjzVar) throws GeneralSecurityException {
        int iOrdinal = zzhjzVar.f33913e.ordinal();
        Integer num = zzhjzVar.f33914f;
        if (iOrdinal == 1) {
            return zzhjf.b(num.intValue()).b();
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhjf.f33886a.b();
            }
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
        }
        return zzhjf.a(num.intValue()).b();
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.f34325b;
        int length = bArr3.length;
        zzhaq zzhaqVar = this.f34324a;
        byte[] bArr4 = this.f34326c;
        if (length == 0 && bArr4.length == 0) {
            zzhaqVar.zza(bArr, bArr2);
        } else {
            if (!zzhkl.c(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            if (bArr4.length != 0) {
                bArr2 = zzhvp.a(bArr2, bArr4);
            }
            zzhaqVar.zza(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
    }
}
