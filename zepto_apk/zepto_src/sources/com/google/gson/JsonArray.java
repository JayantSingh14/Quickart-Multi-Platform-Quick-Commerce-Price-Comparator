package com.google.gson;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class JsonArray extends JsonElement implements Iterable<JsonElement> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f45254a = new ArrayList();

    @Override // com.google.gson.JsonElement
    public final double b() {
        return j().b();
    }

    @Override // com.google.gson.JsonElement
    public final int d() {
        return j().d();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof JsonArray) && ((JsonArray) obj).f45254a.equals(this.f45254a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f45254a.hashCode();
    }

    @Override // com.google.gson.JsonElement
    public final long i() {
        return j().i();
    }

    @Override // java.lang.Iterable
    public final Iterator<JsonElement> iterator() {
        return this.f45254a.iterator();
    }

    public final JsonElement j() {
        ArrayList arrayList = this.f45254a;
        int size = arrayList.size();
        if (size == 1) {
            return (JsonElement) arrayList.get(0);
        }
        throw new IllegalStateException(b.f(size, "Array must have size 1, but has size "));
    }
}
