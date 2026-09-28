package org.shadow.apache.commons.lang3.concurrent;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class ConcurrentUtils {

    public static final class ConstantFuture<T> implements Future<T> {
        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public final Object get() {
            return null;
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public final Object get(long j2, TimeUnit timeUnit) {
            return null;
        }
    }

    public static void a(Throwable th) {
        boolean z = (th == null || (th instanceof RuntimeException) || (th instanceof Error)) ? false : true;
        String str = "Not a checked exception: " + th;
        Object[] objArr = new Object[0];
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
