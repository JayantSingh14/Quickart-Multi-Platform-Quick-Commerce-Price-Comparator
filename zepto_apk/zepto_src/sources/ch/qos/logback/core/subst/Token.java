package ch.qos.logback.core.subst;

/* loaded from: classes3.dex */
public class Token {

    /* renamed from: c, reason: collision with root package name */
    public static final Token f13769c = new Token(Type.f13776b, null);

    /* renamed from: d, reason: collision with root package name */
    public static final Token f13770d = new Token(Type.f13777c, null);

    /* renamed from: e, reason: collision with root package name */
    public static final Token f13771e = new Token(Type.f13778d, null);

    /* renamed from: f, reason: collision with root package name */
    public static final Token f13772f = new Token(Type.f13779e, null);

    /* renamed from: a, reason: collision with root package name */
    public final Type f13773a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13774b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f13775a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f13776b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f13777c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f13778d;

        /* renamed from: e, reason: collision with root package name */
        public static final Type f13779e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ Type[] f13780f;

        static {
            Type type = new Type("LITERAL", 0);
            f13775a = type;
            Type type2 = new Type("START", 1);
            f13776b = type2;
            Type type3 = new Type("CURLY_LEFT", 2);
            f13777c = type3;
            Type type4 = new Type("CURLY_RIGHT", 3);
            f13778d = type4;
            Type type5 = new Type("DEFAULT", 4);
            f13779e = type5;
            f13780f = new Type[]{type, type2, type3, type4, type5};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f13780f.clone();
        }
    }

    public Token(Type type, String str) {
        this.f13773a = type;
        this.f13774b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Token token = (Token) obj;
        if (this.f13773a != token.f13773a) {
            return false;
        }
        String str = token.f13774b;
        String str2 = this.f13774b;
        return str2 == null ? str == null : str2.equals(str);
    }

    public final int hashCode() {
        Type type = this.f13773a;
        int iHashCode = (type != null ? type.hashCode() : 0) * 31;
        String str = this.f13774b;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        String str = "Token{type=" + this.f13773a;
        String str2 = this.f13774b;
        if (str2 != null) {
            str = str + ", payload='" + str2 + '\'';
        }
        return str + '}';
    }
}
