package com.truecaller.android.sdk.oAuth;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Handler;
import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.truecaller.android.sdk.SdkUtils;
import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import com.truecaller.android.sdk.common.imOtpVerification.ImOtpReceiverClientHandler;
import com.truecaller.android.sdk.common.imOtpVerification.ImOtpReceiverClientHandler$startCountDownTimer$1;
import com.truecaller.android.sdk.common.models.TrueProfile;
import com.truecaller.android.sdk.legacy.ITrueCallback;
import com.truecaller.android.sdk.oAuth.OAuthResponse;
import com.truecaller.android.sdk.oAuth.TcOAuthError;
import com.truecaller.android.sdk.oAuth.clients.BaseClient;
import com.truecaller.android.sdk.oAuth.clients.OAuthClient;
import com.truecaller.android.sdk.oAuth.clients.VerificationClientV2;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

@Keep
/* loaded from: classes4.dex */
public final class TcSdk {
    private static TcSdk sInstance;
    private final ClientManagerV2 mTcClientManager;

    private TcSdk(@NonNull ClientManagerV2 clientManagerV2) {
        this.mTcClientManager = clientManagerV2;
    }

    public static void clear() {
        TcSdk tcSdk = sInstance;
        if (tcSdk != null) {
            BaseClient baseClient = tcSdk.mTcClientManager.f47271a;
            if (baseClient != null && baseClient.f47278c == 2) {
                VerificationClientV2 verificationClientV2 = (VerificationClientV2) baseClient;
                ImOtpReceiverClientHandler imOtpReceiverClientHandler = verificationClientV2.o;
                if (imOtpReceiverClientHandler != null) {
                    imOtpReceiverClientHandler.a();
                    ImOtpReceiverClientHandler imOtpReceiverClientHandler2 = verificationClientV2.o;
                    ImOtpReceiverClientHandler$startCountDownTimer$1 imOtpReceiverClientHandler$startCountDownTimer$1 = imOtpReceiverClientHandler2.f47235c;
                    if (imOtpReceiverClientHandler$startCountDownTimer$1 != null) {
                        imOtpReceiverClientHandler$startCountDownTimer$1.cancel();
                    }
                    imOtpReceiverClientHandler2.f47235c = null;
                    verificationClientV2.o = null;
                }
                if (verificationClientV2.f47289m != null) {
                    verificationClientV2.g();
                    verificationClientV2.f47289m = null;
                }
                Handler handler = verificationClientV2.n;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    verificationClientV2.n = null;
                }
            }
            sInstance.mTcClientManager.f47271a = null;
            ClientManagerV2.f47270b = null;
            sInstance = null;
        }
    }

    public static TcSdk getInstance() throws RuntimeException {
        TcSdk tcSdk = sInstance;
        if (tcSdk != null) {
            return tcSdk;
        }
        throw new RuntimeException("Please call init() on TcSdk first");
    }

    public static synchronized void init(@NonNull TcSdkOptions tcSdkOptions) {
        sInstance = new TcSdk(ClientManagerV2.a(tcSdkOptions));
    }

    public void getAuthorizationCode(@NonNull FragmentActivity fragmentActivity, @NonNull ActivityResultLauncher<Intent> activityResultLauncher) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        BaseClient baseClient = this.mTcClientManager.f47271a;
        if (baseClient.f47278c != 1) {
            SdkUtils.c(fragmentActivity);
            VerificationRequestManagerImpl verificationRequestManagerImpl = ((VerificationClientV2) baseClient).f47286j;
            ITrueCallback iTrueCallback = verificationRequestManagerImpl.f47197c;
            if (iTrueCallback != null) {
                iTrueCallback.onVerificationRequired(null);
                return;
            }
            TcOAuthCallback tcOAuthCallback = verificationRequestManagerImpl.f47198d;
            if (tcOAuthCallback != null) {
                tcOAuthCallback.onVerificationRequired(null);
                return;
            }
            return;
        }
        OAuthClient oAuthClient = (OAuthClient) baseClient;
        String str = oAuthClient.f47284i;
        if (str == null || str.trim().isEmpty()) {
            throw new RuntimeException("Code challenge cannot be null or empty");
        }
        String[] strArr = oAuthClient.f47282g;
        if (strArr == null || strArr.length == 0) {
            throw new RuntimeException("OAuth scopes cannot be null or empty");
        }
        String str2 = oAuthClient.f47283h;
        if (str2 == null || str2.trim().isEmpty()) {
            throw new RuntimeException("OAuth state cannot be null or empty");
        }
        try {
            Intent intentH = oAuthClient.h(fragmentActivity);
            if (intentH == null) {
                oAuthClient.i(fragmentActivity, TcOAuthError.TruecallerNotInstalledError.INSTANCE);
            } else {
                activityResultLauncher.a(intentH);
            }
        } catch (ActivityNotFoundException unused) {
            oAuthClient.f47277b.onFailure(TcOAuthError.TruecallerActivityNotFoundError.INSTANCE);
        }
    }

    public boolean isOAuthFlowUsable() {
        return this.mTcClientManager.f47271a != null;
    }

    public boolean onActivityResultObtained(@NonNull FragmentActivity fragmentActivity, int i2, @Nullable Intent intent) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        BaseClient baseClient = this.mTcClientManager.f47271a;
        if (baseClient.f47278c != 1) {
            return false;
        }
        OAuthClient oAuthClient = (OAuthClient) baseClient;
        TcOAuthCallback tcOAuthCallback = oAuthClient.f47277b;
        if (intent == null || intent.getExtras() == null) {
            tcOAuthCallback.onFailure(TcOAuthError.TruecallerClosedError.INSTANCE);
            return false;
        }
        OAuthResponse oAuthResponse = (OAuthResponse) intent.getParcelableExtra(OAuthResponse.OAUTH_RESPONSE_EXTRA);
        if (oAuthResponse == null) {
            tcOAuthCallback.onFailure(TcOAuthError.RequestCodeCollisionError.INSTANCE);
            return false;
        }
        if (-1 == i2 && oAuthResponse.isSuccessful()) {
            tcOAuthCallback.onSuccess(((OAuthResponse.SuccessResponse) oAuthResponse).getTcOAuthData());
            return true;
        }
        TcOAuthError tcOAuthError = ((OAuthResponse.FailureResponse) oAuthResponse).getTcOAuthError();
        if (tcOAuthError == TcOAuthError.UserDeniedError.INSTANCE || tcOAuthError == TcOAuthError.UserDeniedByPressingFooterError.INSTANCE || tcOAuthError == TcOAuthError.UserDeniedWhileLoadingError.INSTANCE || tcOAuthError == TcOAuthError.InvalidAccountStateError.INSTANCE) {
            oAuthClient.i(fragmentActivity, tcOAuthError);
            return true;
        }
        tcOAuthCallback.onFailure(tcOAuthError);
        return true;
    }

    public void requestVerification(@NonNull String str, @NonNull String phoneNumber, @NonNull VerificationCallback verificationCallback, @NonNull FragmentActivity fragmentActivity) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        BaseClient baseClient = this.mTcClientManager.f47271a;
        if (baseClient.f47278c == 2) {
            VerificationClientV2 verificationClientV2 = (VerificationClientV2) baseClient;
            SdkUtils.a(fragmentActivity);
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            if (!SdkUtils.f47191b.matcher(phoneNumber).matches()) {
                throw new RuntimeException(TrueException.TYPE_INVALID_NUMBER);
            }
            String strA = UtilsV2.a(fragmentActivity);
            String str2 = verificationClientV2.f47283h;
            String strB = SdkUtils.b(fragmentActivity);
            verificationClientV2.f47286j.a(str2, verificationClientV2.f47279d, str, phoneNumber, strB, verificationClientV2.f47288l, verificationCallback, strA);
        }
    }

    public void setCodeChallenge(@NonNull String str) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        this.mTcClientManager.f47271a.f47284i = str;
    }

    public void setLocale(@NonNull Locale locale) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        this.mTcClientManager.f47271a.f47280e = locale;
    }

    public void setOAuthScopes(@NonNull String[] strArr) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        this.mTcClientManager.f47271a.f47282g = strArr;
    }

    public void setOAuthState(@NonNull String str) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        this.mTcClientManager.f47271a.f47283h = str;
    }

    public void setTheme(@NonNull @OAuthThemeOptions int i2) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        this.mTcClientManager.f47271a.f47281f = i2;
    }

    public void verifyMissedCall(@NonNull TrueProfile trueProfile, @NonNull VerificationCallback verificationCallback) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        BaseClient baseClient = this.mTcClientManager.f47271a;
        if (baseClient.f47278c == 2) {
            VerificationClientV2 verificationClientV2 = (VerificationClientV2) baseClient;
            VerificationRequestManagerImpl verificationRequestManagerImpl = verificationClientV2.f47286j;
            String str = verificationRequestManagerImpl.f47205k;
            if (str != null) {
                verificationRequestManagerImpl.b(trueProfile, str, verificationClientV2.f47279d, verificationCallback);
            } else {
                verificationCallback.onRequestFailure(5, new TrueException(3, TrueException.TYPE_MISSING_CREATE_CALL_MESSAGE));
            }
        }
    }

    public void verifyOtp(@NonNull TrueProfile trueProfile, @NonNull String str, @NonNull VerificationCallback verificationCallback) {
        if (!isOAuthFlowUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        BaseClient baseClient = this.mTcClientManager.f47271a;
        if (baseClient.f47278c == 2) {
            VerificationClientV2 verificationClientV2 = (VerificationClientV2) baseClient;
            verificationClientV2.f47286j.b(trueProfile, str, verificationClientV2.f47279d, verificationCallback);
        }
    }

    public void getAuthorizationCode(@NonNull Fragment fragment, @NonNull ActivityResultLauncher<Intent> activityResultLauncher) {
        if (isOAuthFlowUsable()) {
            BaseClient baseClient = this.mTcClientManager.f47271a;
            if (baseClient.f47278c == 1) {
                OAuthClient oAuthClient = (OAuthClient) baseClient;
                String str = oAuthClient.f47284i;
                if (str != null && !str.trim().isEmpty()) {
                    String[] strArr = oAuthClient.f47282g;
                    if (strArr != null && strArr.length != 0) {
                        String str2 = oAuthClient.f47283h;
                        if (str2 != null && !str2.trim().isEmpty()) {
                            FragmentActivity activity = fragment.getActivity();
                            if (activity != null) {
                                try {
                                    Intent intentH = oAuthClient.h(activity);
                                    if (intentH == null) {
                                        oAuthClient.i(activity, TcOAuthError.TruecallerNotInstalledError.INSTANCE);
                                        return;
                                    } else {
                                        activityResultLauncher.a(intentH);
                                        return;
                                    }
                                } catch (ActivityNotFoundException unused) {
                                    oAuthClient.f47277b.onFailure(TcOAuthError.TruecallerActivityNotFoundError.INSTANCE);
                                    return;
                                }
                            }
                            return;
                        }
                        throw new RuntimeException("OAuth state cannot be null or empty");
                    }
                    throw new RuntimeException("OAuth scopes cannot be null or empty");
                }
                throw new RuntimeException("Code challenge cannot be null or empty");
            }
            SdkUtils.c(fragment.getActivity());
            VerificationRequestManagerImpl verificationRequestManagerImpl = ((VerificationClientV2) baseClient).f47286j;
            ITrueCallback iTrueCallback = verificationRequestManagerImpl.f47197c;
            if (iTrueCallback != null) {
                iTrueCallback.onVerificationRequired(null);
                return;
            }
            TcOAuthCallback tcOAuthCallback = verificationRequestManagerImpl.f47198d;
            if (tcOAuthCallback != null) {
                tcOAuthCallback.onVerificationRequired(null);
                return;
            }
            return;
        }
        throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
    }
}
