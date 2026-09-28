package androidx.constraintlayout.core.state;

/* loaded from: classes3.dex */
public class Dimension {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1908a = new String("WRAP_DIMENSION");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1909a = {new Type("FIXED", 0), new Type("WRAP", 1), new Type("MATCH_PARENT", 2), new Type("MATCH_CONSTRAINT", 3)};

        /* JADX INFO: Fake field, exist only in values array */
        Type EF5;

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1909a.clone();
        }
    }
}
