package androidx.media3.extractor.mp4;

import android.support.v4.media.b;
import android.util.SparseArray;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.exoplayer.dash.PlayerEmsgHandler;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.metadata.emsg.EventMessageEncoder;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.SubtitleTranscodingExtractorOutput;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public class FragmentedMp4Extractor implements Extractor {
    public static final byte[] K = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    public static final Format L;
    public long A;
    public TrackBundle B;
    public int C;
    public int D;
    public int E;
    public boolean F;
    public ExtractorOutput G;
    public TrackOutput[] H;
    public TrackOutput[] I;
    public boolean J;

    /* renamed from: a, reason: collision with root package name */
    public final SubtitleParser.Factory f9005a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9006b;

    /* renamed from: c, reason: collision with root package name */
    public final Track f9007c;

    /* renamed from: d, reason: collision with root package name */
    public final List f9008d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f9009e;

    /* renamed from: f, reason: collision with root package name */
    public final ParsableByteArray f9010f;

    /* renamed from: g, reason: collision with root package name */
    public final ParsableByteArray f9011g;

    /* renamed from: h, reason: collision with root package name */
    public final ParsableByteArray f9012h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f9013i;

    /* renamed from: j, reason: collision with root package name */
    public final ParsableByteArray f9014j;

    /* renamed from: k, reason: collision with root package name */
    public final TimestampAdjuster f9015k;

    /* renamed from: l, reason: collision with root package name */
    public final EventMessageEncoder f9016l;

    /* renamed from: m, reason: collision with root package name */
    public final ParsableByteArray f9017m;
    public final ArrayDeque n;
    public final ArrayDeque o;
    public final PlayerEmsgHandler.PlayerTrackEmsgHandler p;
    public ImmutableList q;
    public int r;
    public int s;
    public long t;
    public int u;
    public ParsableByteArray v;
    public long w;
    public int x;
    public long y;
    public long z;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class MetadataSampleInfo {

        /* renamed from: a, reason: collision with root package name */
        public final long f9018a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9019b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9020c;

        public MetadataSampleInfo(int i2, long j2, boolean z) {
            this.f9018a = j2;
            this.f9019b = z;
            this.f9020c = i2;
        }
    }

    public static final class TrackBundle {

        /* renamed from: a, reason: collision with root package name */
        public final TrackOutput f9021a;

        /* renamed from: d, reason: collision with root package name */
        public TrackSampleTable f9024d;

        /* renamed from: e, reason: collision with root package name */
        public DefaultSampleValues f9025e;

        /* renamed from: f, reason: collision with root package name */
        public int f9026f;

        /* renamed from: g, reason: collision with root package name */
        public int f9027g;

        /* renamed from: h, reason: collision with root package name */
        public int f9028h;

        /* renamed from: i, reason: collision with root package name */
        public int f9029i;

        /* renamed from: l, reason: collision with root package name */
        public boolean f9032l;

        /* renamed from: b, reason: collision with root package name */
        public final TrackFragment f9022b = new TrackFragment();

        /* renamed from: c, reason: collision with root package name */
        public final ParsableByteArray f9023c = new ParsableByteArray();

        /* renamed from: j, reason: collision with root package name */
        public final ParsableByteArray f9030j = new ParsableByteArray(1);

        /* renamed from: k, reason: collision with root package name */
        public final ParsableByteArray f9031k = new ParsableByteArray();

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues) {
            this.f9021a = trackOutput;
            this.f9024d = trackSampleTable;
            this.f9025e = defaultSampleValues;
            this.f9024d = trackSampleTable;
            this.f9025e = defaultSampleValues;
            trackOutput.b(trackSampleTable.f9094a.f9070f);
            d();
        }

        public final TrackEncryptionBox a() {
            if (this.f9032l) {
                TrackFragment trackFragment = this.f9022b;
                DefaultSampleValues defaultSampleValues = trackFragment.f9081a;
                int i2 = Util.f5744a;
                int i3 = defaultSampleValues.f9001a;
                TrackEncryptionBox trackEncryptionBox = trackFragment.f9093m;
                if (trackEncryptionBox == null) {
                    TrackEncryptionBox[] trackEncryptionBoxArr = this.f9024d.f9094a.f9075k;
                    trackEncryptionBox = trackEncryptionBoxArr == null ? null : trackEncryptionBoxArr[i3];
                }
                if (trackEncryptionBox != null && trackEncryptionBox.f9076a) {
                    return trackEncryptionBox;
                }
            }
            return null;
        }

        public final boolean b() {
            this.f9026f++;
            if (!this.f9032l) {
                return false;
            }
            int i2 = this.f9027g + 1;
            this.f9027g = i2;
            int[] iArr = this.f9022b.f9087g;
            int i3 = this.f9028h;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.f9028h = i3 + 1;
            this.f9027g = 0;
            return false;
        }

        public final int c(int i2, int i3) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox trackEncryptionBoxA = a();
            if (trackEncryptionBoxA == null) {
                return 0;
            }
            TrackFragment trackFragment = this.f9022b;
            int length = trackEncryptionBoxA.f9079d;
            if (length != 0) {
                parsableByteArray = trackFragment.n;
            } else {
                int i4 = Util.f5744a;
                byte[] bArr = trackEncryptionBoxA.f9080e;
                int length2 = bArr.length;
                ParsableByteArray parsableByteArray2 = this.f9031k;
                parsableByteArray2.H(length2, bArr);
                length = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean z = trackFragment.f9091k && trackFragment.f9092l[this.f9026f];
            boolean z2 = z || i3 != 0;
            ParsableByteArray parsableByteArray3 = this.f9030j;
            parsableByteArray3.f5723a[0] = (byte) ((z2 ? 128 : 0) | length);
            parsableByteArray3.J(0);
            TrackOutput trackOutput = this.f9021a;
            trackOutput.a(parsableByteArray3, 1, 1);
            trackOutput.a(parsableByteArray, length, 1);
            if (!z2) {
                return length + 1;
            }
            ParsableByteArray parsableByteArray4 = this.f9023c;
            if (!z) {
                parsableByteArray4.G(8);
                byte[] bArr2 = parsableByteArray4.f5723a;
                bArr2[0] = 0;
                bArr2[1] = 1;
                bArr2[2] = (byte) 0;
                bArr2[3] = (byte) (i3 & 255);
                bArr2[4] = (byte) ((i2 >> 24) & 255);
                bArr2[5] = (byte) ((i2 >> 16) & 255);
                bArr2[6] = (byte) ((i2 >> 8) & 255);
                bArr2[7] = (byte) (i2 & 255);
                trackOutput.a(parsableByteArray4, 8, 1);
                return length + 9;
            }
            ParsableByteArray parsableByteArray5 = trackFragment.n;
            int iD = parsableByteArray5.D();
            parsableByteArray5.K(-2);
            int i5 = (iD * 6) + 2;
            if (i3 != 0) {
                parsableByteArray4.G(i5);
                byte[] bArr3 = parsableByteArray4.f5723a;
                parsableByteArray5.h(0, bArr3, i5);
                int i6 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i3;
                bArr3[2] = (byte) ((i6 >> 8) & 255);
                bArr3[3] = (byte) (i6 & 255);
            } else {
                parsableByteArray4 = parsableByteArray5;
            }
            trackOutput.a(parsableByteArray4, i5, 1);
            return length + 1 + i5;
        }

        public final void d() {
            TrackFragment trackFragment = this.f9022b;
            trackFragment.f9084d = 0;
            trackFragment.p = 0L;
            trackFragment.q = false;
            trackFragment.f9091k = false;
            trackFragment.o = false;
            trackFragment.f9093m = null;
            this.f9026f = 0;
            this.f9028h = 0;
            this.f9027g = 0;
            this.f9029i = 0;
            this.f9032l = false;
        }
    }

    static {
        Format.Builder builder = new Format.Builder();
        builder.f5237l = MimeTypes.p("application/x-emsg");
        L = new Format(builder);
    }

    @Deprecated
    public FragmentedMp4Extractor() {
        this(SubtitleParser.Factory.f9179a, 32, null, null, ImmutableList.r(), null);
    }

    public static DrmInitData b(ArrayList arrayList) {
        int size = arrayList.size();
        ArrayList arrayList2 = null;
        for (int i2 = 0; i2 < size; i2++) {
            Atom.LeafAtom leafAtom = (Atom.LeafAtom) arrayList.get(i2);
            if (leafAtom.f8969a == 1886614376) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                byte[] bArr = leafAtom.f8973b.f5723a;
                PsshAtomUtil.PsshAtom psshAtomB = PsshAtomUtil.b(bArr);
                UUID uuid = psshAtomB == null ? null : psshAtomB.f9054a;
                if (uuid == null) {
                    Log.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList2.add(new DrmInitData.SchemeData(uuid, null, "video/mp4", bArr));
                }
            }
        }
        if (arrayList2 == null) {
            return null;
        }
        return new DrmInitData(null, false, (DrmInitData.SchemeData[]) arrayList2.toArray(new DrmInitData.SchemeData[0]));
    }

    public static void d(ParsableByteArray parsableByteArray, int i2, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.J(i2 + 8);
        int iJ = parsableByteArray.j();
        if ((iJ & 1) != 0) {
            throw ParserException.c("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iJ & 2) != 0;
        int iB = parsableByteArray.B();
        if (iB == 0) {
            Arrays.fill(trackFragment.f9092l, 0, trackFragment.f9085e, false);
            return;
        }
        if (iB != trackFragment.f9085e) {
            StringBuilder sbU = b.u(iB, "Senc sample count ", " is different from fragment sample count");
            sbU.append(trackFragment.f9085e);
            throw ParserException.a(null, sbU.toString());
        }
        Arrays.fill(trackFragment.f9092l, 0, iB, z);
        int iA = parsableByteArray.a();
        ParsableByteArray parsableByteArray2 = trackFragment.n;
        parsableByteArray2.G(iA);
        trackFragment.f9091k = true;
        trackFragment.o = true;
        parsableByteArray.h(0, parsableByteArray2.f5723a, parsableByteArray2.f5725c);
        parsableByteArray2.J(0);
        trackFragment.o = false;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        SparseArray sparseArray = this.f9009e;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((TrackBundle) sparseArray.valueAt(i2)).d();
        }
        this.o.clear();
        this.x = 0;
        this.y = j3;
        this.n.clear();
        this.r = 0;
        this.u = 0;
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        int i2;
        int i3 = this.f9006b;
        ExtractorOutput subtitleTranscodingExtractorOutput = (i3 & 32) == 0 ? new SubtitleTranscodingExtractorOutput(extractorOutput, this.f9005a) : extractorOutput;
        this.G = subtitleTranscodingExtractorOutput;
        this.r = 0;
        this.u = 0;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.H = trackOutputArr;
        PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler = this.p;
        if (playerTrackEmsgHandler != null) {
            trackOutputArr[0] = playerTrackEmsgHandler;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = 100;
        if ((i3 & 4) != 0) {
            trackOutputArr[i2] = subtitleTranscodingExtractorOutput.n(100, 5);
            i4 = 101;
            i2++;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.V(i2, this.H);
        this.H = trackOutputArr2;
        for (TrackOutput trackOutput : trackOutputArr2) {
            trackOutput.b(L);
        }
        List list = this.f9008d;
        this.I = new TrackOutput[list.size()];
        int i5 = 0;
        while (i5 < this.I.length) {
            TrackOutput trackOutputN = this.G.n(i4, 3);
            trackOutputN.b((Format) list.get(i5));
            this.I[i5] = trackOutputN;
            i5++;
            i4++;
        }
        Track track = this.f9007c;
        if (track != null) {
            this.f9009e.put(0, new TrackBundle(extractorOutput.n(0, track.f9066b), new TrackSampleTable(this.f9007c, new long[0], new int[0], 0, new long[0], new int[0], 0L), new DefaultSampleValues(0, 0, 0, 0)));
            this.G.m();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:356:0x07c7, code lost:
    
        r58.r = 0;
        r58.u = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x07cc, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(long r59) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instructions count: 1997
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.f(long):void");
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        SniffFailure sniffFailureB = Sniffer.b(extractorInput, true, false);
        this.q = sniffFailureB != null ? ImmutableList.t(sniffFailureB) : ImmutableList.r();
        return sniffFailureB == null;
    }

    @Override // androidx.media3.extractor.Extractor
    public final List i() {
        return this.q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01fe, code lost:
    
        r33 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0203, code lost:
    
        if ((r12 & 31) == 6) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0206, code lost:
    
        r33 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x020d, code lost:
    
        if ("video/hevc".equals(r4) == false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0217, code lost:
    
        if (((r12 & 126) >> 1) != 39) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0219, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x021b, code lost:
    
        r33 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x021e, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x021f, code lost:
    
        r31.F = r2;
        r31.D += 5;
        r31.C += r33;
        r7 = r33;
        r2 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0231, code lost:
    
        r12 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x023c, code lost:
    
        throw androidx.media3.common.ParserException.a(null, "Invalid NAL length");
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x023d, code lost:
    
        r19 = r2;
        r33 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0244, code lost:
    
        if (r31.F == false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0246, code lost:
    
        r2 = r31.f9012h;
        r2.G(r4);
        r22 = r10;
        r23 = r14;
        ((androidx.media3.extractor.DefaultExtractorInput) r1).e(r2.f5723a, 0, r31.E, false);
        r11.e(r31.E, r2);
        r4 = r31.E;
        r7 = androidx.media3.container.NalUnitUtil.f(r2.f5725c, r2.f5723a);
        r2.J("video/hevc".equals(r12.f5225m) ? 1 : 0);
        r2.I(r7);
        androidx.media3.extractor.CeaUtil.a(r8, r2, r31.I);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x027b, code lost:
    
        r22 = r10;
        r23 = r14;
        r4 = r11.c(r1, r4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0284, code lost:
    
        r31.D += r4;
        r31.E -= r4;
        r7 = r33;
        r2 = r19;
        r10 = r22;
        r14 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0297, code lost:
    
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x029a, code lost:
    
        r30 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x029c, code lost:
    
        r2 = r31.D;
        r4 = r31.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x02a0, code lost:
    
        if (r2 >= r4) goto L402;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02a2, code lost:
    
        r31.D += r11.c(r1, r4 - r2, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02b0, code lost:
    
        if (r3.f9032l != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02b2, code lost:
    
        r1 = r3.f9024d.f9100g[r3.f9026f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x02c1, code lost:
    
        if (r5.f9090j[r3.f9026f] == false) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02c3, code lost:
    
        r1 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02c5, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02ca, code lost:
    
        if (r3.a() == null) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02cc, code lost:
    
        r1 = r1 | 1073741824;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02cf, code lost:
    
        r25 = r1;
        r1 = r3.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02d5, code lost:
    
        if (r1 == null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02d7, code lost:
    
        r28 = r1.f9078c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02dc, code lost:
    
        r28 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02de, code lost:
    
        r23 = r8;
        r11.f(r23, r25, r31.C, 0, r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02ef, code lost:
    
        if (r30.isEmpty() != false) goto L398;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02f1, code lost:
    
        r1 = (androidx.media3.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo) r30.removeFirst();
        r31.x -= r1.f9020c;
        r2 = r1.f9019b;
        r4 = r1.f9018a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0302, code lost:
    
        if (r2 == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0304, code lost:
    
        r4 = r4 + r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0306, code lost:
    
        if (r13 == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0308, code lost:
    
        r4 = r13.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x030c, code lost:
    
        r7 = r4;
        r2 = r31.H;
        r4 = r2.length;
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0311, code lost:
    
        if (r5 >= r4) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0313, code lost:
    
        r2[r5].f(r7, 1, r1.f9020c, r31.x, null);
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0327, code lost:
    
        if (r3.b() != false) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0329, code lost:
    
        r31.B = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x032c, code lost:
    
        r31.r = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0331, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0332, code lost:
    
        r2 = r5.size();
        r3 = null;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0338, code lost:
    
        if (r4 >= r2) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x033a, code lost:
    
        r6 = ((androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle) r5.valueAt(r4)).f9022b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0344, code lost:
    
        if (r6.o == false) goto L405;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0346, code lost:
    
        r9 = r6.f9083c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x034a, code lost:
    
        if (r9 >= r7) goto L406;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x034c, code lost:
    
        r3 = (androidx.media3.extractor.mp4.FragmentedMp4Extractor.TrackBundle) r5.valueAt(r4);
        r7 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0353, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0358, code lost:
    
        if (r3 != null) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x035a, code lost:
    
        r31.r = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x035f, code lost:
    
        r2 = (int) (r7 - ((androidx.media3.extractor.DefaultExtractorInput) r1).f8519d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0366, code lost:
    
        if (r2 < 0) goto L359;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0368, code lost:
    
        r4 = (androidx.media3.extractor.DefaultExtractorInput) r1;
        r4.i(r2);
        r2 = r3.f9022b;
        r3 = r2.n;
        r4.e(r3.f5723a, 0, r3.f5725c, false);
        r3.J(0);
        r2.o = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0388, code lost:
    
        throw androidx.media3.common.ParserException.a(null, "Offset to encryption data was negative.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0389, code lost:
    
        r2 = ((int) r31.t) - r31.u;
        r3 = r31.v;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0395, code lost:
    
        if (r3 == null) goto L224;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0397, code lost:
    
        ((androidx.media3.extractor.DefaultExtractorInput) r1).e(r3.f5723a, 8, r2, false);
        r5 = r31.s;
        r2 = new androidx.media3.extractor.mp4.Atom.LeafAtom(r5, r3);
        r9 = ((androidx.media3.extractor.DefaultExtractorInput) r1).f8519d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03b2, code lost:
    
        if (r4.isEmpty() != false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03b4, code lost:
    
        ((androidx.media3.extractor.mp4.Atom.ContainerAtom) r4.peek()).f8971c.add(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03c1, code lost:
    
        if (r5 != 1936286840) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03c3, code lost:
    
        r3.J(8);
        r2 = androidx.media3.extractor.mp4.Atom.b(r3.j());
        r3.K(4);
        r25 = r3.z();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x03d8, code lost:
    
        if (r2 != 0) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x03da, code lost:
    
        r4 = r3.z();
        r6 = r3.z();
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x03e2, code lost:
    
        r6 = r6 + r9;
        r21 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x03e6, code lost:
    
        r4 = r3.C();
        r6 = r3.C();
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x03ef, code lost:
    
        r2 = androidx.media3.common.util.Util.f5744a;
        r4 = androidx.media3.common.util.Util.b0(r21, 1000000, r25, java.math.RoundingMode.FLOOR);
        r3.K(2);
        r2 = r3.D();
        r8 = new int[r2];
        r9 = new long[r2];
        r10 = new long[r2];
        r11 = new long[r2];
        r14 = r4;
        r12 = r6;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x040e, code lost:
    
        if (r6 >= r2) goto L407;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0410, code lost:
    
        r7 = r3.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0418, code lost:
    
        if ((r7 & Integer.MIN_VALUE) != 0) goto L360;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x041a, code lost:
    
        r23 = r3.z();
        r8[r6] = r7 & com.google.android.gms.common.api.Api.BaseClientBuilder.API_PRIORITY_OTHER;
        r9[r6] = r12;
        r11[r6] = r14;
        r21 = r21 + r23;
        r14 = androidx.media3.common.util.Util.b0(r21, 1000000, r25, java.math.RoundingMode.FLOOR);
        r10[r6] = r14 - r11[r6];
        r3.K(4);
        r12 = r12 + r8[r6];
        r6 = r6 + 1;
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0454, code lost:
    
        throw androidx.media3.common.ParserException.a(null, "Unhandled indirect reference");
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0455, code lost:
    
        r1 = android.util.Pair.create(java.lang.Long.valueOf(r4), new androidx.media3.extractor.ChunkIndex(r8, r9, r10, r11));
        r31.A = ((java.lang.Long) r1.first).longValue();
        r31.G.c((androidx.media3.extractor.SeekMap) r1.second);
        r31.J = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x047a, code lost:
    
        if (r5 != 1701671783) goto L369;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x047f, code lost:
    
        if (r31.H.length != 0) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0483, code lost:
    
        r3.J(8);
        r1 = androidx.media3.extractor.mp4.Atom.b(r3.j());
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0495, code lost:
    
        if (r1 == 0) goto L200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0498, code lost:
    
        if (r1 == 1) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x049a, code lost:
    
        android.support.v4.media.a.r(r1, "Skipping unsupported emsg version: ", "FragmentedMp4Extractor");
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x04a1, code lost:
    
        r10 = r3.z();
        r6 = r3.C();
        r12 = java.math.RoundingMode.FLOOR;
        r1 = androidx.media3.common.util.Util.b0(r6, 1000000, r10, r12);
        r6 = androidx.media3.common.util.Util.b0(r3.z(), 1000, r10, r12);
        r8 = r3.z();
        r10 = r3.s();
        r10.getClass();
        r11 = r3.s();
        r11.getClass();
        r24 = r6;
        r26 = r8;
        r6 = -9223372036854775807L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04d3, code lost:
    
        r22 = r10;
        r23 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04d8, code lost:
    
        r10 = r3.s();
        r10.getClass();
        r11 = r3.s();
        r11.getClass();
        r25 = r3.z();
        r21 = r3.z();
        r27 = java.math.RoundingMode.FLOOR;
        r1 = androidx.media3.common.util.Util.b0(r21, 1000000, r25, r27);
        r6 = r31.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04fb, code lost:
    
        if (r6 == (-9223372036854775807L)) goto L203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04fd, code lost:
    
        r6 = r6 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04ff, code lost:
    
        r6 = -9223372036854775807L;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0500, code lost:
    
        r22 = r6;
        r6 = r1;
        r1 = r22;
        r24 = androidx.media3.common.util.Util.b0(r3.z(), 1000, r25, r27);
        r26 = r3.z();
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0518, code lost:
    
        r8 = new byte[r3.a()];
        r3.h(0, r8, r3.a());
        r8 = new androidx.media3.common.util.ParsableByteArray(r31.f9016l.a(new androidx.media3.extractor.metadata.emsg.EventMessage(r22, r23, r24, r26, r8)));
        r3 = r8.a();
        r9 = r31.H;
        r10 = r9.length;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0542, code lost:
    
        if (r11 >= r10) goto L408;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0544, code lost:
    
        r12 = r9[r11];
        r8.J(0);
        r12.e(r3, r8);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0553, code lost:
    
        if (r1 != (-9223372036854775807L)) goto L211;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0555, code lost:
    
        r12.addLast(new androidx.media3.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo(r3, r6, true));
        r31.x += r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x056b, code lost:
    
        if (r12.isEmpty() != false) goto L214;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x056d, code lost:
    
        r12.addLast(new androidx.media3.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo(r3, r1, false));
        r31.x += r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x057d, code lost:
    
        if (r13 == null) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0583, code lost:
    
        if (r13.e() != false) goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0585, code lost:
    
        r12.addLast(new androidx.media3.extractor.mp4.FragmentedMp4Extractor.MetadataSampleInfo(r3, r1, false));
        r31.x += r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0593, code lost:
    
        if (r13 == null) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0595, code lost:
    
        r1 = r13.a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0599, code lost:
    
        r22 = r1;
        r1 = r31.H;
        r2 = r1.length;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x059f, code lost:
    
        if (r6 >= r2) goto L374;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x05a1, code lost:
    
        r1[r6].f(r22, 1, r3, 0, null);
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x05b3, code lost:
    
        ((androidx.media3.extractor.DefaultExtractorInput) r32).i(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d8, code lost:
    
        r2 = r31.r;
        r5 = r3.f9022b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00de, code lost:
    
        if (r2 != 3) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e2, code lost:
    
        if (r3.f9032l != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e4, code lost:
    
        r2 = r3.f9024d.f9097d[r3.f9026f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ed, code lost:
    
        r2 = r5.f9088h[r3.f9026f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f3, code lost:
    
        r31.C = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00f9, code lost:
    
        if (r3.f9026f >= r3.f9029i) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00fb, code lost:
    
        ((androidx.media3.extractor.DefaultExtractorInput) r1).i(r2);
        r1 = r3.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0104, code lost:
    
        if (r1 != null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0107, code lost:
    
        r2 = r5.n;
        r1 = r1.f9079d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x010b, code lost:
    
        if (r1 == 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x010d, code lost:
    
        r2.K(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0110, code lost:
    
        r1 = r3.f9026f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0114, code lost:
    
        if (r5.f9091k == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x011a, code lost:
    
        if (r5.f9092l[r1] == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011c, code lost:
    
        r2.K(r2.D() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0128, code lost:
    
        if (r3.b() != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012a, code lost:
    
        r31.B = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x012c, code lost:
    
        r31.r = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x012f, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0138, code lost:
    
        if (r3.f9024d.f9094a.f9071g != r20) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x013a, code lost:
    
        r31.C = r2 - 8;
        ((androidx.media3.extractor.DefaultExtractorInput) r1).i(r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0154, code lost:
    
        if ("audio/ac4".equals(r3.f9024d.f9094a.f9070f.f5225m) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0156, code lost:
    
        r31.D = r3.c(r31.C, 7);
        r2 = r31.C;
        r8 = r31.f9014j;
        androidx.media3.extractor.Ac4Util.a(r2, r8);
        r3.f9021a.e(7, r8);
        r31.D += 7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0171, code lost:
    
        r31.D = r3.c(r31.C, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0179, code lost:
    
        r31.C += r31.D;
        r31.r = 4;
        r31.E = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0185, code lost:
    
        r2 = r3.f9024d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0189, code lost:
    
        if (r3.f9032l != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x018b, code lost:
    
        r8 = r2.f9099f[r3.f9026f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0192, code lost:
    
        r8 = r5.f9089i[r3.f9026f];
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0199, code lost:
    
        if (r13 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x019b, code lost:
    
        r8 = r13.a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019f, code lost:
    
        r2 = r2.f9094a;
        r7 = r2.f9074j;
        r11 = r3.f9021a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a5, code lost:
    
        if (r7 == 0) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a7, code lost:
    
        r14 = r31.f9011g;
        r15 = r14.f5723a;
        r15[0] = 0;
        r15[1] = 0;
        r15[r33] = 0;
        r10 = r7 + 1;
        r7 = 4 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01bd, code lost:
    
        if (r31.D >= r31.C) goto L394;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01bf, code lost:
    
        r4 = r31.E;
        r30 = r12;
        r12 = r2.f9070f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01c7, code lost:
    
        if (r4 != 0) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01c9, code lost:
    
        r19 = r2;
        ((androidx.media3.extractor.DefaultExtractorInput) r1).e(r15, r7, r10, false);
        r14.J(0);
        r4 = r14.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01da, code lost:
    
        if (r4 < 1) goto L395;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01dc, code lost:
    
        r31.E = r4 - 1;
        r4 = r31.f9010f;
        r4.J(0);
        r11.e(4, r4);
        r11.e(1, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01f0, code lost:
    
        if (r31.I.length <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f2, code lost:
    
        r4 = r12.f5225m;
        r12 = r15[4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01fc, code lost:
    
        if ("video/avc".equals(r4) == false) goto L103;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r32, androidx.media3.extractor.PositionHolder r33) throws androidx.media3.common.ParserException, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 1998
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.FragmentedMp4Extractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public FragmentedMp4Extractor(int i2, SubtitleParser.Factory factory) {
        this(factory, i2, null, null, ImmutableList.r(), null);
    }

    public FragmentedMp4Extractor(SubtitleParser.Factory factory, int i2, TimestampAdjuster timestampAdjuster, Track track, List list, PlayerEmsgHandler.PlayerTrackEmsgHandler playerTrackEmsgHandler) {
        this.f9005a = factory;
        this.f9006b = i2;
        this.f9015k = timestampAdjuster;
        this.f9007c = track;
        this.f9008d = Collections.unmodifiableList(list);
        this.p = playerTrackEmsgHandler;
        this.f9016l = new EventMessageEncoder();
        this.f9017m = new ParsableByteArray(16);
        this.f9010f = new ParsableByteArray(NalUnitUtil.f5779a);
        this.f9011g = new ParsableByteArray(5);
        this.f9012h = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.f9013i = bArr;
        this.f9014j = new ParsableByteArray(bArr);
        this.n = new ArrayDeque();
        this.o = new ArrayDeque();
        this.f9009e = new SparseArray();
        this.q = ImmutableList.r();
        this.z = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.A = -9223372036854775807L;
        this.G = ExtractorOutput.g0;
        this.H = new TrackOutput[0];
        this.I = new TrackOutput[0];
    }
}
