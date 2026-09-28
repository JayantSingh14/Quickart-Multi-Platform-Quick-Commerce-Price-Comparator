package com.google.android.gms.internal.ads;

import android.app.Activity;

/* loaded from: classes4.dex */
final class zzehk extends zzeig {

    /* renamed from: a, reason: collision with root package name */
    public Activity f29345a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.ads.internal.overlay.zzm f29346b;

    /* renamed from: c, reason: collision with root package name */
    public String f29347c;

    /* renamed from: d, reason: collision with root package name */
    public String f29348d;

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzeig a(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("Null activity");
        }
        this.f29345a = activity;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzeig b(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.f29346b = zzmVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzeig c(String str) {
        this.f29347c = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzeig d(String str) {
        this.f29348d = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeig
    public final zzeih e() {
        Activity activity = this.f29345a;
        if (activity != null) {
            return new zzehl(activity, this.f29346b, this.f29347c, this.f29348d);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}
