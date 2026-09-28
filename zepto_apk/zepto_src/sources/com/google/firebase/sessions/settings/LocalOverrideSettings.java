package com.google.firebase.sessions.settings;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.sessions.settings.SettingsProvider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Singleton
@Metadata
/* loaded from: classes.dex */
public final class LocalOverrideSettings implements SettingsProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f45146a;

    @Metadata
    public static final class Companion {
    }

    public LocalOverrideSettings(Context appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Bundle bundle = appContext.getPackageManager().getApplicationInfo(appContext.getPackageName(), 128).metaData;
        this.f45146a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public final Boolean a() {
        Bundle bundle = this.f45146a;
        if (bundle.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(bundle.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public final Duration b() {
        Bundle bundle = this.f45146a;
        if (bundle.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return new Duration(DurationKt.g(bundle.getInt("firebase_sessions_sessions_restart_timeout"), DurationUnit.f54022e));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public final Double c() {
        Bundle bundle = this.f45146a;
        if (bundle.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(bundle.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public final Object d(Continuation continuation) {
        return SettingsProvider.DefaultImpls.a();
    }
}
