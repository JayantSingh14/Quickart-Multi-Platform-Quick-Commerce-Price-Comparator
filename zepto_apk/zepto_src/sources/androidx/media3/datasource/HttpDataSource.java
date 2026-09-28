package androidx.media3.datasource;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public interface HttpDataSource extends DataSource {

    @UnstableApi
    public static abstract class BaseFactory implements Factory {
        public BaseFactory() {
            new RequestProperties();
        }

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final DataSource a() {
            return b();
        }

        public abstract HttpDataSource b();

        @Override // androidx.media3.datasource.HttpDataSource.Factory, androidx.media3.datasource.DataSource.Factory
        public final HttpDataSource a() {
            return b();
        }
    }

    public static final class CleartextNotPermittedException extends HttpDataSourceException {
    }

    public interface Factory extends DataSource.Factory {
        @Override // androidx.media3.datasource.DataSource.Factory
        HttpDataSource a();
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {

        /* renamed from: d, reason: collision with root package name */
        public final int f5900d;

        /* renamed from: e, reason: collision with root package name */
        public final Map f5901e;

        public InvalidResponseCodeException(int i2, DataSourceException dataSourceException, Map map) {
            super(android.support.v4.media.b.f(i2, "Response code: "), dataSourceException, 2004);
            this.f5900d = i2;
            this.f5901e = map;
        }
    }

    @UnstableApi
    public static final class RequestProperties {

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f5902a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public Map f5903b;

        public final synchronized Map a() {
            try {
                if (this.f5903b == null) {
                    this.f5903b = Collections.unmodifiableMap(new HashMap(this.f5902a));
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f5903b;
        }
    }

    public static class HttpDataSourceException extends DataSourceException {

        /* renamed from: c, reason: collision with root package name */
        public final int f5899c;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        public HttpDataSourceException(int i2) {
            super(i2 == 2000 ? 2001 : i2);
            this.f5899c = 1;
        }

        public static HttpDataSourceException a(IOException iOException, int i2) {
            String message = iOException.getMessage();
            int i3 = iOException instanceof SocketTimeoutException ? 2002 : iOException instanceof InterruptedIOException ? 1004 : (message == null || !Ascii.b(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
            return i3 == 2007 ? new CleartextNotPermittedException("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, 2007) : new HttpDataSourceException(i3, i2, iOException);
        }

        public HttpDataSourceException(String str, int i2) {
            super(str, i2 == 2000 ? 2001 : i2);
            this.f5899c = 1;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public HttpDataSourceException(int i2, int i3, IOException iOException) {
            if (i2 == 2000 && i3 == 1) {
                i2 = 2001;
            }
            super(i2, iOException);
            this.f5899c = i3;
        }

        public HttpDataSourceException(String str, IOException iOException, int i2) {
            super(str, iOException, i2 == 2000 ? 2001 : i2);
            this.f5899c = 1;
        }
    }
}
