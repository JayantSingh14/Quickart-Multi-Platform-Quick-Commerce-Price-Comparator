package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzzh implements Spatializer$OnSpatializerStateChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzzu f35955a;

    public zzzh(zzzj zzzjVar, zzzu zzzuVar) {
        this.f35955a = zzzuVar;
        Objects.requireNonNull(zzzjVar);
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.f35955a.k();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.f35955a.k();
    }
}
