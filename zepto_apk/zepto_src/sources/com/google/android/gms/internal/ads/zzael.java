package com.google.android.gms.internal.ads;

import java.io.EOFException;

/* loaded from: classes4.dex */
public final class zzael implements zzaga {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22885a = new byte[4096];

    @Override // com.google.android.gms.internal.ads.zzaga
    public final int a(zzj zzjVar, int i2, boolean z) throws EOFException {
        int iB = zzjVar.b(0, this.f22885a, Math.min(4096, i2));
        if (iB != -1) {
            return iB;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final void c(zzv zzvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final void d(zzer zzerVar, int i2, int i3) {
        zzerVar.G(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final void e(long j2, int i2, int i3, int i4, zzafz zzafzVar) {
    }
}
