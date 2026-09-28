package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.webvtt.WebvttCueParser;
import com.google.common.base.Charsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

@UnstableApi
/* loaded from: classes3.dex */
public final class Mp4WebvttParser implements SubtitleParser {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f9432a = new ParsableByteArray();

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final void b(byte[] bArr, int i2, int i3, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        Cue cueA;
        ParsableByteArray parsableByteArray = this.f9432a;
        parsableByteArray.H(i2 + i3, bArr);
        parsableByteArray.J(i2);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.a() > 0) {
            Assertions.b(parsableByteArray.a() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            int iJ = parsableByteArray.j();
            if (parsableByteArray.j() == 1987343459) {
                int i4 = iJ - 8;
                CharSequence charSequenceF = null;
                Cue.Builder builderA = null;
                while (i4 > 0) {
                    Assertions.b(i4 >= 8, "Incomplete vtt cue box header found.");
                    int iJ2 = parsableByteArray.j();
                    int iJ3 = parsableByteArray.j();
                    int i5 = iJ2 - 8;
                    byte[] bArr2 = parsableByteArray.f5723a;
                    int i6 = parsableByteArray.f5724b;
                    int i7 = Util.f5744a;
                    String str = new String(bArr2, i6, i5, Charsets.f42260c);
                    parsableByteArray.K(i5);
                    i4 = (i4 - 8) - i5;
                    if (iJ3 == 1937011815) {
                        Pattern pattern = WebvttCueParser.f9453a;
                        WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder = new WebvttCueParser.WebvttCueInfoBuilder();
                        WebvttCueParser.e(str, webvttCueInfoBuilder);
                        builderA = webvttCueInfoBuilder.a();
                    } else if (iJ3 == 1885436268) {
                        charSequenceF = WebvttCueParser.f(null, str.trim(), Collections.EMPTY_LIST);
                    }
                }
                if (charSequenceF == null) {
                    charSequenceF = "";
                }
                if (builderA != null) {
                    builderA.f5625a = charSequenceF;
                    cueA = builderA.a();
                } else {
                    Pattern pattern2 = WebvttCueParser.f9453a;
                    WebvttCueParser.WebvttCueInfoBuilder webvttCueInfoBuilder2 = new WebvttCueParser.WebvttCueInfoBuilder();
                    webvttCueInfoBuilder2.f9468c = charSequenceF;
                    cueA = webvttCueInfoBuilder2.a().a();
                }
                arrayList.add(cueA);
            } else {
                parsableByteArray.K(iJ - 8);
            }
        }
        consumer.accept(new CuesWithTiming(arrayList, -9223372036854775807L, -9223372036854775807L));
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final int c() {
        return 2;
    }
}
