package com.google.gson.internal.bind;

import android.support.v4.media.b;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.NumberLimits;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* loaded from: classes.dex */
public final class TypeAdapters {
    public static final TypeAdapterFactory A;
    public static final TypeAdapterFactory B;

    /* renamed from: a, reason: collision with root package name */
    public static final TypeAdapterFactory f45411a = new AnonymousClass31(Class.class, new TypeAdapter<Class>() { // from class: com.google.gson.internal.bind.TypeAdapters.1
        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + TroubleshootingGuide.a("java-lang-class-unsupported"));
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) {
            throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + ((Class) obj).getName() + ". Forgot to register a type adapter?\nSee " + TroubleshootingGuide.a("java-lang-class-unsupported"));
        }
    }.a());

    /* renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory f45412b = new AnonymousClass31(BitSet.class, new TypeAdapter<BitSet>() { // from class: com.google.gson.internal.bind.TypeAdapters.2
        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) throws IOException, NumberFormatException {
            boolean zN;
            BitSet bitSet = new BitSet();
            jsonReader.a();
            JsonToken jsonTokenJ0 = jsonReader.j0();
            int i2 = 0;
            while (jsonTokenJ0 != JsonToken.f45476b) {
                int iOrdinal = jsonTokenJ0.ordinal();
                if (iOrdinal == 5 || iOrdinal == 6) {
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt == 0) {
                        zN = false;
                    } else {
                        if (iNextInt != 1) {
                            StringBuilder sbU = b.u(iNextInt, "Invalid bitset value ", ", expected 0 or 1; at path ");
                            sbU.append(jsonReader.s());
                            throw new JsonSyntaxException(sbU.toString());
                        }
                        zN = true;
                    }
                } else {
                    if (iOrdinal != 7) {
                        throw new JsonSyntaxException("Invalid bitset value type: " + jsonTokenJ0 + "; at path " + jsonReader.j());
                    }
                    zN = jsonReader.N();
                }
                if (zN) {
                    bitSet.set(i2);
                }
                i2++;
                jsonTokenJ0 = jsonReader.j0();
            }
            jsonReader.e();
            return bitSet;
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
            BitSet bitSet = (BitSet) obj;
            jsonWriter.b();
            int length = bitSet.length();
            for (int i2 = 0; i2 < length; i2++) {
                jsonWriter.T(bitSet.get(i2) ? 1L : 0L);
            }
            jsonWriter.e();
        }
    }.a());

    /* renamed from: c, reason: collision with root package name */
    public static final TypeAdapter f45413c;

    /* renamed from: d, reason: collision with root package name */
    public static final TypeAdapterFactory f45414d;

    /* renamed from: e, reason: collision with root package name */
    public static final TypeAdapterFactory f45415e;

    /* renamed from: f, reason: collision with root package name */
    public static final TypeAdapterFactory f45416f;

    /* renamed from: g, reason: collision with root package name */
    public static final TypeAdapterFactory f45417g;

    /* renamed from: h, reason: collision with root package name */
    public static final TypeAdapterFactory f45418h;

    /* renamed from: i, reason: collision with root package name */
    public static final TypeAdapterFactory f45419i;

    /* renamed from: j, reason: collision with root package name */
    public static final TypeAdapterFactory f45420j;

    /* renamed from: k, reason: collision with root package name */
    public static final TypeAdapter f45421k;

    /* renamed from: l, reason: collision with root package name */
    public static final TypeAdapterFactory f45422l;

    /* renamed from: m, reason: collision with root package name */
    public static final TypeAdapter f45423m;
    public static final TypeAdapter n;
    public static final TypeAdapter o;
    public static final TypeAdapterFactory p;
    public static final TypeAdapterFactory q;
    public static final TypeAdapterFactory r;
    public static final TypeAdapterFactory s;
    public static final TypeAdapterFactory t;
    public static final TypeAdapterFactory u;
    public static final TypeAdapterFactory v;
    public static final TypeAdapterFactory w;
    public static final TypeAdapterFactory x;
    public static final TypeAdapterFactory y;
    public static final TypeAdapter z;

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$31, reason: invalid class name */
    class AnonymousClass31 implements TypeAdapterFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f45426a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TypeAdapter f45427b;

        public AnonymousClass31(Class cls, TypeAdapter typeAdapter) {
            this.f45426a = cls;
            this.f45427b = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.f45459a == this.f45426a) {
                return this.f45427b;
            }
            return null;
        }

        public final String toString() {
            return "Factory[type=" + this.f45426a.getName() + ",adapter=" + this.f45427b + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$32, reason: invalid class name */
    class AnonymousClass32 implements TypeAdapterFactory {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Class f45428a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f45429b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TypeAdapter f45430c;

        public AnonymousClass32(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.f45428a = cls;
            this.f45429b = cls2;
            this.f45430c = typeAdapter;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public final TypeAdapter a(Gson gson, TypeToken typeToken) {
            Class cls = typeToken.f45459a;
            if (cls == this.f45428a || cls == this.f45429b) {
                return this.f45430c;
            }
            return null;
        }

        public final String toString() {
            return "Factory[type=" + this.f45429b.getName() + "+" + this.f45428a.getName() + ",adapter=" + this.f45430c + "]";
        }
    }

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$42, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass42 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45436a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f45436a = iArr;
            try {
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45436a[5] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45436a[7] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45436a[0] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45436a[2] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45436a[8] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f45437a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f45438b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f45439c = new HashMap();

        public EnumTypeAdapter(final Class cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new PrivilegedAction<Field[]>() { // from class: com.google.gson.internal.bind.TypeAdapters.EnumTypeAdapter.1
                    @Override // java.security.PrivilegedAction
                    public final Field[] run() throws SecurityException {
                        Field[] declaredFields = cls.getDeclaredFields();
                        ArrayList arrayList = new ArrayList(declaredFields.length);
                        for (Field field2 : declaredFields) {
                            if (field2.isEnumConstant()) {
                                arrayList.add(field2);
                            }
                        }
                        Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                        AccessibleObject.setAccessible(fieldArr, true);
                        return fieldArr;
                    }
                })) {
                    Enum r4 = (Enum) field.get(null);
                    String strName = r4.name();
                    String string = r4.toString();
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        strName = serializedName.value();
                        for (String str : serializedName.alternate()) {
                            this.f45437a.put(str, r4);
                        }
                    }
                    this.f45437a.put(strName, r4);
                    this.f45438b.put(string, r4);
                    this.f45439c.put(r4, strName);
                }
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() == JsonToken.f45483i) {
                jsonReader.T();
                return null;
            }
            String strK0 = jsonReader.K0();
            Enum r0 = (Enum) this.f45437a.get(strK0);
            return r0 == null ? (Enum) this.f45438b.get(strK0) : r0;
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
            Enum r3 = (Enum) obj;
            jsonWriter.j0(r3 == null ? null : (String) this.f45439c.get(r3));
        }
    }

    static {
        TypeAdapter<Boolean> typeAdapter = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenJ0 = jsonReader.j0();
                if (jsonTokenJ0 != JsonToken.f45483i) {
                    return jsonTokenJ0 == JsonToken.f45480f ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.K0())) : Boolean.valueOf(jsonReader.N());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.V((Boolean) obj);
            }
        };
        f45413c = new TypeAdapter<Boolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.f45483i) {
                    return Boolean.valueOf(jsonReader.K0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                Boolean bool = (Boolean) obj;
                jsonWriter.j0(bool == null ? "null" : bool.toString());
            }
        };
        f45414d = new AnonymousClass32(Boolean.TYPE, Boolean.class, typeAdapter);
        f45415e = new AnonymousClass32(Byte.TYPE, Byte.class, new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                try {
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt <= 255 && iNextInt >= -128) {
                        return Byte.valueOf((byte) iNextInt);
                    }
                    StringBuilder sbU = b.u(iNextInt, "Lossy conversion from ", " to byte; at path ");
                    sbU.append(jsonReader.s());
                    throw new JsonSyntaxException(sbU.toString());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                if (((Number) obj) == null) {
                    jsonWriter.s();
                } else {
                    jsonWriter.T(r4.byteValue());
                }
            }
        });
        f45416f = new AnonymousClass32(Short.TYPE, Short.class, new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                try {
                    int iNextInt = jsonReader.nextInt();
                    if (iNextInt <= 65535 && iNextInt >= -32768) {
                        return Short.valueOf((short) iNextInt);
                    }
                    StringBuilder sbU = b.u(iNextInt, "Lossy conversion from ", " to short; at path ");
                    sbU.append(jsonReader.s());
                    throw new JsonSyntaxException(sbU.toString());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                if (((Number) obj) == null) {
                    jsonWriter.s();
                } else {
                    jsonWriter.T(r4.shortValue());
                }
            }
        });
        f45417g = new AnonymousClass32(Integer.TYPE, Integer.class, new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.nextInt());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                if (((Number) obj) == null) {
                    jsonWriter.s();
                } else {
                    jsonWriter.T(r4.intValue());
                }
            }
        });
        f45418h = new AnonymousClass31(AtomicInteger.class, new TypeAdapter<AtomicInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) {
                try {
                    return new AtomicInteger(jsonReader.nextInt());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.T(((AtomicInteger) obj).get());
            }
        }.a());
        f45419i = new AnonymousClass31(AtomicBoolean.class, new TypeAdapter<AtomicBoolean>() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) {
                return new AtomicBoolean(jsonReader.N());
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.k0(((AtomicBoolean) obj).get());
            }
        }.a());
        f45420j = new AnonymousClass31(AtomicIntegerArray.class, new TypeAdapter<AtomicIntegerArray>() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                ArrayList arrayList = new ArrayList();
                jsonReader.a();
                while (jsonReader.x()) {
                    try {
                        arrayList.add(Integer.valueOf(jsonReader.nextInt()));
                    } catch (NumberFormatException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                }
                jsonReader.e();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicIntegerArray.set(i2, ((Integer) arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.b();
                int length = ((AtomicIntegerArray) obj).length();
                for (int i2 = 0; i2 < length; i2++) {
                    jsonWriter.T(r6.get(i2));
                }
                jsonWriter.e();
            }
        }.a());
        f45421k = new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.nextLong());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                Number number = (Number) obj;
                if (number == null) {
                    jsonWriter.s();
                } else {
                    jsonWriter.T(number.longValue());
                }
            }
        };
        new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.12
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
                if (!(numberValueOf instanceof Float)) {
                    numberValueOf = Float.valueOf(numberValueOf.floatValue());
                }
                jsonWriter.Z(numberValueOf);
            }
        };
        new TypeAdapter<Number>() { // from class: com.google.gson.internal.bind.TypeAdapters.13
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
                } else {
                    jsonWriter.O(number.doubleValue());
                }
            }
        };
        f45422l = new AnonymousClass32(Character.TYPE, Character.class, new TypeAdapter<Character>() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                String strK0 = jsonReader.K0();
                if (strK0.length() == 1) {
                    return Character.valueOf(strK0.charAt(0));
                }
                StringBuilder sbY = b.y("Expecting character, got: ", strK0, "; at ");
                sbY.append(jsonReader.s());
                throw new JsonSyntaxException(sbY.toString());
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                Character ch2 = (Character) obj;
                jsonWriter.j0(ch2 == null ? null : String.valueOf(ch2));
            }
        });
        TypeAdapter<String> typeAdapter2 = new TypeAdapter<String>() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenJ0 = jsonReader.j0();
                if (jsonTokenJ0 != JsonToken.f45483i) {
                    return jsonTokenJ0 == JsonToken.f45482h ? Boolean.toString(jsonReader.N()) : jsonReader.K0();
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.j0((String) obj);
            }
        };
        f45423m = new TypeAdapter<BigDecimal>() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                String strK0 = jsonReader.K0();
                try {
                    return NumberLimits.b(strK0);
                } catch (NumberFormatException e2) {
                    StringBuilder sbY = b.y("Failed parsing '", strK0, "' as BigDecimal; at path ");
                    sbY.append(jsonReader.s());
                    throw new JsonSyntaxException(sbY.toString(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.Z((BigDecimal) obj);
            }
        };
        n = new TypeAdapter<BigInteger>() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                String strK0 = jsonReader.K0();
                try {
                    return NumberLimits.c(strK0);
                } catch (NumberFormatException e2) {
                    StringBuilder sbY = b.y("Failed parsing '", strK0, "' as BigInteger; at path ");
                    sbY.append(jsonReader.s());
                    throw new JsonSyntaxException(sbY.toString(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.Z((BigInteger) obj);
            }
        };
        o = new TypeAdapter<LazilyParsedNumber>() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.f45483i) {
                    return new LazilyParsedNumber(jsonReader.K0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.Z((LazilyParsedNumber) obj);
            }
        };
        p = new AnonymousClass31(String.class, typeAdapter2);
        q = new AnonymousClass31(StringBuilder.class, new TypeAdapter<StringBuilder>() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.f45483i) {
                    return new StringBuilder(jsonReader.K0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                StringBuilder sb = (StringBuilder) obj;
                jsonWriter.j0(sb == null ? null : sb.toString());
            }
        });
        r = new AnonymousClass31(StringBuffer.class, new TypeAdapter<StringBuffer>() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.f45483i) {
                    return new StringBuffer(jsonReader.K0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                StringBuffer stringBuffer = (StringBuffer) obj;
                jsonWriter.j0(stringBuffer == null ? null : stringBuffer.toString());
            }
        });
        s = new AnonymousClass31(URL.class, new TypeAdapter<URL>() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                String strK0 = jsonReader.K0();
                if (strK0.equals("null")) {
                    return null;
                }
                return new URL(strK0);
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                URL url = (URL) obj;
                jsonWriter.j0(url == null ? null : url.toExternalForm());
            }
        });
        t = new AnonymousClass31(URI.class, new TypeAdapter<URI>() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                try {
                    String strK0 = jsonReader.K0();
                    if (strK0.equals("null")) {
                        return null;
                    }
                    return new URI(strK0);
                } catch (URISyntaxException e2) {
                    throw new JsonIOException(e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                URI uri = (URI) obj;
                jsonWriter.j0(uri == null ? null : uri.toASCIIString());
            }
        });
        final TypeAdapter<InetAddress> typeAdapter3 = new TypeAdapter<InetAddress>() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() != JsonToken.f45483i) {
                    return InetAddress.getByName(jsonReader.K0());
                }
                jsonReader.T();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                InetAddress inetAddress = (InetAddress) obj;
                jsonWriter.j0(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        final Class<InetAddress> cls = InetAddress.class;
        u = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter a(Gson gson, TypeToken typeToken) {
                final Class<?> cls2 = typeToken.f45459a;
                if (cls.isAssignableFrom(cls2)) {
                    return new TypeAdapter<Object>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                        @Override // com.google.gson.TypeAdapter
                        public final Object b(JsonReader jsonReader) {
                            Object objB = typeAdapter3.b(jsonReader);
                            if (objB != null) {
                                Class cls3 = cls2;
                                if (!cls3.isInstance(objB)) {
                                    throw new JsonSyntaxException("Expected a " + cls3.getName() + " but was " + objB.getClass().getName() + "; at path " + jsonReader.s());
                                }
                            }
                            return objB;
                        }

                        @Override // com.google.gson.TypeAdapter
                        public final void c(JsonWriter jsonWriter, Object obj) {
                            typeAdapter3.c(jsonWriter, obj);
                        }
                    };
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter3 + "]";
            }
        };
        v = new AnonymousClass31(UUID.class, new TypeAdapter<UUID>() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                String strK0 = jsonReader.K0();
                try {
                    return UUID.fromString(strK0);
                } catch (IllegalArgumentException e2) {
                    StringBuilder sbY = b.y("Failed parsing '", strK0, "' as UUID; at path ");
                    sbY.append(jsonReader.s());
                    throw new JsonSyntaxException(sbY.toString(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                UUID uuid = (UUID) obj;
                jsonWriter.j0(uuid == null ? null : uuid.toString());
            }
        });
        w = new AnonymousClass31(Currency.class, new TypeAdapter<Currency>() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                String strK0 = jsonReader.K0();
                try {
                    return Currency.getInstance(strK0);
                } catch (IllegalArgumentException e2) {
                    StringBuilder sbY = b.y("Failed parsing '", strK0, "' as Currency; at path ");
                    sbY.append(jsonReader.s());
                    throw new JsonSyntaxException(sbY.toString(), e2);
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                jsonWriter.j0(((Currency) obj).getCurrencyCode());
            }
        }.a());
        final TypeAdapter<Calendar> typeAdapter4 = new TypeAdapter<Calendar>() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException, NumberFormatException {
                int iNextInt;
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                jsonReader.k();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (jsonReader.j0() != JsonToken.f45478d) {
                    String strX = jsonReader.X();
                    iNextInt = jsonReader.nextInt();
                    strX.getClass();
                    switch (strX) {
                        case "dayOfMonth":
                            i4 = iNextInt;
                            break;
                        case "minute":
                            i6 = iNextInt;
                            break;
                        case "second":
                            i7 = iNextInt;
                            break;
                        case "year":
                            i2 = iNextInt;
                            break;
                        case "month":
                            i3 = iNextInt;
                            break;
                        case "hourOfDay":
                            i5 = iNextInt;
                            break;
                    }
                }
                jsonReader.t();
                return new GregorianCalendar(i2, i3, i4, i5, i6, i7);
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                if (((Calendar) obj) == null) {
                    jsonWriter.s();
                    return;
                }
                jsonWriter.k();
                jsonWriter.l("year");
                jsonWriter.T(r4.get(1));
                jsonWriter.l("month");
                jsonWriter.T(r4.get(2));
                jsonWriter.l("dayOfMonth");
                jsonWriter.T(r4.get(5));
                jsonWriter.l("hourOfDay");
                jsonWriter.T(r4.get(11));
                jsonWriter.l("minute");
                jsonWriter.T(r4.get(12));
                jsonWriter.l("second");
                jsonWriter.T(r4.get(13));
                jsonWriter.t();
            }
        };
        x = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.33
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class cls2 = typeToken.f45459a;
                if (cls2 == Calendar.class || cls2 == GregorianCalendar.class) {
                    return typeAdapter4;
                }
                return null;
            }

            public final String toString() {
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + typeAdapter4 + "]";
            }
        };
        y = new AnonymousClass31(Locale.class, new TypeAdapter<Locale>() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                if (jsonReader.j0() == JsonToken.f45483i) {
                    jsonReader.T();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.K0(), Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                Locale locale = (Locale) obj;
                jsonWriter.j0(locale == null ? null : locale.toString());
            }
        });
        final TypeAdapter<JsonElement> typeAdapter5 = new TypeAdapter<JsonElement>() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            public static JsonElement d(JsonReader jsonReader, JsonToken jsonToken) throws IOException {
                int iOrdinal = jsonToken.ordinal();
                if (iOrdinal == 5) {
                    return new JsonPrimitive(jsonReader.K0());
                }
                if (iOrdinal == 6) {
                    return new JsonPrimitive(new LazilyParsedNumber(jsonReader.K0()));
                }
                if (iOrdinal == 7) {
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.N()));
                }
                if (iOrdinal == 8) {
                    jsonReader.T();
                    return JsonNull.f45255a;
                }
                throw new IllegalStateException("Unexpected token: " + jsonToken);
            }

            public static void e(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
                if (jsonElement == null || (jsonElement instanceof JsonNull)) {
                    jsonWriter.s();
                    return;
                }
                if (jsonElement instanceof JsonPrimitive) {
                    JsonPrimitive jsonPrimitiveG = jsonElement.g();
                    Serializable serializable = jsonPrimitiveG.f45257a;
                    if (serializable instanceof Number) {
                        jsonWriter.Z(jsonPrimitiveG.m());
                        return;
                    } else if (serializable instanceof Boolean) {
                        jsonWriter.k0(jsonPrimitiveG.k());
                        return;
                    } else {
                        jsonWriter.j0(jsonPrimitiveG.n());
                        return;
                    }
                }
                boolean z2 = jsonElement instanceof JsonArray;
                if (z2) {
                    jsonWriter.b();
                    if (!z2) {
                        throw new IllegalStateException("Not a JSON Array: " + jsonElement);
                    }
                    Iterator it = ((JsonArray) jsonElement).f45254a.iterator();
                    while (it.hasNext()) {
                        e((JsonElement) it.next(), jsonWriter);
                    }
                    jsonWriter.e();
                    return;
                }
                if (!(jsonElement instanceof JsonObject)) {
                    throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
                }
                jsonWriter.k();
                for (Map.Entry entry : jsonElement.f().f45256a.entrySet()) {
                    jsonWriter.l((String) entry.getKey());
                    e((JsonElement) entry.getValue(), jsonWriter);
                }
                jsonWriter.t();
            }

            @Override // com.google.gson.TypeAdapter
            public final Object b(JsonReader jsonReader) throws IOException {
                JsonElement jsonArray;
                JsonElement jsonArray2;
                JsonElement jsonElement;
                if (jsonReader instanceof JsonTreeReader) {
                    JsonTreeReader jsonTreeReader = (JsonTreeReader) jsonReader;
                    JsonToken jsonTokenJ0 = jsonTreeReader.j0();
                    if (jsonTokenJ0 != JsonToken.f45479e && jsonTokenJ0 != JsonToken.f45476b && jsonTokenJ0 != JsonToken.f45478d && jsonTokenJ0 != JsonToken.f45484j) {
                        JsonElement jsonElement2 = (JsonElement) jsonTreeReader.c1();
                        jsonTreeReader.E();
                        return jsonElement2;
                    }
                    throw new IllegalStateException("Unexpected " + jsonTokenJ0 + " when reading a JsonElement.");
                }
                JsonToken jsonTokenJ02 = jsonReader.j0();
                int iOrdinal = jsonTokenJ02.ordinal();
                if (iOrdinal == 0) {
                    jsonReader.a();
                    jsonArray = new JsonArray();
                } else if (iOrdinal != 2) {
                    jsonArray = null;
                } else {
                    jsonReader.k();
                    jsonArray = new JsonObject();
                }
                if (jsonArray == null) {
                    return d(jsonReader, jsonTokenJ02);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    if (jsonReader.x()) {
                        String strX = jsonArray instanceof JsonObject ? jsonReader.X() : null;
                        JsonToken jsonTokenJ03 = jsonReader.j0();
                        int iOrdinal2 = jsonTokenJ03.ordinal();
                        if (iOrdinal2 == 0) {
                            jsonReader.a();
                            jsonArray2 = new JsonArray();
                        } else if (iOrdinal2 != 2) {
                            jsonArray2 = null;
                        } else {
                            jsonReader.k();
                            jsonArray2 = new JsonObject();
                        }
                        boolean z2 = jsonArray2 != null;
                        if (jsonArray2 == null) {
                            jsonArray2 = d(jsonReader, jsonTokenJ03);
                        }
                        if (jsonArray instanceof JsonArray) {
                            JsonArray jsonArray3 = (JsonArray) jsonArray;
                            if (jsonArray2 == null) {
                                jsonArray3.getClass();
                                jsonElement = JsonNull.f45255a;
                            } else {
                                jsonElement = jsonArray2;
                            }
                            jsonArray3.f45254a.add(jsonElement);
                        } else {
                            ((JsonObject) jsonArray).j(strX, jsonArray2);
                        }
                        if (z2) {
                            arrayDeque.addLast(jsonArray);
                            jsonArray = jsonArray2;
                        }
                    } else {
                        if (jsonArray instanceof JsonArray) {
                            jsonReader.e();
                        } else {
                            jsonReader.t();
                        }
                        if (arrayDeque.isEmpty()) {
                            return jsonArray;
                        }
                        jsonArray = (JsonElement) arrayDeque.removeLast();
                    }
                }
            }

            @Override // com.google.gson.TypeAdapter
            public final /* bridge */ /* synthetic */ void c(JsonWriter jsonWriter, Object obj) throws IOException {
                e((JsonElement) obj, jsonWriter);
            }
        };
        z = typeAdapter5;
        final Class<JsonElement> cls2 = JsonElement.class;
        A = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.34
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter a(Gson gson, TypeToken typeToken) {
                final Class cls22 = typeToken.f45459a;
                if (cls2.isAssignableFrom(cls22)) {
                    return new TypeAdapter<Object>() { // from class: com.google.gson.internal.bind.TypeAdapters.34.1
                        @Override // com.google.gson.TypeAdapter
                        public final Object b(JsonReader jsonReader) {
                            Object objB = typeAdapter5.b(jsonReader);
                            if (objB != null) {
                                Class cls3 = cls22;
                                if (!cls3.isInstance(objB)) {
                                    throw new JsonSyntaxException("Expected a " + cls3.getName() + " but was " + objB.getClass().getName() + "; at path " + jsonReader.s());
                                }
                            }
                            return objB;
                        }

                        @Override // com.google.gson.TypeAdapter
                        public final void c(JsonWriter jsonWriter, Object obj) {
                            typeAdapter5.c(jsonWriter, obj);
                        }
                    };
                }
                return null;
            }

            public final String toString() {
                return "Factory[typeHierarchy=" + cls2.getName() + ",adapter=" + typeAdapter5 + "]";
            }
        };
        B = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class superclass = typeToken.f45459a;
                if (!Enum.class.isAssignableFrom(superclass) || superclass == Enum.class) {
                    return null;
                }
                if (!superclass.isEnum()) {
                    superclass = superclass.getSuperclass();
                }
                return new EnumTypeAdapter(superclass);
            }
        };
    }

    public static TypeAdapterFactory a(final TypeToken typeToken, final TypeAdapter typeAdapter) {
        return new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // com.google.gson.TypeAdapterFactory
            public final TypeAdapter a(Gson gson, TypeToken typeToken2) {
                if (typeToken2.equals(typeToken)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static TypeAdapterFactory b(Class cls, TypeAdapter typeAdapter) {
        return new AnonymousClass31(cls, typeAdapter);
    }

    public static TypeAdapterFactory c(Class cls, Class cls2, TypeAdapter typeAdapter) {
        return new AnonymousClass32(cls, cls2, typeAdapter);
    }
}
