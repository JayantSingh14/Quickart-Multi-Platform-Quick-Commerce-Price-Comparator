package com.truecaller.android.sdk.common.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.common.models.CreateInstallationModel;
import com.truecaller.android.sdk.common.models.VerifyInstallationModel;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

@RestrictTo
/* loaded from: classes4.dex */
public interface VerificationService {
    @POST("verify")
    Call<Map<String, Object>> a(@NonNull @Header("appKey") String str, @NonNull @Header("fingerPrint") String str2, @NonNull @Body VerifyInstallationModel verifyInstallationModel);

    @POST(CLConstants.CRED_SUB_TYPE_MANDATE_CREATE)
    Call<Map<String, Object>> b(@NonNull @Header("appKey") String str, @NonNull @Header("fingerPrint") String str2, @Nullable @Body CreateInstallationModel createInstallationModel);

    @POST(CLConstants.CRED_SUB_TYPE_MANDATE_CREATE)
    Call<Map<String, Object>> c(@NonNull @Header("clientId") String str, @NonNull @Header("fingerPrint") String str2, @Nullable @Body CreateInstallationModel createInstallationModel);

    @POST("verify")
    Call<Map<String, Object>> d(@NonNull @Header("clientId") String str, @NonNull @Header("fingerPrint") String str2, @NonNull @Body VerifyInstallationModel verifyInstallationModel);
}
