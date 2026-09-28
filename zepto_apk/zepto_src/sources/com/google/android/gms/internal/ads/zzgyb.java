package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes4.dex */
final class zzgyb implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final zzgyb f33369a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzgyb[] f33370b;

    static {
        zzgyb zzgybVar = new zzgyb("INSTANCE", 0);
        f33369a = zzgybVar;
        f33370b = new zzgyb[]{zzgybVar};
    }

    public static zzgyb[] values() {
        return (zzgyb[]) f33370b.clone();
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
