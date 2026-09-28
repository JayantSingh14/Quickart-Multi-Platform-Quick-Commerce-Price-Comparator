package androidx.constraintlayout.core.dsl;

/* loaded from: classes3.dex */
public class KeyCycle extends KeyAttribute {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Wave {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Wave[] f1766a = {new Wave("SIN", 0), new Wave("SQUARE", 1), new Wave("TRIANGLE", 2), new Wave("SAW", 3), new Wave("REVERSE_SAW", 4), new Wave("COS", 5)};

        /* JADX INFO: Fake field, exist only in values array */
        Wave EF5;

        public static Wave valueOf(String str) {
            return (Wave) Enum.valueOf(Wave.class, str);
        }

        public static Wave[] values() {
            return (Wave[]) f1766a.clone();
        }
    }

    @Override // androidx.constraintlayout.core.dsl.KeyAttribute
    public final void b(StringBuilder sb) {
        super.b(sb);
        Keys.a(sb, "period");
        Keys.a(sb, "offset");
        Keys.a(sb, "phase");
    }
}
