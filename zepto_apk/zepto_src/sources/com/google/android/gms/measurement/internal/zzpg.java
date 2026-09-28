package com.google.android.gms.measurement.internal;

import android.app.Service;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzpg {

    /* renamed from: a, reason: collision with root package name */
    public final Context f39607a;

    public zzpg(Service service) {
        Preconditions.checkNotNull(service);
        Context applicationContext = service.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f39607a = applicationContext;
    }
}
