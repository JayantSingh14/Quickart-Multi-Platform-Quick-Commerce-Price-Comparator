package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SettingsJsonParser {

    /* renamed from: a, reason: collision with root package name */
    public final SystemCurrentTimeProvider f44446a;

    public SettingsJsonParser(SystemCurrentTimeProvider systemCurrentTimeProvider) {
        this.f44446a = systemCurrentTimeProvider;
    }

    public final Settings a(JSONObject jSONObject) throws JSONException {
        SettingsJsonTransform settingsV3JsonTransform;
        int i2 = jSONObject.getInt("settings_version");
        if (i2 != 3) {
            Logger.f43705a.c("Could not determine SettingsJsonTransform for settings version " + i2 + ". Using default settings values.", null);
            settingsV3JsonTransform = new DefaultSettingsJsonTransform();
        } else {
            settingsV3JsonTransform = new SettingsV3JsonTransform();
        }
        return settingsV3JsonTransform.a(this.f44446a, jSONObject);
    }
}
