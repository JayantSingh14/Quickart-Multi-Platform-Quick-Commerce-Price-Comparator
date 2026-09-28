package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeax extends AdListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f28979a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseAdView f28980b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzebh f28981c;

    public zzeax(zzebh zzebhVar, String str, BaseAdView baseAdView) {
        this.f28979a = str;
        this.f28980b = baseAdView;
        Objects.requireNonNull(zzebhVar);
        this.f28981c = zzebhVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void g(LoadAdError loadAdError) {
        this.f28981c.Yb(zzebh.bc(loadAdError));
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void m() {
        String str = this.f28979a;
        this.f28981c.Xb(this.f28980b, str);
    }
}
