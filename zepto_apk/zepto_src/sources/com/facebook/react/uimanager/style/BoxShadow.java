package com.facebook.react.uimanager.style;

import android.content.Context;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class BoxShadow {

    /* renamed from: a, reason: collision with root package name */
    public final float f19862a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19863b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f19864c;

    /* renamed from: d, reason: collision with root package name */
    public final Float f19865d;

    /* renamed from: e, reason: collision with root package name */
    public final Float f19866e;

    /* renamed from: f, reason: collision with root package name */
    public final Boolean f19867f;

    @Metadata
    public static final class Companion {

        @Metadata
        public /* synthetic */ class WhenMappings {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f19868a;

            static {
                int[] iArr = new int[ReadableType.values().length];
                try {
                    iArr[ReadableType.Number.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ReadableType.Map.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f19868a = iArr;
            }
        }

        public static BoxShadow a(Context context, ReadableMap readableMap) {
            Integer num;
            Integer numValueOf;
            Intrinsics.checkNotNullParameter(context, "context");
            if (readableMap == null || !readableMap.hasKey("offsetX") || !readableMap.hasKey("offsetY")) {
                return null;
            }
            float f2 = (float) readableMap.getDouble("offsetX");
            float f3 = (float) readableMap.getDouble("offsetY");
            if (readableMap.hasKey("color")) {
                ReadableType type = readableMap.getType("color");
                int i2 = WhenMappings.f19868a[type.ordinal()];
                if (i2 == 1) {
                    numValueOf = Integer.valueOf(readableMap.getInt("color"));
                } else {
                    if (i2 != 2) {
                        throw new JSApplicationCausedNativeException("Unsupported color type " + type);
                    }
                    numValueOf = ColorPropConverter.getColor(readableMap.getMap("color"), context);
                }
                num = numValueOf;
            } else {
                num = null;
            }
            return new BoxShadow(f2, f3, num, readableMap.hasKey("blurRadius") ? Float.valueOf((float) readableMap.getDouble("blurRadius")) : null, readableMap.hasKey("spreadDistance") ? Float.valueOf((float) readableMap.getDouble("spreadDistance")) : null, readableMap.hasKey("inset") ? Boolean.valueOf(readableMap.getBoolean("inset")) : null);
        }
    }

    public BoxShadow(float f2, float f3, Integer num, Float f4, Float f5, Boolean bool) {
        this.f19862a = f2;
        this.f19863b = f3;
        this.f19864c = num;
        this.f19865d = f4;
        this.f19866e = f5;
        this.f19867f = bool;
    }

    public final Float a() {
        return this.f19865d;
    }

    public final Integer b() {
        return this.f19864c;
    }

    public final Boolean c() {
        return this.f19867f;
    }

    public final float d() {
        return this.f19862a;
    }

    public final float e() {
        return this.f19863b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxShadow)) {
            return false;
        }
        BoxShadow boxShadow = (BoxShadow) obj;
        return Float.compare(this.f19862a, boxShadow.f19862a) == 0 && Float.compare(this.f19863b, boxShadow.f19863b) == 0 && Intrinsics.b(this.f19864c, boxShadow.f19864c) && Intrinsics.b(this.f19865d, boxShadow.f19865d) && Intrinsics.b(this.f19866e, boxShadow.f19866e) && Intrinsics.b(this.f19867f, boxShadow.f19867f);
    }

    public final Float f() {
        return this.f19866e;
    }

    public final int hashCode() {
        int iHashCode = (Float.hashCode(this.f19863b) + (Float.hashCode(this.f19862a) * 31)) * 31;
        Integer num = this.f19864c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Float f2 = this.f19865d;
        int iHashCode3 = (iHashCode2 + (f2 == null ? 0 : f2.hashCode())) * 31;
        Float f3 = this.f19866e;
        int iHashCode4 = (iHashCode3 + (f3 == null ? 0 : f3.hashCode())) * 31;
        Boolean bool = this.f19867f;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        return "BoxShadow(offsetX=" + this.f19862a + ", offsetY=" + this.f19863b + ", color=" + this.f19864c + ", blurRadius=" + this.f19865d + ", spreadDistance=" + this.f19866e + ", inset=" + this.f19867f + ")";
    }
}
