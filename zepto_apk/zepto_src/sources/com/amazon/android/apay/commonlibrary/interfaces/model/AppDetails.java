package com.amazon.android.apay.commonlibrary.interfaces.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class AppDetails {

    /* renamed from: a, reason: collision with root package name */
    @SerializedName("packageName")
    @NotNull
    public final String f14946a;

    /* renamed from: b, reason: collision with root package name */
    @SerializedName("applicationName")
    @NotNull
    public final String f14947b;

    /* renamed from: c, reason: collision with root package name */
    @SerializedName("version")
    @NotNull
    public final String f14948c;

    public AppDetails(@NotNull String packageName, @NotNull String applicationName, @NotNull String version) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(applicationName, "applicationName");
        Intrinsics.checkNotNullParameter(version, "version");
        this.f14946a = packageName;
        this.f14947b = applicationName;
        this.f14948c = version;
    }

    @NotNull
    public final String getApplicationName() {
        return this.f14947b;
    }

    @NotNull
    public final String getPackageName() {
        return this.f14946a;
    }

    @NotNull
    public final String getVersion() {
        return this.f14948c;
    }
}
