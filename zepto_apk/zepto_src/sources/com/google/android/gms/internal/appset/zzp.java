package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* loaded from: classes4.dex */
public final class zzp extends GoogleApi<Api.ApiOptions.NoOptions> implements AppSetIdClient {

    /* renamed from: c, reason: collision with root package name */
    public static final Api f36018c = new Api("AppSet.API", new zzn(), new Api.ClientKey());

    /* renamed from: a, reason: collision with root package name */
    public final Context f36019a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleApiAvailabilityLight f36020b;

    public zzp(Context context, GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        super(context, (Api<Api.ApiOptions.NoOptions>) f36018c, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.f36019a = context;
        this.f36020b = googleApiAvailabilityLight;
    }

    @Override // com.google.android.gms.appset.AppSetIdClient
    public final Task a() {
        return this.f36020b.isGooglePlayServicesAvailable(this.f36019a, 212800000) == 0 ? doRead(TaskApiCall.builder().setFeatures(com.google.android.gms.appset.zze.f22000a).run(new zzm()).setAutoResolveMissingFeatures(false).setMethodKey(27601).build()) : Tasks.d(new ApiException(new Status(17)));
    }
}
