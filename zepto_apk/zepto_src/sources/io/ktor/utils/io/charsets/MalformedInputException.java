package io.ktor.utils.io.charsets;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public class MalformedInputException extends java.nio.charset.MalformedInputException {

    /* renamed from: a, reason: collision with root package name */
    public final String f51179a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MalformedInputException(String message) {
        super(0);
        Intrinsics.checkNotNullParameter(message, "message");
        this.f51179a = message;
    }

    @Override // java.nio.charset.MalformedInputException, java.lang.Throwable
    public final String getMessage() {
        return this.f51179a;
    }
}
