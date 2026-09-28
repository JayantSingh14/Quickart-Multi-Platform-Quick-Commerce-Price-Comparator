package androidx.media3.extractor.text.dvb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import org.xbill.DNS.WKSRecord;

@UnstableApi
/* loaded from: classes3.dex */
public final class DvbParser implements SubtitleParser {

    /* renamed from: h, reason: collision with root package name */
    public static final byte[] f9257h = {0, 7, 8, 15};

    /* renamed from: i, reason: collision with root package name */
    public static final byte[] f9258i = {0, 119, -120, -1};

    /* renamed from: j, reason: collision with root package name */
    public static final byte[] f9259j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f9260a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f9261b;

    /* renamed from: c, reason: collision with root package name */
    public final Canvas f9262c;

    /* renamed from: d, reason: collision with root package name */
    public final DisplayDefinition f9263d;

    /* renamed from: e, reason: collision with root package name */
    public final ClutDefinition f9264e;

    /* renamed from: f, reason: collision with root package name */
    public final SubtitleService f9265f;

    /* renamed from: g, reason: collision with root package name */
    public Bitmap f9266g;

    public static final class ClutDefinition {

        /* renamed from: a, reason: collision with root package name */
        public final int f9267a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f9268b;

        /* renamed from: c, reason: collision with root package name */
        public final int[] f9269c;

        /* renamed from: d, reason: collision with root package name */
        public final int[] f9270d;

        public ClutDefinition(int i2, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f9267a = i2;
            this.f9268b = iArr;
            this.f9269c = iArr2;
            this.f9270d = iArr3;
        }
    }

    public static final class DisplayDefinition {

        /* renamed from: a, reason: collision with root package name */
        public final int f9271a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9272b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9273c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9274d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9275e;

        /* renamed from: f, reason: collision with root package name */
        public final int f9276f;

        public DisplayDefinition(int i2, int i3, int i4, int i5, int i6, int i7) {
            this.f9271a = i2;
            this.f9272b = i3;
            this.f9273c = i4;
            this.f9274d = i5;
            this.f9275e = i6;
            this.f9276f = i7;
        }
    }

    public static final class ObjectData {

        /* renamed from: a, reason: collision with root package name */
        public final int f9277a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9278b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f9279c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f9280d;

        public ObjectData(int i2, boolean z, byte[] bArr, byte[] bArr2) {
            this.f9277a = i2;
            this.f9278b = z;
            this.f9279c = bArr;
            this.f9280d = bArr2;
        }
    }

    public static final class PageComposition {

        /* renamed from: a, reason: collision with root package name */
        public final int f9281a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9282b;

        /* renamed from: c, reason: collision with root package name */
        public final SparseArray f9283c;

        public PageComposition(int i2, int i3, SparseArray sparseArray) {
            this.f9281a = i2;
            this.f9282b = i3;
            this.f9283c = sparseArray;
        }
    }

    public static final class PageRegion {

        /* renamed from: a, reason: collision with root package name */
        public final int f9284a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9285b;

        public PageRegion(int i2, int i3) {
            this.f9284a = i2;
            this.f9285b = i3;
        }
    }

    public static final class RegionComposition {

        /* renamed from: a, reason: collision with root package name */
        public final int f9286a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9287b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9288c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9289d;

        /* renamed from: e, reason: collision with root package name */
        public final int f9290e;

        /* renamed from: f, reason: collision with root package name */
        public final int f9291f;

        /* renamed from: g, reason: collision with root package name */
        public final int f9292g;

        /* renamed from: h, reason: collision with root package name */
        public final int f9293h;

        /* renamed from: i, reason: collision with root package name */
        public final int f9294i;

        /* renamed from: j, reason: collision with root package name */
        public final SparseArray f9295j;

        public RegionComposition(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray sparseArray) {
            this.f9286a = i2;
            this.f9287b = z;
            this.f9288c = i3;
            this.f9289d = i4;
            this.f9290e = i5;
            this.f9291f = i6;
            this.f9292g = i7;
            this.f9293h = i8;
            this.f9294i = i9;
            this.f9295j = sparseArray;
        }
    }

    public static final class RegionObject {

        /* renamed from: a, reason: collision with root package name */
        public final int f9296a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9297b;

        public RegionObject(int i2, int i3) {
            this.f9296a = i2;
            this.f9297b = i3;
        }
    }

    public static final class SubtitleService {

        /* renamed from: a, reason: collision with root package name */
        public final int f9298a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9299b;

        /* renamed from: c, reason: collision with root package name */
        public final SparseArray f9300c = new SparseArray();

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray f9301d = new SparseArray();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray f9302e = new SparseArray();

        /* renamed from: f, reason: collision with root package name */
        public final SparseArray f9303f = new SparseArray();

        /* renamed from: g, reason: collision with root package name */
        public final SparseArray f9304g = new SparseArray();

        /* renamed from: h, reason: collision with root package name */
        public DisplayDefinition f9305h;

        /* renamed from: i, reason: collision with root package name */
        public PageComposition f9306i;

        public SubtitleService(int i2, int i3) {
            this.f9298a = i2;
            this.f9299b = i3;
        }
    }

    public DvbParser(List list) {
        ParsableByteArray parsableByteArray = new ParsableByteArray((byte[]) list.get(0));
        int iD = parsableByteArray.D();
        int iD2 = parsableByteArray.D();
        Paint paint = new Paint();
        this.f9260a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f9261b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f9262c = new Canvas();
        this.f9263d = new DisplayDefinition(719, 575, 0, 719, 0, 575);
        this.f9264e = new ClutDefinition(0, new int[]{0, -1, -16777216, -8421505}, e(), f());
        this.f9265f = new SubtitleService(iD, iD2);
    }

    public static byte[] d(int i2, int i3, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) parsableBitArray.g(i3);
        }
        return bArr;
    }

    public static int[] e() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = g(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                int i3 = i2 & 1;
                int i4 = WKSRecord.Service.LOCUS_CON;
                int i5 = i3 != 0 ? 127 : 0;
                int i6 = (i2 & 2) != 0 ? 127 : 0;
                if ((i2 & 4) == 0) {
                    i4 = 0;
                }
                iArr[i2] = g(255, i5, i6, i4);
            }
        }
        return iArr;
    }

    public static int[] f() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = g(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & WKSRecord.Service.PROFILE;
                if (i3 == 0) {
                    iArr[i2] = g(255, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 8) {
                    iArr[i2] = g(WKSRecord.Service.LOCUS_CON, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 128) {
                    iArr[i2] = g(255, ((i2 & 1) != 0 ? 43 : 0) + WKSRecord.Service.LOCUS_CON + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + WKSRecord.Service.LOCUS_CON + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + WKSRecord.Service.LOCUS_CON + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = g(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int g(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01fe A[LOOP:3: B:86:0x0166->B:116:0x01fe, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(byte[] r22, int[] r23, int r24, int r25, int r26, android.graphics.Paint r27, android.graphics.Canvas r28) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.dvb.DvbParser.h(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    public static ClutDefinition i(ParsableBitArray parsableBitArray, int i2) {
        int iG;
        int i3;
        int iG2;
        int iG3;
        int iG4;
        int i4 = 8;
        int iG5 = parsableBitArray.g(8);
        parsableBitArray.o(8);
        int i5 = 2;
        int i6 = i2 - 2;
        int i7 = 0;
        int[] iArr = {0, -1, -16777216, -8421505};
        int[] iArrE = e();
        int[] iArrF = f();
        while (i6 > 0) {
            int iG6 = parsableBitArray.g(i4);
            int iG7 = parsableBitArray.g(i4);
            int[] iArr2 = (iG7 & 128) != 0 ? iArr : (iG7 & 64) != 0 ? iArrE : iArrF;
            if ((iG7 & 1) != 0) {
                iG3 = parsableBitArray.g(i4);
                iG4 = parsableBitArray.g(i4);
                iG = parsableBitArray.g(i4);
                iG2 = parsableBitArray.g(i4);
                i3 = i6 - 6;
            } else {
                int iG8 = parsableBitArray.g(6) << i5;
                int iG9 = parsableBitArray.g(4) << 4;
                iG = parsableBitArray.g(4) << 4;
                i3 = i6 - 4;
                iG2 = parsableBitArray.g(i5) << 6;
                iG3 = iG8;
                iG4 = iG9;
            }
            if (iG3 == 0) {
                iG4 = i7;
                iG = iG4;
                iG2 = 255;
            }
            double d2 = iG3;
            double d3 = iG4 - 128;
            double d4 = iG - 128;
            iArr2[iG6] = g((byte) (255 - (iG2 & 255)), Util.k((int) ((1.402d * d3) + d2), 0, 255), Util.k((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), Util.k((int) ((d4 * 1.772d) + d2), 0, 255));
            i6 = i3;
            i7 = 0;
            iG5 = iG5;
            iArrF = iArrF;
            i4 = 8;
            i5 = 2;
        }
        return new ClutDefinition(iG5, iArr, iArrE, iArrF);
    }

    public static ObjectData j(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int iG = parsableBitArray.g(16);
        parsableBitArray.o(4);
        int iG2 = parsableBitArray.g(2);
        boolean zF = parsableBitArray.f();
        parsableBitArray.o(1);
        byte[] bArr2 = Util.f5749f;
        if (iG2 != 1) {
            if (iG2 == 0) {
                int iG3 = parsableBitArray.g(16);
                int iG4 = parsableBitArray.g(16);
                if (iG3 > 0) {
                    bArr2 = new byte[iG3];
                    parsableBitArray.j(iG3, bArr2);
                }
                if (iG4 > 0) {
                    bArr = new byte[iG4];
                    parsableBitArray.j(iG4, bArr);
                }
            }
            return new ObjectData(iG, zF, bArr2, bArr);
        }
        parsableBitArray.o(parsableBitArray.g(8) * 16);
        bArr = bArr2;
        return new ObjectData(iG, zF, bArr2, bArr);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void b(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        boolean z;
        SubtitleService subtitleService;
        CuesWithTiming cuesWithTiming;
        int i4;
        char c2;
        char c3;
        char c4;
        int i5;
        ArrayList arrayList;
        int i6;
        SubtitleService subtitleService2;
        RegionComposition regionComposition;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        RegionComposition regionComposition2;
        int iG;
        int iG2;
        int i12;
        int iG3;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr, i2 + i3);
        parsableBitArray.m(i2);
        while (true) {
            int iB = parsableBitArray.b();
            z = true;
            subtitleService = this.f9265f;
            if (iB >= 48 && parsableBitArray.g(8) == 15) {
                int iG4 = parsableBitArray.g(8);
                int iG5 = parsableBitArray.g(16);
                int iG6 = parsableBitArray.g(16);
                int iD = parsableBitArray.d() + iG6;
                if (iG6 * 8 > parsableBitArray.b()) {
                    Log.h("DvbParser", "Data field length exceeds limit");
                    parsableBitArray.o(parsableBitArray.b());
                } else {
                    switch (iG4) {
                        case 16:
                            if (iG5 == subtitleService.f9298a) {
                                PageComposition pageComposition = subtitleService.f9306i;
                                parsableBitArray.g(8);
                                int iG7 = parsableBitArray.g(4);
                                int iG8 = parsableBitArray.g(2);
                                parsableBitArray.o(2);
                                int i13 = iG6 - 2;
                                SparseArray sparseArray = new SparseArray();
                                while (i13 > 0) {
                                    int iG9 = parsableBitArray.g(8);
                                    parsableBitArray.o(8);
                                    i13 -= 6;
                                    sparseArray.put(iG9, new PageRegion(parsableBitArray.g(16), parsableBitArray.g(16)));
                                }
                                PageComposition pageComposition2 = new PageComposition(iG7, iG8, sparseArray);
                                if (iG8 == 0) {
                                    if (pageComposition != null && pageComposition.f9281a != iG7) {
                                        subtitleService.f9306i = pageComposition2;
                                        break;
                                    }
                                } else {
                                    subtitleService.f9306i = pageComposition2;
                                    subtitleService.f9300c.clear();
                                    subtitleService.f9301d.clear();
                                    subtitleService.f9302e.clear();
                                    break;
                                }
                            }
                            break;
                        case 17:
                            PageComposition pageComposition3 = subtitleService.f9306i;
                            if (iG5 == subtitleService.f9298a && pageComposition3 != null) {
                                int iG10 = parsableBitArray.g(8);
                                parsableBitArray.o(4);
                                boolean zF = parsableBitArray.f();
                                parsableBitArray.o(3);
                                int iG11 = parsableBitArray.g(16);
                                int iG12 = parsableBitArray.g(16);
                                parsableBitArray.g(3);
                                int iG13 = parsableBitArray.g(3);
                                parsableBitArray.o(2);
                                int iG14 = parsableBitArray.g(8);
                                int iG15 = parsableBitArray.g(8);
                                int iG16 = parsableBitArray.g(4);
                                int iG17 = parsableBitArray.g(2);
                                parsableBitArray.o(2);
                                int i14 = iG6 - 10;
                                SparseArray sparseArray2 = new SparseArray();
                                while (i14 > 0) {
                                    int iG18 = parsableBitArray.g(16);
                                    int iG19 = parsableBitArray.g(2);
                                    parsableBitArray.g(2);
                                    int iG20 = parsableBitArray.g(12);
                                    parsableBitArray.o(4);
                                    int iG21 = parsableBitArray.g(12);
                                    int i15 = i14 - 6;
                                    if (iG19 == 1 || iG19 == 2) {
                                        parsableBitArray.g(8);
                                        parsableBitArray.g(8);
                                        i14 -= 8;
                                    } else {
                                        i14 = i15;
                                    }
                                    sparseArray2.put(iG18, new RegionObject(iG20, iG21));
                                }
                                RegionComposition regionComposition3 = new RegionComposition(iG10, zF, iG11, iG12, iG13, iG14, iG15, iG16, iG17, sparseArray2);
                                SparseArray sparseArray3 = subtitleService.f9300c;
                                if (pageComposition3.f9282b == 0 && (regionComposition2 = (RegionComposition) sparseArray3.get(iG10)) != null) {
                                    int i16 = 0;
                                    while (true) {
                                        SparseArray sparseArray4 = regionComposition2.f9295j;
                                        if (i16 < sparseArray4.size()) {
                                            regionComposition3.f9295j.put(sparseArray4.keyAt(i16), (RegionObject) sparseArray4.valueAt(i16));
                                            i16++;
                                        }
                                    }
                                }
                                sparseArray3.put(regionComposition3.f9286a, regionComposition3);
                                break;
                            }
                            break;
                        case 18:
                            if (iG5 != subtitleService.f9298a) {
                                if (iG5 == subtitleService.f9299b) {
                                    ClutDefinition clutDefinitionI = i(parsableBitArray, iG6);
                                    subtitleService.f9303f.put(clutDefinitionI.f9267a, clutDefinitionI);
                                    break;
                                }
                            } else {
                                ClutDefinition clutDefinitionI2 = i(parsableBitArray, iG6);
                                subtitleService.f9301d.put(clutDefinitionI2.f9267a, clutDefinitionI2);
                                break;
                            }
                            break;
                        case 19:
                            if (iG5 != subtitleService.f9298a) {
                                if (iG5 == subtitleService.f9299b) {
                                    ObjectData objectDataJ = j(parsableBitArray);
                                    subtitleService.f9304g.put(objectDataJ.f9277a, objectDataJ);
                                    break;
                                }
                            } else {
                                ObjectData objectDataJ2 = j(parsableBitArray);
                                subtitleService.f9302e.put(objectDataJ2.f9277a, objectDataJ2);
                                break;
                            }
                            break;
                        case 20:
                            if (iG5 == subtitleService.f9298a) {
                                parsableBitArray.o(4);
                                boolean zF2 = parsableBitArray.f();
                                parsableBitArray.o(3);
                                int iG22 = parsableBitArray.g(16);
                                int iG23 = parsableBitArray.g(16);
                                if (zF2) {
                                    int iG24 = parsableBitArray.g(16);
                                    iG = parsableBitArray.g(16);
                                    iG3 = parsableBitArray.g(16);
                                    iG2 = parsableBitArray.g(16);
                                    i12 = iG24;
                                } else {
                                    iG = iG22;
                                    iG2 = iG23;
                                    i12 = 0;
                                    iG3 = 0;
                                }
                                subtitleService.f9305h = new DisplayDefinition(iG22, iG23, i12, iG, iG3, iG2);
                                break;
                            }
                            break;
                    }
                    parsableBitArray.p(iD - parsableBitArray.d());
                }
            }
        }
        PageComposition pageComposition4 = subtitleService.f9306i;
        if (pageComposition4 == null) {
            cuesWithTiming = new CuesWithTiming(ImmutableList.r(), -9223372036854775807L, -9223372036854775807L);
        } else {
            DisplayDefinition displayDefinition = subtitleService.f9305h;
            if (displayDefinition == null) {
                displayDefinition = this.f9263d;
            }
            Bitmap bitmap = this.f9266g;
            Canvas canvas = this.f9262c;
            if (bitmap == null || displayDefinition.f9271a + 1 != bitmap.getWidth() || displayDefinition.f9272b + 1 != this.f9266g.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(displayDefinition.f9271a + 1, displayDefinition.f9272b + 1, Bitmap.Config.ARGB_8888);
                this.f9266g = bitmapCreateBitmap;
                canvas.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList2 = new ArrayList();
            int i17 = 0;
            while (true) {
                SparseArray sparseArray5 = pageComposition4.f9283c;
                if (i17 < sparseArray5.size()) {
                    canvas.save();
                    PageRegion pageRegion = (PageRegion) sparseArray5.valueAt(i17);
                    RegionComposition regionComposition4 = (RegionComposition) subtitleService.f9300c.get(sparseArray5.keyAt(i17));
                    int i18 = pageRegion.f9284a + displayDefinition.f9273c;
                    int i19 = pageRegion.f9285b + displayDefinition.f9275e;
                    int iMin = Math.min(regionComposition4.f9288c + i18, displayDefinition.f9274d);
                    int i20 = regionComposition4.f9289d;
                    int i21 = i19 + i20;
                    boolean z2 = z;
                    canvas.clipRect(i18, i19, iMin, Math.min(i21, displayDefinition.f9276f));
                    SparseArray sparseArray6 = subtitleService.f9301d;
                    int i22 = regionComposition4.f9291f;
                    ClutDefinition clutDefinition = (ClutDefinition) sparseArray6.get(i22);
                    if (clutDefinition == null && (clutDefinition = (ClutDefinition) subtitleService.f9303f.get(i22)) == null) {
                        clutDefinition = this.f9264e;
                    }
                    int i23 = 0;
                    while (true) {
                        SparseArray sparseArray7 = regionComposition4.f9295j;
                        if (i23 < sparseArray7.size()) {
                            int iKeyAt = sparseArray7.keyAt(i23);
                            RegionObject regionObject = (RegionObject) sparseArray7.valueAt(i23);
                            PageComposition pageComposition5 = pageComposition4;
                            ObjectData objectData = (ObjectData) subtitleService.f9302e.get(iKeyAt);
                            if (objectData == null) {
                                objectData = (ObjectData) subtitleService.f9304g.get(iKeyAt);
                            }
                            if (objectData != null) {
                                Paint paint = objectData.f9278b ? null : this.f9260a;
                                int i24 = regionObject.f9296a + i18;
                                int i25 = regionObject.f9297b + i19;
                                int i26 = i18;
                                int i27 = regionComposition4.f9290e;
                                int i28 = i19;
                                int[] iArr = i27 == 3 ? clutDefinition.f9270d : i27 == 2 ? clutDefinition.f9269c : clutDefinition.f9268b;
                                regionComposition = regionComposition4;
                                i9 = i23;
                                i8 = i26;
                                subtitleService2 = subtitleService;
                                i10 = i20;
                                arrayList = arrayList2;
                                i11 = i21;
                                i6 = i17;
                                i7 = i28;
                                h(objectData.f9279c, iArr, i27, i24, i25, paint, canvas);
                                h(objectData.f9280d, iArr, i27, i24, i25 + 1, paint, canvas);
                            } else {
                                arrayList = arrayList2;
                                i6 = i17;
                                subtitleService2 = subtitleService;
                                regionComposition = regionComposition4;
                                i7 = i19;
                                i8 = i18;
                                i9 = i23;
                                i10 = i20;
                                i11 = i21;
                            }
                            i23 = i9 + 1;
                            regionComposition4 = regionComposition;
                            i21 = i11;
                            i18 = i8;
                            i19 = i7;
                            i20 = i10;
                            pageComposition4 = pageComposition5;
                            i17 = i6;
                            subtitleService = subtitleService2;
                            arrayList2 = arrayList;
                        } else {
                            PageComposition pageComposition6 = pageComposition4;
                            ArrayList arrayList3 = arrayList2;
                            int i29 = i17;
                            SubtitleService subtitleService3 = subtitleService;
                            RegionComposition regionComposition5 = regionComposition4;
                            int i30 = i19;
                            int i31 = i18;
                            int i32 = i20;
                            int i33 = i21;
                            boolean z3 = regionComposition5.f9287b;
                            int i34 = regionComposition5.f9288c;
                            if (z3) {
                                int i35 = regionComposition5.f9290e;
                                if (i35 == 3) {
                                    i5 = clutDefinition.f9270d[regionComposition5.f9292g];
                                    c4 = 2;
                                } else {
                                    c4 = 2;
                                    i5 = i35 == 2 ? clutDefinition.f9269c[regionComposition5.f9293h] : clutDefinition.f9268b[regionComposition5.f9294i];
                                }
                                Paint paint2 = this.f9261b;
                                paint2.setColor(i5);
                                c3 = 3;
                                c2 = c4;
                                i4 = i34;
                                canvas.drawRect(i31, i30, i31 + i34, i33, paint2);
                            } else {
                                i4 = i34;
                                c2 = 2;
                                c3 = 3;
                            }
                            Cue.Builder builder = new Cue.Builder();
                            builder.f5626b = Bitmap.createBitmap(this.f9266g, i31, i30, i4, i32);
                            float f2 = displayDefinition.f9271a;
                            builder.f5632h = i31 / f2;
                            builder.f5633i = 0;
                            float f3 = displayDefinition.f9272b;
                            builder.f5629e = i30 / f3;
                            builder.f5630f = 0;
                            builder.f5631g = 0;
                            builder.f5636l = i4 / f2;
                            builder.f5637m = i32 / f3;
                            arrayList3.add(builder.a());
                            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                            canvas.restore();
                            i17 = i29 + 1;
                            z = z2;
                            arrayList2 = arrayList3;
                            subtitleService = subtitleService3;
                            pageComposition4 = pageComposition6;
                        }
                    }
                } else {
                    cuesWithTiming = new CuesWithTiming(arrayList2, -9223372036854775807L, -9223372036854775807L);
                }
            }
        }
        consumer.accept(cuesWithTiming);
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final int c() {
        return 2;
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void reset() {
        SubtitleService subtitleService = this.f9265f;
        subtitleService.f9300c.clear();
        subtitleService.f9301d.clear();
        subtitleService.f9302e.clear();
        subtitleService.f9303f.clear();
        subtitleService.f9304g.clear();
        subtitleService.f9305h = null;
        subtitleService.f9306i = null;
    }
}
