package com.truecaller.android.sdk.common.network;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.Scopes;
import com.truecaller.android.sdk.common.models.TrueProfile;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

@RestrictTo
/* loaded from: classes4.dex */
public interface ProfileService {
    @POST(Scopes.PROFILE)
    Call<JSONObject> a(@NonNull @Header("Authorization") String str, @NonNull @Body TrueProfile trueProfile);

    @GET(Scopes.PROFILE)
    Call<TrueProfile> b(@NonNull @Header("Authorization") String str);
}
