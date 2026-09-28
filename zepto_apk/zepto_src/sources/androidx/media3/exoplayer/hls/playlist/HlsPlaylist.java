package androidx.media3.exoplayer.hls.playlist;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.offline.FilterableManifest;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class HlsPlaylist implements FilterableManifest<HlsPlaylist> {

    /* renamed from: a, reason: collision with root package name */
    public final String f7173a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7174b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7175c;

    public HlsPlaylist(String str, List list, boolean z) {
        this.f7173a = str;
        this.f7174b = Collections.unmodifiableList(list);
        this.f7175c = z;
    }
}
