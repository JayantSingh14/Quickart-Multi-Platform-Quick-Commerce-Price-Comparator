package androidx.media3.session;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import androidx.media3.common.util.Log;
import androidx.media3.session.LegacyConversions;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaControllerImplLegacy;

/* loaded from: classes3.dex */
public final /* synthetic */ class f0 implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10358a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10359b;

    public /* synthetic */ f0(Object obj, int i2) {
        this.f10358a = i2;
        this.f10359b = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws LegacyConversions.ConversionException {
        switch (this.f10358a) {
            case 0:
                MediaControllerImplBase.FlushCommandQueueHandler flushCommandQueueHandler = (MediaControllerImplBase.FlushCommandQueueHandler) this.f10359b;
                flushCommandQueueHandler.getClass();
                if (message.what == 1) {
                    try {
                        MediaControllerImplBase mediaControllerImplBase = MediaControllerImplBase.this;
                        mediaControllerImplBase.z.s9(mediaControllerImplBase.f9972c);
                        break;
                    } catch (RemoteException unused) {
                        Log.h("MCImplBase", "Error in sending flushCommandQueue");
                        break;
                    }
                }
                break;
            default:
                MediaControllerImplLegacy.ControllerCompatCallback controllerCompatCallback = (MediaControllerImplLegacy.ControllerCompatCallback) this.f10359b;
                controllerCompatCallback.getClass();
                if (message.what == 1) {
                    MediaControllerImplLegacy mediaControllerImplLegacy = MediaControllerImplLegacy.this;
                    mediaControllerImplLegacy.k(false, mediaControllerImplLegacy.f10001l);
                    break;
                }
                break;
        }
        return true;
        return true;
    }
}
