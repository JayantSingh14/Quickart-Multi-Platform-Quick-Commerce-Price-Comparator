package androidx.media3.extractor.metadata.id3;

import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@UnstableApi
/* loaded from: classes3.dex */
public final class Id3Decoder extends SimpleMetadataDecoder {

    /* renamed from: b, reason: collision with root package name */
    public static final p f8823b = new p(13);

    /* renamed from: a, reason: collision with root package name */
    public final FramePredicate f8824a;

    public interface FramePredicate {
        boolean e(int i2, int i3, int i4, int i5, int i6);
    }

    public static final class Id3Header {

        /* renamed from: a, reason: collision with root package name */
        public final int f8825a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f8826b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8827c;

        public Id3Header(int i2, int i3, boolean z) {
            this.f8825a = i2;
            this.f8826b = z;
            this.f8827c = i3;
        }
    }

    public Id3Decoder() {
        this(null);
    }

    public static ApicFrame d(ParsableByteArray parsableByteArray, int i2, int i3) {
        int iV;
        String strConcat;
        int iX = parsableByteArray.x();
        Charset charsetS = s(iX);
        int i4 = i2 - 1;
        byte[] bArr = new byte[i4];
        parsableByteArray.h(0, bArr, i4);
        if (i3 == 2) {
            strConcat = "image/" + Ascii.b(new String(bArr, 0, 3, Charsets.f42259b));
            if (ClipboardModule.MIMETYPE_JPG.equals(strConcat)) {
                strConcat = "image/jpeg";
            }
            iV = 2;
        } else {
            iV = v(0, bArr);
            String strB = Ascii.b(new String(bArr, 0, iV, Charsets.f42259b));
            strConcat = strB.indexOf(47) == -1 ? "image/".concat(strB) : strB;
        }
        int i5 = bArr[iV + 1] & 255;
        int i6 = iV + 2;
        int iU = u(i6, bArr, iX);
        String str = new String(bArr, i6, iU - i6, charsetS);
        int iR = r(iX) + iU;
        return new ApicFrame(i5, strConcat, str, i4 <= iR ? Util.f5749f : Arrays.copyOfRange(bArr, iR, i4));
    }

    public static ChapterFrame e(ParsableByteArray parsableByteArray, int i2, int i3, boolean z, int i4, FramePredicate framePredicate) throws Throwable {
        int i5 = parsableByteArray.f5724b;
        int iV = v(i5, parsableByteArray.f5723a);
        String str = new String(parsableByteArray.f5723a, i5, iV - i5, Charsets.f42259b);
        parsableByteArray.J(iV + 1);
        int iJ = parsableByteArray.j();
        int iJ2 = parsableByteArray.j();
        long jZ = parsableByteArray.z();
        if (jZ == 4294967295L) {
            jZ = -1;
        }
        long jZ2 = parsableByteArray.z();
        long j2 = jZ2 == 4294967295L ? -1L : jZ2;
        ArrayList arrayList = new ArrayList();
        int i6 = i5 + i2;
        while (parsableByteArray.f5724b < i6) {
            Id3Frame id3FrameH = h(i3, parsableByteArray, z, i4, framePredicate);
            if (id3FrameH != null) {
                arrayList.add(id3FrameH);
            }
        }
        return new ChapterFrame(str, iJ, iJ2, jZ, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame f(ParsableByteArray parsableByteArray, int i2, int i3, boolean z, int i4, FramePredicate framePredicate) throws Throwable {
        int i5 = parsableByteArray.f5724b;
        int iV = v(i5, parsableByteArray.f5723a);
        String str = new String(parsableByteArray.f5723a, i5, iV - i5, Charsets.f42259b);
        parsableByteArray.J(iV + 1);
        int iX = parsableByteArray.x();
        boolean z2 = (iX & 2) != 0;
        boolean z3 = (iX & 1) != 0;
        int iX2 = parsableByteArray.x();
        String[] strArr = new String[iX2];
        for (int i6 = 0; i6 < iX2; i6++) {
            int i7 = parsableByteArray.f5724b;
            int iV2 = v(i7, parsableByteArray.f5723a);
            strArr[i6] = new String(parsableByteArray.f5723a, i7, iV2 - i7, Charsets.f42259b);
            parsableByteArray.J(iV2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i8 = i5 + i2;
        while (parsableByteArray.f5724b < i8) {
            Id3Frame id3FrameH = h(i3, parsableByteArray, z, i4, framePredicate);
            if (id3FrameH != null) {
                arrayList.add(id3FrameH);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static CommentFrame g(int i2, ParsableByteArray parsableByteArray) {
        if (i2 < 4) {
            return null;
        }
        int iX = parsableByteArray.x();
        Charset charsetS = s(iX);
        byte[] bArr = new byte[3];
        parsableByteArray.h(0, bArr, 3);
        String str = new String(bArr, 0, 3);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        parsableByteArray.h(0, bArr2, i3);
        int iU = u(0, bArr2, iX);
        String str2 = new String(bArr2, 0, iU, charsetS);
        int iR = r(iX) + iU;
        return new CommentFrame(str, str2, l(bArr2, iR, u(iR, bArr2, iX), charsetS));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0225 A[Catch: all -> 0x020a, Exception -> 0x020c, OutOfMemoryError -> 0x020e, TRY_LEAVE, TryCatch #7 {Exception -> 0x020c, OutOfMemoryError -> 0x020e, all -> 0x020a, blocks: (B:173:0x0205, B:186:0x0220, B:187:0x0225), top: B:203:0x01f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0247  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [androidx.media3.extractor.metadata.id3.Id3Frame] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20, types: [androidx.media3.common.util.ParsableByteArray] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.extractor.metadata.id3.Id3Frame h(int r19, androidx.media3.common.util.ParsableByteArray r20, boolean r21, int r22, androidx.media3.extractor.metadata.id3.Id3Decoder.FramePredicate r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.h(int, androidx.media3.common.util.ParsableByteArray, boolean, int, androidx.media3.extractor.metadata.id3.Id3Decoder$FramePredicate):androidx.media3.extractor.metadata.id3.Id3Frame");
    }

    public static GeobFrame i(int i2, ParsableByteArray parsableByteArray) {
        int iX = parsableByteArray.x();
        Charset charsetS = s(iX);
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.h(0, bArr, i3);
        int iV = v(0, bArr);
        String strP = MimeTypes.p(new String(bArr, 0, iV, Charsets.f42259b));
        int i4 = iV + 1;
        int iU = u(i4, bArr, iX);
        String strL = l(bArr, i4, iU, charsetS);
        int iR = r(iX) + iU;
        int iU2 = u(iR, bArr, iX);
        String strL2 = l(bArr, iR, iU2, charsetS);
        int iR2 = r(iX) + iU2;
        return new GeobFrame(strP, strL, strL2, i3 <= iR2 ? Util.f5749f : Arrays.copyOfRange(bArr, iR2, i3));
    }

    public static MlltFrame j(int i2, ParsableByteArray parsableByteArray) {
        int iD = parsableByteArray.D();
        int iA = parsableByteArray.A();
        int iA2 = parsableByteArray.A();
        int iX = parsableByteArray.x();
        int iX2 = parsableByteArray.x();
        ParsableBitArray parsableBitArray = new ParsableBitArray();
        parsableBitArray.l(parsableByteArray);
        int i3 = ((i2 - 10) * 8) / (iX + iX2);
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int iG = parsableBitArray.g(iX);
            int iG2 = parsableBitArray.g(iX2);
            iArr[i4] = iG;
            iArr2[i4] = iG2;
        }
        return new MlltFrame(iD, iA, iA2, iArr, iArr2);
    }

    public static PrivFrame k(int i2, ParsableByteArray parsableByteArray) {
        byte[] bArr = new byte[i2];
        parsableByteArray.h(0, bArr, i2);
        int iV = v(0, bArr);
        String str = new String(bArr, 0, iV, Charsets.f42259b);
        int i3 = iV + 1;
        return new PrivFrame(str, i2 <= i3 ? Util.f5749f : Arrays.copyOfRange(bArr, i3, i2));
    }

    public static String l(byte[] bArr, int i2, int i3, Charset charset) {
        return (i3 <= i2 || i3 > bArr.length) ? "" : new String(bArr, i2, i3 - i2, charset);
    }

    public static TextInformationFrame m(int i2, ParsableByteArray parsableByteArray, String str) {
        if (i2 < 1) {
            return null;
        }
        int iX = parsableByteArray.x();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.h(0, bArr, i3);
        return new TextInformationFrame(str, null, n(iX, bArr, 0));
    }

    public static ImmutableList n(int i2, byte[] bArr, int i3) {
        if (i3 >= bArr.length) {
            return ImmutableList.t("");
        }
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int iU = u(i3, bArr, i2);
        while (i3 < iU) {
            builder.h(new String(bArr, i3, iU - i3, s(i2)));
            i3 = r(i2) + iU;
            iU = u(i3, bArr, i2);
        }
        ImmutableList immutableListJ = builder.j();
        return immutableListJ.isEmpty() ? ImmutableList.t("") : immutableListJ;
    }

    public static TextInformationFrame o(int i2, ParsableByteArray parsableByteArray) {
        if (i2 < 1) {
            return null;
        }
        int iX = parsableByteArray.x();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.h(0, bArr, i3);
        int iU = u(0, bArr, iX);
        return new TextInformationFrame("TXXX", new String(bArr, 0, iU, s(iX)), n(iX, bArr, r(iX) + iU));
    }

    public static UrlLinkFrame p(int i2, ParsableByteArray parsableByteArray, String str) {
        byte[] bArr = new byte[i2];
        parsableByteArray.h(0, bArr, i2);
        return new UrlLinkFrame(str, null, new String(bArr, 0, v(0, bArr), Charsets.f42259b));
    }

    public static UrlLinkFrame q(int i2, ParsableByteArray parsableByteArray) {
        if (i2 < 1) {
            return null;
        }
        int iX = parsableByteArray.x();
        int i3 = i2 - 1;
        byte[] bArr = new byte[i3];
        parsableByteArray.h(0, bArr, i3);
        int iU = u(0, bArr, iX);
        String str = new String(bArr, 0, iU, s(iX));
        int iR = r(iX) + iU;
        return new UrlLinkFrame("WXXX", str, l(bArr, iR, v(iR, bArr), Charsets.f42259b));
    }

    public static int r(int i2) {
        return (i2 == 0 || i2 == 3) ? 1 : 2;
    }

    public static Charset s(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? Charsets.f42259b : Charsets.f42260c : Charsets.f42261d : Charsets.f42263f;
    }

    public static String t(int i2, int i3, int i4, int i5, int i6) {
        return i2 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static int u(int i2, byte[] bArr, int i3) {
        int iV = v(i2, bArr);
        if (i3 == 0 || i3 == 3) {
            return iV;
        }
        while (iV < bArr.length - 1) {
            if ((iV - i2) % 2 == 0 && bArr[iV + 1] == 0) {
                return iV;
            }
            iV = v(iV + 1, bArr);
        }
        return bArr.length;
    }

    public static int v(int i2, byte[] bArr) {
        while (i2 < bArr.length) {
            if (bArr[i2] == 0) {
                return i2;
            }
            i2++;
        }
        return bArr.length;
    }

    public static int w(int i2, ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.f5723a;
        int i3 = parsableByteArray.f5724b;
        int i4 = i3;
        while (true) {
            int i5 = i4 + 1;
            if (i5 >= i3 + i2) {
                return i2;
            }
            if ((bArr[i4] & 255) == 255 && bArr[i5] == 0) {
                System.arraycopy(bArr, i4 + 2, bArr, i5, (i2 - (i4 - i3)) - 2);
                i2--;
            }
            i4 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007a A[PHI: r3
      0x007a: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:42:0x0087, B:33:0x0077] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean x(androidx.media3.common.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r1.f5724b
        L6:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L20
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lac
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L23
            int r7 = r1.j()     // Catch: java.lang.Throwable -> L20
            long r8 = r1.z()     // Catch: java.lang.Throwable -> L20
            int r10 = r1.D()     // Catch: java.lang.Throwable -> L20
            goto L2d
        L20:
            r0 = move-exception
            goto Lb0
        L23:
            int r7 = r1.A()     // Catch: java.lang.Throwable -> L20
            int r8 = r1.A()     // Catch: java.lang.Throwable -> L20
            long r8 = (long) r8
            r10 = r6
        L2d:
            r11 = 0
            if (r7 != 0) goto L3b
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3b
            if (r10 != 0) goto L3b
            r1.J(r2)
            return r4
        L3b:
            r7 = 4
            if (r0 != r7) goto L6c
            if (r21 != 0) goto L6c
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4c
            r1.J(r2)
            return r6
        L4c:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6c:
            if (r0 != r7) goto L7c
            r3 = r10 & 64
            if (r3 == 0) goto L74
            r3 = r4
            goto L75
        L74:
            r3 = r6
        L75:
            r7 = r10 & 1
            if (r7 == 0) goto L7a
            goto L8c
        L7a:
            r4 = r6
            goto L8c
        L7c:
            if (r0 != r3) goto L8a
            r3 = r10 & 32
            if (r3 == 0) goto L84
            r3 = r4
            goto L85
        L84:
            r3 = r6
        L85:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L7a
            goto L8c
        L8a:
            r3 = r6
            r4 = r3
        L8c:
            if (r4 == 0) goto L90
            int r3 = r3 + 4
        L90:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L99
            r1.J(r2)
            return r6
        L99:
            int r3 = r1.a()     // Catch: java.lang.Throwable -> L20
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La6
            r1.J(r2)
            return r6
        La6:
            int r3 = (int) r8
            r1.K(r3)     // Catch: java.lang.Throwable -> L20
            goto L6
        Lac:
            r1.J(r2)
            return r4
        Lb0:
            r1.J(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.x(androidx.media3.common.util.ParsableByteArray, int, int, boolean):boolean");
    }

    @Override // androidx.media3.extractor.metadata.SimpleMetadataDecoder
    public final Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        return c(byteBuffer.limit(), byteBuffer.array());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.media3.common.Metadata c(int r13, byte[] r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.metadata.id3.Id3Decoder.c(int, byte[]):androidx.media3.common.Metadata");
    }

    public Id3Decoder(FramePredicate framePredicate) {
        this.f8824a = framePredicate;
    }
}
