package com.google.common.base;

import com.google.android.gms.common.api.Api;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.AbstractIterator;
import com.google.common.base.CharMatcher;
import com.google.common.base.JdkPattern;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Splitter {

    /* renamed from: a, reason: collision with root package name */
    public final CharMatcher f42295a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f42296b;

    /* renamed from: c, reason: collision with root package name */
    public final Strategy f42297c;

    /* renamed from: d, reason: collision with root package name */
    public final int f42298d;

    /* renamed from: com.google.common.base.Splitter$2, reason: invalid class name */
    class AnonymousClass2 implements Strategy {
        @Override // com.google.common.base.Splitter.Strategy
        public final Iterator a(Splitter splitter, CharSequence charSequence) {
            return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.2.1
                @Override // com.google.common.base.Splitter.SplittingIterator
                public final int b(int i2) {
                    AnonymousClass2.this.getClass();
                    return 1 + i2;
                }

                @Override // com.google.common.base.Splitter.SplittingIterator
                public final int c(int i2) {
                    AnonymousClass2.this.getClass();
                    CharSequence charSequence2 = this.f42304c;
                    int length = charSequence2.length() - 1;
                    while (i2 <= length) {
                        if (charSequence2.charAt(i2) == StringUtils.SPACE.charAt(0)) {
                            return i2;
                        }
                        i2++;
                    }
                    return -1;
                }
            };
        }
    }

    /* renamed from: com.google.common.base.Splitter$3, reason: invalid class name */
    class AnonymousClass3 implements Strategy {

        /* renamed from: com.google.common.base.Splitter$3$1, reason: invalid class name */
        class AnonymousClass1 extends SplittingIterator {

            /* renamed from: h, reason: collision with root package name */
            public final /* synthetic */ CommonMatcher f42302h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Splitter splitter, CharSequence charSequence, CommonMatcher commonMatcher) {
                super(splitter, charSequence);
                this.f42302h = commonMatcher;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public final int b(int i2) {
                return this.f42302h.a();
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public final int c(int i2) {
                CommonMatcher commonMatcher = this.f42302h;
                if (commonMatcher.b(i2)) {
                    return commonMatcher.c();
                }
                return -1;
            }
        }

        @Override // com.google.common.base.Splitter.Strategy
        public final Iterator a(Splitter splitter, CharSequence charSequence) {
            throw null;
        }
    }

    /* renamed from: com.google.common.base.Splitter$4, reason: invalid class name */
    class AnonymousClass4 implements Strategy {
        @Override // com.google.common.base.Splitter.Strategy
        public final Iterator a(Splitter splitter, CharSequence charSequence) {
            return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.4.1
                @Override // com.google.common.base.Splitter.SplittingIterator
                public final int b(int i2) {
                    return i2;
                }

                @Override // com.google.common.base.Splitter.SplittingIterator
                public final int c(int i2) {
                    AnonymousClass4.this.getClass();
                    if (i2 < this.f42304c.length()) {
                        return i2;
                    }
                    return -1;
                }
            };
        }
    }

    /* renamed from: com.google.common.base.Splitter$5, reason: invalid class name */
    class AnonymousClass5 implements Iterable<String> {
        @Override // java.lang.Iterable
        public final Iterator<String> iterator() {
            throw null;
        }

        public final String toString() {
            Joiner joiner = new Joiner(", ");
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            joiner.b(iterator(), sb);
            sb.append(']');
            return sb.toString();
        }
    }

    public static final class MapSplitter {
    }

    public static abstract class SplittingIterator extends AbstractIterator<String> {

        /* renamed from: c, reason: collision with root package name */
        public final CharSequence f42304c;

        /* renamed from: d, reason: collision with root package name */
        public final CharMatcher f42305d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f42306e;

        /* renamed from: f, reason: collision with root package name */
        public int f42307f;

        /* renamed from: g, reason: collision with root package name */
        public int f42308g;

        public SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.f42227a = AbstractIterator.State.f42231b;
            this.f42307f = 0;
            this.f42305d = splitter.f42295a;
            this.f42306e = splitter.f42296b;
            this.f42308g = splitter.f42298d;
            this.f42304c = charSequence;
        }

        @Override // com.google.common.base.AbstractIterator
        public final Object a() {
            int iC;
            CharSequence charSequence;
            CharMatcher charMatcher;
            int i2 = this.f42307f;
            while (true) {
                int i3 = this.f42307f;
                if (i3 == -1) {
                    this.f42227a = AbstractIterator.State.f42232c;
                    return null;
                }
                iC = c(i3);
                charSequence = this.f42304c;
                if (iC == -1) {
                    iC = charSequence.length();
                    this.f42307f = -1;
                } else {
                    this.f42307f = b(iC);
                }
                int i4 = this.f42307f;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.f42307f = i5;
                    if (i5 > charSequence.length()) {
                        this.f42307f = -1;
                    }
                } else {
                    while (true) {
                        charMatcher = this.f42305d;
                        if (i2 >= iC || !charMatcher.m(charSequence.charAt(i2))) {
                            break;
                        }
                        i2++;
                    }
                    while (iC > i2 && charMatcher.m(charSequence.charAt(iC - 1))) {
                        iC--;
                    }
                    if (!this.f42306e || i2 != iC) {
                        break;
                    }
                    i2 = this.f42307f;
                }
            }
            int i6 = this.f42308g;
            if (i6 == 1) {
                iC = charSequence.length();
                this.f42307f = -1;
                while (iC > i2 && charMatcher.m(charSequence.charAt(iC - 1))) {
                    iC--;
                }
            } else {
                this.f42308g = i6 - 1;
            }
            return charSequence.subSequence(i2, iC).toString();
        }

        public abstract int b(int i2);

        public abstract int c(int i2);
    }

    public interface Strategy {
        Iterator a(Splitter splitter, CharSequence charSequence);
    }

    public Splitter(Strategy strategy) {
        CharMatcher charMatcher = CharMatcher.None.f42250b;
        this.f42297c = strategy;
        this.f42296b = false;
        this.f42295a = charMatcher;
        this.f42298d = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static Splitter a(char c2) {
        final CharMatcher.Is is = new CharMatcher.Is(c2);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.1
            @Override // com.google.common.base.Splitter.Strategy
            public final Iterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.1.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public final int b(int i2) {
                        return i2 + 1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public final int c(int i2) {
                        return is.h(this.f42304c, i2);
                    }
                };
            }
        });
    }

    public static void b() {
        Preconditions.h(!new JdkPattern.JdkMatcher(r0.f42274a.matcher("")).f42275a.matches(), "The pattern may not match the empty string: %s", new JdkPattern(Pattern.compile("\r\n|\n|\r")));
    }

    public final List c(CharSequence charSequence) {
        charSequence.getClass();
        Iterator itA = this.f42297c.a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (itA.hasNext()) {
            arrayList.add((String) itA.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final void d() {
        CharMatcher.Whitespace.f42257c.getClass();
    }
}
