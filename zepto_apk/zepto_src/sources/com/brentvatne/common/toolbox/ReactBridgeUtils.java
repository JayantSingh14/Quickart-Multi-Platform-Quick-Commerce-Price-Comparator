package com.brentvatne.common.toolbox;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ReactBridgeUtils {
    public static final ReadableArray a(ReadableMap readableMap, String str) {
        if (readableMap == null || !readableMap.hasKey(str) || readableMap.isNull(str)) {
            return null;
        }
        return readableMap.getArray(str);
    }

    public static final boolean b(ReadableMap readableMap, String str, boolean z) {
        return (readableMap == null || !readableMap.hasKey(str) || readableMap.isNull(str)) ? z : readableMap.getBoolean(str);
    }

    public static final double c(ReadableMap readableMap, String str) {
        if (!readableMap.hasKey(str) || readableMap.isNull(str)) {
            return -1.0d;
        }
        return readableMap.getDouble(str);
    }

    public static final float d(ReadableMap readableMap, String str, float f2) {
        return (readableMap == null || !readableMap.hasKey(str) || readableMap.isNull(str)) ? f2 : (float) readableMap.getDouble(str);
    }

    public static final int e(int i2, String str, ReadableMap readableMap) {
        return (readableMap == null || !readableMap.hasKey(str) || readableMap.isNull(str)) ? i2 : readableMap.getInt(str);
    }

    public static final ReadableMap f(ReadableMap readableMap, String str) {
        if (readableMap == null || !readableMap.hasKey(str) || readableMap.isNull(str)) {
            return null;
        }
        return readableMap.getMap(str);
    }

    public static final String g(ReadableMap readableMap, String str) {
        return h(readableMap, str, null);
    }

    public static final String h(ReadableMap readableMap, String str, String str2) {
        return (readableMap == null || !readableMap.hasKey(str) || readableMap.isNull(str)) ? str2 : readableMap.getString(str);
    }

    public static final int i(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return -1;
        }
    }
}
