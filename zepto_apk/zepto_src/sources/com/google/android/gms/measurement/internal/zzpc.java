package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzpc {

    /* renamed from: a, reason: collision with root package name */
    public final String f39588a;

    /* renamed from: b, reason: collision with root package name */
    public final long f39589b;

    public zzpc(zzpf zzpfVar, String str) {
        Objects.requireNonNull(zzpfVar);
        this.f39588a = str;
        this.f39589b = zzpfVar.f().elapsedRealtime();
    }
}
