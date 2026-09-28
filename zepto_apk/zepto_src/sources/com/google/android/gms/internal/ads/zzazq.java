package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes4.dex */
final class zzazq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzazt f24554a;

    public zzazq(zzazt zzaztVar) {
        this.f24554a = zzaztVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzazt zzaztVar = this.f24554a;
        zzaztVar.getClass();
        try {
            if (zzaztVar.f24563f == null && zzaztVar.f24564g) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(zzaztVar.f24558a);
                advertisingIdClient.d(true);
                zzaztVar.f24563f = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            zzaztVar.f24563f = null;
        }
    }
}
