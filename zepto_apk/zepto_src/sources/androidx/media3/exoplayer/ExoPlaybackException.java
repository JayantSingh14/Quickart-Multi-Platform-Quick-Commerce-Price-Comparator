package androidx.media3.exoplayer;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes3.dex */
public final class ExoPlaybackException extends PlaybackException {
    public static final String q;
    public static final String r;
    public static final String s;
    public static final String t;
    public static final String u;
    public static final String v;

    /* renamed from: j, reason: collision with root package name */
    public final int f6179j;

    /* renamed from: k, reason: collision with root package name */
    public final String f6180k;

    /* renamed from: l, reason: collision with root package name */
    public final int f6181l;

    /* renamed from: m, reason: collision with root package name */
    public final Format f6182m;
    public final int n;
    public final MediaSource.MediaPeriodId o;
    public final boolean p;

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    @UnstableApi
    public @interface Type {
    }

    static {
        int i2 = Util.f5744a;
        q = Integer.toString(DateUtils.SEMI_MONTH, 36);
        r = Integer.toString(1002, 36);
        s = Integer.toString(1003, 36);
        t = Integer.toString(1004, 36);
        u = Integer.toString(1005, 36);
        v = Integer.toString(1006, 36);
    }

    public ExoPlaybackException(int i2, Exception exc, int i3) {
        this(i2, exc, i3, null, -1, null, 4, false);
    }

    @Override // androidx.media3.common.PlaybackException
    public final boolean a(PlaybackException playbackException) {
        if (!super.a(playbackException)) {
            return false;
        }
        int i2 = Util.f5744a;
        ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
        return this.f6179j == exoPlaybackException.f6179j && Util.a(this.f6180k, exoPlaybackException.f6180k) && this.f6181l == exoPlaybackException.f6181l && Util.a(this.f6182m, exoPlaybackException.f6182m) && this.n == exoPlaybackException.n && Util.a(this.o, exoPlaybackException.o) && this.p == exoPlaybackException.p;
    }

    @Override // androidx.media3.common.PlaybackException
    public final Bundle c() {
        Bundle bundleC = super.c();
        bundleC.putInt(q, this.f6179j);
        bundleC.putString(r, this.f6180k);
        bundleC.putInt(s, this.f6181l);
        Format format = this.f6182m;
        if (format != null) {
            bundleC.putBundle(t, format.c(false));
        }
        bundleC.putInt(u, this.n);
        bundleC.putBoolean(v, this.p);
        return bundleC;
    }

    public final ExoPlaybackException d(MediaSource.MediaPeriodId mediaPeriodId) {
        String message = getMessage();
        int i2 = Util.f5744a;
        return new ExoPlaybackException(message, getCause(), this.f5421a, this.f6179j, this.f6180k, this.f6181l, this.f6182m, this.n, mediaPeriodId, this.f5422b, this.p);
    }

    public ExoPlaybackException(String str, Throwable th, int i2, int i3, String str2, int i4, Format format, int i5, MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z) {
        super(str, th, i2, Bundle.EMPTY, j2);
        Assertions.a(!z || i3 == 1);
        Assertions.a(th != null || i3 == 3);
        this.f6179j = i3;
        this.f6180k = str2;
        this.f6181l = i4;
        this.f6182m = format;
        this.n = i5;
        this.o = mediaPeriodId;
        this.p = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExoPlaybackException(int i2, Throwable th, int i3, String str, int i4, Format format, int i5, boolean z) {
        String str2;
        int i6;
        Format format2;
        String string;
        if (i2 == 0) {
            str2 = str;
            i6 = i4;
            format2 = format;
            string = "Source error";
        } else if (i2 != 1) {
            if (i2 != 3) {
                string = "Unexpected runtime error";
            } else {
                string = "Remote error";
            }
            str2 = str;
            i6 = i4;
            format2 = format;
        } else {
            StringBuilder sb = new StringBuilder();
            str2 = str;
            sb.append(str2);
            sb.append(" error, index=");
            i6 = i4;
            sb.append(i6);
            sb.append(", format=");
            format2 = format;
            sb.append(format2);
            sb.append(", format_supported=");
            sb.append(Util.y(i5));
            string = sb.toString();
        }
        this(TextUtils.isEmpty(null) ? string : android.support.v4.media.b.k(string, ": null"), th, i3, i2, str2, i6, format2, i5, null, SystemClock.elapsedRealtime(), z);
    }
}
