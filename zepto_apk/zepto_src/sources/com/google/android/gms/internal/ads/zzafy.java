package com.google.android.gms.internal.ads;

import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public final class zzafy implements zzaer {

    /* renamed from: a, reason: collision with root package name */
    public final long f22972a;

    /* renamed from: b, reason: collision with root package name */
    public final zzaer f22973b;

    public zzafy(long j2, zzaer zzaerVar) {
        this.f22972a = j2;
        this.f22973b = zzaerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void d(zzafr zzafrVar) {
        ((zzxk) this.f22973b).d(new zzafx(this, zzafrVar, zzafrVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final zzaga e(int i2, int i3) {
        return this.f22973b.e(i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzaer
    public final void h() {
        this.f22973b.h();
    }
}
