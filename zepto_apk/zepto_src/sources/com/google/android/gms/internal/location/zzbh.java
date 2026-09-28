package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzbh implements RemoteCall {
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzda zzdaVar = (zzda) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        Api api = zzbp.f36637a;
        zzdaVar.getContext();
        if (zzdaVar.f(com.google.android.gms.location.zzm.f38385a)) {
            ((zzo) zzdaVar.getService()).c5(new zzcm(taskCompletionSource));
        } else {
            ListenerHolders.createListenerHolder(new zzcj(zzdaVar, taskCompletionSource), zzdw.f36705a, "GetCurrentLocation").getListenerKey().getClass();
            new TaskCompletionSource();
            throw null;
        }
    }
}
