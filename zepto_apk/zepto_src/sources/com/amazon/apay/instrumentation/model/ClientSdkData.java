package com.amazon.apay.instrumentation.model;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class ClientSdkData {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f15044a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Context f15045b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f15046c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f15047d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f15048e;

    public ClientSdkData(@NotNull String clientId, @NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f15044a = clientId;
        this.f15045b = context;
        this.f15046c = str;
        this.f15047d = str2;
        this.f15048e = str3;
    }

    @Nullable
    public final String getAppMetadata() {
        return this.f15048e;
    }

    @Nullable
    public final String getAppName() {
        return this.f15046c;
    }

    @Nullable
    public final String getAppVersion() {
        return this.f15047d;
    }

    @NotNull
    public final String getClientId() {
        return this.f15044a;
    }

    @NotNull
    public final Context getContext() {
        return this.f15045b;
    }
}
