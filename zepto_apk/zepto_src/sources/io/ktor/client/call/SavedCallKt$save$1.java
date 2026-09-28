package io.ktor.client.call;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.call.SavedCallKt", f = "SavedCall.kt", l = {WKSRecord.Service.NETRJS_3}, m = "save")
/* loaded from: classes.dex */
final class SavedCallKt$save$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpClientCall f49313a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49314b;

    /* renamed from: c, reason: collision with root package name */
    public int f49315c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49314b = obj;
        this.f49315c |= Integer.MIN_VALUE;
        return SavedCallKt.a(null, this);
    }
}
