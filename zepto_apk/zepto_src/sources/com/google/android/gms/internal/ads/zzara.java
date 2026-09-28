package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzara implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final zzark f24194a;

    /* renamed from: b, reason: collision with root package name */
    public final zzarq f24195b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f24196c;

    public zzara(zzark zzarkVar, zzarq zzarqVar, Runnable runnable) {
        this.f24194a = zzarkVar;
        this.f24195b = zzarqVar;
        this.f24196c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaro zzaroVar;
        zzark zzarkVar = this.f24194a;
        synchronized (zzarkVar.f24217e) {
        }
        zzarq zzarqVar = this.f24195b;
        zzart zzartVar = zzarqVar.f24238c;
        if (zzartVar == null) {
            zzarkVar.l(zzarqVar.f24236a);
        } else {
            synchronized (zzarkVar.f24217e) {
                zzaroVar = zzarkVar.f24218f;
            }
            zzaroVar.a(zzartVar);
        }
        if (zzarqVar.f24239d) {
            zzarkVar.a("intermediate-response");
        } else {
            zzarkVar.b("done");
        }
        Runnable runnable = this.f24196c;
        if (runnable != null) {
            ((zzaqv) runnable).run();
        }
    }
}
