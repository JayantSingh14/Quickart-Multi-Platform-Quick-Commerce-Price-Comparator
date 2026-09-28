package androidx.media3.exoplayer.audio;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* loaded from: classes3.dex */
final class AudioTimestampPoller {

    /* renamed from: a, reason: collision with root package name */
    public final AudioTimestampWrapper f6538a;

    /* renamed from: b, reason: collision with root package name */
    public int f6539b;

    /* renamed from: c, reason: collision with root package name */
    public long f6540c;

    /* renamed from: d, reason: collision with root package name */
    public long f6541d;

    /* renamed from: e, reason: collision with root package name */
    public long f6542e;

    /* renamed from: f, reason: collision with root package name */
    public long f6543f;

    public static final class AudioTimestampWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final AudioTrack f6544a;

        /* renamed from: b, reason: collision with root package name */
        public final AudioTimestamp f6545b = new AudioTimestamp();

        /* renamed from: c, reason: collision with root package name */
        public long f6546c;

        /* renamed from: d, reason: collision with root package name */
        public long f6547d;

        /* renamed from: e, reason: collision with root package name */
        public long f6548e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f6549f;

        /* renamed from: g, reason: collision with root package name */
        public long f6550g;

        public AudioTimestampWrapper(AudioTrack audioTrack) {
            this.f6544a = audioTrack;
        }
    }

    public AudioTimestampPoller(AudioTrack audioTrack) {
        this.f6538a = new AudioTimestampWrapper(audioTrack);
        a();
    }

    public final void a() {
        if (this.f6538a != null) {
            b(0);
        }
    }

    public final void b(int i2) {
        this.f6539b = i2;
        if (i2 == 0) {
            this.f6542e = 0L;
            this.f6543f = -1L;
            this.f6540c = System.nanoTime() / 1000;
            this.f6541d = 10000L;
            return;
        }
        if (i2 == 1) {
            this.f6541d = 10000L;
            return;
        }
        if (i2 == 2 || i2 == 3) {
            this.f6541d = 10000000L;
        } else {
            if (i2 != 4) {
                throw new IllegalStateException();
            }
            this.f6541d = 500000L;
        }
    }
}
