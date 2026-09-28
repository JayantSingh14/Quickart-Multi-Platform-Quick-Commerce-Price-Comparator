package io.invertase.firebase.common;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReactNativeFirebaseJSON {

    /* renamed from: b, reason: collision with root package name */
    public static final ReactNativeFirebaseJSON f49237b;

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f49238a;

    static {
        ReactNativeFirebaseJSON reactNativeFirebaseJSON = new ReactNativeFirebaseJSON();
        try {
            reactNativeFirebaseJSON.f49238a = new JSONObject("{\"crashlytics_debug_enabled\":true,\"crashlytics_disable_auto_disabler\":true,\"crashlytics_auto_collection_enabled\":true,\"crashlytics_is_error_generation_on_js_crash_enabled\":true,\"crashlytics_javascript_exception_handler_chaining_enabled\":true,\"perf_auto_collection_enabled\":true}");
        } catch (JSONException unused) {
        }
        f49237b = reactNativeFirebaseJSON;
    }
}
