package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata
/* loaded from: classes.dex */
public class ReadableNativeArray extends NativeArray implements ReadableArray {

    @NotNull
    private static final Companion Companion = new Companion(null);
    private static int jniPassCounter;

    @NotNull
    private final Lazy localArray$delegate;

    @NotNull
    private final Lazy localTypeArray$delegate;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @JvmName
        public final int getJNIPassCounter() {
            return ReadableNativeArray.jniPassCounter;
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

    public ReadableNativeArray() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f53528a;
        final int i2 = 0;
        this.localArray$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.react.bridge.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        return ReadableNativeArray.localArray_delegate$lambda$0(this);
                    default:
                        return ReadableNativeArray.localTypeArray_delegate$lambda$1(this);
                }
            }
        });
        final int i3 = 1;
        this.localTypeArray$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0() { // from class: com.facebook.react.bridge.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        return ReadableNativeArray.localArray_delegate$lambda$0(this);
                    default:
                        return ReadableNativeArray.localTypeArray_delegate$lambda$1(this);
                }
            }
        });
    }

    @JvmStatic
    @JvmName
    public static final int getJNIPassCounter() {
        return Companion.getJNIPassCounter();
    }

    private final Object[] getLocalArray() {
        return (Object[]) this.localArray$delegate.getValue();
    }

    private final ReadableType[] getLocalTypeArray() {
        Object value = this.localTypeArray$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ReadableType[]) value;
    }

    private final native Object[] importArray();

    private final native Object[] importTypeArray();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object[] localArray_delegate$lambda$0(ReadableNativeArray readableNativeArray) {
        jniPassCounter++;
        return readableNativeArray.importArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReadableType[] localTypeArray_delegate$lambda$1(ReadableNativeArray readableNativeArray) {
        jniPassCounter++;
        Object[] objArrImportTypeArray = readableNativeArray.importTypeArray();
        return (ReadableType[]) Arrays.copyOf(objArrImportTypeArray, objArrImportTypeArray.length, ReadableType[].class);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ReadableNativeArray) {
            return ArraysKt.j(getLocalArray(), ((ReadableNativeArray) obj).getLocalArray());
        }
        return false;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean getBoolean(int i2) {
        Object obj = getLocalArray()[i2];
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Boolean");
        return ((Boolean) obj).booleanValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public double getDouble(int i2) {
        Object obj = getLocalArray()[i2];
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Double");
        return ((Double) obj).doubleValue();
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
        Object obj = getLocalArray()[i2];
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Double");
        return (int) ((Double) obj).doubleValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public long getLong(int i2) {
        Object obj = getLocalArray()[i2];
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.Long");
        return ((Long) obj).longValue();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public String getString(int i2) {
        return (String) getLocalArray()[i2];
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @NotNull
    public ReadableType getType(int i2) {
        return getLocalTypeArray()[i2];
    }

    public int hashCode() {
        return getLocalArray().hashCode();
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public boolean isNull(int i2) {
        return getLocalArray()[i2] == null;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    public int size() {
        return getLocalArray().length;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @NotNull
    public ArrayList<Object> toArrayList() {
        ArrayList<Object> arrayList = new ArrayList<>();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            switch (WhenMappings.$EnumSwitchMapping$0[getType(i2).ordinal()]) {
                case 1:
                    arrayList.add(null);
                    break;
                case 2:
                    arrayList.add(Boolean.valueOf(getBoolean(i2)));
                    break;
                case 3:
                    arrayList.add(Double.valueOf(getDouble(i2)));
                    break;
                case 4:
                    arrayList.add(getString(i2));
                    break;
                case 5:
                    ReadableNativeMap map = getMap(i2);
                    arrayList.add(map != null ? map.toHashMap() : null);
                    break;
                case 6:
                    ReadableNativeArray array = getArray(i2);
                    arrayList.add(array != null ? array.toArrayList() : null);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        return arrayList;
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public ReadableNativeArray getArray(int i2) {
        return (ReadableNativeArray) getLocalArray()[i2];
    }

    @Override // com.facebook.react.bridge.ReadableArray
    @Nullable
    public ReadableNativeMap getMap(int i2) {
        return (ReadableNativeMap) getLocalArray()[i2];
    }
}
