package com.bumptech.glide.load.engine.prefill;

import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class BitmapPreFillRunner implements Runnable {

    @VisibleForTesting
    public static class Clock {
    }

    public static final class UniqueKey implements Key {
        @Override // com.bumptech.glide.load.Key
        public final void b(MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        TimeUnit.SECONDS.toMillis(1L);
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw null;
    }
}
