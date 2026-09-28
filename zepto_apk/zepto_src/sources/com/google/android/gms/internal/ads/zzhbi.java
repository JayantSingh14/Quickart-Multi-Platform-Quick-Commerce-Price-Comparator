package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzhbi implements zzgzq {

    /* renamed from: a, reason: collision with root package name */
    public final zzhjp f33447a;

    @Override // com.google.android.gms.internal.ads.zzgzq
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Iterator it = this.f33447a.a(bArr).iterator();
        while (it.hasNext()) {
            try {
                return ((zzhbg) it.next()).f33445a.zza(bArr, bArr2);
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
