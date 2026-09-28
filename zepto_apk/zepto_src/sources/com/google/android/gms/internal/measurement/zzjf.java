package com.google.android.gms.internal.measurement;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class zzjf {

    /* renamed from: a, reason: collision with root package name */
    public static final zzjl f36985a;

    static {
        zzjl zzjlVar;
        Uri uri = zzjg.f36986a;
        synchronized (zzji.class) {
            try {
                if (zzji.f36989a == null) {
                    zzjl zzjlVar2 = new zzjl();
                    synchronized (zzji.class) {
                        if (zzji.f36989a != null) {
                            throw new IllegalStateException("init() already called");
                        }
                        zzji.f36989a = zzjlVar2;
                    }
                }
                zzjlVar = zzji.f36989a;
            } catch (Throwable th) {
                throw th;
            }
        }
        f36985a = zzjlVar;
    }
}
