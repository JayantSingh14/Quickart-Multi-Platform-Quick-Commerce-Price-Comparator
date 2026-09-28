package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzmd extends zzgc {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39395a;

    public zzmd(zznk zznkVar, AtomicReference atomicReference) {
        this.f39395a = atomicReference;
    }

    @Override // com.google.android.gms.measurement.internal.zzgd
    public final void J0(List list) {
        AtomicReference atomicReference = this.f39395a;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
