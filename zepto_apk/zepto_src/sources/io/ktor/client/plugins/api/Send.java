package io.ktor.client.plugins.api;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class Send implements ClientHook<Function3<? super Sender, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object>> {

    @Metadata
    public static final class Sender {

        /* renamed from: a, reason: collision with root package name */
        public final io.ktor.client.plugins.Sender f49672a;

        public Sender(io.ktor.client.plugins.Sender httpSendSender) {
            Intrinsics.checkNotNullParameter(httpSendSender, "httpSendSender");
            this.f49672a = httpSendSender;
        }
    }
}
