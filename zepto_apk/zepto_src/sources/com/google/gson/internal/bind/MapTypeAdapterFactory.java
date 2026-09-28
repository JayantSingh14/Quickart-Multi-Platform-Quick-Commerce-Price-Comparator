package com.google.gson.internal.bind;

import android.support.v4.media.b;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes.dex */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ConstructorConstructor f45358a;

    public final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        public final TypeAdapter f45359a;

        /* renamed from: b, reason: collision with root package name */
        public final TypeAdapter f45360b;

        /* renamed from: c, reason: collision with root package name */
        public final ObjectConstructor f45361c;

        public Adapter(Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, ObjectConstructor objectConstructor) {
            this.f45359a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.f45360b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.f45361c = objectConstructor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) throws IOException {
            JsonToken jsonTokenJ0 = jsonReader.j0();
            if (jsonTokenJ0 == JsonToken.f45483i) {
                jsonReader.T();
                return null;
            }
            Map map = (Map) this.f45361c.a();
            if (jsonTokenJ0 != JsonToken.f45475a) {
                jsonReader.k();
                while (jsonReader.x()) {
                    JsonReaderInternalAccess.f45306a.a(jsonReader);
                    Object objB = ((TypeAdapterRuntimeTypeWrapper) this.f45359a).f45409b.b(jsonReader);
                    if (map.put(objB, ((TypeAdapterRuntimeTypeWrapper) this.f45360b).f45409b.b(jsonReader)) != null) {
                        throw new JsonSyntaxException(b.j(objB, "duplicate key: "));
                    }
                }
                jsonReader.t();
                return map;
            }
            jsonReader.a();
            while (jsonReader.x()) {
                jsonReader.a();
                Object objB2 = ((TypeAdapterRuntimeTypeWrapper) this.f45359a).f45409b.b(jsonReader);
                if (map.put(objB2, ((TypeAdapterRuntimeTypeWrapper) this.f45360b).f45409b.b(jsonReader)) != null) {
                    throw new JsonSyntaxException(b.j(objB2, "duplicate key: "));
                }
                jsonReader.e();
            }
            jsonReader.e();
            return map;
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                jsonWriter.s();
                return;
            }
            MapTypeAdapterFactory.this.getClass();
            TypeAdapter typeAdapter = this.f45360b;
            jsonWriter.k();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                jsonWriter.l(String.valueOf(entry.getKey()));
                typeAdapter.c(jsonWriter, entry.getValue());
            }
            jsonWriter.t();
        }
    }

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.f45358a = constructorConstructor;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter a(Gson gson, TypeToken typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.f45460b;
        Class cls = typeToken.f45459a;
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            if (type instanceof WildcardType) {
                type = ((WildcardType) type).getUpperBounds()[0];
            }
            C$Gson$Preconditions.a(Map.class.isAssignableFrom(cls));
            Type typeG = C$Gson$Types.g(type, cls, C$Gson$Types.d(type, cls, Map.class), new HashMap());
            actualTypeArguments = typeG instanceof ParameterizedType ? ((ParameterizedType) typeG).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        return new Adapter(gson, actualTypeArguments[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? TypeAdapters.f45413c : gson.f(new TypeToken(type2)), actualTypeArguments[1], gson.f(new TypeToken(actualTypeArguments[1])), this.f45358a.b(typeToken));
    }
}
