package io.sentry.cache.tape;

import io.sentry.Breadcrumb;
import java.io.Closeable;
import java.io.OutputStream;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
/* loaded from: classes.dex */
public abstract class ObjectQueue<T> implements Iterable<T>, Closeable {

    public interface Converter<T> {
        void a(Object obj, OutputStream outputStream);

        Breadcrumb b(byte[] bArr);
    }

    public static ObjectQueue r(QueueFile queueFile, Converter converter) {
        return new FileObjectQueue(queueFile, converter);
    }

    public static ObjectQueue s() {
        return new EmptyObjectQueue();
    }

    public abstract void A(int i2);

    public abstract void b(Object obj);

    public void clear() {
        A(size());
    }

    public abstract int size();
}
