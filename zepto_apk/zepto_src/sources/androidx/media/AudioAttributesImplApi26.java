package androidx.media;

import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesImpl;
import androidx.media.AudioAttributesImplApi21;

@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
public class AudioAttributesImplApi26 extends AudioAttributesImplApi21 {

    @RequiresApi
    public static class Builder extends AudioAttributesImplApi21.Builder {
        @Override // androidx.media.AudioAttributesImplApi21.Builder, androidx.media.AudioAttributesImpl.Builder
        public final AudioAttributesImpl.Builder a() {
            this.f5030a.setUsage(1);
            return this;
        }

        @Override // androidx.media.AudioAttributesImplApi21.Builder
        /* renamed from: b */
        public final AudioAttributesImplApi21.Builder a() {
            this.f5030a.setUsage(1);
            return this;
        }

        @Override // androidx.media.AudioAttributesImplApi21.Builder, androidx.media.AudioAttributesImpl.Builder
        public final AudioAttributesImpl build() {
            return new AudioAttributesImplApi26(this.f5030a.build());
        }
    }

    @RestrictTo
    public AudioAttributesImplApi26() {
    }
}
