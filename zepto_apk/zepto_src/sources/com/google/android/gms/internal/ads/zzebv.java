package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* loaded from: classes4.dex */
final /* synthetic */ class zzebv implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ zzebv f29033a = new zzebv();

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        Throwable cause = (ExecutionException) obj;
        if (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return zzgym.b(cause);
    }
}
