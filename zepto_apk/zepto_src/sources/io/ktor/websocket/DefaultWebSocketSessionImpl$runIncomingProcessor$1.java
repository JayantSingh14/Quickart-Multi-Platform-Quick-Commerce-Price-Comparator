package io.ktor.websocket;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

@Metadata
@DebugMetadata(c = "io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1", f = "DefaultWebSocketSession.kt", l = {352, 172, 226, 178, 179, 181, 196, 211, 226, 226, 226, 226}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class DefaultWebSocketSessionImpl$runIncomingProcessor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public Serializable f51411a;

    /* renamed from: b, reason: collision with root package name */
    public Object f51412b;

    /* renamed from: c, reason: collision with root package name */
    public Ref.BooleanRef f51413c;

    /* renamed from: d, reason: collision with root package name */
    public DefaultWebSocketSessionImpl f51414d;

    /* renamed from: e, reason: collision with root package name */
    public SendChannel f51415e;

    /* renamed from: f, reason: collision with root package name */
    public ReceiveChannel f51416f;

    /* renamed from: g, reason: collision with root package name */
    public ChannelIterator f51417g;

    /* renamed from: h, reason: collision with root package name */
    public Frame f51418h;

    /* renamed from: i, reason: collision with root package name */
    public int f51419i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f51420j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ DefaultWebSocketSessionImpl f51421k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ BufferedChannel f51422l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultWebSocketSessionImpl$runIncomingProcessor$1(DefaultWebSocketSessionImpl defaultWebSocketSessionImpl, BufferedChannel bufferedChannel, Continuation continuation) {
        super(2, continuation);
        this.f51421k = defaultWebSocketSessionImpl;
        this.f51422l = bufferedChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DefaultWebSocketSessionImpl$runIncomingProcessor$1 defaultWebSocketSessionImpl$runIncomingProcessor$1 = new DefaultWebSocketSessionImpl$runIncomingProcessor$1(this.f51421k, this.f51422l, continuation);
        defaultWebSocketSessionImpl$runIncomingProcessor$1.f51420j = obj;
        return defaultWebSocketSessionImpl$runIncomingProcessor$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((DefaultWebSocketSessionImpl$runIncomingProcessor$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x035c, code lost:
    
        if (r3.o(r0, r23) == r2) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x03a2, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r0, r3, r23) == r2) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x03fb, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r0, r3, r23) == r2) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0480, code lost:
    
        if (io.ktor.websocket.WebSocketSessionKt.a(r0, r3, r23) == r2) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0360, code lost:
    
        r6 = r12.f53801a;
        kotlin.jvm.internal.Intrinsics.c(r6);
        r0 = r0.f51442c;
        io.ktor.utils.io.core.OutputKt.b((io.ktor.utils.io.core.Output) r6, r0, 0, r0.length);
        r0 = r13;
        r13 = r7;
        r7 = r0;
        r0 = r12;
        r12 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r0;
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x020d, code lost:
    
        r0 = r7;
        r7 = r8;
        r8 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0363 A[Catch: all -> 0x003e, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x003e, blocks: (B:9:0x0039, B:40:0x013b, B:42:0x0143, B:44:0x016b, B:46:0x0173, B:48:0x017f, B:49:0x0181, B:52:0x019f, B:64:0x01e6, B:66:0x01ea, B:68:0x01f0, B:71:0x020b, B:73:0x021a, B:75:0x021e, B:78:0x0239, B:109:0x0363, B:20:0x0094, B:23:0x00b0, B:28:0x00cd, B:31:0x00e8), top: B:161:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0143 A[Catch: all -> 0x003e, TryCatch #4 {all -> 0x003e, blocks: (B:9:0x0039, B:40:0x013b, B:42:0x0143, B:44:0x016b, B:46:0x0173, B:48:0x017f, B:49:0x0181, B:52:0x019f, B:64:0x01e6, B:66:0x01ea, B:68:0x01f0, B:71:0x020b, B:73:0x021a, B:75:0x021e, B:78:0x0239, B:109:0x0363, B:20:0x0094, B:23:0x00b0, B:28:0x00cd, B:31:0x00e8), top: B:161:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019f A[Catch: all -> 0x003e, PHI: r7 r10 r11
      0x019f: PHI (r7v17 kotlinx.coroutines.channels.ReceiveChannel) = 
      (r7v5 kotlinx.coroutines.channels.ReceiveChannel)
      (r7v19 kotlinx.coroutines.channels.ReceiveChannel)
      (r7v19 kotlinx.coroutines.channels.ReceiveChannel)
     binds: [B:28:0x00cd, B:45:0x0171, B:50:0x019b] A[DONT_GENERATE, DONT_INLINE]
      0x019f: PHI (r10v14 kotlin.jvm.internal.Ref$BooleanRef) = 
      (r10v3 kotlin.jvm.internal.Ref$BooleanRef)
      (r10v15 kotlin.jvm.internal.Ref$BooleanRef)
      (r10v15 kotlin.jvm.internal.Ref$BooleanRef)
     binds: [B:28:0x00cd, B:45:0x0171, B:50:0x019b] A[DONT_GENERATE, DONT_INLINE]
      0x019f: PHI (r11v19 kotlin.jvm.internal.Ref$ObjectRef) = 
      (r11v4 kotlin.jvm.internal.Ref$ObjectRef)
      (r11v20 kotlin.jvm.internal.Ref$ObjectRef)
      (r11v20 kotlin.jvm.internal.Ref$ObjectRef)
     binds: [B:28:0x00cd, B:45:0x0171, B:50:0x019b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {all -> 0x003e, blocks: (B:9:0x0039, B:40:0x013b, B:42:0x0143, B:44:0x016b, B:46:0x0173, B:48:0x017f, B:49:0x0181, B:52:0x019f, B:64:0x01e6, B:66:0x01ea, B:68:0x01f0, B:71:0x020b, B:73:0x021a, B:75:0x021e, B:78:0x0239, B:109:0x0363, B:20:0x0094, B:23:0x00b0, B:28:0x00cd, B:31:0x00e8), top: B:161:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x026a A[Catch: all -> 0x0077, TryCatch #2 {all -> 0x0077, blocks: (B:82:0x0266, B:84:0x026a, B:86:0x026e, B:87:0x0270, B:89:0x0274, B:90:0x027c, B:91:0x0293, B:93:0x0297, B:94:0x029f, B:96:0x02a5, B:97:0x02b3, B:101:0x02da, B:102:0x0331, B:104:0x0337, B:105:0x0342, B:15:0x0071), top: B:157:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0293 A[Catch: all -> 0x0077, TryCatch #2 {all -> 0x0077, blocks: (B:82:0x0266, B:84:0x026a, B:86:0x026e, B:87:0x0270, B:89:0x0274, B:90:0x027c, B:91:0x0293, B:93:0x0297, B:94:0x029f, B:96:0x02a5, B:97:0x02b3, B:101:0x02da, B:102:0x0331, B:104:0x0337, B:105:0x0342, B:15:0x0071), top: B:157:0x0071 }] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v4, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r8v5, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r9v4, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x01ee -> B:72:0x020d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0235 -> B:72:0x020d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1188
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.DefaultWebSocketSessionImpl$runIncomingProcessor$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
