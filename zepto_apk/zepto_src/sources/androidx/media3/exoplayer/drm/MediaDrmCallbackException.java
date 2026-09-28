package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public final class MediaDrmCallbackException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final Map f6946a;

    public MediaDrmCallbackException(DataSpec dataSpec, Uri uri, Map map, long j2, Exception exc) {
        super(exc);
        this.f6946a = map;
    }
}
