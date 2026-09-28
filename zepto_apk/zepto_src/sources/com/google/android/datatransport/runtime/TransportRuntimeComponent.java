package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.Component;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import java.io.Closeable;
import java.io.IOException;
import javax.inject.Singleton;

@Singleton
@Component
/* loaded from: classes.dex */
abstract class TransportRuntimeComponent implements Closeable, AutoCloseable {

    @Component.Builder
    public interface Builder {
    }

    public abstract EventStore a();

    public abstract TransportRuntime b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a().close();
    }
}
