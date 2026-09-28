package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
public abstract class CharSource {

    public final class AsByteSource extends ByteSource {
        public final String toString() {
            throw null;
        }
    }

    public static class CharSequenceCharSource extends CharSource {

        /* renamed from: com.google.common.io.CharSource$CharSequenceCharSource$1, reason: invalid class name */
        class AnonymousClass1 extends AbstractIterator<String> {
            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                throw null;
            }
        }

        static {
            Splitter.b();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x001c A[PHI: r1
          0x001c: PHI (r1v2 java.lang.String) = (r1v1 java.lang.String), (r1v7 java.lang.String) binds: [B:3:0x000f, B:5:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r5 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "CharSource.wrap("
                r0.<init>(r1)
                java.lang.String r1 = ""
                int r2 = r1.length()
                r3 = 30
                if (r2 > r3) goto L1c
                java.lang.String r1 = r1.toString()
                int r2 = r1.length()
                if (r2 > r3) goto L1c
                goto L30
            L1c:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r3)
                r3 = 0
                r4 = 27
                r2.append(r1, r3, r4)
                java.lang.String r1 = "..."
                r2.append(r1)
                java.lang.String r1 = r2.toString()
            L30:
                r0.append(r1)
                java.lang.String r1 = ")"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.CharSource.CharSequenceCharSource.toString():java.lang.String");
        }
    }

    public static final class ConcatenatedCharSource extends CharSource {
        public final String toString() {
            return "CharSource.concat(null)";
        }
    }

    public static final class EmptyCharSource extends StringCharSource {
        @Override // com.google.common.io.CharSource.CharSequenceCharSource
        public final String toString() {
            return "CharSource.empty()";
        }
    }

    public static class StringCharSource extends CharSequenceCharSource {
    }
}
