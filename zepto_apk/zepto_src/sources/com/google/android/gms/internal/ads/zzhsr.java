package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzhsr implements zzhaq {

    /* renamed from: a, reason: collision with root package name */
    public final zzhjp f34173a;

    public zzhsr(zzhjp zzhjpVar) {
        this.f34173a = zzhjpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhaq
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Iterator it = this.f34173a.a(bArr).iterator();
        while (it.hasNext()) {
            try {
                ((zzhsq) it.next()).f34172a.zza(bArr, bArr2);
                int length = bArr2.length;
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("invalid signature");
    }
}
