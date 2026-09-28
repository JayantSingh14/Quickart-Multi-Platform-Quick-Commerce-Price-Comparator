package androidx.media3.extractor.text;

import androidx.media3.common.util.Consumer;
import androidx.media3.extractor.text.SubtitleExtractor;
import com.google.common.collect.ImmutableList;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Consumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9198a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9199b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f9198a = i2;
        this.f9199b = obj;
    }

    @Override // androidx.media3.common.util.Consumer
    public final void accept(Object obj) {
        switch (this.f9198a) {
            case 0:
                CuesWithTiming cuesWithTiming = (CuesWithTiming) obj;
                SubtitleExtractor subtitleExtractor = (SubtitleExtractor) this.f9199b;
                subtitleExtractor.getClass();
                long j2 = cuesWithTiming.f9156b;
                subtitleExtractor.f9164b.getClass();
                SubtitleExtractor.Sample sample = new SubtitleExtractor.Sample(j2, CueEncoder.a(cuesWithTiming.f9155a, cuesWithTiming.f9157c));
                subtitleExtractor.f9166d.add(sample);
                long j3 = subtitleExtractor.f9173k;
                if (j3 == -9223372036854775807L || cuesWithTiming.f9156b >= j3) {
                    subtitleExtractor.b(sample);
                    break;
                }
                break;
            default:
                ((ImmutableList.Builder) this.f9199b).h((CuesWithTiming) obj);
                break;
        }
    }
}
