package androidx.constraintlayout.core.dsl;

import java.util.Arrays;

/* loaded from: classes3.dex */
public class KeyAttributes extends Keys {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Fit {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Fit[] f1764a = {new Fit("SPLINE", 0), new Fit("LINEAR", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        Fit EF5;

        public static Fit valueOf(String str) {
            return (Fit) Enum.valueOf(Fit.class, str);
        }

        public static Fit[] values() {
            return (Fit[]) f1764a.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Visibility {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Visibility[] f1765a = {new Visibility("VISIBLE", 0), new Visibility("INVISIBLE", 1), new Visibility("GONE", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        Visibility EF5;

        public static Visibility valueOf(String str) {
            return (Visibility) Enum.valueOf(Visibility.class, str);
        }

        public static Visibility[] values() {
            return (Visibility[]) f1765a.clone();
        }
    }

    public final String toString() {
        return "null:{\nframe:" + Arrays.toString((int[]) null) + ",\n},\n";
    }
}
