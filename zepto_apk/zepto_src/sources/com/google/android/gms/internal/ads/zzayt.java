package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzayt {

    /* renamed from: a, reason: collision with root package name */
    public final ListenableFuture f24514a;

    public zzayt(final Context context, Executor executor) {
        this.f24514a = zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzays
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                Context context2 = context;
                try {
                    return zzfum.a(context2, context2.getPackageName(), Integer.toString(context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode));
                } catch (Throwable unused) {
                    return null;
                }
            }
        }, executor);
    }
}
