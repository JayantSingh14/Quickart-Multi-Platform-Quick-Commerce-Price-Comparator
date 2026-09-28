package androidx.media;

import android.media.AudioAttributes;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;

@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f5028a;

    /* renamed from: b, reason: collision with root package name */
    public int f5029b = -1;

    @RequiresApi
    public static class Builder implements AudioAttributesImpl.Builder {

        /* renamed from: a, reason: collision with root package name */
        public final AudioAttributes.Builder f5030a = new AudioAttributes.Builder();

        @Override // androidx.media.AudioAttributesImpl.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder a() {
            this.f5030a.setUsage(1);
            return this;
        }

        @Override // androidx.media.AudioAttributesImpl.Builder
        public AudioAttributesImpl build() {
            return new AudioAttributesImplApi21(this.f5030a.build());
        }
    }

    @RestrictTo
    public AudioAttributesImplApi21() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f5028a.equals(((AudioAttributesImplApi21) obj).f5028a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5028a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f5028a;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes) {
        this.f5028a = audioAttributes;
    }
}
