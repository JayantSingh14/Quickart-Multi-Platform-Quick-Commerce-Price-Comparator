package io.ktor.serialization;

import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes.dex */
public interface ContentConverter {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    Object a(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, ContinuationImpl continuationImpl);
}
