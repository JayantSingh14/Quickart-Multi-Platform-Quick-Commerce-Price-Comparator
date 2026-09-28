package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
final class zzddk implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f27634a;

    @Override // java.lang.Runnable
    public final void run() {
        zzddl zzddlVar = (zzddl) this.f27634a.get();
        if (zzddlVar != null) {
            zzddlVar.v0(zzddh.f27631a);
        }
    }
}
