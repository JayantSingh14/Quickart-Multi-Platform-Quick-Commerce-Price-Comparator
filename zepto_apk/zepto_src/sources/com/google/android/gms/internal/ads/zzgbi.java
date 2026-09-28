package com.google.android.gms.internal.ads;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzgbi implements zzgbc {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f32217a;

    /* renamed from: b, reason: collision with root package name */
    public final String f32218b;

    /* renamed from: c, reason: collision with root package name */
    public final long f32219c;

    public zzgbi(ExecutorService executorService, String str, long j2) {
        this.f32217a = executorService;
        this.f32218b = str;
        this.f32219c = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzgbc
    public final ListenableFuture a(String str) {
        return CallbackToFutureAdapter.a(new zzgbf(this, str, false, null, new byte[0]));
    }

    @Override // com.google.android.gms.internal.ads.zzgbc
    public final ListenableFuture b(String str, byte[] bArr) {
        return CallbackToFutureAdapter.a(new zzgbf(this, str, true, "application/x-protobuf", bArr));
    }
}
