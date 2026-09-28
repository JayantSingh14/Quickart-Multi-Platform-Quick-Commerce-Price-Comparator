package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleOutputBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

@UnstableApi
/* loaded from: classes3.dex */
public final class Cea608Decoder extends CeaDecoder {

    /* renamed from: i, reason: collision with root package name */
    public final int f9204i;

    /* renamed from: j, reason: collision with root package name */
    public final int f9205j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9206k;
    public List o;
    public List p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public byte u;
    public byte v;
    public boolean x;
    public long y;
    public static final int[] z = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] A = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] B = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] C = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, WKSRecord.Service.SUR_MEAS, Type.TSIG, 97, 98, 99, 100, 101, 102, 103, 104, 105, Type.L64, 107, Type.EUI48, 109, 110, WKSRecord.Service.SUNRPC, 112, WKSRecord.Service.AUTH, 114, WKSRecord.Service.SFTP, 116, WKSRecord.Service.UUCP_PATH, 118, WKSRecord.Service.NNTP, 120, WKSRecord.Service.ERPC, 122, 231, 247, 209, 241, 9632};
    public static final int[] D = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, Type.IXFR};
    public static final int[] E = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, Type.TKEY, 219, 171, 187};
    public static final int[] F = {195, 227, 205, 204, 236, 210, 242, 213, WKSRecord.Service.LINK, WKSRecord.Service.NTP, WKSRecord.Service.LOCUS_MAP, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] G = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: h, reason: collision with root package name */
    public final ParsableByteArray f9203h = new ParsableByteArray();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f9208m = new ArrayList();
    public CueBuilder n = new CueBuilder(0, 4);
    public int w = 0;

    /* renamed from: l, reason: collision with root package name */
    public final long f9207l = 16000000;

    public static final class CueBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f9209a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f9210b;

        /* renamed from: c, reason: collision with root package name */
        public final StringBuilder f9211c;

        /* renamed from: d, reason: collision with root package name */
        public int f9212d;

        /* renamed from: e, reason: collision with root package name */
        public int f9213e;

        /* renamed from: f, reason: collision with root package name */
        public int f9214f;

        /* renamed from: g, reason: collision with root package name */
        public int f9215g;

        /* renamed from: h, reason: collision with root package name */
        public int f9216h;

        public static class CueStyle {

            /* renamed from: a, reason: collision with root package name */
            public final int f9217a;

            /* renamed from: b, reason: collision with root package name */
            public final boolean f9218b;

            /* renamed from: c, reason: collision with root package name */
            public int f9219c;

            public CueStyle(int i2, int i3, boolean z) {
                this.f9217a = i2;
                this.f9218b = z;
                this.f9219c = i3;
            }
        }

        public CueBuilder(int i2, int i3) {
            ArrayList arrayList = new ArrayList();
            this.f9209a = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f9210b = arrayList2;
            StringBuilder sb = new StringBuilder();
            this.f9211c = sb;
            this.f9215g = i2;
            arrayList.clear();
            arrayList2.clear();
            sb.setLength(0);
            this.f9212d = 15;
            this.f9213e = 0;
            this.f9214f = 0;
            this.f9216h = i3;
        }

        public final void a(char c2) {
            StringBuilder sb = this.f9211c;
            if (sb.length() < 32) {
                sb.append(c2);
            }
        }

        public final void b() {
            StringBuilder sb = this.f9211c;
            int length = sb.length();
            if (length > 0) {
                sb.delete(length - 1, length);
                ArrayList arrayList = this.f9209a;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    CueStyle cueStyle = (CueStyle) arrayList.get(size);
                    int i2 = cueStyle.f9219c;
                    if (i2 != length) {
                        return;
                    }
                    cueStyle.f9219c = i2 - 1;
                }
            }
        }

        public final Cue c(int i2) {
            float f2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int i3 = 0;
            while (true) {
                ArrayList arrayList = this.f9210b;
                if (i3 >= arrayList.size()) {
                    break;
                }
                spannableStringBuilder.append((CharSequence) arrayList.get(i3));
                spannableStringBuilder.append('\n');
                i3++;
            }
            spannableStringBuilder.append((CharSequence) d());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int i4 = this.f9213e + this.f9214f;
            int length = (32 - i4) - spannableStringBuilder.length();
            int i5 = i4 - length;
            if (i2 == Integer.MIN_VALUE) {
                i2 = (this.f9215g != 2 || (Math.abs(i5) >= 3 && length >= 0)) ? (this.f9215g != 2 || i5 <= 0) ? 0 : 2 : 1;
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    i4 = 32 - length;
                }
                f2 = ((i4 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f2 = 0.5f;
            }
            int i6 = this.f9212d;
            if (i6 > 7) {
                i6 -= 17;
            } else if (this.f9215g == 1) {
                i6 -= this.f9216h - 1;
            }
            Cue.Builder builder = new Cue.Builder();
            builder.f5625a = spannableStringBuilder;
            builder.f5627c = Layout.Alignment.ALIGN_NORMAL;
            builder.f5629e = i6;
            builder.f5630f = 1;
            builder.f5632h = f2;
            builder.f5633i = i2;
            return builder.a();
        }

        public final SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f9211c);
            int length = spannableStringBuilder.length();
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            int i7 = 0;
            boolean z = false;
            while (true) {
                ArrayList arrayList = this.f9209a;
                if (i6 >= arrayList.size()) {
                    break;
                }
                CueStyle cueStyle = (CueStyle) arrayList.get(i6);
                boolean z2 = cueStyle.f9218b;
                int i8 = cueStyle.f9217a;
                if (i8 != 8) {
                    boolean z3 = i8 == 7;
                    if (i8 != 7) {
                        i5 = Cea608Decoder.B[i8];
                    }
                    z = z3;
                }
                int i9 = cueStyle.f9219c;
                i6++;
                if (i9 != (i6 < arrayList.size() ? ((CueStyle) arrayList.get(i6)).f9219c : length)) {
                    if (i2 != -1 && !z2) {
                        spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i9, 33);
                        i2 = -1;
                    } else if (i2 == -1 && z2) {
                        i2 = i9;
                    }
                    if (i3 != -1 && !z) {
                        spannableStringBuilder.setSpan(new StyleSpan(2), i3, i9, 33);
                        i3 = -1;
                    } else if (i3 == -1 && z) {
                        i3 = i9;
                    }
                    if (i5 != i4) {
                        if (i4 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i7, i9, 33);
                        }
                        i4 = i5;
                        i7 = i9;
                    }
                }
            }
            if (i2 != -1 && i2 != length) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
            }
            if (i3 != -1 && i3 != length) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, length, 33);
            }
            if (i7 != length && i4 != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i4), i7, length, 33);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public final boolean e() {
            return this.f9209a.isEmpty() && this.f9210b.isEmpty() && this.f9211c.length() == 0;
        }
    }

    public Cea608Decoder(String str, int i2) {
        this.f9204i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i2 == 1) {
            this.f9206k = 0;
            this.f9205j = 0;
        } else if (i2 == 2) {
            this.f9206k = 1;
            this.f9205j = 0;
        } else if (i2 == 3) {
            this.f9206k = 0;
            this.f9205j = 1;
        } else if (i2 != 4) {
            Log.h("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f9206k = 0;
            this.f9205j = 0;
        } else {
            this.f9206k = 1;
            this.f9205j = 1;
        }
        m(0);
        l();
        this.x = true;
        this.y = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.extractor.text.SubtitleDecoder
    public final void c(long j2) {
        this.f9250e = j2;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public final void flush() {
        super.flush();
        this.o = null;
        this.p = null;
        m(0);
        this.r = 4;
        this.n.f9216h = 4;
        l();
        this.s = false;
        this.t = false;
        this.u = (byte) 0;
        this.v = (byte) 0;
        this.w = 0;
        this.x = true;
        this.y = -9223372036854775807L;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final Subtitle g() {
        List list = this.o;
        this.p = list;
        list.getClass();
        return new CeaSubtitle(list);
    }

    @Override // androidx.media3.decoder.Decoder
    public final String getName() {
        return "Cea608Decoder";
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0085 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6 A[FALL_THROUGH] */
    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(androidx.media3.extractor.text.SubtitleInputBuffer r15) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea608Decoder.h(androidx.media3.extractor.text.SubtitleInputBuffer):void");
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    /* renamed from: i */
    public final SubtitleOutputBuffer a() {
        SubtitleOutputBuffer subtitleOutputBuffer;
        SubtitleOutputBuffer subtitleOutputBufferA = super.a();
        if (subtitleOutputBufferA != null) {
            return subtitleOutputBufferA;
        }
        long j2 = this.f9207l;
        if (j2 == -9223372036854775807L) {
            return null;
        }
        long j3 = this.y;
        if (j3 == -9223372036854775807L || this.f9250e - j3 < j2 || (subtitleOutputBuffer = (SubtitleOutputBuffer) this.f9247b.pollFirst()) == null) {
            return null;
        }
        this.o = Collections.EMPTY_LIST;
        this.y = -9223372036854775807L;
        Subtitle subtitleG = g();
        long j4 = this.f9250e;
        subtitleOutputBuffer.f6076b = j4;
        subtitleOutputBuffer.f9177e = subtitleG;
        subtitleOutputBuffer.f9178f = j4;
        return subtitleOutputBuffer;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final boolean j() {
        return this.o != this.p;
    }

    public final ArrayList k() {
        ArrayList arrayList = this.f9208m;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int iMin = 2;
        for (int i2 = 0; i2 < size; i2++) {
            Cue cueC = ((CueBuilder) arrayList.get(i2)).c(Integer.MIN_VALUE);
            arrayList2.add(cueC);
            if (cueC != null) {
                iMin = Math.min(iMin, cueC.f5620i);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            Cue cueC2 = (Cue) arrayList2.get(i3);
            if (cueC2 != null) {
                if (cueC2.f5620i != iMin) {
                    cueC2 = ((CueBuilder) arrayList.get(i3)).c(iMin);
                    cueC2.getClass();
                }
                arrayList3.add(cueC2);
            }
        }
        return arrayList3;
    }

    public final void l() {
        CueBuilder cueBuilder = this.n;
        cueBuilder.f9215g = this.q;
        cueBuilder.f9209a.clear();
        cueBuilder.f9210b.clear();
        cueBuilder.f9211c.setLength(0);
        cueBuilder.f9212d = 15;
        cueBuilder.f9213e = 0;
        cueBuilder.f9214f = 0;
        ArrayList arrayList = this.f9208m;
        arrayList.clear();
        arrayList.add(this.n);
    }

    public final void m(int i2) {
        int i3 = this.q;
        if (i3 == i2) {
            return;
        }
        this.q = i2;
        if (i2 != 3) {
            l();
            if (i3 == 3 || i2 == 1 || i2 == 0) {
                this.o = Collections.EMPTY_LIST;
                return;
            }
            return;
        }
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f9208m;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((CueBuilder) arrayList.get(i4)).f9215g = i2;
            i4++;
        }
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public final void release() {
    }
}
