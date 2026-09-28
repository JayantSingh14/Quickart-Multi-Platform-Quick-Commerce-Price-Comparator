package androidx.media3.session;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaBrowser;
import androidx.media3.session.SessionCommands;
import androidx.media3.session.legacy.MediaBrowserCompat;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class MediaBrowserImplLegacy extends MediaControllerImplLegacy implements MediaBrowser.MediaBrowserImpl {

    /* renamed from: androidx.media3.session.MediaBrowserImplLegacy$1, reason: invalid class name */
    class AnonymousClass1 extends MediaBrowserCompat.ItemCallback {
        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ItemCallback
        public final void a() {
            LibraryResult.b(-1);
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ItemCallback
        public final void b(MediaBrowserCompat.MediaItem mediaItem) {
            if (mediaItem == null) {
                LibraryResult.b(-3);
                throw null;
            }
            ImmutableSet immutableSet = LegacyConversions.f9940a;
            int i2 = mediaItem.f10455a;
            LibraryResult.d(LegacyConversions.j(mediaItem.f10456b, (i2 & 1) != 0, (i2 & 2) != 0));
            SystemClock.elapsedRealtime();
            throw null;
        }
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplLegacy$2, reason: invalid class name */
    class AnonymousClass2 extends MediaBrowserCompat.SearchCallback {
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplLegacy$3, reason: invalid class name */
    class AnonymousClass3 extends MediaBrowserCompat.SearchCallback {
    }

    public class GetChildrenCallback extends MediaBrowserCompat.SubscriptionCallback {
        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public final void a(String str, ArrayList arrayList) {
            if (!TextUtils.isEmpty(str)) {
                throw null;
            }
            Log.h("MB2ImplLegacy", "GetChildrenCallback.onChildrenLoaded(): Ignoring empty parentId");
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public final void b(String str, ArrayList arrayList) {
            if (!TextUtils.isEmpty(str)) {
                throw null;
            }
            Log.h("MB2ImplLegacy", "GetChildrenCallback.onChildrenLoaded(): Ignoring empty parentId");
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public final void c() {
            LibraryResult.b(-1);
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public final void d() {
            LibraryResult.b(-1);
            throw null;
        }
    }

    public class GetLibraryRootCallback extends MediaBrowserCompat.ConnectionCallback {
        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void a() {
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void b() {
            LibraryResult.b(-3);
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public final void c() {
            b();
            throw null;
        }
    }

    public class SubscribeCallback extends MediaBrowserCompat.SubscriptionCallback {
        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public final void a(String str, ArrayList arrayList) {
            if (!TextUtils.isEmpty(str)) {
                throw null;
            }
            Log.h("MB2ImplLegacy", "SubscribeCallback.onChildrenLoaded(): Ignoring empty parentId");
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public final void b(String str, ArrayList arrayList) {
            if (!TextUtils.isEmpty(str)) {
                throw null;
            }
            Log.h("MB2ImplLegacy", "SubscribeCallback.onChildrenLoaded(): Ignoring empty parentId");
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public final void c() {
            LibraryResult.b(-1);
            throw null;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public final void d() {
            LibraryResult.b(-1);
            throw null;
        }
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy, androidx.media3.session.MediaController.MediaControllerImpl
    public final SessionCommands c() {
        if (this.f9997h == null) {
            return this.f10002m.f10008b;
        }
        SessionCommands sessionCommands = this.f10002m.f10008b;
        sessionCommands.getClass();
        SessionCommands.Builder builder = new SessionCommands.Builder(sessionCommands);
        builder.a(SessionCommand.f10229e);
        return builder.b();
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy
    public final MediaController j() {
        return null;
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy, androidx.media3.session.MediaController.MediaControllerImpl
    public final void release() {
        throw null;
    }
}
