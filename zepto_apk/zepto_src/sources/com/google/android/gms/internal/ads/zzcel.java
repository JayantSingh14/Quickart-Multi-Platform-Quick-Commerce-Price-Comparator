package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcel implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzceo f26013a;

    public zzcel(zzceo zzceoVar) {
        Objects.requireNonNull(zzceoVar);
        this.f26013a = zzceoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzceo zzceoVar = this.f26013a;
        zzcey zzceyVar = zzceoVar.q;
        if (zzceyVar != null) {
            if (!zzceoVar.r) {
                zzceyVar.m();
                zzceoVar.r = true;
            }
            zzceoVar.q.g();
        }
    }
}
