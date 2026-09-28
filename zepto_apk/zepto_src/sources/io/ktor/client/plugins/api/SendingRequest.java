package io.ktor.client.plugins.api;

import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

@Metadata
/* loaded from: classes3.dex */
public final class SendingRequest implements ClientHook<Function3<? super HttpRequestBuilder, ? super OutgoingContent, ? super Continuation<? super Unit>, ? extends Object>> {
}
