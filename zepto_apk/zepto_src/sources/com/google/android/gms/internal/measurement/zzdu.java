package com.google.android.gms.internal.measurement;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdu extends zzcw {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f36874a;

    public zzdu(zzdv zzdvVar, Runnable runnable) {
        this.f36874a = runnable;
        Objects.requireNonNull(zzdvVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzcx
    public final void zze() {
        this.f36874a.run();
    }
}
