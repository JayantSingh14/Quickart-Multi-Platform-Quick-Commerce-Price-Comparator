package com.google.gson;

import com.zeptoconsumerapp.modules.configservice.entity.ResolvedConfigData;

/* loaded from: classes.dex */
public interface JsonDeserializer<T> {
    ResolvedConfigData a(JsonElement jsonElement, JsonDeserializationContext jsonDeserializationContext);
}
