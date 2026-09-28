package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zbk extends zbl {
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        zbe zbeVar = (zbe) anyClient;
        zbs zbsVar = (zbs) zbeVar.getService();
        zbj zbjVar = new zbj(this);
        Parcel parcelG = zbsVar.g();
        int i2 = com.google.android.gms.internal.p000authapi.zbc.f36271a;
        parcelG.writeStrongBinder(zbjVar);
        com.google.android.gms.internal.p000authapi.zbc.c(parcelG, zbeVar.f22212a);
        zbsVar.z0(103, parcelG);
    }
}
