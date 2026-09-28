package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class AudioOffloadSupport {

    /* renamed from: d, reason: collision with root package name */
    public static final AudioOffloadSupport f6516d = new Builder().a();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6517a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6518b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6519c;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public boolean f6520a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f6521b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6522c;

        public final AudioOffloadSupport a() {
            if (this.f6520a || !(this.f6521b || this.f6522c)) {
                return new AudioOffloadSupport(this);
            }
            throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
        }
    }

    public AudioOffloadSupport(Builder builder) {
        this.f6517a = builder.f6520a;
        this.f6518b = builder.f6521b;
        this.f6519c = builder.f6522c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AudioOffloadSupport.class != obj.getClass()) {
            return false;
        }
        AudioOffloadSupport audioOffloadSupport = (AudioOffloadSupport) obj;
        return this.f6517a == audioOffloadSupport.f6517a && this.f6518b == audioOffloadSupport.f6518b && this.f6519c == audioOffloadSupport.f6519c;
    }

    public final int hashCode() {
        return ((this.f6517a ? 1 : 0) << 2) + ((this.f6518b ? 1 : 0) << 1) + (this.f6519c ? 1 : 0);
    }
}
