package com.appsflyer.reactnative;

import android.os.Bundle;
import android.support.v4.media.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class RNUtil {

    /* renamed from: com.appsflyer.reactnative.RNUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$facebook$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Null.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Boolean.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Number.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.String.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Map.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$facebook$react$bridge$ReadableType[ReadableType.Array.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private RNUtil() {
    }

    private static JSONArray convertArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            int i3 = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i2).ordinal()];
            if (i3 == 2) {
                jSONArray.put(readableArray.getBoolean(i2));
            } else if (i3 == 3) {
                jSONArray.put(readableArray.getDouble(i2));
            } else if (i3 == 4) {
                jSONArray.put(readableArray.getString(i2));
            } else if (i3 == 5) {
                jSONArray.put(readableMapToJson(readableArray.getMap(i2)));
            } else if (i3 == 6) {
                jSONArray.put(convertArrayToJson(readableArray.getArray(i2)));
            }
        }
        return jSONArray;
    }

    @Nullable
    public static WritableArray jsonArrayToWritableArray(JSONArray jSONArray) throws JSONException {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                Object obj = jSONArray.get(i2);
                if (obj == null) {
                    writableNativeArray.pushNull();
                } else if (obj instanceof Boolean) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeArray.pushInt(((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeArray.pushDouble(((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeArray.pushString((String) obj);
                } else if (obj instanceof JSONObject) {
                    writableNativeArray.pushMap(jsonToWritableMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeArray.pushArray(jsonArrayToWritableArray((JSONArray) obj));
                }
            } catch (JSONException unused) {
            }
        }
        return writableNativeArray;
    }

    @Nullable
    public static Map<String, String> jsonObjectToMap(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, (String) jSONObject.get(next));
        }
        return map;
    }

    public static Bundle jsonToBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            bundle.putString(next, jSONObject.getString(next));
        }
        return bundle;
    }

    @Nullable
    public static WritableMap jsonToWritableMap(JSONObject jSONObject) throws JSONException {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> itKeys = jSONObject.keys();
        if (!itKeys.hasNext()) {
            return null;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj == null) {
                    writableNativeMap.putNull(next);
                } else if (obj instanceof Boolean) {
                    writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeMap.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeMap.putString(next, (String) obj);
                } else if (obj instanceof JSONObject) {
                    writableNativeMap.putMap(next, jsonToWritableMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeMap.putArray(next, jsonArrayToWritableArray((JSONArray) obj));
                }
            } catch (JSONException unused) {
            }
        }
        return writableNativeMap;
    }

    @Nullable
    public static JSONObject readableMapToJson(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        if (!readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            return null;
        }
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(strNextKey).ordinal()]) {
                case 1:
                    jSONObject.put(strNextKey, (Object) null);
                    continue;
                case 2:
                    jSONObject.put(strNextKey, readableMap.getBoolean(strNextKey));
                    continue;
                case 3:
                    jSONObject.put(strNextKey, readableMap.getInt(strNextKey));
                    continue;
                case 4:
                    jSONObject.put(strNextKey, readableMap.getString(strNextKey));
                    continue;
                case 5:
                    jSONObject.put(strNextKey, readableMapToJson(readableMap.getMap(strNextKey)));
                    continue;
                case 6:
                    jSONObject.put(strNextKey, convertArrayToJson(readableMap.getArray(strNextKey)));
                    continue;
                default:
                    continue;
            }
        }
        return jSONObject;
    }

    public static List<Object> toList(@Nullable ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        List<Object> arrayList = new ArrayList<>(readableArray.size());
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i2).ordinal()]) {
                case 1:
                    arrayList.add(null);
                    break;
                case 2:
                    arrayList.add(Boolean.valueOf(readableArray.getBoolean(i2)));
                    break;
                case 3:
                    double d2 = readableArray.getDouble(i2);
                    int i3 = (int) d2;
                    if (d2 == i3) {
                        arrayList.add(Integer.valueOf(i3));
                        break;
                    } else {
                        arrayList.add(Double.valueOf(d2));
                        break;
                    }
                case 4:
                    arrayList.add(readableArray.getString(i2));
                    break;
                case 5:
                    arrayList.add(toMap(readableArray.getMap(i2)));
                    break;
                case 6:
                    arrayList = toList(readableArray.getArray(i2));
                    break;
                default:
                    throw new IllegalArgumentException(b.g(i2, "Could not convert object with index: ", CLConstants.DOT_SALT_DELIMETER));
            }
        }
        return arrayList;
    }

    public static Map<String, Object> toMap(@Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
        if (!readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            return null;
        }
        HashMap map = new HashMap();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            map.put(strNextKey, toObject(readableMap, strNextKey));
        }
        return map;
    }

    public static Object toObject(@Nullable ReadableMap readableMap, String str) {
        if (readableMap == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(str).ordinal()]) {
            case 1:
                return null;
            case 2:
                return Boolean.valueOf(readableMap.getBoolean(str));
            case 3:
                double d2 = readableMap.getDouble(str);
                int i2 = (int) d2;
                return d2 == ((double) i2) ? Integer.valueOf(i2) : Double.valueOf(d2);
            case 4:
                return readableMap.getString(str);
            case 5:
                return toMap(readableMap.getMap(str));
            case 6:
                return toList(readableMap.getArray(str));
            default:
                throw new IllegalArgumentException(b.D("Could not convert object with key: ", str, CLConstants.DOT_SALT_DELIMETER));
        }
    }

    public static WritableArray toWritableArray(List<Object> list) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (Object obj : list) {
            if (obj == null) {
                writableArrayCreateArray.pushNull();
            } else if (obj instanceof Boolean) {
                writableArrayCreateArray.pushBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Double) {
                writableArrayCreateArray.pushDouble(((Double) obj).doubleValue());
            } else if (obj instanceof Integer) {
                writableArrayCreateArray.pushInt(((Integer) obj).intValue());
            } else if (obj instanceof String) {
                writableArrayCreateArray.pushString((String) obj);
            } else if (obj instanceof Map) {
                writableArrayCreateArray.pushMap(toWritableMap((Map) obj));
            } else if (obj instanceof List) {
                writableArrayCreateArray.pushArray(toWritableArray((List) obj));
            }
        }
        return writableArrayCreateArray;
    }

    public static WritableMap toWritableMap(Map<String, Object> map) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                writableMapCreateMap.putNull(key);
            } else if (value instanceof Boolean) {
                writableMapCreateMap.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                writableMapCreateMap.putDouble(key, ((Double) value).doubleValue());
            } else if (value instanceof Integer) {
                writableMapCreateMap.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof String) {
                writableMapCreateMap.putString(key, (String) value);
            } else if (value instanceof Map) {
                writableMapCreateMap.putMap(key, toWritableMap((Map) value));
            } else if (value instanceof List) {
                writableMapCreateMap.putArray(key, toWritableArray((List) value));
            }
        }
        return writableMapCreateMap;
    }
}
