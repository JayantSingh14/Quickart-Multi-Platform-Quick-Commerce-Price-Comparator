package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes3.dex */
public final class OutputStreamContent extends OutgoingContent.WriteChannelContent {
    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public final Object d(ByteWriteChannel byteWriteChannel, Continuation continuation) throws Throwable {
        boolean zB;
        Object objE;
        OutputStreamContent$writeTo$2 outputStreamContent$writeTo$2 = new OutputStreamContent$writeTo$2(byteWriteChannel, this, null);
        SuspendLambda suspendLambda = (SuspendLambda) continuation;
        Method method = (Method) BlockingBridgeKt.f50281a.getValue();
        boolean z = false;
        if (method != null) {
            try {
                zB = Intrinsics.b(method.invoke(null, null), Boolean.TRUE);
            } catch (Throwable unused) {
                zB = false;
            }
            if (zB) {
                z = true;
            }
        }
        if (z) {
            objE = outputStreamContent$writeTo$2.invoke(suspendLambda);
            if (objE != CoroutineSingletons.f53689a) {
                objE = Unit.f53572a;
            }
        } else {
            DefaultScheduler defaultScheduler = Dispatchers.f54091a;
            objE = BuildersKt.e(DefaultIoScheduler.f55150b, new BlockingBridgeKt$withBlockingAndRedispatch$2(outputStreamContent$writeTo$2, null), suspendLambda);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            if (objE != coroutineSingletons) {
                objE = Unit.f53572a;
            }
            if (objE != coroutineSingletons) {
                objE = Unit.f53572a;
            }
        }
        return objE == CoroutineSingletons.f53689a ? objE : Unit.f53572a;
    }
}
