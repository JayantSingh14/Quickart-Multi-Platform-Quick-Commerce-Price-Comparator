package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzw f39814a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callable f39815b;

    public zzz(zzw zzwVar, Callable callable) {
        this.f39814a = zzwVar;
        this.f39815b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzw zzwVar = this.f39814a;
        try {
            zzwVar.t(this.f39815b.call());
        } catch (Exception e2) {
            zzwVar.s(e2);
        } catch (Throwable th) {
            zzwVar.s(new RuntimeException(th));
        }
    }
}
