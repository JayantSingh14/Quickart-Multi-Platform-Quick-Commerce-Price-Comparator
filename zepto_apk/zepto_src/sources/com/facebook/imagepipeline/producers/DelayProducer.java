package com.facebook.imagepipeline.producers;

import androidx.media3.common.util.e;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DelayProducer implements Producer<CloseableReference<CloseableImage>> {
    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext context) {
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        Intrinsics.checkNotNullParameter(context, "context");
        ImageRequest imageRequestD = context.D();
        Object obj = null;
        obj.getClass();
        new e(this, consumer, context, 14);
        imageRequestD.getClass();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        throw null;
    }
}
