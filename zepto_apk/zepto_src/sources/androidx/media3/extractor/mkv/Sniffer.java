package androidx.media3.extractor.mkv;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;

/* loaded from: classes3.dex */
final class Sniffer {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f8930a = new ParsableByteArray(8);

    /* renamed from: b, reason: collision with root package name */
    public int f8931b;

    public final long a(DefaultExtractorInput defaultExtractorInput) {
        ParsableByteArray parsableByteArray = this.f8930a;
        int i2 = 0;
        defaultExtractorInput.b(parsableByteArray.f5723a, 0, 1, false);
        int i3 = parsableByteArray.f5723a[0] & 255;
        if (i3 == 0) {
            return Long.MIN_VALUE;
        }
        int i4 = 128;
        int i5 = 0;
        while ((i3 & i4) == 0) {
            i4 >>= 1;
            i5++;
        }
        int i6 = i3 & (~i4);
        defaultExtractorInput.b(parsableByteArray.f5723a, 1, i5, false);
        while (i2 < i5) {
            i2++;
            i6 = (parsableByteArray.f5723a[i2] & 255) + (i6 << 8);
        }
        this.f8931b = i5 + 1 + this.f8931b;
        return i6;
    }
}
