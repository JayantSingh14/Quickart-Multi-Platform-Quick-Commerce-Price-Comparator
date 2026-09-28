package com.truecaller.android.sdk.common;

import android.os.Handler;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.common.VerificationRequestManager;
import com.truecaller.android.sdk.common.callbacks.ImOtpCallInstallationCallback;
import com.truecaller.android.sdk.common.callbacks.VerifyInstallationCallback;
import com.truecaller.android.sdk.common.models.CreateInstallationModel;
import com.truecaller.android.sdk.common.models.TrueProfile;
import com.truecaller.android.sdk.common.models.VerifyInstallationModel;
import com.truecaller.android.sdk.common.network.ProfileService;
import com.truecaller.android.sdk.common.network.VerificationService;
import com.truecaller.android.sdk.common.otpVerification.SmsRetrieverClientHandler;
import com.truecaller.android.sdk.legacy.ITrueCallback;
import com.truecaller.android.sdk.legacy.clients.VerificationClient;
import com.truecaller.android.sdk.oAuth.TcOAuthCallback;
import com.truecaller.android.sdk.oAuth.clients.VerificationClientV2;
import java.util.regex.Pattern;

@RestrictTo
/* loaded from: classes4.dex */
public final class VerificationRequestManagerImpl implements VerificationRequestManager {

    /* renamed from: a, reason: collision with root package name */
    public final ProfileService f47195a;

    /* renamed from: b, reason: collision with root package name */
    public final VerificationService f47196b;

    /* renamed from: c, reason: collision with root package name */
    public final ITrueCallback f47197c;

    /* renamed from: d, reason: collision with root package name */
    public final TcOAuthCallback f47198d;

    /* renamed from: e, reason: collision with root package name */
    public final VerificationRequestManager.Client f47199e;

    /* renamed from: f, reason: collision with root package name */
    public final SmsRetrieverClientHandler f47200f;

    /* renamed from: g, reason: collision with root package name */
    public String f47201g;

    /* renamed from: h, reason: collision with root package name */
    public String f47202h;

    /* renamed from: i, reason: collision with root package name */
    public String f47203i;

    /* renamed from: j, reason: collision with root package name */
    public String f47204j;

    /* renamed from: k, reason: collision with root package name */
    public String f47205k;

    /* renamed from: l, reason: collision with root package name */
    public final Pattern f47206l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f47207m;

    public VerificationRequestManagerImpl(VerificationClient verificationClient, ProfileService profileService, VerificationService verificationService, ITrueCallback iTrueCallback, SmsRetrieverClientHandler smsRetrieverClientHandler) {
        this.f47206l = Pattern.compile("^(?=.*?[\\w&&[\\D]&&[^_]])[\\w\\W]{1,128}$");
        this.f47195a = profileService;
        this.f47196b = verificationService;
        this.f47199e = verificationClient;
        this.f47197c = iTrueCallback;
        this.f47200f = smsRetrieverClientHandler;
        this.f47198d = null;
        this.f47207m = false;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, boolean z, VerificationCallback verificationCallback, String str6) {
        this.f47201g = str4;
        this.f47202h = str3;
        this.f47203i = str6;
        CreateInstallationModel createInstallationModel = new CreateInstallationModel(str, str3, str4, str5, z);
        VerificationRequestManager.Client client = this.f47199e;
        createInstallationModel.setSimState(client.e());
        createInstallationModel.setAirplaneModeDisabled(client.b());
        if (client.d()) {
            createInstallationModel.setPhonePermission(true);
        }
        Handler handler = client.getHandler();
        ImOtpCallInstallationCallback imOtpCallInstallationCallback = new ImOtpCallInstallationCallback(verificationCallback, this, this.f47200f);
        imOtpCallInstallationCallback.f47225g = handler;
        boolean z2 = this.f47207m;
        VerificationService verificationService = this.f47196b;
        if (z2) {
            verificationService.c(str2, str6, createInstallationModel).N(imOtpCallInstallationCallback);
        } else {
            verificationService.b(str2, str6, createInstallationModel).N(imOtpCallInstallationCallback);
        }
    }

    public final void b(TrueProfile trueProfile, String str, String str2, VerificationCallback verificationCallback) {
        if (this.f47201g == null || this.f47204j == null || this.f47202h == null) {
            verificationCallback.onRequestFailure(5, new TrueException(3, TrueException.TYPE_MISSING_CREATE_CALL_MESSAGE));
            return;
        }
        String str3 = trueProfile.firstName;
        Pattern pattern = this.f47206l;
        boolean z = false;
        if ((str3 == null || str3.trim().isEmpty()) ? false : pattern.matcher(str3).matches()) {
            String str4 = trueProfile.lastName;
            if (str4 == null ? false : str4.trim().isEmpty() ? true : pattern.matcher(str4).matches()) {
                z = true;
            }
        }
        if (!z) {
            verificationCallback.onRequestFailure(5, new TrueException(5, TrueException.TYPE_INVALID_NAME_MESSAGE));
            return;
        }
        VerifyInstallationModel verifyInstallationModel = new VerifyInstallationModel(this.f47204j, this.f47201g, this.f47202h, str);
        VerifyInstallationCallback verifyInstallationCallback = new VerifyInstallationCallback(str2, verifyInstallationModel, verificationCallback, trueProfile, this);
        boolean z2 = this.f47207m;
        VerificationService verificationService = this.f47196b;
        if (z2) {
            verificationService.d(str2, this.f47203i, verifyInstallationModel).N(verifyInstallationCallback);
        } else {
            verificationService.a(str2, this.f47203i, verifyInstallationModel).N(verifyInstallationCallback);
        }
    }

    public VerificationRequestManagerImpl(VerificationClientV2 verificationClientV2, ProfileService profileService, VerificationService verificationService, TcOAuthCallback tcOAuthCallback, SmsRetrieverClientHandler smsRetrieverClientHandler) {
        this.f47206l = Pattern.compile("^(?=.*?[\\w&&[\\D]&&[^_]])[\\w\\W]{1,128}$");
        this.f47195a = profileService;
        this.f47196b = verificationService;
        this.f47199e = verificationClientV2;
        this.f47198d = tcOAuthCallback;
        this.f47200f = smsRetrieverClientHandler;
        this.f47197c = null;
        this.f47207m = true;
    }
}
