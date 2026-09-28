package androidx.startup;

import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes3.dex */
public final class StartupException extends RuntimeException {
    public StartupException() {
        super("Context cannot be null");
    }

    public StartupException(Throwable th) {
        super(th);
    }
}
