package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzbw implements RemoteCall {
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzda zzdaVar = (zzda) obj;
        zzdaVar.getClass();
        Preconditions.checkNotNull(null, "geofencingRequest can't be null.");
        Preconditions.checkNotNull(null, "PendingIntent must be specified.");
        ((zzo) zzdaVar.getService()).x6(new zzci((TaskCompletionSource) obj2));
    }
}
