package com.google.android.gms.identity.intents;

import android.accounts.Account;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.identity.zzg;
import com.google.android.gms.internal.identity.zzh;

/* loaded from: classes4.dex */
final class zzb extends zzc {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        com.google.android.gms.internal.identity.zze zzeVar = (com.google.android.gms.internal.identity.zze) anyClient;
        String str = zzeVar.f36621c;
        zzeVar.checkConnected();
        com.google.android.gms.internal.identity.zzd zzdVar = new com.google.android.gms.internal.identity.zzd();
        zzdVar.f36618a = zzeVar.f36619a;
        zzeVar.f36620b = zzdVar;
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", zzeVar.getContext().getPackageName());
            if (!TextUtils.isEmpty(str)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(str, AccountType.GOOGLE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", 0);
            ((zzh) zzeVar.getService()).g((zzg) Preconditions.checkNotNull(zzeVar.f36620b), bundle);
        } catch (RemoteException e2) {
            Log.e("AddressClientImpl", "Exception requesting user address", e2);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
            ((com.google.android.gms.internal.identity.zzd) Preconditions.checkNotNull(zzeVar.f36620b)).z0(1, bundle2);
        }
        setResult((zzb) Status.RESULT_SUCCESS);
    }
}
