package androidx.media3.extractor.ogg;

import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.ogg.FlacReader;

/* loaded from: classes3.dex */
abstract class StreamReader {

    /* renamed from: b, reason: collision with root package name */
    public TrackOutput f9135b;

    /* renamed from: c, reason: collision with root package name */
    public ExtractorOutput f9136c;

    /* renamed from: d, reason: collision with root package name */
    public OggSeeker f9137d;

    /* renamed from: e, reason: collision with root package name */
    public long f9138e;

    /* renamed from: f, reason: collision with root package name */
    public long f9139f;

    /* renamed from: g, reason: collision with root package name */
    public long f9140g;

    /* renamed from: h, reason: collision with root package name */
    public int f9141h;

    /* renamed from: i, reason: collision with root package name */
    public int f9142i;

    /* renamed from: k, reason: collision with root package name */
    public long f9144k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9145l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9146m;

    /* renamed from: a, reason: collision with root package name */
    public final OggPacket f9134a = new OggPacket();

    /* renamed from: j, reason: collision with root package name */
    public SetupData f9143j = new SetupData();

    public static class SetupData {

        /* renamed from: a, reason: collision with root package name */
        public Format f9147a;

        /* renamed from: b, reason: collision with root package name */
        public FlacReader.FlacOggSeeker f9148b;
    }

    public static final class UnseekableOggSeeker implements OggSeeker {
        @Override // androidx.media3.extractor.ogg.OggSeeker
        public final long a(DefaultExtractorInput defaultExtractorInput) {
            return -1L;
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public final SeekMap b() {
            return new SeekMap.Unseekable(-9223372036854775807L);
        }

        @Override // androidx.media3.extractor.ogg.OggSeeker
        public final void c(long j2) {
        }
    }

    public void a(long j2) {
        this.f9140g = j2;
    }

    public abstract long b(ParsableByteArray parsableByteArray);

    public abstract boolean c(ParsableByteArray parsableByteArray, long j2, SetupData setupData);

    public void d(boolean z) {
        if (z) {
            this.f9143j = new SetupData();
            this.f9139f = 0L;
            this.f9141h = 0;
        } else {
            this.f9141h = 1;
        }
        this.f9138e = -1L;
        this.f9140g = 0L;
    }
}
