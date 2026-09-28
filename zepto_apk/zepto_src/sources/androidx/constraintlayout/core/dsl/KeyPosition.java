package androidx.constraintlayout.core.dsl;

/* loaded from: classes3.dex */
public class KeyPosition extends Keys {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1769a = {new Type("CARTESIAN", 0), new Type("SCREEN", 1), new Type("PATH", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        Type EF5;

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1769a.clone();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPositions:{\nframe:0,\n");
        Keys.a(sb, "percentX");
        Keys.a(sb, "percentY");
        Keys.a(sb, "percentWidth");
        Keys.a(sb, "percentHeight");
        sb.append("},\n");
        return sb.toString();
    }
}
