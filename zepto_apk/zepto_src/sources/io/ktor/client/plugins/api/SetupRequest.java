package io.ktor.client.plugins.api;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata
/* loaded from: classes3.dex */
public final class SetupRequest implements ClientHook<Function2<? super HttpRequestBuilder, ? super Continuation<? super Unit>, ? extends Object>> {
}
