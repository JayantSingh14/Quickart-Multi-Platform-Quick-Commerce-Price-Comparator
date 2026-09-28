package com.zeptoconsumerapp.modules.utils;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public final class JsonUtils {
    public static HashMap a(String jsonString) {
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        HashMap map = new HashMap();
        JSONObject jSONObject = new JSONObject(jsonString);
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jSONObject.getString(next));
        }
        return map;
    }
}
