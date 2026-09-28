package io.ktor.client.plugins.cache.storage;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$1$1$1", f = "FileCacheStorage.kt", l = {96, WKSRecord.Service.TACNEWS}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class FileCacheStorage$writeCache$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f49816a;

    /* renamed from: b, reason: collision with root package name */
    public int f49817b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ByteBufferChannel f49818c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$writeCache$2$1$1$1(ByteBufferChannel byteBufferChannel, Continuation continuation) {
        super(2, continuation);
        this.f49818c = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FileCacheStorage$writeCache$2$1$1$1(this.f49818c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileCacheStorage$writeCache$2$1$1$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        int i2 = this.f49817b;
        ByteBufferChannel byteBufferChannel = this.f49818c;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 == 1) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterator it = this.f49816a;
        ResultKt.b(obj);
        if (!it.hasNext()) {
            ByteWriteChannelKt.a(byteBufferChannel);
            return Unit.f53572a;
        }
        this.f49816a = it;
        this.f49817b = 2;
        throw null;
    }
}
