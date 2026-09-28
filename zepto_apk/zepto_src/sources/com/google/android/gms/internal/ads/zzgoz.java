package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* loaded from: classes4.dex */
final /* synthetic */ class zzgoz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgpd f33034a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f33035b;

    public /* synthetic */ zzgoz(zzgpd zzgpdVar, Runnable runnable) {
        this.f33034a = zzgpdVar;
        this.f33035b = runnable;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        zzgpd zzgpdVar = this.f33034a;
        Runnable runnable = this.f33035b;
        if (zzgpdVar.f33048j != null || zzgpdVar.f33044f) {
            if (!zzgpdVar.f33044f) {
                runnable.run();
                return;
            }
            zzgpdVar.f33041c.a("Waiting to bind to the service.", new Object[0]);
            ArrayList arrayList = zzgpdVar.f33043e;
            synchronized (arrayList) {
                arrayList.add(runnable);
            }
            return;
        }
        zzgpdVar.f33041c.a("Initiate binding to the service.", new Object[0]);
        ArrayList arrayList2 = zzgpdVar.f33043e;
        synchronized (arrayList2) {
            arrayList2.add(runnable);
        }
        zzgox zzgoxVar = new zzgox(zzgpdVar);
        zzgpdVar.f33047i = zzgoxVar;
        zzgpdVar.f33044f = true;
        if (zzgpdVar.f33040b.bindService(zzgpdVar.f33045g, zzgoxVar, 1)) {
            return;
        }
        zzgpdVar.f33041c.a("Failed to bind to the service.", new Object[0]);
        zzgpdVar.f33044f = false;
        ArrayList arrayList3 = zzgpdVar.f33043e;
        synchronized (arrayList3) {
            arrayList3.clear();
        }
    }
}
