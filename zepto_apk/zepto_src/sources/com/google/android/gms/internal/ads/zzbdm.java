package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class zzbdm {

    /* renamed from: b, reason: collision with root package name */
    public static MessageDigest f24802b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f24803a = new Object();

    public final MessageDigest a() {
        synchronized (this.f24803a) {
            MessageDigest messageDigest = f24802b;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    f24802b = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return f24802b;
        }
    }
}
