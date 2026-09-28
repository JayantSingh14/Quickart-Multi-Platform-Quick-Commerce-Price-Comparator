package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes4.dex */
final class zzgxr extends zzgxp {
    @Override // com.google.android.gms.internal.ads.zzgxp
    public final void a(zzgxo zzgxoVar, Set set) {
        synchronized (zzgxoVar) {
            try {
                if (zzgxoVar.f33356h == null) {
                    zzgxoVar.f33356h = set;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxp
    public final int b(zzgxo zzgxoVar) {
        int i2;
        synchronized (zzgxoVar) {
            i2 = zzgxoVar.f33357i - 1;
            zzgxoVar.f33357i = i2;
        }
        return i2;
    }
}
