package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class TextDirectionHeuristicsCompat {

    /* renamed from: a, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2961a = new TextDirectionHeuristicInternal(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2962b = new TextDirectionHeuristicInternal(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2963c;

    /* renamed from: d, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2964d;

    public static class AnyStrong implements TextDirectionAlgorithm {
    }

    public static class FirstStrong implements TextDirectionAlgorithm {

        /* renamed from: a, reason: collision with root package name */
        public static final FirstStrong f2965a = new FirstStrong();
    }

    public interface TextDirectionAlgorithm {
    }

    public static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {

        /* renamed from: a, reason: collision with root package name */
        public final FirstStrong f2966a;

        public TextDirectionHeuristicImpl(FirstStrong firstStrong) {
            this.f2966a = firstStrong;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
        @Override // androidx.core.text.TextDirectionHeuristicCompat
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a(java.lang.CharSequence r7, int r8) {
            /*
                r6 = this;
                r0 = 1
                if (r7 == 0) goto L42
                if (r8 < 0) goto L42
                int r1 = r7.length()
                int r1 = r1 - r8
                if (r1 < 0) goto L42
                androidx.core.text.TextDirectionHeuristicsCompat$FirstStrong r1 = r6.f2966a
                if (r1 != 0) goto L15
                boolean r7 = r6.b()
                return r7
            L15:
                r1 = 0
                r2 = 2
                r3 = r1
                r4 = r2
            L19:
                if (r3 >= r8) goto L37
                if (r4 != r2) goto L37
                char r4 = r7.charAt(r3)
                byte r4 = java.lang.Character.getDirectionality(r4)
                androidx.core.text.TextDirectionHeuristicCompat r5 = androidx.core.text.TextDirectionHeuristicsCompat.f2961a
                if (r4 == 0) goto L34
                if (r4 == r0) goto L32
                if (r4 == r2) goto L32
                switch(r4) {
                    case 14: goto L34;
                    case 15: goto L34;
                    case 16: goto L32;
                    case 17: goto L32;
                    default: goto L30;
                }
            L30:
                r4 = r2
                goto L35
            L32:
                r4 = r1
                goto L35
            L34:
                r4 = r0
            L35:
                int r3 = r3 + r0
                goto L19
            L37:
                if (r4 == 0) goto L41
                if (r4 == r0) goto L40
                boolean r7 = r6.b()
                return r7
            L40:
                return r1
            L41:
                return r0
            L42:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                r7.<init>()
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl.a(java.lang.CharSequence, int):boolean");
        }

        public abstract boolean b();
    }

    public static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f2967b;

        public TextDirectionHeuristicInternal(FirstStrong firstStrong, boolean z) {
            super(firstStrong);
            this.f2967b = z;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public final boolean b() {
            return this.f2967b;
        }
    }

    public static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        public final boolean b() {
            return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.f2965a;
        f2963c = new TextDirectionHeuristicInternal(firstStrong, false);
        f2964d = new TextDirectionHeuristicInternal(firstStrong, true);
    }
}
