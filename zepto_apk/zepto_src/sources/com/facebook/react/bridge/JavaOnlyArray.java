package com.facebook.react.bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class JavaOnlyArray implements ReadableArray, WritableArray {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final List<Object> backingList;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {

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

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final JavaOnlyArray deepClone(@Nullable ReadableArray readableArray) {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            if (readableArray != null) {
                int size = readableArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    switch (WhenMappings.$EnumSwitchMapping$0[readableArray.getType(i2).ordinal()]) {
                        case 1:
                            javaOnlyArray.pushNull();
                            break;
                        case 2:
                            javaOnlyArray.pushBoolean(readableArray.getBoolean(i2));
                            break;
                        case 3:
                            javaOnlyArray.pushDouble(readableArray.getDouble(i2));
                            break;
                        case 4:
                            javaOnlyArray.pushString(readableArray.getString(i2));
                            break;
                        case 5:
                            javaOnlyArray.pushMap(JavaOnlyMap.Companion.deepClone(readableArray.getMap(i2)));
                            break;
                        case 6:
                            javaOnlyArray.pushArray(JavaOnlyArray.Companion.deepClone(readableArray.getArray(i2)));
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                }
            }
            return javaOnlyArray;
        }

        @JvmStatic
        @NotNull
        public final JavaOnlyArray from(@NotNull List<?> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            return new JavaOnlyArray(list, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        public final JavaOnlyArray of(@NotNull Object... values) {
            Intrinsics.checkNotNullParameter(values, "values");
            return new JavaOnlyArray(Arrays.copyOf(values, values.length), (DefaultConstructorMarker) null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ JavaOnlyArray(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<?>) list);
    }

    @JvmStatic
    @NotNull
    public static final JavaOnlyArray deepClone(@Nullable ReadableArray readableArray) {
        return Companion.deepClone(readableArray);
    }

    @JvmStatic
    @NotNull
    public static final JavaOnlyArray from(@NotNull List<?> list) {
        return Companion.from(list);
    }

    @JvmStatic
    @NotNull
    public static final JavaOnlyArray of(@NotNull Object... objArr) {
        return Companion.of(objArr);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !JavaOnlyArray.class.equals(obj.getClass())) {
            return false;
        }
        return Intrinsics.b(this.backingList, ((JavaOnlyArray) obj).backingList);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public ReadableArray getArray(int i2) {
        return (ReadableArray) this.backingList.get(i2);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean getBoolean(int i2) {
        Object obj = this.backingList.get(i2);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public double getDouble(int i2) {
        Object obj = this.backingList.get(i2);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @NotNull
    public Dynamic getDynamic(int i2) {
        DynamicFromArray dynamicFromArrayCreate = DynamicFromArray.create(this, i2);
        Intrinsics.checkNotNullExpressionValue(dynamicFromArrayCreate, "create(...)");
        return dynamicFromArrayCreate;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int getInt(int i2) {
        Object obj = this.backingList.get(i2);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).intValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public long getLong(int i2) {
        Object obj = this.backingList.get(i2);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Number");
        return ((Number) obj).longValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public ReadableMap getMap(int i2) {
        return (ReadableMap) this.backingList.get(i2);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public String getString(int i2) {
        return (String) this.backingList.get(i2);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @NotNull
    public ReadableType getType(int i2) {
        Object obj = this.backingList.get(i2);
        if (obj == null) {
            return ReadableType.Null;
        }
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if ((obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        throw new IllegalStateException("Invalid type " + obj.getClass() + ")");
    }

    public int hashCode() {
        return this.backingList.hashCode();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean isNull(int i2) {
        return this.backingList.get(i2) == null;
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushArray(@Nullable ReadableArray readableArray) {
        this.backingList.add(readableArray);
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushBoolean(boolean z) {
        this.backingList.add(Boolean.valueOf(z));
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushDouble(double d2) {
        this.backingList.add(Double.valueOf(d2));
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushInt(int i2) {
        this.backingList.add(Double.valueOf(i2));
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushLong(long j2) {
        this.backingList.add(Double.valueOf(j2));
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushMap(@Nullable ReadableMap readableMap) {
        this.backingList.add(readableMap);
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushNull() {
        this.backingList.add(null);
    }

    @Override // com.facebook.react.bridge.WritableArray
    public void pushString(@Nullable String str) {
        this.backingList.add(str);
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int size() {
        return this.backingList.size();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @NotNull
    public ArrayList<Object> toArrayList() {
        return new ArrayList<>(this.backingList);
    }

    @NotNull
    public String toString() {
        return this.backingList.toString();
    }

    public /* synthetic */ JavaOnlyArray(Object[] objArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(objArr);
    }

    private JavaOnlyArray(Object... objArr) {
        this.backingList = CollectionsKt.J(Arrays.copyOf(objArr, objArr.length));
    }

    private JavaOnlyArray(List<?> list) {
        this.backingList = new ArrayList(list);
    }

    public JavaOnlyArray() {
        this.backingList = new ArrayList();
    }
}
