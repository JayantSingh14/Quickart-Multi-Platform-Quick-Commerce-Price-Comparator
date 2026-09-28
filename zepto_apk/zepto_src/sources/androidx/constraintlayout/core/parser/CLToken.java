package androidx.constraintlayout.core.parser;

/* loaded from: classes3.dex */
public class CLToken extends CLElement {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1905a = {new Type("UNKNOWN", 0), new Type("TRUE", 1), new Type("FALSE", 2), new Type("NULL", 3)};

        /* JADX INFO: Fake field, exist only in values array */
        Type EF5;

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1905a.clone();
        }
    }
}
