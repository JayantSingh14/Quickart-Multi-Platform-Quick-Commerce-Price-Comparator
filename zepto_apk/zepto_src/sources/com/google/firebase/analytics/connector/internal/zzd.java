package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.measurement.internal.zzjl;
import com.google.android.gms.measurement.internal.zzls;
import com.google.common.collect.ImmutableSet;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzd implements AppMeasurementSdk.OnEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zze f43545a;

    public zzd(zze zzeVar) {
        Objects.requireNonNull(zzeVar);
        this.f43545a = zzeVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    public final void a(long j2, Bundle bundle, String str, String str2) {
        zze zzeVar = this.f43545a;
        if (zzeVar.f43546a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            ImmutableSet immutableSet = zzc.f43541a;
            String strB = zzls.b(str2, zzjl.f39203c, zzjl.f39201a);
            if (strB != null) {
                str2 = strB;
            }
            bundle2.putString("events", str2);
            zzeVar.f43547b.a(2, bundle2);
        }
    }
}
