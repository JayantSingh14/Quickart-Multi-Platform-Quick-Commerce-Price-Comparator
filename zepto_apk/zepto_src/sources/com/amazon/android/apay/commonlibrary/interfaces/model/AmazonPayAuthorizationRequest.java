package com.amazon.android.apay.commonlibrary.interfaces.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public final class AmazonPayAuthorizationRequest {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f14937a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f14938b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final List<String> f14939c;

    public AmazonPayAuthorizationRequest(@NotNull String clientId, @NotNull String codeChallenge, @Nullable List<String> list) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(codeChallenge, "codeChallenge");
        this.f14937a = clientId;
        this.f14938b = codeChallenge;
        this.f14939c = list;
    }

    @Nullable
    public final List<String> getAdditionalAuthScopes() {
        return this.f14939c;
    }

    @NotNull
    public final String getClientId() {
        return this.f14937a;
    }

    @NotNull
    public final String getCodeChallenge() {
        return this.f14938b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AmazonPayAuthorizationRequest(@NotNull String clientId, @NotNull String codeChallenge) {
        this(clientId, codeChallenge, null);
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(codeChallenge, "codeChallenge");
    }
}
