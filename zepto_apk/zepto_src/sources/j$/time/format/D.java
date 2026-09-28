package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class D {
    public static final D ALWAYS;
    public static final D EXCEEDS_PAD;
    public static final D NEVER;
    public static final D NORMAL;
    public static final D NOT_NEGATIVE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ D[] f53282a;

    public static D valueOf(String str) {
        return (D) Enum.valueOf(D.class, str);
    }

    public static D[] values() {
        return (D[]) f53282a.clone();
    }

    static {
        D d2 = new D("NORMAL", 0);
        NORMAL = d2;
        D d3 = new D("ALWAYS", 1);
        ALWAYS = d3;
        D d4 = new D("NEVER", 2);
        NEVER = d4;
        D d5 = new D("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = d5;
        D d6 = new D("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = d6;
        f53282a = new D[]{d2, d3, d4, d5, d6};
    }
}
