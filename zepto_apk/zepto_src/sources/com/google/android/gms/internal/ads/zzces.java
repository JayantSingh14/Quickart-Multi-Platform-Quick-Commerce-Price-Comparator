package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzces implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzcey f26030a;

    public zzces(zzcey zzceyVar) {
        Objects.requireNonNull(zzceyVar);
        this.f26030a = zzceyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26030a.c("surfaceCreated", new String[0]);
    }
}
