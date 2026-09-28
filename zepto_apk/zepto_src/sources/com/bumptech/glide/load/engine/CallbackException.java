package com.bumptech.glide.load.engine;

/* loaded from: classes3.dex */
final class CallbackException extends RuntimeException {
    public CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
