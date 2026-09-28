package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzfzk extends zzfzi {

    /* renamed from: i, reason: collision with root package name */
    public static zzfzk f32103i;

    public static final zzfzk f(Context context) {
        zzfzk zzfzkVar;
        synchronized (zzfzk.class) {
            try {
                if (f32103i == null) {
                    f32103i = new zzfzk(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
                }
                zzfzkVar = f32103i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfzkVar;
    }

    public final zzfzf g(long j2, boolean z) {
        boolean z2;
        synchronized (zzfzk.class) {
            try {
                zzfzg zzfzgVar = this.f32101g;
                zzfzgVar.getClass();
                synchronized (zzfzg.class) {
                    z2 = zzfzgVar.f32090a.f32093b.getBoolean("paidv2_publisher_option", true);
                }
                if (z2) {
                    return a(null, null, j2, z);
                }
                return new zzfzf();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (zzfzk.class) {
            try {
                if (this.f32100f.f32093b.contains(this.f32095a)) {
                    c(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
