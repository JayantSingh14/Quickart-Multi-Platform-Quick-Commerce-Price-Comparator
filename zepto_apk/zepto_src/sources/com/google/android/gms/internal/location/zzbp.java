package com.google.android.gms.internal.location;

import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final class zzbp extends GoogleApi implements FusedLocationProviderClient {

    /* renamed from: a, reason: collision with root package name */
    public static final Api f36637a = new Api("LocationServices.API", new zzbm(), new Api.ClientKey());

    public final Task b() {
        return doRead(TaskApiCall.builder().run(zzbe.f36632a).setMethodKey(2414).build());
    }

    public final Task c(LocationCallback locationCallback) {
        return doUnregisterEventListener(ListenerHolders.createListenerKey(locationCallback, "LocationCallback"), 2418).h(zzbk.f36633a, zzbc.f36631a);
    }

    public final Task d(final LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        if (looper == null) {
            looper = Looper.myLooper();
            Preconditions.checkNotNull(looper, "invalid null looper");
        }
        ListenerHolder listenerHolderCreateListenerHolder = ListenerHolders.createListenerHolder(locationCallback, looper, "LocationCallback");
        final zzbo zzboVar = new zzbo(this, listenerHolderCreateListenerHolder);
        return doRegisterEventListener(RegistrationMethods.builder().register(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzay
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                Api api = zzbp.f36637a;
                ((zzda) obj).h(zzboVar, locationRequest, (TaskCompletionSource) obj2);
            }
        }).unregister(zzboVar).withHolder(listenerHolderCreateListenerHolder).setMethodKey(2436).build());
    }
}
