package androidx.media3.extractor.text.pgs;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.text.SubtitleParser;
import java.util.zip.Inflater;

@UnstableApi
/* loaded from: classes3.dex */
public final class PgsParser implements SubtitleParser {

    /* renamed from: a, reason: collision with root package name */
    public final ParsableByteArray f9307a = new ParsableByteArray();

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9308b = new ParsableByteArray();

    /* renamed from: c, reason: collision with root package name */
    public final CueBuilder f9309c = new CueBuilder();

    /* renamed from: d, reason: collision with root package name */
    public Inflater f9310d;

    public static final class CueBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final ParsableByteArray f9311a = new ParsableByteArray();

        /* renamed from: b, reason: collision with root package name */
        public final int[] f9312b = new int[256];

        /* renamed from: c, reason: collision with root package name */
        public boolean f9313c;

        /* renamed from: d, reason: collision with root package name */
        public int f9314d;

        /* renamed from: e, reason: collision with root package name */
        public int f9315e;

        /* renamed from: f, reason: collision with root package name */
        public int f9316f;

        /* renamed from: g, reason: collision with root package name */
        public int f9317g;

        /* renamed from: h, reason: collision with root package name */
        public int f9318h;

        /* renamed from: i, reason: collision with root package name */
        public int f9319i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0083  */
    @Override // androidx.media3.extractor.text.SubtitleParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(byte[] r25, int r26, int r27, androidx.media3.extractor.text.SubtitleParser.OutputOptions r28, androidx.media3.common.util.Consumer r29) {
        /*
            Method dump skipped, instructions count: 618
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.pgs.PgsParser.b(byte[], int, int, androidx.media3.extractor.text.SubtitleParser$OutputOptions, androidx.media3.common.util.Consumer):void");
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public final int c() {
        return 2;
    }
}
