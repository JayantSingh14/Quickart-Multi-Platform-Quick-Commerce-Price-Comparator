package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zbab implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zbae zbaeVar = new zbae((TaskCompletionSource) obj2);
        zbm zbmVar = (zbm) ((zbg) obj).getService();
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) Preconditions.checkNotNull(null);
        Parcel parcelG = zbmVar.g();
        int i2 = zbc.f36271a;
        parcelG.writeStrongBinder(zbaeVar);
        zbc.c(parcelG, savePasswordRequest);
        zbmVar.z0(2, parcelG);
    }
}
