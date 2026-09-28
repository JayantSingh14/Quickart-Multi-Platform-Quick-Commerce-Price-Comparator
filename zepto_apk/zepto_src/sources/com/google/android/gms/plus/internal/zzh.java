package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.plus.zzr;
import com.google.android.gms.plus.Plus;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzh extends GmsClient<zzf> {

    /* renamed from: a, reason: collision with root package name */
    public final zzn f39695a;

    public zzh(Context context, Looper looper, ClientSettings clientSettings, zzn zznVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f39695a = zznVar;
    }

    public final ICancelToken c(BaseImplementation.ResultHolder resultHolder) {
        checkConnected();
        zzj zzjVar = new zzj(resultHolder);
        try {
            return ((zzf) getService()).R2(zzjVar, 1, 0);
        } catch (RemoteException unused) {
            zzjVar.v1(DataHolder.empty(8), null);
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
        return iInterfaceQueryLocalInterface instanceof zzf ? (zzf) iInterfaceQueryLocalInterface : new zzg(iBinder, "com.google.android.gms.plus.internal.IPlusService");
    }

    public final void d(BaseImplementation.ResultHolder resultHolder) {
        checkConnected();
        zzj zzjVar = new zzj(resultHolder);
        try {
            ((zzf) getService()).R2(zzjVar, 2, 1);
        } catch (RemoteException unused) {
            zzjVar.v1(DataHolder.empty(8), null);
        }
    }

    public final void e(BaseImplementation.ResultHolder resultHolder, List list) {
        checkConnected();
        zzj zzjVar = new zzj(resultHolder);
        try {
            ((zzf) getService()).Y4(zzjVar, new ArrayList(list));
        } catch (RemoteException unused) {
            zzjVar.v1(DataHolder.empty(8), null);
        }
    }

    public final void f(BaseImplementation.ResultHolder resultHolder) {
        checkConnected();
        checkConnected();
        try {
            ((zzf) getService()).zza();
            zzk zzkVar = new zzk(resultHolder);
            try {
                ((zzf) getService()).Z5(zzkVar);
            } catch (RemoteException unused) {
                zzkVar.X8(8, null);
            }
        } catch (RemoteException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        zzn zznVar = this.f39695a;
        zznVar.getClass();
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PlusCommonExtras.class.getClassLoader());
        bundle.putByteArray("android.gms.plus.internal.PlusCommonExtras.extraPlusCommon", SafeParcelableSerializer.serializeToBytes(zznVar.f39709j));
        bundle.putStringArray("request_visible_actions", zznVar.f39703d);
        bundle.putString(ServiceSpecificExtraArgs.PlusExtraArgs.PLUS_AUTH_PACKAGE, zznVar.f39705f);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.plus.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onPostInitHandler(int i2, IBinder iBinder, Bundle bundle, int i3) {
        if (i2 == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            byte[] byteArray = bundle.getByteArray("loaded_person");
            Parcelable.Creator<zzr> creator = zzr.CREATOR;
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(byteArray, 0, byteArray.length);
            parcelObtain.setDataPosition(0);
            zzr.CREATOR.createFromParcel(parcelObtain);
            parcelObtain.recycle();
        }
        super.onPostInitHandler(i2, iBinder, bundle, i3);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        Set<Scope> applicableScopes = getClientSettings().getApplicableScopes(Plus.f39681a);
        if (applicableScopes == null || applicableScopes.isEmpty()) {
            return false;
        }
        return (applicableScopes.size() == 1 && applicableScopes.contains(new Scope("plus_one_placeholder_scope"))) ? false : true;
    }
}
