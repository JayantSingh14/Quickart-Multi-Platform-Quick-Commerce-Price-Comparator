package com.google.firebase.sessions.settings;

import android.util.Log;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.PreferencesKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {109}, m = "removeConfigs$com_google_firebase_firebase_sessions")
/* loaded from: classes4.dex */
final class SettingsCache$removeConfigs$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f45202a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingsCache f45203b;

    /* renamed from: c, reason: collision with root package name */
    public int f45204c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$removeConfigs$1(SettingsCache settingsCache, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f45203b = settingsCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SettingsCache$removeConfigs$1 settingsCache$removeConfigs$1;
        this.f45202a = obj;
        this.f45204c |= Integer.MIN_VALUE;
        SettingsCache settingsCache = this.f45203b;
        settingsCache.getClass();
        int i2 = this.f45204c;
        if ((i2 & Integer.MIN_VALUE) != 0) {
            this.f45204c = i2 - Integer.MIN_VALUE;
            settingsCache$removeConfigs$1 = this;
        } else {
            settingsCache$removeConfigs$1 = new SettingsCache$removeConfigs$1(settingsCache, this);
        }
        Object obj2 = settingsCache$removeConfigs$1.f45202a;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i3 = settingsCache$removeConfigs$1.f45204c;
        try {
            if (i3 == 0) {
                ResultKt.b(obj2);
                DataStore dataStore = settingsCache.f45197a;
                SettingsCache$removeConfigs$2 settingsCache$removeConfigs$2 = new SettingsCache$removeConfigs$2(settingsCache, null);
                settingsCache$removeConfigs$1.f45204c = 1;
                if (PreferencesKt.a(dataStore, settingsCache$removeConfigs$2, settingsCache$removeConfigs$1) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj2);
            }
        } catch (IOException e2) {
            Log.w("SettingsCache", "Failed to remove config values: " + e2);
        }
        return Unit.f53572a;
    }
}
