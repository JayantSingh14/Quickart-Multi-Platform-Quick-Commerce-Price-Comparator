package com.google.android.gms.security;

import android.os.AsyncTask;
import com.amazon.apay.hardened.activity.APayBrowserActivity;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;

/* loaded from: classes4.dex */
final class zza extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ APayBrowserActivity f39715a;

    public zza(APayBrowserActivity aPayBrowserActivity, APayBrowserActivity aPayBrowserActivity2) {
        this.f39715a = aPayBrowserActivity;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            ProviderInstaller.a(this.f39715a);
            return 0;
        } catch (GooglePlayServicesNotAvailableException e2) {
            return Integer.valueOf(e2.errorCode);
        } catch (GooglePlayServicesRepairableException e3) {
            return Integer.valueOf(e3.getConnectionStatusCode());
        }
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            return;
        }
        GoogleApiAvailabilityLight googleApiAvailabilityLight = ProviderInstaller.f39711a;
        ProviderInstaller.f39711a.getErrorResolutionIntent(this.f39715a, num.intValue(), "pi");
    }
}
