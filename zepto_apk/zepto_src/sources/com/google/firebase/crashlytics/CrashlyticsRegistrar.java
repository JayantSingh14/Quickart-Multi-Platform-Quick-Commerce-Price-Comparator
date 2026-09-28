package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f43692d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Qualified f43693a = new Qualified(Background.class, ExecutorService.class);

    /* renamed from: b, reason: collision with root package name */
    public final Qualified f43694b = new Qualified(Blocking.class, ExecutorService.class);

    /* renamed from: c, reason: collision with root package name */
    public final Qualified f43695c = new Qualified(Lightweight.class, ExecutorService.class);

    static {
        FirebaseSessionsDependencies.a();
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        Component.Builder builderB = Component.b(FirebaseCrashlytics.class);
        builderB.f43563a = "fire-cls";
        builderB.a(Dependency.b(FirebaseApp.class));
        builderB.a(Dependency.b(FirebaseInstallationsApi.class));
        builderB.a(new Dependency(this.f43693a, 1, 0));
        builderB.a(new Dependency(this.f43694b, 1, 0));
        builderB.a(new Dependency(this.f43695c, 1, 0));
        builderB.a(new Dependency(0, 2, CrashlyticsNativeComponent.class));
        builderB.a(new Dependency(0, 2, AnalyticsConnector.class));
        builderB.a(new Dependency(0, 2, FirebaseRemoteConfigInterop.class));
        builderB.f43568f = new a(this);
        builderB.d(2);
        return Arrays.asList(builderB.b(), LibraryVersionComponent.a("fire-cls", "19.4.4"));
    }
}
