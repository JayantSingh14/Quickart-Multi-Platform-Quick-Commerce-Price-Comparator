package com.zeptonow.horizon.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModuleBuilder;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SerializationUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialModuleImpl f48278a;

    /* renamed from: b, reason: collision with root package name */
    public static final Json f48279b;

    static {
        SerializersModuleBuilder serializersModuleBuilder = new SerializersModuleBuilder();
        AnyValueSerializer anyValueSerializer = AnyValueSerializer.f48230a;
        serializersModuleBuilder.a(Reflection.a(Object.class));
        f48278a = new SerialModuleImpl(serializersModuleBuilder.f56121a, serializersModuleBuilder.f56122b, serializersModuleBuilder.f56123c, serializersModuleBuilder.f56124d, serializersModuleBuilder.f56125e);
        f48279b = JsonKt.a(SerializationUtilsKt$jsonInstance$1.f48280c);
    }

    public static final JsonElement a(Object obj) {
        if (obj == null) {
            return JsonNull.INSTANCE;
        }
        if (obj instanceof Double) {
            return JsonElementKt.a((Number) obj);
        }
        if (obj instanceof Boolean) {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
            return new JsonLiteral((Boolean) obj, false, null);
        }
        if (obj instanceof Number) {
            return JsonElementKt.a((Number) obj);
        }
        if (obj instanceof String) {
            return JsonElementKt.b((String) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new SerializationException("Unsupported type: " + Reflection.a(obj.getClass()));
            }
            Iterable iterable = (Iterable) obj;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return new JsonArray(arrayList);
        }
        Set<Map.Entry> setEntrySet = ((Map) obj).entrySet();
        int iF = MapsKt.f(CollectionsKt.r(setEntrySet, 10));
        if (iF < 16) {
            iF = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iF);
        for (Map.Entry entry : setEntrySet) {
            linkedHashMap.put(String.valueOf(entry.getKey()), a(entry.getValue()));
        }
        return new JsonObject(linkedHashMap);
    }
}
