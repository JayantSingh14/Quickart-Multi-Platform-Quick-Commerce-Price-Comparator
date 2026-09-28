package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PeekSource implements Source {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedSource f56974a;

    /* renamed from: b, reason: collision with root package name */
    public final Buffer f56975b;

    /* renamed from: c, reason: collision with root package name */
    public Segment f56976c;

    /* renamed from: d, reason: collision with root package name */
    public int f56977d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f56978e;

    /* renamed from: f, reason: collision with root package name */
    public long f56979f;

    public PeekSource(BufferedSource upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.f56974a = upstream;
        Buffer bufferG = upstream.g();
        this.f56975b = bufferG;
        Segment segment = bufferG.f56913a;
        this.f56976c = segment;
        this.f56977d = segment != null ? segment.f56989b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f56978e = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0020, code lost:
    
        if (r3 == r5.f56989b) goto L15;
     */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6b
            boolean r3 = r8.f56978e
            if (r3 != 0) goto L63
            okio.Segment r3 = r8.f56976c
            okio.Buffer r4 = r8.f56975b
            if (r3 == 0) goto L2b
            okio.Segment r5 = r4.f56913a
            if (r3 != r5) goto L23
            int r3 = r8.f56977d
            kotlin.jvm.internal.Intrinsics.c(r5)
            int r5 = r5.f56989b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.f56979f
            r2 = 1
            long r0 = r0 + r2
            okio.BufferedSource r2 = r8.f56974a
            boolean r0 = r2.h0(r0)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            okio.Segment r0 = r8.f56976c
            if (r0 != 0) goto L4c
            okio.Segment r0 = r4.f56913a
            if (r0 == 0) goto L4c
            r8.f56976c = r0
            int r0 = r0.f56989b
            r8.f56977d = r0
        L4c:
            long r0 = r4.f56914b
            long r2 = r8.f56979f
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.f56975b
            long r4 = r8.f56979f
            r3 = r9
            r2.e(r3, r4, r6)
            long r9 = r8.f56979f
            long r9 = r9 + r6
            r8.f56979f = r9
            return r6
        L63:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L6b:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = android.support.v4.media.b.i(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.read(okio.Buffer, long):long");
    }

    @Override // okio.Source
    public final Timeout timeout() {
        return this.f56974a.timeout();
    }
}
