package io.ktor.client.plugins.api;

import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function5;

@Metadata
/* loaded from: classes3.dex */
public final class TransformResponseBodyHook implements ClientHook<Function5<? super TransformResponseBodyContext, ? super HttpResponse, ? super ByteReadChannel, ? super TypeInfo, ? super Continuation<? super Object>, ? extends Object>> {
}
