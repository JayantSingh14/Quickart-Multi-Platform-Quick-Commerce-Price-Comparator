package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes4.dex */
public final class zzdum {

    /* renamed from: a, reason: collision with root package name */
    public final zzfza f28596a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f28597b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f28598c = new AtomicBoolean(false);

    public zzdum(zzfza zzfzaVar) {
        this.f28596a = zzfzaVar;
    }

    public final void a(zzbdf zzbdfVar) {
        this.f28598c.set(true);
        synchronized (zzbdfVar.f24770a) {
            try {
                if (zzbdfVar.f24771b == null) {
                    zzbdfVar.f24771b = new zzbdd();
                }
                zzbdd zzbddVar = zzbdfVar.f24771b;
                synchronized (zzbddVar.f24762c) {
                    zzbddVar.f24766g.add(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzfza zzfzaVar = this.f28596a;
        zzfzaVar.getClass();
        BuildersKt.c(zzfzaVar.f32075a, null, new zzfyv(zzfzaVar, null), 3);
    }
}
