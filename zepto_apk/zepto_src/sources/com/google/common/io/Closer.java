package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Closeable;
import java.lang.reflect.Method;
import java.util.logging.Level;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes4.dex */
public final class Closer implements Closeable, AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public static final Suppressor f43240a;

    @VisibleForTesting
    public static final class LoggingSuppressor implements Suppressor {

        /* renamed from: a, reason: collision with root package name */
        public static final LoggingSuppressor f43241a = new LoggingSuppressor();

        @Override // com.google.common.io.Closer.Suppressor
        public final void a(Closeable closeable, Throwable th, Throwable th2) {
            Closeables.f43239a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    @VisibleForTesting
    public static final class SuppressingSuppressor implements Suppressor {

        /* renamed from: a, reason: collision with root package name */
        public final Method f43242a;

        public SuppressingSuppressor(Method method) {
            this.f43242a = method;
        }

        @Override // com.google.common.io.Closer.Suppressor
        public final void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th == th2) {
                return;
            }
            try {
                this.f43242a.invoke(th, th2);
            } catch (Throwable unused) {
                LoggingSuppressor.f43241a.a(closeable, th, th2);
            }
        }
    }

    @VisibleForTesting
    public interface Suppressor {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        Suppressor suppressingSuppressor;
        try {
            suppressingSuppressor = new SuppressingSuppressor(Throwable.class.getMethod("addSuppressed", Throwable.class));
        } catch (Throwable unused) {
            suppressingSuppressor = null;
        }
        if (suppressingSuppressor == null) {
            suppressingSuppressor = LoggingSuppressor.f43241a;
        }
        f43240a = suppressingSuppressor;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw null;
    }
}
