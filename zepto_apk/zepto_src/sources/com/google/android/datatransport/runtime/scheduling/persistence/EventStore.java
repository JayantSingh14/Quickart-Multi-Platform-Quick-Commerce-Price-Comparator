package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.annotation.WorkerThread;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

@WorkerThread
/* loaded from: classes.dex */
public interface EventStore extends Closeable {
    boolean A0(TransportContext transportContext);

    void C0(Iterable iterable);

    PersistedEvent C1(TransportContext transportContext, EventInternal eventInternal);

    Iterable L();

    Iterable P0(TransportContext transportContext);

    int f();

    void u1(long j2, TransportContext transportContext);

    long w0(TransportContext transportContext);

    void y(Iterable iterable);
}
