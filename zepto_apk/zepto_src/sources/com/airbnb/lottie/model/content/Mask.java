package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;

/* loaded from: classes3.dex */
public class Mask {

    /* renamed from: a, reason: collision with root package name */
    public final MaskMode f14537a;

    /* renamed from: b, reason: collision with root package name */
    public final AnimatableShapeValue f14538b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatableIntegerValue f14539c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14540d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class MaskMode {

        /* renamed from: a, reason: collision with root package name */
        public static final MaskMode f14541a;

        /* renamed from: b, reason: collision with root package name */
        public static final MaskMode f14542b;

        /* renamed from: c, reason: collision with root package name */
        public static final MaskMode f14543c;

        /* renamed from: d, reason: collision with root package name */
        public static final MaskMode f14544d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ MaskMode[] f14545e;

        static {
            MaskMode maskMode = new MaskMode("MASK_MODE_ADD", 0);
            f14541a = maskMode;
            MaskMode maskMode2 = new MaskMode("MASK_MODE_SUBTRACT", 1);
            f14542b = maskMode2;
            MaskMode maskMode3 = new MaskMode("MASK_MODE_INTERSECT", 2);
            f14543c = maskMode3;
            MaskMode maskMode4 = new MaskMode("MASK_MODE_NONE", 3);
            f14544d = maskMode4;
            f14545e = new MaskMode[]{maskMode, maskMode2, maskMode3, maskMode4};
        }

        public static MaskMode valueOf(String str) {
            return (MaskMode) Enum.valueOf(MaskMode.class, str);
        }

        public static MaskMode[] values() {
            return (MaskMode[]) f14545e.clone();
        }
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z) {
        this.f14537a = maskMode;
        this.f14538b = animatableShapeValue;
        this.f14539c = animatableIntegerValue;
        this.f14540d = z;
    }
}
