package com.airbnb.lottie;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class RenderMode {

    /* renamed from: a, reason: collision with root package name */
    public static final RenderMode f14202a;

    /* renamed from: b, reason: collision with root package name */
    public static final RenderMode f14203b;

    /* renamed from: c, reason: collision with root package name */
    public static final RenderMode f14204c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ RenderMode[] f14205d;

    /* renamed from: com.airbnb.lottie.RenderMode$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14206a;

        static {
            int[] iArr = new int[RenderMode.values().length];
            f14206a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14206a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14206a[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        RenderMode renderMode = new RenderMode("AUTOMATIC", 0);
        f14202a = renderMode;
        RenderMode renderMode2 = new RenderMode("HARDWARE", 1);
        f14203b = renderMode2;
        RenderMode renderMode3 = new RenderMode("SOFTWARE", 2);
        f14204c = renderMode3;
        f14205d = new RenderMode[]{renderMode, renderMode2, renderMode3};
    }

    public static RenderMode valueOf(String str) {
        return (RenderMode) Enum.valueOf(RenderMode.class, str);
    }

    public static RenderMode[] values() {
        return (RenderMode[]) f14205d.clone();
    }
}
