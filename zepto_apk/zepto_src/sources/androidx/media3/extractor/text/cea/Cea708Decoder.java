package androidx.media3.extractor.text.cea;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.Subtitle;
import androidx.media3.extractor.text.SubtitleInputBuffer;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

@UnstableApi
/* loaded from: classes3.dex */
public final class Cea708Decoder extends CeaDecoder {

    /* renamed from: h, reason: collision with root package name */
    public final ParsableByteArray f9220h = new ParsableByteArray();

    /* renamed from: i, reason: collision with root package name */
    public final ParsableBitArray f9221i = new ParsableBitArray();

    /* renamed from: j, reason: collision with root package name */
    public int f9222j = -1;

    /* renamed from: k, reason: collision with root package name */
    public final int f9223k;

    /* renamed from: l, reason: collision with root package name */
    public final CueInfoBuilder[] f9224l;

    /* renamed from: m, reason: collision with root package name */
    public CueInfoBuilder f9225m;
    public List n;
    public List o;
    public DtvCcPacket p;
    public int q;

    public static final class Cea708CueInfo {

        /* renamed from: c, reason: collision with root package name */
        public static final a f9226c = new a();

        /* renamed from: a, reason: collision with root package name */
        public final Cue f9227a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9228b;

        public Cea708CueInfo(SpannableStringBuilder spannableStringBuilder, Layout.Alignment alignment, float f2, int i2, float f3, int i3, boolean z, int i4, int i5) {
            Cue.Builder builder = new Cue.Builder();
            builder.f5625a = spannableStringBuilder;
            builder.f5627c = alignment;
            builder.f5629e = f2;
            builder.f5630f = 0;
            builder.f5631g = i2;
            builder.f5632h = f3;
            builder.f5633i = i3;
            builder.f5636l = -3.4028235E38f;
            if (z) {
                builder.o = i4;
                builder.n = true;
            }
            this.f9227a = builder.a();
            this.f9228b = i5;
        }
    }

    public static final class CueInfoBuilder {
        public static final boolean[] A;
        public static final int[] B;
        public static final int[] C;
        public static final int[] D;
        public static final int[] E;
        public static final int v = c(2, 2, 2, 0);
        public static final int w;
        public static final int[] x;
        public static final int[] y;
        public static final int[] z;

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f9229a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final SpannableStringBuilder f9230b = new SpannableStringBuilder();

        /* renamed from: c, reason: collision with root package name */
        public boolean f9231c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f9232d;

        /* renamed from: e, reason: collision with root package name */
        public int f9233e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f9234f;

        /* renamed from: g, reason: collision with root package name */
        public int f9235g;

        /* renamed from: h, reason: collision with root package name */
        public int f9236h;

        /* renamed from: i, reason: collision with root package name */
        public int f9237i;

        /* renamed from: j, reason: collision with root package name */
        public int f9238j;

        /* renamed from: k, reason: collision with root package name */
        public int f9239k;

        /* renamed from: l, reason: collision with root package name */
        public int f9240l;

        /* renamed from: m, reason: collision with root package name */
        public int f9241m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;

        static {
            int iC = c(0, 0, 0, 0);
            w = iC;
            int iC2 = c(0, 0, 0, 3);
            x = new int[]{0, 0, 0, 0, 0, 2, 0};
            y = new int[]{0, 0, 0, 0, 0, 0, 2};
            z = new int[]{3, 3, 3, 3, 3, 3, 1};
            A = new boolean[]{false, false, false, true, true, true, false};
            B = new int[]{iC, iC2, iC, iC, iC2, iC, iC};
            C = new int[]{0, 1, 2, 3, 4, 3, 4};
            D = new int[]{0, 0, 0, 0, 0, 3, 3};
            E = new int[]{iC, iC, iC, iC, iC, iC2, iC2};
        }

        public CueInfoBuilder() {
            d();
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int c(int r4, int r5, int r6, int r7) {
            /*
                r0 = 4
                androidx.media3.common.util.Assertions.c(r4, r0)
                androidx.media3.common.util.Assertions.c(r5, r0)
                androidx.media3.common.util.Assertions.c(r6, r0)
                androidx.media3.common.util.Assertions.c(r7, r0)
                r0 = 0
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L1b
                if (r7 == r1) goto L1b
                r3 = 2
                if (r7 == r3) goto L1f
                r3 = 3
                if (r7 == r3) goto L1d
            L1b:
                r7 = r2
                goto L21
            L1d:
                r7 = r0
                goto L21
            L1f:
                r7 = 127(0x7f, float:1.78E-43)
            L21:
                if (r4 <= r1) goto L25
                r4 = r2
                goto L26
            L25:
                r4 = r0
            L26:
                if (r5 <= r1) goto L2a
                r5 = r2
                goto L2b
            L2a:
                r5 = r0
            L2b:
                if (r6 <= r1) goto L2e
                r0 = r2
            L2e:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.CueInfoBuilder.c(int, int, int, int):int");
        }

        public final void a(char c2) {
            SpannableStringBuilder spannableStringBuilder = this.f9230b;
            if (c2 != '\n') {
                spannableStringBuilder.append(c2);
                return;
            }
            ArrayList arrayList = this.f9229a;
            arrayList.add(b());
            spannableStringBuilder.clear();
            if (this.o != -1) {
                this.o = 0;
            }
            if (this.p != -1) {
                this.p = 0;
            }
            if (this.q != -1) {
                this.q = 0;
            }
            if (this.s != -1) {
                this.s = 0;
            }
            while (true) {
                if (arrayList.size() < this.f9238j && arrayList.size() < 15) {
                    this.u = arrayList.size();
                    return;
                }
                arrayList.remove(0);
            }
        }

        public final SpannableString b() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f9230b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.o != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.o, length, 33);
                }
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.r), this.q, length, 33);
                }
                if (this.s != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.t), this.s, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public final void d() {
            this.f9229a.clear();
            this.f9230b.clear();
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.s = -1;
            this.u = 0;
            this.f9231c = false;
            this.f9232d = false;
            this.f9233e = 4;
            this.f9234f = false;
            this.f9235g = 0;
            this.f9236h = 0;
            this.f9237i = 0;
            this.f9238j = 15;
            this.f9239k = 0;
            this.f9240l = 0;
            this.f9241m = 0;
            int i2 = w;
            this.n = i2;
            this.r = v;
            this.t = i2;
        }

        public final void e(boolean z2, boolean z3) {
            int i2 = this.o;
            SpannableStringBuilder spannableStringBuilder = this.f9230b;
            if (i2 != -1) {
                if (!z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.o, spannableStringBuilder.length(), 33);
                    this.o = -1;
                }
            } else if (z2) {
                this.o = spannableStringBuilder.length();
            }
            if (this.p == -1) {
                if (z3) {
                    this.p = spannableStringBuilder.length();
                }
            } else {
                if (z3) {
                    return;
                }
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.p, spannableStringBuilder.length(), 33);
                this.p = -1;
            }
        }

        public final void f(int i2, int i3) {
            int i4 = this.q;
            SpannableStringBuilder spannableStringBuilder = this.f9230b;
            if (i4 != -1 && this.r != i2) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.r), this.q, spannableStringBuilder.length(), 33);
            }
            if (i2 != v) {
                this.q = spannableStringBuilder.length();
                this.r = i2;
            }
            if (this.s != -1 && this.t != i3) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.t), this.s, spannableStringBuilder.length(), 33);
            }
            if (i3 != w) {
                this.s = spannableStringBuilder.length();
                this.t = i3;
            }
        }
    }

    public static final class DtvCcPacket {

        /* renamed from: a, reason: collision with root package name */
        public final int f9242a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9243b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f9244c;

        /* renamed from: d, reason: collision with root package name */
        public int f9245d = 0;

        public DtvCcPacket(int i2, int i3) {
            this.f9242a = i2;
            this.f9243b = i3;
            this.f9244c = new byte[(i3 * 2) - 1];
        }
    }

    public Cea708Decoder(int i2, List list) {
        this.f9223k = i2 == -1 ? 1 : i2;
        if (list != null && list.size() == 1 && ((byte[]) list.get(0)).length == 1) {
            byte b2 = ((byte[]) list.get(0))[0];
        }
        this.f9224l = new CueInfoBuilder[8];
        for (int i3 = 0; i3 < 8; i3++) {
            this.f9224l[i3] = new CueInfoBuilder();
        }
        this.f9225m = this.f9224l[0];
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.extractor.text.SubtitleDecoder
    public final void c(long j2) {
        this.f9250e = j2;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public final void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        this.q = 0;
        this.f9225m = this.f9224l[0];
        m();
        this.p = null;
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final Subtitle g() {
        List list = this.n;
        this.o = list;
        list.getClass();
        return new CeaSubtitle(list);
    }

    @Override // androidx.media3.decoder.Decoder
    public final String getName() {
        return "Cea708Decoder";
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final void h(SubtitleInputBuffer subtitleInputBuffer) {
        ByteBuffer byteBuffer = subtitleInputBuffer.f6071d;
        byteBuffer.getClass();
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        ParsableByteArray parsableByteArray = this.f9220h;
        parsableByteArray.H(iLimit, bArrArray);
        while (parsableByteArray.a() >= 3) {
            int iX = parsableByteArray.x();
            int i2 = iX & 3;
            boolean z = (iX & 4) == 4;
            byte bX = (byte) parsableByteArray.x();
            byte bX2 = (byte) parsableByteArray.x();
            if (i2 == 2 || i2 == 3) {
                if (z) {
                    if (i2 == 3) {
                        k();
                        int i3 = (bX & 192) >> 6;
                        int i4 = this.f9222j;
                        if (i4 != -1 && i3 != (i4 + 1) % 4) {
                            m();
                            Log.h("Cea708Decoder", "Sequence number discontinuity. previous=" + this.f9222j + " current=" + i3);
                        }
                        this.f9222j = i3;
                        int i5 = bX & 63;
                        if (i5 == 0) {
                            i5 = 64;
                        }
                        DtvCcPacket dtvCcPacket = new DtvCcPacket(i3, i5);
                        this.p = dtvCcPacket;
                        dtvCcPacket.f9245d = 1;
                        dtvCcPacket.f9244c[0] = bX2;
                    } else {
                        Assertions.a(i2 == 2);
                        DtvCcPacket dtvCcPacket2 = this.p;
                        if (dtvCcPacket2 == null) {
                            Log.d("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr = dtvCcPacket2.f9244c;
                            int i6 = dtvCcPacket2.f9245d;
                            int i7 = i6 + 1;
                            dtvCcPacket2.f9245d = i7;
                            bArr[i6] = bX;
                            dtvCcPacket2.f9245d = i6 + 2;
                            bArr[i7] = bX2;
                        }
                    }
                    DtvCcPacket dtvCcPacket3 = this.p;
                    if (dtvCcPacket3.f9245d == (dtvCcPacket3.f9243b * 2) - 1) {
                        k();
                    }
                }
            }
        }
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder
    public final boolean j() {
        return this.n != this.o;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void k() {
        boolean z;
        char c2;
        int i2;
        boolean z2;
        DtvCcPacket dtvCcPacket = this.p;
        if (dtvCcPacket == null) {
            return;
        }
        int i3 = 2;
        if (dtvCcPacket.f9245d != (dtvCcPacket.f9243b * 2) - 1) {
            Log.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.p.f9243b * 2) - 1) + ", but current index is " + this.p.f9245d + " (sequence number " + this.p.f9242a + ");");
        }
        DtvCcPacket dtvCcPacket2 = this.p;
        byte[] bArr = dtvCcPacket2.f9244c;
        int i4 = dtvCcPacket2.f9245d;
        ParsableBitArray parsableBitArray = this.f9221i;
        parsableBitArray.k(i4, bArr);
        boolean z3 = false;
        while (true) {
            if (parsableBitArray.b() > 0) {
                int i5 = 3;
                int iG = parsableBitArray.g(3);
                int iG2 = parsableBitArray.g(5);
                if (iG == 7) {
                    parsableBitArray.o(i3);
                    iG = parsableBitArray.g(6);
                    if (iG < 7) {
                        android.support.v4.media.a.r(iG, "Invalid extended service number: ", "Cea708Decoder");
                    }
                }
                if (iG2 == 0) {
                    if (iG != 0) {
                        Log.h("Cea708Decoder", "serviceNumber is non-zero (" + iG + ") when blockSize is 0");
                    }
                } else if (iG != this.f9223k) {
                    parsableBitArray.p(iG2);
                } else {
                    int iE = (iG2 * 8) + parsableBitArray.e();
                    while (parsableBitArray.e() < iE) {
                        int iG3 = parsableBitArray.g(8);
                        if (iG3 != 16) {
                            if (iG3 <= 31) {
                                if (iG3 != 0) {
                                    if (iG3 == i5) {
                                        this.n = l();
                                    } else if (iG3 != 8) {
                                        switch (iG3) {
                                            case 12:
                                                m();
                                                break;
                                            case 13:
                                                this.f9225m.a('\n');
                                                break;
                                            case 14:
                                                break;
                                            default:
                                                if (iG3 < 17 || iG3 > 23) {
                                                    if (iG3 < 24 || iG3 > 31) {
                                                        android.support.v4.media.a.r(iG3, "Invalid C0 command: ", "Cea708Decoder");
                                                        break;
                                                    } else {
                                                        Log.h("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + iG3);
                                                        parsableBitArray.o(16);
                                                        break;
                                                    }
                                                } else {
                                                    Log.h("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + iG3);
                                                    parsableBitArray.o(8);
                                                    break;
                                                }
                                        }
                                    } else {
                                        SpannableStringBuilder spannableStringBuilder = this.f9225m.f9230b;
                                        int length = spannableStringBuilder.length();
                                        if (length > 0) {
                                            spannableStringBuilder.delete(length - 1, length);
                                        }
                                    }
                                }
                                i2 = i3;
                            } else if (iG3 <= 127) {
                                if (iG3 == 127) {
                                    this.f9225m.a((char) 9835);
                                } else {
                                    this.f9225m.a((char) (iG3 & 255));
                                }
                                i2 = i3;
                                z3 = true;
                            } else {
                                if (iG3 <= 159) {
                                    CueInfoBuilder[] cueInfoBuilderArr = this.f9224l;
                                    switch (iG3) {
                                        case 128:
                                        case WKSRecord.Service.PWDGEN /* 129 */:
                                        case WKSRecord.Service.CISCO_FNA /* 130 */:
                                        case WKSRecord.Service.CISCO_TNA /* 131 */:
                                        case WKSRecord.Service.CISCO_SYS /* 132 */:
                                        case WKSRecord.Service.STATSRV /* 133 */:
                                        case WKSRecord.Service.INGRES_NET /* 134 */:
                                        case WKSRecord.Service.LOC_SRV /* 135 */:
                                            z2 = false;
                                            z = true;
                                            int i6 = iG3 - 128;
                                            if (this.q != i6) {
                                                this.q = i6;
                                                this.f9225m = cueInfoBuilderArr[i6];
                                                break;
                                            }
                                            break;
                                        case WKSRecord.Service.PROFILE /* 136 */:
                                            z = true;
                                            for (int i7 = 1; i7 <= 8; i7++) {
                                                if (parsableBitArray.f()) {
                                                    CueInfoBuilder cueInfoBuilder = cueInfoBuilderArr[8 - i7];
                                                    cueInfoBuilder.f9229a.clear();
                                                    cueInfoBuilder.f9230b.clear();
                                                    cueInfoBuilder.o = -1;
                                                    cueInfoBuilder.p = -1;
                                                    cueInfoBuilder.q = -1;
                                                    cueInfoBuilder.s = -1;
                                                    cueInfoBuilder.u = 0;
                                                }
                                            }
                                            z2 = false;
                                            break;
                                        case WKSRecord.Service.NETBIOS_NS /* 137 */:
                                            for (int i8 = 1; i8 <= 8; i8++) {
                                                if (parsableBitArray.f()) {
                                                    cueInfoBuilderArr[8 - i8].f9232d = true;
                                                }
                                            }
                                            z = true;
                                            z2 = false;
                                            break;
                                        case WKSRecord.Service.NETBIOS_DGM /* 138 */:
                                            for (int i9 = 1; i9 <= 8; i9++) {
                                                if (parsableBitArray.f()) {
                                                    cueInfoBuilderArr[8 - i9].f9232d = false;
                                                }
                                            }
                                            z2 = false;
                                            z = true;
                                            break;
                                        case WKSRecord.Service.NETBIOS_SSN /* 139 */:
                                            for (int i10 = 1; i10 <= 8; i10++) {
                                                if (parsableBitArray.f()) {
                                                    cueInfoBuilderArr[8 - i10].f9232d = !r3.f9232d;
                                                }
                                            }
                                            z2 = false;
                                            z = true;
                                            break;
                                        case WKSRecord.Service.EMFIS_DATA /* 140 */:
                                            for (int i11 = 1; i11 <= 8; i11++) {
                                                if (parsableBitArray.f()) {
                                                    cueInfoBuilderArr[8 - i11].d();
                                                }
                                            }
                                            z2 = false;
                                            z = true;
                                            break;
                                        case WKSRecord.Service.EMFIS_CNTL /* 141 */:
                                            parsableBitArray.o(8);
                                            z2 = false;
                                            z = true;
                                            break;
                                        case WKSRecord.Service.BL_IDM /* 142 */:
                                            z2 = false;
                                            z = true;
                                            break;
                                        case 143:
                                            m();
                                            z2 = false;
                                            z = true;
                                            break;
                                        case 144:
                                            if (!this.f9225m.f9231c) {
                                                parsableBitArray.o(16);
                                                z2 = false;
                                                i5 = 3;
                                                z = true;
                                                break;
                                            } else {
                                                parsableBitArray.g(4);
                                                parsableBitArray.g(2);
                                                parsableBitArray.g(2);
                                                boolean zF = parsableBitArray.f();
                                                boolean zF2 = parsableBitArray.f();
                                                i5 = 3;
                                                parsableBitArray.g(3);
                                                parsableBitArray.g(3);
                                                this.f9225m.e(zF, zF2);
                                                z2 = false;
                                                z = true;
                                            }
                                        case 145:
                                            if (this.f9225m.f9231c) {
                                                int iC = CueInfoBuilder.c(parsableBitArray.g(2), parsableBitArray.g(2), parsableBitArray.g(2), parsableBitArray.g(2));
                                                int iC2 = CueInfoBuilder.c(parsableBitArray.g(2), parsableBitArray.g(2), parsableBitArray.g(2), parsableBitArray.g(2));
                                                parsableBitArray.o(2);
                                                CueInfoBuilder.c(parsableBitArray.g(2), parsableBitArray.g(2), parsableBitArray.g(2), 0);
                                                this.f9225m.f(iC, iC2);
                                            } else {
                                                parsableBitArray.o(24);
                                            }
                                            z2 = false;
                                            i5 = 3;
                                            z = true;
                                            break;
                                        case 146:
                                            if (this.f9225m.f9231c) {
                                                parsableBitArray.o(4);
                                                int iG4 = parsableBitArray.g(4);
                                                parsableBitArray.o(2);
                                                parsableBitArray.g(6);
                                                CueInfoBuilder cueInfoBuilder2 = this.f9225m;
                                                if (cueInfoBuilder2.u != iG4) {
                                                    cueInfoBuilder2.a('\n');
                                                }
                                                cueInfoBuilder2.u = iG4;
                                            } else {
                                                parsableBitArray.o(16);
                                            }
                                            z2 = false;
                                            i5 = 3;
                                            z = true;
                                            break;
                                        case 147:
                                        case 148:
                                        case 149:
                                        case 150:
                                        default:
                                            android.support.v4.media.a.r(iG3, "Invalid C1 command: ", "Cea708Decoder");
                                            z2 = false;
                                            z = true;
                                            break;
                                        case 151:
                                            if (this.f9225m.f9231c) {
                                                int iC3 = CueInfoBuilder.c(parsableBitArray.g(2), parsableBitArray.g(2), parsableBitArray.g(2), parsableBitArray.g(2));
                                                parsableBitArray.g(2);
                                                CueInfoBuilder.c(parsableBitArray.g(2), parsableBitArray.g(2), parsableBitArray.g(2), 0);
                                                parsableBitArray.f();
                                                parsableBitArray.f();
                                                parsableBitArray.g(2);
                                                parsableBitArray.g(2);
                                                int iG5 = parsableBitArray.g(2);
                                                parsableBitArray.o(8);
                                                CueInfoBuilder cueInfoBuilder3 = this.f9225m;
                                                cueInfoBuilder3.n = iC3;
                                                cueInfoBuilder3.f9239k = iG5;
                                            } else {
                                                parsableBitArray.o(32);
                                            }
                                            z2 = false;
                                            i5 = 3;
                                            z = true;
                                            break;
                                        case ModuleDescriptor.MODULE_VERSION /* 152 */:
                                        case 153:
                                        case 154:
                                        case 155:
                                        case 156:
                                        case 157:
                                        case 158:
                                        case 159:
                                            int i12 = iG3 - 152;
                                            CueInfoBuilder cueInfoBuilder4 = cueInfoBuilderArr[i12];
                                            parsableBitArray.o(i3);
                                            boolean zF3 = parsableBitArray.f();
                                            parsableBitArray.o(i3);
                                            int iG6 = parsableBitArray.g(i5);
                                            boolean zF4 = parsableBitArray.f();
                                            int iG7 = parsableBitArray.g(7);
                                            int iG8 = parsableBitArray.g(8);
                                            int iG9 = parsableBitArray.g(4);
                                            int iG10 = parsableBitArray.g(4);
                                            parsableBitArray.o(i3);
                                            parsableBitArray.o(6);
                                            parsableBitArray.o(i3);
                                            int iG11 = parsableBitArray.g(3);
                                            int iG12 = parsableBitArray.g(3);
                                            cueInfoBuilder4.f9231c = true;
                                            cueInfoBuilder4.f9232d = zF3;
                                            cueInfoBuilder4.f9233e = iG6;
                                            cueInfoBuilder4.f9234f = zF4;
                                            cueInfoBuilder4.f9235g = iG7;
                                            cueInfoBuilder4.f9236h = iG8;
                                            cueInfoBuilder4.f9237i = iG9;
                                            int i13 = iG10 + 1;
                                            if (cueInfoBuilder4.f9238j != i13) {
                                                cueInfoBuilder4.f9238j = i13;
                                                while (true) {
                                                    ArrayList arrayList = cueInfoBuilder4.f9229a;
                                                    if (arrayList.size() >= cueInfoBuilder4.f9238j || arrayList.size() >= 15) {
                                                        arrayList.remove(0);
                                                    }
                                                }
                                            }
                                            if (iG11 != 0 && cueInfoBuilder4.f9240l != iG11) {
                                                cueInfoBuilder4.f9240l = iG11;
                                                int i14 = iG11 - 1;
                                                int i15 = CueInfoBuilder.B[i14];
                                                boolean z4 = CueInfoBuilder.A[i14];
                                                int i16 = CueInfoBuilder.y[i14];
                                                int i17 = CueInfoBuilder.z[i14];
                                                int i18 = CueInfoBuilder.x[i14];
                                                cueInfoBuilder4.n = i15;
                                                cueInfoBuilder4.f9239k = i18;
                                            }
                                            if (iG12 != 0 && cueInfoBuilder4.f9241m != iG12) {
                                                cueInfoBuilder4.f9241m = iG12;
                                                int i19 = iG12 - 1;
                                                int i20 = CueInfoBuilder.D[i19];
                                                int i21 = CueInfoBuilder.C[i19];
                                                cueInfoBuilder4.e(false, false);
                                                cueInfoBuilder4.f(CueInfoBuilder.v, CueInfoBuilder.E[i19]);
                                            }
                                            if (this.q != i12) {
                                                this.q = i12;
                                                this.f9225m = cueInfoBuilderArr[i12];
                                            }
                                            z2 = false;
                                            i5 = 3;
                                            z = true;
                                            break;
                                    }
                                } else {
                                    z2 = false;
                                    z = true;
                                    if (iG3 <= 255) {
                                        this.f9225m.a((char) (iG3 & 255));
                                    } else {
                                        android.support.v4.media.a.r(iG3, "Invalid base command: ", "Cea708Decoder");
                                        i2 = 2;
                                        c2 = 7;
                                    }
                                }
                                z3 = z;
                                i2 = 2;
                                c2 = 7;
                            }
                            z = true;
                            c2 = 7;
                        } else {
                            z = true;
                            int iG13 = parsableBitArray.g(8);
                            if (iG13 <= 31) {
                                c2 = 7;
                                if (iG13 > 7) {
                                    if (iG13 <= 15) {
                                        parsableBitArray.o(8);
                                    } else if (iG13 <= 23) {
                                        parsableBitArray.o(16);
                                    } else if (iG13 <= 31) {
                                        parsableBitArray.o(24);
                                    }
                                }
                            } else {
                                c2 = 7;
                                if (iG13 <= 127) {
                                    if (iG13 == 32) {
                                        this.f9225m.a(' ');
                                    } else if (iG13 == 33) {
                                        this.f9225m.a((char) 160);
                                    } else if (iG13 == 37) {
                                        this.f9225m.a((char) 8230);
                                    } else if (iG13 == 42) {
                                        this.f9225m.a((char) 352);
                                    } else if (iG13 == 44) {
                                        this.f9225m.a((char) 338);
                                    } else if (iG13 == 63) {
                                        this.f9225m.a((char) 376);
                                    } else if (iG13 == 57) {
                                        this.f9225m.a((char) 8482);
                                    } else if (iG13 == 58) {
                                        this.f9225m.a((char) 353);
                                    } else if (iG13 == 60) {
                                        this.f9225m.a((char) 339);
                                    } else if (iG13 != 61) {
                                        switch (iG13) {
                                            case Type.DNSKEY /* 48 */:
                                                this.f9225m.a((char) 9608);
                                                break;
                                            case 49:
                                                this.f9225m.a((char) 8216);
                                                break;
                                            case 50:
                                                this.f9225m.a((char) 8217);
                                                break;
                                            case 51:
                                                this.f9225m.a((char) 8220);
                                                break;
                                            case Type.TLSA /* 52 */:
                                                this.f9225m.a((char) 8221);
                                                break;
                                            case 53:
                                                this.f9225m.a((char) 8226);
                                                break;
                                            default:
                                                switch (iG13) {
                                                    case 118:
                                                        this.f9225m.a((char) 8539);
                                                        break;
                                                    case WKSRecord.Service.NNTP /* 119 */:
                                                        this.f9225m.a((char) 8540);
                                                        break;
                                                    case 120:
                                                        this.f9225m.a((char) 8541);
                                                        break;
                                                    case WKSRecord.Service.ERPC /* 121 */:
                                                        this.f9225m.a((char) 8542);
                                                        break;
                                                    case 122:
                                                        this.f9225m.a((char) 9474);
                                                        break;
                                                    case WKSRecord.Service.NTP /* 123 */:
                                                        this.f9225m.a((char) 9488);
                                                        break;
                                                    case 124:
                                                        this.f9225m.a((char) 9492);
                                                        break;
                                                    case WKSRecord.Service.LOCUS_MAP /* 125 */:
                                                        this.f9225m.a((char) 9472);
                                                        break;
                                                    case 126:
                                                        this.f9225m.a((char) 9496);
                                                        break;
                                                    case WKSRecord.Service.LOCUS_CON /* 127 */:
                                                        this.f9225m.a((char) 9484);
                                                        break;
                                                    default:
                                                        android.support.v4.media.a.r(iG13, "Invalid G2 character: ", "Cea708Decoder");
                                                        break;
                                                }
                                        }
                                    } else {
                                        this.f9225m.a((char) 8480);
                                    }
                                    z3 = true;
                                } else if (iG13 > 159) {
                                    i2 = 2;
                                    if (iG13 <= 255) {
                                        if (iG13 == 160) {
                                            this.f9225m.a((char) 13252);
                                        } else {
                                            android.support.v4.media.a.r(iG13, "Invalid G3 character: ", "Cea708Decoder");
                                            this.f9225m.a('_');
                                        }
                                        z3 = true;
                                    } else {
                                        android.support.v4.media.a.r(iG13, "Invalid extended command: ", "Cea708Decoder");
                                    }
                                } else if (iG13 <= 135) {
                                    parsableBitArray.o(32);
                                } else if (iG13 <= 143) {
                                    parsableBitArray.o(40);
                                } else if (iG13 <= 159) {
                                    i2 = 2;
                                    parsableBitArray.o(2);
                                    parsableBitArray.o(parsableBitArray.g(6) * 8);
                                }
                            }
                            i2 = 2;
                        }
                        i3 = i2;
                    }
                }
            }
        }
        if (z3) {
            this.n = l();
        }
        this.p = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List l() {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.cea.Cea708Decoder.l():java.util.List");
    }

    public final void m() {
        for (int i2 = 0; i2 < 8; i2++) {
            this.f9224l[i2].d();
        }
    }

    @Override // androidx.media3.extractor.text.cea.CeaDecoder, androidx.media3.decoder.Decoder
    public final /* bridge */ /* synthetic */ void release() {
    }
}
