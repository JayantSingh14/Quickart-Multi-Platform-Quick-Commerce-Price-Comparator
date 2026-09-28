package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.NalUnitUtil;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class HevcConfig {

    /* renamed from: a, reason: collision with root package name */
    public final List f8570a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8571b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8572c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8573d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8574e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8575f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8576g;

    /* renamed from: h, reason: collision with root package name */
    public final float f8577h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8578i;

    /* renamed from: j, reason: collision with root package name */
    public final String f8579j;

    public HevcConfig(List list, int i2, int i3, int i4, int i5, int i6, int i7, float f2, int i8, String str) {
        this.f8570a = list;
        this.f8571b = i2;
        this.f8572c = i3;
        this.f8573d = i4;
        this.f8574e = i5;
        this.f8575f = i6;
        this.f8576g = i7;
        this.f8577h = f2;
        this.f8578i = i8;
        this.f8579j = str;
    }

    public static HevcConfig a(ParsableByteArray parsableByteArray) throws ParserException {
        boolean z;
        int i2;
        try {
            parsableByteArray.K(21);
            int iX = parsableByteArray.x() & 3;
            int iX2 = parsableByteArray.x();
            int i3 = parsableByteArray.f5724b;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                z = true;
                if (i5 >= iX2) {
                    break;
                }
                parsableByteArray.K(1);
                int iD = parsableByteArray.D();
                for (int i7 = 0; i7 < iD; i7++) {
                    int iD2 = parsableByteArray.D();
                    i6 += iD2 + 4;
                    parsableByteArray.K(iD2);
                }
                i5++;
            }
            parsableByteArray.J(i3);
            byte[] bArr = new byte[i6];
            int i8 = -1;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            float f2 = 1.0f;
            String strA = null;
            int i14 = 0;
            int i15 = 0;
            while (i14 < iX2) {
                int iX3 = parsableByteArray.x() & 63;
                int iD3 = parsableByteArray.D();
                int i16 = i4;
                while (i16 < iD3) {
                    int iD4 = parsableByteArray.D();
                    boolean z2 = z;
                    int i17 = iX;
                    System.arraycopy(NalUnitUtil.f5779a, i4, bArr, i15, 4);
                    int i18 = i15 + 4;
                    System.arraycopy(parsableByteArray.f5723a, parsableByteArray.f5724b, bArr, i18, iD4);
                    if (iX3 == 33 && i16 == 0) {
                        NalUnitUtil.H265SpsData h265SpsDataC = NalUnitUtil.c(i18, bArr, i18 + iD4);
                        i8 = h265SpsDataC.f5787e + 8;
                        i9 = h265SpsDataC.f5788f + 8;
                        i10 = h265SpsDataC.f5795m;
                        int i19 = h265SpsDataC.n;
                        int i20 = h265SpsDataC.o;
                        i2 = iX2;
                        float f3 = h265SpsDataC.f5793k;
                        int i21 = h265SpsDataC.f5794l;
                        strA = CodecSpecificDataUtil.a(h265SpsDataC.f5783a, h265SpsDataC.f5784b, h265SpsDataC.f5785c, h265SpsDataC.f5786d, h265SpsDataC.f5789g, h265SpsDataC.f5790h);
                        f2 = f3;
                        i13 = i21;
                        i12 = i20;
                        i11 = i19;
                    } else {
                        i2 = iX2;
                    }
                    i15 = i18 + iD4;
                    parsableByteArray.K(iD4);
                    i16++;
                    z = z2;
                    iX = i17;
                    iX2 = i2;
                    i4 = 0;
                }
                i14++;
                i4 = 0;
            }
            return new HevcConfig(i6 == 0 ? Collections.EMPTY_LIST : Collections.singletonList(bArr), iX + 1, i8, i9, i10, i11, i12, f2, i13, strA);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.a(e2, "Error parsing HEVC config");
        }
    }
}
