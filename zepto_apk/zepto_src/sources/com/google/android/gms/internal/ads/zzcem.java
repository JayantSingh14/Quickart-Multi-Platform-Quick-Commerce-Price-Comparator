package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcem implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzceo f26014a;

    public zzcem(zzceo zzceoVar) {
        Objects.requireNonNull(zzceoVar);
        this.f26014a = zzceoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcey zzceyVar = this.f26014a.q;
        if (zzceyVar != null) {
            zzceyVar.h();
        }
    }
}
