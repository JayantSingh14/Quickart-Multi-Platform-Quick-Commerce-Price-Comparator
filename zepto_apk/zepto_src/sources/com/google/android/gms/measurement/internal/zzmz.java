package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
final class zzmz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzga f39459a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzne f39460b;

    public zzmz(zzne zzneVar, zzga zzgaVar) {
        this.f39459a = zzgaVar;
        this.f39460b = zzneVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzne zzneVar = this.f39460b;
        synchronized (zzneVar) {
            try {
                zzneVar.f39468a = false;
                zznk zznkVar = zzneVar.f39470c;
                if (!zznkVar.x()) {
                    zzgt zzgtVar = zznkVar.f39180a.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.f38965m.a("Connected to remote service");
                    zzga zzgaVar = this.f39459a;
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
        zznk zznkVar2 = this.f39460b.f39470c;
        ScheduledExecutorService scheduledExecutorService = zznkVar2.f39488g;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            zznkVar2.f39488g = null;
        }
    }
}
