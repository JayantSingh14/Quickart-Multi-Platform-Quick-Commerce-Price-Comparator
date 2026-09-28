package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes3.dex */
public final class ArrayAsSequence implements CharSequence {

    /* renamed from: a, reason: collision with root package name */
    public int f56024a;

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        throw null;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f56024a;
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        return StringsKt.m(null, i2, Math.min(i3, this.f56024a));
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        int i2 = this.f56024a;
        return StringsKt.m(null, 0, Math.min(i2, i2));
    }
}
