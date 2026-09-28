package com.google.android.gms.auth.api.signin.internal;

import androidx.loader.app.LoaderManager;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes4.dex */
final class zbv implements LoaderManager.LoaderCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SignInHubActivity f22220a;

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        SignInHubActivity signInHubActivity = this.f22220a;
        signInHubActivity.setResult(signInHubActivity.f22201l, signInHubActivity.f22202m);
        signInHubActivity.finish();
    }

    @Override // androidx.loader.app.LoaderManager.LoaderCallbacks
    public final zbc b() {
        return new zbc(this.f22220a, GoogleApiClient.getAllClients());
    }
}
