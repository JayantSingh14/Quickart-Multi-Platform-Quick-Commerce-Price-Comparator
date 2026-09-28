package io.invertase.firebase.common;

import android.util.Log;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SharedUtils {
    public static WritableMap a(Exception exc) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        String message = exc.getMessage();
        writableMapCreateMap.putString("code", zzck.UNKNOWN_CONTENT_TYPE);
        writableMapCreateMap.putString("nativeErrorCode", zzck.UNKNOWN_CONTENT_TYPE);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, message);
        writableMapCreateMap.putString("nativeErrorMessage", message);
        return writableMapCreateMap;
    }

    public static WritableArray b(JSONArray jSONArray) throws JSONException {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object obj = jSONArray.get(i2);
            if ((obj instanceof Float) || (obj instanceof Double)) {
                writableArrayCreateArray.pushDouble(jSONArray.getDouble(i2));
            } else if (obj instanceof Number) {
                writableArrayCreateArray.pushInt(jSONArray.getInt(i2));
            } else if (obj instanceof String) {
                writableArrayCreateArray.pushString(jSONArray.getString(i2));
            } else if (obj instanceof JSONObject) {
                writableArrayCreateArray.pushMap(c(jSONArray.getJSONObject(i2)));
            } else if (obj instanceof JSONArray) {
                writableArrayCreateArray.pushArray(b(jSONArray.getJSONArray(i2)));
            } else if (obj == JSONObject.NULL) {
                writableArrayCreateArray.pushNull();
            }
        }
        return writableArrayCreateArray;
    }

    public static WritableMap c(JSONObject jSONObject) throws JSONException {
        Iterator<String> itKeys = jSONObject.keys();
        WritableMap writableMapCreateMap = Arguments.createMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if ((obj instanceof Float) || (obj instanceof Double)) {
                writableMapCreateMap.putDouble(next, jSONObject.getDouble(next));
            } else if (obj instanceof Number) {
                writableMapCreateMap.putInt(next, jSONObject.getInt(next));
            } else if (obj instanceof String) {
                writableMapCreateMap.putString(next, jSONObject.getString(next));
            } else if (obj instanceof JSONObject) {
                writableMapCreateMap.putMap(next, c(jSONObject.getJSONObject(next)));
            } else if (obj instanceof JSONArray) {
                writableMapCreateMap.putArray(next, b(jSONObject.getJSONArray(next)));
            } else if (obj == JSONObject.NULL) {
                writableMapCreateMap.putNull(next);
            }
        }
        return writableMapCreateMap;
    }

    public static WritableArray d(List list) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (Object obj : list) {
            if (obj == null || obj == JSONObject.NULL) {
                writableArrayCreateArray.pushNull();
            } else {
                String name = obj.getClass().getName();
                if (name.equals("java.lang.Integer")) {
                    writableArrayCreateArray.pushInt(((Integer) obj).intValue());
                } else if (name.equals("java.lang.Float")) {
                    writableArrayCreateArray.pushDouble(((Float) obj).floatValue());
                } else if (name.equals("org.json.JSONArray$1")) {
                    try {
                        writableArrayCreateArray.pushArray(b((JSONArray) obj));
                    } catch (JSONException unused) {
                        writableArrayCreateArray.pushNull();
                    }
                } else if (name.equals("java.lang.Boolean")) {
                    writableArrayCreateArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (name.equals("java.lang.Long")) {
                    writableArrayCreateArray.pushDouble(((Long) obj).longValue());
                } else if (name.equals("java.lang.Double")) {
                    writableArrayCreateArray.pushDouble(((Double) obj).doubleValue());
                } else if (name.equals("java.lang.String")) {
                    writableArrayCreateArray.pushString((String) obj);
                } else if (name.equals("org.json.JSONObject$1")) {
                    try {
                        writableArrayCreateArray.pushMap(c((JSONObject) obj));
                    } catch (JSONException unused2) {
                        writableArrayCreateArray.pushNull();
                    }
                } else if (List.class.isAssignableFrom(obj.getClass())) {
                    writableArrayCreateArray.pushArray(d((List) obj));
                } else if (Map.class.isAssignableFrom(obj.getClass())) {
                    writableArrayCreateArray.pushMap(f((Map) obj));
                } else {
                    Log.d("Utils", "utils:arrayPushValue:unknownType:".concat(name));
                    writableArrayCreateArray.pushNull();
                }
            }
        }
        return writableArrayCreateArray;
    }

    public static void e(WritableMap writableMap, String str, Object obj) {
        if (obj == null || obj == JSONObject.NULL) {
            writableMap.putNull(str);
            return;
        }
        String name = obj.getClass().getName();
        if (name.equals("java.lang.Integer")) {
            writableMap.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (name.equals("java.lang.Float")) {
            writableMap.putDouble(str, ((Float) obj).floatValue());
            return;
        }
        if (name.equals("org.json.JSONArray$1")) {
            try {
                writableMap.putArray(str, b((JSONArray) obj));
                return;
            } catch (JSONException unused) {
                writableMap.putNull(str);
                return;
            }
        }
        if (name.equals("java.lang.Boolean")) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (name.equals("java.lang.Long")) {
            writableMap.putDouble(str, ((Long) obj).longValue());
            return;
        }
        if (name.equals("java.lang.Double")) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (name.equals("java.lang.String")) {
            writableMap.putString(str, (String) obj);
            return;
        }
        if (name.equals("org.json.JSONObject$1")) {
            try {
                writableMap.putMap(str, c((JSONObject) obj));
            } catch (JSONException unused2) {
                writableMap.putNull(str);
            }
        } else if (List.class.isAssignableFrom(obj.getClass())) {
            writableMap.putArray(str, d((List) obj));
        } else if (Map.class.isAssignableFrom(obj.getClass())) {
            writableMap.putMap(str, f((Map) obj));
        } else {
            Log.d("Utils", "utils:mapPutValue:unknownType:".concat(name));
            writableMap.putNull(str);
        }
    }

    public static WritableMap f(Map map) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Map.Entry entry : map.entrySet()) {
            e(writableMapCreateMap, (String) entry.getKey(), entry.getValue());
        }
        return writableMapCreateMap;
    }
}
