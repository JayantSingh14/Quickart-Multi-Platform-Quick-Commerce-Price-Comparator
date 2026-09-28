package org.xbill.DNS;

import in.juspay.hypersdk.core.Constants;
import j$.time.Instant;
import j$.util.DateRetargetClass;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import lombok.Generated;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes5.dex */
public class DNSSEC {
    static final int ASN1_BITSTRING = 3;
    static final int ASN1_INT = 2;
    static final int ASN1_OID = 6;
    static final int ASN1_SEQ = 48;
    private static final int DSA_LEN = 20;
    private static final ECKeyInfo GOST = new ECKeyInfo(32, "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD97", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFD94", "A6", "1", "8D91E471E0989CDA27DF505A453F2B7635294F2DDF23E3B122ACC99C9E9F1E14", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF6C611070995AD10045841B09B761B893");
    private static final ECKeyInfo ECDSA_P256 = new ECKeyInfo(32, "FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF", "FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC", "5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B", "6B17D1F2E12C4247F8BCE6E563A440F277037D812DEB33A0F4A13945D898C296", "4FE342E2FE1A7F9B8EE7EB4A7C0F9E162BCE33576B315ECECBB6406837BF51F5", "FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551");
    private static final ECKeyInfo ECDSA_P384 = new ECKeyInfo(48, "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC", "B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF", "AA87CA22BE8B05378EB1C71EF320AD746E1D3B628BA79B9859F741E082542A385502F25DBF55296C3A545E3872760AB7", "3617DE4A96262C6F5D9E98BF9292DC29F8F41DBD289A147CE9DA3113B5F0B8C00A60B1CE1D7E819D7A431D7C90EA0E5F", "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973");

    public static class Algorithm {
        public static final int DELETE = 0;
        public static final int DH = 2;
        public static final int DSA = 3;
        public static final int DSA_NSEC3_SHA1 = 6;
        public static final int ECC_GOST = 12;
        public static final int ECC_GOST12 = 23;
        public static final int ECDSAP256SHA256 = 13;
        public static final int ECDSAP384SHA384 = 14;
        public static final int ED25519 = 15;
        public static final int ED448 = 16;
        public static final int INDIRECT = 252;
        public static final int PRIVATEDNS = 253;
        public static final int PRIVATEOID = 254;
        public static final int RSAMD5 = 1;
        public static final int RSASHA1 = 5;
        public static final int RSASHA256 = 8;
        public static final int RSASHA512 = 10;
        public static final int RSA_NSEC3_SHA1 = 7;
        public static final int SM2SM3 = 17;
        private static final Mnemonic algs;

        static {
            Mnemonic mnemonic = new Mnemonic("DNSSEC algorithm", 2);
            algs = mnemonic;
            mnemonic.setMaximum(255);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(0, "DELETE");
            mnemonic.add(1, "RSAMD5");
            mnemonic.add(2, "DH");
            mnemonic.add(3, "DSA");
            mnemonic.add(5, "RSASHA1");
            mnemonic.add(6, "DSA-NSEC3-SHA1");
            mnemonic.add(7, "RSASHA1-NSEC3-SHA1");
            mnemonic.add(8, "RSASHA256");
            mnemonic.add(10, "RSASHA512");
            mnemonic.add(12, "ECC-GOST");
            mnemonic.add(13, "ECDSAP256SHA256");
            mnemonic.add(14, "ECDSAP384SHA384");
            mnemonic.add(15, "ED25519");
            mnemonic.add(16, "ED448");
            mnemonic.add(17, "SM2SM3");
            mnemonic.add(23, "ECC-GOST12");
            mnemonic.add(252, "INDIRECT");
            mnemonic.add(253, "PRIVATEDNS");
            mnemonic.add(254, "PRIVATEOID");
        }

        private Algorithm() {
        }

        public static void check(int i2) {
            algs.check(i2);
        }

        public static String string(int i2) {
            return algs.getText(i2);
        }

        public static int value(String str) {
            return algs.getValue(str);
        }
    }

    public static class DNSSECException extends Exception {
        public DNSSECException(String str, Throwable th) {
            super(str, th);
        }

        public DNSSECException(Throwable th) {
            super(th);
        }

        public DNSSECException(String str) {
            super(str);
        }
    }

    public static class Digest {
        public static final int GOST3411 = 3;
        public static final int GOST3411_12 = 5;
        public static final int SHA1 = 1;
        public static final int SHA256 = 2;
        public static final int SHA384 = 4;
        public static final int SM3 = 6;
        private static final Map<Integer, Integer> algLengths;
        private static final Mnemonic algs;

        static {
            Mnemonic mnemonic = new Mnemonic("DNSSEC Digest Algorithm", 2);
            algs = mnemonic;
            HashMap map = new HashMap(4);
            algLengths = map;
            mnemonic.setMaximum(255);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(1, MessageDigestAlgorithms.SHA_1);
            map.put(1, 20);
            mnemonic.add(2, MessageDigestAlgorithms.SHA_256);
            map.put(2, 32);
            mnemonic.add(3, "GOST R 34.11-94");
            map.put(3, 32);
            mnemonic.add(4, MessageDigestAlgorithms.SHA_384);
            map.put(4, 48);
            mnemonic.add(5, "GOST12");
            map.put(5, 64);
            mnemonic.add(6, "SM3");
            map.put(6, 32);
        }

        private Digest() {
        }

        public static int algLength(int i2) {
            Integer num = algLengths.get(Integer.valueOf(i2));
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public static String string(int i2) {
            return algs.getText(i2);
        }

        public static int value(String str) {
            return algs.getValue(str);
        }
    }

    public static class ECKeyInfo {
        EllipticCurve curve;
        int length;
        ECParameterSpec spec;

        public ECKeyInfo(int i2, String str, String str2, String str3, String str4, String str5, String str6) {
            this.length = i2;
            BigInteger bigInteger = new BigInteger(str, 16);
            BigInteger bigInteger2 = new BigInteger(str2, 16);
            BigInteger bigInteger3 = new BigInteger(str3, 16);
            BigInteger bigInteger4 = new BigInteger(str4, 16);
            BigInteger bigInteger5 = new BigInteger(str5, 16);
            BigInteger bigInteger6 = new BigInteger(str6, 16);
            this.curve = new EllipticCurve(new ECFieldFp(bigInteger), bigInteger2, bigInteger3);
            this.spec = new ECParameterSpec(this.curve, new ECPoint(bigInteger4, bigInteger5), bigInteger6, 1);
        }
    }

    public static class IncompatibleKeyException extends IllegalArgumentException {
        public IncompatibleKeyException() {
            super("incompatible keys");
        }
    }

    public static class InvalidDnskeyException extends DNSSECException {
        private final int edeCode;

        public InvalidDnskeyException(DNSKEYRecord dNSKEYRecord, String str, int i2) {
            super("DNSKEY " + dNSKEYRecord.getName() + " is invalid, " + str);
            this.edeCode = i2;
        }

        @Generated
        public int getEdeCode() {
            return this.edeCode;
        }
    }

    public static class KeyMismatchException extends DNSSECException {
        public KeyMismatchException(KEYBase kEYBase, SIGBase sIGBase) {
            super("key " + kEYBase.getName() + "/" + Algorithm.string(kEYBase.getAlgorithm()) + "/" + kEYBase.getFootprint() + " does not match signature " + sIGBase.getSigner() + "/" + Algorithm.string(sIGBase.getAlgorithm()) + "/" + sIGBase.getFootprint());
        }
    }

    public static class MalformedKeyException extends DNSSECException {
        public MalformedKeyException(String str) {
            super(str);
        }

        public MalformedKeyException(Record record, Throwable th) {
            super("Invalid key data: " + record.rdataToString(), th);
        }
    }

    public static class NoSignatureException extends DNSSECException {
        public NoSignatureException() {
            super("no signature found");
        }
    }

    public static class SignatureExpiredException extends DNSSECException {
        private final Instant now;
        private final Instant when;

        public SignatureExpiredException(Instant instant, Instant instant2) {
            super("signature expired");
            this.when = instant;
            this.now = instant2;
        }

        public Instant getExpiration() {
            return this.when;
        }

        public Instant getVerifyTime() {
            return this.now;
        }
    }

    public static class SignatureNotYetValidException extends DNSSECException {
        private final Instant now;
        private final Instant when;

        public SignatureNotYetValidException(Instant instant, Instant instant2) {
            super("signature is not yet valid");
            this.when = instant;
            this.now = instant2;
        }

        public Instant getExpiration() {
            return this.when;
        }

        public Instant getVerifyTime() {
            return this.now;
        }
    }

    public static class SignatureVerificationException extends DNSSECException {
        public SignatureVerificationException(Throwable th) {
            super("Signature verification failed", th);
        }

        public SignatureVerificationException(String str) {
            super(android.support.v4.media.b.C("Signature verification failed: ", str));
        }
    }

    public static class UnsupportedAlgorithmException extends DNSSECException {
        public UnsupportedAlgorithmException(int i2) {
            super(android.support.v4.media.b.f(i2, "Unsupported algorithm: "));
        }
    }

    private DNSSEC() {
    }

    public static String algString(int i2) throws UnsupportedAlgorithmException {
        switch (i2) {
            case 1:
                return "MD5withRSA";
            case 2:
            case 4:
            case 9:
            case 11:
            default:
                throw new UnsupportedAlgorithmException(i2);
            case 3:
            case 6:
                return "SHA1withDSA";
            case 5:
            case 7:
                return "SHA1withRSA";
            case 8:
                return "SHA256withRSA";
            case 10:
                return "SHA512withRSA";
            case 12:
                return "GOST3411withECGOST3410";
            case 13:
                return "SHA256withECDSA";
            case 14:
                return "SHA384withECDSA";
            case 15:
                return "Ed25519";
            case 16:
                return "Ed448";
        }
    }

    private static IOException asn1ParseException(Object obj, Object obj2) {
        return new IOException("Invalid ASN.1 data, expected " + obj + " got " + obj2);
    }

    private static int bigIntegerLength(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) / 8;
    }

    public static void checkAlgorithm(PrivateKey privateKey, int i2) throws UnsupportedAlgorithmException {
        switch (i2) {
            case 1:
            case 5:
            case 7:
            case 8:
            case 10:
                if (!Constants.ALG_RSA.equals(privateKey.getAlgorithm())) {
                    throw new IncompatibleKeyException();
                }
                return;
            case 2:
            case 4:
            case 9:
            case 11:
            default:
                throw new UnsupportedAlgorithmException(i2);
            case 3:
            case 6:
                if (!"DSA".equals(privateKey.getAlgorithm())) {
                    throw new IncompatibleKeyException();
                }
                return;
            case 12:
            case 13:
            case 14:
                if (!"EC".equals(privateKey.getAlgorithm()) && !"ECDSA".equals(privateKey.getAlgorithm())) {
                    throw new IncompatibleKeyException();
                }
                return;
            case 15:
                if (!"Ed25519".equals(privateKey.getAlgorithm()) && !"EdDSA".equals(privateKey.getAlgorithm())) {
                    throw new IncompatibleKeyException();
                }
                return;
            case 16:
                if (!"Ed448".equals(privateKey.getAlgorithm()) && !"EdDSA".equals(privateKey.getAlgorithm())) {
                    throw new IncompatibleKeyException();
                }
                return;
        }
    }

    private static void checkKeyAndSigRecord(SIGBase sIGBase, KEYBase kEYBase, Instant instant) throws DNSSECException {
        if (!matches(sIGBase, kEYBase)) {
            throw new KeyMismatchException(kEYBase, sIGBase);
        }
        if (instant.compareTo(sIGBase.getExpire()) > 0) {
            throw new SignatureExpiredException(sIGBase.getExpire(), instant);
        }
        if (instant.compareTo(sIGBase.getTimeSigned()) < 0) {
            throw new SignatureNotYetValidException(sIGBase.getTimeSigned(), instant);
        }
    }

    public static byte[] digestMessage(SIGRecord sIGRecord, Message message, byte[] bArr) {
        DNSOutput dNSOutput = new DNSOutput();
        digestSIG(dNSOutput, sIGRecord);
        if (bArr != null) {
            dNSOutput.writeByteArray(bArr);
        }
        message.toWire(dNSOutput);
        return dNSOutput.toByteArray();
    }

    public static byte[] digestRRset(RRSIGRecord rRSIGRecord, RRset rRset) {
        final DNSOutput dNSOutput = new DNSOutput();
        digestSIG(dNSOutput, rRSIGRecord);
        Name name = rRset.getName();
        int labels = rRSIGRecord.getLabels() + 1;
        Name nameWild = name.labels() > labels ? name.wild(name.labels() - labels) : null;
        final DNSOutput dNSOutput2 = new DNSOutput();
        if (nameWild != null) {
            nameWild.toWireCanonical(dNSOutput2);
        } else {
            name.toWireCanonical(dNSOutput2);
        }
        dNSOutput2.writeU16(rRset.getType());
        dNSOutput2.writeU16(rRset.getDClass());
        dNSOutput2.writeU32(rRSIGRecord.getOrigTTL());
        rRset.rrs(false).stream().sorted().forEachOrdered(new Consumer() { // from class: org.xbill.DNS.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                DNSSEC.lambda$digestRRset$0(dNSOutput, dNSOutput2, (Record) obj);
            }
        });
        return dNSOutput.toByteArray();
    }

    private static void digestSIG(DNSOutput dNSOutput, SIGBase sIGBase) {
        dNSOutput.writeU16(sIGBase.getTypeCovered());
        dNSOutput.writeU8(sIGBase.getAlgorithm());
        dNSOutput.writeU8(sIGBase.getLabels());
        dNSOutput.writeU32(sIGBase.getOrigTTL());
        dNSOutput.writeU32(sIGBase.getExpire().getEpochSecond());
        dNSOutput.writeU32(sIGBase.getTimeSigned().getEpochSecond());
        dNSOutput.writeU16(sIGBase.getFootprint());
        sIGBase.getSigner().toWireCanonical(dNSOutput);
    }

    private static byte[] dsaSignatureFromDNS(byte[] bArr, int i2, boolean z) throws IOException, DNSSECException {
        if (bArr.length != (i2 * 2) + (z ? 1 : 0)) {
            throw new SignatureVerificationException("input has unexpected length " + bArr.length);
        }
        DNSInput dNSInput = new DNSInput(bArr);
        DNSOutput dNSOutput = new DNSOutput();
        if (z) {
            dNSInput.readU8();
        }
        byte[] byteArray = dNSInput.readByteArray(i2);
        int dsaIntLen = getDsaIntLen(byteArray, i2);
        byte[] byteArray2 = dNSInput.readByteArray(i2);
        int dsaIntLen2 = getDsaIntLen(byteArray2, i2);
        dNSOutput.writeU8(48);
        dNSOutput.writeU8(dsaIntLen + dsaIntLen2 + 4);
        writeAsn1Int(i2, dNSOutput, byteArray, dsaIntLen);
        writeAsn1Int(i2, dNSOutput, byteArray2, dsaIntLen2);
        return dNSOutput.toByteArray();
    }

    private static byte[] dsaSignatureToDNS(byte[] bArr, int i2, int i3) throws IOException {
        DNSInput dNSInput = new DNSInput(bArr);
        DNSOutput dNSOutput = new DNSOutput();
        if (i3 > -1) {
            dNSOutput.writeU8(i3);
        }
        int u8 = dNSInput.readU8();
        if (u8 != 48) {
            throw asn1ParseException(48, Integer.valueOf(u8));
        }
        dNSInput.readU8();
        transformAns1IntToDns(i2, dNSInput, dNSOutput);
        transformAns1IntToDns(i2, dNSInput, dNSOutput);
        return dNSOutput.toByteArray();
    }

    private static byte[] fromDSAPublicKey(DSAPublicKey dSAPublicKey) {
        DNSOutput dNSOutput = new DNSOutput();
        BigInteger q = dSAPublicKey.getParams().getQ();
        BigInteger p = dSAPublicKey.getParams().getP();
        BigInteger g2 = dSAPublicKey.getParams().getG();
        BigInteger y = dSAPublicKey.getY();
        int length = (p.toByteArray().length - 64) / 8;
        dNSOutput.writeU8(length);
        writeBigInteger(dNSOutput, q);
        writeBigInteger(dNSOutput, p);
        int i2 = (length * 8) + 64;
        writePaddedBigInteger(dNSOutput, g2, i2);
        writePaddedBigInteger(dNSOutput, y, i2);
        return dNSOutput.toByteArray();
    }

    private static byte[] fromECDSAPublicKey(ECPublicKey eCPublicKey, ECKeyInfo eCKeyInfo) {
        DNSOutput dNSOutput = new DNSOutput();
        BigInteger affineX = eCPublicKey.getW().getAffineX();
        BigInteger affineY = eCPublicKey.getW().getAffineY();
        writePaddedBigInteger(dNSOutput, affineX, eCKeyInfo.length);
        writePaddedBigInteger(dNSOutput, affineY, eCKeyInfo.length);
        return dNSOutput.toByteArray();
    }

    private static byte[] fromECGOSTPublicKey(ECPublicKey eCPublicKey, ECKeyInfo eCKeyInfo) {
        DNSOutput dNSOutput = new DNSOutput();
        BigInteger affineX = eCPublicKey.getW().getAffineX();
        BigInteger affineY = eCPublicKey.getW().getAffineY();
        writePaddedBigIntegerLittleEndian(dNSOutput, affineX, eCKeyInfo.length);
        writePaddedBigIntegerLittleEndian(dNSOutput, affineY, eCKeyInfo.length);
        return dNSOutput.toByteArray();
    }

    private static byte[] fromEdDSAPublicKey(PublicKey publicKey) {
        byte[] encoded = publicKey.getEncoded();
        return Arrays.copyOfRange(encoded, 12, encoded.length);
    }

    public static byte[] fromPublicKey(PublicKey publicKey, int i2) throws DNSSECException {
        switch (i2) {
            case 1:
            case 5:
            case 7:
            case 8:
            case 10:
                if (publicKey instanceof RSAPublicKey) {
                    return fromRSAPublicKey((RSAPublicKey) publicKey);
                }
                throw new IncompatibleKeyException();
            case 2:
            case 4:
            case 9:
            case 11:
            default:
                throw new UnsupportedAlgorithmException(i2);
            case 3:
            case 6:
                if (publicKey instanceof DSAPublicKey) {
                    return fromDSAPublicKey((DSAPublicKey) publicKey);
                }
                throw new IncompatibleKeyException();
            case 12:
                if (publicKey instanceof ECPublicKey) {
                    return fromECGOSTPublicKey((ECPublicKey) publicKey, GOST);
                }
                throw new IncompatibleKeyException();
            case 13:
                if (publicKey instanceof ECPublicKey) {
                    return fromECDSAPublicKey((ECPublicKey) publicKey, ECDSA_P256);
                }
                throw new IncompatibleKeyException();
            case 14:
                if (publicKey instanceof ECPublicKey) {
                    return fromECDSAPublicKey((ECPublicKey) publicKey, ECDSA_P384);
                }
                throw new IncompatibleKeyException();
            case 15:
            case 16:
                if (publicKey.getFormat().equalsIgnoreCase("X.509")) {
                    return fromEdDSAPublicKey(publicKey);
                }
                throw new IncompatibleKeyException();
        }
    }

    private static byte[] fromRSAPublicKey(RSAPublicKey rSAPublicKey) {
        DNSOutput dNSOutput = new DNSOutput();
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int iBigIntegerLength = bigIntegerLength(publicExponent);
        if (iBigIntegerLength < 256) {
            dNSOutput.writeU8(iBigIntegerLength);
        } else {
            dNSOutput.writeU8(0);
            dNSOutput.writeU16(iBigIntegerLength);
        }
        writeBigInteger(dNSOutput, publicExponent);
        writeBigInteger(dNSOutput, modulus);
        return dNSOutput.toByteArray();
    }

    public static byte[] generateDSDigest(DNSKEYRecord dNSKEYRecord, int i2) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        try {
            if (i2 == 1) {
                messageDigest = MessageDigest.getInstance("sha-1");
            } else if (i2 == 2) {
                messageDigest = MessageDigest.getInstance("sha-256");
            } else if (i2 == 3) {
                messageDigest = MessageDigest.getInstance("GOST3411");
            } else {
                if (i2 != 4) {
                    throw new IllegalArgumentException("unknown DS digest type " + i2);
                }
                messageDigest = MessageDigest.getInstance("sha-384");
            }
            messageDigest.update(dNSKEYRecord.getName().toWireCanonical());
            messageDigest.update(dNSKEYRecord.rdataToWireCanonical());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("no message digest support");
        }
    }

    private static int getDsaIntLen(byte[] bArr, int i2) {
        int i3 = 0;
        if (bArr[0] < 0) {
            return i2 + 1;
        }
        int i4 = i2;
        while (i3 < i2 - 1 && bArr[i3] == 0) {
            i3++;
            if (bArr[i3] < 0) {
                break;
            }
            i4--;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$digestRRset$0(DNSOutput dNSOutput, DNSOutput dNSOutput2, Record record) {
        dNSOutput.writeByteArray(dNSOutput2.toByteArray());
        int iCurrent = dNSOutput.current();
        dNSOutput.writeU16(0);
        record.rrToWire(dNSOutput, null, true);
        int iCurrent2 = (dNSOutput.current() - iCurrent) - 2;
        dNSOutput.save();
        dNSOutput.jump(iCurrent);
        dNSOutput.writeU16(iCurrent2);
        dNSOutput.restore();
    }

    private static boolean matches(SIGBase sIGBase, KEYBase kEYBase) {
        return kEYBase.getAlgorithm() == sIGBase.getAlgorithm() && kEYBase.getFootprint() == sIGBase.getFootprint() && kEYBase.getName().equals(sIGBase.getSigner());
    }

    private static BigInteger readBigInteger(DNSInput dNSInput, int i2) throws IOException {
        return new BigInteger(1, dNSInput.readByteArray(i2));
    }

    private static BigInteger readBigIntegerLittleEndian(DNSInput dNSInput, int i2) throws IOException {
        byte[] byteArray = dNSInput.readByteArray(i2);
        reverseByteArray(byteArray);
        return new BigInteger(1, byteArray);
    }

    private static void reverseByteArray(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length / 2; i2++) {
            int length = (bArr.length - i2) - 1;
            byte b2 = bArr[i2];
            bArr[i2] = bArr[length];
            bArr[length] = b2;
        }
    }

    public static byte[] sign(PrivateKey privateKey, PublicKey publicKey, int i2, byte[] bArr, String str) throws SignatureException, InvalidKeyException, DNSSECException {
        try {
            Signature signature = str != null ? Signature.getInstance(algString(i2), str) : Signature.getInstance(algString(i2));
            signature.initSign(privateKey);
            signature.update(bArr);
            byte[] bArrSign = signature.sign();
            if (publicKey instanceof DSAPublicKey) {
                try {
                    return dsaSignatureToDNS(bArrSign, 20, (bigIntegerLength(((DSAPublicKey) publicKey).getParams().getP()) - 64) / 8);
                } catch (IOException e2) {
                    throw new DNSSECException(e2);
                }
            }
            if (publicKey instanceof ECPublicKey) {
                try {
                    switch (i2) {
                        case 12:
                            break;
                        case 13:
                            return dsaSignatureToDNS(bArrSign, ECDSA_P256.length, -1);
                        case 14:
                            return dsaSignatureToDNS(bArrSign, ECDSA_P384.length, -1);
                        default:
                            throw new UnsupportedAlgorithmException(i2);
                    }
                } catch (IOException e3) {
                    throw new DNSSECException(e3);
                }
            }
            return bArrSign;
        } catch (GeneralSecurityException e4) {
            throw new DNSSECException(e4);
        }
    }

    public static SIGRecord signMessage(Message message, SIGRecord sIGRecord, KEYRecord kEYRecord, PrivateKey privateKey, Instant instant, Instant instant2) throws DNSSECException {
        int algorithm = kEYRecord.getAlgorithm();
        checkAlgorithm(privateKey, algorithm);
        SIGRecord sIGRecord2 = new SIGRecord(Name.root, 255, 0L, 0, algorithm, 0L, instant2, instant, kEYRecord.getFootprint(), kEYRecord.getName(), (byte[]) null);
        DNSOutput dNSOutput = new DNSOutput();
        digestSIG(dNSOutput, sIGRecord2);
        if (sIGRecord != null) {
            dNSOutput.writeByteArray(sIGRecord.getSignature());
        }
        dNSOutput.writeByteArray(message.toWire());
        sIGRecord2.setSignature(sign(privateKey, kEYRecord.getPublicKey(), algorithm, dNSOutput.toByteArray(), (String) null));
        return sIGRecord2;
    }

    private static PublicKey toDSAPublicKey(byte[] bArr) throws MalformedKeyException, GeneralSecurityException, IOException {
        DNSInput dNSInput = new DNSInput(bArr);
        int u8 = dNSInput.readU8();
        if (u8 > 8) {
            throw new MalformedKeyException("t is too large");
        }
        BigInteger bigInteger = readBigInteger(dNSInput, 20);
        int i2 = (u8 * 8) + 64;
        BigInteger bigInteger2 = readBigInteger(dNSInput, i2);
        BigInteger bigInteger3 = readBigInteger(dNSInput, i2);
        return KeyFactory.getInstance("DSA").generatePublic(new DSAPublicKeySpec(readBigInteger(dNSInput, i2), bigInteger2, bigInteger, bigInteger3));
    }

    private static PublicKey toECDSAPublicKey(byte[] bArr, ECKeyInfo eCKeyInfo) throws GeneralSecurityException, IOException {
        DNSInput dNSInput = new DNSInput(bArr);
        return KeyFactory.getInstance("EC").generatePublic(new ECPublicKeySpec(new ECPoint(readBigInteger(dNSInput, eCKeyInfo.length), readBigInteger(dNSInput, eCKeyInfo.length)), eCKeyInfo.spec));
    }

    private static PublicKey toECGOSTPublicKey(byte[] bArr, ECKeyInfo eCKeyInfo) throws GeneralSecurityException, IOException {
        DNSInput dNSInput = new DNSInput(bArr);
        return KeyFactory.getInstance("ECGOST3410").generatePublic(new ECPublicKeySpec(new ECPoint(readBigIntegerLittleEndian(dNSInput, eCKeyInfo.length), readBigIntegerLittleEndian(dNSInput, eCKeyInfo.length)), eCKeyInfo.spec));
    }

    private static PublicKey toEdDSAPublicKey(byte[] bArr, byte b2) throws GeneralSecurityException {
        byte[] bArr2 = new byte[bArr.length + 12];
        bArr2[0] = 48;
        bArr2[1] = (byte) (bArr.length + 10);
        bArr2[2] = 48;
        bArr2[3] = 5;
        bArr2[4] = 6;
        bArr2[5] = 3;
        bArr2[6] = 43;
        bArr2[7] = 101;
        bArr2[8] = b2;
        bArr2[9] = 3;
        bArr2[10] = (byte) (bArr.length + 1);
        System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
        return KeyFactory.getInstance("EdDSA").generatePublic(new X509EncodedKeySpec(bArr2));
    }

    public static PublicKey toPublicKey(KEYBase kEYBase) throws DNSSECException {
        return toPublicKey(kEYBase.getAlgorithm(), kEYBase.getKey(), kEYBase);
    }

    private static PublicKey toRSAPublicKey(byte[] bArr) throws GeneralSecurityException, IOException {
        DNSInput dNSInput = new DNSInput(bArr);
        int u8 = dNSInput.readU8();
        if (u8 == 0) {
            u8 = dNSInput.readU16();
        }
        BigInteger bigInteger = readBigInteger(dNSInput, u8);
        return KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new RSAPublicKeySpec(readBigInteger(dNSInput), bigInteger));
    }

    private static void transformAns1IntToDns(int i2, DNSInput dNSInput, DNSOutput dNSOutput) throws IOException {
        int u8 = dNSInput.readU8();
        if (u8 != 2) {
            throw asn1ParseException(2, Integer.valueOf(u8));
        }
        int u82 = dNSInput.readU8();
        if (u82 == i2 + 1 && dNSInput.readU8() == 0) {
            u82--;
        } else {
            if (u82 > i2) {
                throw new IOException(android.support.v4.media.b.f(u82, "Invalid r/s-value in ASN.1 DER encoded signature: "));
            }
            for (int i3 = 0; i3 < i2 - u82; i3++) {
                dNSOutput.writeU8(0);
            }
        }
        dNSOutput.writeByteArray(dNSInput.readByteArray(u82));
    }

    private static byte[] trimByteArray(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length - 1];
        System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
        return bArr2;
    }

    private static void verify(KEYBase kEYBase, SIGBase sIGBase, byte[] bArr, int i2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, DNSSECException {
        PublicKey publicKey = kEYBase.getPublicKey();
        int algorithm = sIGBase.getAlgorithm();
        byte[] signature = sIGBase.getSignature();
        if (publicKey instanceof DSAPublicKey) {
            try {
                signature = dsaSignatureFromDNS(signature, 20, true);
            } catch (IOException e2) {
                throw new SignatureVerificationException(e2);
            }
        } else if (publicKey instanceof ECPublicKey) {
            try {
                switch (algorithm) {
                    case 12:
                        if (signature.length != GOST.length * 2) {
                            throw new SignatureVerificationException("input has unexpected length " + signature.length);
                        }
                        break;
                    case 13:
                        signature = dsaSignatureFromDNS(signature, ECDSA_P256.length, false);
                        break;
                    case 14:
                        signature = dsaSignatureFromDNS(signature, ECDSA_P384.length, false);
                        break;
                    default:
                        throw new UnsupportedAlgorithmException(algorithm);
                }
            } catch (IOException e3) {
                throw new SignatureVerificationException(e3);
            }
        }
        try {
            Signature signature2 = Signature.getInstance(algString(algorithm));
            signature2.initVerify(publicKey);
            signature2.update(bArr);
            if (signature2.verify(signature)) {
                return;
            }
            throw new SignatureVerificationException("Key " + kEYBase.getName() + " (alg=" + kEYBase.getAlgorithm() + ",id=" + kEYBase.getFootprint() + ") doesn't validate <" + sIGBase.getName() + "/" + DClass.string(sIGBase.getDClass()) + "/" + Type.string(i2) + "> (alg=" + sIGBase.getAlgorithm() + ",id=" + sIGBase.getFootprint() + ")");
        } catch (GeneralSecurityException e4) {
            throw new DNSSECException(e4);
        }
    }

    public static void verifyMessage(Message message, byte[] bArr, SIGRecord sIGRecord, SIGRecord sIGRecord2, KEYRecord kEYRecord, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, DNSSECException {
        if (message.sig0start == 0) {
            throw new NoSignatureException();
        }
        checkKeyAndSigRecord(sIGRecord, kEYRecord, instant);
        DNSOutput dNSOutput = new DNSOutput();
        digestSIG(dNSOutput, sIGRecord);
        if (sIGRecord2 != null) {
            dNSOutput.writeByteArray(sIGRecord2.getSignature());
        }
        Header headerClone = message.getHeader().clone();
        headerClone.decCount(3);
        dNSOutput.writeByteArray(headerClone.toWire());
        dNSOutput.writeByteArray(bArr, 12, message.sig0start - 12);
        verify(kEYRecord, sIGRecord, dNSOutput.toByteArray(), 0);
    }

    private static void writeAsn1Int(int i2, DNSOutput dNSOutput, byte[] bArr, int i3) {
        dNSOutput.writeU8(2);
        dNSOutput.writeU8(i3);
        if (i3 > i2) {
            dNSOutput.writeU8(0);
        }
        if (i3 >= i2) {
            dNSOutput.writeByteArray(bArr);
        } else {
            dNSOutput.writeByteArray(bArr, i2 - i3, i3);
        }
    }

    private static void writeBigInteger(DNSOutput dNSOutput, BigInteger bigInteger) {
        dNSOutput.writeByteArray(trimByteArray(bigInteger.toByteArray()));
    }

    private static void writePaddedBigInteger(DNSOutput dNSOutput, BigInteger bigInteger, int i2) {
        byte[] bArrTrimByteArray = trimByteArray(bigInteger.toByteArray());
        if (bArrTrimByteArray.length > i2) {
            throw new IllegalArgumentException();
        }
        if (bArrTrimByteArray.length < i2) {
            dNSOutput.writeByteArray(new byte[i2 - bArrTrimByteArray.length]);
        }
        dNSOutput.writeByteArray(bArrTrimByteArray);
    }

    private static void writePaddedBigIntegerLittleEndian(DNSOutput dNSOutput, BigInteger bigInteger, int i2) {
        byte[] bArrTrimByteArray = trimByteArray(bigInteger.toByteArray());
        if (bArrTrimByteArray.length > i2) {
            throw new IllegalArgumentException();
        }
        reverseByteArray(bArrTrimByteArray);
        dNSOutput.writeByteArray(bArrTrimByteArray);
        if (bArrTrimByteArray.length < i2) {
            dNSOutput.writeByteArray(new byte[i2 - bArrTrimByteArray.length]);
        }
    }

    public static PublicKey toPublicKey(int i2, byte[] bArr, Record record) throws DNSSECException {
        try {
            switch (i2) {
                case 1:
                case 5:
                case 7:
                case 8:
                case 10:
                    return toRSAPublicKey(bArr);
                case 2:
                case 4:
                case 9:
                case 11:
                default:
                    throw new UnsupportedAlgorithmException(i2);
                case 3:
                case 6:
                    return toDSAPublicKey(bArr);
                case 12:
                    return toECGOSTPublicKey(bArr, GOST);
                case 13:
                    return toECDSAPublicKey(bArr, ECDSA_P256);
                case 14:
                    return toECDSAPublicKey(bArr, ECDSA_P384);
                case 15:
                    return toEdDSAPublicKey(bArr, (byte) 112);
                case 16:
                    return toEdDSAPublicKey(bArr, (byte) 113);
            }
        } catch (IOException e2) {
            throw new MalformedKeyException(record, e2);
        } catch (GeneralSecurityException e3) {
            throw new DNSSECException(e3);
        }
    }

    private static BigInteger readBigInteger(DNSInput dNSInput) {
        return new BigInteger(1, dNSInput.readByteArray());
    }

    @Deprecated
    public static RRSIGRecord sign(RRset rRset, DNSKEYRecord dNSKEYRecord, PrivateKey privateKey, Date date, Date date2) throws DNSSECException {
        return sign(rRset, dNSKEYRecord, privateKey, DateRetargetClass.toInstant(date), DateRetargetClass.toInstant(date2), (String) null);
    }

    @Deprecated
    public static RRSIGRecord sign(RRset rRset, DNSKEYRecord dNSKEYRecord, PrivateKey privateKey, Date date, Date date2, String str) throws DNSSECException {
        return sign(rRset, dNSKEYRecord, privateKey, DateRetargetClass.toInstant(date), DateRetargetClass.toInstant(date2), str);
    }

    public static RRSIGRecord sign(RRset rRset, DNSKEYRecord dNSKEYRecord, PrivateKey privateKey, Instant instant, Instant instant2) throws DNSSECException {
        return sign(rRset, dNSKEYRecord, privateKey, instant, instant2, (String) null);
    }

    public static RRSIGRecord sign(RRset rRset, DNSKEYRecord dNSKEYRecord, PrivateKey privateKey, Instant instant, Instant instant2, String str) throws DNSSECException {
        int algorithm = dNSKEYRecord.getAlgorithm();
        checkAlgorithm(privateKey, algorithm);
        RRSIGRecord rRSIGRecord = new RRSIGRecord(rRset.getName(), rRset.getDClass(), rRset.getTTL(), rRset.getType(), algorithm, rRset.getTTL(), instant2, instant, dNSKEYRecord.getFootprint(), dNSKEYRecord.getName(), (byte[]) null);
        rRSIGRecord.setSignature(sign(privateKey, dNSKEYRecord.getPublicKey(), algorithm, digestRRset(rRSIGRecord, rRset), str));
        return rRSIGRecord;
    }

    public static void verify(RRset rRset, RRSIGRecord rRSIGRecord, DNSKEYRecord dNSKEYRecord) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, DNSSECException {
        verify(rRset, rRSIGRecord, dNSKEYRecord, Instant.now());
    }

    @Deprecated
    public static void verify(RRset rRset, RRSIGRecord rRSIGRecord, DNSKEYRecord dNSKEYRecord, Date date) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, DNSSECException {
        verify(rRset, rRSIGRecord, dNSKEYRecord, DateRetargetClass.toInstant(date));
    }

    public static void verify(RRset rRset, RRSIGRecord rRSIGRecord, DNSKEYRecord dNSKEYRecord, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, DNSSECException {
        if ((dNSKEYRecord.getFlags() & 256) == 256) {
            if (dNSKEYRecord.getProtocol() == 3) {
                checkKeyAndSigRecord(rRSIGRecord, dNSKEYRecord, instant);
                verify(dNSKEYRecord, rRSIGRecord, digestRRset(rRSIGRecord, rRset), rRset.getType());
                return;
            }
            throw new InvalidDnskeyException(dNSKEYRecord, "invalid protocol", 6);
        }
        throw new InvalidDnskeyException(dNSKEYRecord, "zone key flag is not set", 11);
    }
}
