package com.google.android.gms.internal.identity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class zzd extends zzf {

    /* renamed from: a, reason: collision with root package name */
    public Activity f36618a;

    public final void z0(int i2, Bundle bundle) {
        PendingIntent pendingIntentCreatePendingResult;
        if (i2 == 1) {
            Intent intent = new Intent();
            intent.putExtras(bundle);
            Activity activity = this.f36618a;
            if (activity == null || (pendingIntentCreatePendingResult = activity.createPendingResult(0, intent, 1073741824)) == null) {
                return;
            }
            try {
                pendingIntentCreatePendingResult.send(1);
                return;
            } catch (PendingIntent.CanceledException e2) {
                Log.w("AddressClientImpl", "Exception settng pending result", e2);
                return;
            }
        }
        ConnectionResult connectionResult = new ConnectionResult(i2, bundle != null ? (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT") : null);
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult((Activity) Preconditions.checkNotNull(this.f36618a), 0);
                return;
            } catch (IntentSender.SendIntentException e3) {
                Log.w("AddressClientImpl", "Exception starting pending intent", e3);
                return;
            }
        }
        try {
            PendingIntent pendingIntentCreatePendingResult2 = ((Activity) Preconditions.checkNotNull(this.f36618a)).createPendingResult(0, new Intent(), 1073741824);
            if (pendingIntentCreatePendingResult2 != null) {
                pendingIntentCreatePendingResult2.send(1);
            }
        } catch (PendingIntent.CanceledException e4) {
            Log.w("AddressClientImpl", "Exception setting pending result", e4);
        }
    }
}
