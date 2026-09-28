package com.facebook.react.devsupport;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DevInternalSettings implements DeveloperSettings, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final Listener f18794a;

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f18795b;

    /* renamed from: c, reason: collision with root package name */
    public final PackagerConnectionSettings f18796c;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public interface Listener {
        void a();
    }

    public DevInternalSettings(Context applicationContext, Listener listener) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        this.f18794a = listener;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.f18795b = defaultSharedPreferences;
        this.f18796c = new PackagerConnectionSettings(applicationContext);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public final boolean a() {
        return this.f18795b.getBoolean("remote_js_debug", false);
    }

    public final boolean b() {
        return this.f18795b.getBoolean("fps_debug", false);
    }

    @Override // com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public final void c(boolean z) {
        this.f18795b.edit().putBoolean("remote_js_debug", z).apply();
    }

    public final boolean d() {
        return this.f18795b.getBoolean("js_dev_mode_debug", true);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Listener listener = this.f18794a;
        if ("fps_debug".equals(str) || "js_dev_mode_debug".equals(str) || "js_minify_debug".equals(str)) {
            listener.a();
        }
    }
}
