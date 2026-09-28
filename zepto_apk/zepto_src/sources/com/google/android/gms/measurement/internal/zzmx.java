package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzmx implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzga f39455a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzne f39456b;

    public zzmx(zzne zzneVar, zzga zzgaVar) {
        this.f39455a = zzgaVar;
        this.f39456b = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzne zzneVar = this.f39456b;
        synchronized (zzneVar) {
            try {
                zzneVar.f39468a = false;
                zznk zznkVar = zzneVar.f39470c;
                if (!zznkVar.x()) {
                    zzgt zzgtVar = zznkVar.f39180a.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.n.a("Connected to service");
                    zzga zzgaVar = this.f39455a;
                    zznkVar.g();
                    Preconditions.checkNotNull(zzgaVar);
                    zznkVar.f39485d = zzgaVar;
                    zznkVar.t();
                    zznkVar.v();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
