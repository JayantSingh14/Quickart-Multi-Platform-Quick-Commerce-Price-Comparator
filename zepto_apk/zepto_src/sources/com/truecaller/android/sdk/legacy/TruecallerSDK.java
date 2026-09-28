package com.truecaller.android.sdk.legacy;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.truecaller.android.sdk.SdkUtils;
import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import com.truecaller.android.sdk.common.models.TrueProfile;
import com.truecaller.android.sdk.legacy.clients.TcClient;
import com.truecaller.android.sdk.legacy.clients.TrueClient;
import com.truecaller.android.sdk.legacy.clients.VerificationClient;
import com.truecaller.android.sdk.oAuth.TcOAuthCallback;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

@Keep
/* loaded from: classes4.dex */
public final class TruecallerSDK {
    public static final int SHARE_PROFILE_REQUEST_CODE = 100;
    private static TruecallerSDK sInstance;
    private final ClientManager mTcClientManager;

    private TruecallerSDK(@NonNull ClientManager clientManager) {
        this.mTcClientManager = clientManager;
    }

    public static void clear() {
        TruecallerSDK truecallerSDK = sInstance;
        if (truecallerSDK != null) {
            TcClient tcClient = truecallerSDK.mTcClientManager.f47244a;
            if (tcClient != null && tcClient.f47259c == 2) {
                VerificationClient verificationClient = (VerificationClient) tcClient;
                if (verificationClient.f47268k != null) {
                    verificationClient.g();
                    verificationClient.f47268k = null;
                }
                Handler handler = verificationClient.f47269l;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    verificationClient.f47269l = null;
                }
            }
            sInstance.mTcClientManager.f47244a = null;
            ClientManager.f47243b = null;
            sInstance = null;
        }
    }

    public static TruecallerSDK getInstance() throws RuntimeException {
        TruecallerSDK truecallerSDK = sInstance;
        if (truecallerSDK != null) {
            return truecallerSDK;
        }
        throw new RuntimeException(TrueException.TYPE_SDK_NOT_INITIALIZED);
    }

    public static synchronized void init(@NonNull TruecallerSdkScope truecallerSdkScope) {
        sInstance = new TruecallerSDK(ClientManager.a(truecallerSdkScope));
    }

    public void getUserProfile(@NonNull FragmentActivity fragmentActivity) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        if (!isUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        TcClient tcClient = this.mTcClientManager.f47244a;
        if (tcClient.f47259c == 1) {
            TrueClient trueClient = (TrueClient) tcClient;
            try {
                Intent intentH = trueClient.h(fragmentActivity);
                if (intentH == null) {
                    trueClient.i(fragmentActivity, 11);
                    return;
                } else {
                    fragmentActivity.startActivityForResult(intentH, 100);
                    return;
                }
            } catch (ActivityNotFoundException unused) {
                trueClient.i(fragmentActivity, 15);
                return;
            }
        }
        SdkUtils.c(fragmentActivity);
        VerificationRequestManagerImpl verificationRequestManagerImpl = ((VerificationClient) tcClient).f47265h;
        ITrueCallback iTrueCallback = verificationRequestManagerImpl.f47197c;
        if (iTrueCallback != null) {
            iTrueCallback.onVerificationRequired(null);
            return;
        }
        TcOAuthCallback tcOAuthCallback = verificationRequestManagerImpl.f47198d;
        if (tcOAuthCallback != null) {
            tcOAuthCallback.onVerificationRequired(null);
        }
    }

    public boolean isUsable() {
        return this.mTcClientManager.f47244a != null;
    }

    public boolean onActivityResultObtained(@NonNull FragmentActivity fragmentActivity, int i2, int i3, @Nullable Intent intent) {
        if (i2 == 100) {
            if (!isUsable()) {
                throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
            }
            TcClient tcClient = this.mTcClientManager.f47244a;
            if (tcClient.f47259c == 1) {
                TrueClient trueClient = (TrueClient) tcClient;
                if (intent != null && intent.getExtras() != null) {
                    Bundle extras = intent.getExtras();
                    TrueResponse trueResponse = extras.containsKey(TrueResponse.TRUESDK_VERSION) ? new TrueResponse(extras) : (TrueResponse) extras.getParcelable(TrueResponse.TRUECALLER_RESPONSE_EXTRA);
                    if (trueResponse == null) {
                        trueClient.f47258b.onFailureProfileShared(new TrueError(7));
                        return false;
                    }
                    if (-1 == i3) {
                        TrueProfile trueProfile = trueResponse.trueProfile;
                        if (trueProfile != null) {
                            trueClient.f47258b.onSuccessProfileShared(trueProfile);
                            return true;
                        }
                    } else {
                        TrueError trueError = trueResponse.trueError;
                        if (trueError != null) {
                            int errorType = trueError.getErrorType();
                            if (errorType != 10 && errorType != 2 && errorType != 14 && errorType != 13) {
                                trueClient.f47258b.onFailureProfileShared(trueError);
                                return true;
                            }
                            trueClient.i(fragmentActivity, errorType);
                        }
                    }
                    return true;
                }
                trueClient.f47258b.onFailureProfileShared(new TrueError(5));
            }
        }
        return false;
    }

    public void requestVerification(@NonNull String str, @NonNull String phoneNumber, @NonNull VerificationCallback verificationCallback, @NonNull FragmentActivity fragmentActivity) throws PackageManager.NameNotFoundException {
        if (!isUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        TcClient tcClient = this.mTcClientManager.f47244a;
        if (tcClient.f47259c == 2) {
            VerificationClient verificationClient = (VerificationClient) tcClient;
            SdkUtils.a(fragmentActivity);
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            if (!SdkUtils.f47191b.matcher(phoneNumber).matches()) {
                throw new RuntimeException(TrueException.TYPE_INVALID_NUMBER);
            }
            String strA = Utils.a(fragmentActivity);
            if (TextUtils.isEmpty(verificationClient.f47261e)) {
                verificationClient.f47261e = UUID.randomUUID().toString();
            }
            String str2 = verificationClient.f47261e;
            String strB = SdkUtils.b(fragmentActivity);
            verificationClient.f47265h.a(str2, verificationClient.f47260d, str, phoneNumber, strB, verificationClient.f47267j, verificationCallback, strA);
        }
    }

    public void setLocale(@NonNull Locale locale) {
        if (!isUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        this.mTcClientManager.f47244a.f47262f = locale;
    }

    public void setRequestNonce(@NonNull String str) {
        if (!isUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        this.mTcClientManager.f47244a.f47261e = str;
    }

    public void setTheme(@NonNull @SdkThemeOptions int i2) {
        if (!isUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        this.mTcClientManager.f47244a.f47263g = i2;
    }

    public void updateCallback(@NonNull ITrueCallback iTrueCallback) {
        if (!isUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        ClientManager.f47243b.f47244a.f47258b = iTrueCallback;
    }

    public void verifyMissedCall(@NonNull TrueProfile trueProfile, @NonNull VerificationCallback verificationCallback) {
        if (!isUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        TcClient tcClient = this.mTcClientManager.f47244a;
        if (tcClient.f47259c == 2) {
            VerificationClient verificationClient = (VerificationClient) tcClient;
            VerificationRequestManagerImpl verificationRequestManagerImpl = verificationClient.f47265h;
            String str = verificationRequestManagerImpl.f47205k;
            if (str != null) {
                verificationRequestManagerImpl.b(trueProfile, str, verificationClient.f47260d, verificationCallback);
            } else {
                verificationCallback.onRequestFailure(5, new TrueException(3, TrueException.TYPE_MISSING_CREATE_CALL_MESSAGE));
            }
        }
    }

    public void verifyOtp(@NonNull TrueProfile trueProfile, @NonNull String str, @NonNull VerificationCallback verificationCallback) {
        if (!isUsable()) {
            throw new RuntimeException(TrueException.TYPE_CLIENT_MISSING);
        }
        TcClient tcClient = this.mTcClientManager.f47244a;
        if (tcClient.f47259c == 2) {
            VerificationClient verificationClient = (VerificationClient) tcClient;
            verificationClient.f47265h.b(trueProfile, str, verificationClient.f47260d, verificationCallback);
        }
    }

    public void getUserProfile(@NonNull Fragment fragment) throws PackageManager.NameNotFoundException, NoSuchAlgorithmException {
        if (isUsable()) {
            TcClient tcClient = this.mTcClientManager.f47244a;
            if (tcClient.f47259c == 1) {
                TrueClient trueClient = (TrueClient) tcClient;
                FragmentActivity activity = fragment.getActivity();
                if (activity != null) {
                    try {
                        Intent intentH = trueClient.h(activity);
                        if (intentH == null) {
                            trueClient.i(activity, 11);
                            return;
                        } else {
                            fragment.startActivityForResult(intentH, 100);
                            return;
                        }
                    } catch (ActivityNotFoundException unused) {
                        trueClient.i(activity, 15);
                        return;
                    }
                }
                return;
            }
            SdkUtils.c(fragment.getActivity());
            VerificationRequestManagerImpl verificationRequestManagerImpl = ((VerificationClient) tcClient).f47265h;
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
