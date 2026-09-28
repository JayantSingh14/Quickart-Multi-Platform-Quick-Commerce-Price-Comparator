package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class zzmh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39404a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzr f39405b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zznk f39406c;

    public zzmh(zznk zznkVar, AtomicReference atomicReference, zzr zzrVar) {
        this.f39404a = atomicReference;
        this.f39405b = zzrVar;
        Objects.requireNonNull(zznkVar);
        this.f39406c = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznk zznkVar;
        zzib zzibVar;
        zzhg zzhgVar;
        AtomicReference atomicReference2 = this.f39404a;
        synchronized (atomicReference2) {
            try {
                try {
                    zznkVar = this.f39406c;
                    zzibVar = zznkVar.f39180a;
                    zzhgVar = zzibVar.f39088e;
                    zzib.j(zzhgVar);
                } catch (RemoteException e2) {
                    zzgt zzgtVar = this.f39406c.f39180a.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.f38958f.b(e2, "Failed to get app instance id");
                    atomicReference = this.f39404a;
                }
                if (zzhgVar.n().i(zzjj.ANALYTICS_STORAGE)) {
                    zzga zzgaVar = zznkVar.f39485d;
                    if (zzgaVar != null) {
                        zzr zzrVar = this.f39405b;
                        Preconditions.checkNotNull(zzrVar);
                        atomicReference2.set(zzgaVar.j6(zzrVar));
                        String str = (String) atomicReference2.get();
                        if (str != null) {
                            zzli zzliVar = zznkVar.f39180a.f39096m;
                            zzib.k(zzliVar);
                            zzliVar.f39319g.set(str);
                            zzhg zzhgVar2 = zzibVar.f39088e;
                            zzib.j(zzhgVar2);
                            zzhgVar2.f39026g.b(str);
                        }
                        zznkVar.t();
                        atomicReference = this.f39404a;
                        atomicReference.notify();
                        return;
                    }
                    zzgt zzgtVar2 = zzibVar.f39089f;
                    zzib.l(zzgtVar2);
                    zzgtVar2.f38958f.a("Failed to get app instance id");
                    atomicReference2.notify();
                } else {
                    zzgt zzgtVar3 = zzibVar.f39089f;
                    zzib.l(zzgtVar3);
                    zzgtVar3.f38963k.a("Analytics storage consent denied; will not get app instance id");
                    zzli zzliVar2 = zznkVar.f39180a.f39096m;
                    zzib.k(zzliVar2);
                    zzliVar2.f39319g.set(null);
                    zzhg zzhgVar3 = zzibVar.f39088e;
                    zzib.j(zzhgVar3);
                    zzhgVar3.f39026g.b(null);
                    atomicReference2.set(null);
                    atomicReference2.notify();
                }
            } catch (Throwable th) {
                this.f39404a.notify();
                throw th;
            }
        }
    }
}
