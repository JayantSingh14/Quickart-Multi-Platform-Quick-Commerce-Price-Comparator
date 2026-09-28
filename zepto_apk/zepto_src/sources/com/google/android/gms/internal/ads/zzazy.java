package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzazy implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzbaa f24596a;

    public zzazy(zzbaa zzbaaVar) {
        Objects.requireNonNull(zzbaaVar);
        this.f24596a = zzbaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f24596a.c();
    }
}
