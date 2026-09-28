package androidx.media3.extractor.mkv;

import androidx.media3.extractor.DefaultExtractorInput;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;

/* loaded from: classes3.dex */
final class DefaultEbmlReader implements EbmlReader {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8894a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f8895b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final VarintReader f8896c = new VarintReader();

    /* renamed from: d, reason: collision with root package name */
    public EbmlProcessor f8897d;

    /* renamed from: e, reason: collision with root package name */
    public int f8898e;

    /* renamed from: f, reason: collision with root package name */
    public int f8899f;

    /* renamed from: g, reason: collision with root package name */
    public long f8900g;

    public static final class MasterElement {

        /* renamed from: a, reason: collision with root package name */
        public final int f8901a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8902b;

        public MasterElement(int i2, long j2) {
            this.f8901a = i2;
            this.f8902b = j2;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:514:0x0896  */
    /* JADX WARN: Removed duplicated region for block: B:519:0x08ad  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x08af  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x08be  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:596:0x0a43  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0a92  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cb  */
    /* JADX WARN: Type inference failed for: r0v180 */
    /* JADX WARN: Type inference failed for: r0v97, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v98 */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v104 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v63 */
    /* JADX WARN: Type inference failed for: r3v64, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r46v0, types: [androidx.media3.extractor.DefaultExtractorInput] */
    /* JADX WARN: Type inference failed for: r8v24, types: [androidx.media3.extractor.mkv.MatroskaExtractor$Track, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(androidx.media3.extractor.DefaultExtractorInput r46) {
        /*
            Method dump skipped, instructions count: 4708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.mkv.DefaultEbmlReader.a(androidx.media3.extractor.DefaultExtractorInput):boolean");
    }

    public final long b(DefaultExtractorInput defaultExtractorInput, int i2) throws EOFException, InterruptedIOException {
        defaultExtractorInput.e(this.f8894a, 0, i2, false);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | (r0[i3] & 255);
        }
        return j2;
    }
}
