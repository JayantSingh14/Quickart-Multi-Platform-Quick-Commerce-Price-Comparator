package com.google.android.gms.auth.api.signin.internal;

import android.os.Binder;
import android.support.v4.media.b;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import com.google.android.gms.common.util.UidVerifier;

/* loaded from: classes4.dex */
public final class zbt extends zbo {

    /* renamed from: a, reason: collision with root package name */
    public final RevocationBoundService f22219a;

    public zbt(RevocationBoundService revocationBoundService) {
        this.f22219a = revocationBoundService;
    }

    public final void z0() {
        if (!UidVerifier.isGooglePlayServicesUid(this.f22219a, Binder.getCallingUid())) {
            throw new SecurityException(b.g(Binder.getCallingUid(), "Calling UID ", " is not Google Play services."));
        }
    }
}
