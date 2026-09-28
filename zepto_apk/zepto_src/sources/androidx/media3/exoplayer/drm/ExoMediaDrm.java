package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public interface ExoMediaDrm {

    public static final class AppManagedProvider implements Provider {
        @Override // androidx.media3.exoplayer.drm.ExoMediaDrm.Provider
        public final ExoMediaDrm h(UUID uuid) {
            throw null;
        }
    }

    public static final class KeyRequest {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f6931a;

        /* renamed from: b, reason: collision with root package name */
        public final String f6932b;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface RequestType {
        }

        public KeyRequest(String str, byte[] bArr) {
            this.f6931a = bArr;
            this.f6932b = str;
        }
    }

    public static final class KeyStatus {
    }

    public interface OnEventListener {
    }

    public interface OnExpirationUpdateListener {
    }

    public interface OnKeyStatusChangeListener {
    }

    public interface Provider {
        ExoMediaDrm h(UUID uuid);
    }

    public static final class ProvisionRequest {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f6933a;

        /* renamed from: b, reason: collision with root package name */
        public final String f6934b;

        public ProvisionRequest(String str, byte[] bArr) {
            this.f6933a = bArr;
            this.f6934b = str;
        }
    }

    Map a(byte[] bArr);

    ProvisionRequest b();

    byte[] c();

    void d(byte[] bArr, byte[] bArr2);

    void e(byte[] bArr);

    int f();

    CryptoConfig g(byte[] bArr);

    void h(byte[] bArr);

    byte[] i(byte[] bArr, byte[] bArr2);

    void j(OnEventListener onEventListener);

    KeyRequest k(byte[] bArr, List list, int i2, HashMap map);

    default void l(byte[] bArr, PlayerId playerId) {
    }

    boolean m(String str, byte[] bArr);

    void release();
}
