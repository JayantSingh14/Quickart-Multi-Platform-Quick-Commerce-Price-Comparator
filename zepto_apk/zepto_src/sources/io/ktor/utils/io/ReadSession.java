package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public interface ReadSession {

    @Metadata
    public static final class DefaultImpls {
    }

    int B(int i2);

    ChunkBuffer b(int i2);
}
