package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zbw implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zby zbyVar = new zby((TaskCompletionSource) obj2);
        zbj zbjVar = (zbj) ((zbf) obj).getService();
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) Preconditions.checkNotNull(null);
        Parcel parcelG = zbjVar.g();
        int i2 = zbc.f36271a;
        parcelG.writeStrongBinder(zbyVar);
        zbc.c(parcelG, authorizationRequest);
        zbjVar.z0(1, parcelG);
    }
}
