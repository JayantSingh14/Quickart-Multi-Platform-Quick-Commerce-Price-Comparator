package com.google.android.gms.ads;

import android.app.IntentService;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbsv;

@KeepForSdk
/* loaded from: classes4.dex */
public class AdService extends IntentService {
    public AdService() {
        super("AdService");
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) {
        try {
            zzbb.f21141g.f21143b.j(this, new zzbsv()).q1(intent);
        } catch (RemoteException e2) {
            zzo.c("RemoteException calling handleNotificationIntent: ".concat(e2.toString()));
        }
    }
}
