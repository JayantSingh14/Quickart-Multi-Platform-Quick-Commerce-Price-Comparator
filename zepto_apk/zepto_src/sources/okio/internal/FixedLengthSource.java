package okio.internal;

import android.support.v4.media.b;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata
/* loaded from: classes3.dex */
public final class FixedLengthSource extends ForwardingSource {

    /* renamed from: a, reason: collision with root package name */
    public final long f57038a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f57039b;

    /* renamed from: c, reason: collision with root package name */
    public long f57040c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FixedLengthSource(Source delegate, long j2, boolean z) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f57038a = j2;
        this.f57039b = z;
    }

    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer sink, long j2) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j3 = this.f57040c;
        long j4 = this.f57038a;
        if (j3 > j4) {
            j2 = 0;
        } else if (this.f57039b) {
            long j5 = j4 - j3;
            if (j5 == 0) {
                return -1L;
            }
            j2 = Math.min(j2, j5);
        }
        long j6 = super.read(sink, j2);
        if (j6 != -1) {
            this.f57040c += j6;
        }
        long j7 = this.f57040c;
        if ((j7 >= j4 || j6 != -1) && j7 <= j4) {
            return j6;
        }
        if (j6 > 0 && j7 > j4) {
            long j8 = sink.f56914b - (j7 - j4);
            Buffer buffer = new Buffer();
            buffer.g0(sink);
            sink.write(buffer, j8);
            buffer.a();
        }
        StringBuilder sbV = b.v(j4, "expected ", " bytes but got ");
        sbV.append(this.f57040c);
        throw new IOException(sbV.toString());
    }
}
