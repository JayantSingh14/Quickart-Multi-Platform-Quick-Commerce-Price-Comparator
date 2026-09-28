package androidx.media3.session;

import androidx.media3.session.LegacyConversions;
import androidx.media3.session.MediaControllerImplLegacy.ConnectionCallback;
import androidx.media3.session.legacy.MediaBrowserCompat;

/* loaded from: classes3.dex */
public final /* synthetic */ class m0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10702a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaControllerImplLegacy f10703b;

    public /* synthetic */ m0(MediaControllerImplLegacy mediaControllerImplLegacy, int i2) {
        this.f10702a = i2;
        this.f10703b = mediaControllerImplLegacy;
    }

    @Override // java.lang.Runnable
    public final void run() throws LegacyConversions.ConversionException {
        switch (this.f10702a) {
            case 0:
                MediaControllerImplLegacy mediaControllerImplLegacy = this.f10703b;
                mediaControllerImplLegacy.getClass();
                MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(mediaControllerImplLegacy.f9990a, mediaControllerImplLegacy.f9992c.f10269a.f(), mediaControllerImplLegacy.new ConnectionCallback());
                mediaControllerImplLegacy.f9997h = mediaBrowserCompat;
                mediaBrowserCompat.a();
                break;
            default:
                MediaControllerImplLegacy mediaControllerImplLegacy2 = this.f10703b;
                if (!mediaControllerImplLegacy2.f9996g.r()) {
                    mediaControllerImplLegacy2.n();
                    break;
                }
                break;
        }
    }
}
