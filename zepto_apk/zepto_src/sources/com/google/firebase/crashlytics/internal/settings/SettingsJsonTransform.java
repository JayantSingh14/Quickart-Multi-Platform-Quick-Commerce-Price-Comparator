package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import org.json.JSONObject;

/* loaded from: classes.dex */
interface SettingsJsonTransform {
    Settings a(SystemCurrentTimeProvider systemCurrentTimeProvider, JSONObject jSONObject);
}
