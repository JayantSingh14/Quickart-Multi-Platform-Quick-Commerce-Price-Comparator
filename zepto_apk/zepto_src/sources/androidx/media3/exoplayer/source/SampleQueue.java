package androidx.media3.exoplayer.source;

import android.util.SparseArray;
import androidx.media3.common.DataReader;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.source.SampleDataQueue;
import androidx.media3.exoplayer.upstream.Allocation;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.extractor.TrackOutput;
import java.io.EOFException;

@UnstableApi
/* loaded from: classes3.dex */
public class SampleQueue implements TrackOutput {
    public Format A;
    public Format B;
    public long C;
    public boolean E;
    public long F;
    public boolean G;

    /* renamed from: a, reason: collision with root package name */
    public final SampleDataQueue f7692a;

    /* renamed from: d, reason: collision with root package name */
    public final DrmSessionManager f7695d;

    /* renamed from: e, reason: collision with root package name */
    public final DrmSessionEventListener.EventDispatcher f7696e;

    /* renamed from: f, reason: collision with root package name */
    public Object f7697f;

    /* renamed from: g, reason: collision with root package name */
    public Format f7698g;

    /* renamed from: h, reason: collision with root package name */
    public DrmSession f7699h;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean w;
    public boolean z;

    /* renamed from: b, reason: collision with root package name */
    public final SampleExtrasHolder f7693b = new SampleExtrasHolder();

    /* renamed from: i, reason: collision with root package name */
    public int f7700i = 1000;

    /* renamed from: j, reason: collision with root package name */
    public long[] f7701j = new long[1000];

    /* renamed from: k, reason: collision with root package name */
    public long[] f7702k = new long[1000];
    public long[] n = new long[1000];

    /* renamed from: m, reason: collision with root package name */
    public int[] f7704m = new int[1000];

    /* renamed from: l, reason: collision with root package name */
    public int[] f7703l = new int[1000];
    public TrackOutput.CryptoData[] o = new TrackOutput.CryptoData[1000];

    /* renamed from: c, reason: collision with root package name */
    public final SpannedData f7694c = new SpannedData(new l(0));
    public long t = Long.MIN_VALUE;
    public long u = Long.MIN_VALUE;
    public long v = Long.MIN_VALUE;
    public boolean y = true;
    public boolean x = true;
    public boolean D = true;

    public static final class SampleExtrasHolder {

        /* renamed from: a, reason: collision with root package name */
        public int f7705a;

        /* renamed from: b, reason: collision with root package name */
        public long f7706b;

        /* renamed from: c, reason: collision with root package name */
        public TrackOutput.CryptoData f7707c;
    }

    public static final class SharedSampleMetadata {

        /* renamed from: a, reason: collision with root package name */
        public final Format f7708a;

        /* renamed from: b, reason: collision with root package name */
        public final DrmSessionManager.DrmSessionReference f7709b;

        public SharedSampleMetadata(Format format, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.f7708a = format;
            this.f7709b = drmSessionReference;
        }
    }

    public interface UpstreamFormatChangedListener {
        void a();
    }

    public SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f7695d = drmSessionManager;
        this.f7696e = eventDispatcher;
        this.f7692a = new SampleDataQueue(allocator);
    }

    public final synchronized boolean A(int i2) {
        synchronized (this) {
            this.s = 0;
            SampleDataQueue sampleDataQueue = this.f7692a;
            sampleDataQueue.f7685e = sampleDataQueue.f7684d;
        }
        int i3 = this.q;
        if (i2 >= i3 && i2 <= this.p + i3) {
            this.t = Long.MIN_VALUE;
            this.s = i2 - i3;
            return true;
        }
        return false;
    }

    /* JADX WARN: Finally extract failed */
    public final synchronized boolean B(long j2, boolean z) throws Throwable {
        Throwable th;
        SampleQueue sampleQueue;
        long j3;
        int iM;
        try {
            synchronized (this) {
                try {
                    try {
                        this.s = 0;
                        SampleDataQueue sampleDataQueue = this.f7692a;
                        sampleDataQueue.f7685e = sampleDataQueue.f7684d;
                        int iQ = q(0);
                        int i2 = this.s;
                        int i3 = this.p;
                        if (!(i2 != i3) || j2 < this.n[iQ] || (j2 > this.v && !z)) {
                            return false;
                        }
                        if (this.D) {
                            iM = i3 - i2;
                            int i4 = 0;
                            while (true) {
                                if (i4 < iM) {
                                    try {
                                        if (this.n[iQ] >= j2) {
                                            iM = i4;
                                            break;
                                        }
                                        iQ++;
                                        if (iQ == this.f7700i) {
                                            iQ = 0;
                                        }
                                        i4++;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        throw th;
                                    }
                                } else if (!z) {
                                    iM = -1;
                                }
                            }
                            sampleQueue = this;
                            j3 = j2;
                        } else {
                            sampleQueue = this;
                            j3 = j2;
                            iM = sampleQueue.m(iQ, i3 - i2, j3, true);
                        }
                        if (iM == -1) {
                            return false;
                        }
                        sampleQueue.t = j3;
                        sampleQueue.s += iM;
                        return true;
                    } catch (Throwable th3) {
                        th = th3;
                        while (true) {
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    th = th;
                    throw th;
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void C(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 < 0) goto Le
            int r0 = r2.s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            int r1 = r2.p     // Catch: java.lang.Throwable -> Lc
            if (r0 > r1) goto Le
            r0 = 1
            goto Lf
        Lc:
            r3 = move-exception
            goto L19
        Le:
            r0 = 0
        Lf:
            androidx.media3.common.util.Assertions.a(r0)     // Catch: java.lang.Throwable -> Lc
            int r0 = r2.s     // Catch: java.lang.Throwable -> Lc
            int r0 = r0 + r3
            r2.s = r0     // Catch: java.lang.Throwable -> Lc
            monitor-exit(r2)
            return
        L19:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.C(int):void");
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final void a(ParsableByteArray parsableByteArray, int i2, int i3) {
        while (true) {
            SampleDataQueue sampleDataQueue = this.f7692a;
            if (i2 <= 0) {
                sampleDataQueue.getClass();
                return;
            }
            int iB = sampleDataQueue.b(i2);
            SampleDataQueue.AllocationNode allocationNode = sampleDataQueue.f7686f;
            Allocation allocation = allocationNode.f7690c;
            parsableByteArray.h(((int) (sampleDataQueue.f7687g - allocationNode.f7688a)) + allocation.f8060b, allocation.f8059a, iB);
            i2 -= iB;
            long j2 = sampleDataQueue.f7687g + iB;
            sampleDataQueue.f7687g = j2;
            SampleDataQueue.AllocationNode allocationNode2 = sampleDataQueue.f7686f;
            if (j2 == allocationNode2.f7689b) {
                sampleDataQueue.f7686f = allocationNode2.f7691d;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:4:0x000a, B:8:0x0016, B:13:0x0026, B:15:0x003d, B:19:0x0055, B:18:0x0053), top: B:29:0x000a }] */
    /* JADX WARN: Type inference failed for: r5v23, types: [androidx.media3.exoplayer.source.SampleQueue$UpstreamFormatChangedListener, java.lang.Object] */
    @Override // androidx.media3.extractor.TrackOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.media3.common.Format r5) {
        /*
            r4 = this;
            androidx.media3.common.Format r0 = r4.n(r5)
            r1 = 0
            r4.z = r1
            r4.A = r5
            monitor-enter(r4)
            r4.y = r1     // Catch: java.lang.Throwable -> L51
            androidx.media3.common.Format r5 = r4.B     // Catch: java.lang.Throwable -> L51
            boolean r5 = androidx.media3.common.util.Util.a(r0, r5)     // Catch: java.lang.Throwable -> L51
            if (r5 == 0) goto L16
            monitor-exit(r4)
            goto L68
        L16:
            androidx.media3.exoplayer.source.SpannedData r5 = r4.f7694c     // Catch: java.lang.Throwable -> L51
            android.util.SparseArray r5 = r5.f7761b     // Catch: java.lang.Throwable -> L51
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L51
            r2 = 1
            if (r5 != 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            if (r5 != 0) goto L53
            androidx.media3.exoplayer.source.SpannedData r5 = r4.f7694c     // Catch: java.lang.Throwable -> L51
            android.util.SparseArray r5 = r5.f7761b     // Catch: java.lang.Throwable -> L51
            int r3 = r5.size()     // Catch: java.lang.Throwable -> L51
            int r3 = r3 - r2
            java.lang.Object r5 = r5.valueAt(r3)     // Catch: java.lang.Throwable -> L51
            androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata r5 = (androidx.media3.exoplayer.source.SampleQueue.SharedSampleMetadata) r5     // Catch: java.lang.Throwable -> L51
            androidx.media3.common.Format r5 = r5.f7708a     // Catch: java.lang.Throwable -> L51
            boolean r5 = r5.equals(r0)     // Catch: java.lang.Throwable -> L51
            if (r5 == 0) goto L53
            androidx.media3.exoplayer.source.SpannedData r5 = r4.f7694c     // Catch: java.lang.Throwable -> L51
            android.util.SparseArray r5 = r5.f7761b     // Catch: java.lang.Throwable -> L51
            int r0 = r5.size()     // Catch: java.lang.Throwable -> L51
            int r0 = r0 - r2
            java.lang.Object r5 = r5.valueAt(r0)     // Catch: java.lang.Throwable -> L51
            androidx.media3.exoplayer.source.SampleQueue$SharedSampleMetadata r5 = (androidx.media3.exoplayer.source.SampleQueue.SharedSampleMetadata) r5     // Catch: java.lang.Throwable -> L51
            androidx.media3.common.Format r5 = r5.f7708a     // Catch: java.lang.Throwable -> L51
            r4.B = r5     // Catch: java.lang.Throwable -> L51
            goto L55
        L51:
            r5 = move-exception
            goto L72
        L53:
            r4.B = r0     // Catch: java.lang.Throwable -> L51
        L55:
            boolean r5 = r4.D     // Catch: java.lang.Throwable -> L51
            androidx.media3.common.Format r0 = r4.B     // Catch: java.lang.Throwable -> L51
            java.lang.String r3 = r0.f5225m     // Catch: java.lang.Throwable -> L51
            java.lang.String r0 = r0.f5222j     // Catch: java.lang.Throwable -> L51
            boolean r0 = androidx.media3.common.MimeTypes.a(r3, r0)     // Catch: java.lang.Throwable -> L51
            r5 = r5 & r0
            r4.D = r5     // Catch: java.lang.Throwable -> L51
            r4.E = r1     // Catch: java.lang.Throwable -> L51
            monitor-exit(r4)
            r1 = r2
        L68:
            java.lang.Object r5 = r4.f7697f
            if (r5 == 0) goto L71
            if (r1 == 0) goto L71
            r5.a()
        L71:
            return
        L72:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L51
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.b(androidx.media3.common.Format):void");
    }

    @Override // androidx.media3.extractor.TrackOutput
    public final int d(DataReader dataReader, int i2, boolean z) throws EOFException {
        SampleDataQueue sampleDataQueue = this.f7692a;
        int iB = sampleDataQueue.b(i2);
        SampleDataQueue.AllocationNode allocationNode = sampleDataQueue.f7686f;
        Allocation allocation = allocationNode.f7690c;
        int i3 = dataReader.read(allocation.f8059a, ((int) (sampleDataQueue.f7687g - allocationNode.f7688a)) + allocation.f8060b, iB);
        if (i3 == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        long j2 = sampleDataQueue.f7687g + i3;
        sampleDataQueue.f7687g = j2;
        SampleDataQueue.AllocationNode allocationNode2 = sampleDataQueue.f7686f;
        if (j2 == allocationNode2.f7689b) {
            sampleDataQueue.f7686f = allocationNode2.f7691d;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013b A[Catch: all -> 0x00de, TryCatch #1 {all -> 0x00de, blocks: (B:69:0x00c0, B:71:0x00c4, B:75:0x00da, B:78:0x00e1, B:82:0x00e9, B:87:0x0122, B:110:0x0197, B:112:0x01a0, B:89:0x013b, B:91:0x0144, B:93:0x014d, B:95:0x015f, B:99:0x0168, B:100:0x016d, B:102:0x0173, B:106:0x0181, B:108:0x0186, B:109:0x0194, B:92:0x014b), top: B:118:0x00c0 }] */
    @Override // androidx.media3.extractor.TrackOutput
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(long r17, int r19, int r20, int r21, androidx.media3.extractor.TrackOutput.CryptoData r22) {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.f(long, int, int, int, androidx.media3.extractor.TrackOutput$CryptoData):void");
    }

    public final long g(int i2) {
        this.u = Math.max(this.u, o(i2));
        this.p -= i2;
        int i3 = this.q + i2;
        this.q = i3;
        int i4 = this.r + i2;
        this.r = i4;
        int i5 = this.f7700i;
        if (i4 >= i5) {
            this.r = i4 - i5;
        }
        int i6 = this.s - i2;
        this.s = i6;
        int i7 = 0;
        if (i6 < 0) {
            this.s = 0;
        }
        while (true) {
            SpannedData spannedData = this.f7694c;
            SparseArray sparseArray = spannedData.f7761b;
            if (i7 >= sparseArray.size() - 1) {
                break;
            }
            int i8 = i7 + 1;
            if (i3 < sparseArray.keyAt(i8)) {
                break;
            }
            spannedData.f7762c.accept(sparseArray.valueAt(i7));
            sparseArray.removeAt(i7);
            int i9 = spannedData.f7760a;
            if (i9 > 0) {
                spannedData.f7760a = i9 - 1;
            }
            i7 = i8;
        }
        if (this.p != 0) {
            return this.f7702k[this.r];
        }
        int i10 = this.r;
        if (i10 == 0) {
            i10 = this.f7700i;
        }
        return this.f7702k[i10 - 1] + this.f7703l[r7];
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(long r12, boolean r14, boolean r15) throws java.lang.Throwable {
        /*
            r11 = this;
            androidx.media3.exoplayer.source.SampleDataQueue r0 = r11.f7692a
            monitor-enter(r11)
            int r1 = r11.p     // Catch: java.lang.Throwable -> L38
            r2 = -1
            if (r1 == 0) goto L13
            long[] r4 = r11.n     // Catch: java.lang.Throwable -> L38
            int r6 = r11.r     // Catch: java.lang.Throwable -> L38
            r7 = r4[r6]     // Catch: java.lang.Throwable -> L38
            int r4 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r4 >= 0) goto L15
        L13:
            r5 = r11
            goto L3b
        L15:
            if (r15 == 0) goto L1d
            int r15 = r11.s     // Catch: java.lang.Throwable -> L22
            if (r15 == r1) goto L1d
            int r1 = r15 + 1
        L1d:
            r5 = r11
            r8 = r12
            r10 = r14
            r7 = r1
            goto L26
        L22:
            r0 = move-exception
            r12 = r0
            r5 = r11
            goto L40
        L26:
            int r12 = r5.m(r6, r7, r8, r10)     // Catch: java.lang.Throwable -> L35
            r13 = -1
            if (r12 != r13) goto L2f
            monitor-exit(r11)
            goto L3c
        L2f:
            long r2 = r11.g(r12)     // Catch: java.lang.Throwable -> L35
            monitor-exit(r11)
            goto L3c
        L35:
            r0 = move-exception
        L36:
            r12 = r0
            goto L40
        L38:
            r0 = move-exception
            r5 = r11
            goto L36
        L3b:
            monitor-exit(r11)
        L3c:
            r0.a(r2)
            return
        L40:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L35
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.SampleQueue.h(long, boolean, boolean):void");
    }

    public final void i() {
        long jG;
        SampleDataQueue sampleDataQueue = this.f7692a;
        synchronized (this) {
            int i2 = this.p;
            jG = i2 == 0 ? -1L : g(i2);
        }
        sampleDataQueue.a(jG);
    }

    public final void j() {
        long jG;
        SampleDataQueue sampleDataQueue = this.f7692a;
        synchronized (this) {
            int i2 = this.s;
            jG = i2 == 0 ? -1L : g(i2);
        }
        sampleDataQueue.a(jG);
    }

    public final long k(int i2) {
        int i3 = this.q;
        int i4 = this.p;
        int i5 = (i3 + i4) - i2;
        boolean z = false;
        Assertions.a(i5 >= 0 && i5 <= i4 - this.s);
        int i6 = this.p - i5;
        this.p = i6;
        this.v = Math.max(this.u, o(i6));
        if (i5 == 0 && this.w) {
            z = true;
        }
        this.w = z;
        SpannedData spannedData = this.f7694c;
        SparseArray sparseArray = spannedData.f7761b;
        for (int size = sparseArray.size() - 1; size >= 0 && i2 < sparseArray.keyAt(size); size--) {
            spannedData.f7762c.accept(sparseArray.valueAt(size));
            sparseArray.removeAt(size);
        }
        spannedData.f7760a = sparseArray.size() > 0 ? Math.min(spannedData.f7760a, sparseArray.size() - 1) : -1;
        int i7 = this.p;
        if (i7 == 0) {
            return 0L;
        }
        return this.f7702k[q(i7 - 1)] + this.f7703l[r9];
    }

    public final void l(int i2) {
        long jK = k(i2);
        SampleDataQueue sampleDataQueue = this.f7692a;
        Assertions.a(jK <= sampleDataQueue.f7687g);
        sampleDataQueue.f7687g = jK;
        Allocator allocator = sampleDataQueue.f7681a;
        int i3 = sampleDataQueue.f7682b;
        if (jK != 0) {
            SampleDataQueue.AllocationNode allocationNode = sampleDataQueue.f7684d;
            if (jK != allocationNode.f7688a) {
                while (sampleDataQueue.f7687g > allocationNode.f7689b) {
                    allocationNode = allocationNode.f7691d;
                }
                SampleDataQueue.AllocationNode allocationNode2 = allocationNode.f7691d;
                allocationNode2.getClass();
                if (allocationNode2.f7690c != null) {
                    allocator.a(allocationNode2);
                    allocationNode2.f7690c = null;
                    allocationNode2.f7691d = null;
                }
                SampleDataQueue.AllocationNode allocationNode3 = new SampleDataQueue.AllocationNode(allocationNode.f7689b, i3);
                allocationNode.f7691d = allocationNode3;
                if (sampleDataQueue.f7687g == allocationNode.f7689b) {
                    allocationNode = allocationNode3;
                }
                sampleDataQueue.f7686f = allocationNode;
                if (sampleDataQueue.f7685e == allocationNode2) {
                    sampleDataQueue.f7685e = allocationNode3;
                    return;
                }
                return;
            }
        }
        SampleDataQueue.AllocationNode allocationNode4 = sampleDataQueue.f7684d;
        if (allocationNode4.f7690c != null) {
            allocator.a(allocationNode4);
            allocationNode4.f7690c = null;
            allocationNode4.f7691d = null;
        }
        SampleDataQueue.AllocationNode allocationNode5 = new SampleDataQueue.AllocationNode(sampleDataQueue.f7687g, i3);
        sampleDataQueue.f7684d = allocationNode5;
        sampleDataQueue.f7685e = allocationNode5;
        sampleDataQueue.f7686f = allocationNode5;
    }

    public final int m(int i2, int i3, long j2, boolean z) {
        int i4 = -1;
        for (int i5 = 0; i5 < i3; i5++) {
            long j3 = this.n[i2];
            if (j3 > j2) {
                break;
            }
            if (!z || (this.f7704m[i2] & 1) != 0) {
                if (j3 == j2) {
                    return i5;
                }
                i4 = i5;
            }
            i2++;
            if (i2 == this.f7700i) {
                i2 = 0;
            }
        }
        return i4;
    }

    public Format n(Format format) {
        if (this.F == 0 || format.r == Long.MAX_VALUE) {
            return format;
        }
        Format.Builder builderA = format.a();
        builderA.q = format.r + this.F;
        return new Format(builderA);
    }

    public final long o(int i2) {
        long jMax = Long.MIN_VALUE;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int iQ = q(i2 - 1);
        for (int i3 = 0; i3 < i2; i3++) {
            jMax = Math.max(jMax, this.n[iQ]);
            if ((this.f7704m[iQ] & 1) != 0) {
                return jMax;
            }
            iQ--;
            if (iQ == -1) {
                iQ = this.f7700i - 1;
            }
        }
        return jMax;
    }

    public final int p() {
        return this.q + this.s;
    }

    public final int q(int i2) {
        int i3 = this.r + i2;
        int i4 = this.f7700i;
        return i3 < i4 ? i3 : i3 - i4;
    }

    public final synchronized int r(long j2, boolean z) throws Throwable {
        try {
            try {
                int iQ = q(this.s);
                int i2 = this.s;
                int i3 = this.p;
                if (!(i2 != i3) || j2 < this.n[iQ]) {
                    return 0;
                }
                if (j2 > this.v && z) {
                    return i3 - i2;
                }
                int iM = m(iQ, i3 - i2, j2, true);
                if (iM == -1) {
                    return 0;
                }
                return iM;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized Format s() {
        return this.y ? null : this.B;
    }

    public final synchronized boolean t(boolean z) {
        Format format;
        boolean z2 = false;
        if (this.s != this.p) {
            if (((SharedSampleMetadata) this.f7694c.a(p())).f7708a != this.f7698g) {
                return true;
            }
            return u(q(this.s));
        }
        if (z || this.w || ((format = this.B) != null && format != this.f7698g)) {
            z2 = true;
        }
        return z2;
    }

    public final boolean u(int i2) {
        DrmSession drmSession = this.f7699h;
        if (drmSession == null || drmSession.getState() == 4) {
            return true;
        }
        return (this.f7704m[i2] & 1073741824) == 0 && this.f7699h.b();
    }

    public final void v() throws DrmSession.DrmSessionException {
        DrmSession drmSession = this.f7699h;
        if (drmSession == null || drmSession.getState() != 1) {
            return;
        }
        DrmSession.DrmSessionException error = this.f7699h.getError();
        error.getClass();
        throw error;
    }

    public final void w(Format format, FormatHolder formatHolder) {
        Format format2;
        Format format3 = this.f7698g;
        boolean z = format3 == null;
        DrmInitData drmInitData = format3 == null ? null : format3.q;
        this.f7698g = format;
        DrmInitData drmInitData2 = format.q;
        DrmSessionManager drmSessionManager = this.f7695d;
        if (drmSessionManager != null) {
            int iC = drmSessionManager.c(format);
            Format.Builder builderA = format.a();
            builderA.I = iC;
            format2 = new Format(builderA);
        } else {
            format2 = format;
        }
        formatHolder.f6254b = format2;
        formatHolder.f6253a = this.f7699h;
        if (drmSessionManager == null) {
            return;
        }
        if (z || !Util.a(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f7699h;
            DrmSessionEventListener.EventDispatcher eventDispatcher = this.f7696e;
            DrmSession drmSessionB = drmSessionManager.b(eventDispatcher, format);
            this.f7699h = drmSessionB;
            formatHolder.f6253a = drmSessionB;
            if (drmSession != null) {
                drmSession.f(eventDispatcher);
            }
        }
    }

    public final synchronized long x() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return this.s != this.p ? this.f7701j[q(this.s)] : this.C;
    }

    public final int y(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2, boolean z) {
        int i3;
        boolean z2 = (i2 & 2) != 0;
        SampleExtrasHolder sampleExtrasHolder = this.f7693b;
        synchronized (this) {
            try {
                decoderInputBuffer.f6072e = false;
                i3 = -3;
                if (this.s != this.p) {
                    Format format = ((SharedSampleMetadata) this.f7694c.a(p())).f7708a;
                    if (!z2 && format == this.f7698g) {
                        int iQ = q(this.s);
                        if (u(iQ)) {
                            decoderInputBuffer.f6056a = this.f7704m[iQ];
                            if (this.s == this.p - 1 && (z || this.w)) {
                                decoderInputBuffer.e(536870912);
                            }
                            decoderInputBuffer.f6073f = this.n[iQ];
                            sampleExtrasHolder.f7705a = this.f7703l[iQ];
                            sampleExtrasHolder.f7706b = this.f7702k[iQ];
                            sampleExtrasHolder.f7707c = this.o[iQ];
                            i3 = -4;
                        } else {
                            decoderInputBuffer.f6072e = true;
                        }
                    }
                    w(format, formatHolder);
                    i3 = -5;
                } else {
                    if (!z && !this.w) {
                        Format format2 = this.B;
                        if (format2 == null || (!z2 && format2 == this.f7698g)) {
                        }
                        w(format2, formatHolder);
                        i3 = -5;
                    }
                    decoderInputBuffer.f6056a = 4;
                    decoderInputBuffer.f6073f = Long.MIN_VALUE;
                    i3 = -4;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (i3 == -4 && !decoderInputBuffer.g(4)) {
            boolean z3 = (i2 & 1) != 0;
            if ((i2 & 4) == 0) {
                if (z3) {
                    SampleDataQueue sampleDataQueue = this.f7692a;
                    SampleDataQueue.e(sampleDataQueue.f7685e, decoderInputBuffer, this.f7693b, sampleDataQueue.f7683c);
                } else {
                    SampleDataQueue sampleDataQueue2 = this.f7692a;
                    sampleDataQueue2.f7685e = SampleDataQueue.e(sampleDataQueue2.f7685e, decoderInputBuffer, this.f7693b, sampleDataQueue2.f7683c);
                }
            }
            if (!z3) {
                this.s++;
            }
        }
        return i3;
    }

    public final void z(boolean z) {
        SpannedData spannedData;
        SparseArray sparseArray;
        SampleDataQueue sampleDataQueue = this.f7692a;
        SampleDataQueue.AllocationNode allocationNode = sampleDataQueue.f7684d;
        Allocation allocation = allocationNode.f7690c;
        Allocator allocator = sampleDataQueue.f7681a;
        if (allocation != null) {
            allocator.a(allocationNode);
            allocationNode.f7690c = null;
            allocationNode.f7691d = null;
        }
        SampleDataQueue.AllocationNode allocationNode2 = sampleDataQueue.f7684d;
        int i2 = 0;
        Assertions.g(allocationNode2.f7690c == null);
        allocationNode2.f7688a = 0L;
        allocationNode2.f7689b = sampleDataQueue.f7682b;
        SampleDataQueue.AllocationNode allocationNode3 = sampleDataQueue.f7684d;
        sampleDataQueue.f7685e = allocationNode3;
        sampleDataQueue.f7686f = allocationNode3;
        sampleDataQueue.f7687g = 0L;
        allocator.d();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.x = true;
        this.t = Long.MIN_VALUE;
        this.u = Long.MIN_VALUE;
        this.v = Long.MIN_VALUE;
        this.w = false;
        while (true) {
            spannedData = this.f7694c;
            sparseArray = spannedData.f7761b;
            if (i2 >= sparseArray.size()) {
                break;
            }
            spannedData.f7762c.accept(sparseArray.valueAt(i2));
            i2++;
        }
        spannedData.f7760a = -1;
        sparseArray.clear();
        if (z) {
            this.A = null;
            this.B = null;
            this.y = true;
            this.D = true;
        }
    }
}
