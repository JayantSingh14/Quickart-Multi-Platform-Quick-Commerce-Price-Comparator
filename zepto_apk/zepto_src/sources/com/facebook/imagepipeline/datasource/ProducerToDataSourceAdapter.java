package com.facebook.imagepipeline.datasource;

import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
@Metadata
/* loaded from: classes3.dex */
public final class ProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<T> {

    @Metadata
    public static final class Companion {
        public static ProducerToDataSourceAdapter a(Producer producer, SettableProducerContext settableProducerContext, InternalRequestListener listener) {
            Intrinsics.checkNotNullParameter(producer, "producer");
            Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
            Intrinsics.checkNotNullParameter(listener, "listener");
            return new ProducerToDataSourceAdapter(producer, settableProducerContext, listener);
        }
    }
}
