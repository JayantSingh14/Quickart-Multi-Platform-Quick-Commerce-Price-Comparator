package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbas;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes4.dex */
public final class zbe extends GmsClient {

    /* renamed from: a, reason: collision with root package name */
    public final GoogleSignInOptions f22212a;

    public zbe(Context context, Looper looper, ClientSettings clientSettings, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        GoogleSignInOptions.Builder builder;
        super(context, looper, 91, clientSettings, connectionCallbacks, onConnectionFailedListener);
        if (googleSignInOptions != null) {
            builder = new GoogleSignInOptions.Builder();
            builder.f22178a = new HashSet();
            builder.f22185h = new HashMap();
            Preconditions.checkNotNull(googleSignInOptions);
            builder.f22178a = new HashSet(googleSignInOptions.f22169b);
            builder.f22179b = googleSignInOptions.f22172e;
            builder.f22180c = googleSignInOptions.f22173f;
            builder.f22181d = googleSignInOptions.f22171d;
            builder.f22182e = googleSignInOptions.f22174g;
            builder.f22183f = googleSignInOptions.f22170c;
            builder.f22184g = googleSignInOptions.f22175h;
            builder.f22185h = GoogleSignInOptions.r(googleSignInOptions.f22176i);
            builder.f22186i = googleSignInOptions.f22177j;
        } else {
            builder = new GoogleSignInOptions.Builder();
        }
        builder.f22186i = zbas.a();
        if (!clientSettings.getAllRequestedScopes().isEmpty()) {
            for (Scope scope : clientSettings.getAllRequestedScopes()) {
                HashSet hashSet = builder.f22178a;
                hashSet.add(scope);
                hashSet.addAll(Arrays.asList(new Scope[0]));
            }
        }
        this.f22212a = builder.a();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zbs ? (zbs) iInterfaceQueryLocalInterface : new zbs(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final Intent getSignInIntent() {
        Context context = getContext();
        zbm.f22216a.d("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), this.f22212a);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PaymentConstants.Category.CONFIG, signInConfiguration);
        intent.putExtra(PaymentConstants.Category.CONFIG, bundle);
        return intent;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean providesSignIn() {
        return true;
    }
}
