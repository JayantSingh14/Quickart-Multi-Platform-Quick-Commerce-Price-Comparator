package com.google.android.play.core.splitinstall;

/* loaded from: classes4.dex */
final class zzw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SplitInstallSessionState f42140a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f42141b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f42142c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzx f42143d;

    public zzw(zzx zzxVar, SplitInstallSessionState splitInstallSessionState, int i2, int i3) {
        this.f42143d = zzxVar;
        this.f42140a = splitInstallSessionState;
        this.f42141b = i2;
        this.f42142c = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zza zzaVar = (zza) this.f42140a;
        this.f42143d.d(new zza(zzaVar.f42072a, this.f42141b, this.f42142c, zzaVar.f42075d, zzaVar.f42076e, zzaVar.f42077f, zzaVar.f42078g, zzaVar.f42079h, zzaVar.f42080i));
    }
}
