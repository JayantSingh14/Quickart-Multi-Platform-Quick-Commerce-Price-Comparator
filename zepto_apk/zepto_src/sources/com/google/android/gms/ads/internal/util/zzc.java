package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* loaded from: classes4.dex */
final class zzc extends zzb {

    /* renamed from: b, reason: collision with root package name */
    public final Context f21554b;

    public zzc(Context context) {
        this.f21554b = context;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void a() {
        boolean zB;
        try {
            zB = AdvertisingIdClient.b(this.f21554b);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e2) {
            int i2 = zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.d("Fail to get isAdIdFakeForDebugLogging", e2);
            zB = false;
        }
        synchronized (com.google.android.gms.ads.internal.util.client.zzl.f21429b) {
            com.google.android.gms.ads.internal.util.client.zzl.f21430c = true;
            com.google.android.gms.ads.internal.util.client.zzl.f21431d = zB;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(zB).length() + 38);
        sb.append("Update ad debug logging enablement as ");
        sb.append(zB);
        String string = sb.toString();
        int i3 = zze.f21576b;
        com.google.android.gms.ads.internal.util.client.zzo.f(string);
    }
}
