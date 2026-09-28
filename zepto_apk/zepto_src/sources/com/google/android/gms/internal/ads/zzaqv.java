package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzaqv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzark f24181a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzaqw f24182b;

    public zzaqv(zzaqw zzaqwVar, zzark zzarkVar) {
        this.f24181a = zzarkVar;
        Objects.requireNonNull(zzaqwVar);
        this.f24182b = zzaqwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f24182b.f24185b.put(this.f24181a);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
