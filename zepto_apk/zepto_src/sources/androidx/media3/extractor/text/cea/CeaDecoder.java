package androidx.media3.extractor.text.cea;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleDecoder;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* loaded from: classes3.dex */
abstract class CeaDecoder implements SubtitleDecoder {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f9246a = new ArrayDeque();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f9247b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityQueue f9248c;

    /* renamed from: d, reason: collision with root package name */
    public CeaInputBuffer f9249d;

    /* renamed from: e, reason: collision with root package name */
    public long f9250e;

    /* renamed from: f, reason: collision with root package name */
    public long f9251f;

    /* renamed from: g, reason: collision with root package name */
    public long f9252g;

    public static final class CeaInputBuffer extends SubtitleInputBuffer implements Comparable<CeaInputBuffer> {

        /* renamed from: j, reason: collision with root package name */
        public long f9253j;

        @Override // java.lang.Comparable
        public final int compareTo(CeaInputBuffer ceaInputBuffer) {
            CeaInputBuffer ceaInputBuffer2 = ceaInputBuffer;
            if (g(4) != ceaInputBuffer2.g(4)) {
                return g(4) ? 1 : -1;
            }
            long j2 = this.f6073f - ceaInputBuffer2.f6073f;
            if (j2 == 0) {
                j2 = this.f9253j - ceaInputBuffer2.f9253j;
                if (j2 == 0) {
                    return 0;
                }
            }
            return j2 > 0 ? 1 : -1;
        }
    }

    public static final class CeaOutputBuffer extends SubtitleOutputBuffer {

        /* renamed from: g, reason: collision with root package name */
        public b f9254g;

        @Override // androidx.media3.decoder.DecoderOutputBuffer
        public final void i() {
            b bVar = this.f9254g;
            bVar.getClass();
            CeaDecoder ceaDecoder = bVar.f9256a;
            h();
            ceaDecoder.f9247b.add(this);
        }
    }

    public CeaDecoder() {
        for (int i2 = 0; i2 < 10; i2++) {
            this.f9246a.add(new CeaInputBuffer());
        }
        this.f9247b = new ArrayDeque();
        for (int i3 = 0; i3 < 2; i3++) {
            ArrayDeque arrayDeque = this.f9247b;
            b bVar = new b(this);
            CeaOutputBuffer ceaOutputBuffer = new CeaOutputBuffer();
            ceaOutputBuffer.f9254g = bVar;
            arrayDeque.add(ceaOutputBuffer);
        }
        this.f9248c = new PriorityQueue();
        this.f9252g = -9223372036854775807L;
    }

    @Override // androidx.media3.decoder.Decoder
    public final void b(Object obj) {
        SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) obj;
        Assertions.a(subtitleInputBuffer == this.f9249d);
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) subtitleInputBuffer;
        long j2 = this.f9252g;
        if (j2 == -9223372036854775807L || ceaInputBuffer.f6073f >= j2) {
            long j3 = this.f9251f;
            this.f9251f = 1 + j3;
            ceaInputBuffer.f9253j = j3;
            this.f9248c.add(ceaInputBuffer);
        } else {
            ceaInputBuffer.h();
            this.f9246a.add(ceaInputBuffer);
        }
        this.f9249d = null;
    }

    @Override // androidx.media3.extractor.text.SubtitleDecoder
    public void c(long j2) {
        this.f9250e = j2;
    }

    @Override // androidx.media3.decoder.Decoder
    public final void d(long j2) {
        this.f9252g = j2;
    }

    @Override // androidx.media3.decoder.Decoder
    public final Object e() {
        Assertions.g(this.f9249d == null);
        ArrayDeque arrayDeque = this.f9246a;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) arrayDeque.pollFirst();
        this.f9249d = ceaInputBuffer;
        return ceaInputBuffer;
    }

    @Override // androidx.media3.decoder.Decoder
    public void flush() {
        ArrayDeque arrayDeque;
        this.f9251f = 0L;
        this.f9250e = 0L;
        while (true) {
            PriorityQueue priorityQueue = this.f9248c;
            boolean zIsEmpty = priorityQueue.isEmpty();
            arrayDeque = this.f9246a;
            if (zIsEmpty) {
                break;
            }
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) priorityQueue.poll();
            int i2 = Util.f5744a;
            ceaInputBuffer.h();
            arrayDeque.add(ceaInputBuffer);
        }
        CeaInputBuffer ceaInputBuffer2 = this.f9249d;
        if (ceaInputBuffer2 != null) {
            ceaInputBuffer2.h();
            arrayDeque.add(ceaInputBuffer2);
            this.f9249d = null;
        }
    }

    public abstract Subtitle g();

    public abstract void h(SubtitleInputBuffer subtitleInputBuffer);

    @Override // androidx.media3.decoder.Decoder
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public SubtitleOutputBuffer a() {
        ArrayDeque arrayDeque = this.f9247b;
        if (arrayDeque.isEmpty()) {
            return null;
        }
        while (true) {
            PriorityQueue priorityQueue = this.f9248c;
            if (priorityQueue.isEmpty()) {
                return null;
            }
            CeaInputBuffer ceaInputBuffer = (CeaInputBuffer) priorityQueue.peek();
            int i2 = Util.f5744a;
            if (ceaInputBuffer.f6073f > this.f9250e) {
                return null;
            }
            CeaInputBuffer ceaInputBuffer2 = (CeaInputBuffer) priorityQueue.poll();
            boolean zG = ceaInputBuffer2.g(4);
            ArrayDeque arrayDeque2 = this.f9246a;
            if (zG) {
                SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) arrayDeque.pollFirst();
                subtitleOutputBuffer.e(4);
                ceaInputBuffer2.h();
                arrayDeque2.add(ceaInputBuffer2);
                return subtitleOutputBuffer;
            }
            h(ceaInputBuffer2);
            if (j()) {
                Subtitle subtitleG = g();
                SubtitleOutputBuffer subtitleOutputBuffer2 = (SubtitleOutputBuffer) arrayDeque.pollFirst();
                long j2 = ceaInputBuffer2.f6073f;
                subtitleOutputBuffer2.f6076b = j2;
                subtitleOutputBuffer2.f9177e = subtitleG;
                subtitleOutputBuffer2.f9178f = j2;
                ceaInputBuffer2.h();
                arrayDeque2.add(ceaInputBuffer2);
                return subtitleOutputBuffer2;
            }
            ceaInputBuffer2.h();
            arrayDeque2.add(ceaInputBuffer2);
        }
    }

    public abstract boolean j();

    @Override // androidx.media3.decoder.Decoder
    public void release() {
    }
}
