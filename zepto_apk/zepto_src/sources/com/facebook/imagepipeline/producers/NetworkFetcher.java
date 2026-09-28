package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.FetchState;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes.dex */
public interface NetworkFetcher<FETCH_STATE extends FetchState> {

    /* loaded from: classes3.dex */
    public interface Callback {
        void a();

        void b(InputStream inputStream, int i2);

        void onFailure(Exception exc);
    }

    void a(FetchState fetchState, Callback callback);

    Map b(FetchState fetchState, int i2);

    FetchState c(Consumer consumer, ProducerContext producerContext);

    void d(FetchState fetchState);
}
