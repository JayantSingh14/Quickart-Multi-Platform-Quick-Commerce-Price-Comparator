package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
    public static CloseableProducerToDataSourceAdapter p(Producer producer, SettableProducerContext settableProducerContext, InternalRequestListener internalRequestListener) {
        FrescoSystrace.a();
        CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = new CloseableProducerToDataSourceAdapter(producer, settableProducerContext, internalRequestListener);
        FrescoSystrace.a();
        return closeableProducerToDataSourceAdapter;
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public final Object a() {
        return CloseableReference.c((CloseableReference) super.a());
    }

    @Override // com.facebook.datasource.AbstractDataSource
    public final void h(Object obj) {
        CloseableReference.e((CloseableReference) obj);
    }

    @Override // com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter
    public final void o(Object obj, int i2, ProducerContext producerContext) {
        super.o(CloseableReference.c((CloseableReference) obj), i2, producerContext);
    }
}
