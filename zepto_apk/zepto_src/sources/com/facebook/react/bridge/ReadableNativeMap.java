package com.facebook.react.bridge;

import android.annotation.SuppressLint;
import androidx.fragment.app.e;
import com.facebook.infer.annotation.Assertions;
import com.facebook.proguard.annotations.DoNotStripAny;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStripAny
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public class ReadableNativeMap extends NativeMap implements ReadableMap {

    @NotNull
    private static final Companion Companion = new Companion(null);
    private static int jniPassCounter;

    @NotNull
    private final Lazy keys$delegate;

    @NotNull
    private final Lazy localMap$delegate;

    @NotNull
    private final Lazy localTypeMap$delegate;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmName
        public final int getJNIPassCounter() {
            return ReadableNativeMap.jniPassCounter;
        }

        private Companion() {
        }
    }

    @Metadata
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

    public ReadableNativeMap() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f53528a;
        final int i2 = 0;
        this.keys$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0(this) { // from class: com.facebook.react.bridge.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReadableNativeMap f18684b;

            {
                this.f18684b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return ReadableNativeMap.keys_delegate$lambda$1(this.f18684b);
                    case 1:
                        return ReadableNativeMap.localMap_delegate$lambda$2(this.f18684b);
                    default:
                        return ReadableNativeMap.localTypeMap_delegate$lambda$3(this.f18684b);
                }
            }
        });
        final int i3 = 1;
        this.localMap$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0(this) { // from class: com.facebook.react.bridge.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReadableNativeMap f18684b;

            {
                this.f18684b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        return ReadableNativeMap.keys_delegate$lambda$1(this.f18684b);
                    case 1:
                        return ReadableNativeMap.localMap_delegate$lambda$2(this.f18684b);
                    default:
                        return ReadableNativeMap.localTypeMap_delegate$lambda$3(this.f18684b);
                }
            }
        });
        final int i4 = 2;
        this.localTypeMap$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0(this) { // from class: com.facebook.react.bridge.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ReadableNativeMap f18684b;

            {
                this.f18684b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i4) {
                    case 0:
                        return ReadableNativeMap.keys_delegate$lambda$1(this.f18684b);
                    case 1:
                        return ReadableNativeMap.localMap_delegate$lambda$2(this.f18684b);
                    default:
                        return ReadableNativeMap.localTypeMap_delegate$lambda$3(this.f18684b);
                }
            }
        });
    }

    @SuppressLint({"ReflectionMethodUse"})
    private final <T> T checkInstance(String str, Object obj, Class<T> cls) {
        Intrinsics.g();
        throw null;
    }

    @JvmStatic
    @JvmName
    public static final int getJNIPassCounter() {
        return Companion.getJNIPassCounter();
    }

    private final String[] getKeys() {
        return (String[]) this.keys$delegate.getValue();
    }

    private final HashMap<String, Object> getLocalMap() {
        return (HashMap) this.localMap$delegate.getValue();
    }

    private final HashMap<String, ReadableType> getLocalTypeMap() {
        return (HashMap) this.localTypeMap$delegate.getValue();
    }

    private final Object getNullableValue(String str) {
        return getLocalMap().get(str);
    }

    private final Object getValue(String str) {
        if (!hasKey(str)) {
            throw new NoSuchKeyException(str);
        }
        Object obj = getLocalMap().get(str);
        Assertions.c(obj);
        Intrinsics.checkNotNullExpressionValue(obj, "assertNotNull(...)");
        return obj;
    }

    private final native String[] importKeys();

    private final native Object[] importTypes();

    private final native Object[] importValues();

    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] keys_delegate$lambda$1(ReadableNativeMap readableNativeMap) {
        String[] strArrImportKeys = readableNativeMap.importKeys();
        jniPassCounter++;
        return strArrImportKeys;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap localMap_delegate$lambda$2(ReadableNativeMap readableNativeMap) {
        int length = readableNativeMap.getKeys().length;
        HashMap map = new HashMap(length);
        Object[] objArrImportValues = readableNativeMap.importValues();
        jniPassCounter++;
        for (int i2 = 0; i2 < length; i2++) {
            map.put(readableNativeMap.getKeys()[i2], objArrImportValues[i2]);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap localTypeMap_delegate$lambda$3(ReadableNativeMap readableNativeMap) {
        int length = readableNativeMap.getKeys().length;
        HashMap map = new HashMap(length);
        Object[] objArrImportTypes = readableNativeMap.importTypes();
        jniPassCounter++;
        for (int i2 = 0; i2 < length; i2++) {
            String str = readableNativeMap.getKeys()[i2];
            Object obj = objArrImportTypes[i2];
            Intrinsics.d(obj, "null cannot be cast to non-null type com.facebook.react.bridge.ReadableType");
            map.put(str, (ReadableType) obj);
        }
        return map;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ReadableNativeMap) {
            return Intrinsics.b(getLocalMap(), ((ReadableNativeMap) obj).getLocalMap());
        }
        return false;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @Nullable
    public ReadableArray getArray(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object nullableValue = getNullableValue(name);
        if (nullableValue == null) {
            return null;
        }
        ReadableArray readableArray = (ReadableArray) (nullableValue instanceof ReadableArray ? nullableValue : null);
        if (readableArray != null) {
            return readableArray;
        }
        throw new UnexpectedNativeTypeException(android.support.v4.media.b.m("Value for ", name, " cannot be cast from ", nullableValue.getClass().getSimpleName(), " to ReadableArray"));
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean getBoolean(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object value = getValue(name);
        Boolean bool = (Boolean) (!(value instanceof Boolean) ? null : value);
        if (bool != null) {
            return bool.booleanValue();
        }
        String simpleName = value != null ? value.getClass().getSimpleName() : "NULL";
        String simpleName2 = Boolean.TYPE.getSimpleName();
        StringBuilder sbV = e.v("Value for ", name, " cannot be cast from ", simpleName, " to ");
        sbV.append(simpleName2);
        throw new UnexpectedNativeTypeException(sbV.toString());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public double getDouble(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object value = getValue(name);
        Double d2 = (Double) (!(value instanceof Double) ? null : value);
        if (d2 != null) {
            return d2.doubleValue();
        }
        String simpleName = value != null ? value.getClass().getSimpleName() : "NULL";
        String simpleName2 = Double.TYPE.getSimpleName();
        StringBuilder sbV = e.v("Value for ", name, " cannot be cast from ", simpleName, " to ");
        sbV.append(simpleName2);
        throw new UnexpectedNativeTypeException(sbV.toString());
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
        ReadableNativeMap$entryIterator$1$1 readableNativeMap$entryIterator$1$1;
        synchronized (this) {
            String[] keys = getKeys();
            Object[] objArrImportValues = importValues();
            jniPassCounter++;
            readableNativeMap$entryIterator$1$1 = new ReadableNativeMap$entryIterator$1$1(keys, objArrImportValues);
        }
        return readableNativeMap$entryIterator$1$1;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public int getInt(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object value = getValue(name);
        Double d2 = (Double) (!(value instanceof Double) ? null : value);
        if (d2 != null) {
            return (int) d2.doubleValue();
        }
        String simpleName = value != null ? value.getClass().getSimpleName() : "NULL";
        String simpleName2 = Double.TYPE.getSimpleName();
        StringBuilder sbV = e.v("Value for ", name, " cannot be cast from ", simpleName, " to ");
        sbV.append(simpleName2);
        throw new UnexpectedNativeTypeException(sbV.toString());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public long getLong(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object value = getValue(name);
        Long l2 = (Long) (!(value instanceof Long) ? null : value);
        if (l2 != null) {
            return l2.longValue();
        }
        String simpleName = value != null ? value.getClass().getSimpleName() : "NULL";
        String simpleName2 = Long.TYPE.getSimpleName();
        StringBuilder sbV = e.v("Value for ", name, " cannot be cast from ", simpleName, " to ");
        sbV.append(simpleName2);
        throw new UnexpectedNativeTypeException(sbV.toString());
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @Nullable
    public String getString(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object nullableValue = getNullableValue(name);
        if (nullableValue == null) {
            return null;
        }
        String str = (String) (nullableValue instanceof String ? nullableValue : null);
        if (str != null) {
            return str;
        }
        throw new UnexpectedNativeTypeException(android.support.v4.media.b.m("Value for ", name, " cannot be cast from ", nullableValue.getClass().getSimpleName(), " to String"));
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @NotNull
    public ReadableType getType(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        ReadableType readableType = getLocalTypeMap().get(name);
        if (readableType != null) {
            return readableType;
        }
        throw new NoSuchKeyException(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean hasKey(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return getLocalMap().containsKey(name);
    }

    public int hashCode() {
        return getLocalMap().hashCode();
    }

    @Override // com.facebook.react.bridge.ReadableMap
    public boolean isNull(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (getLocalMap().containsKey(name)) {
            return getLocalMap().get(name) == null;
        }
        throw new NoSuchKeyException(name);
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @NotNull
    public ReadableMapKeySetIterator keySetIterator() {
        final String[] keys = getKeys();
        return new ReadableMapKeySetIterator() { // from class: com.facebook.react.bridge.ReadableNativeMap.keySetIterator.1
            private int currentIndex;

            public final int getCurrentIndex() {
                return this.currentIndex;
            }

            @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
            public boolean hasNextKey() {
                return this.currentIndex < keys.length;
            }

            @Override // com.facebook.react.bridge.ReadableMapKeySetIterator
            public String nextKey() {
                String[] strArr = keys;
                int i2 = this.currentIndex;
                this.currentIndex = i2 + 1;
                return strArr[i2];
            }

            public final void setCurrentIndex(int i2) {
                this.currentIndex = i2;
            }
        };
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @NotNull
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = new HashMap<>(getLocalMap());
        for (String str : map.keySet()) {
            Intrinsics.d(str, "null cannot be cast to non-null type kotlin.String");
            String str2 = str;
            switch (WhenMappings.$EnumSwitchMapping$0[getType(str2).ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    break;
                case 5:
                    ReadableNativeMap map2 = getMap(str2);
                    Assertions.c(map2);
                    map.put(str2, map2.toHashMap());
                    break;
                case 6:
                    ReadableArray array = getArray(str2);
                    Assertions.c(array);
                    map.put(str2, array.toArrayList());
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return map;
    }

    private final <T> T getNullableValue(String str, Class<T> cls) {
        if (getNullableValue(str) == null) {
            return null;
        }
        Intrinsics.g();
        throw null;
    }

    @Override // com.facebook.react.bridge.ReadableMap
    @Nullable
    public ReadableNativeMap getMap(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Object nullableValue = getNullableValue(name);
        if (nullableValue == null) {
            return null;
        }
        ReadableNativeMap readableNativeMap = (ReadableNativeMap) (nullableValue instanceof ReadableNativeMap ? nullableValue : null);
        if (readableNativeMap != null) {
            return readableNativeMap;
        }
        throw new UnexpectedNativeTypeException(android.support.v4.media.b.m("Value for ", name, " cannot be cast from ", nullableValue.getClass().getSimpleName(), " to ReadableNativeMap"));
    }

    private final <T> T getValue(String str, Class<T> cls) {
        getValue(str);
        Intrinsics.g();
        throw null;
    }
}
