package com.zeptoconsumerapp.DynamicFeatures;

import coil3.decode.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class EventLogger {

    /* renamed from: a, reason: collision with root package name */
    public static final MediaType f47406a;

    /* renamed from: b, reason: collision with root package name */
    public static final Lazy f47407b;

    static {
        Pattern pattern = MediaType.f56278d;
        f47406a = MediaType.Companion.a("application/json; charset=utf-8");
        f47407b = LazyKt.b(new b(13));
    }

    public static JSONObject a(LinkedHashMap linkedHashMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            jSONObject.put((String) entry.getKey(), b(entry.getValue()));
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("event_type", "dynamic_import_flow");
        jSONObject2.put("data", jSONObject);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("events", jSONArray);
        return jSONObject3;
    }

    public static Object b(Object obj) throws JSONException {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key instanceof String) {
                    jSONObject.put((String) key, b(value));
                }
            }
            return jSONObject;
        }
        if (obj instanceof List) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                jSONArray.put(b(it.next()));
            }
            return jSONArray;
        }
        if (!(obj instanceof Object[])) {
            return obj;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (Object obj2 : (Object[]) obj) {
            jSONArray2.put(b(obj2));
        }
        return jSONArray2;
    }
}
