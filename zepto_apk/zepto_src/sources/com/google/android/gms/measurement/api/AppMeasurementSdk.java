package com.google.android.gms.measurement.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzjo;
import com.google.android.gms.measurement.internal.zzjp;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class AppMeasurementSdk {

    /* renamed from: a, reason: collision with root package name */
    public final zzfb f38652a;

    @KeepForSdk
    /* loaded from: classes4.dex */
    public static final class ConditionalUserProperty {
    }

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes4.dex */
    public interface EventInterceptor extends zzjo {
    }

    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzjp {
    }

    public AppMeasurementSdk(zzfb zzfbVar) {
        this.f38652a = zzfbVar;
    }
}
