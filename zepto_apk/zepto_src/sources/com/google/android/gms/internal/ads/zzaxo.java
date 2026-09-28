package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
final class zzaxo implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzaxp.f24443b = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            countDownLatch = zzaxp.f24446e;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzaxp.f24446e;
        } catch (Throwable th) {
            zzaxp.f24446e.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
