package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes4.dex */
public final class zzgzd {
    public static Executor a(final Executor executor, final zzgxf zzgxfVar) {
        executor.getClass();
        return executor == zzgyb.f33369a ? executor : new Executor() { // from class: com.google.android.gms.internal.ads.zzgyz
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RejectedExecutionException e2) {
                    zzgxfVar.d(e2);
                }
            }
        };
    }
}
