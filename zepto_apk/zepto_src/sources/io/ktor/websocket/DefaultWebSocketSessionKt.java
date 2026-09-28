package io.ktor.websocket;

import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.websocket.CloseReason;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineName;
import org.slf4j.Logger;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DefaultWebSocketSessionKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f51435a = KtorSimpleLoggerJvmKt.a("io.ktor.websocket.WebSocket");

    /* renamed from: b, reason: collision with root package name */
    public static final CoroutineName f51436b = new CoroutineName("ws-incoming-processor");

    /* renamed from: c, reason: collision with root package name */
    public static final CoroutineName f51437c = new CoroutineName("ws-outgoing-processor");

    /* renamed from: d, reason: collision with root package name */
    public static final CloseReason f51438d = new CloseReason(CloseReason.Codes.NORMAL, "OK");
}
