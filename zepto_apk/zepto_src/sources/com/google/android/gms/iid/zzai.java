package com.google.android.gms.iid;

/* loaded from: classes4.dex */
public abstract class zzai {

    /* renamed from: a, reason: collision with root package name */
    public static zzai f22556a;

    public static synchronized zzai b() {
        try {
            if (f22556a == null) {
                f22556a = new zzac();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f22556a;
    }

    public abstract zzaj a();
}
