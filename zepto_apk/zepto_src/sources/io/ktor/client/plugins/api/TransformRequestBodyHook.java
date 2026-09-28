package io.ktor.client.plugins.api;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function5;

@Metadata
/* loaded from: classes3.dex */
public final class TransformRequestBodyHook implements ClientHook<Function5<? super TransformRequestBodyContext, ? super HttpRequestBuilder, ? super Object, ? super TypeInfo, ? super Continuation<? super OutgoingContent>, ? extends Object>> {
}
