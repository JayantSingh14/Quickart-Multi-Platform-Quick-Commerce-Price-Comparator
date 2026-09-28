package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzarb {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f24197a;

    public zzarb(Handler handler) {
        this.f24197a = new zzaqz(this, handler);
    }

    public final void a(zzark zzarkVar, zzarq zzarqVar, Runnable runnable) {
        synchronized (zzarkVar.f24217e) {
            zzarkVar.f24221i = true;
        }
        zzarkVar.a("post-response");
        ((zzaqz) this.f24197a).f24192a.post(new zzara(zzarkVar, zzarqVar, runnable));
    }
}
