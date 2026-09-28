package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zbg extends zbl {
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new GoogleSignInResult(null, status);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        zbs zbsVar = (zbs) ((zbe) anyClient).getService();
        zbf zbfVar = new zbf(this);
        Parcel parcelG = zbsVar.g();
        int i2 = com.google.android.gms.internal.p000authapi.zbc.f36271a;
        parcelG.writeStrongBinder(zbfVar);
        parcelG.writeInt(0);
        zbsVar.z0(101, parcelG);
    }
}
