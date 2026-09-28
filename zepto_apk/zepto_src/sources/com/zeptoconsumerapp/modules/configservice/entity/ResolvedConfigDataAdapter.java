package com.zeptoconsumerapp.modules.configservice.entity;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ResolvedConfigDataAdapter implements JsonSerializer<ResolvedConfigData>, JsonDeserializer<ResolvedConfigData> {
    @Override // com.google.gson.JsonDeserializer
    public final ResolvedConfigData a(JsonElement jsonElement, JsonDeserializationContext jsonDeserializationContext) {
        JsonObject jsonObjectF = jsonElement != null ? jsonElement.f() : new JsonObject();
        JsonElement jsonElementK = jsonObjectF.k("version");
        long jI = jsonElementK != null ? jsonElementK.i() : 0L;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<Map.Entry> setEntrySet = jsonObjectF.f45256a.entrySet();
        Intrinsics.checkNotNullExpressionValue(setEntrySet, "entrySet(...)");
        for (Map.Entry entry : setEntrySet) {
            Intrinsics.c(entry);
            String str = (String) entry.getKey();
            JsonElement jsonElement2 = (JsonElement) entry.getValue();
            if (!Intrinsics.b(str, "version")) {
                linkedHashMap.put(str, jsonDeserializationContext != null ? (ResolvedConfig) jsonDeserializationContext.b(jsonElement2) : null);
            }
        }
        return new ResolvedConfigData(jI, linkedHashMap);
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonObject b(Object obj, JsonSerializationContext jsonSerializationContext) {
        JsonElement jsonElementA;
        ResolvedConfigData resolvedConfigData = (ResolvedConfigData) obj;
        JsonObject jsonObject = new JsonObject();
        if (resolvedConfigData != null) {
            jsonObject.j("version", new JsonPrimitive(Long.valueOf(resolvedConfigData.b())));
            for (Map.Entry entry : resolvedConfigData.a().entrySet()) {
                String str = (String) entry.getKey();
                ResolvedConfig resolvedConfig = (ResolvedConfig) entry.getValue();
                if (jsonSerializationContext != null && (jsonElementA = jsonSerializationContext.a(resolvedConfig)) != null) {
                    jsonObject.j(str, jsonElementA);
                }
            }
        }
        return jsonObject;
    }
}
