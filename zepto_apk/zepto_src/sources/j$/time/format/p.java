package j$.time.format;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class p implements InterfaceC0122e {
    public static final p INSENSITIVE;
    public static final p LENIENT;
    public static final p SENSITIVE;
    public static final p STRICT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ p[] f53345a;

    @Override // j$.time.format.InterfaceC0122e
    public final boolean q(w wVar, StringBuilder sb) {
        return true;
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) f53345a.clone();
    }

    static {
        p pVar = new p("SENSITIVE", 0);
        SENSITIVE = pVar;
        p pVar2 = new p("INSENSITIVE", 1);
        INSENSITIVE = pVar2;
        p pVar3 = new p("STRICT", 2);
        STRICT = pVar3;
        p pVar4 = new p("LENIENT", 3);
        LENIENT = pVar4;
        f53345a = new p[]{pVar, pVar2, pVar3, pVar4};
    }

    @Override // j$.time.format.InterfaceC0122e
    public final int s(u uVar, CharSequence charSequence, int i2) {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            uVar.f53362b = true;
            return i2;
        }
        if (iOrdinal == 1) {
            uVar.f53362b = false;
            return i2;
        }
        if (iOrdinal == 2) {
            uVar.f53363c = true;
            return i2;
        }
        if (iOrdinal != 3) {
            return i2;
        }
        uVar.f53363c = false;
        return i2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return "ParseCaseSensitive(true)";
        }
        if (iOrdinal == 1) {
            return "ParseCaseSensitive(false)";
        }
        if (iOrdinal == 2) {
            return "ParseStrict(true)";
        }
        if (iOrdinal == 3) {
            return "ParseStrict(false)";
        }
        throw new IllegalStateException("Unreachable");
    }
}
