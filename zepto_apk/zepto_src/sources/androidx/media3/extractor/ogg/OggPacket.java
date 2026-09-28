package androidx.media3.extractor.ogg;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;
import java.io.EOFException;
import java.io.InterruptedIOException;

/* loaded from: classes3.dex */
final class OggPacket {

    /* renamed from: a, reason: collision with root package name */
    public final OggPageHeader f9122a = new OggPageHeader();

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9123b = new ParsableByteArray(new byte[65025], 0);

    /* renamed from: c, reason: collision with root package name */
    public int f9124c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f9125d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9126e;

    public final int a(int i2) {
        int i3;
        int i4 = 0;
        this.f9125d = 0;
        do {
            int i5 = this.f9125d;
            int i6 = i2 + i5;
            OggPageHeader oggPageHeader = this.f9122a;
            if (i6 >= oggPageHeader.f9129c) {
                break;
            }
            int[] iArr = oggPageHeader.f9132f;
            this.f9125d = i5 + 1;
            i3 = iArr[i5 + i2];
            i4 += i3;
        } while (i3 == 255);
        return i4;
    }

    public final boolean b(DefaultExtractorInput defaultExtractorInput) throws InterruptedIOException {
        int i2;
        Assertions.g(defaultExtractorInput != null);
        boolean z = this.f9126e;
        ParsableByteArray parsableByteArray = this.f9123b;
        if (z) {
            this.f9126e = false;
            parsableByteArray.G(0);
        }
        while (!this.f9126e) {
            int i3 = this.f9124c;
            OggPageHeader oggPageHeader = this.f9122a;
            if (i3 < 0) {
                if (oggPageHeader.b(defaultExtractorInput, -1L) && oggPageHeader.a(defaultExtractorInput, true)) {
                    int iA = oggPageHeader.f9130d;
                    if ((oggPageHeader.f9127a & 1) == 1 && parsableByteArray.f5725c == 0) {
                        iA += a(0);
                        i2 = this.f9125d;
                    } else {
                        i2 = 0;
                    }
                    try {
                        defaultExtractorInput.i(iA);
                        this.f9124c = i2;
                    } catch (EOFException unused) {
                    }
                }
                return false;
            }
            int iA2 = a(this.f9124c);
            int i4 = this.f9124c + this.f9125d;
            if (iA2 > 0) {
                parsableByteArray.c(parsableByteArray.f5725c + iA2);
                defaultExtractorInput.e(parsableByteArray.f5723a, parsableByteArray.f5725c, iA2, false);
                parsableByteArray.I(parsableByteArray.f5725c + iA2);
                this.f9126e = oggPageHeader.f9132f[i4 + (-1)] != 255;
            }
            if (i4 == oggPageHeader.f9129c) {
                i4 = -1;
            }
            this.f9124c = i4;
        }
        return true;
    }
}
