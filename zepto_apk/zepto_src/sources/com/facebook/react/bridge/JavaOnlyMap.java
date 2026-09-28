package com.facebook.react.bridge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class JavaOnlyMap implements ReadableMap, WritableMap {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Map<String, Object> backingMap;

    @Metadata
    public static final class Companion {

        @Metadata
        /* loaded from: classes3.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Null.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.Boolean.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ReadableType.Number.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ReadableType.String.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ReadableType.Map.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ReadableType.Array.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final JavaOnlyMap deepClone(@Nullable ReadableMap readableMap) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            if (readableMap != null) {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
                while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    switch (WhenMappings.$EnumSwitchMapping$0[readableMap.getType(strNextKey).ordinal()]) {
                        case 1:
                            javaOnlyMap.putNull(strNextKey);
                            break;
                        case 2:
                            javaOnlyMap.putBoolean(strNextKey, readableMap.getBoolean(strNextKey));
                            break;
                        case 3:
                            javaOnlyMap.putDouble(strNextKey, readableMap.getDouble(strNextKey));
                            break;
                        case 4:
                            javaOnlyMap.putString(strNextKey, readableMap.getString(strNextKey));
                            break;
                        case 5:
                            javaOnlyMap.putMap(strNextKey, deepClone(readableMap.getMap(strNextKey)));
                            break;
                        case 6:
                            javaOnlyMap.putArray(strNextKey, JavaOnlyArray.Companion.deepClone(readableMap.getArray(strNextKey)));
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
            }
            return javaOnlyMap;
        }

        @JvmStatic
        @NotNull
        public final JavaOnlyMap from(@NotNull Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            return new JavaOnlyMap(new Object[]{map}, null);
        }

        @JvmStatic
        @NotNull
        public final JavaOnlyMap of(@NotNull Object... keysAndValues) {
            Intrinsics.checkNotNullParameter(keysAndValues, "keysAndValues");
            return new JavaOnlyMap(Arrays.copyOf(keysAndValues, keysAndValues.length), null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ JavaOnlyMap(Object[] objArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(objArr);
    }

    @JvmStatic
    @NotNull
    public static final JavaOnlyMap deepClone(@Nullable ReadableMap readableMap) {
        return Companion.deepClone(readableMap);
    }

    @JvmStatic
    @NotNull
    public static final JavaOnlyMap from(@NotNull Map<String, ? extends Object> map) {
        return Companion.from(map);
    }

    @JvmStatic
    @NotNull
    public static final JavaOnlyMap of(@NotNull Object... objArr) {
        return Companion.of(objArr);
    }

    @Override // com.facebook.react.bridge.WritableMap
    @NotNull
    public WritableMap copy() {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.merge(this);
        return javaOnlyMap;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !JavaOnlyMap.class.equals(obj.getClass())) {
            return false;
        }
        return Intrinsics.b(this.backingMap, ((JavaOnlyMap) obj).backingMap);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @Nullable
    public ReadableArray getArray(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (ReadableArray) this.backingMap.get(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean getBoolean(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public double getDouble(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @NotNull
    public Dynamic getDynamic(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        DynamicFromMap dynamicFromMapCreate = DynamicFromMap.create(this, name);
        Intrinsics.checkNotNullExpressionValue(dynamicFromMapCreate, "create(...)");
        return dynamicFromMapCreate;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @NotNull
    public Iterator<Map.Entry<String, Object>> getEntryIterator() {
        return this.backingMap.entrySet().iterator();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public int getInt(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).intValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public long getLong(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).longValue();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @Nullable
    public ReadableMap getMap(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (ReadableMap) this.backingMap.get(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @Nullable
    public String getString(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (String) this.backingMap.get(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @NotNull
    public ReadableType getType(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object obj = this.backingMap.get(name);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Number) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof Dynamic) {
            return ((Dynamic) obj).getType();
        }
        throw new IllegalArgumentException("Invalid value " + obj + " for key " + name + " contained in JavaOnlyMap");
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean hasKey(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.containsKey(name);
    }

    public int hashCode() {
        return this.backingMap.hashCode();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean isNull(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.backingMap.get(name) == null;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @NotNull
    public ReadableMapKeySetIterator keySetIterator() {
        return new ReadableMapKeySetIterator(this) { // from class: com.facebook.react.bridge.JavaOnlyMap.keySetIterator.1
            private final Iterator<Map.Entry<String, Object>> iterator;

            {
                this.iterator = this.backingMap.entrySet().iterator();
            }

            @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
            public boolean hasNextKey() {
                return this.iterator.hasNext();
            }

            @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
            public String nextKey() {
                return this.iterator.next().getKey();
            }
        };
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void merge(@NotNull ReadableMap source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.backingMap.putAll(((JavaOnlyMap) source).backingMap);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putArray(@NotNull String key, @Nullable ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, readableArray);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putBoolean(@NotNull String key, boolean z) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, Boolean.valueOf(z));
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putDouble(@NotNull String key, double d2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, Double.valueOf(d2));
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putInt(@NotNull String key, int i2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, Double.valueOf(i2));
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putLong(@NotNull String key, long j2) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, Double.valueOf(j2));
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putMap(@NotNull String key, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, readableMap);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putNull(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, null);
    }

    @Override // com.facebook.react.bridge.WritableMap
    public void putString(@NotNull String key, @Nullable String str) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.put(key, str);
    }

    public final void remove(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.backingMap.remove(key);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @NotNull
    public HashMap<String, Object> toHashMap() {
        return new HashMap<>(this.backingMap);
    }

    @NotNull
    public String toString() {
        return this.backingMap.toString();
    }

    public JavaOnlyMap() {
        this.backingMap = new HashMap();
    }

    private JavaOnlyMap(Object... objArr) {
        this();
        if (objArr.length % 2 == 0) {
            int i2 = 0;
            int iA = ProgressionUtilKt.a(0, objArr.length - 1, 2);
            if (iA < 0) {
                return;
            }
            while (true) {
                Object objValueOf = objArr[i2 + 1];
                objValueOf = objValueOf instanceof Number ? Double.valueOf(((Number) objValueOf).doubleValue()) : objValueOf;
                Map<String, Object> map = this.backingMap;
                Object obj = objArr[i2];
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.String");
                map.put((String) obj, objValueOf);
                if (i2 == iA) {
                    return;
                } else {
                    i2 += 2;
                }
            }
        } else {
            throw new IllegalArgumentException("You must provide the same number of keys and values");
        }
    }
}
