package com.facebook.react.bridge;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes3.dex */
public final class ReactIgnorableMountingException extends RuntimeException {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean isIgnorable(@NotNull Throwable e2) {
            Intrinsics.checkNotNullParameter(e2, "e");
            while (e2 != null) {
                if (e2 instanceof ReactIgnorableMountingException) {
                    return true;
                }
                e2 = e2.getCause();
            }
            return false;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactIgnorableMountingException(@NotNull String m2) {
        super(m2);
        Intrinsics.checkNotNullParameter(m2, "m");
    }

    @JvmStatic
    public static final boolean isIgnorable(@NotNull Throwable th) {
        return Companion.isIgnorable(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactIgnorableMountingException(@NotNull Throwable e2) {
        super(e2);
        Intrinsics.checkNotNullParameter(e2, "e");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactIgnorableMountingException(@NotNull String m2, @NotNull Throwable e2) {
        super(m2, e2);
        Intrinsics.checkNotNullParameter(m2, "m");
        Intrinsics.checkNotNullParameter(e2, "e");
    }
}
