package com.google.android.gms.measurement.internal;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
final class zzkj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f39258a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f39259b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f39260c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzli f39261d;

    public zzkj(zzli zzliVar, AtomicReference atomicReference, String str, String str2) {
        this.f39258a = atomicReference;
        this.f39259b = str;
        this.f39260c = str2;
        Objects.requireNonNull(zzliVar);
        this.f39261d = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznk zznkVarO = this.f39261d.f39180a.o();
        zznkVarO.g();
        zznkVarO.h();
        zznkVarO.u(new zzmu(zznkVarO, this.f39258a, this.f39259b, this.f39260c, zznkVarO.w(false)));
    }
}
