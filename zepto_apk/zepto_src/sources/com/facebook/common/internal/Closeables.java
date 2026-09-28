package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

@Nullsafe
/* loaded from: classes3.dex */
public final class Closeables {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f17075a = Logger.getLogger(Closeables.class.getName());

    public static void a(Closeable closeable) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e2) {
            f17075a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e2);
        }
    }

    public static void b(InputStream inputStream) {
        try {
            a(inputStream);
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
