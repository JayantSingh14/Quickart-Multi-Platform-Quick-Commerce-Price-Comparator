package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@UnstableApi
/* loaded from: classes3.dex */
public final class LoadEventInfo {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLong f7578d = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final long f7579a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f7580b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7581c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LoadEventInfo(long j2, DataSpec dataSpec) {
        this(j2, Collections.EMPTY_MAP, 0L);
        Uri uri = dataSpec.f5851a;
    }

    public LoadEventInfo(long j2, Map map, long j3) {
        this.f7579a = j2;
        this.f7580b = map;
        this.f7581c = j3;
    }
}
