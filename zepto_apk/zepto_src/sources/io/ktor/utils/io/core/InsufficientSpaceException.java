package io.ktor.utils.io.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class InsufficientSpaceException extends Exception {
    public InsufficientSpaceException() {
        this("Not enough free space");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsufficientSpaceException(String message) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InsufficientSpaceException(String name, int i2, int i3) {
        this("Not enough free space to write " + name + " of " + i2 + " bytes, available " + i3 + " bytes.");
        Intrinsics.checkNotNullParameter(name, "name");
    }
}
