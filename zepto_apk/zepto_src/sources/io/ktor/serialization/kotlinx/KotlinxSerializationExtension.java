package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.http.content.ChannelWriterContent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes.dex */
public interface KotlinxSerializationExtension {
    Object a(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, ContinuationImpl continuationImpl);

    ChannelWriterContent b(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj);
}
