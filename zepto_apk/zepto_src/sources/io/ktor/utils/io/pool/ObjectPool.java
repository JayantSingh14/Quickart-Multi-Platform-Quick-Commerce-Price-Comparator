package io.ktor.utils.io.pool;

import java.io.Closeable;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface ObjectPool<T> extends Closeable, AutoCloseable {

    @Metadata
    public static final class DefaultImpls {
        public static void a(ObjectPool objectPool) {
            objectPool.dispose();
        }
    }

    void G1(Object obj);

    Object S0();

    void dispose();
}
