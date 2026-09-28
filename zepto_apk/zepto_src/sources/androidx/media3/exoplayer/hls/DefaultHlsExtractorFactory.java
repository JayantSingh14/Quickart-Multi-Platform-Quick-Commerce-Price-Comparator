package androidx.media3.exoplayer.hls;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.DefaultSubtitleParserFactory;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f6974c = {8, 13, 11, 2, 0, 1, 7};

    /* renamed from: a, reason: collision with root package name */
    public DefaultSubtitleParserFactory f6975a = new DefaultSubtitleParserFactory();

    /* renamed from: b, reason: collision with root package name */
    public boolean f6976b;

    public static void a(int i2, ArrayList arrayList) {
        if (Ints.e(f6974c, i2, 0, 7) == -1 || arrayList.contains(Integer.valueOf(i2))) {
            return;
        }
        arrayList.add(Integer.valueOf(i2));
    }

    public final Format b(Format format) {
        if (!this.f6976b || !this.f6975a.b(format)) {
            return format;
        }
        Format.Builder builderA = format.a();
        builderA.f5237l = MimeTypes.p("application/x-media3-cues");
        builderA.F = this.f6975a.a(format);
        StringBuilder sb = new StringBuilder();
        sb.append(format.f5225m);
        String str = format.f5222j;
        sb.append(str != null ? StringUtils.SPACE.concat(str) : "");
        builderA.f5234i = sb.toString();
        builderA.q = Long.MAX_VALUE;
        return new Format(builderA);
    }
}
