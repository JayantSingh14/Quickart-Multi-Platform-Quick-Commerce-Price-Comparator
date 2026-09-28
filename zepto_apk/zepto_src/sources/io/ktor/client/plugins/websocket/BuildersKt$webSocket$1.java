package io.ktor.client.plugins.websocket;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt", f = "builders.kt", l = {242, WKSRecord.Service.LINK, 101, 103, 103, Type.IXFR, Type.IXFR}, m = "webSocket")
/* loaded from: classes3.dex */
final class BuildersKt$webSocket$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f49965a;

    /* renamed from: b, reason: collision with root package name */
    public Object f49966b;

    /* renamed from: c, reason: collision with root package name */
    public CoroutineScope f49967c;

    /* renamed from: d, reason: collision with root package name */
    public Throwable f49968d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f49969e;

    /* renamed from: f, reason: collision with root package name */
    public int f49970f;

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
    
        if (r5.a(r4, r8) != r1) goto L48;
     */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x012c: INVOKE (r9 I:java.lang.Object) = 
      (r5v0 ?? I:io.ktor.client.statement.HttpStatement)
      (r4 I:io.ktor.client.statement.HttpResponse)
      (r8 I:kotlin.coroutines.jvm.internal.ContinuationImpl)
     VIRTUAL call: io.ktor.client.statement.HttpStatement.a(io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object A[Catch: CancellationException -> 0x0023, MD:(io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object (m)] (LINE:301), block:B:59:0x0121 */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x012c: INVOKE (r9 I:java.lang.Object) = 
      (r5 I:io.ktor.client.statement.HttpStatement)
      (r4 I:io.ktor.client.statement.HttpResponse)
      (r8 I:kotlin.coroutines.jvm.internal.ContinuationImpl)
     VIRTUAL call: io.ktor.client.statement.HttpStatement.a(io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object A[Catch: CancellationException -> 0x0023, MD:(io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object (m)] (LINE:301), block:B:59:0x0121 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003d, B:55:0x010f, B:56:0x0118, B:20:0x0054, B:44:0x00dd, B:41:0x00cd, B:52:0x00fd, B:28:0x0080, B:36:0x00ba, B:57:0x0119, B:58:0x0120, B:32:0x0093), top: B:67:0x000f, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00dd A[Catch: all -> 0x0042, PHI: r0 r4 r5
      0x00dd: PHI (r0v21 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) = 
      (r0v17 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession)
      (r0v23 io.ktor.client.plugins.websocket.DefaultClientWebSocketSession)
     binds: [B:42:0x00da, B:20:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r4v12 io.ktor.client.statement.HttpResponse) = (r4v7 io.ktor.client.statement.HttpResponse), (r4v14 io.ktor.client.statement.HttpResponse) binds: [B:42:0x00da, B:20:0x0054] A[DONT_GENERATE, DONT_INLINE]
      0x00dd: PHI (r5v10 io.ktor.client.statement.HttpStatement) = (r5v7 io.ktor.client.statement.HttpStatement), (r5v12 io.ktor.client.statement.HttpStatement) binds: [B:42:0x00da, B:20:0x0054] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003d, B:55:0x010f, B:56:0x0118, B:20:0x0054, B:44:0x00dd, B:41:0x00cd, B:52:0x00fd, B:28:0x0080, B:36:0x00ba, B:57:0x0119, B:58:0x0120, B:32:0x0093), top: B:67:0x000f, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0119 A[Catch: all -> 0x0042, TryCatch #0 {all -> 0x0042, blocks: (B:15:0x003d, B:55:0x010f, B:56:0x0118, B:20:0x0054, B:44:0x00dd, B:41:0x00cd, B:52:0x00fd, B:28:0x0080, B:36:0x00ba, B:57:0x0119, B:58:0x0120, B:32:0x0093), top: B:67:0x000f, outer: #3 }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r5v0, types: [io.ktor.client.statement.HttpStatement] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt$webSocket$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
