package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ConstructorConstructor f45345a;

    public static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        public final TypeAdapter f45346a;

        /* renamed from: b, reason: collision with root package name */
        public final ObjectConstructor f45347b;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, ObjectConstructor objectConstructor) {
            this.f45346a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f45347b = objectConstructor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() == JsonToken.f45483i) {
                jsonReader.T();
                return null;
            }
            Collection collection = (Collection) this.f45347b.a();
            jsonReader.a();
            while (jsonReader.x()) {
                collection.add(((TypeAdapterRuntimeTypeWrapper) this.f45346a).f45409b.b(jsonReader));
            }
            jsonReader.e();
            return collection;
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
            Collection collection = (Collection) obj;
            if (collection == null) {
                jsonWriter.s();
                return;
            }
            jsonWriter.b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f45346a.c(jsonWriter, it.next());
            }
            jsonWriter.e();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f45345a = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter a(Gson gson, TypeToken typeToken) {
        Type type = typeToken.f45460b;
        Class cls = typeToken.f45459a;
        if (!Collection.class.isAssignableFrom(cls)) {
            return null;
        }
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        C$Gson$Preconditions.a(Collection.class.isAssignableFrom(cls));
        Type typeG = C$Gson$Types.g(type, cls, C$Gson$Types.d(type, cls, Collection.class), new HashMap());
        Class cls2 = typeG instanceof ParameterizedType ? ((ParameterizedType) typeG).getActualTypeArguments()[0] : Object.class;
        return new Adapter(gson, cls2, gson.f(new TypeToken(cls2)), this.f45345a.b(typeToken));
    }
}
