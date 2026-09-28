package kotlinx.coroutines.channels;

import io.ktor.client.engine.okhttp.OkHttpWebsocketSession;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: classes3.dex */
public final class ActorKt {
    public static SendChannel a(OkHttpWebsocketSession okHttpWebsocketSession, Function2 function2) {
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f53685a;
        CoroutineStart coroutineStart = CoroutineStart.f54078a;
        CoroutineContext coroutineContextB = CoroutineContextKt.b(okHttpWebsocketSession, emptyCoroutineContext);
        BufferedChannel bufferedChannelA = ChannelKt.a(0, null, 6);
        CoroutineStart coroutineStart2 = CoroutineStart.f54078a;
        ActorCoroutine actorCoroutine = new ActorCoroutine(coroutineContextB, bufferedChannelA, false, true);
        actorCoroutine.S((Job) coroutineContextB.get(Job.Key.f54121a));
        actorCoroutine.A0(coroutineStart, actorCoroutine, function2);
        return actorCoroutine;
    }
}
