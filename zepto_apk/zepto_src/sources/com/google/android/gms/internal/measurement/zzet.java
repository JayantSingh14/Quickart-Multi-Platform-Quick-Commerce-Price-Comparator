package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class zzet extends zzeq {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bundle f36922e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Activity f36923f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ zzfa f36924g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzet(zzfa zzfaVar, Bundle bundle, Activity activity) {
        super(zzfaVar.f36942a, true);
        this.f36922e = bundle;
        this.f36923f = activity;
        this.f36924g = zzfaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeq
    public final void a() {
        Bundle bundle;
        Bundle bundle2 = this.f36922e;
        if (bundle2 != null) {
            bundle = new Bundle();
            if (bundle2.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = bundle2.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        zzcr zzcrVar = (zzcr) Preconditions.checkNotNull(this.f36924g.f36942a.f36950g);
        Activity activity = this.f36923f;
        zzcrVar.onActivityCreatedByScionActivityInfo(zzdf.b(activity), bundle, this.f36918b);
    }
}
