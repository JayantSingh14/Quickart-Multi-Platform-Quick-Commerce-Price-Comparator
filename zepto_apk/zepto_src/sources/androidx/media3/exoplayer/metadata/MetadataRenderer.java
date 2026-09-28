package androidx.media3.exoplayer.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.metadata.MetadataDecoderFactory;
import androidx.media3.extractor.metadata.MetadataDecoder;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    public long A;
    public final MetadataDecoderFactory r;
    public final MetadataOutput s;
    public final Handler t;
    public final MetadataInputBuffer u;
    public MetadataDecoder v;
    public boolean w;
    public boolean x;
    public long y;
    public Metadata z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        Handler handler;
        super(5);
        MetadataDecoderFactory metadataDecoderFactory = MetadataDecoderFactory.f7361a;
        this.s = metadataOutput;
        if (looper == null) {
            handler = null;
        } else {
            int i2 = Util.f5744a;
            handler = new Handler(looper, this);
        }
        this.t = handler;
        this.r = metadataDecoderFactory;
        this.u = new MetadataInputBuffer();
        this.A = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void G() {
        this.z = null;
        this.v = null;
        this.A = -9223372036854775807L;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void I(long j2, boolean z) {
        this.z = null;
        this.w = false;
        this.x = false;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer
    public final void N(Format[] formatArr, long j2, long j3) {
        this.v = ((MetadataDecoderFactory.AnonymousClass1) this.r).a(formatArr[0]);
        Metadata metadata = this.z;
        if (metadata != null) {
            long j4 = this.A;
            long j5 = metadata.f5406b;
            long j6 = (j4 + j5) - j3;
            if (j5 != j6) {
                metadata = new Metadata(j6, metadata.f5405a);
            }
            this.z = metadata;
        }
        this.A = j3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P(androidx.media3.common.Metadata r7, java.util.ArrayList r8) {
        /*
            r6 = this;
            r0 = 0
        L1:
            androidx.media3.common.Metadata$Entry[] r1 = r7.f5405a
            int r2 = r1.length
            if (r0 >= r2) goto L4a
            r2 = r1[r0]
            androidx.media3.common.Format r2 = r2.z0()
            if (r2 == 0) goto L42
            androidx.media3.exoplayer.metadata.MetadataDecoderFactory r3 = r6.r
            androidx.media3.exoplayer.metadata.MetadataDecoderFactory$1 r3 = (androidx.media3.exoplayer.metadata.MetadataDecoderFactory.AnonymousClass1) r3
            boolean r4 = r3.b(r2)
            if (r4 == 0) goto L42
            androidx.media3.extractor.metadata.SimpleMetadataDecoder r2 = r3.a(r2)
            r1 = r1[r0]
            byte[] r1 = r1.T7()
            r1.getClass()
            androidx.media3.extractor.metadata.MetadataInputBuffer r3 = r6.u
            r3.h()
            int r4 = r1.length
            r3.l(r4)
            java.nio.ByteBuffer r4 = r3.f6071d
            int r5 = androidx.media3.common.util.Util.f5744a
            r4.put(r1)
            r3.n()
            androidx.media3.common.Metadata r1 = r2.a(r3)
            if (r1 == 0) goto L47
            r6.P(r1, r8)
            goto L47
        L42:
            r1 = r1[r0]
            r8.add(r1)
        L47:
            int r0 = r0 + 1
            goto L1
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.metadata.MetadataRenderer.P(androidx.media3.common.Metadata, java.util.ArrayList):void");
    }

    public final long Q(long j2) {
        Assertions.g(j2 != -9223372036854775807L);
        Assertions.g(this.A != -9223372036854775807L);
        return j2 - this.A;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final boolean a() {
        return true;
    }

    @Override // androidx.media3.exoplayer.RendererCapabilities
    public final int b(Format format) {
        if (((MetadataDecoderFactory.AnonymousClass1) this.r).b(format)) {
            return RendererCapabilities.h(format.J == 0 ? 4 : 2, 0, 0, 0);
        }
        return RendererCapabilities.h(0, 0, 0, 0);
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public final boolean c() {
        return this.x;
    }

    @Override // androidx.media3.exoplayer.Renderer, androidx.media3.exoplayer.RendererCapabilities
    public final String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 1) {
            throw new IllegalStateException();
        }
        this.s.f1((Metadata) message.obj);
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public final void i(long j2, long j3) {
        boolean z = true;
        while (z) {
            if (!this.w && this.z == null) {
                MetadataInputBuffer metadataInputBuffer = this.u;
                metadataInputBuffer.h();
                FormatHolder formatHolder = this.f6114c;
                formatHolder.a();
                int iO = O(formatHolder, metadataInputBuffer, 0);
                if (iO == -4) {
                    if (metadataInputBuffer.g(4)) {
                        this.w = true;
                    } else if (metadataInputBuffer.f6073f >= this.f6123l) {
                        metadataInputBuffer.f8765i = this.y;
                        metadataInputBuffer.n();
                        MetadataDecoder metadataDecoder = this.v;
                        int i2 = Util.f5744a;
                        Metadata metadataA = metadataDecoder.a(metadataInputBuffer);
                        if (metadataA != null) {
                            ArrayList arrayList = new ArrayList(metadataA.f5405a.length);
                            P(metadataA, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.z = new Metadata(Q(metadataInputBuffer.f6073f), (Metadata.Entry[]) arrayList.toArray(new Metadata.Entry[0]));
                            }
                        }
                    }
                } else if (iO == -5) {
                    Format format = formatHolder.f6254b;
                    format.getClass();
                    this.y = format.r;
                }
            }
            Metadata metadata = this.z;
            if (metadata == null || metadata.f5406b > Q(j2)) {
                z = false;
            } else {
                Metadata metadata2 = this.z;
                Handler handler = this.t;
                if (handler != null) {
                    handler.obtainMessage(1, metadata2).sendToTarget();
                } else {
                    this.s.f1(metadata2);
                }
                this.z = null;
                z = true;
            }
            if (this.w && this.z == null) {
                this.x = true;
            }
        }
    }
}
