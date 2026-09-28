package com.google.android.gms.ads;

import com.google.android.gms.ads.internal.client.zzed;

/* loaded from: classes4.dex */
public final class VideoController {

    /* renamed from: a, reason: collision with root package name */
    public final Object f21030a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public zzed f21031b;

    public static abstract class VideoLifecycleCallbacks {
        public void a() {
        }

        public void b() {
        }

        public void c() {
        }
    }

    public final void a(zzed zzedVar) {
        synchronized (this.f21030a) {
            this.f21031b = zzedVar;
        }
    }
}
