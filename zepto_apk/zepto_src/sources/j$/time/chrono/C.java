package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class C implements l {
    public static final C BEFORE_ROC;
    public static final C ROC;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C[] f53212a;

    public static C valueOf(String str) {
        return (C) Enum.valueOf(C.class, str);
    }

    public static C[] values() {
        return (C[]) f53212a.clone();
    }

    static {
        C c2 = new C("BEFORE_ROC", 0);
        BEFORE_ROC = c2;
        C c3 = new C("ROC", 1);
        ROC = c3;
        f53212a = new C[]{c2, c3};
    }

    @Override // j$.time.chrono.l
    public final int q() {
        return ordinal();
    }
}
