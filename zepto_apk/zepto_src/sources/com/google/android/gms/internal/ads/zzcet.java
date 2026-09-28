package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcet implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcey f26031a;

    public zzcet(zzcey zzceyVar) {
        Objects.requireNonNull(zzceyVar);
        this.f26031a = zzceyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26031a.c("surfaceDestroyed", new String[0]);
    }
}
