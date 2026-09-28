package io.ktor.utils.io;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public interface WriterJob extends Job {

    @Metadata
    public static final class DefaultImpls {
    }

    ByteChannel t0();
}
