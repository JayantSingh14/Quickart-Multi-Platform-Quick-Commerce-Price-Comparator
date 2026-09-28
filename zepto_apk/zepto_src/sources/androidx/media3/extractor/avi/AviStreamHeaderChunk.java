package androidx.media3.extractor.avi;

/* loaded from: classes3.dex */
final class AviStreamHeaderChunk implements AviChunk {

    /* renamed from: a, reason: collision with root package name */
    public final int f8672a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8673b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8674c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8675d;

    /* renamed from: e, reason: collision with root package name */
    public final int f8676e;

    public AviStreamHeaderChunk(int i2, int i3, int i4, int i5, int i6) {
        this.f8672a = i2;
        this.f8673b = i3;
        this.f8674c = i4;
        this.f8675d = i5;
        this.f8676e = i6;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public final int getType() {
        return 1752331379;
    }
}
