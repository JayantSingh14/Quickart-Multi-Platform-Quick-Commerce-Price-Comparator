package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class C {
    public static final C LENIENT;
    public static final C SMART;
    public static final C STRICT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C[] f53281a;

    public static C valueOf(String str) {
        return (C) Enum.valueOf(C.class, str);
    }

    public static C[] values() {
        return (C[]) f53281a.clone();
    }

    static {
        C c2 = new C("STRICT", 0);
        STRICT = c2;
        C c3 = new C("SMART", 1);
        SMART = c3;
        C c4 = new C("LENIENT", 2);
        LENIENT = c4;
        f53281a = new C[]{c2, c3, c4};
    }
}
