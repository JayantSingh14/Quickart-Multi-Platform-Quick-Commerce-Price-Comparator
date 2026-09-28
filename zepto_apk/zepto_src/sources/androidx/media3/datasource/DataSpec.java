package androidx.media3.datasource;

import android.net.Uri;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import coil3.network.internal.UtilsKt;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
/* loaded from: classes3.dex */
public final class DataSpec {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f5851a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5852b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5853c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f5854d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f5855e;

    /* renamed from: f, reason: collision with root package name */
    public final long f5856f;

    /* renamed from: g, reason: collision with root package name */
    public final long f5857g;

    /* renamed from: h, reason: collision with root package name */
    public final String f5858h;

    /* renamed from: i, reason: collision with root package name */
    public final int f5859i;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Uri f5860a;

        /* renamed from: b, reason: collision with root package name */
        public long f5861b;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f5863d;

        /* renamed from: f, reason: collision with root package name */
        public long f5865f;

        /* renamed from: h, reason: collision with root package name */
        public String f5867h;

        /* renamed from: i, reason: collision with root package name */
        public int f5868i;

        /* renamed from: c, reason: collision with root package name */
        public int f5862c = 1;

        /* renamed from: e, reason: collision with root package name */
        public Map f5864e = Collections.EMPTY_MAP;

        /* renamed from: g, reason: collision with root package name */
        public long f5866g = -1;

        public final DataSpec a() {
            if (this.f5860a != null) {
                return new DataSpec(this.f5860a, this.f5861b, this.f5862c, this.f5863d, this.f5864e, this.f5865f, this.f5866g, this.f5867h, this.f5868i);
            }
            throw new IllegalStateException("The uri must be set.");
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpMethod {
    }

    static {
        MediaLibraryInfo.a("media3.datasource");
    }

    public DataSpec(Uri uri) {
        this(uri, 0L, 1, null, Collections.EMPTY_MAP, 0L, -1L, null, 0);
    }

    public static String b(int i2) {
        if (i2 == 1) {
            return UtilsKt.HTTP_METHOD_GET;
        }
        if (i2 == 2) {
            return "POST";
        }
        if (i2 == 3) {
            return "HEAD";
        }
        throw new IllegalStateException();
    }

    public final Builder a() {
        Builder builder = new Builder();
        builder.f5860a = this.f5851a;
        builder.f5861b = this.f5852b;
        builder.f5862c = this.f5853c;
        builder.f5863d = this.f5854d;
        builder.f5864e = this.f5855e;
        builder.f5865f = this.f5856f;
        builder.f5866g = this.f5857g;
        builder.f5867h = this.f5858h;
        builder.f5868i = this.f5859i;
        return builder;
    }

    public final boolean c(int i2) {
        return (this.f5859i & i2) == i2;
    }

    public final DataSpec d(long j2) {
        long j3 = this.f5857g;
        return e(j2, j3 != -1 ? j3 - j2 : -1L);
    }

    public final DataSpec e(long j2, long j3) {
        if (j2 == 0 && this.f5857g == j3) {
            return this;
        }
        long j4 = this.f5856f + j2;
        return new DataSpec(this.f5851a, this.f5852b, this.f5853c, this.f5854d, this.f5855e, j4, j3, this.f5858h, this.f5859i);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DataSpec[");
        sb.append(b(this.f5853c));
        sb.append(StringUtils.SPACE);
        sb.append(this.f5851a);
        sb.append(", ");
        sb.append(this.f5856f);
        sb.append(", ");
        sb.append(this.f5857g);
        sb.append(", ");
        sb.append(this.f5858h);
        sb.append(", ");
        return android.support.v4.media.b.o(sb, this.f5859i, "]");
    }

    public DataSpec(Uri uri, long j2, int i2, byte[] bArr, Map map, long j3, long j4, String str, int i3) {
        Assertions.a(j2 + j3 >= 0);
        Assertions.a(j3 >= 0);
        Assertions.a(j4 > 0 || j4 == -1);
        uri.getClass();
        this.f5851a = uri;
        this.f5852b = j2;
        this.f5853c = i2;
        this.f5854d = (bArr == null || bArr.length == 0) ? null : bArr;
        this.f5855e = Collections.unmodifiableMap(new HashMap(map));
        this.f5856f = j3;
        this.f5857g = j4;
        this.f5858h = str;
        this.f5859i = i3;
    }
}
