package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
public interface Sender {
    Object a(HttpRequestBuilder httpRequestBuilder, ContinuationImpl continuationImpl);
}
