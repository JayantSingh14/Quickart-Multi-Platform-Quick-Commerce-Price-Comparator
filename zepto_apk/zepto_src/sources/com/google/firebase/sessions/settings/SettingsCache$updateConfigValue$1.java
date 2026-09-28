package com.google.firebase.sessions.settings;

import androidx.datastore.preferences.core.Preferences;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {122}, m = "updateConfigValue")
/* loaded from: classes4.dex */
final class SettingsCache$updateConfigValue$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f45207a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SettingsCache f45208b;

    /* renamed from: c, reason: collision with root package name */
    public int f45209c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsCache$updateConfigValue$1(SettingsCache settingsCache, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f45208b = settingsCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f45207a = obj;
        this.f45209c |= Integer.MIN_VALUE;
        Preferences.Key key = SettingsCache.f45192c;
        return this.f45208b.f(null, null, this);
    }
}
