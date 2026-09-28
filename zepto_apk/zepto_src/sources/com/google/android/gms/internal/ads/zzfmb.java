package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfmb implements ListenableFuture {

    /* renamed from: a, reason: collision with root package name */
    public final Object f31384a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31385b;

    /* renamed from: c, reason: collision with root package name */
    public final ListenableFuture f31386c;

    public zzfmb(Object obj, String str, ListenableFuture listenableFuture) {
        this.f31384a = obj;
        this.f31385b = str;
        this.f31386c = listenableFuture;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.f31386c.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.f31386c.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f31386c.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f31386c.isDone();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void q(Runnable runnable, Executor executor) {
        this.f31386c.q(runnable, executor);
    }

    public final String toString() {
        int iIdentityHashCode = System.identityHashCode(this);
        String str = this.f31385b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(iIdentityHashCode).length());
        sb.append(str);
        sb.append("@");
        sb.append(iIdentityHashCode);
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) {
        return this.f31386c.get(j2, timeUnit);
    }
}
