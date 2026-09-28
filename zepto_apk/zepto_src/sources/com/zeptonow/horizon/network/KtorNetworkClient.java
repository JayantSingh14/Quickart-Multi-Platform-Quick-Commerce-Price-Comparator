package com.zeptonow.horizon.network;

import com.zeptonow.horizon.entity.HorizonConfig;
import com.zeptonow.horizon.utils.AndroidDispatchersProvider;
import com.zeptonow.horizon.utils.Compressor;
import io.ktor.client.HttpClient;
import io.ktor.util.StringValues;
import io.ktor.util.StringValuesBuilderImpl;
import io.ktor.util.StringValuesImpl;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class KtorNetworkClient implements NetworkClient {

    /* renamed from: a, reason: collision with root package name */
    public final HttpClient f48107a;

    /* renamed from: b, reason: collision with root package name */
    public final HorizonConfig f48108b;

    /* renamed from: c, reason: collision with root package name */
    public final AndroidDispatchersProvider f48109c;

    /* renamed from: d, reason: collision with root package name */
    public StringValuesImpl f48110d;

    public KtorNetworkClient(HttpClient client, HorizonConfig config, Compressor compressor, AndroidDispatchersProvider dispatchersProvider) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(compressor, "compressor");
        Intrinsics.checkNotNullParameter(dispatchersProvider, "dispatchersProvider");
        this.f48107a = client;
        this.f48108b = config;
        this.f48109c = dispatchersProvider;
        StringValues.f50504c.getClass();
        this.f48110d = StringValues.Companion.f50506b;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.Serializable c(com.zeptonow.horizon.network.KtorNetworkClient r5, java.lang.Exception r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.network.KtorNetworkClient.c(com.zeptonow.horizon.network.KtorNetworkClient, java.lang.Exception, kotlin.coroutines.jvm.internal.ContinuationImpl):java.io.Serializable");
    }

    @Override // com.zeptonow.horizon.network.NetworkClient
    public final void a(JsonObject headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        StringValues.Companion companion = StringValues.f50504c;
        StringValuesBuilderImpl stringValuesBuilderImpl = new StringValuesBuilderImpl(false);
        for (Map.Entry entry : headers.f55996a.entrySet()) {
            String str = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
            Intrinsics.checkNotNullParameter(jsonElement, "<this>");
            JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
            if (jsonPrimitive == null) {
                JsonElementKt.c("JsonPrimitive", jsonElement);
                throw null;
            }
            stringValuesBuilderImpl.c(str, jsonPrimitive.b());
        }
        this.f48110d = new StringValuesImpl(stringValuesBuilderImpl.f50508b, stringValuesBuilderImpl.f50507a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.zeptonow.horizon.network.NetworkClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.util.List r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$1
            if (r0 == 0) goto L13
            r0 = r7
            com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$1 r0 = (com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$1) r0
            int r1 = r0.f48119c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f48119c = r1
            goto L18
        L13:
            com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$1 r0 = new com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f48117a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f48119c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r7)
            goto L45
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.ResultKt.b(r7)
            com.zeptonow.horizon.utils.AndroidDispatchersProvider r7 = r5.f48109c
            kotlinx.coroutines.scheduling.DefaultIoScheduler r7 = r7.f48229c
            com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$2 r2 = new com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$2
            r4 = 0
            r2.<init>(r6, r5, r4)
            r0.f48119c = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.e(r7, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r6 = r7.f53539a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptonow.horizon.network.KtorNetworkClient.b(java.util.List, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
