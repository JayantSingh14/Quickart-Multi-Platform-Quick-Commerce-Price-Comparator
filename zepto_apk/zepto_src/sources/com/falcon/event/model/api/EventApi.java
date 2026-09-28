package com.falcon.event.model.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata
/* loaded from: classes3.dex */
public interface EventApi {
    @POST("v2/publish-events")
    @NotNull
    Call<Void> a(@Body @NotNull EventRequestType eventRequestType);
}
