package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzebb extends AdListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzebh f28991a;

    public zzebb(zzebh zzebhVar) {
        Objects.requireNonNull(zzebhVar);
        this.f28991a = zzebhVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void g(LoadAdError loadAdError) {
        this.f28991a.Yb(zzebh.bc(loadAdError));
    }
}
