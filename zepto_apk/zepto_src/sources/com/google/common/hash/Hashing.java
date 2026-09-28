package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.util.Arrays;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@ElementTypesAreNonnullByDefault
/* loaded from: classes.dex */
public final class Hashing {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43208a = 0;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Immutable
    /* loaded from: classes4.dex */
    public static abstract class ChecksumType implements ImmutableSupplier<Checksum> {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChecksumType[] f43209a = {new AnonymousClass1("CRC_32", 0), new AnonymousClass2("ADLER_32", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        ChecksumType EF6;

        /* renamed from: com.google.common.hash.Hashing$ChecksumType$1, reason: invalid class name */
        public enum AnonymousClass1 extends ChecksumType {
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new CRC32();
            }
        }

        /* renamed from: com.google.common.hash.Hashing$ChecksumType$2, reason: invalid class name */
        public enum AnonymousClass2 extends ChecksumType {
            @Override // com.google.common.base.Supplier
            public final Object get() {
                return new Adler32();
            }
        }

        public static ChecksumType valueOf(String str) {
            return (ChecksumType) Enum.valueOf(ChecksumType.class, str);
        }

        public static ChecksumType[] values() {
            return (ChecksumType[]) f43209a.clone();
        }
    }

    /* loaded from: classes4.dex */
    public static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        public final boolean equals(Object obj) {
            if (!(obj instanceof ConcatenatedHashFunction)) {
                return false;
            }
            ((ConcatenatedHashFunction) obj).getClass();
            return Arrays.equals((Object[]) null, (Object[]) null);
        }

        public final int hashCode() {
            return Arrays.hashCode((Object[]) null);
        }
    }

    /* loaded from: classes4.dex */
    public static final class LinearCongruentialGenerator {
    }

    /* loaded from: classes4.dex */
    public static class Md5Holder {
        static {
            new MessageDigestHashFunction(MessageDigestAlgorithms.MD5, "Hashing.md5()");
        }
    }

    /* loaded from: classes4.dex */
    public static class Sha1Holder {
        static {
            new MessageDigestHashFunction(MessageDigestAlgorithms.SHA_1, "Hashing.sha1()");
        }
    }

    /* loaded from: classes4.dex */
    public static class Sha256Holder {
        static {
            new MessageDigestHashFunction(MessageDigestAlgorithms.SHA_256, "Hashing.sha256()");
        }
    }

    /* loaded from: classes4.dex */
    public static class Sha384Holder {
        static {
            new MessageDigestHashFunction(MessageDigestAlgorithms.SHA_384, "Hashing.sha384()");
        }
    }

    /* loaded from: classes4.dex */
    public static class Sha512Holder {
        static {
            new MessageDigestHashFunction(MessageDigestAlgorithms.SHA_512, "Hashing.sha512()");
        }
    }

    static {
        System.currentTimeMillis();
    }

    public static HashFunction a() {
        return Murmur3_32HashFunction.f43218a;
    }
}
