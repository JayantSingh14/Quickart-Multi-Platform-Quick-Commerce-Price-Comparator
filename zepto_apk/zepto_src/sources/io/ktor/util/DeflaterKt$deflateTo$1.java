package io.ktor.util;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.util.DeflaterKt", f = "Deflater.kt", l = {WKSRecord.Service.NETRJS_2, 77, 82, 88, WKSRecord.Service.MIT_DOV}, m = "deflateTo")
/* loaded from: classes3.dex */
final class DeflaterKt$deflateTo$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f50450a;

    /* renamed from: b, reason: collision with root package name */
    public Object f50451b;

    /* renamed from: c, reason: collision with root package name */
    public Object f50452c;

    /* renamed from: d, reason: collision with root package name */
    public Object f50453d;

    /* renamed from: e, reason: collision with root package name */
    public Object f50454e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f50455f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f50456g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f50457h;

    /* renamed from: i, reason: collision with root package name */
    public int f50458i;

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x008b: MOVE (r5 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:140), block:B:27:0x0089 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x008c: MOVE (r6 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:141), block:B:27:0x0089 */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6 A[Catch: all -> 0x0088, PHI: r4 r6 r9 r10 r11 r12 r13 r14
      0x00c6: PHI (r4v5 java.nio.ByteBuffer) = (r4v3 java.nio.ByteBuffer), (r4v4 java.nio.ByteBuffer), (r4v7 java.nio.ByteBuffer) binds: [B:32:0x00c3, B:39:0x00ed, B:47:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r6v5 'buffer' java.nio.ByteBuffer) = (r6v3 'buffer' java.nio.ByteBuffer), (r6v4 'buffer' java.nio.ByteBuffer), (r6v7 'buffer' java.nio.ByteBuffer) binds: [B:32:0x00c3, B:39:0x00ed, B:47:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r9v5 int) = (r9v0 int), (r9v1 int), (r9v6 int) binds: [B:32:0x00c3, B:39:0x00ed, B:47:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r10v4 java.util.zip.Deflater) = (r10v2 java.util.zip.Deflater), (r10v3 java.util.zip.Deflater), (r10v5 java.util.zip.Deflater) binds: [B:32:0x00c3, B:39:0x00ed, B:47:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r11v3 java.util.zip.CRC32) = (r11v1 java.util.zip.CRC32), (r11v2 java.util.zip.CRC32), (r11v4 java.util.zip.CRC32) binds: [B:32:0x00c3, B:39:0x00ed, B:47:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r12v4 io.ktor.utils.io.pool.ObjectPool) = 
      (r12v2 io.ktor.utils.io.pool.ObjectPool)
      (r12v3 io.ktor.utils.io.pool.ObjectPool)
      (r12v5 io.ktor.utils.io.pool.ObjectPool)
     binds: [B:32:0x00c3, B:39:0x00ed, B:47:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r13v3 io.ktor.utils.io.ByteWriteChannel) = 
      (r13v1 io.ktor.utils.io.ByteWriteChannel)
      (r13v2 io.ktor.utils.io.ByteWriteChannel)
      (r13v4 io.ktor.utils.io.ByteWriteChannel)
     binds: [B:32:0x00c3, B:39:0x00ed, B:47:0x014d] A[DONT_GENERATE, DONT_INLINE]
      0x00c6: PHI (r14v3 io.ktor.utils.io.ByteReadChannel) = 
      (r14v1 io.ktor.utils.io.ByteReadChannel)
      (r14v2 io.ktor.utils.io.ByteReadChannel)
      (r14v4 io.ktor.utils.io.ByteReadChannel)
     binds: [B:32:0x00c3, B:39:0x00ed, B:47:0x014d] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0088, blocks: (B:24:0x0083, B:33:0x00c6, B:35:0x00cc, B:38:0x00e7, B:40:0x00ef, B:42:0x0102, B:44:0x011d, B:48:0x0150, B:49:0x0157, B:50:0x0158, B:51:0x015f, B:52:0x0160, B:54:0x0166, B:60:0x0195, B:29:0x00a7, B:32:0x00c3), top: B:65:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cc A[Catch: all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:24:0x0083, B:33:0x00c6, B:35:0x00cc, B:38:0x00e7, B:40:0x00ef, B:42:0x0102, B:44:0x011d, B:48:0x0150, B:49:0x0157, B:50:0x0158, B:51:0x015f, B:52:0x0160, B:54:0x0166, B:60:0x0195, B:29:0x00a7, B:32:0x00c3), top: B:65:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ef A[Catch: all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:24:0x0083, B:33:0x00c6, B:35:0x00cc, B:38:0x00e7, B:40:0x00ef, B:42:0x0102, B:44:0x011d, B:48:0x0150, B:49:0x0157, B:50:0x0158, B:51:0x015f, B:52:0x0160, B:54:0x0166, B:60:0x0195, B:29:0x00a7, B:32:0x00c3), top: B:65:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0160 A[Catch: all -> 0x0088, TryCatch #0 {all -> 0x0088, blocks: (B:24:0x0083, B:33:0x00c6, B:35:0x00cc, B:38:0x00e7, B:40:0x00ef, B:42:0x0102, B:44:0x011d, B:48:0x0150, B:49:0x0157, B:50:0x0158, B:51:0x015f, B:52:0x0160, B:54:0x0166, B:60:0x0195, B:29:0x00a7, B:32:0x00c3), top: B:65:0x0028 }] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ed -> B:33:0x00c6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x014a -> B:47:0x014d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 431
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.DeflaterKt$deflateTo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
