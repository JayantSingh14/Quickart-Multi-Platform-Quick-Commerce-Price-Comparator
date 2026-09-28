package com.google.gson.internal.bind;

import android.support.v4.media.b;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.TroubleshootingGuide;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a, reason: collision with root package name */
    public final ConstructorConstructor f45372a;

    /* renamed from: b, reason: collision with root package name */
    public final FieldNamingPolicy f45373b;

    /* renamed from: c, reason: collision with root package name */
    public final Excluder f45374c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f45375d;

    /* renamed from: e, reason: collision with root package name */
    public final List f45376e;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {

        /* renamed from: a, reason: collision with root package name */
        public final FieldsData f45383a;

        public Adapter(FieldsData fieldsData) {
            this.f45383a = fieldsData;
        }

        @Override // com.google.gson.TypeAdapter
        public final Object b(JsonReader jsonReader) throws IOException {
            if (jsonReader.j0() == JsonToken.f45483i) {
                jsonReader.T();
                return null;
            }
            Object objD = d();
            Map map = this.f45383a.f45389a;
            try {
                jsonReader.k();
                while (jsonReader.x()) {
                    BoundField boundField = (BoundField) map.get(jsonReader.X());
                    if (boundField == null) {
                        jsonReader.E();
                    } else {
                        f(objD, jsonReader, boundField);
                    }
                }
                jsonReader.t();
                return e(objD);
            } catch (IllegalAccessException e2) {
                ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.f45442a;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
            } catch (IllegalStateException e3) {
                throw new JsonSyntaxException(e3);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
            if (obj == null) {
                jsonWriter.s();
                return;
            }
            jsonWriter.k();
            try {
                Iterator it = this.f45383a.f45390b.iterator();
                while (it.hasNext()) {
                    ((BoundField) it.next()).c(jsonWriter, obj);
                }
                jsonWriter.t();
            } catch (IllegalAccessException e2) {
                ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.f45442a;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
            }
        }

        public abstract Object d();

        public abstract Object e(Object obj);

        public abstract void f(Object obj, JsonReader jsonReader, BoundField boundField);
    }

    public static abstract class BoundField {

        /* renamed from: a, reason: collision with root package name */
        public final String f45384a;

        /* renamed from: b, reason: collision with root package name */
        public final Field f45385b;

        /* renamed from: c, reason: collision with root package name */
        public final String f45386c;

        public BoundField(String str, Field field) {
            this.f45384a = str;
            this.f45385b = field;
            this.f45386c = field.getName();
        }

        public abstract void a(JsonReader jsonReader, int i2, Object[] objArr);

        public abstract void b(JsonReader jsonReader, Object obj);

        public abstract void c(JsonWriter jsonWriter, Object obj);
    }

    public static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* renamed from: b, reason: collision with root package name */
        public final ObjectConstructor f45387b;

        public FieldReflectionAdapter(ObjectConstructor objectConstructor, FieldsData fieldsData) {
            super(fieldsData);
            this.f45387b = objectConstructor;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object d() {
            return this.f45387b.a();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object e(Object obj) {
            return obj;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void f(Object obj, JsonReader jsonReader, BoundField boundField) {
            boundField.b(jsonReader, obj);
        }
    }

    public static class FieldsData {

        /* renamed from: c, reason: collision with root package name */
        public static final FieldsData f45388c = new FieldsData(Collections.EMPTY_MAP, Collections.EMPTY_LIST);

        /* renamed from: a, reason: collision with root package name */
        public final Map f45389a;

        /* renamed from: b, reason: collision with root package name */
        public final List f45390b;

        public FieldsData(Map map, List list) {
            this.f45389a = map;
            this.f45390b = list;
        }
    }

    /* loaded from: classes4.dex */
    public static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* renamed from: e, reason: collision with root package name */
        public static final HashMap f45391e;

        /* renamed from: b, reason: collision with root package name */
        public final Constructor f45392b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f45393c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f45394d;

        static {
            HashMap map = new HashMap();
            map.put(Byte.TYPE, (byte) 0);
            map.put(Short.TYPE, (short) 0);
            map.put(Integer.TYPE, 0);
            map.put(Long.TYPE, 0L);
            map.put(Float.TYPE, Float.valueOf(0.0f));
            map.put(Double.TYPE, Double.valueOf(0.0d));
            map.put(Character.TYPE, (char) 0);
            map.put(Boolean.TYPE, Boolean.FALSE);
            f45391e = map;
        }

        public RecordAdapter(Class cls, FieldsData fieldsData, boolean z) throws SecurityException {
            super(fieldsData);
            this.f45394d = new HashMap();
            Constructor constructorF = ReflectionHelper.f(cls);
            this.f45392b = constructorF;
            if (z) {
                ReflectiveTypeAdapterFactory.b(null, constructorF);
            } else {
                ReflectionHelper.j(constructorF);
            }
            String[] strArrH = ReflectionHelper.h(cls);
            for (int i2 = 0; i2 < strArrH.length; i2++) {
                this.f45394d.put(strArrH[i2], Integer.valueOf(i2));
            }
            Class<?>[] parameterTypes = this.f45392b.getParameterTypes();
            this.f45393c = new Object[parameterTypes.length];
            for (int i3 = 0; i3 < parameterTypes.length; i3++) {
                this.f45393c[i3] = f45391e.get(parameterTypes[i3]);
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object d() {
            return (Object[]) this.f45393c.clone();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object e(Object obj) {
            Object[] objArr = (Object[]) obj;
            Constructor constructor = this.f45392b;
            try {
                return constructor.newInstance(objArr);
            } catch (IllegalAccessException e2) {
                ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.f45442a;
                throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e2);
            } catch (IllegalArgumentException e3) {
                e = e3;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.b(constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e4) {
                e = e4;
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.b(constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Failed to invoke constructor '" + ReflectionHelper.b(constructor) + "' with args " + Arrays.toString(objArr), e5.getCause());
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void f(Object obj, JsonReader jsonReader, BoundField boundField) {
            Object[] objArr = (Object[]) obj;
            HashMap map = this.f45394d;
            String str = boundField.f45386c;
            Integer num = (Integer) map.get(str);
            if (num != null) {
                boundField.a(jsonReader, num.intValue(), objArr);
                return;
            }
            throw new IllegalStateException("Could not find the index in the constructor '" + ReflectionHelper.b(this.f45392b) + "' for field with name '" + str + "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
        }
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingPolicy fieldNamingPolicy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory, List list) {
        this.f45372a = constructorConstructor;
        this.f45373b = fieldNamingPolicy;
        this.f45374c = excluder;
        this.f45375d = jsonAdapterAnnotationTypeAdapterFactory;
        this.f45376e = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(Object obj, AccessibleObject accessibleObject) {
        if (Modifier.isStatic(((Member) accessibleObject).getModifiers())) {
            obj = null;
        }
        if (!ReflectionAccessFilterHelper.a(obj, accessibleObject)) {
            throw new JsonIOException(b.k(ReflectionHelper.d(accessibleObject, true), " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type."));
        }
    }

    public static void c(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + ReflectionHelper.c(field) + " and " + ReflectionHelper.c(field2) + "\nSee " + TroubleshootingGuide.a("duplicate-fields"));
    }

    @Override // com.google.gson.TypeAdapterFactory
    public final TypeAdapter a(Gson gson, TypeToken typeToken) {
        Class cls = typeToken.f45459a;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        ReflectionHelper.RecordHelper recordHelper = ReflectionHelper.f45442a;
        if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return new TypeAdapter<Object>() { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
                @Override // com.google.gson.TypeAdapter
                public final Object b(JsonReader jsonReader) throws IOException {
                    jsonReader.E();
                    return null;
                }

                @Override // com.google.gson.TypeAdapter
                public final void c(JsonWriter jsonWriter, Object obj) throws IOException {
                    jsonWriter.s();
                }

                public final String toString() {
                    return "AnonymousOrNonStaticLocalClassAdapter";
                }
            };
        }
        ReflectionAccessFilter.FilterResult filterResultB = ReflectionAccessFilterHelper.b(this.f45376e, cls);
        if (filterResultB != ReflectionAccessFilter.FilterResult.f45263d) {
            boolean z = filterResultB == ReflectionAccessFilter.FilterResult.f45262c;
            return ReflectionHelper.i(cls) ? new RecordAdapter(cls, d(gson, typeToken, cls, z, true), z) : new FieldReflectionAdapter(this.f45372a.b(typeToken), d(gson, typeToken, cls, z, false));
        }
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + cls + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x018f  */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.FieldsData d(com.google.gson.Gson r29, com.google.gson.reflect.TypeToken r30, java.lang.Class r31, boolean r32, boolean r33) throws java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 497
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.d(com.google.gson.Gson, com.google.gson.reflect.TypeToken, java.lang.Class, boolean, boolean):com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$FieldsData");
    }

    public final boolean e(Field field, boolean z) {
        boolean z2;
        Excluder excluder = this.f45374c;
        excluder.getClass();
        if ((field.getModifiers() & WKSRecord.Service.PROFILE) != 0 || field.isSynthetic() || excluder.b(field.getType(), z)) {
            z2 = true;
            break;
        }
        List list = z ? excluder.f45297a : excluder.f45298b;
        if (!list.isEmpty()) {
            new FieldAttributes(field);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((ExclusionStrategy) it.next()).b()) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        return !z2;
    }
}
