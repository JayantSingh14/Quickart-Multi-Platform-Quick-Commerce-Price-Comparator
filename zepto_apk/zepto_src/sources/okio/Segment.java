package okio;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.KEYRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Segment {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f56988a;

    /* renamed from: b, reason: collision with root package name */
    public int f56989b;

    /* renamed from: c, reason: collision with root package name */
    public int f56990c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f56991d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f56992e;

    /* renamed from: f, reason: collision with root package name */
    public Segment f56993f;

    /* renamed from: g, reason: collision with root package name */
    public Segment f56994g;

    @Metadata
    public static final class Companion {
    }

    public Segment() {
        this.f56988a = new byte[KEYRecord.Flags.FLAG2];
        this.f56992e = true;
        this.f56991d = false;
    }

    public final Segment a() {
        Segment segment = this.f56993f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f56994g;
        Intrinsics.c(segment2);
        segment2.f56993f = this.f56993f;
        Segment segment3 = this.f56993f;
        Intrinsics.c(segment3);
        segment3.f56994g = this.f56994g;
        this.f56993f = null;
        this.f56994g = null;
        return segment;
    }

    public final void b(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.f56994g = this;
        segment.f56993f = this.f56993f;
        Segment segment2 = this.f56993f;
        Intrinsics.c(segment2);
        segment2.f56994g = segment;
        this.f56993f = segment;
    }

    public final Segment c() {
        this.f56991d = true;
        return new Segment(this.f56988a, this.f56989b, this.f56990c, true, false);
    }

    public final void d(Segment sink, int i2) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.f56992e) {
            throw new IllegalStateException("only owner can write");
        }
        int i3 = sink.f56990c;
        int i4 = i3 + i2;
        byte[] bArr = sink.f56988a;
        if (i4 > 8192) {
            if (sink.f56991d) {
                throw new IllegalArgumentException();
            }
            int i5 = sink.f56989b;
            if (i4 - i5 > 8192) {
                throw new IllegalArgumentException();
            }
            ArraysKt.l(bArr, 0, i5, bArr, i3);
            sink.f56990c -= sink.f56989b;
            sink.f56989b = 0;
        }
        int i6 = sink.f56990c;
        int i7 = this.f56989b;
        ArraysKt.l(this.f56988a, i6, i7, bArr, i7 + i2);
        sink.f56990c += i2;
        this.f56989b += i2;
    }

    public Segment(byte[] data, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f56988a = data;
        this.f56989b = i2;
        this.f56990c = i3;
        this.f56991d = z;
        this.f56992e = z2;
    }
}
