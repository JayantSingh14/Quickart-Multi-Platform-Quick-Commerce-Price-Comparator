package ch.qos.logback.core.pattern.parser;

import android.support.v4.media.b;

/* loaded from: classes3.dex */
class Token {

    /* renamed from: c, reason: collision with root package name */
    public static final Token f13684c = new Token(41, null);

    /* renamed from: d, reason: collision with root package name */
    public static final Token f13685d = new Token(1005, "BARE");

    /* renamed from: e, reason: collision with root package name */
    public static final Token f13686e = new Token(37, null);

    /* renamed from: a, reason: collision with root package name */
    public final int f13687a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13688b;

    public Token(int i2, Object obj) {
        this.f13687a = i2;
        this.f13688b = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Token)) {
            return false;
        }
        Token token = (Token) obj;
        if (this.f13687a != token.f13687a) {
            return false;
        }
        Object obj2 = token.f13688b;
        Object obj3 = this.f13688b;
        return obj3 != null ? obj3.equals(obj2) : obj2 == null;
    }

    public final int hashCode() {
        int i2 = this.f13687a * 29;
        Object obj = this.f13688b;
        return i2 + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        String str;
        int i2 = this.f13687a;
        if (i2 == 37) {
            str = "%";
        } else if (i2 == 41) {
            str = "RIGHT_PARENTHESIS";
        } else if (i2 == 1000) {
            str = "LITERAL";
        } else if (i2 != 1002) {
            switch (i2) {
                case 1004:
                    str = "SIMPLE_KEYWORD";
                    break;
                case 1005:
                    str = "COMPOSITE_KEYWORD";
                    break;
                case 1006:
                    str = "OPTION";
                    break;
                default:
                    str = "UNKNOWN";
                    break;
            }
        } else {
            str = "FormatModifier";
        }
        Object obj = this.f13688b;
        if (obj == null) {
            return b.D("Token(", str, ")");
        }
        return "Token(" + str + ", \"" + obj + "\")";
    }
}
