package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;

/* loaded from: classes4.dex */
final class zzcu implements ListenerHolder.Notifier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationAvailability f36654a;

    public zzcu(LocationAvailability locationAvailability) {
        this.f36654a = locationAvailability;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((LocationCallback) obj).a(this.f36654a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
