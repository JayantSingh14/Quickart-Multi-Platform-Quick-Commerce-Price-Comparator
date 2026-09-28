package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

@RestrictTo
@Deprecated
/* loaded from: classes3.dex */
public class FingerprintManagerCompat {

    /* renamed from: androidx.core.hardware.fingerprint.FingerprintManagerCompat$1, reason: invalid class name */
    class AnonymousClass1 extends FingerprintManager.AuthenticationCallback {
        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public final void onAuthenticationError(int i2, CharSequence charSequence) {
            throw null;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public final void onAuthenticationFailed() {
            throw null;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public final void onAuthenticationHelp(int i2, CharSequence charSequence) {
            throw null;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public final void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            FingerprintManager.CryptoObject cryptoObject = authenticationResult.getCryptoObject();
            if (cryptoObject != null) {
                if (cryptoObject.getCipher() != null) {
                    cryptoObject.getCipher();
                } else if (cryptoObject.getSignature() != null) {
                    cryptoObject.getSignature();
                } else if (cryptoObject.getMac() != null) {
                    cryptoObject.getMac();
                }
            }
            throw null;
        }
    }

    @RequiresApi
    public static class Api23Impl {
    }

    public static abstract class AuthenticationCallback {
    }

    public static final class AuthenticationResult {
    }

    public static class CryptoObject {
    }
}
