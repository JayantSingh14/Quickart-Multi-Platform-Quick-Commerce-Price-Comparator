package androidx.media3.extractor.flv;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.TrackOutput;

/* loaded from: classes3.dex */
final class VideoTagPayloadReader extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f8733b;

    /* renamed from: c, reason: collision with root package name */
    public final ParsableByteArray f8734c;

    /* renamed from: d, reason: collision with root package name */
    public int f8735d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8736e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8737f;

    /* renamed from: g, reason: collision with root package name */
    public int f8738g;

    public VideoTagPayloadReader(TrackOutput trackOutput) {
        super(trackOutput);
        this.f8733b = new ParsableByteArray(NalUnitUtil.f5779a);
        this.f8734c = new ParsableByteArray(4);
    }
}
