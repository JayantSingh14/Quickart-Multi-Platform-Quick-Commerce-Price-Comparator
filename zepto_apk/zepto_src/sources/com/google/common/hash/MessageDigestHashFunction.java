package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f43216a;

    public static final class MessageDigestHasher extends AbstractByteHasher {
    }

    public static final class SerializedForm implements Serializable {
    }

    public MessageDigestHashFunction(String str, String str2) throws NoSuchAlgorithmException, CloneNotSupportedException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.getDigestLength();
            this.f43216a = str2;
            try {
                messageDigest.clone();
            } catch (CloneNotSupportedException unused) {
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String toString() {
        return this.f43216a;
    }
}
