package com.zeptonow.horizon.network;

import com.zeptonow.horizon.entity.dto.EventRequestBody;
import com.zeptonow.horizon.utils.SerializationUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.Json;

@Metadata
@SourceDebugExtension
/* renamed from: com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$2$invokeSuspend$$inlined$makeRequest-0E7RQCE$1, reason: invalid class name */
/* loaded from: classes.dex */
public final class KtorNetworkClient$sendEvents$2$invokeSuspend$$inlined$makeRequest0E7RQCE$1 extends Lambda implements Function0<String> {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ EventRequestBody f48111c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KtorNetworkClient$sendEvents$2$invokeSuspend$$inlined$makeRequest0E7RQCE$1(EventRequestBody eventRequestBody) {
        super(0);
        this.f48111c = eventRequestBody;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Json json = SerializationUtilsKt.f48279b;
        json.getClass();
        return json.d(EventRequestBody.Companion.serializer(), this.f48111c);
    }
}
