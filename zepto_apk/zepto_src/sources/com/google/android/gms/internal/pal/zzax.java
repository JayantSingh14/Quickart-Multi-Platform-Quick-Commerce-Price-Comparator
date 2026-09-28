package com.google.android.gms.internal.pal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public final class zzax extends zzbg {

    /* renamed from: e, reason: collision with root package name */
    public final Context f37528e;

    public zzax(Handler handler, ExecutorService executorService, Context context) {
        super(handler, executorService, zzagc.b(2L));
        this.f37528e = context;
    }

    @Override // com.google.android.gms.internal.pal.zzbg
    public final zzil a() {
        zzil zziqVar;
        Context context = this.f37528e;
        boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
        zzif zzifVar = zzif.f37811a;
        if (zHasSystemFeature) {
            try {
                ContentResolver contentResolver = context.getContentResolver();
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                boolean z = true;
                if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 1) {
                    z = false;
                }
                zziqVar = new zziq(new zzaz(string, "afai", z));
            } catch (Settings.SettingNotFoundException e2) {
                Log.e("NonceGenerator", "Failed to retrieve advertising info from amazon fire tv.", e2);
            }
        } else {
            zziqVar = zzifVar;
        }
        if (zziqVar.d()) {
            return zziqVar;
        }
        try {
            AdvertisingIdClient.Info infoA = AdvertisingIdClient.a(context);
            String str = infoA.f21070a;
            if (str == null) {
                str = "";
            }
            return new zziq(new zzaz(str, "adid", infoA.f21071b));
        } catch (GooglePlayServicesNotAvailableException e3) {
            Log.e("NonceGenerator", "Google Play services is not available entirely.", e3);
            return zzifVar;
        } catch (GooglePlayServicesRepairableException e4) {
            Log.e("NonceGenerator", "Obsolete or disabled version of Google Play Services", e4);
            return zzifVar;
        } catch (IOException e5) {
            Log.e("NonceGenerator", "Unrecoverable error connecting to Google Play services.", e5);
            return zzifVar;
        } catch (IllegalStateException e6) {
            Log.e("NonceGenerator", "IllegalStateException, can't access android advertising info.", e6);
            return zzifVar;
        }
    }
}
