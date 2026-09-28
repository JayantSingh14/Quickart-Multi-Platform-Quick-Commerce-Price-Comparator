package com.google.firebase.sessions.settings;

import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.Lazy;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

@Singleton
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RemoteSettings implements SettingsProvider {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineContext f45148a;

    /* renamed from: b, reason: collision with root package name */
    public final FirebaseInstallationsApi f45149b;

    /* renamed from: c, reason: collision with root package name */
    public final ApplicationInfo f45150c;

    /* renamed from: d, reason: collision with root package name */
    public final CrashlyticsSettingsFetcher f45151d;

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f45152e;

    /* renamed from: f, reason: collision with root package name */
    public final MutexImpl f45153f;

    @Metadata
    public static final class Companion {
    }

    public RemoteSettings(CoroutineContext backgroundDispatcher, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, Lazy lazySettingsCache) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(lazySettingsCache, "lazySettingsCache");
        this.f45148a = backgroundDispatcher;
        this.f45149b = firebaseInstallationsApi;
        this.f45150c = appInfo;
        this.f45151d = configsFetcher;
        this.f45152e = lazySettingsCache;
        this.f45153f = MutexKt.a();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public final Boolean a() {
        return e().e();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public final Duration b() {
        Integer numC = e().c();
        if (numC == null) {
            return null;
        }
        Duration.Companion companion = Duration.f54014b;
        return new Duration(DurationKt.g(numC.intValue(), DurationUnit.f54022e));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public final Double c() {
        return e().d();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00bd A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:21:0x0050, B:44:0x00b1, B:46:0x00bd, B:49:0x00c8, B:36:0x008a, B:38:0x0094, B:41:0x009f), top: B:58:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c8 A[Catch: all -> 0x0054, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:21:0x0050, B:44:0x00b1, B:46:0x00bd, B:49:0x00c8, B:36:0x008a, B:38:0x0094, B:41:0x009f), top: B:58:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final SettingsCache e() {
        Object obj = this.f45152e.get();
        Intrinsics.checkNotNullExpressionValue(obj, "lazySettingsCache.get()");
        return (SettingsCache) obj;
    }
}
