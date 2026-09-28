package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public final class zzdh {

    /* renamed from: a, reason: collision with root package name */
    public static ExecutorService f27760a;

    public static synchronized Executor a() {
        try {
            if (f27760a == null) {
                String str = zzfj.f31254a;
                f27760a = Executors.newSingleThreadExecutor(new zzfi("ExoPlayer:BackgroundExecutor"));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f27760a;
    }
}
