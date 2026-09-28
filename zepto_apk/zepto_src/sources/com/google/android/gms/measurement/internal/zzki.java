package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
final class zzki implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f39256a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzli f39257b;

    public zzki(zzli zzliVar, Bundle bundle) {
        this.f39256a = bundle;
        Objects.requireNonNull(zzliVar);
        this.f39257b = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzli zzliVar = this.f39257b;
        zzliVar.g();
        zzliVar.h();
        Bundle bundle = this.f39256a;
        Preconditions.checkNotNull(bundle);
        String strCheckNotEmpty = Preconditions.checkNotEmpty(bundle.getString(CLConstants.FIELD_PAY_INFO_NAME));
        zzib zzibVar = zzliVar.f39180a;
        if (!zzibVar.a()) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.n.a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzpk zzpkVar = new zzpk(0L, null, strCheckNotEmpty, "");
        try {
            zzpo zzpoVar = zzibVar.f39092i;
            zzib.j(zzpoVar);
            bundle.getString("app_id");
            zzibVar.o().z(new zzah(bundle.getString("app_id"), "", zzpkVar, bundle.getLong("creation_timestamp"), bundle.getBoolean(AppStateModule.APP_STATE_ACTIVE), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), zzpoVar.H(bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
