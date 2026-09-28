package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzfzj extends zzfzi {

    /* renamed from: i, reason: collision with root package name */
    public static zzfzj f32102i;

    public static final zzfzj f(Context context) {
        zzfzj zzfzjVar;
        synchronized (zzfzj.class) {
            try {
                if (f32102i == null) {
                    f32102i = new zzfzj(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
                }
                zzfzjVar = f32102i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfzjVar;
    }

    public final zzfzf g(long j2, boolean z) {
        zzfzf zzfzfVarA;
        synchronized (zzfzj.class) {
            zzfzfVarA = a(null, null, j2, z);
        }
        return zzfzfVarA;
    }

    public final void h() {
        synchronized (zzfzj.class) {
            c(false);
        }
    }

    public final void i() {
        synchronized (zzfzj.class) {
            c(true);
        }
    }
}
