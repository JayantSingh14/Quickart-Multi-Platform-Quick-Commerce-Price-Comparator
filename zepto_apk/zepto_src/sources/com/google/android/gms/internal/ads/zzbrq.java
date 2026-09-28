package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class zzbrq extends zzcea {

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzbc f25485d;

    /* renamed from: c, reason: collision with root package name */
    public final Object f25484c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public boolean f25486e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f25487f = 0;

    public zzbrq(com.google.android.gms.ads.internal.util.zzbc zzbcVar) {
        this.f25485d = zzbcVar;
    }

    public final zzbrl d() {
        zzbrl zzbrlVar = new zzbrl(this);
        com.google.android.gms.ads.internal.util.zze.k("createNewReference: Trying to acquire lock");
        synchronized (this.f25484c) {
            com.google.android.gms.ads.internal.util.zze.k("createNewReference: Lock acquired");
            a(new zzbrm(this, zzbrlVar), new zzbrn(this, zzbrlVar));
            Preconditions.checkState(this.f25487f >= 0);
            this.f25487f++;
        }
        com.google.android.gms.ads.internal.util.zze.k("createNewReference: Lock released");
        return zzbrlVar;
    }

    public final void e() {
        com.google.android.gms.ads.internal.util.zze.k("releaseOneReference: Trying to acquire lock");
        synchronized (this.f25484c) {
            com.google.android.gms.ads.internal.util.zze.k("releaseOneReference: Lock acquired");
            Preconditions.checkState(this.f25487f > 0);
            com.google.android.gms.ads.internal.util.zze.k("Releasing 1 reference for JS Engine");
            this.f25487f--;
            g();
        }
        com.google.android.gms.ads.internal.util.zze.k("releaseOneReference: Lock released");
    }

    public final void f() {
        com.google.android.gms.ads.internal.util.zze.k("markAsDestroyable: Trying to acquire lock");
        synchronized (this.f25484c) {
            com.google.android.gms.ads.internal.util.zze.k("markAsDestroyable: Lock acquired");
            Preconditions.checkState(this.f25487f >= 0);
            com.google.android.gms.ads.internal.util.zze.k("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.f25486e = true;
            g();
        }
        com.google.android.gms.ads.internal.util.zze.k("markAsDestroyable: Lock released");
    }

    public final void g() {
        com.google.android.gms.ads.internal.util.zze.k("maybeDestroy: Trying to acquire lock");
        synchronized (this.f25484c) {
            try {
                com.google.android.gms.ads.internal.util.zze.k("maybeDestroy: Lock acquired");
                Preconditions.checkState(this.f25487f >= 0);
                if (this.f25486e && this.f25487f == 0) {
                    com.google.android.gms.ads.internal.util.zze.k("No reference is left (including root). Cleaning up engine.");
                    a(new zzbrp(), new zzcdw());
                } else {
                    com.google.android.gms.ads.internal.util.zze.k("There are still references to the engine. Not destroying.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.k("maybeDestroy: Lock released");
    }
}
