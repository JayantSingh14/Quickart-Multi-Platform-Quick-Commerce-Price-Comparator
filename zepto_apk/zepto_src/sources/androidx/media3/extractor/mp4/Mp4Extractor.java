package androidx.media3.extractor.mp4;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.SniffFailure;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.TrueHdSampleRechunker;
import androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
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
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class Mp4Extractor implements Extractor, SeekMap {
    public static final /* synthetic */ int B = 0;
    public MotionPhotoMetadata A;

    /* renamed from: a, reason: collision with root package name */
    public final SubtitleParser.Factory f9035a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9036b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f9037c;

    /* renamed from: d, reason: collision with root package name */
    public final ParsableByteArray f9038d;

    /* renamed from: e, reason: collision with root package name */
    public final ParsableByteArray f9039e;

    /* renamed from: f, reason: collision with root package name */
    public final ParsableByteArray f9040f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayDeque f9041g;

    /* renamed from: h, reason: collision with root package name */
    public final SefReader f9042h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f9043i;

    /* renamed from: j, reason: collision with root package name */
    public ImmutableList f9044j;

    /* renamed from: k, reason: collision with root package name */
    public int f9045k;

    /* renamed from: l, reason: collision with root package name */
    public int f9046l;

    /* renamed from: m, reason: collision with root package name */
    public long f9047m;
    public int n;
    public ParsableByteArray o;
    public int p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public ExtractorOutput u;
    public Mp4Track[] v;
    public long[][] w;
    public int x;
    public long y;
    public int z;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class Mp4Track {

        /* renamed from: a, reason: collision with root package name */
        public final Track f9048a;

        /* renamed from: b, reason: collision with root package name */
        public final TrackSampleTable f9049b;

        /* renamed from: c, reason: collision with root package name */
        public final TrackOutput f9050c;

        /* renamed from: d, reason: collision with root package name */
        public final TrueHdSampleRechunker f9051d;

        /* renamed from: e, reason: collision with root package name */
        public int f9052e;

        public Mp4Track(Track track, TrackSampleTable trackSampleTable, TrackOutput trackOutput) {
            this.f9048a = track;
            this.f9049b = trackSampleTable;
            this.f9050c = trackOutput;
            this.f9051d = "audio/true-hd".equals(track.f9070f.f5225m) ? new TrueHdSampleRechunker() : null;
        }
    }

    @Deprecated
    public Mp4Extractor() {
        this(16, SubtitleParser.Factory.f9179a);
    }

    @Override // androidx.media3.extractor.Extractor
    public final void a(long j2, long j3) {
        this.f9041g.clear();
        this.n = 0;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        if (j2 == 0) {
            if (this.f9045k != 3) {
                this.f9045k = 0;
                this.n = 0;
                return;
            } else {
                SefReader sefReader = this.f9042h;
                sefReader.f9059a.clear();
                sefReader.f9060b = 0;
                this.f9043i.clear();
                return;
            }
        }
        for (Mp4Track mp4Track : this.v) {
            TrackSampleTable trackSampleTable = mp4Track.f9049b;
            int iF = Util.f(trackSampleTable.f9099f, j3, false);
            while (true) {
                if (iF < 0) {
                    iF = -1;
                    break;
                } else if ((trackSampleTable.f9100g[iF] & 1) != 0) {
                    break;
                } else {
                    iF--;
                }
            }
            if (iF == -1) {
                iF = trackSampleTable.a(j3);
            }
            mp4Track.f9052e = iF;
            TrueHdSampleRechunker trueHdSampleRechunker = mp4Track.f9051d;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.f8619b = false;
                trueHdSampleRechunker.f8620c = 0;
            }
        }
    }

    @Override // androidx.media3.extractor.Extractor
    public final void c(ExtractorOutput extractorOutput) {
        if ((this.f9036b & 16) == 0) {
            extractorOutput = new SubtitleTranscodingExtractorOutput(extractorOutput, this.f9035a);
        }
        this.u = extractorOutput;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e0 A[EDGE_INSN: B:75:0x00e0->B:67:0x00e0 BREAK  A[LOOP:1: B:32:0x0077->B:66:0x00db], SYNTHETIC] */
    @Override // androidx.media3.extractor.SeekMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.extractor.SeekMap.SeekPoints d(long r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.d(long):androidx.media3.extractor.SeekMap$SeekPoints");
    }

    @Override // androidx.media3.extractor.SeekMap
    public final boolean g() {
        return true;
    }

    @Override // androidx.media3.extractor.Extractor
    public final boolean h(ExtractorInput extractorInput) {
        SniffFailure sniffFailureB = Sniffer.b(extractorInput, false, (this.f9036b & 2) != 0);
        this.f9044j = sniffFailureB != null ? ImmutableList.t(sniffFailureB) : ImmutableList.r();
        return sniffFailureB == null;
    }

    @Override // androidx.media3.extractor.Extractor
    public final List i() {
        return this.f9044j;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x04af, code lost:
    
        r3 = r10;
        r10 = r4;
        r6 = r42.n;
        r7 = r42.f9040f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x04b9, code lost:
    
        if (r6 != 0) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x04c3, code lost:
    
        if (r43.e(r7.f5723a, 0, 8, r3) != false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x04c8, code lost:
    
        if (r42.z != 2) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x04cd, code lost:
    
        if ((r42.f9036b & 2) == 0) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x04cf, code lost:
    
        r0 = r42.u.n(0, 4);
        r2 = r42.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x04d8, code lost:
    
        if (r2 != null) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x04db, code lost:
    
        r15 = new androidx.media3.common.Metadata(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x04e5, code lost:
    
        r2 = new androidx.media3.common.Format.Builder();
        r2.f5235j = r15;
        android.support.v4.media.a.s(r2, r0);
        r42.u.m();
        r42.u.c(new androidx.media3.extractor.SeekMap.Unseekable(-9223372036854775807L));
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0505, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x0506, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0509, code lost:
    
        r42.n = 8;
        r7.J(0);
        r42.f9047m = r7.z();
        r42.f9046l = r7.j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0523, code lost:
    
        r13 = r42.f9047m;
     */
    /* JADX WARN: Code restructure failed: missing block: B:261:0x0529, code lost:
    
        if (r13 != 1) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x052b, code lost:
    
        r43.readFully(r7.f5723a, 8, 8);
        r42.n += 8;
        r42.f9047m = r7.C();
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0542, code lost:
    
        if (r13 != 0) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x0544, code lost:
    
        r13 = r43.getLength();
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x054a, code lost:
    
        if (r13 != (-1)) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x054c, code lost:
    
        r6 = (androidx.media3.extractor.mp4.Atom.ContainerAtom) r12.peek();
     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x0552, code lost:
    
        if (r6 == null) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0554, code lost:
    
        r13 = r6.f8970b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0558, code lost:
    
        if (r13 == (-1)) goto L273;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x055a, code lost:
    
        r42.f9047m = (r13 - r43.getPosition()) + r42.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0566, code lost:
    
        r4 = r42.f9047m;
        r6 = r42.n;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x056d, code lost:
    
        if (r4 < r6) goto L357;
     */
    /* JADX WARN: Code restructure failed: missing block: B:275:0x056f, code lost:
    
        r4 = r42.f9046l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:276:0x057a, code lost:
    
        if (r4 == 1836019574) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:278:0x057f, code lost:
    
        if (r4 == 1953653099) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0584, code lost:
    
        if (r4 == 1835297121) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:282:0x0589, code lost:
    
        if (r4 == 1835626086) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:284:0x058e, code lost:
    
        if (r4 == 1937007212) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x0593, code lost:
    
        if (r4 == 1701082227) goto L288;
     */
    /* JADX WARN: Code restructure failed: missing block: B:287:0x0595, code lost:
    
        if (r4 != 1835365473) goto L289;
     */
    /* JADX WARN: Code restructure failed: missing block: B:290:0x059d, code lost:
    
        if (r4 == 1835296868) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x05a2, code lost:
    
        if (r4 == 1836476516) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x05a4, code lost:
    
        if (r4 == 1751411826) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x05a9, code lost:
    
        if (r4 == 1937011556) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:297:0x05ae, code lost:
    
        if (r4 == 1937011827) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:299:0x05b3, code lost:
    
        if (r4 == 1937011571) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:301:0x05b8, code lost:
    
        if (r4 == 1668576371) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:303:0x05bd, code lost:
    
        if (r4 == 1701606260) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:305:0x05c2, code lost:
    
        if (r4 == 1937011555) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x05c7, code lost:
    
        if (r4 == 1937011578) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x05cc, code lost:
    
        if (r4 == 1937013298) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x05d1, code lost:
    
        if (r4 == 1937007471) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:313:0x05d6, code lost:
    
        if (r4 == 1668232756) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:315:0x05db, code lost:
    
        if (r4 == 1953196132) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x05e0, code lost:
    
        if (r4 == 1718909296) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x05e5, code lost:
    
        if (r4 == 1969517665) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x05ea, code lost:
    
        if (r4 == 1801812339) goto L324;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x05ef, code lost:
    
        if (r4 != 1768715124) goto L325;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x05f4, code lost:
    
        r3 = r43.getPosition();
        r5 = r42.n;
        r34 = r3 - r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0602, code lost:
    
        if (r42.f9046l != 1836086884) goto L328;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0604, code lost:
    
        r42.A = new androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata(0, r34, -9223372036854775807L, r34 + r5, r42.f9047m - r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x061a, code lost:
    
        r42.o = null;
        r42.f9045k = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x061f, code lost:
    
        r14 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0624, code lost:
    
        if (r6 != 8) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0626, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x0628, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x0629, code lost:
    
        androidx.media3.common.util.Assertions.g(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x0633, code lost:
    
        if (r42.f9047m > org.xbill.DNS.TTL.MAX_VALUE) goto L336;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x0635, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x0637, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:337:0x0638, code lost:
    
        androidx.media3.common.util.Assertions.g(r3);
        r3 = new androidx.media3.common.util.ParsableByteArray((int) r42.f9047m);
        java.lang.System.arraycopy(r7.f5723a, 0, r3.f5723a, 0, 8);
        r42.o = r3;
        r42.f9045k = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:338:0x0652, code lost:
    
        r6 = r43.getPosition();
        r13 = r42.f9047m;
        r4 = r42.n;
        r6 = (r6 + r13) - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:339:0x065f, code lost:
    
        if (r13 == r4) goto L346;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x0663, code lost:
    
        if (r42.f9046l != 1835365473) goto L346;
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0665, code lost:
    
        r14.G(8);
        r43.f(0, r14.f5723a, 8);
        r4 = androidx.media3.extractor.mp4.AtomParsers.f8974a;
        r4 = r14.f5724b;
        r14 = 4;
        r14.K(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x067e, code lost:
    
        if (r14.j() == 1751411826) goto L345;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0680, code lost:
    
        r4 = r4 + 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0681, code lost:
    
        r14.J(r4);
        r43.i(r14.f5724b);
        r43.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x068d, code lost:
    
        r14 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x0690, code lost:
    
        r12.push(new androidx.media3.extractor.mp4.Atom.ContainerAtom(r42.f9046l, r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x06a1, code lost:
    
        if (r42.f9047m != r42.n) goto L350;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x06a3, code lost:
    
        m(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x06a7, code lost:
    
        r42.f9045k = 0;
        r42.n = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x06b6, code lost:
    
        throw androidx.media3.common.ParserException.c("Atom size less than header length (unsupported).");
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0088  */
    @Override // androidx.media3.extractor.Extractor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(androidx.media3.extractor.ExtractorInput r43, androidx.media3.extractor.PositionHolder r44) throws androidx.media3.common.ParserException {
        /*
            Method dump skipped, instructions count: 1756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.j(androidx.media3.extractor.ExtractorInput, androidx.media3.extractor.PositionHolder):int");
    }

    @Override // androidx.media3.extractor.SeekMap
    public final long l() {
        return this.y;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01df, code lost:
    
        r0 = r12.t(r29 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e9, code lost:
    
        if (r6 != 1851878757) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01eb, code lost:
    
        r2 = r12.t(r29 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01f5, code lost:
    
        if (r6 != 1684108385) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01f7, code lost:
    
        r3 = r13;
        r9 = r29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01fa, code lost:
    
        r12.K(r29 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01ff, code lost:
    
        r7 = r31;
        r24 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0205, code lost:
    
        r31 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0207, code lost:
    
        if (r0 == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0209, code lost:
    
        if (r2 == null) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x020c, code lost:
    
        if (r3 != (-1)) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x020f, code lost:
    
        r12.J(r3);
        r12.K(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0221, code lost:
    
        r3 = new androidx.media3.extractor.metadata.id3.InternalFrame(r0, r2, r12.t(r9 - 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0224, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0225, code lost:
    
        r12.J(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x022a, code lost:
    
        r31 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x022f, code lost:
    
        r2 = 16777215 & r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0236, code lost:
    
        if (r2 != 6516084) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0238, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.a(r9, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0240, code lost:
    
        if (r2 == 7233901) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0245, code lost:
    
        if (r2 != 7631467) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x024c, code lost:
    
        if (r2 == 6516589) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0251, code lost:
    
        if (r2 != 7828084) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0258, code lost:
    
        if (r2 != 6578553) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x025a, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TDRC");
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0264, code lost:
    
        if (r2 != 4280916) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0266, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TPE1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0270, code lost:
    
        if (r2 != 7630703) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0272, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TSSE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x027c, code lost:
    
        if (r2 != 6384738) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x027e, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TALB");
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0288, code lost:
    
        if (r2 != 7108978) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x028a, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "USLT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0294, code lost:
    
        if (r2 != 6776174) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0296, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TCON");
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x029e, code lost:
    
        if (r2 != 6779504) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02a0, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TIT1");
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02a8, code lost:
    
        androidx.media3.common.util.Log.b("MetadataUtil", "Skipped unknown metadata entry: " + androidx.media3.extractor.mp4.Atom.a(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02bb, code lost:
    
        r12.J(r5);
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02c0, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TCOM");
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02c8, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TIT2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02d0, code lost:
    
        if (r3 == null) goto L381;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02d2, code lost:
    
        r4.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02d5, code lost:
    
        r0 = r30;
        r7 = r31;
        r6 = 1;
        r24 = 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02e3, code lost:
    
        r12.J(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02e6, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02e7, code lost:
    
        r31 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02ee, code lost:
    
        if (r4.isEmpty() == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02f0, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02f2, code lost:
    
        r0 = new androidx.media3.common.Metadata(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x033e, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0098, code lost:
    
        r12.J(r0);
        r0 = r0 + r4;
        r12.K(r2);
        r4 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
    
        r5 = r12.f5724b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a6, code lost:
    
        if (r5 >= r0) goto L379;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        r5 = r12.j() + r5;
        r9 = r12.j();
        r2 = (r9 >> 24) & 255;
        r28 = r6;
        r30 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c2, code lost:
    
        if (r2 == 169) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c6, code lost:
    
        if (r2 != 253) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c8, code lost:
    
        r31 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d0, code lost:
    
        if (r9 != 1735291493) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d2, code lost:
    
        r2 = androidx.media3.extractor.metadata.id3.Id3Util.a(androidx.media3.extractor.mp4.MetadataUtil.d(r12) - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
    
        if (r2 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00de, code lost:
    
        r3 = new androidx.media3.extractor.metadata.id3.TextInformationFrame("TCON", null, com.google.common.collect.ImmutableList.t(r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e9, code lost:
    
        androidx.media3.common.util.Log.h("MetadataUtil", "Failed to parse standard genre code");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ef, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f0, code lost:
    
        r12.J(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f3, code lost:
    
        r31 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00fc, code lost:
    
        if (r9 != 1684632427) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fe, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.c(r9, r12, "TPOS");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0105, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010b, code lost:
    
        if (r9 != 1953655662) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010d, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.c(r9, r12, "TRCK");
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0117, code lost:
    
        if (r9 != 1953329263) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0119, code lost:
    
        r0 = androidx.media3.extractor.mp4.MetadataUtil.e(r9, "TBPM", r12, r28, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0122, code lost:
    
        r12.J(r5);
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x012a, code lost:
    
        if (r9 != 1668311404) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x012c, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.e(r9, "TCMP", r12, true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0137, code lost:
    
        if (r9 != 1668249202) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0139, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.b(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0141, code lost:
    
        if (r9 != 1631670868) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0143, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TPE2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x014d, code lost:
    
        if (r9 != 1936682605) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014f, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TSOT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0159, code lost:
    
        if (r9 != 1936679276) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x015b, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TSOA");
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0165, code lost:
    
        if (r9 != 1936679282) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0167, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TSOP");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0171, code lost:
    
        if (r9 != 1936679265) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0173, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TSO2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x017e, code lost:
    
        if (r9 != 1936679791) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0180, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TSOC");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x018b, code lost:
    
        if (r9 != 1920233063) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x018d, code lost:
    
        r0 = androidx.media3.extractor.mp4.MetadataUtil.e(r9, "ITUNESADVISORY", r12, false, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0198, code lost:
    
        if (r9 != 1885823344) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x019a, code lost:
    
        r0 = androidx.media3.extractor.mp4.MetadataUtil.e(r9, "ITUNESGAPLESS", r12, false, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a7, code lost:
    
        if (r9 != 1936683886) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a9, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TVSHOWSORT");
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b4, code lost:
    
        if (r9 != 1953919848) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01b6, code lost:
    
        r3 = androidx.media3.extractor.mp4.MetadataUtil.f(r9, r12, "TVSHOW");
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01c1, code lost:
    
        if (r9 != 757935405) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01c3, code lost:
    
        r0 = null;
        r2 = null;
        r3 = -1;
        r9 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c7, code lost:
    
        r13 = r12.f5724b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01c9, code lost:
    
        if (r13 >= r5) goto L382;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01cb, code lost:
    
        r29 = r12.j();
        r6 = r12.j();
        r31 = r7;
        r12.K(r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01dd, code lost:
    
        if (r6 != 1835360622) goto L101;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x051d  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x06b5 A[LOOP:13: B:337:0x06b2->B:339:0x06b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0692 A[EDGE_INSN: B:399:0x0692->B:336:0x0692 BREAK  A[LOOP:10: B:268:0x0566->B:335:0x0688], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m(long r35) {
        /*
            Method dump skipped, instructions count: 1882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mp4.Mp4Extractor.m(long):void");
    }

    @Override // androidx.media3.extractor.Extractor
    public final void release() {
    }

    public Mp4Extractor(int i2, SubtitleParser.Factory factory) {
        this.f9035a = factory;
        this.f9036b = i2;
        this.f9044j = ImmutableList.r();
        this.f9045k = (i2 & 4) != 0 ? 3 : 0;
        this.f9042h = new SefReader();
        this.f9043i = new ArrayList();
        this.f9040f = new ParsableByteArray(16);
        this.f9041g = new ArrayDeque();
        this.f9037c = new ParsableByteArray(NalUnitUtil.f5779a);
        this.f9038d = new ParsableByteArray(4);
        this.f9039e = new ParsableByteArray();
        this.p = -1;
        this.u = ExtractorOutput.g0;
        this.v = new Mp4Track[0];
    }
}
