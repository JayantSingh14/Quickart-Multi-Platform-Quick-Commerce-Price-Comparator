package com.airbnb.lottie.model.content;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class LBlendMode {

    /* renamed from: a, reason: collision with root package name */
    public static final LBlendMode f14533a;

    /* renamed from: b, reason: collision with root package name */
    public static final LBlendMode f14534b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ LBlendMode[] f14535c;

    /* renamed from: com.airbnb.lottie.model.content.LBlendMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14536a;

        static {
            int[] iArr = new int[LBlendMode.values().length];
            f14536a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14536a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14536a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14536a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14536a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14536a[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14536a[16] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14536a[6] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14536a[7] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14536a[8] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14536a[9] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f14536a[10] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f14536a[11] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f14536a[12] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f14536a[13] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f14536a[14] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f14536a[15] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f14536a[17] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    static {
        LBlendMode lBlendMode = new LBlendMode("NORMAL", 0);
        f14533a = lBlendMode;
        LBlendMode lBlendMode2 = new LBlendMode("MULTIPLY", 1);
        f14534b = lBlendMode2;
        f14535c = new LBlendMode[]{lBlendMode, lBlendMode2, new LBlendMode("SCREEN", 2), new LBlendMode("OVERLAY", 3), new LBlendMode("DARKEN", 4), new LBlendMode("LIGHTEN", 5), new LBlendMode("COLOR_DODGE", 6), new LBlendMode("COLOR_BURN", 7), new LBlendMode("HARD_LIGHT", 8), new LBlendMode("SOFT_LIGHT", 9), new LBlendMode("DIFFERENCE", 10), new LBlendMode("EXCLUSION", 11), new LBlendMode("HUE", 12), new LBlendMode("SATURATION", 13), new LBlendMode("COLOR", 14), new LBlendMode("LUMINOSITY", 15), new LBlendMode("ADD", 16), new LBlendMode("HARD_MIX", 17)};
    }

    public static LBlendMode valueOf(String str) {
        return (LBlendMode) Enum.valueOf(LBlendMode.class, str);
    }

    public static LBlendMode[] values() {
        return (LBlendMode[]) f14535c.clone();
    }
}
