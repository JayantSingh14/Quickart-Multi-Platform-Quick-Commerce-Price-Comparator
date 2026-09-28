package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;

/* loaded from: classes.dex */
public final class JsonObject extends JsonElement {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedTreeMap f45256a = new LinkedTreeMap(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof JsonObject) && ((JsonObject) obj).f45256a.equals(this.f45256a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f45256a.hashCode();
    }

    public final void j(String str, JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.f45255a;
        }
        this.f45256a.put(str, jsonElement);
    }

    public final JsonElement k(String str) {
        return (JsonElement) this.f45256a.get(str);
    }

    public final JsonObject m(String str) {
        return (JsonObject) this.f45256a.get(str);
    }
}
