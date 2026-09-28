package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.zbc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

/* loaded from: classes4.dex */
public final class zbd extends GmsClient {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.auth.api.zbd f36272a;

    public zbd(Context context, Looper looper, ClientSettings clientSettings, com.google.android.gms.auth.api.zbd zbdVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, clientSettings, connectionCallbacks, onConnectionFailedListener);
        zbdVar = zbdVar == null ? com.google.android.gms.auth.api.zbd.f22224c : zbdVar;
        zbc zbcVar = new zbc();
        zbcVar.f22222a = Boolean.FALSE;
        com.google.android.gms.auth.api.zbd zbdVar2 = com.google.android.gms.auth.api.zbd.f22224c;
        zbdVar.getClass();
        zbcVar.f22222a = Boolean.valueOf(zbdVar.f22225a);
        zbcVar.f22223b = zbdVar.f22226b;
        zbcVar.f22223b = zbas.a();
        this.f36272a = new com.google.android.gms.auth.api.zbd(zbcVar);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        return iInterfaceQueryLocalInterface instanceof zbe ? (zbe) iInterfaceQueryLocalInterface : new zbe(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        com.google.android.gms.auth.api.zbd zbdVar = this.f36272a;
        zbdVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("consumer_package", null);
        bundle.putBoolean("force_save_dialog", zbdVar.f22225a);
        bundle.putString("log_session_id", zbdVar.f22226b);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12800000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
}
