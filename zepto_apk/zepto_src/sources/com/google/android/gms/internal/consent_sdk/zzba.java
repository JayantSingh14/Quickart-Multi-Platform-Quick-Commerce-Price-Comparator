package com.google.android.gms.internal.consent_sdk;

import android.util.Log;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* loaded from: classes4.dex */
final class zzba implements UserMessagingPlatform.OnConsentFormLoadSuccessListener, UserMessagingPlatform.OnConsentFormLoadFailureListener {
    public final void a(FormError formError) {
        Log.e("UserMessagingPlatform", "Failed to load and cache a form, error=".concat(String.valueOf(formError.f42225a)));
    }

    public final void b(ConsentForm consentForm) {
        throw null;
    }
}
