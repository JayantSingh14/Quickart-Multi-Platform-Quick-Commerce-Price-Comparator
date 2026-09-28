package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzmu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39439a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39440b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39441c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzr f39442d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zznk f39443e;

    public zzmu(zznk zznkVar, AtomicReference atomicReference, String str, String str2, zzr zzrVar) {
        this.f39439a = atomicReference;
        this.f39440b = str;
        this.f39441c = str2;
        this.f39442d = zzrVar;
        this.f39443e = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznk zznkVar;
        zzga zzgaVar;
        AtomicReference atomicReference2 = this.f39439a;
        synchronized (atomicReference2) {
            try {
                try {
                    zznkVar = this.f39443e;
                    zzgaVar = zznkVar.f39485d;
                } catch (RemoteException e2) {
                    zzgt zzgtVar = this.f39443e.f39180a.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.f38958f.d("(legacy) Failed to get conditional properties; remote exception", null, this.f39440b, e2);
                    this.f39439a.set(Collections.EMPTY_LIST);
                    atomicReference = this.f39439a;
                }
                if (zzgaVar == null) {
                    zzgt zzgtVar2 = zznkVar.f39180a.f39089f;
                    zzib.l(zzgtVar2);
                    zzgtVar2.f38958f.d("(legacy) Failed to get conditional properties; not connected to service", null, this.f39440b, this.f39441c);
                    atomicReference2.set(Collections.EMPTY_LIST);
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    zzr zzrVar = this.f39442d;
                    Preconditions.checkNotNull(zzrVar);
                    atomicReference2.set(zzgaVar.pb(this.f39440b, this.f39441c, zzrVar));
                } else {
                    atomicReference2.set(zzgaVar.Z2(null, this.f39440b, this.f39441c));
                }
                zznkVar.t();
                atomicReference = this.f39439a;
                atomicReference.notify();
            } catch (Throwable th) {
                this.f39439a.notify();
                throw th;
            }
        }
    }
}
