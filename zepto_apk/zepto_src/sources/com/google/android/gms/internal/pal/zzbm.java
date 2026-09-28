package com.google.android.gms.internal.pal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
final class zzbm implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzbn.f37548b = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            countDownLatch = zzbn.f37551e;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzbn.f37551e;
        } catch (Throwable th) {
            zzbn.f37551e.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }
}
