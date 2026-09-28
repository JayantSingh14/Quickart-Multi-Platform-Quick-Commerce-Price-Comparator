package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolders;

/* loaded from: classes4.dex */
final class zzap extends zzat {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzda) anyClient).d(ListenerHolders.createListenerKey(null, "LocationCallback"), true, zzau.a(this));
    }
}
