package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.DefaultExtractorInput;

/* loaded from: classes3.dex */
final class TsDurationReader {

    /* renamed from: c, reason: collision with root package name */
    public boolean f9778c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9779d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f9780e;

    /* renamed from: a, reason: collision with root package name */
    public final TimestampAdjuster f9776a = new TimestampAdjuster(0);

    /* renamed from: f, reason: collision with root package name */
    public long f9781f = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f9782g = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f9783h = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f9777b = new ParsableByteArray();

    public final void a(DefaultExtractorInput defaultExtractorInput) {
        byte[] bArr = Util.f5749f;
        ParsableByteArray parsableByteArray = this.f9777b;
        parsableByteArray.getClass();
        parsableByteArray.H(bArr.length, bArr);
        this.f9778c = true;
        defaultExtractorInput.f8521f = 0;
    }
}
