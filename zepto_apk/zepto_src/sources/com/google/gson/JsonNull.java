package com.google.gson;

/* loaded from: classes.dex */
public final class JsonNull extends JsonElement {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonNull f45255a = new JsonNull();

    @Deprecated
    public JsonNull() {
    }

    public final boolean equals(Object obj) {
        return obj instanceof JsonNull;
    }

    public final int hashCode() {
        return JsonNull.class.hashCode();
    }
}
