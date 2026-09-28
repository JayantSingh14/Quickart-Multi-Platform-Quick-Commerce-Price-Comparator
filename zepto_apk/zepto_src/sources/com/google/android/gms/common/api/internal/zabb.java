package com.google.android.gms.common.api.internal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* loaded from: classes4.dex */
final class zabb implements ResultCallback {
    final /* synthetic */ StatusPendingResult zaa;
    final /* synthetic */ boolean zab;
    final /* synthetic */ GoogleApiClient zac;
    final /* synthetic */ zabe zad;

    public zabb(zabe zabeVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zad = zabeVar;
        this.zaa = statusPendingResult;
        this.zab = z;
        this.zac = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(@NonNull Result result) {
        Status status = (Status) result;
        Storage storageA = Storage.a(this.zad.zan);
        String strD = storageA.d("defaultGoogleSignInAccount");
        storageA.e("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strD)) {
            storageA.e(Storage.g("googleSignInAccount", strD));
            storageA.e(Storage.g("googleSignInOptions", strD));
        }
        if (status.isSuccess() && this.zad.isConnected()) {
            zabe zabeVar = this.zad;
            zabeVar.disconnect();
            zabeVar.connect();
        }
        this.zaa.setResult(status);
        if (this.zab) {
            this.zac.disconnect();
        }
    }
}
