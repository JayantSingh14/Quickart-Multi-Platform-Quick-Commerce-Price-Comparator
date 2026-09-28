package io.ktor.util;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt", f = "ByteChannels.kt", l = {WKSRecord.Service.MIT_DOV}, m = "toByteArray")
/* loaded from: classes3.dex */
final class ByteChannelsKt$toByteArray$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f50436a;

    /* renamed from: b, reason: collision with root package name */
    public int f50437b;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f50436a = obj;
        this.f50437b |= Integer.MIN_VALUE;
        return ByteChannelsKt.b(null, this);
    }
}
