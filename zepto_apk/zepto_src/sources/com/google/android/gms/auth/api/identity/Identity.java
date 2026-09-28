package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbap;

/* loaded from: classes4.dex */
public final class Identity {
    public static zbap a(Activity activity) {
        return new zbap((Activity) Preconditions.checkNotNull(activity), new zbs());
    }
}
