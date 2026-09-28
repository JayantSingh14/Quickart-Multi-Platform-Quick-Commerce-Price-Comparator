package androidx.media3.exoplayer.hls;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.SampleStream;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
final class HlsSampleStream implements SampleStream {

    /* renamed from: a, reason: collision with root package name */
    public final int f7036a;

    /* renamed from: b, reason: collision with root package name */
    public final HlsSampleStreamWrapper f7037b;

    /* renamed from: c, reason: collision with root package name */
    public int f7038c = -1;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i2) {
        this.f7037b = hlsSampleStreamWrapper;
        this.f7036a = i2;
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final boolean a() {
        if (this.f7038c == -3) {
            return true;
        }
        if (!d()) {
            return false;
        }
        int i2 = this.f7038c;
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f7037b;
        return !hlsSampleStreamWrapper.A() && hlsSampleStreamWrapper.v[i2].t(hlsSampleStreamWrapper.C0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            r6 = this;
            int r0 = r6.f7038c
            r1 = 1
            r2 = -1
            if (r0 != r2) goto L8
            r0 = r1
            goto L9
        L8:
            r0 = 0
        L9:
            androidx.media3.common.util.Assertions.a(r0)
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper r0 = r6.f7037b
            r0.t()
            int[] r3 = r0.K
            r3.getClass()
            int[] r3 = r0.K
            int r4 = r6.f7036a
            r3 = r3[r4]
            r5 = -2
            if (r3 != r2) goto L31
            java.util.Set r1 = r0.J
            androidx.media3.exoplayer.source.TrackGroupArray r0 = r0.I
            androidx.media3.common.TrackGroup r0 = r0.a(r4)
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L2f
            r3 = -3
            goto L3a
        L2f:
            r3 = r5
            goto L3a
        L31:
            boolean[] r0 = r0.Q
            boolean r2 = r0[r3]
            if (r2 == 0) goto L38
            goto L2f
        L38:
            r0[r3] = r1
        L3a:
            r6.f7038c = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsSampleStream.b():void");
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final void c() throws DrmSession.DrmSessionException, SampleQueueMappingException {
        int i2 = this.f7038c;
        HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f7037b;
        if (i2 == -2) {
            hlsSampleStreamWrapper.t();
            throw new SampleQueueMappingException(android.support.v4.media.b.D("Unable to bind a sample queue to TrackGroup with MIME type ", hlsSampleStreamWrapper.I.a(this.f7036a).f5504d[0].f5225m, CLConstants.DOT_SALT_DELIMETER));
        }
        if (i2 == -1) {
            hlsSampleStreamWrapper.C();
        } else if (i2 != -3) {
            hlsSampleStreamWrapper.C();
            hlsSampleStreamWrapper.v[i2].v();
        }
    }

    public final boolean d() {
        int i2 = this.f7038c;
        return (i2 == -1 || i2 == -3 || i2 == -2) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    @Override // androidx.media3.exoplayer.source.SampleStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m(long r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r4.d()
            if (r0 == 0) goto L67
            int r0 = r4.f7038c
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper r1 = r4.f7037b
            boolean r2 = r1.A()
            if (r2 == 0) goto L11
            goto L67
        L11:
            androidx.media3.exoplayer.hls.HlsSampleStreamWrapper$HlsSampleQueue[] r2 = r1.v
            r2 = r2[r0]
            boolean r3 = r1.C0
            int r5 = r2.r(r5, r3)
            java.util.ArrayList r6 = r1.n
            boolean r1 = r6 instanceof java.util.Collection
            if (r1 == 0) goto L37
            r1 = r6
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L2b
            goto L4d
        L2b:
            boolean r1 = r6 instanceof java.util.List
            if (r1 == 0) goto L37
            java.util.List r6 = (java.util.List) r6
            r1 = 1
            java.lang.Object r6 = androidx.fragment.app.e.k(r1, r6)
            goto L4e
        L37:
            java.util.Iterator r6 = r6.iterator()
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L4d
        L41:
            java.lang.Object r1 = r6.next()
            boolean r3 = r6.hasNext()
            if (r3 != 0) goto L41
            r6 = r1
            goto L4e
        L4d:
            r6 = 0
        L4e:
            androidx.media3.exoplayer.hls.HlsMediaChunk r6 = (androidx.media3.exoplayer.hls.HlsMediaChunk) r6
            if (r6 == 0) goto L63
            boolean r1 = r6.K
            if (r1 != 0) goto L63
            int r1 = r2.p()
            int r6 = r6.g(r0)
            int r6 = r6 - r1
            int r5 = java.lang.Math.min(r5, r6)
        L63:
            r2.C(r5)
            return r5
        L67:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.hls.HlsSampleStream.m(long):int");
    }

    @Override // androidx.media3.exoplayer.source.SampleStream
    public final int n(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
        Format format;
        if (this.f7038c == -3) {
            decoderInputBuffer.e(4);
            return -4;
        }
        if (d()) {
            int i3 = this.f7038c;
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.f7037b;
            if (!hlsSampleStreamWrapper.A()) {
                ArrayList arrayList = hlsSampleStreamWrapper.n;
                int i4 = 0;
                if (!arrayList.isEmpty()) {
                    int i5 = 0;
                    loop0: while (i5 < arrayList.size() - 1) {
                        int i6 = ((HlsMediaChunk) arrayList.get(i5)).f7002k;
                        int length = hlsSampleStreamWrapper.v.length;
                        for (int i7 = 0; i7 < length; i7++) {
                            if (hlsSampleStreamWrapper.Q[i7] && hlsSampleStreamWrapper.v[i7].x() == i6) {
                                break loop0;
                            }
                        }
                        i5++;
                    }
                    Util.Y(0, i5, arrayList);
                    HlsMediaChunk hlsMediaChunk = (HlsMediaChunk) arrayList.get(0);
                    Format format2 = hlsMediaChunk.f7858d;
                    if (!format2.equals(hlsSampleStreamWrapper.G)) {
                        hlsSampleStreamWrapper.f7049k.a(hlsSampleStreamWrapper.f7040b, format2, hlsMediaChunk.f7859e, hlsMediaChunk.f7860f, hlsMediaChunk.f7861g);
                    }
                    hlsSampleStreamWrapper.G = format2;
                }
                if (arrayList.isEmpty() || ((HlsMediaChunk) arrayList.get(0)).K) {
                    int iY = hlsSampleStreamWrapper.v[i3].y(formatHolder, decoderInputBuffer, i2, hlsSampleStreamWrapper.C0);
                    if (iY == -5) {
                        Format formatE = formatHolder.f6254b;
                        formatE.getClass();
                        if (i3 == hlsSampleStreamWrapper.B) {
                            int iB = Ints.b(hlsSampleStreamWrapper.v[i3].x());
                            while (i4 < arrayList.size() && ((HlsMediaChunk) arrayList.get(i4)).f7002k != iB) {
                                i4++;
                            }
                            if (i4 < arrayList.size()) {
                                format = ((HlsMediaChunk) arrayList.get(i4)).f7858d;
                            } else {
                                format = hlsSampleStreamWrapper.F;
                                format.getClass();
                            }
                            formatE = formatE.e(format);
                        }
                        formatHolder.f6254b = formatE;
                    }
                    return iY;
                }
            }
        }
        return -3;
    }
}
