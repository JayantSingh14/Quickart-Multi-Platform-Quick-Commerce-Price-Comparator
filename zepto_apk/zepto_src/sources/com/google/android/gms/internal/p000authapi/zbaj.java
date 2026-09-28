package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zbaj implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zban zbanVar = new zban((TaskCompletionSource) obj2);
        zbv zbvVar = (zbv) ((zbaq) obj).getService();
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) Preconditions.checkNotNull(null);
        Parcel parcelG = zbvVar.g();
        int i2 = zbc.f36271a;
        parcelG.writeStrongBinder(zbanVar);
        zbc.c(parcelG, getSignInIntentRequest);
        zbvVar.z0(3, parcelG);
    }
}
