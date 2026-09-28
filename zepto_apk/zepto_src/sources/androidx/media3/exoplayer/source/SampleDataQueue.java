package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.source.SampleQueue;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes3.dex */
class SampleDataQueue {

    /* renamed from: a, reason: collision with root package name */
    public final Allocator f7681a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7682b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f7683c;

    /* renamed from: d, reason: collision with root package name */
    public AllocationNode f7684d;

    /* renamed from: e, reason: collision with root package name */
    public AllocationNode f7685e;

    /* renamed from: f, reason: collision with root package name */
    public AllocationNode f7686f;

    /* renamed from: g, reason: collision with root package name */
    public long f7687g;

    public static final class AllocationNode implements Allocator.AllocationNode {

        /* renamed from: a, reason: collision with root package name */
        public long f7688a;

        /* renamed from: b, reason: collision with root package name */
        public long f7689b;

        /* renamed from: c, reason: collision with root package name */
        public Allocation f7690c;

        /* renamed from: d, reason: collision with root package name */
        public AllocationNode f7691d;

        public AllocationNode(long j2, int i2) {
            Assertions.g(this.f7690c == null);
            this.f7688a = j2;
            this.f7689b = j2 + i2;
        }

        @Override // androidx.media3.exoplayer.upstream.Allocator.AllocationNode
        public final Allocation a() {
            Allocation allocation = this.f7690c;
            allocation.getClass();
            return allocation;
        }

        @Override // androidx.media3.exoplayer.upstream.Allocator.AllocationNode
        public final Allocator.AllocationNode next() {
            AllocationNode allocationNode = this.f7691d;
            if (allocationNode == null || allocationNode.f7690c == null) {
                return null;
            }
            return allocationNode;
        }
    }

    public SampleDataQueue(Allocator allocator) {
        this.f7681a = allocator;
        int iE = allocator.e();
        this.f7682b = iE;
        this.f7683c = new ParsableByteArray(32);
        AllocationNode allocationNode = new AllocationNode(0L, iE);
        this.f7684d = allocationNode;
        this.f7685e = allocationNode;
        this.f7686f = allocationNode;
    }

    public static AllocationNode c(AllocationNode allocationNode, long j2, ByteBuffer byteBuffer, int i2) {
        while (j2 >= allocationNode.f7689b) {
            allocationNode = allocationNode.f7691d;
        }
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (allocationNode.f7689b - j2));
            Allocation allocation = allocationNode.f7690c;
            byteBuffer.put(allocation.f8059a, ((int) (j2 - allocationNode.f7688a)) + allocation.f8060b, iMin);
            i2 -= iMin;
            j2 += iMin;
            if (j2 == allocationNode.f7689b) {
                allocationNode = allocationNode.f7691d;
            }
        }
        return allocationNode;
    }

    public static AllocationNode d(AllocationNode allocationNode, long j2, byte[] bArr, int i2) {
        while (j2 >= allocationNode.f7689b) {
            allocationNode = allocationNode.f7691d;
        }
        int i3 = i2;
        while (i3 > 0) {
            int iMin = Math.min(i3, (int) (allocationNode.f7689b - j2));
            Allocation allocation = allocationNode.f7690c;
            System.arraycopy(allocation.f8059a, ((int) (j2 - allocationNode.f7688a)) + allocation.f8060b, bArr, i2 - i3, iMin);
            i3 -= iMin;
            j2 += iMin;
            if (j2 == allocationNode.f7689b) {
                allocationNode = allocationNode.f7691d;
            }
        }
        return allocationNode;
    }

    public static AllocationNode e(AllocationNode allocationNode, DecoderInputBuffer decoderInputBuffer, SampleQueue.SampleExtrasHolder sampleExtrasHolder, ParsableByteArray parsableByteArray) {
        AllocationNode allocationNodeD;
        int iD;
        if (decoderInputBuffer.g(1073741824)) {
            long j2 = sampleExtrasHolder.f7706b;
            parsableByteArray.G(1);
            AllocationNode allocationNodeD2 = d(allocationNode, j2, parsableByteArray.f5723a, 1);
            long j3 = j2 + 1;
            byte b2 = parsableByteArray.f5723a[0];
            boolean z = (b2 & 128) != 0;
            int i2 = b2 & 127;
            CryptoInfo cryptoInfo = decoderInputBuffer.f6070c;
            byte[] bArr = cryptoInfo.f6057a;
            if (bArr == null) {
                cryptoInfo.f6057a = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            allocationNodeD = d(allocationNodeD2, j3, cryptoInfo.f6057a, i2);
            long j4 = j3 + i2;
            if (z) {
                parsableByteArray.G(2);
                allocationNodeD = d(allocationNodeD, j4, parsableByteArray.f5723a, 2);
                j4 += 2;
                iD = parsableByteArray.D();
            } else {
                iD = 1;
            }
            int[] iArr = cryptoInfo.f6060d;
            if (iArr == null || iArr.length < iD) {
                iArr = new int[iD];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = cryptoInfo.f6061e;
            if (iArr3 == null || iArr3.length < iD) {
                iArr3 = new int[iD];
            }
            int[] iArr4 = iArr3;
            if (z) {
                int i3 = iD * 6;
                parsableByteArray.G(i3);
                allocationNodeD = d(allocationNodeD, j4, parsableByteArray.f5723a, i3);
                j4 += i3;
                parsableByteArray.J(0);
                for (int i4 = 0; i4 < iD; i4++) {
                    iArr2[i4] = parsableByteArray.D();
                    iArr4[i4] = parsableByteArray.B();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = sampleExtrasHolder.f7705a - ((int) (j4 - sampleExtrasHolder.f7706b));
            }
            TrackOutput.CryptoData cryptoData = sampleExtrasHolder.f7707c;
            int i5 = Util.f5744a;
            cryptoInfo.a(iD, iArr2, iArr4, cryptoData.f8615b, cryptoInfo.f6057a, cryptoData.f8614a, cryptoData.f8616c, cryptoData.f8617d);
            long j5 = sampleExtrasHolder.f7706b;
            int i6 = (int) (j4 - j5);
            sampleExtrasHolder.f7706b = j5 + i6;
            sampleExtrasHolder.f7705a -= i6;
        } else {
            allocationNodeD = allocationNode;
        }
        if (!decoderInputBuffer.g(268435456)) {
            decoderInputBuffer.l(sampleExtrasHolder.f7705a);
            return c(allocationNodeD, sampleExtrasHolder.f7706b, decoderInputBuffer.f6071d, sampleExtrasHolder.f7705a);
        }
        parsableByteArray.G(4);
        AllocationNode allocationNodeD3 = d(allocationNodeD, sampleExtrasHolder.f7706b, parsableByteArray.f5723a, 4);
        int iB = parsableByteArray.B();
        sampleExtrasHolder.f7706b += 4;
        sampleExtrasHolder.f7705a -= 4;
        decoderInputBuffer.l(iB);
        AllocationNode allocationNodeC = c(allocationNodeD3, sampleExtrasHolder.f7706b, decoderInputBuffer.f6071d, iB);
        sampleExtrasHolder.f7706b += iB;
        int i7 = sampleExtrasHolder.f7705a - iB;
        sampleExtrasHolder.f7705a = i7;
        ByteBuffer byteBuffer = decoderInputBuffer.f6074g;
        if (byteBuffer == null || byteBuffer.capacity() < i7) {
            decoderInputBuffer.f6074g = ByteBuffer.allocate(i7);
        } else {
            decoderInputBuffer.f6074g.clear();
        }
        return c(allocationNodeC, sampleExtrasHolder.f7706b, decoderInputBuffer.f6074g, sampleExtrasHolder.f7705a);
    }

    public final void a(long j2) {
        AllocationNode allocationNode;
        if (j2 == -1) {
            return;
        }
        while (true) {
            allocationNode = this.f7684d;
            if (j2 < allocationNode.f7689b) {
                break;
            }
            this.f7681a.c(allocationNode.f7690c);
            AllocationNode allocationNode2 = this.f7684d;
            allocationNode2.f7690c = null;
            AllocationNode allocationNode3 = allocationNode2.f7691d;
            allocationNode2.f7691d = null;
            this.f7684d = allocationNode3;
        }
        if (this.f7685e.f7688a < allocationNode.f7688a) {
            this.f7685e = allocationNode;
        }
    }

    public final int b(int i2) {
        AllocationNode allocationNode = this.f7686f;
        if (allocationNode.f7690c == null) {
            Allocation allocationB = this.f7681a.b();
            AllocationNode allocationNode2 = new AllocationNode(this.f7686f.f7689b, this.f7682b);
            allocationNode.f7690c = allocationB;
            allocationNode.f7691d = allocationNode2;
        }
        return Math.min(i2, (int) (this.f7686f.f7689b - this.f7687g));
    }
}
