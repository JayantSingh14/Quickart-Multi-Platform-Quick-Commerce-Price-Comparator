package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes4.dex */
public final class zzfzg {

    /* renamed from: b, reason: collision with root package name */
    public static zzfzg f32089b;

    /* renamed from: a, reason: collision with root package name */
    public final zzfzh f32090a;

    public zzfzg(Context context) {
        if (zzfzh.f32091c == null) {
            zzfzh.f32091c = new zzfzh(context);
        }
        this.f32090a = zzfzh.f32091c;
    }

    public static final zzfzg a(Context context) {
        zzfzg zzfzgVar;
        synchronized (zzfzg.class) {
            try {
                if (f32089b == null) {
                    f32089b = new zzfzg(context);
                }
                zzfzgVar = f32089b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzfzgVar;
    }

    public final void b(boolean z) {
        synchronized (zzfzg.class) {
            try {
                zzfzh zzfzhVar = this.f32090a;
                zzfzhVar.a(Boolean.valueOf(z), "paidv2_publisher_option");
                if (!z) {
                    zzfzhVar.b("paidv2_creation_time");
                    zzfzhVar.b("paidv2_id");
                    zzfzhVar.b("vendor_scoped_gpid_v2_id");
                    zzfzhVar.b("vendor_scoped_gpid_v2_creation_time");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
