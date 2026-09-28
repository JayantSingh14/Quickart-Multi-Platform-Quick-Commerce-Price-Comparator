package androidx.media3.exoplayer.upstream;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.lang3.time.DateUtils;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {

    /* renamed from: a, reason: collision with root package name */
    public final int f8155a;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    @Override // androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public long a(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        Throwable cause = loadErrorInfo.f8162a;
        if ((cause instanceof ParserException) || (cause instanceof FileNotFoundException) || (cause instanceof HttpDataSource.CleartextNotPermittedException) || (cause instanceof Loader.UnexpectedLoaderException)) {
            return -9223372036854775807L;
        }
        int i2 = DataSourceException.f5844b;
        while (cause != null) {
            if ((cause instanceof DataSourceException) && ((DataSourceException) cause).f5845a == 2008) {
                return -9223372036854775807L;
            }
            cause = cause.getCause();
        }
        return Math.min((loadErrorInfo.f8163b - 1) * 1000, 5000);
    }

    @Override // androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public int b(int i2) {
        int i3 = this.f8155a;
        return i3 == -1 ? i2 == 7 ? 6 : 3 : i3;
    }

    @Override // androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy
    public final LoadErrorHandlingPolicy.FallbackSelection c(LoadErrorHandlingPolicy.FallbackOptions fallbackOptions, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.f8162a;
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return null;
        }
        int i2 = ((HttpDataSource.InvalidResponseCodeException) iOException).f5900d;
        if (i2 != 403 && i2 != 404 && i2 != 410 && i2 != 416 && i2 != 500 && i2 != 503) {
            return null;
        }
        if (fallbackOptions.a(1)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(1, 300000L);
        }
        if (fallbackOptions.a(2)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(2, DateUtils.MILLIS_PER_MINUTE);
        }
        return null;
    }

    public DefaultLoadErrorHandlingPolicy(int i2) {
        this.f8155a = i2;
    }
}
