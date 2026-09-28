package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes4.dex */
public final class zzewu implements zzezv {

    /* renamed from: a, reason: collision with root package name */
    public final String f30498a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30499b;

    public zzewu(String str, boolean z) {
        this.f30498a = str;
        this.f30499b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = ((zzczm) obj).f27481a;
        bundle.putString("gct", this.f30498a);
        if (this.f30499b) {
            bundle.putString("de", "1");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzezv
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzczm) obj).f27482b.putString("gct", this.f30498a);
    }
}
