package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
final class zzcj extends LocationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f36642a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzda f36643b;

    public zzcj(zzda zzdaVar, TaskCompletionSource taskCompletionSource) {
        this.f36643b = zzdaVar;
        this.f36642a = taskCompletionSource;
    }

    @Override // com.google.android.gms.location.LocationCallback
    public final void b(LocationResult locationResult) {
        this.f36642a.d(locationResult.b());
        try {
            this.f36643b.d(ListenerHolders.createListenerKey(this, "GetCurrentLocation"), false, new TaskCompletionSource());
        } catch (RemoteException unused) {
        }
    }
}
