package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
final class SettingsCache$updateConfigValue$2 extends SuspendLambda implements Function2<MutablePreferences, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f45210a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f45211b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Preferences.Key f45212c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SettingsCache f45213d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$updateConfigValue$2(Object obj, Preferences.Key key, SettingsCache settingsCache, Continuation continuation) {
        super(2, continuation);
        this.f45211b = obj;
        this.f45212c = key;
        this.f45213d = settingsCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SettingsCache$updateConfigValue$2 settingsCache$updateConfigValue$2 = new SettingsCache$updateConfigValue$2(this.f45211b, this.f45212c, this.f45213d, continuation);
        settingsCache$updateConfigValue$2.f45210a = obj;
        return settingsCache$updateConfigValue$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((SettingsCache$updateConfigValue$2) create((MutablePreferences) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        MutablePreferences mutablePreferences = (MutablePreferences) this.f45210a;
        Object obj2 = this.f45211b;
        Preferences.Key key = this.f45212c;
        if (obj2 != null) {
            mutablePreferences.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            mutablePreferences.d(key, obj2);
        } else {
            mutablePreferences.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            mutablePreferences.c();
            mutablePreferences.f3717a.remove(key);
        }
        SettingsCache.a(this.f45213d, mutablePreferences);
        return Unit.f53572a;
    }
}
