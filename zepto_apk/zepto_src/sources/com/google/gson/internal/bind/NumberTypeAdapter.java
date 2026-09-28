package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes.dex */
public final class NumberTypeAdapter extends TypeAdapter<Number> {

    /* renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory f45363b = d(ToNumberPolicy.f45270b);

    /* renamed from: a, reason: collision with root package name */
    public final ToNumberPolicy f45364a;

    /* renamed from: com.google.gson.internal.bind.NumberTypeAdapter$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45366a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f45366a = iArr;
            try {
                iArr[8] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45366a[6] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45366a[5] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public NumberTypeAdapter(ToNumberPolicy toNumberPolicy) {
        this.f45364a = toNumberPolicy;
    }

    public static TypeAdapterFactory d(ToNumberPolicy toNumberPolicy) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.NumberTypeAdapter.1
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.f45459a == Number.class) {
                    return NumberTypeAdapter.this;
                }
                return null;
            }
        };
    }

    @Override // com.google.gson.TypeAdapter
    public final Object b(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenJ0 = jsonReader.j0();
        int iOrdinal = jsonTokenJ0.ordinal();
        if (iOrdinal == 5 || iOrdinal == 6) {
            return this.f45364a.a(jsonReader);
        }
        if (iOrdinal == 8) {
            jsonReader.T();
            return null;
        }
        throw new JsonSyntaxException("Expecting number, got: " + jsonTokenJ0 + "; at path " + jsonReader.j());
    }

    @Override // com.google.gson.TypeAdapter
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        jsonWriter.Z((Number) obj);
    }
}
