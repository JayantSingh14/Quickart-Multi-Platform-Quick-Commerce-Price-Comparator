package j$.time.chrono;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class s implements l {
    public static final s BCE;
    public static final s CE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ s[] f53254a;

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f53254a.clone();
    }

    static {
        s sVar = new s("BCE", 0);
        BCE = sVar;
        s sVar2 = new s("CE", 1);
        CE = sVar2;
        f53254a = new s[]{sVar, sVar2};
    }

    @Override // j$.time.chrono.l
    public final int q() {
        return ordinal();
    }
}
