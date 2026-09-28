package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes4.dex */
public final class zzdzr implements zzdhs {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f28868a = new Bundle();

    @VisibleForTesting
    public zzdzr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhs
    public final void Y(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhs
    public final synchronized void a(String str) {
        this.f28868a.putInt(str, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzdhs
    public final synchronized void b(String str) {
        this.f28868a.putInt(str, 2);
    }

    @Override // com.google.android.gms.internal.ads.zzdhs
    public final synchronized void c(String str, String str2) {
        this.f28868a.putInt(str, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzdhs
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhs
    public final void zzf() {
    }
}
