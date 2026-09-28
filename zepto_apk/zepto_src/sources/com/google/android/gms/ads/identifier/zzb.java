package com.google.android.gms.ads.identifier;

import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzb extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f21073a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21074b;

    /* renamed from: c, reason: collision with root package name */
    public final CountDownLatch f21075c = new CountDownLatch(1);

    /* renamed from: d, reason: collision with root package name */
    public boolean f21076d = false;

    public zzb(AdvertisingIdClient advertisingIdClient, long j2) {
        this.f21073a = new WeakReference(advertisingIdClient);
        this.f21074b = j2;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        AdvertisingIdClient advertisingIdClient;
        WeakReference weakReference = this.f21073a;
        try {
            if (this.f21075c.await(this.f21074b, TimeUnit.MILLISECONDS) || (advertisingIdClient = (AdvertisingIdClient) weakReference.get()) == null) {
                return;
            }
            advertisingIdClient.c();
            this.f21076d = true;
        } catch (InterruptedException unused) {
            AdvertisingIdClient advertisingIdClient2 = (AdvertisingIdClient) weakReference.get();
            if (advertisingIdClient2 != null) {
                advertisingIdClient2.c();
                this.f21076d = true;
            }
        }
    }
}
