package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeaw extends AppOpenAd.AppOpenAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f28977a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzebh f28978b;

    public zzeaw(zzebh zzebhVar, String str) {
        this.f28977a = str;
        Objects.requireNonNull(zzebhVar);
        this.f28978b = zzebhVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void a(LoadAdError loadAdError) {
        this.f28978b.Yb(zzebh.bc(loadAdError));
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        String str = this.f28977a;
        this.f28978b.Xb((AppOpenAd) obj, str);
    }
}
