package androidx.media3.extractor.avi;

/* loaded from: classes3.dex */
final class AviMainHeaderChunk implements AviChunk {

    /* renamed from: a, reason: collision with root package name */
    public final int f8669a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8670b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8671c;

    public AviMainHeaderChunk(int i2, int i3, int i4) {
        this.f8669a = i2;
        this.f8670b = i3;
        this.f8671c = i4;
    }

    @Override // androidx.media3.extractor.avi.AviChunk
    public final int getType() {
        return 1751742049;
    }
}
