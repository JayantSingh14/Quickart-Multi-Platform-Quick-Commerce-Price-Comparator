package com.google.firebase.sessions;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class UuidGeneratorImpl implements UuidGenerator {

    /* renamed from: a, reason: collision with root package name */
    public static final UuidGeneratorImpl f45124a = new UuidGeneratorImpl();

    @Override // com.google.firebase.sessions.UuidGenerator
    public final UUID next() {
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        return uuidRandomUUID;
    }
}
