package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final TypeAdapterFactory f45342c = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter a(Gson gson, TypeToken typeToken) {
            Type type = typeToken.f45460b;
            boolean z = type instanceof GenericArrayType;
            if (!z && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type genericComponentType = z ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
            return new ArrayTypeAdapter(gson, gson.f(new TypeToken(genericComponentType)), C$Gson$Types.e(genericComponentType));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Class f45343a;

    /* renamed from: b, reason: collision with root package name */
    public final TypeAdapter f45344b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class cls) {
        this.f45344b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f45343a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.TypeAdapter
    public final Object b(JsonReader jsonReader) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        if (jsonReader.j0() == JsonToken.f45483i) {
            jsonReader.T();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.a();
        while (jsonReader.x()) {
            arrayList.add(((TypeAdapterRuntimeTypeWrapper) this.f45344b).f45409b.b(jsonReader));
        }
        jsonReader.e();
        int size = arrayList.size();
        Class cls = this.f45343a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) cls, size);
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(objNewInstance, i2, arrayList.get(i2));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (obj == null) {
            jsonWriter.s();
            return;
        }
        jsonWriter.b();
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            this.f45344b.c(jsonWriter, Array.get(obj, i2));
        }
        jsonWriter.e();
    }
}
