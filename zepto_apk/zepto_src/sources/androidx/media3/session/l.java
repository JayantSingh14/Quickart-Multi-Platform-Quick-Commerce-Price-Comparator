package androidx.media3.session;

import android.text.TextUtils;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaNotification;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionLegacyStub.AnonymousClass2;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements MediaControllerImplBase.RemoteSessionTask, MediaNotification.Provider.Callback, MediaSessionLegacyStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10408a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10409b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10410c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10411d;

    public /* synthetic */ l(MediaSessionLegacyStub mediaSessionLegacyStub, MediaDescriptionCompat mediaDescriptionCompat, int i2) {
        this.f10408a = 3;
        this.f10409b = mediaSessionLegacyStub;
        this.f10411d = mediaDescriptionCompat;
        this.f10410c = i2;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void b(MediaSession.ControllerInfo controllerInfo) {
        int i2 = MediaSessionLegacyStub.r;
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f10409b;
        mediaSessionLegacyStub.getClass();
        MediaDescriptionCompat mediaDescriptionCompat = (MediaDescriptionCompat) this.f10411d;
        if (TextUtils.isEmpty(mediaDescriptionCompat.f10587a)) {
            Log.h("MediaSessionLegacyStub", "onAddQueueItem(): Media ID shouldn't be empty");
        } else {
            Futures.a(mediaSessionLegacyStub.f10115g.l(controllerInfo, ImmutableList.t(LegacyConversions.j(mediaDescriptionCompat, false, true))), mediaSessionLegacyStub.new AnonymousClass2(controllerInfo, this.f10410c), MoreExecutors.a());
        }
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        int i3 = this.f10410c;
        Object obj = this.f10411d;
        Object obj2 = this.f10409b;
        switch (this.f10408a) {
            case 0:
                MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) obj2;
                SessionToken sessionToken = mediaControllerImplBase.f9981l;
                sessionToken.getClass();
                int iD = sessionToken.f10269a.d();
                MediaItem mediaItem = (MediaItem) obj;
                MediaControllerStub mediaControllerStub = mediaControllerImplBase.f9972c;
                if (iD < 2) {
                    iMediaSession.a7(mediaControllerStub, i2, i3 + 1, mediaItem.c(true));
                    iMediaSession.g6(mediaControllerStub, i2, i3);
                    break;
                } else {
                    iMediaSession.F6(mediaControllerStub, i2, i3, mediaItem.c(true));
                    break;
                }
            default:
                MediaControllerImplBase mediaControllerImplBase2 = (MediaControllerImplBase) obj2;
                mediaControllerImplBase2.getClass();
                UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
                ImmutableList.Builder builder = new ImmutableList.Builder();
                int i4 = 0;
                while (true) {
                    List list = (List) obj;
                    if (i4 >= list.size()) {
                        iMediaSession.q8(mediaControllerImplBase2.f9972c, i2, i3, new BundleListRetriever(builder.j()));
                        break;
                    } else {
                        builder.h(((MediaItem) list.get(i4)).c(true));
                        i4++;
                    }
                }
        }
    }

    public /* synthetic */ l(Object obj, int i2, Object obj2, int i3) {
        this.f10408a = i3;
        this.f10409b = obj;
        this.f10410c = i2;
        this.f10411d = obj2;
    }
}
