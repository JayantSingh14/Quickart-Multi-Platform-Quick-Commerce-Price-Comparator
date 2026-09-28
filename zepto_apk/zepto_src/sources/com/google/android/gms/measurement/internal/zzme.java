package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzme extends zzgf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39396a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zznk f39397b;

    public zzme(zznk zznkVar, AtomicReference atomicReference) {
        this.f39396a = atomicReference;
        this.f39397b = zznkVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgg
    public final void ib(zzop zzopVar) {
        AtomicReference atomicReference = this.f39396a;
        synchronized (atomicReference) {
            zzgt zzgtVar = this.f39397b.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.b(Integer.valueOf(zzopVar.f39560a.size()), "[sgtm] Got upload batches from service. count");
            atomicReference.set(zzopVar);
            atomicReference.notifyAll();
        }
    }
}
