package androidx.media3.session.legacy;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.j;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.UnstableApi;
import java.util.Objects;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class MediaSessionManager {

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f10642b = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f10643c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static volatile MediaSessionManager f10644d;

    /* renamed from: a, reason: collision with root package name */
    public MediaSessionManagerImplApi21 f10645a;

    public interface MediaSessionManagerImpl {
        boolean a(MediaSessionManagerImplBase.RemoteUserInfoImplBase remoteUserInfoImplBase);
    }

    @RequiresApi
    public static class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
        public MediaSessionManagerImplApi21(Context context) {
            this.f10647a = context;
            this.f10648b = context.getContentResolver();
            this.f10647a = context;
        }

        @Override // androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImplBase, androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImpl
        public boolean a(MediaSessionManagerImplBase.RemoteUserInfoImplBase remoteUserInfoImplBase) {
            return this.f10647a.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", remoteUserInfoImplBase.f10650b, remoteUserInfoImplBase.f10651c) == 0 || super.a(remoteUserInfoImplBase);
        }
    }

    @RequiresApi
    public static final class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {

        @RequiresApi
        public static final class RemoteUserInfoImplApi28 extends MediaSessionManagerImplBase.RemoteUserInfoImplBase {
        }
    }

    public static class MediaSessionManagerImplBase implements MediaSessionManagerImpl {

        /* renamed from: c, reason: collision with root package name */
        public static final boolean f10646c = MediaSessionManager.f10642b;

        /* renamed from: a, reason: collision with root package name */
        public Context f10647a;

        /* renamed from: b, reason: collision with root package name */
        public ContentResolver f10648b;

        public static class RemoteUserInfoImplBase implements RemoteUserInfoImpl {

            /* renamed from: a, reason: collision with root package name */
            public final String f10649a;

            /* renamed from: b, reason: collision with root package name */
            public final int f10650b;

            /* renamed from: c, reason: collision with root package name */
            public final int f10651c;

            public RemoteUserInfoImplBase(String str, int i2, int i3) {
                this.f10649a = str;
                this.f10650b = i2;
                this.f10651c = i3;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof RemoteUserInfoImplBase)) {
                    return false;
                }
                RemoteUserInfoImplBase remoteUserInfoImplBase = (RemoteUserInfoImplBase) obj;
                int i2 = this.f10651c;
                String str = this.f10649a;
                int i3 = this.f10650b;
                return (i3 < 0 || remoteUserInfoImplBase.f10650b < 0) ? TextUtils.equals(str, remoteUserInfoImplBase.f10649a) && i2 == remoteUserInfoImplBase.f10651c : TextUtils.equals(str, remoteUserInfoImplBase.f10649a) && i3 == remoteUserInfoImplBase.f10650b && i2 == remoteUserInfoImplBase.f10651c;
            }

            public final int hashCode() {
                return Objects.hash(this.f10649a, Integer.valueOf(this.f10651c));
            }
        }

        @Override // androidx.media3.session.legacy.MediaSessionManager.MediaSessionManagerImpl
        public boolean a(RemoteUserInfoImplBase remoteUserInfoImplBase) {
            try {
                if (this.f10647a.getPackageManager().getApplicationInfo(remoteUserInfoImplBase.f10649a, 0) != null) {
                    if (b(remoteUserInfoImplBase, "android.permission.STATUS_BAR_SERVICE") || b(remoteUserInfoImplBase, "android.permission.MEDIA_CONTENT_CONTROL") || remoteUserInfoImplBase.f10651c == 1000) {
                        return true;
                    }
                    String string = Settings.Secure.getString(this.f10648b, "enabled_notification_listeners");
                    if (string != null) {
                        for (String str : string.split(":")) {
                            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                            if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(remoteUserInfoImplBase.f10649a)) {
                                return true;
                            }
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
                if (f10646c) {
                    Log.d("MediaSessionManager", "Package " + remoteUserInfoImplBase.f10649a + " doesn't exist");
                }
            }
            return false;
        }

        public final boolean b(RemoteUserInfoImplBase remoteUserInfoImplBase, String str) {
            int i2 = remoteUserInfoImplBase.f10650b;
            return i2 < 0 ? this.f10647a.getPackageManager().checkPermission(str, remoteUserInfoImplBase.f10649a) == 0 : this.f10647a.checkPermission(str, i2, remoteUserInfoImplBase.f10651c) == 0;
        }
    }

    public interface RemoteUserInfoImpl {
    }

    public static MediaSessionManager a(Context context) {
        MediaSessionManager mediaSessionManager;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        synchronized (f10643c) {
            try {
                if (f10644d == null) {
                    Context applicationContext = context.getApplicationContext();
                    MediaSessionManager mediaSessionManager2 = new MediaSessionManager();
                    if (Build.VERSION.SDK_INT >= 28) {
                        MediaSessionManagerImplApi28 mediaSessionManagerImplApi28 = new MediaSessionManagerImplApi28(applicationContext);
                        mediaSessionManager2.f10645a = mediaSessionManagerImplApi28;
                    } else {
                        mediaSessionManager2.f10645a = new MediaSessionManagerImplApi21(applicationContext);
                    }
                    f10644d = mediaSessionManager2;
                }
                mediaSessionManager = f10644d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return mediaSessionManager;
    }

    public final boolean b(RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo != null) {
            return this.f10645a.a(remoteUserInfo.f10652a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    public static final class RemoteUserInfo {

        /* renamed from: a, reason: collision with root package name */
        public final MediaSessionManagerImplBase.RemoteUserInfoImplBase f10652a;

        public RemoteUserInfo(String str, int i2, int i3) {
            if (str == null) {
                throw new NullPointerException("package shouldn't be null");
            }
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            if (Build.VERSION.SDK_INT < 28) {
                this.f10652a = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(str, i2, i3);
                return;
            }
            MediaSessionManagerImplApi28.RemoteUserInfoImplApi28 remoteUserInfoImplApi28 = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(str, i2, i3);
            j.r(i2, i3, str);
            this.f10652a = remoteUserInfoImplApi28;
        }

        public final String a() {
            return this.f10652a.f10649a;
        }

        public final int b() {
            return this.f10652a.f10650b;
        }

        public final int c() {
            return this.f10652a.f10651c;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfo)) {
                return false;
            }
            return this.f10652a.equals(((RemoteUserInfo) obj).f10652a);
        }

        public final int hashCode() {
            return this.f10652a.hashCode();
        }

        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            String packageName = remoteUserInfo.getPackageName();
            if (packageName != null) {
                if (!TextUtils.isEmpty(packageName)) {
                    this.f10652a = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
                    return;
                }
                throw new IllegalArgumentException("packageName should be nonempty");
            }
            throw new NullPointerException("package shouldn't be null");
        }
    }
}
