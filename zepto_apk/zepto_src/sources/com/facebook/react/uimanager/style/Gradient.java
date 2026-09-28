package com.facebook.react.uimanager.style;

import android.content.Context;
import android.support.v4.media.b;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class Gradient {

    /* renamed from: a, reason: collision with root package name */
    public final GradientType f19881a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearGradient f19882b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class GradientType {

        /* renamed from: a, reason: collision with root package name */
        public static final GradientType f19883a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ GradientType[] f19884b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f19885c;

        static {
            GradientType gradientType = new GradientType("LINEAR_GRADIENT", 0);
            f19883a = gradientType;
            GradientType[] gradientTypeArr = {gradientType};
            f19884b = gradientTypeArr;
            f19885c = EnumEntriesKt.a(gradientTypeArr);
        }

        public static GradientType valueOf(String str) {
            return (GradientType) Enum.valueOf(GradientType.class, str);
        }

        public static GradientType[] values() {
            return (GradientType[]) f19884b.clone();
        }
    }

    @Metadata
    public /* synthetic */ class WhenMappings {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19886a;

        static {
            int[] iArr = new int[GradientType.values().length];
            try {
                GradientType gradientType = GradientType.f19883a;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f19886a = iArr;
        }
    }

    public Gradient(Context context, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (readableMap == null) {
            throw new IllegalArgumentException("Gradient cannot be null");
        }
        String string = readableMap.getString("type");
        if (!Intrinsics.b(string, "linearGradient")) {
            throw new IllegalArgumentException(b.C("Unsupported gradient type: ", string));
        }
        this.f19881a = GradientType.f19883a;
        ReadableMap map = readableMap.getMap("direction");
        if (map == null) {
            throw new IllegalArgumentException("Gradient must have direction");
        }
        ReadableArray array = readableMap.getArray("colorStops");
        if (array == null) {
            throw new IllegalArgumentException("Invalid colorStops array");
        }
        int size = array.size();
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            ReadableMap map2 = array.getMap(i2);
            if (map2 != null) {
                Integer color = map2.getType("color") == ReadableType.Map ? ColorPropConverter.getColor(map2.getMap("color"), context) : Integer.valueOf(map2.getInt("color"));
                Intrinsics.c(color);
                iArr[i2] = color.intValue();
                fArr[i2] = (float) map2.getDouble("position");
            }
        }
        this.f19882b = new LinearGradient(map, iArr, fArr);
    }
}
