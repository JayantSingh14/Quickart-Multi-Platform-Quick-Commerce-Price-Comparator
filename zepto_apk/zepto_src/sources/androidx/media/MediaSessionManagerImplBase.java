package androidx.media;

import android.text.TextUtils;
import androidx.media.MediaSessionManager;
import java.util.Objects;

/* loaded from: classes3.dex */
class MediaSessionManagerImplBase implements MediaSessionManager.MediaSessionManagerImpl {

    public static class RemoteUserInfoImplBase implements MediaSessionManager.RemoteUserInfoImpl {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RemoteUserInfoImplBase)) {
                return false;
            }
            ((RemoteUserInfoImplBase) obj).getClass();
            return TextUtils.equals(null, null);
        }

        public final int hashCode() {
            return Objects.hash(null, 0);
        }
    }

    static {
        int i2 = MediaSessionManager.f5109a;
    }
}
