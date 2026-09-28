package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzkh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f39254a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39255b;

    public zzkh(zzli zzliVar, Bundle bundle) {
        this.f39254a = bundle;
        Objects.requireNonNull(zzliVar);
        this.f39255b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.f39255b;
        zzliVar.g();
        zzliVar.h();
        Bundle bundle = this.f39254a;
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString(CLConstants.FIELD_PAY_INFO_NAME);
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get(CLConstants.FIELD_PAY_INFO_VALUE));
        zzib zzibVar = zzliVar.f39180a;
        if (!zzibVar.a()) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzpk zzpkVar = new zzpk(bundle.getLong("triggered_timestamp"), bundle.get(CLConstants.FIELD_PAY_INFO_VALUE), string, string2);
        try {
            zzpo zzpoVar = zzibVar.f39092i;
            zzib.j(zzpoVar);
            bundle.getString("app_id");
            zzbg zzbgVarH = zzpoVar.H(bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true);
            zzib.j(zzpoVar);
            bundle.getString("app_id");
            zzbg zzbgVarH2 = zzpoVar.H(bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true);
            bundle.getString("app_id");
            zzibVar.o().z(new zzah(bundle.getString("app_id"), string2, zzpkVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzbgVarH2, bundle.getLong("trigger_timeout"), zzbgVarH, bundle.getLong("time_to_live"), zzpoVar.H(bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
