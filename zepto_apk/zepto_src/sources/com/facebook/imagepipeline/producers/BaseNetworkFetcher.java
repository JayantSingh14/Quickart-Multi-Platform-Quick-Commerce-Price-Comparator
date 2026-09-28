package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.FetchState;
import java.util.Map;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<FETCH_STATE> {
    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public Map b(FetchState fetchState, int i2) {
        return null;
    }

    @Override // com.facebook.imagepipeline.producers.NetworkFetcher
    public void d(FetchState fetchState) {
    }
}
