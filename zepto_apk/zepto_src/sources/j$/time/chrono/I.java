package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class I implements l {
    public static final I BE;
    public static final I BEFORE_BE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ I[] f53219a;

    public static I valueOf(String str) {
        return (I) Enum.valueOf(I.class, str);
    }

    public static I[] values() {
        return (I[]) f53219a.clone();
    }

    static {
        I i2 = new I("BEFORE_BE", 0);
        BEFORE_BE = i2;
        I i3 = new I("BE", 1);
        BE = i3;
        f53219a = new I[]{i2, i3};
    }

    @Override // j$.time.chrono.l
    public final int q() {
        return ordinal();
    }
}
