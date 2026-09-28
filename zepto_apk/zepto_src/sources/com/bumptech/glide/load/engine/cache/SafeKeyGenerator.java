package com.bumptech.glide.load.engine.cache;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes3.dex */
public class SafeKeyGenerator {

    /* renamed from: a, reason: collision with root package name */
    public final LruCache f16109a = new LruCache(1000);

    /* renamed from: b, reason: collision with root package name */
    public final Pools.Pool f16110b = FactoryPools.a(10, new AnonymousClass1());

    /* renamed from: com.bumptech.glide.load.engine.cache.SafeKeyGenerator$1, reason: invalid class name */
    public class AnonymousClass1 implements FactoryPools.Factory<PoolableDigestContainer> {
        @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
        public final Object create() {
            try {
                return new PoolableDigestContainer(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    public static final class PoolableDigestContainer implements FactoryPools.Poolable {

        /* renamed from: a, reason: collision with root package name */
        public final MessageDigest f16111a;

        /* renamed from: b, reason: collision with root package name */
        public final StateVerifier f16112b = StateVerifier.a();

        public PoolableDigestContainer(MessageDigest messageDigest) {
            this.f16111a = messageDigest;
        }

        @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
        public final StateVerifier b() {
            return this.f16112b;
        }
    }

    public final String a(Key key) {
        String str;
        synchronized (this.f16109a) {
            str = (String) this.f16109a.b(key);
        }
        if (str == null) {
            Object objB = this.f16110b.b();
            Preconditions.c(objB, "Argument must not be null");
            PoolableDigestContainer poolableDigestContainer = (PoolableDigestContainer) objB;
            try {
                key.b(poolableDigestContainer.f16111a);
                byte[] bArrDigest = poolableDigestContainer.f16111a.digest();
                char[] cArr = Util.f16529b;
                synchronized (cArr) {
                    for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                        byte b2 = bArrDigest[i2];
                        int i3 = i2 * 2;
                        char[] cArr2 = Util.f16528a;
                        cArr[i3] = cArr2[(b2 & 255) >>> 4];
                        cArr[i3 + 1] = cArr2[b2 & 15];
                    }
                    str = new String(cArr);
                }
            } finally {
                this.f16110b.a(poolableDigestContainer);
            }
        }
        synchronized (this.f16109a) {
            this.f16109a.e(key, str);
        }
        return str;
    }
}
