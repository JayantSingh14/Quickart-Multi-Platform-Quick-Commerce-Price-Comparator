package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzba implements RemoteCall {
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzda zzdaVar = (zzda) obj;
        Api api = zzbp.f36637a;
        ((TaskCompletionSource) obj2).b(((zzo) zzdaVar.getService()).c0(zzdaVar.getContext().getPackageName()));
    }
}
