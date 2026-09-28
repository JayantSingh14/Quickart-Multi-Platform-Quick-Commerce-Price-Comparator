package androidx.media3.datasource.cache;

import android.support.v4.media.b;
import java.io.File;
import java.util.regex.Pattern;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
final class SimpleCacheSpan extends CacheSpan {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f6038g = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f6039h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* renamed from: i, reason: collision with root package name */
    public static final Pattern f6040i = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[PHI: r2
      0x009d: PHI (r2v16 java.util.regex.Matcher) = (r2v10 java.util.regex.Matcher), (r2v8 java.util.regex.Matcher) binds: [B:26:0x0093, B:22:0x0081] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.datasource.cache.SimpleCacheSpan b(java.io.File r16, long r17, long r19, androidx.media3.datasource.cache.CachedContentIndex r21) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.SimpleCacheSpan.b(java.io.File, long, long, androidx.media3.datasource.cache.CachedContentIndex):androidx.media3.datasource.cache.SimpleCacheSpan");
    }

    public static File c(File file, int i2, long j2, long j3) {
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append(j2);
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        return new File(file, b.p(sb, j3, ".v3.exo"));
    }
}
