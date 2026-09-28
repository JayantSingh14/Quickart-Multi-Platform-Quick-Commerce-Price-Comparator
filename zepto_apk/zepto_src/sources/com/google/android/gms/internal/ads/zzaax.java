package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzaax implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final zzaaw f22621a;

    public zzaax(zzaaw zzaawVar) {
        this.f22621a = zzaawVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzxk zzxkVar = (zzxk) this.f22621a;
        for (zzxv zzxvVar : zzxkVar.r) {
            zzxvVar.k(true);
            if (zzxvVar.f35877g != null) {
                zzxvVar.f35877g = null;
                zzxvVar.f35876f = null;
            }
        }
        zzxkVar.f35841k.zzb();
    }
}
