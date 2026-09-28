package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.metadata.id3.Id3Decoder;
import java.io.EOFException;

@UnstableApi
/* loaded from: classes3.dex */
public final class Id3Peeker {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f8580a = new ParsableByteArray(10);

    public final Metadata a(DefaultExtractorInput defaultExtractorInput, Id3Decoder.FramePredicate framePredicate) throws Throwable {
        ParsableByteArray parsableByteArray = this.f8580a;
        Metadata metadataC = null;
        int i2 = 0;
        while (true) {
            try {
                defaultExtractorInput.b(parsableByteArray.f5723a, 0, 10, false);
                parsableByteArray.J(0);
                if (parsableByteArray.A() != 4801587) {
                    break;
                }
                parsableByteArray.K(3);
                int iW = parsableByteArray.w();
                int i3 = iW + 10;
                if (metadataC == null) {
                    byte[] bArr = new byte[i3];
                    System.arraycopy(parsableByteArray.f5723a, 0, bArr, 0, 10);
                    defaultExtractorInput.b(bArr, 10, iW, false);
                    metadataC = new Id3Decoder(framePredicate).c(i3, bArr);
                } else {
                    defaultExtractorInput.l(iW, false);
                }
                i2 += i3;
            } catch (EOFException unused) {
            }
        }
        defaultExtractorInput.f8521f = 0;
        defaultExtractorInput.l(i2, false);
        return metadataC;
    }
}
