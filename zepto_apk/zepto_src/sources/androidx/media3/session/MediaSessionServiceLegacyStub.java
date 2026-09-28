package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.legacy.MediaBrowserServiceCompat;
import androidx.media3.session.legacy.MediaSessionCompat;
import androidx.media3.session.legacy.MediaSessionManager;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
class MediaSessionServiceLegacyStub extends MediaBrowserServiceCompat {

    /* renamed from: j, reason: collision with root package name */
    public final MediaSessionManager f10154j;

    /* renamed from: k, reason: collision with root package name */
    public final MediaSessionImpl f10155k;

    /* renamed from: l, reason: collision with root package name */
    public final ConnectedControllersManager f10156l;

    public MediaSessionServiceLegacyStub(MediaSessionImpl mediaSessionImpl) {
        this.f10154j = MediaSessionManager.a(mediaSessionImpl.f10096f);
        this.f10155k = mediaSessionImpl;
        this.f10156l = new ConnectedControllersManager(mediaSessionImpl);
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public MediaBrowserServiceCompat.BrowserRoot g(String str, int i2, Bundle bundle) {
        MediaSessionManager.RemoteUserInfo remoteUserInfoB = b();
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        MediaSession.ControllerInfo controllerInfoP = p(remoteUserInfoB, bundle);
        AtomicReference atomicReference = new AtomicReference();
        ConditionVariable conditionVariable = new ConditionVariable();
        Util.X(this.f10155k.f10102l, new d(this, atomicReference, controllerInfoP, conditionVariable, 6));
        try {
            conditionVariable.a();
            MediaSession.ConnectionResult connectionResult = (MediaSession.ConnectionResult) atomicReference.get();
            if (!connectionResult.f10074a) {
                return null;
            }
            this.f10156l.a(remoteUserInfoB, controllerInfoP, connectionResult.f10075b, connectionResult.f10076c);
            return MediaUtils.f10167a;
        } catch (InterruptedException e2) {
            Log.e("MSSLegacyStub", "Couldn't get a result from onConnect", e2);
            return null;
        }
    }

    @Override // androidx.media3.session.legacy.MediaBrowserServiceCompat
    public void i(String str, MediaBrowserServiceCompat.Result result) {
        result.f(null);
    }

    public MediaSession.ControllerInfo p(MediaSessionManager.RemoteUserInfo remoteUserInfo, Bundle bundle) {
        return new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, this.f10154j.b(remoteUserInfo), null, bundle);
    }

    public final void q(MediaSessionCompat.Token token) {
        attachBaseContext(this.f10155k.f10096f);
        onCreate();
        o(token);
    }
}
