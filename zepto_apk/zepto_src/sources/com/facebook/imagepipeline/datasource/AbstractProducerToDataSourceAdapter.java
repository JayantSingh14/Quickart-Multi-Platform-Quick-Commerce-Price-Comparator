package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.HasImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@ThreadSafe
@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> implements HasImageRequest {

    /* renamed from: h, reason: collision with root package name */
    public final SettableProducerContext f17925h;

    /* renamed from: i, reason: collision with root package name */
    public final InternalRequestListener f17926i;

    public AbstractProducerToDataSourceAdapter(Producer producer, SettableProducerContext settableProducerContext, InternalRequestListener requestListener) {
        Intrinsics.checkNotNullParameter(producer, "producer");
        Intrinsics.checkNotNullParameter(settableProducerContext, "settableProducerContext");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        this.f17925h = settableProducerContext;
        this.f17926i = requestListener;
        FrescoSystrace.a();
        this.f17155a = settableProducerContext.f18096g;
        FrescoSystrace.a();
        requestListener.j(settableProducerContext);
        FrescoSystrace.a();
        producer.b(new BaseConsumer<Object>() { // from class: com.facebook.imagepipeline.datasource.AbstractProducerToDataSourceAdapter$createConsumer$1
            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void f() {
                AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter = this.f17927b;
                synchronized (abstractProducerToDataSourceAdapter) {
                    Preconditions.e(abstractProducerToDataSourceAdapter.i());
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void g(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter = this.f17927b;
                SettableProducerContext producerContext = abstractProducerToDataSourceAdapter.f17925h;
                Intrinsics.checkNotNullParameter(producerContext, "producerContext");
                if (abstractProducerToDataSourceAdapter.k(throwable, producerContext.getExtras())) {
                    abstractProducerToDataSourceAdapter.f17926i.h(producerContext, throwable);
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void h(int i2, Object obj) {
                AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter = this.f17927b;
                abstractProducerToDataSourceAdapter.o(obj, i2, abstractProducerToDataSourceAdapter.f17925h);
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void i(float f2) {
                this.f17927b.l(f2);
            }
        }, settableProducerContext);
    }

    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
    public final boolean close() {
        if (!super.close()) {
            return false;
        }
        if (b()) {
            return true;
        }
        InternalRequestListener internalRequestListener = this.f17926i;
        SettableProducerContext settableProducerContext = this.f17925h;
        internalRequestListener.f(settableProducerContext);
        settableProducerContext.h();
        return true;
    }

    public void o(Object obj, int i2, ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        boolean zD = BaseConsumer.d(i2);
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        if (m(obj, zD, producerContext.getExtras()) && zD) {
            this.f17926i.d(this.f17925h);
        }
    }
}
