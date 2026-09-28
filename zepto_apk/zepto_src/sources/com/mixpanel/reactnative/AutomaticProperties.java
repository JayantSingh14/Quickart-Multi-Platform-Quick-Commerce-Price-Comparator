package com.mixpanel.reactnative;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AutomaticProperties {

    /* renamed from: a, reason: collision with root package name */
    public static JSONObject f46098a;

    public static void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = f46098a;
        if (jSONObject2 != null) {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, f46098a.get(next));
            }
        }
    }
}
