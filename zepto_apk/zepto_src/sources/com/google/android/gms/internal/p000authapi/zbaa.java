package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes4.dex */
public final /* synthetic */ class zbaa implements RemoteCall {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zbad zbadVar = new zbad((TaskCompletionSource) obj2);
        zbm zbmVar = (zbm) ((zbg) obj).getService();
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) Preconditions.checkNotNull(null);
        Parcel parcelG = zbmVar.g();
        int i2 = zbc.f36271a;
        parcelG.writeStrongBinder(zbadVar);
        zbc.c(parcelG, saveAccountLinkingTokenRequest);
        zbmVar.z0(1, parcelG);
    }
}
