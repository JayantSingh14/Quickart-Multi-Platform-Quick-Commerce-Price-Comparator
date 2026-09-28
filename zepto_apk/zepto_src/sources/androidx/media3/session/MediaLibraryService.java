package androidx.media3.session;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionService;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes3.dex */
public abstract class MediaLibraryService extends MediaSessionService {

    public static final class LibraryParams {

        /* renamed from: e, reason: collision with root package name */
        public static final String f10023e;

        /* renamed from: f, reason: collision with root package name */
        public static final String f10024f;

        /* renamed from: g, reason: collision with root package name */
        public static final String f10025g;

        /* renamed from: h, reason: collision with root package name */
        public static final String f10026h;

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f10027a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f10028b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10029c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f10030d;

        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            public boolean f10031a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f10032b;

            /* renamed from: c, reason: collision with root package name */
            public boolean f10033c;

            /* renamed from: d, reason: collision with root package name */
            public Bundle f10034d = Bundle.EMPTY;
        }

        static {
            int i2 = Util.f5744a;
            f10023e = Integer.toString(0, 36);
            f10024f = Integer.toString(1, 36);
            f10025g = Integer.toString(2, 36);
            f10026h = Integer.toString(3, 36);
        }

        public LibraryParams(Bundle bundle, boolean z, boolean z2, boolean z3) {
            this.f10027a = new Bundle(bundle);
            this.f10028b = z;
            this.f10029c = z2;
            this.f10030d = z3;
        }

        public static LibraryParams a(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(f10023e);
            boolean z = bundle.getBoolean(f10024f, false);
            boolean z2 = bundle.getBoolean(f10025g, false);
            boolean z3 = bundle.getBoolean(f10026h, false);
            if (bundle2 == null) {
                bundle2 = Bundle.EMPTY;
            }
            return new LibraryParams(bundle2, z, z2, z3);
        }

        public final Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putBundle(f10023e, this.f10027a);
            bundle.putBoolean(f10024f, this.f10028b);
            bundle.putBoolean(f10025g, this.f10029c);
            bundle.putBoolean(f10026h, this.f10030d);
            return bundle;
        }
    }

    public static final class MediaLibrarySession extends MediaSession {

        public static final class Builder extends MediaSession.BuilderBase<MediaLibrarySession, Builder, Callback> {
        }

        public interface Callback extends MediaSession.Callback {
            static ListenableFuture d() {
                return Futures.d(LibraryResult.b(-6));
            }
        }

        @Override // androidx.media3.session.MediaSession
        public final MediaSessionImpl b() {
            return (MediaLibrarySessionImpl) this.f10060a;
        }
    }

    @Override // androidx.media3.session.MediaSessionService
    public final /* bridge */ /* synthetic */ MediaSession e(MediaSession.ControllerInfo controllerInfo) {
        return i();
    }

    public abstract MediaLibrarySession i();

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public final IBinder onBind(Intent intent) {
        MediaSessionService.MediaSessionServiceStub mediaSessionServiceStub;
        if (intent == null) {
            return null;
        }
        if (!"androidx.media3.session.MediaLibraryService".equals(intent.getAction())) {
            return super.onBind(intent);
        }
        synchronized (this.f10142a) {
            mediaSessionServiceStub = this.f10145d;
            Assertions.h(mediaSessionServiceStub);
        }
        return mediaSessionServiceStub;
    }
}
