package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbwr;

@KeepForSdk
/* loaded from: classes4.dex */
public final class NotificationHandlerActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            zzbwr zzbwrVarJ = zzbb.f21141g.f21143b.j(this, new zzbsv());
            if (zzbwrVarJ == null) {
                zzo.c("OfflineUtils is null");
            } else {
                zzbwrVarJ.q1(getIntent());
            }
        } catch (RemoteException e2) {
            zzo.c("RemoteException calling handleNotificationIntent: ".concat(e2.toString()));
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        finish();
    }
}
