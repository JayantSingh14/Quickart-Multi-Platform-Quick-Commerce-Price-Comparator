package com.google.ads.interactivemedia.v3.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes3.dex */
final class zzfr implements Runnable {
    private zzfr() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        CountDownLatch countDownLatch;
        try {
            zzfs.zzd = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            countDownLatch = zzfs.zzb;
        } catch (NoSuchAlgorithmException unused) {
            countDownLatch = zzfs.zzb;
        } catch (Throwable th) {
            zzfs.zzb.countDown();
            throw th;
        }
        countDownLatch.countDown();
    }

    public /* synthetic */ zzfr(zzfq zzfqVar) {
    }
}
