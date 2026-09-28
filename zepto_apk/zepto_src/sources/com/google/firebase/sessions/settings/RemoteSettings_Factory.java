package com.google.firebase.sessions.settings;

import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.Lazy;
import com.google.firebase.sessions.dagger.internal.DaggerGenerated;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.QualifierMetadata;
import com.google.firebase.sessions.dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
/* loaded from: classes.dex */
public final class RemoteSettings_Factory implements Factory<RemoteSettings> {

    /* renamed from: a, reason: collision with root package name */
    public final InstanceFactory f45174a;

    /* renamed from: b, reason: collision with root package name */
    public final InstanceFactory f45175b;

    /* renamed from: c, reason: collision with root package name */
    public final Provider f45176c;

    /* renamed from: d, reason: collision with root package name */
    public final Provider f45177d;

    /* renamed from: e, reason: collision with root package name */
    public final Provider f45178e;

    public RemoteSettings_Factory(InstanceFactory instanceFactory, InstanceFactory instanceFactory2, Provider provider, Provider provider2, Provider provider3) {
        this.f45174a = instanceFactory;
        this.f45175b = instanceFactory2;
        this.f45176c = provider;
        this.f45177d = provider2;
        this.f45178e = provider3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.google.firebase.sessions.dagger.Lazy] */
    @Override // javax.inject.Provider
    public final Object get() {
        CoroutineContext coroutineContext = (CoroutineContext) this.f45174a.f45145a;
        FirebaseInstallationsApi firebaseInstallationsApi = (FirebaseInstallationsApi) this.f45175b.f45145a;
        ApplicationInfo applicationInfo = (ApplicationInfo) this.f45176c.get();
        CrashlyticsSettingsFetcher crashlyticsSettingsFetcher = (CrashlyticsSettingsFetcher) this.f45177d.get();
        Provider provider = this.f45178e;
        return new RemoteSettings(coroutineContext, firebaseInstallationsApi, applicationInfo, crashlyticsSettingsFetcher, provider instanceof Lazy ? (Lazy) provider : new DoubleCheck(provider));
    }
}
