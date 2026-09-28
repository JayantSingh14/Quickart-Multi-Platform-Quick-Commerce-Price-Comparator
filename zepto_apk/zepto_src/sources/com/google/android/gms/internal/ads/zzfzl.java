package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzfzl {

    /* renamed from: b, reason: collision with root package name */
    public static zzfzl f32104b;

    /* renamed from: a, reason: collision with root package name */
    public final zzfzh f32105a;

    public zzfzl(Context context) {
        if (zzfzh.f32091c == null) {
            zzfzh.f32091c = new zzfzh(context);
        }
        this.f32105a = zzfzh.f32091c;
        zzfzg.a(context);
    }

    public static final zzfzl a(Context context) {
        zzfzl zzfzlVar;
        synchronized (zzfzl.class) {
            try {
                if (f32104b == null) {
                    f32104b = new zzfzl(context);
                }
                zzfzlVar = f32104b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfzlVar;
    }

    public final void b() {
        synchronized (zzfzl.class) {
            zzfzh zzfzhVar = this.f32105a;
            zzfzhVar.b("vendor_scoped_gpid_v2_id");
            zzfzhVar.b("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
