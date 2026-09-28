package androidx.media3.exoplayer.dash;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.dash.manifest.EventStream;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.extractor.metadata.emsg.EventMessageEncoder;
import java.io.IOException;

/* loaded from: classes3.dex */
final class EventSampleStream implements SampleStream {

    /* renamed from: a, reason: collision with root package name */
    public final Format f6753a;

    /* renamed from: c, reason: collision with root package name */
    public long[] f6755c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6756d;

    /* renamed from: e, reason: collision with root package name */
    public EventStream f6757e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6758f;

    /* renamed from: g, reason: collision with root package name */
    public int f6759g;

    /* renamed from: b, reason: collision with root package name */
    public final EventMessageEncoder f6754b = new EventMessageEncoder();

    /* renamed from: h, reason: collision with root package name */
    public long f6760h = -9223372036854775807L;

    public EventSampleStream(EventStream eventStream, Format format, boolean z) {
        this.f6753a = format;
        this.f6757e = eventStream;
        this.f6755c = eventStream.f6819b;
        b(eventStream, z);
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final boolean a() {
        return true;
    }

    public final void b(EventStream eventStream, boolean z) {
        int i2 = this.f6759g;
        long j2 = -9223372036854775807L;
        long j3 = i2 == 0 ? -9223372036854775807L : this.f6755c[i2 - 1];
        this.f6756d = z;
        this.f6757e = eventStream;
        long[] jArr = eventStream.f6819b;
        this.f6755c = jArr;
        long j4 = this.f6760h;
        if (j4 == -9223372036854775807L) {
            if (j3 != -9223372036854775807L) {
                this.f6759g = Util.b(jArr, j3, false);
            }
        } else {
            int iB = Util.b(jArr, j4, true);
            this.f6759g = iB;
            if (this.f6756d && iB == this.f6755c.length) {
                j2 = j4;
            }
            this.f6760h = j2;
        }
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final void c() {
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final int m(long j2) {
        int iMax = Math.max(this.f6759g, Util.b(this.f6755c, j2, true));
        int i2 = iMax - this.f6759g;
        this.f6759g = iMax;
        return i2;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) throws IOException {
        int i3 = this.f6759g;
        boolean z = i3 == this.f6755c.length;
        if (z && !this.f6756d) {
            decoderInputBuffer.f6056a = 4;
            return -4;
        }
        if ((i2 & 2) != 0 || !this.f6758f) {
            formatHolder.f6254b = this.f6753a;
            this.f6758f = true;
            return -5;
        }
        if (z) {
            return -3;
        }
        if ((i2 & 1) == 0) {
            this.f6759g = i3 + 1;
        }
        if ((i2 & 4) == 0) {
            byte[] bArrA = this.f6754b.a(this.f6757e.f6818a[i3]);
            decoderInputBuffer.l(bArrA.length);
            decoderInputBuffer.f6071d.put(bArrA);
        }
        decoderInputBuffer.f6073f = this.f6755c[i3];
        decoderInputBuffer.f6056a = 1;
        return -4;
    }
}
