package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class QualifiedResourceFetchProducer extends LocalFetchProducer {

    /* renamed from: c, reason: collision with root package name */
    public final ContentResolver f18298c;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QualifiedResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(pooledByteBufferFactory, "pooledByteBufferFactory");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        this.f18298c = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final EncodedImage d(ImageRequest imageRequest) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(imageRequest, "imageRequest");
        InputStream inputStreamOpenInputStream = this.f18298c.openInputStream(imageRequest.f18348b);
        if (inputStreamOpenInputStream == null) {
            throw new IllegalStateException("ContentResolver returned null InputStream");
        }
        EncodedImage encodedImageC = c(inputStreamOpenInputStream, -1);
        Intrinsics.checkNotNullExpressionValue(encodedImageC, "getEncodedImage(...)");
        return encodedImageC;
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public final String e() {
        return "QualifiedResourceFetchProducer";
    }
}
