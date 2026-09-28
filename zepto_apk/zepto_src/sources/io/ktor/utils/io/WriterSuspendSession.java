package io.ktor.utils.io;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public interface WriterSuspendSession extends WriterSession {
    Object c(int i2, ContinuationImpl continuationImpl);
}
