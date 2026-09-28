package com.google.android.gms.internal.ads;

import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public final class zzafw extends zzafc {

    /* renamed from: b, reason: collision with root package name */
    public final long f22969b;

    public zzafw(zzaef zzaefVar, long j2) {
        super(zzaefVar);
        zzgqa.a(zzaefVar.f22872d >= j2);
        this.f22969b = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzafc, com.google.android.gms.internal.ads.zzaep
    public final long zzm() {
        return super.zzm() - this.f22969b;
    }

    @Override // com.google.android.gms.internal.ads.zzafc, com.google.android.gms.internal.ads.zzaep
    public final long zzn() {
        return super.zzn() - this.f22969b;
    }

    @Override // com.google.android.gms.internal.ads.zzafc, com.google.android.gms.internal.ads.zzaep
    public final long zzo() {
        return super.zzo() - this.f22969b;
    }
}
