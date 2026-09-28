package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* loaded from: classes.dex */
public final class Gson {
    public static final FormattingStyle u = FormattingStyle.f45220d;
    public static final FieldNamingStrategy v = FieldNamingPolicy.f45218a;
    public static final ToNumberStrategy w = ToNumberPolicy.f45269a;
    public static final ToNumberStrategy x = ToNumberPolicy.f45270b;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f45225a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f45226b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstructorConstructor f45227c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f45228d;

    /* renamed from: e, reason: collision with root package name */
    public final List f45229e;

    /* renamed from: f, reason: collision with root package name */
    public final Excluder f45230f;

    /* renamed from: g, reason: collision with root package name */
    public final FieldNamingPolicy f45231g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f45232h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f45233i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f45234j;

    /* renamed from: k, reason: collision with root package name */
    public final FormattingStyle f45235k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f45236l;

    /* renamed from: m, reason: collision with root package name */
    public final int f45237m;
    public final int n;
    public final LongSerializationPolicy o;
    public final List p;
    public final List q;
    public final ToNumberPolicy r;
    public final ToNumberPolicy s;
    public final List t;

    /* renamed from: com.google.gson.Gson$1, reason: invalid class name */
    class AnonymousClass1 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() != JsonToken.f45483i) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.T();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
            Number number = (Number) obj;
            if (number == null) {
                jsonWriter.s();
                return;
            }
            double dDoubleValue = number.doubleValue();
            Gson.a(dDoubleValue);
            jsonWriter.O(dDoubleValue);
        }
    }

    /* renamed from: com.google.gson.Gson$2, reason: invalid class name */
    class AnonymousClass2 extends TypeAdapter<Number> {
        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() != JsonToken.f45483i) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.T();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
            Number numberValueOf = (Number) obj;
            if (numberValueOf == null) {
                jsonWriter.s();
                return;
            }
            float fFloatValue = numberValueOf.floatValue();
            Gson.a(fFloatValue);
            if (!(numberValueOf instanceof Float)) {
                numberValueOf = Float.valueOf(fFloatValue);
            }
            jsonWriter.Z(numberValueOf);
        }
    }

    public static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

        /* renamed from: a, reason: collision with root package name */
        public TypeAdapter f45240a = null;

        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) {
            TypeAdapter typeAdapter = this.f45240a;
            if (typeAdapter != null) {
                return typeAdapter.b(jsonReader);
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) {
            TypeAdapter typeAdapter = this.f45240a;
            if (typeAdapter == null) {
                throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
            }
            typeAdapter.c(jsonWriter, obj);
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public final TypeAdapter d() {
            TypeAdapter typeAdapter = this.f45240a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Gson() {
        Excluder excluder = Excluder.f45296c;
        FieldNamingStrategy fieldNamingStrategy = v;
        Map map = Collections.EMPTY_MAP;
        FormattingStyle formattingStyle = u;
        LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.f45258a;
        List list = Collections.EMPTY_LIST;
        this(excluder, (FieldNamingPolicy) fieldNamingStrategy, map, false, true, formattingStyle, true, longSerializationPolicy, 2, 2, list, list, list, (ToNumberPolicy) w, (ToNumberPolicy) x, list);
    }

    public static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public final Object b(JsonReader jsonReader, TypeToken typeToken) {
        boolean z;
        Strictness strictness = jsonReader.f45463b;
        if (strictness == Strictness.f45266b) {
            jsonReader.f45463b = Strictness.f45265a;
        }
        try {
            try {
                try {
                    jsonReader.j0();
                    z = false;
                    try {
                        return f(typeToken).b(jsonReader);
                    } catch (EOFException e2) {
                        e = e2;
                        if (!z) {
                            throw new JsonSyntaxException(e);
                        }
                        jsonReader.n0(strictness);
                        return null;
                    }
                } finally {
                    jsonReader.n0(strictness);
                }
            } catch (EOFException e3) {
                e = e3;
                z = true;
            }
        } catch (IOException e4) {
            throw new JsonSyntaxException(e4);
        } catch (AssertionError e5) {
            throw new AssertionError("AssertionError (GSON 2.11.0): " + e5.getMessage(), e5);
        } catch (IllegalStateException e6) {
            throw new JsonSyntaxException(e6);
        }
    }

    public final Object c(Reader reader, TypeToken typeToken) {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.n0(Strictness.f45266b);
        Object objB = b(jsonReader, typeToken);
        if (objB != null) {
            try {
                if (jsonReader.j0() != JsonToken.f45484j) {
                    throw new JsonSyntaxException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
        return objB;
    }

    public final Object d(Class cls, String str) {
        return Primitives.a(cls).cast(str == null ? null : c(new StringReader(str), new TypeToken(cls)));
    }

    public final Object e(String str, Type type) {
        TypeToken typeToken = new TypeToken(type);
        if (str == null) {
            return null;
        }
        return c(new StringReader(str), typeToken);
    }

    public final TypeAdapter f(TypeToken typeToken) {
        boolean z;
        Objects.requireNonNull(typeToken, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.f45226b;
        TypeAdapter typeAdapter = (TypeAdapter) concurrentHashMap.get(typeToken);
        if (typeAdapter != null) {
            return typeAdapter;
        }
        ThreadLocal threadLocal = this.f45225a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z = true;
        } else {
            TypeAdapter typeAdapter2 = (TypeAdapter) map.get(typeToken);
            if (typeAdapter2 != null) {
                return typeAdapter2;
            }
            z = false;
        }
        try {
            FutureTypeAdapter futureTypeAdapter = new FutureTypeAdapter();
            map.put(typeToken, futureTypeAdapter);
            Iterator it = this.f45229e.iterator();
            TypeAdapter typeAdapterA = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                typeAdapterA = ((TypeAdapterFactory) it.next()).a(this, typeToken);
                if (typeAdapterA != null) {
                    if (futureTypeAdapter.f45240a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    futureTypeAdapter.f45240a = typeAdapterA;
                    map.put(typeToken, typeAdapterA);
                }
            }
            if (z) {
                threadLocal.remove();
            }
            if (typeAdapterA != null) {
                if (z) {
                    concurrentHashMap.putAll(map);
                }
                return typeAdapterA;
            }
            throw new IllegalArgumentException("GSON (2.11.0) cannot handle " + typeToken);
        } catch (Throwable th) {
            if (z) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.TypeAdapter g(com.google.gson.TypeAdapterFactory r7, com.google.gson.reflect.TypeToken r8) {
        /*
            r6 = this;
            java.lang.String r0 = "skipPast must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r8, r0)
            com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory r0 = r6.f45228d
            r0.getClass()
            com.google.gson.TypeAdapterFactory r1 = com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.f45353c
            if (r7 != r1) goto L14
            goto L57
        L14:
            java.util.concurrent.ConcurrentHashMap r1 = r0.f45356b
            java.lang.Class r2 = r8.f45459a
            java.lang.Object r3 = r1.get(r2)
            com.google.gson.TypeAdapterFactory r3 = (com.google.gson.TypeAdapterFactory) r3
            if (r3 == 0) goto L23
            if (r3 != r7) goto L58
            goto L57
        L23:
            java.lang.Class<com.google.gson.annotations.JsonAdapter> r3 = com.google.gson.annotations.JsonAdapter.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)
            com.google.gson.annotations.JsonAdapter r3 = (com.google.gson.annotations.JsonAdapter) r3
            if (r3 != 0) goto L2e
            goto L58
        L2e:
            java.lang.Class r3 = r3.value()
            java.lang.Class<com.google.gson.TypeAdapterFactory> r4 = com.google.gson.TypeAdapterFactory.class
            boolean r4 = r4.isAssignableFrom(r3)
            if (r4 != 0) goto L3b
            goto L58
        L3b:
            com.google.gson.internal.ConstructorConstructor r4 = r0.f45355a
            com.google.gson.reflect.TypeToken r5 = new com.google.gson.reflect.TypeToken
            r5.<init>(r3)
            com.google.gson.internal.ObjectConstructor r3 = r4.b(r5)
            java.lang.Object r3 = r3.a()
            com.google.gson.TypeAdapterFactory r3 = (com.google.gson.TypeAdapterFactory) r3
            java.lang.Object r1 = r1.putIfAbsent(r2, r3)
            com.google.gson.TypeAdapterFactory r1 = (com.google.gson.TypeAdapterFactory) r1
            if (r1 == 0) goto L55
            r3 = r1
        L55:
            if (r3 != r7) goto L58
        L57:
            r7 = r0
        L58:
            java.util.List r0 = r6.f45229e
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L5f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L78
            java.lang.Object r2 = r0.next()
            com.google.gson.TypeAdapterFactory r2 = (com.google.gson.TypeAdapterFactory) r2
            if (r1 != 0) goto L71
            if (r2 != r7) goto L5f
            r1 = 1
            goto L5f
        L71:
            com.google.gson.TypeAdapter r2 = r2.a(r6, r8)
            if (r2 == 0) goto L5f
            return r2
        L78:
            if (r1 != 0) goto L7f
            com.google.gson.TypeAdapter r7 = r6.f(r8)
            return r7
        L7f:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "GSON cannot serialize or deserialize "
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.g(com.google.gson.TypeAdapterFactory, com.google.gson.reflect.TypeToken):com.google.gson.TypeAdapter");
    }

    public final JsonWriter h(Writer writer) {
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.A(this.f45235k);
        jsonWriter.f45496i = this.f45234j;
        jsonWriter.D(Strictness.f45266b);
        jsonWriter.f45498k = this.f45233i;
        return jsonWriter;
    }

    public final String i(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        try {
            k(jsonElement, h(stringWriter));
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final String j(Object obj) {
        if (obj == null) {
            return i(JsonNull.f45255a);
        }
        Class cls = obj.getClass();
        StringWriter stringWriter = new StringWriter();
        try {
            l(obj, cls, h(stringWriter));
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final void k(JsonElement jsonElement, JsonWriter jsonWriter) {
        Strictness strictness = jsonWriter.f45495h;
        boolean z = jsonWriter.f45496i;
        boolean z2 = jsonWriter.f45498k;
        jsonWriter.f45496i = this.f45234j;
        jsonWriter.f45498k = this.f45233i;
        if (strictness == Strictness.f45266b) {
            jsonWriter.f45495h = Strictness.f45265a;
        }
        try {
            try {
                try {
                    TypeAdapters.z.c(jsonWriter, jsonElement);
                    jsonWriter.D(strictness);
                    jsonWriter.f45496i = z;
                    jsonWriter.f45498k = z2;
                } catch (IOException e2) {
                    throw new JsonIOException(e2);
                }
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.11.0): " + e3.getMessage(), e3);
            }
        } catch (Throwable th) {
            jsonWriter.D(strictness);
            jsonWriter.f45496i = z;
            jsonWriter.f45498k = z2;
            throw th;
        }
    }

    public final void l(Object obj, Class cls, JsonWriter jsonWriter) {
        TypeAdapter typeAdapterF = f(new TypeToken(cls));
        Strictness strictness = jsonWriter.f45495h;
        if (strictness == Strictness.f45266b) {
            jsonWriter.f45495h = Strictness.f45265a;
        }
        boolean z = jsonWriter.f45496i;
        boolean z2 = jsonWriter.f45498k;
        jsonWriter.f45496i = this.f45234j;
        jsonWriter.f45498k = this.f45233i;
        try {
            try {
                typeAdapterF.c(jsonWriter, obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.11.0): " + e3.getMessage(), e3);
            }
        } finally {
            jsonWriter.D(strictness);
            jsonWriter.f45496i = z;
            jsonWriter.f45498k = z2;
        }
    }

    public final JsonElement m(Object obj) {
        if (obj == null) {
            return JsonNull.f45255a;
        }
        Class cls = obj.getClass();
        JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
        l(obj, cls, jsonTreeWriter);
        ArrayList arrayList = jsonTreeWriter.o;
        if (arrayList.isEmpty()) {
            return jsonTreeWriter.q;
        }
        throw new IllegalStateException("Expected one JSON element but was " + arrayList);
    }

    public final String toString() {
        return "{serializeNulls:" + this.f45233i + ",factories:" + this.f45229e + ",instanceCreators:" + this.f45227c + "}";
    }

    public Gson(Excluder excluder, FieldNamingPolicy fieldNamingPolicy, Map map, boolean z, boolean z2, FormattingStyle formattingStyle, boolean z3, LongSerializationPolicy longSerializationPolicy, int i2, int i3, List list, List list2, List list3, ToNumberPolicy toNumberPolicy, ToNumberPolicy toNumberPolicy2, List list4) {
        final TypeAdapter<Number> typeAdapter;
        TypeAdapterFactory typeAdapterFactoryD;
        this.f45225a = new ThreadLocal();
        this.f45226b = new ConcurrentHashMap();
        this.f45230f = excluder;
        this.f45231g = fieldNamingPolicy;
        this.f45232h = map;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(map, z3, list4);
        this.f45227c = constructorConstructor;
        this.f45233i = z;
        this.f45234j = z2;
        this.f45235k = formattingStyle;
        this.f45236l = z3;
        this.o = longSerializationPolicy;
        this.f45237m = i2;
        this.n = i3;
        this.p = list;
        this.q = list2;
        this.r = toNumberPolicy;
        this.s = toNumberPolicy2;
        this.t = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.A);
        arrayList.add(ObjectTypeAdapter.d(toNumberPolicy));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.p);
        arrayList.add(TypeAdapters.f45417g);
        arrayList.add(TypeAdapters.f45414d);
        arrayList.add(TypeAdapters.f45415e);
        arrayList.add(TypeAdapters.f45416f);
        if (longSerializationPolicy == LongSerializationPolicy.f45258a) {
            typeAdapter = TypeAdapters.f45421k;
        } else {
            typeAdapter = new TypeAdapter<Number>() { // from class: com.google.gson.Gson.3
                @Override // com.google.gson.TypeAdapter
                public final Object b(JsonReader jsonReader) throws IOException {
                    if (jsonReader.j0() != JsonToken.f45483i) {
                        return Long.valueOf(jsonReader.nextLong());
                    }
                    jsonReader.T();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                    Number number = (Number) obj;
                    if (number == null) {
                        jsonWriter.s();
                    } else {
                        jsonWriter.j0(number.toString());
                    }
                }
            };
        }
        arrayList.add(TypeAdapters.c(Long.TYPE, Long.class, typeAdapter));
        arrayList.add(TypeAdapters.c(Double.TYPE, Double.class, new AnonymousClass1()));
        arrayList.add(TypeAdapters.c(Float.TYPE, Float.class, new AnonymousClass2()));
        if (toNumberPolicy2 == ToNumberPolicy.f45270b) {
            typeAdapterFactoryD = NumberTypeAdapter.f45363b;
        } else {
            typeAdapterFactoryD = NumberTypeAdapter.d(toNumberPolicy2);
        }
        arrayList.add(typeAdapterFactoryD);
        arrayList.add(TypeAdapters.f45418h);
        arrayList.add(TypeAdapters.f45419i);
        arrayList.add(TypeAdapters.b(AtomicLong.class, new TypeAdapter.AnonymousClass1()));
        arrayList.add(TypeAdapters.b(AtomicLongArray.class, new TypeAdapter.AnonymousClass1()));
        arrayList.add(TypeAdapters.f45420j);
        arrayList.add(TypeAdapters.f45422l);
        arrayList.add(TypeAdapters.q);
        arrayList.add(TypeAdapters.r);
        arrayList.add(TypeAdapters.b(BigDecimal.class, TypeAdapters.f45423m));
        arrayList.add(TypeAdapters.b(BigInteger.class, TypeAdapters.n));
        arrayList.add(TypeAdapters.b(LazilyParsedNumber.class, TypeAdapters.o));
        arrayList.add(TypeAdapters.s);
        arrayList.add(TypeAdapters.t);
        arrayList.add(TypeAdapters.v);
        arrayList.add(TypeAdapters.w);
        arrayList.add(TypeAdapters.y);
        arrayList.add(TypeAdapters.u);
        arrayList.add(TypeAdapters.f45412b);
        arrayList.add(DefaultDateTypeAdapter.f45348c);
        arrayList.add(TypeAdapters.x);
        if (SqlTypesSupport.f45453a) {
            arrayList.add(SqlTypesSupport.f45457e);
            arrayList.add(SqlTypesSupport.f45456d);
            arrayList.add(SqlTypesSupport.f45458f);
        }
        arrayList.add(ArrayTypeAdapter.f45342c);
        arrayList.add(TypeAdapters.f45411a);
        arrayList.add(new CollectionTypeAdapterFactory(constructorConstructor));
        arrayList.add(new MapTypeAdapterFactory(constructorConstructor));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(constructorConstructor);
        this.f45228d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.B);
        arrayList.add(new ReflectiveTypeAdapterFactory(constructorConstructor, fieldNamingPolicy, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.f45229e = Collections.unmodifiableList(arrayList);
    }
}
