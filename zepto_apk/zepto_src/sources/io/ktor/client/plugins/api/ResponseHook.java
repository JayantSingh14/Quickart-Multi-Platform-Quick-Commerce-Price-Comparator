package io.ktor.client.plugins.api;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

@Metadata
/* loaded from: classes3.dex */
public final class ResponseHook implements ClientHook<Function3<? super OnResponseContext, ? super HttpResponse, ? super Continuation<? super Unit>, ? extends Object>> {
}
