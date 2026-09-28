package androidx.constraintlayout.core.dsl;

/* loaded from: classes3.dex */
public class KeyAttribute extends Keys {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Fit {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Fit[] f1762a = {new Fit("SPLINE", 0), new Fit("LINEAR", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Fit EF5;

        public static Fit valueOf(String str) {
            return (Fit) Enum.valueOf(Fit.class, str);
        }

        public static Fit[] values() {
            return (Fit[]) f1762a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Visibility {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Visibility[] f1763a = {new Visibility("VISIBLE", 0), new Visibility("INVISIBLE", 1), new Visibility("GONE", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        Visibility EF5;

        public static Visibility valueOf(String str) {
            return (Visibility) Enum.valueOf(Visibility.class, str);
        }

        public static Visibility[] values() {
            return (Visibility[]) f1763a.clone();
        }
    }

    public void b(StringBuilder sb) {
        sb.append("frame:");
        sb.append(0);
        sb.append(",\n");
        Keys.a(sb, "alpha");
        Keys.a(sb, "rotationX");
        Keys.a(sb, "rotationY");
        Keys.a(sb, "rotationZ");
        Keys.a(sb, "pivotX");
        Keys.a(sb, "pivotY");
        Keys.a(sb, "pathRotate");
        Keys.a(sb, "scaleX");
        Keys.a(sb, "scaleY");
        Keys.a(sb, "translationX");
        Keys.a(sb, "translationY");
        Keys.a(sb, "translationZ");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("null:{\n");
        b(sb);
        sb.append("},\n");
        return sb.toString();
    }
}
