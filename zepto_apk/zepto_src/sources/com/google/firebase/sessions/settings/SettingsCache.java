package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.Type;

@Singleton
@Metadata
/* loaded from: classes4.dex */
public final class SettingsCache {

    /* renamed from: c, reason: collision with root package name */
    public static final Preferences.Key f45192c;

    /* renamed from: d, reason: collision with root package name */
    public static final Preferences.Key f45193d;

    /* renamed from: e, reason: collision with root package name */
    public static final Preferences.Key f45194e;

    /* renamed from: f, reason: collision with root package name */
    public static final Preferences.Key f45195f;

    /* renamed from: g, reason: collision with root package name */
    public static final Preferences.Key f45196g;

    /* renamed from: a, reason: collision with root package name */
    public final DataStore f45197a;

    /* renamed from: b, reason: collision with root package name */
    public SessionConfigs f45198b;

    @Metadata
    @DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {Type.TLSA}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public SettingsCache f45199a;

        /* renamed from: b, reason: collision with root package name */
        public int f45200b;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return SettingsCache.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SettingsCache settingsCache;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            int i2 = this.f45200b;
            if (i2 == 0) {
                ResultKt.b(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                Flow data = settingsCache2.f45197a.getData();
                this.f45199a = settingsCache2;
                this.f45200b = 1;
                Object objI = FlowKt.i(data, this);
                if (objI == coroutineSingletons) {
                    return coroutineSingletons;
                }
                settingsCache = settingsCache2;
                obj = objI;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = this.f45199a;
                ResultKt.b(obj);
            }
            SettingsCache.a(settingsCache, new MutablePreferences(MapsKt.n(((Preferences) obj).a()), true));
            return Unit.f53572a;
        }
    }

    @Metadata
    public static final class Companion {
    }

    static {
        Intrinsics.checkNotNullParameter("firebase_sessions_enabled", CLConstants.FIELD_PAY_INFO_NAME);
        f45192c = new Preferences.Key("firebase_sessions_enabled");
        Intrinsics.checkNotNullParameter("firebase_sessions_sampling_rate", CLConstants.FIELD_PAY_INFO_NAME);
        f45193d = new Preferences.Key("firebase_sessions_sampling_rate");
        Intrinsics.checkNotNullParameter("firebase_sessions_restart_timeout", CLConstants.FIELD_PAY_INFO_NAME);
        f45194e = new Preferences.Key("firebase_sessions_restart_timeout");
        Intrinsics.checkNotNullParameter("firebase_sessions_cache_duration", CLConstants.FIELD_PAY_INFO_NAME);
        f45195f = new Preferences.Key("firebase_sessions_cache_duration");
        Intrinsics.checkNotNullParameter("firebase_sessions_cache_updated_time", CLConstants.FIELD_PAY_INFO_NAME);
        f45196g = new Preferences.Key("firebase_sessions_cache_updated_time");
    }

    public SettingsCache(DataStore dataStore) throws Throwable {
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.f45197a = dataStore;
        BuildersKt.d(new AnonymousClass1(null));
    }

    public static final void a(SettingsCache settingsCache, Preferences preferences) {
        settingsCache.getClass();
        settingsCache.f45198b = new SessionConfigs((Boolean) preferences.b(f45192c), (Double) preferences.b(f45193d), (Integer) preferences.b(f45194e), (Integer) preferences.b(f45195f), (Long) preferences.b(f45196g));
    }

    public final boolean b() {
        Integer num;
        SessionConfigs sessionConfigs = this.f45198b;
        if (sessionConfigs == null) {
            Intrinsics.h("sessionConfigs");
            throw null;
        }
        if (sessionConfigs != null) {
            Long l2 = sessionConfigs.f45183e;
            return l2 == null || (num = sessionConfigs.f45182d) == null || (System.currentTimeMillis() - l2.longValue()) / ((long) 1000) >= ((long) num.intValue());
        }
        Intrinsics.h("sessionConfigs");
        throw null;
    }

    public final Integer c() {
        SessionConfigs sessionConfigs = this.f45198b;
        if (sessionConfigs != null) {
            return sessionConfigs.f45181c;
        }
        Intrinsics.h("sessionConfigs");
        throw null;
    }

    public final Double d() {
        SessionConfigs sessionConfigs = this.f45198b;
        if (sessionConfigs != null) {
            return sessionConfigs.f45180b;
        }
        Intrinsics.h("sessionConfigs");
        throw null;
    }

    public final Boolean e() {
        SessionConfigs sessionConfigs = this.f45198b;
        if (sessionConfigs != null) {
            return sessionConfigs.f45179a;
        }
        Intrinsics.h("sessionConfigs");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(androidx.datastore.preferences.core.Preferences.Key r6, java.lang.Object r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            if (r0 == 0) goto L13
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1) r0
            int r1 = r0.f45209c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f45209c = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f45207a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f45209c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)     // Catch: java.io.IOException -> L27
            goto L58
        L27:
            r6 = move-exception
            goto L45
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.b(r8)
            androidx.datastore.core.DataStore r8 = r5.f45197a     // Catch: java.io.IOException -> L27
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch: java.io.IOException -> L27
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch: java.io.IOException -> L27
            r0.f45209c = r3     // Catch: java.io.IOException -> L27
            java.lang.Object r6 = androidx.datastore.preferences.core.PreferencesKt.a(r8, r2, r0)     // Catch: java.io.IOException -> L27
            if (r6 != r1) goto L58
            return r1
        L45:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Failed to update cache config value: "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L58:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.f(androidx.datastore.preferences.core.Preferences$Key, java.lang.Object, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
