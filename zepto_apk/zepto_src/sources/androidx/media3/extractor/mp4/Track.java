package androidx.media3.extractor.mp4;

import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
/* loaded from: classes3.dex */
public final class Track {

    /* renamed from: a, reason: collision with root package name */
    public final int f9065a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9066b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9067c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9068d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9069e;

    /* renamed from: f, reason: collision with root package name */
    public final Format f9070f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9071g;

    /* renamed from: h, reason: collision with root package name */
    public final long[] f9072h;

    /* renamed from: i, reason: collision with root package name */
    public final long[] f9073i;

    /* renamed from: j, reason: collision with root package name */
    public final int f9074j;

    /* renamed from: k, reason: collision with root package name */
    public final TrackEncryptionBox[] f9075k;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i2, int i3, long j2, long j3, long j4, Format format, int i4, TrackEncryptionBox[] trackEncryptionBoxArr, int i5, long[] jArr, long[] jArr2) {
        this.f9065a = i2;
        this.f9066b = i3;
        this.f9067c = j2;
        this.f9068d = j3;
        this.f9069e = j4;
        this.f9070f = format;
        this.f9071g = i4;
        this.f9075k = trackEncryptionBoxArr;
        this.f9074j = i5;
        this.f9072h = jArr;
        this.f9073i = jArr2;
    }
}
