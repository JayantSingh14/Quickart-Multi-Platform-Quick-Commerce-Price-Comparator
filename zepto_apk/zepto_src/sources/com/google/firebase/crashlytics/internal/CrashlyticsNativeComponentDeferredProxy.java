package com.google.firebase.crashlytics.internal;

import androidx.work.impl.c;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class CrashlyticsNativeComponentDeferredProxy implements CrashlyticsNativeComponent {

    /* renamed from: c, reason: collision with root package name */
    public static final NativeSessionFileProvider f43698c = new MissingNativeSessionFileProvider();

    /* renamed from: a, reason: collision with root package name */
    public final Deferred f43699a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f43700b = new AtomicReference(null);

    public static final class MissingNativeSessionFileProvider implements NativeSessionFileProvider {
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public final File a() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public final CrashlyticsReport.ApplicationExitInfo b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public final File c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public final File d() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public final File e() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public final File f() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public final File g() {
            return null;
        }
    }

    public CrashlyticsNativeComponentDeferredProxy(Deferred deferred) {
        this.f43699a = deferred;
        deferred.a(new c(this, 2));
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final NativeSessionFileProvider a(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) this.f43700b.get();
        return crashlyticsNativeComponent == null ? f43698c : crashlyticsNativeComponent.a(str);
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final boolean b() {
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) this.f43700b.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.b();
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final void c(final String str, final long j2, final StaticSessionData staticSessionData) {
        Logger.f43705a.e("Deferring native open session: " + str);
        this.f43699a.a(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.a
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void f(Provider provider) {
                ((CrashlyticsNativeComponent) provider.get()).c(str, j2, staticSessionData);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public final boolean d(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) this.f43700b.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.d(str);
    }
}
