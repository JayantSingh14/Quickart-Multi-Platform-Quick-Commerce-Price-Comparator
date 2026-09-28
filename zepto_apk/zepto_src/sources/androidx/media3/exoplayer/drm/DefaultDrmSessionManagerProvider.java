package androidx.media3.exoplayer.drm;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.exoplayer.analytics.p;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultDrmSessionManagerProvider implements DrmSessionManagerProvider {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6920a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public MediaItem.DrmConfiguration f6921b;

    /* renamed from: c, reason: collision with root package name */
    public DefaultDrmSessionManager f6922c;

    public static DefaultDrmSessionManager b(MediaItem.DrmConfiguration drmConfiguration) {
        DefaultHttpDataSource.Factory factory = new DefaultHttpDataSource.Factory();
        Uri uri = drmConfiguration.f5303b;
        HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(uri == null ? null : uri.toString(), drmConfiguration.f5307f, factory);
        UnmodifiableIterator it = drmConfiguration.f5304c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            httpMediaDrmCallback.d((String) entry.getKey(), (String) entry.getValue());
        }
        DefaultDrmSessionManager.Builder builder = new DefaultDrmSessionManager.Builder();
        p pVar = FrameworkMediaDrm.f6938d;
        UUID uuid = drmConfiguration.f5302a;
        uuid.getClass();
        builder.f6904b = uuid;
        builder.f6905c = pVar;
        builder.f6906d = drmConfiguration.f5305d;
        builder.f6908f = drmConfiguration.f5306e;
        int[] iArrG = Ints.g(drmConfiguration.f5308g);
        for (int i2 : iArrG) {
            boolean z = true;
            if (i2 != 2 && i2 != 1) {
                z = false;
            }
            Assertions.a(z);
        }
        int[] iArr = (int[]) iArrG.clone();
        builder.f6907e = iArr;
        DefaultDrmSessionManager defaultDrmSessionManager = new DefaultDrmSessionManager(builder.f6904b, builder.f6905c, httpMediaDrmCallback, builder.f6903a, builder.f6906d, iArr, builder.f6908f, builder.f6909g, builder.f6910h);
        byte[] bArr = drmConfiguration.f5309h;
        byte[] bArrCopyOf = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        Assertions.g(defaultDrmSessionManager.f6902m.isEmpty());
        defaultDrmSessionManager.v = bArrCopyOf;
        return defaultDrmSessionManager;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManagerProvider
    public final DrmSessionManager a(MediaItem mediaItem) {
        DefaultDrmSessionManager defaultDrmSessionManager;
        mediaItem.f5258b.getClass();
        MediaItem.DrmConfiguration drmConfiguration = mediaItem.f5258b.f5341c;
        if (drmConfiguration == null) {
            return DrmSessionManager.f6929a;
        }
        synchronized (this.f6920a) {
            try {
                if (!drmConfiguration.equals(this.f6921b)) {
                    this.f6921b = drmConfiguration;
                    this.f6922c = b(drmConfiguration);
                }
                defaultDrmSessionManager = this.f6922c;
                defaultDrmSessionManager.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return defaultDrmSessionManager;
    }
}
