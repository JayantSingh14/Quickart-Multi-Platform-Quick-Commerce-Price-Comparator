package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes4.dex */
final class zzccr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f25891a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcdt f25892b;

    public zzccr(zzccs zzccsVar, Context context, zzcdt zzcdtVar) {
        this.f25891a = context;
        this.f25892b = zzcdtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcdt zzcdtVar = this.f25892b;
        try {
            zzcdtVar.b(AdvertisingIdClient.a(this.f25891a));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            zzcdtVar.c(e2);
            com.google.android.gms.ads.internal.util.client.zzo.d("Exception while getting advertising Id info", e2);
        }
    }
}
