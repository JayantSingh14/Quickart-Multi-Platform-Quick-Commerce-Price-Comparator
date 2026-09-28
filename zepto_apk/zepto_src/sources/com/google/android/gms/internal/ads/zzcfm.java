package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzcfm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final zzcey f26111a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f26112b = false;

    public zzcfm(zzcey zzceyVar) {
        this.f26111a = zzceyVar;
    }

    public final void a() {
        this.f26112b = true;
        this.f26111a.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f26112b) {
            return;
        }
        this.f26111a.b();
        com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.f21608l;
        zzfVar.removeCallbacks(this);
        zzfVar.postDelayed(this, 250L);
    }
}
