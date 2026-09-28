package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.RendererConfiguration;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;

@UnstableApi
/* loaded from: classes3.dex */
public final class TrackSelectorResult {

    /* renamed from: a, reason: collision with root package name */
    public final int f8039a;

    /* renamed from: b, reason: collision with root package name */
    public final RendererConfiguration[] f8040b;

    /* renamed from: c, reason: collision with root package name */
    public final ExoTrackSelection[] f8041c;

    /* renamed from: d, reason: collision with root package name */
    public final Tracks f8042d;

    /* renamed from: e, reason: collision with root package name */
    public final MappingTrackSelector.MappedTrackInfo f8043e;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr, Tracks tracks, MappingTrackSelector.MappedTrackInfo mappedTrackInfo) {
        Assertions.a(rendererConfigurationArr.length == exoTrackSelectionArr.length);
        this.f8040b = rendererConfigurationArr;
        this.f8041c = (ExoTrackSelection[]) exoTrackSelectionArr.clone();
        this.f8042d = tracks;
        this.f8043e = mappedTrackInfo;
        this.f8039a = rendererConfigurationArr.length;
    }

    public final boolean a(TrackSelectorResult trackSelectorResult, int i2) {
        return trackSelectorResult != null && Util.a(this.f8040b[i2], trackSelectorResult.f8040b[i2]) && Util.a(this.f8041c[i2], trackSelectorResult.f8041c[i2]);
    }

    public final boolean b(int i2) {
        return this.f8040b[i2] != null;
    }
}
