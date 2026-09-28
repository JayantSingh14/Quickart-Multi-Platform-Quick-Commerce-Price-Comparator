package com.zeptonow.horizon.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class EventPropertiesFilter {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap f48239a = new LinkedHashMap();

    public static List a(String str, List list) {
        LinkedHashMap linkedHashMap = f48239a;
        List list2 = (List) linkedHashMap.get(str);
        if (list2 != null) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List listSplit$default = StringsKt__StringsKt.split$default((String) it.next(), new String[]{"->"}, false, 0, 6, null);
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = listSplit$default.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String string = StringsKt.b0((String) it2.next()).toString();
                String str2 = string.length() != 0 ? string : null;
                if (str2 != null) {
                    arrayList2.add(str2);
                }
            }
            if (arrayList2.isEmpty()) {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                arrayList.add(arrayList2);
            }
        }
        linkedHashMap.put(str, arrayList);
        return arrayList;
    }

    public static JsonObject b(JsonObject jsonObject, List list) {
        if (list.isEmpty()) {
            return jsonObject;
        }
        String str = (String) CollectionsKt.z(list);
        List listV = CollectionsKt.v(list);
        if (listV.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : jsonObject.f55996a.entrySet()) {
                if (!Intrinsics.b((String) entry.getKey(), str)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return new JsonObject(linkedHashMap);
        }
        JsonElement jsonElement = (JsonElement) jsonObject.get(str);
        if (!(jsonElement instanceof JsonObject)) {
            return jsonObject;
        }
        JsonObject jsonObjectB = b((JsonObject) jsonElement, listV);
        LinkedHashMap linkedHashMapN = MapsKt.n(jsonObject);
        linkedHashMapN.put(str, jsonObjectB);
        return new JsonObject(linkedHashMapN);
    }
}
