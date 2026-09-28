package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.base.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class o implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7365a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7366b;

    public /* synthetic */ o(Object obj, int i2) {
        this.f7365a = i2;
        this.f7366b = obj;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f7365a) {
            case 0:
                return Boolean.valueOf(((ExoPlayerImplInternal) this.f7366b).A);
            case 1:
                return (LoadControl) this.f7366b;
            case 2:
                return (BandwidthMeter) this.f7366b;
            case 3:
                return (TrackSelector) this.f7366b;
            case 4:
                return (DefaultMediaSourceFactory) this.f7366b;
            default:
                return (DefaultRenderersFactory) this.f7366b;
        }
    }
}
