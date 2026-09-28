package org.xbill.DNS;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.codec.language.Soundex;
import org.xbill.DNS.utils.base16;
import org.xbill.DNS.utils.base32;

/* loaded from: classes5.dex */
public class NSEC3Record extends Record {
    public static final int SHA1_DIGEST_ID = 1;
    private static final base32 b32 = new base32(base32.Alphabet.BASE32HEX, false, false);
    private int flags;
    private int hashAlg;
    private int iterations;
    private byte[] next;
    private byte[] salt;
    private TypeBitmap types;

    public static class Digest {
        public static final int SHA1 = 1;
        private static final Mnemonic digests;

        static {
            Mnemonic mnemonic = new Mnemonic("DNSSEC NSEC3 Hash Algorithms", 1);
            digests = mnemonic;
            mnemonic.add(1, MessageDigestAlgorithms.SHA_1);
        }

        private Digest() {
        }

        public static String string(int i2) {
            return digests.getText(i2);
        }

        public static int value(String str) {
            return digests.getValue(str);
        }
    }

    public static class Flags {
        public static final int OPT_OUT = 1;

        private Flags() {
        }
    }

    public NSEC3Record() {
    }

    public static byte[] hashName(Name name, int i2, int i3, byte[] bArr) throws NoSuchAlgorithmException {
        if (i2 != 1) {
            throw new NoSuchAlgorithmException(android.support.v4.media.b.f(i2, "Unknown NSEC3 algorithm identifier: "));
        }
        MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
        byte[] bArrDigest = null;
        for (int i4 = 0; i4 <= i3; i4++) {
            messageDigest.reset();
            if (i4 == 0) {
                messageDigest.update(name.toWireCanonical());
            } else {
                messageDigest.update(bArrDigest);
            }
            if (bArr != null) {
                messageDigest.update(bArr);
            }
            bArrDigest = messageDigest.digest();
        }
        return bArrDigest;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getHashAlgorithm() {
        return this.hashAlg;
    }

    public int getIterations() {
        return this.iterations;
    }

    public byte[] getNext() {
        return this.next;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public int[] getTypes() {
        return this.types.toArray();
    }

    public boolean hasType(int i2) {
        return this.types.contains(i2);
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.hashAlg = tokenizer.getUInt8();
        this.flags = tokenizer.getUInt8();
        this.iterations = tokenizer.getUInt16();
        if (tokenizer.getString().equals("-")) {
            this.salt = null;
        } else {
            tokenizer.unget();
            byte[] hexString = tokenizer.getHexString();
            this.salt = hexString;
            if (hexString.length > 255) {
                throw tokenizer.exception("salt value too long");
            }
        }
        this.next = tokenizer.getBase32String(b32);
        this.types = new TypeBitmap(tokenizer);
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.hashAlg = dNSInput.readU8();
        this.flags = dNSInput.readU8();
        this.iterations = dNSInput.readU16();
        int u8 = dNSInput.readU8();
        if (u8 > 0) {
            this.salt = dNSInput.readByteArray(u8);
        } else {
            this.salt = null;
        }
        this.next = dNSInput.readByteArray(dNSInput.readU8());
        this.types = new TypeBitmap(dNSInput);
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.hashAlg);
        sb.append(' ');
        sb.append(this.flags);
        sb.append(' ');
        sb.append(this.iterations);
        sb.append(' ');
        byte[] bArr = this.salt;
        if (bArr == null) {
            sb.append(Soundex.SILENT_MARKER);
        } else {
            sb.append(base16.toString(bArr));
        }
        sb.append(' ');
        sb.append(b32.toString(this.next));
        if (!this.types.empty()) {
            sb.append(' ');
            sb.append(this.types.toString());
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU8(this.hashAlg);
        dNSOutput.writeU8(this.flags);
        dNSOutput.writeU16(this.iterations);
        byte[] bArr = this.salt;
        if (bArr != null) {
            dNSOutput.writeU8(bArr.length);
            dNSOutput.writeByteArray(this.salt);
        } else {
            dNSOutput.writeU8(0);
        }
        dNSOutput.writeU8(this.next.length);
        dNSOutput.writeByteArray(this.next);
        this.types.toWire(dNSOutput);
    }

    public NSEC3Record(Name name, int i2, long j2, int i3, int i4, int i5, byte[] bArr, byte[] bArr2, int[] iArr) {
        super(name, 50, i2, j2);
        this.hashAlg = Record.checkU8("hashAlg", i3);
        this.flags = Record.checkU8("flags", i4);
        this.iterations = Record.checkU16("iterations", i5);
        if (bArr != null) {
            if (bArr.length > 255) {
                throw new IllegalArgumentException("Invalid salt");
            }
            if (bArr.length > 0) {
                byte[] bArr3 = new byte[bArr.length];
                this.salt = bArr3;
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            }
        }
        if (bArr2.length > 255) {
            throw new IllegalArgumentException("Invalid next hash");
        }
        byte[] bArr4 = new byte[bArr2.length];
        this.next = bArr4;
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        this.types = new TypeBitmap(iArr);
    }

    public byte[] hashName(Name name) throws NoSuchAlgorithmException {
        return hashName(name, this.hashAlg, this.iterations, this.salt);
    }
}
