package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
final class zzad<T> implements zzae<T> {

    /* renamed from: a, reason: collision with root package name */
    public final CountDownLatch f39755a = new CountDownLatch(1);

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void a() {
        this.f39755a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f39755a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.f39755a.countDown();
    }
}
