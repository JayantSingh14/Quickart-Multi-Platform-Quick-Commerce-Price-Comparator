package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.lang.Thread;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public final class UncaughtExceptionHandlers {

    @VisibleForTesting
    public static final class Exiter implements Thread.UncaughtExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public static final LazyLogger f43478a = new LazyLogger(Exiter.class);

        /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Thread.UncaughtExceptionHandler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void uncaughtException(java.lang.Thread r6, java.lang.Throwable r7) {
            /*
                r5 = this;
                r0 = 0
                com.google.common.util.concurrent.LazyLogger r1 = com.google.common.util.concurrent.UncaughtExceptionHandlers.Exiter.f43478a     // Catch: java.lang.Throwable -> L19
                java.util.logging.Logger r1 = r1.a()     // Catch: java.lang.Throwable -> L19
                java.util.logging.Level r2 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L19
                java.util.Locale r3 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L19
                java.lang.String r4 = "Caught an exception in %s.  Shutting down."
                java.lang.Object[] r6 = new java.lang.Object[]{r6}     // Catch: java.lang.Throwable -> L19
                java.lang.String r6 = java.lang.String.format(r3, r4, r6)     // Catch: java.lang.Throwable -> L19
                r1.log(r2, r6, r7)     // Catch: java.lang.Throwable -> L19
                throw r0
            L19:
                r6 = move-exception
                java.io.PrintStream r1 = java.lang.System.err     // Catch: java.lang.Throwable -> L2d
                java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L2d
                r1.println(r7)     // Catch: java.lang.Throwable -> L2d
                java.io.PrintStream r7 = java.lang.System.err     // Catch: java.lang.Throwable -> L2d
                java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L2d
                r7.println(r6)     // Catch: java.lang.Throwable -> L2d
                throw r0
            L2d:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.UncaughtExceptionHandlers.Exiter.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
        }
    }
}
