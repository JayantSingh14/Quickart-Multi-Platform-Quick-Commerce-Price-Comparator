package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzghr extends zzfuf {

    /* renamed from: f, reason: collision with root package name */
    public final zzgcf f32605f;

    public zzghr(Context context, ExecutorService executorService, zzgcf zzgcfVar) {
        super(context, executorService, new TaskCompletionSource().f39750a, false);
        this.f32605f = zzgcfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfuf
    public final void b(int i2, long j2) {
        this.f32605f.b(i2, j2, null, null);
        new TaskCompletionSource().b(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzfuf
    public final void c(int i2, long j2, Exception exc) {
        this.f32605f.b(i2, j2, null, exc);
        new TaskCompletionSource().b(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzfuf
    public final void d(int i2, String str) {
        this.f32605f.b(i2, -1L, str, null);
        new TaskCompletionSource().b(Boolean.TRUE);
    }
}
