package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzeeq implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzeeq f29189a = new zzeeq();

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        Throwable cause = (ExecutionException) obj;
        if (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return zzgym.b(cause);
    }
}
