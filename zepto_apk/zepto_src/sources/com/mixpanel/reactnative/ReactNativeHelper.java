package com.mixpanel.reactnative;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReactNativeHelper {

    /* renamed from: com.mixpanel.reactnative.ReactNativeHelper$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46099a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            f46099a = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46099a[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46099a[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46099a[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46099a[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f46099a[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static WritableNativeArray a(JSONArray jSONArray) throws JSONException {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            Object obj = jSONArray.get(i2);
            if (obj instanceof JSONObject) {
                writableNativeArray.pushMap(b((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeArray.pushArray(a((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeArray.pushString((String) obj);
            } else {
                writableNativeArray.pushString(obj.toString());
            }
        }
        return writableNativeArray;
    }

    public static WritableNativeMap b(JSONObject jSONObject) throws JSONException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONObject) {
                writableNativeMap.putMap(next, b((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                writableNativeMap.putArray(next, a((JSONArray) obj));
            } else if (obj instanceof Boolean) {
                writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                writableNativeMap.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof String) {
                writableNativeMap.putString(next, (String) obj);
            } else {
                writableNativeMap.putString(next, obj.toString());
            }
        }
        return writableNativeMap;
    }

    public static Object c(Dynamic dynamic) {
        int i2 = AnonymousClass1.f46099a[dynamic.getType().ordinal()];
        return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? dynamic : dynamic.asArray() : dynamic.asMap() : dynamic.asString() : Double.valueOf(dynamic.asDouble()) : Boolean.valueOf(dynamic.asBoolean());
    }

    public static JSONArray d(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableType type = readableArray.getType(i2);
            switch (AnonymousClass1.f46099a[type.ordinal()]) {
                case 1:
                    jSONArray.put(JSONObject.NULL);
                    break;
                case 2:
                    jSONArray.put(readableArray.getBoolean(i2));
                    break;
                case 3:
                    double d2 = readableArray.getDouble(i2);
                    if (!Double.isNaN(d2) && !Double.isInfinite(d2)) {
                        jSONArray.put(d2);
                        break;
                    } else {
                        break;
                    }
                    break;
                case 4:
                    jSONArray.put(readableArray.getString(i2));
                    break;
                case 5:
                    jSONArray.put(e(readableArray.getMap(i2)));
                    break;
                case 6:
                    jSONArray.put(d(readableArray.getArray(i2)));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported data type" + type);
            }
        }
        return jSONArray;
    }

    public static JSONObject e(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            ReadableType type = readableMap.getType(strNextKey);
            switch (AnonymousClass1.f46099a[type.ordinal()]) {
                case 1:
                    jSONObject.put(strNextKey, JSONObject.NULL);
                    break;
                case 2:
                    jSONObject.put(strNextKey, readableMap.getBoolean(strNextKey));
                    break;
                case 3:
                    double d2 = readableMap.getDouble(strNextKey);
                    if (!Double.isNaN(d2) && !Double.isInfinite(d2)) {
                        jSONObject.put(strNextKey, d2);
                        break;
                    } else {
                        jSONObject.put(strNextKey, String.valueOf(d2));
                        break;
                    }
                case 4:
                    jSONObject.put(strNextKey, readableMap.getString(strNextKey));
                    break;
                case 5:
                    jSONObject.put(strNextKey, e(readableMap.getMap(strNextKey)));
                    break;
                case 6:
                    jSONObject.put(strNextKey, d(readableMap.getArray(strNextKey)));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported data type" + type);
            }
        }
        return jSONObject;
    }

    public static Object[] f(ReadableArray readableArray) {
        Object[] objArr = new Object[readableArray.size()];
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            switch (AnonymousClass1.f46099a[readableArray.getType(i2).ordinal()]) {
                case 1:
                    objArr[i2] = null;
                    break;
                case 2:
                    objArr[i2] = Boolean.valueOf(readableArray.getBoolean(i2));
                    break;
                case 3:
                    objArr[i2] = Double.valueOf(readableArray.getDouble(i2));
                    break;
                case 4:
                    objArr[i2] = readableArray.getString(i2);
                    break;
                case 5:
                    objArr[i2] = g(readableArray.getMap(i2));
                    break;
                case 6:
                    objArr[i2] = f(readableArray.getArray(i2));
                    break;
            }
        }
        return objArr;
    }

    public static HashMap g(ReadableMap readableMap) {
        HashMap map = new HashMap();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            switch (AnonymousClass1.f46099a[readableMap.getType(strNextKey).ordinal()]) {
                case 1:
                    map.put(strNextKey, null);
                    break;
                case 2:
                    map.put(strNextKey, Boolean.valueOf(readableMap.getBoolean(strNextKey)));
                    break;
                case 3:
                    double d2 = readableMap.getDouble(strNextKey);
                    if (!Double.isNaN(d2) && !Double.isInfinite(d2)) {
                        map.put(strNextKey, Double.valueOf(readableMap.getDouble(strNextKey)));
                        break;
                    } else {
                        map.put(strNextKey, String.valueOf(d2));
                        break;
                    }
                case 4:
                    map.put(strNextKey, readableMap.getString(strNextKey));
                    break;
                case 5:
                    map.put(strNextKey, g(readableMap.getMap(strNextKey)));
                    break;
                case 6:
                    map.put(strNextKey, f(readableMap.getArray(strNextKey)));
                    break;
            }
        }
        return map;
    }
}
