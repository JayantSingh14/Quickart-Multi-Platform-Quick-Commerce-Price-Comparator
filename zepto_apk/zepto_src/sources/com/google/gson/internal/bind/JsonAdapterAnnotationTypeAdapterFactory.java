package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: c, reason: collision with root package name */
    public static final TypeAdapterFactory f45353c;

    /* renamed from: d, reason: collision with root package name */
    public static final TypeAdapterFactory f45354d;

    /* renamed from: a, reason: collision with root package name */
    public final ConstructorConstructor f45355a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f45356b = new ConcurrentHashMap();

    public static class DummyTypeAdapterFactory implements TypeAdapterFactory {
        private DummyTypeAdapterFactory() {
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter a(Gson gson, TypeToken typeToken) {
            throw new AssertionError("Factory should not be used");
        }

        public /* synthetic */ DummyTypeAdapterFactory(int i2) {
            this();
        }
    }

    static {
        int i2 = 0;
        f45353c = new DummyTypeAdapterFactory(i2);
        f45354d = new DummyTypeAdapterFactory(i2);
    }

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f45355a = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter a(Gson gson, TypeToken typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.f45459a.getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return b(this.f45355a, gson, typeToken, jsonAdapter, true);
    }

    public final TypeAdapter b(ConstructorConstructor constructorConstructor, Gson gson, TypeToken typeToken, JsonAdapter jsonAdapter, boolean z) {
        TypeAdapter typeAdapterA;
        Object objA = constructorConstructor.b(new TypeToken(jsonAdapter.value())).a();
        boolean zNullSafe = jsonAdapter.nullSafe();
        if (objA instanceof TypeAdapter) {
            typeAdapterA = (TypeAdapter) objA;
        } else if (objA instanceof TypeAdapterFactory) {
            TypeAdapterFactory typeAdapterFactory = (TypeAdapterFactory) objA;
            if (z) {
                TypeAdapterFactory typeAdapterFactory2 = (TypeAdapterFactory) this.f45356b.putIfAbsent(typeToken.f45459a, typeAdapterFactory);
                if (typeAdapterFactory2 != null) {
                    typeAdapterFactory = typeAdapterFactory2;
                }
            }
            typeAdapterA = typeAdapterFactory.a(gson, typeToken);
        } else {
            boolean z2 = objA instanceof JsonSerializer;
            if (!z2 && !(objA instanceof JsonDeserializer)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + C$Gson$Types.h(typeToken.f45460b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            TreeTypeAdapter treeTypeAdapter = new TreeTypeAdapter(z2 ? (JsonSerializer) objA : null, objA instanceof JsonDeserializer ? (JsonDeserializer) objA : null, gson, typeToken, z ? f45353c : f45354d, zNullSafe);
            zNullSafe = false;
            typeAdapterA = treeTypeAdapter;
        }
        return (typeAdapterA == null || !zNullSafe) ? typeAdapterA : typeAdapterA.a();
    }
}
