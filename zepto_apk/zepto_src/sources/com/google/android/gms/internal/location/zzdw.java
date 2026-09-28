package com.google.android.gms.internal.location;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class zzdw implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final zzdw f36705a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzdw[] f36706b;

    static {
        zzdw zzdwVar = new zzdw("INSTANCE", 0);
        f36705a = zzdwVar;
        f36706b = new zzdw[]{zzdwVar};
    }

    public static zzdw[] values() {
        return (zzdw[]) f36706b.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
