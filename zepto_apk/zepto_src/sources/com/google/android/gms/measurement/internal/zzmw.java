package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzmw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39449a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39450b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39451c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzr f39452d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f39453e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zznk f39454f;

    public zzmw(zznk zznkVar, AtomicReference atomicReference, String str, String str2, zzr zzrVar, boolean z) {
        this.f39449a = atomicReference;
        this.f39450b = str;
        this.f39451c = str2;
        this.f39452d = zzrVar;
        this.f39453e = z;
        this.f39454f = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznk zznkVar;
        zzga zzgaVar;
        AtomicReference atomicReference2 = this.f39449a;
        synchronized (atomicReference2) {
            try {
                try {
                    zznkVar = this.f39454f;
                    zzgaVar = zznkVar.f39485d;
                } catch (RemoteException e2) {
                    zzgt zzgtVar = this.f39454f.f39180a.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.f38958f.d("(legacy) Failed to get user properties; remote exception", null, this.f39450b, e2);
                    this.f39449a.set(Collections.EMPTY_LIST);
                    atomicReference = this.f39449a;
                }
                if (zzgaVar == null) {
                    zzgt zzgtVar2 = zznkVar.f39180a.f39089f;
                    zzib.l(zzgtVar2);
                    zzgtVar2.f38958f.d("(legacy) Failed to get user properties; not connected to service", null, this.f39450b, this.f39451c);
                    atomicReference2.set(Collections.EMPTY_LIST);
                    atomicReference2.notify();
                    return;
                }
                if (TextUtils.isEmpty(null)) {
                    zzr zzrVar = this.f39452d;
                    Preconditions.checkNotNull(zzrVar);
                    atomicReference2.set(zzgaVar.fb(this.f39450b, this.f39451c, this.f39453e, zzrVar));
                } else {
                    atomicReference2.set(zzgaVar.z1(null, this.f39450b, this.f39451c, this.f39453e));
                }
                zznkVar.t();
                atomicReference = this.f39449a;
                atomicReference.notify();
            } catch (Throwable th) {
                this.f39449a.notify();
                throw th;
            }
        }
    }
}
