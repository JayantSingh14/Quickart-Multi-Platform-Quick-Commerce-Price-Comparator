package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzoz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39576a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39577b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f39578c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzpa f39579d;

    public zzoz(zzpa zzpaVar, String str, String str2, Bundle bundle) {
        this.f39576a = str;
        this.f39577b = str2;
        this.f39578c = bundle;
        Objects.requireNonNull(zzpaVar);
        this.f39579d = zzpaVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzpf zzpfVar = this.f39579d.f39582a;
        zzpfVar.h((zzbg) Preconditions.checkNotNull(zzpfVar.j0().H(this.f39577b, this.f39578c, "auto", zzpfVar.f().currentTimeMillis(), false)), this.f39576a);
    }
}
