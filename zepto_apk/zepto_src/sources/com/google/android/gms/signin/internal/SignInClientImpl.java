package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;

@KeepForSdk
/* loaded from: classes4.dex */
public class SignInClientImpl extends GmsClient<zaf> implements com.google.android.gms.signin.zae {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f39717e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f39718a;

    /* renamed from: b, reason: collision with root package name */
    public final ClientSettings f39719b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f39720c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f39721d;

    public SignInClientImpl(Context context, Looper looper, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f39718a = true;
        this.f39719b = clientSettings;
        this.f39720c = bundle;
        this.f39721d = clientSettings.zab();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void a(zac zacVar) {
        Preconditions.checkNotNull(zacVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountOrDefault = this.f39719b.getAccountOrDefault();
            zat zatVar = new zat(accountOrDefault, ((Integer) Preconditions.checkNotNull(this.f39721d)).intValue(), "<<default account>>".equals(accountOrDefault.name) ? Storage.a(getContext()).b() : null);
            zaf zafVar = (zaf) getService();
            zai zaiVar = new zai(1, zatVar);
            Parcel parcelZaa = zafVar.zaa();
            com.google.android.gms.internal.base.zac.c(parcelZaa, zaiVar);
            com.google.android.gms.internal.base.zac.d(parcelZaa, zacVar);
            zafVar.zac(12, parcelZaa);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zacVar.zab(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void b(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            zaf zafVar = (zaf) getService();
            int iIntValue = ((Integer) Preconditions.checkNotNull(this.f39721d)).intValue();
            Parcel parcelZaa = zafVar.zaa();
            com.google.android.gms.internal.base.zac.d(parcelZaa, iAccountAccessor);
            parcelZaa.writeInt(iIntValue);
            parcelZaa.writeInt(z ? 1 : 0);
            zafVar.zac(9, parcelZaa);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zaf ? (zaf) iInterfaceQueryLocalInterface : new zaf(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        ClientSettings clientSettings = this.f39719b;
        boolean zEquals = getContext().getPackageName().equals(clientSettings.getRealClientPackageName());
        Bundle bundle = this.f39720c;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", clientSettings.getRealClientPackageName());
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return this.f39718a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void zaa() {
        try {
            zaf zafVar = (zaf) getService();
            int iIntValue = ((Integer) Preconditions.checkNotNull(this.f39721d)).intValue();
            Parcel parcelZaa = zafVar.zaa();
            parcelZaa.writeInt(iIntValue);
            zafVar.zac(7, parcelZaa);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.signin.zae
    public final void zab() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter(this));
    }
}
