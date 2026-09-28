package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class TypeAdapter<T> {

    /* renamed from: com.google.gson.TypeAdapter$1, reason: invalid class name */
    class AnonymousClass1 extends TypeAdapter<Object> {
        public AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() != JsonToken.f45483i) {
                return TypeAdapter.this.b(jsonReader);
            }
            jsonReader.T();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.s();
            } else {
                TypeAdapter.this.c(jsonWriter, obj);
            }
        }
    }

    public final TypeAdapter a() {
        return new AnonymousClass1();
    }

    public abstract Object b(JsonReader jsonReader);

    public abstract void c(JsonWriter jsonWriter, Object obj);
}
