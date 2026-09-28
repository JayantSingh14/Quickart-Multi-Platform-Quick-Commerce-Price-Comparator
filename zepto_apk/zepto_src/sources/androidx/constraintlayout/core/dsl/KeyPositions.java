package androidx.constraintlayout.core.dsl;

import java.util.Arrays;

/* loaded from: classes3.dex */
public class KeyPositions extends Keys {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1770a = {new Type("CARTESIAN", 0), new Type("SCREEN", 1), new Type("PATH", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        Type EF5;

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1770a.clone();
        }
    }

    public final String toString() {
        return "KeyPositions:{\nframe:" + Arrays.toString((int[]) null) + ",\n},\n";
    }
}
