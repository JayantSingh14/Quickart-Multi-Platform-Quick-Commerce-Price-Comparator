package androidx.media3.session;

import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.session.MediaControllerImplBase;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionLegacyStub;
import androidx.media3.session.MediaSessionLegacyStub.AnonymousClass1;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;

/* loaded from: classes3.dex */
public final /* synthetic */ class e0 implements MediaControllerImplBase.RemoteSessionTask, MediaSessionLegacyStub.SessionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f10352a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10353b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10354c;

    public /* synthetic */ e0(Object obj, Object obj2, boolean z) {
        this.f10353b = obj;
        this.f10354c = obj2;
        this.f10352a = z;
    }

    @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
    public void b(MediaSession.ControllerInfo controllerInfo) {
        int i2 = MediaSessionLegacyStub.r;
        MediaSessionLegacyStub mediaSessionLegacyStub = (MediaSessionLegacyStub) this.f10353b;
        mediaSessionLegacyStub.getClass();
        Futures.a(mediaSessionLegacyStub.f10115g.s(controllerInfo, ImmutableList.t((MediaItem) this.f10354c), -1, -9223372036854775807L), mediaSessionLegacyStub.new AnonymousClass1(controllerInfo, this.f10352a), MoreExecutors.a());
    }

    @Override // androidx.media3.session.MediaControllerImplBase.RemoteSessionTask
    public void d(IMediaSession iMediaSession, int i2) {
        MediaControllerImplBase mediaControllerImplBase = (MediaControllerImplBase) this.f10353b;
        mediaControllerImplBase.getClass();
        iMediaSession.Q3(mediaControllerImplBase.f9972c, i2, ((AudioAttributes) this.f10354c).c(), this.f10352a);
    }
}
