package com.google.android.gms.internal.pal;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes4.dex */
final class zzdr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdu f37630a;

    public zzdr(zzdu zzduVar) {
        this.f37630a = zzduVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdu zzduVar = this.f37630a;
        zzduVar.getClass();
        try {
            if (zzduVar.f37639f == null && zzduVar.f37642i) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(zzduVar.f37634a);
                advertisingIdClient.d(true);
                zzduVar.f37639f = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            zzduVar.f37639f = null;
        }
    }
}
