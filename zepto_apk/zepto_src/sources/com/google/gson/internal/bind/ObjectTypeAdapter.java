package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.ToNumberPolicy;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ObjectTypeAdapter extends TypeAdapter<Object> {

    /* renamed from: c, reason: collision with root package name */
    public static final TypeAdapterFactory f45367c = new AnonymousClass1(ToNumberPolicy.f45269a);

    /* renamed from: a, reason: collision with root package name */
    public final Gson f45368a;

    /* renamed from: b, reason: collision with root package name */
    public final ToNumberPolicy f45369b;

    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements TypeAdapterFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ToNumberPolicy f45370a;

        public AnonymousClass1(ToNumberPolicy toNumberPolicy) {
            this.f45370a = toNumberPolicy;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.f45459a == Object.class) {
                return new ObjectTypeAdapter(gson, this.f45370a);
            }
            return null;
        }
    }

    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45371a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f45371a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45371a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45371a[5] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45371a[6] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45371a[7] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45371a[8] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ObjectTypeAdapter(Gson gson, ToNumberPolicy toNumberPolicy) {
        this.f45368a = gson;
        this.f45369b = toNumberPolicy;
    }

    public static TypeAdapterFactory d(ToNumberPolicy toNumberPolicy) {
        return toNumberPolicy == ToNumberPolicy.f45269a ? f45367c : new AnonymousClass1(toNumberPolicy);
    }

    @Override // com.google.gson.TypeAdapter
    public final Object b(JsonReader jsonReader) throws IOException {
        Object arrayList;
        Serializable arrayList2;
        JsonToken jsonTokenJ0 = jsonReader.j0();
        int iOrdinal = jsonTokenJ0.ordinal();
        if (iOrdinal == 0) {
            jsonReader.a();
            arrayList = new ArrayList();
        } else if (iOrdinal != 2) {
            arrayList = null;
        } else {
            jsonReader.k();
            arrayList = new LinkedTreeMap();
        }
        if (arrayList == null) {
            return e(jsonReader, jsonTokenJ0);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (jsonReader.x()) {
                String strX = arrayList instanceof Map ? jsonReader.X() : null;
                JsonToken jsonTokenJ02 = jsonReader.j0();
                int iOrdinal2 = jsonTokenJ02.ordinal();
                if (iOrdinal2 == 0) {
                    jsonReader.a();
                    arrayList2 = new ArrayList();
                } else if (iOrdinal2 != 2) {
                    arrayList2 = null;
                } else {
                    jsonReader.k();
                    arrayList2 = new LinkedTreeMap();
                }
                boolean z = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = e(jsonReader, jsonTokenJ02);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(strX, arrayList2);
                }
                if (z) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    jsonReader.e();
                } else {
                    jsonReader.t();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.s();
            return;
        }
        Class<?> cls = obj.getClass();
        Gson gson = this.f45368a;
        gson.getClass();
        TypeAdapter typeAdapterF = gson.f(new TypeToken(cls));
        if (!(typeAdapterF instanceof ObjectTypeAdapter)) {
            typeAdapterF.c(jsonWriter, obj);
        } else {
            jsonWriter.k();
            jsonWriter.t();
        }
    }

    public final Serializable e(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
        int iOrdinal = jsonToken.ordinal();
        if (iOrdinal == 5) {
            return jsonReader.K0();
        }
        if (iOrdinal == 6) {
            return this.f45369b.a(jsonReader);
        }
        if (iOrdinal == 7) {
            return Boolean.valueOf(jsonReader.N());
        }
        if (iOrdinal == 8) {
            jsonReader.T();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + jsonToken);
    }
}
