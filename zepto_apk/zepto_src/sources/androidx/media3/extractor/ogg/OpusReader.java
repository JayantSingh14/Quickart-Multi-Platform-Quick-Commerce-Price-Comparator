package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.VorbisUtil;
import androidx.media3.extractor.ogg.StreamReader;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class OpusReader extends StreamReader {
    public static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    public static final byte[] p = {79, 112, 117, 115, 84, 97, 103, 115};
    public boolean n;

    public static boolean e(ParsableByteArray parsableByteArray, byte[] bArr) {
        if (parsableByteArray.a() < bArr.length) {
            return false;
        }
        int i2 = parsableByteArray.f5724b;
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.h(0, bArr2, bArr.length);
        parsableByteArray.J(i2);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final long b(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.f5723a;
        return (this.f9142i * OpusUtil.b(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0)) / 1000000;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final boolean c(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) {
        if (e(parsableByteArray, o)) {
            byte[] bArrCopyOf = Arrays.copyOf(parsableByteArray.f5723a, parsableByteArray.f5725c);
            int i2 = bArrCopyOf[9] & 255;
            ArrayList arrayListA = OpusUtil.a(bArrCopyOf);
            if (setupData.f9147a == null) {
                Format.Builder builder = new Format.Builder();
                builder.f5237l = MimeTypes.p("audio/opus");
                builder.z = i2;
                builder.A = 48000;
                builder.o = arrayListA;
                setupData.f9147a = new Format(builder);
                return true;
            }
        } else {
            if (!e(parsableByteArray, p)) {
                Assertions.h(setupData.f9147a);
                return false;
            }
            Assertions.h(setupData.f9147a);
            if (!this.n) {
                this.n = true;
                parsableByteArray.K(8);
                Metadata metadataB = VorbisUtil.b(ImmutableList.p(VorbisUtil.c(parsableByteArray, false, false).f8629a));
                if (metadataB != null) {
                    Format.Builder builderA = setupData.f9147a.a();
                    builderA.f5235j = metadataB.b(setupData.f9147a.f5223k);
                    setupData.f9147a = new Format(builderA);
                    return true;
                }
            }
        }
        return true;
    }

    @Override // androidx.media3.extractor.ogg.StreamReader
    public final void d(boolean z) {
        super.d(z);
        if (z) {
            this.n = false;
        }
    }
}
