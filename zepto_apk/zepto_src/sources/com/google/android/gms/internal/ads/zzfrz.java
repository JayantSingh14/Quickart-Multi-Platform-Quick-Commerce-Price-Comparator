package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzfrz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f31760a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfsa f31761b;

    public zzfrz(zzfsa zzfsaVar, float f2) {
        this.f31760a = f2;
        this.f31761b = zzfsaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfsn zzfsnVar = this.f31761b.f31766a.f31773g;
        float f2 = this.f31760a;
        zzfsnVar.f31798a = f2;
        if (zzfsnVar.f31800c == null) {
            zzfsnVar.f31800c = zzfsf.f31780c;
        }
        Iterator it = Collections.unmodifiableCollection(zzfsnVar.f31800c.f31782b).iterator();
        while (it.hasNext()) {
            zzfsv zzfsvVar = ((zzfrl) it.next()).f31721d;
            zzfsm.f31796a.a(zzfsvVar.c(), "setDeviceVolume", Float.valueOf(f2), zzfsvVar.f31810a);
        }
    }
}
