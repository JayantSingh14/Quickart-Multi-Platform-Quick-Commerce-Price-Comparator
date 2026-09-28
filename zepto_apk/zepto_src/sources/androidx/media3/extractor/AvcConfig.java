package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.NalUnitUtil;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public final class AvcConfig {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f8469a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8470b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8471c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8472d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8473e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8474f;

    /* renamed from: g, reason: collision with root package name */
    public final int f8475g;

    /* renamed from: h, reason: collision with root package name */
    public final int f8476h;

    /* renamed from: i, reason: collision with root package name */
    public final int f8477i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8478j;

    /* renamed from: k, reason: collision with root package name */
    public final float f8479k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8480l;

    public AvcConfig(ArrayList arrayList, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f2, String str) {
        this.f8469a = arrayList;
        this.f8470b = i2;
        this.f8471c = i3;
        this.f8472d = i4;
        this.f8473e = i5;
        this.f8474f = i6;
        this.f8475g = i7;
        this.f8476h = i8;
        this.f8477i = i9;
        this.f8478j = i10;
        this.f8479k = f2;
        this.f8480l = str;
    }

    public static AvcConfig a(ParsableByteArray parsableByteArray) throws ParserException {
        byte[] bArr;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        float f2;
        int i8;
        int i9;
        try {
            parsableByteArray.K(4);
            int iX = (parsableByteArray.x() & 3) + 1;
            if (iX == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iX2 = parsableByteArray.x() & 31;
            int i10 = 0;
            while (true) {
                bArr = CodecSpecificDataUtil.f5663a;
                if (i10 >= iX2) {
                    break;
                }
                int iD = parsableByteArray.D();
                int i11 = parsableByteArray.f5724b;
                parsableByteArray.K(iD);
                byte[] bArr2 = parsableByteArray.f5723a;
                byte[] bArr3 = new byte[iD + 4];
                System.arraycopy(bArr, 0, bArr3, 0, 4);
                System.arraycopy(bArr2, i11, bArr3, 4, iD);
                arrayList.add(bArr3);
                i10++;
            }
            int iX3 = parsableByteArray.x();
            for (int i12 = 0; i12 < iX3; i12++) {
                int iD2 = parsableByteArray.D();
                int i13 = parsableByteArray.f5724b;
                parsableByteArray.K(iD2);
                byte[] bArr4 = parsableByteArray.f5723a;
                byte[] bArr5 = new byte[iD2 + 4];
                System.arraycopy(bArr, 0, bArr5, 0, 4);
                System.arraycopy(bArr4, i13, bArr5, 4, iD2);
                arrayList.add(bArr5);
            }
            if (iX2 > 0) {
                NalUnitUtil.SpsData spsDataD = NalUnitUtil.d(iX, (byte[]) arrayList.get(0), ((byte[]) arrayList.get(0)).length);
                int i14 = spsDataD.f5802e;
                int i15 = spsDataD.f5803f;
                int i16 = spsDataD.f5805h + 8;
                int i17 = spsDataD.f5806i + 8;
                int i18 = spsDataD.p;
                int i19 = spsDataD.q;
                int i20 = spsDataD.r;
                int i21 = spsDataD.s;
                float f3 = spsDataD.f5804g;
                str = String.format("avc1.%02X%02X%02X", Integer.valueOf(spsDataD.f5798a), Integer.valueOf(spsDataD.f5799b), Integer.valueOf(spsDataD.f5800c));
                i5 = i19;
                i6 = i20;
                i7 = i21;
                f2 = f3;
                i3 = i15;
                i4 = i16;
                i8 = i17;
                i9 = i18;
                i2 = i14;
            } else {
                str = null;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                i6 = -1;
                i7 = 16;
                f2 = 1.0f;
                i8 = -1;
                i9 = -1;
            }
            return new AvcConfig(arrayList, iX, i2, i3, i4, i8, i9, i5, i6, i7, f2, str);
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw ParserException.a(e2, "Error parsing AVC config");
        }
    }
}
