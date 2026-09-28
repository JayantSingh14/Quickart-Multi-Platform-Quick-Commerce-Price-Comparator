package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
final class zzf implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzg f43548a;

    public zzf(zzg zzgVar) {
        Objects.requireNonNull(zzgVar);
        this.f43548a = zzgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    public final void a(long j2, Bundle bundle, String str, String str2) {
        if (str == null || zzc.f43541a.contains(str2)) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(CLConstants.FIELD_PAY_INFO_NAME, str2);
        bundle2.putLong("timestampInMillis", j2);
        bundle2.putBundle("params", bundle);
        this.f43548a.f43549a.a(3, bundle2);
    }
}
