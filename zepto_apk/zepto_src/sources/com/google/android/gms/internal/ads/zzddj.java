package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
final class zzddj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f27633a;

    @Override // java.lang.Runnable
    public final void run() {
        zzddl zzddlVar = (zzddl) this.f27633a.get();
        if (zzddlVar != null) {
            zzddlVar.v0(zzddi.f27632a);
        }
    }
}
