package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class CharMatcher implements Predicate<Character> {

    /* renamed from: com.google.common.base.CharMatcher$1, reason: invalid class name */
    class AnonymousClass1 extends NegatedFastMatcher {
        @Override // com.google.common.base.CharMatcher.Negated
        public final String toString() {
            return null;
        }
    }

    public static final class And extends CharMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final CharMatcher f42236a;

        /* renamed from: b, reason: collision with root package name */
        public final CharMatcher f42237b;

        public And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            charMatcher.getClass();
            this.f42236a = charMatcher;
            charMatcher2.getClass();
            this.f42237b = charMatcher2;
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return this.f42236a.m(c2) && this.f42237b.m(c2);
        }

        public final String toString() {
            return "CharMatcher.and(" + this.f42236a + ", " + this.f42237b + ")";
        }
    }

    public static final class Any extends NamedFastMatcher {

        /* renamed from: b, reason: collision with root package name */
        public static final CharMatcher f42238b = new Any("CharMatcher.any()");

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher b(CharMatcher charMatcher) {
            charMatcher.getClass();
            return charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        public final int f(String str) {
            return str.length();
        }

        @Override // com.google.common.base.CharMatcher
        public final int h(CharSequence charSequence, int i2) {
            int length = charSequence.length();
            Preconditions.k(i2, length);
            if (i2 == length) {
                return -1;
            }
            return i2;
        }

        @Override // com.google.common.base.CharMatcher
        public final int i(String str) {
            return str.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean n(String str) {
            str.getClass();
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean o(String str) {
            return str.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public final CharMatcher p() {
            return None.f42250b;
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher q(CharMatcher charMatcher) {
            charMatcher.getClass();
            return this;
        }
    }

    public static final class AnyOf extends CharMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final char[] f42239a;

        public AnyOf(String str) {
            char[] charArray = str.toString().toCharArray();
            this.f42239a = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return Arrays.binarySearch(this.f42239a, c2) >= 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c2 : this.f42239a) {
                sb.append(CharMatcher.a(c2));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    public static final class Ascii extends NamedFastMatcher {

        /* renamed from: b, reason: collision with root package name */
        public static final CharMatcher f42240b = new Ascii("CharMatcher.ascii()");

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return c2 <= 127;
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static final class BitSetMatcher extends NamedFastMatcher {
        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            throw null;
        }
    }

    public static final class BreakingWhitespace extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            if (c2 != ' ' && c2 != 133 && c2 != 5760) {
                if (c2 != 8199) {
                    if (c2 != 8287 && c2 != 12288 && c2 != 8232 && c2 != 8233) {
                        switch (c2) {
                            case '\t':
                            case '\n':
                            case 11:
                            case '\f':
                            case '\r':
                                break;
                            default:
                                if (c2 >= 8192 && c2 <= 8202) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public final String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    public static final class Digit extends RangesMatcher {
        static {
            char[] charArray = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
            char[] cArr = new char[37];
            for (int i2 = 0; i2 < 37; i2++) {
                cArr[i2] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i2) + '\t');
            }
            new Digit("CharMatcher.digit()", charArray, cArr);
        }
    }

    public static abstract class FastMatcher extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher p() {
            return new NegatedFastMatcher(this);
        }
    }

    public static final class ForPredicate extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            ((Character) obj).getClass();
            throw null;
        }

        @Override // com.google.common.base.CharMatcher
        /* renamed from: d */
        public final boolean apply(Character ch2) {
            ch2.getClass();
            throw null;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            throw null;
        }

        public final String toString() {
            return "CharMatcher.forPredicate(null)";
        }
    }

    public static final class InRange extends FastMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final char f42241a;

        /* renamed from: b, reason: collision with root package name */
        public final char f42242b;

        public InRange(char c2, char c3) {
            Preconditions.f(c3 >= c2);
            this.f42241a = c2;
            this.f42242b = c3;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return this.f42241a <= c2 && c2 <= this.f42242b;
        }

        public final String toString() {
            return "CharMatcher.inRange('" + CharMatcher.a(this.f42241a) + "', '" + CharMatcher.a(this.f42242b) + "')";
        }
    }

    public static final class Invisible extends RangesMatcher {
        static {
            new Invisible("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u0890\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9".toCharArray(), "  \u00ad\u0605\u061c\u06dd\u070f\u0891\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb".toCharArray());
        }
    }

    public static final class Is extends FastMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final char f42243a;

        public Is(char c2) {
            this.f42243a = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.m(this.f42243a) ? this : None.f42250b;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return c2 == this.f42243a;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public final CharMatcher p() {
            return new IsNot(this.f42243a);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher q(CharMatcher charMatcher) {
            return charMatcher.m(this.f42243a) ? charMatcher : new Or(this, charMatcher);
        }

        public final String toString() {
            return "CharMatcher.is('" + CharMatcher.a(this.f42243a) + "')";
        }
    }

    public static final class IsEither extends FastMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final char f42244a;

        /* renamed from: b, reason: collision with root package name */
        public final char f42245b;

        public IsEither(char c2, char c3) {
            this.f42244a = c2;
            this.f42245b = c3;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return c2 == this.f42244a || c2 == this.f42245b;
        }

        public final String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.a(this.f42244a) + CharMatcher.a(this.f42245b) + "\")";
        }
    }

    public static final class IsNot extends FastMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final char f42246a;

        public IsNot(char c2) {
            this.f42246a = c2;
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.m(this.f42246a) ? new And(this, charMatcher) : charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return c2 != this.f42246a;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public final CharMatcher p() {
            return new Is(this.f42246a);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher q(CharMatcher charMatcher) {
            return charMatcher.m(this.f42246a) ? Any.f42238b : this;
        }

        public final String toString() {
            return "CharMatcher.isNot('" + CharMatcher.a(this.f42246a) + "')";
        }
    }

    public static final class JavaDigit extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return Character.isDigit(c2);
        }

        public final String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    public static final class JavaIsoControl extends NamedFastMatcher {

        /* renamed from: b, reason: collision with root package name */
        public static final CharMatcher f42247b = new JavaIsoControl("CharMatcher.javaIsoControl()");

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            if (c2 > 31) {
                return c2 >= 127 && c2 <= 159;
            }
            return true;
        }
    }

    public static final class JavaLetter extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return Character.isLetter(c2);
        }

        public final String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    public static final class JavaLetterOrDigit extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return Character.isLetterOrDigit(c2);
        }

        public final String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    public static final class JavaLowerCase extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return Character.isLowerCase(c2);
        }

        public final String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    public static final class JavaUpperCase extends CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return Character.isUpperCase(c2);
        }

        public final String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    public static abstract class NamedFastMatcher extends FastMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final String f42248a;

        public NamedFastMatcher(String str) {
            this.f42248a = str;
        }

        public final String toString() {
            return this.f42248a;
        }
    }

    public static class Negated extends CharMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final CharMatcher f42249a;

        public Negated(CharMatcher charMatcher) {
            this.f42249a = charMatcher;
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final int f(String str) {
            return str.length() - this.f42249a.f(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return !this.f42249a.m(c2);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean n(String str) {
            return this.f42249a.o(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean o(String str) {
            return this.f42249a.n(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher p() {
            return this.f42249a;
        }

        public String toString() {
            return this.f42249a + ".negate()";
        }
    }

    public static class NegatedFastMatcher extends Negated {
    }

    public static final class None extends NamedFastMatcher {

        /* renamed from: b, reason: collision with root package name */
        public static final CharMatcher f42250b = new None("CharMatcher.none()");

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher b(CharMatcher charMatcher) {
            charMatcher.getClass();
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public final int f(String str) {
            str.getClass();
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public final int h(CharSequence charSequence, int i2) {
            Preconditions.k(i2, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public final int i(String str) {
            str.getClass();
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean n(String str) {
            return str.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean o(String str) {
            str.getClass();
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public final CharMatcher p() {
            return Any.f42238b;
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher q(CharMatcher charMatcher) {
            charMatcher.getClass();
            return charMatcher;
        }
    }

    public static final class Or extends CharMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final CharMatcher f42251a;

        /* renamed from: b, reason: collision with root package name */
        public final CharMatcher f42252b;

        public Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
            charMatcher.getClass();
            this.f42251a = charMatcher;
            charMatcher2.getClass();
            this.f42252b = charMatcher2;
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return this.f42251a.m(c2) || this.f42252b.m(c2);
        }

        public final String toString() {
            return "CharMatcher.or(" + this.f42251a + ", " + this.f42252b + ")";
        }
    }

    public static class RangesMatcher extends CharMatcher {

        /* renamed from: a, reason: collision with root package name */
        public final String f42253a;

        /* renamed from: b, reason: collision with root package name */
        public final char[] f42254b;

        /* renamed from: c, reason: collision with root package name */
        public final char[] f42255c;

        public RangesMatcher(String str, char[] cArr, char[] cArr2) {
            this.f42253a = str;
            this.f42254b = cArr;
            this.f42255c = cArr2;
            Preconditions.f(cArr.length == cArr2.length);
            int i2 = 0;
            while (i2 < cArr.length) {
                Preconditions.f(cArr[i2] <= cArr2[i2]);
                int i3 = i2 + 1;
                if (i3 < cArr.length) {
                    Preconditions.f(cArr2[i2] < cArr[i3]);
                }
                i2 = i3;
            }
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public final /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            int iBinarySearch = Arrays.binarySearch(this.f42254b, c2);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i2 = (~iBinarySearch) - 1;
            return i2 >= 0 && c2 <= this.f42255c[i2];
        }

        public final String toString() {
            return this.f42253a;
        }
    }

    public static final class SingleWidth extends RangesMatcher {
        static {
            new SingleWidth("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺\ufdff\ufeffￜ".toCharArray());
        }
    }

    @VisibleForTesting
    public static final class Whitespace extends NamedFastMatcher {

        /* renamed from: b, reason: collision with root package name */
        public static final int f42256b = Integer.numberOfLeadingZeros(31);

        /* renamed from: c, reason: collision with root package name */
        public static final CharMatcher f42257c = new Whitespace("CharMatcher.whitespace()");

        @Override // com.google.common.base.CharMatcher
        public final boolean m(char c2) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c2) >>> f42256b) == c2;
        }
    }

    public static String a(char c2) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static CharMatcher c(String str) {
        int length = str.length();
        return length != 0 ? length != 1 ? length != 2 ? new AnyOf(str) : new IsEither(str.charAt(0), str.charAt(1)) : new Is(str.charAt(0)) : None.f42250b;
    }

    public static CharMatcher e() {
        return Ascii.f42240b;
    }

    public static CharMatcher g(char c2, char c3) {
        return new InRange(c2, c3);
    }

    public static CharMatcher j(char c2) {
        return new Is(c2);
    }

    public static CharMatcher k() {
        return new IsNot(' ');
    }

    public static CharMatcher l() {
        return JavaIsoControl.f42247b;
    }

    public CharMatcher b(CharMatcher charMatcher) {
        return new And(this, charMatcher);
    }

    @Override // com.google.common.base.Predicate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean apply(Character ch2) {
        return m(ch2.charValue());
    }

    public int f(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (m(str.charAt(i3))) {
                i2++;
            }
        }
        return i2;
    }

    public int h(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        Preconditions.k(i2, length);
        while (i2 < length) {
            if (m(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public int i(String str) {
        return h(str, 0);
    }

    public abstract boolean m(char c2);

    public boolean n(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            if (!m(str.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean o(String str) {
        return i(str) == -1;
    }

    public CharMatcher p() {
        return new Negated(this);
    }

    public CharMatcher q(CharMatcher charMatcher) {
        return new Or(this, charMatcher);
    }
}
