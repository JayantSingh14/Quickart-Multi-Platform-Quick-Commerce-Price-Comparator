package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final Excluder f45296c = new Excluder();

    /* renamed from: a, reason: collision with root package name */
    public final List f45297a;

    /* renamed from: b, reason: collision with root package name */
    public final List f45298b;

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.f45297a = list;
        this.f45298b = list;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter a(final Gson gson, final TypeToken typeToken) {
        Class cls = typeToken.f45459a;
        final boolean zB = b(cls, true);
        final boolean zB2 = b(cls, false);
        if (zB || zB2) {
            return new TypeAdapter<Object>() { // from class: com.google.gson.internal.Excluder.1

                /* renamed from: a, reason: collision with root package name */
                public volatile TypeAdapter f45299a;

                @Override // com.google.gson.TypeAdapter
                public final Object b(JsonReader jsonReader) throws IOException {
                    if (zB2) {
                        jsonReader.E();
                        return null;
                    }
                    TypeAdapter typeAdapterG = this.f45299a;
                    if (typeAdapterG == null) {
                        typeAdapterG = gson.g(Excluder.this, typeToken);
                        this.f45299a = typeAdapterG;
                    }
                    return typeAdapterG.b(jsonReader);
                }

                @Override // com.google.gson.TypeAdapter
                public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                    if (zB) {
                        jsonWriter.s();
                        return;
                    }
                    TypeAdapter typeAdapterG = this.f45299a;
                    if (typeAdapterG == null) {
                        typeAdapterG = gson.g(Excluder.this, typeToken);
                        this.f45299a = typeAdapterG;
                    }
                    typeAdapterG.c(jsonWriter, obj);
                }
            };
        }
        return null;
    }

    public final boolean b(Class cls, boolean z) {
        if (!z && !Enum.class.isAssignableFrom(cls)) {
            ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.f45442a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        Iterator it = (z ? this.f45297a : this.f45298b).iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).a()) {
                return true;
            }
        }
        return false;
    }

    public final Object clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }
}
