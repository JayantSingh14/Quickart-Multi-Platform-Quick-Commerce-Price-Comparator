package com.google.android.play.core.splitinstall.internal;

import android.support.v4.media.b;
import android.util.Pair;
import in.juspay.hypersdk.core.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.xbill.DNS.Message;
import org.xbill.DNS.TTL;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public final class zzi {
    public static X509Certificate[][] a(String str) throws IOException {
        Pair pairA;
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        try {
            if (randomAccessFile.length() < 22) {
                pairA = null;
            } else {
                pairA = zzj.a(randomAccessFile, 0);
                if (pairA == null) {
                    pairA = zzj.a(randomAccessFile, Message.MAXLENGTH);
                }
            }
            if (pairA == null) {
                throw new zzf("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile.length() + " bytes");
            }
            ByteBuffer byteBuffer = (ByteBuffer) pairA.first;
            long jLongValue = ((Long) pairA.second).longValue();
            long j2 = jLongValue - 20;
            if (j2 >= 0) {
                randomAccessFile.seek(j2);
                if (randomAccessFile.readInt() == 1347094023) {
                    throw new zzf("ZIP64 APK not supported");
                }
            }
            zzj.b(byteBuffer);
            long j3 = byteBuffer.getInt(byteBuffer.position() + 16) & 4294967295L;
            if (j3 >= jLongValue) {
                throw new zzf("ZIP Central Directory offset out of range: " + j3 + ". ZIP End of Central Directory offset: " + jLongValue);
            }
            zzj.b(byteBuffer);
            if ((byteBuffer.getInt(byteBuffer.position() + 12) & 4294967295L) + j3 != jLongValue) {
                throw new zzf("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            if (j3 < 32) {
                throw new zzf("APK too small for APK Signing Block. ZIP Central Directory offset: " + j3);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile.seek(j3 - byteBufferAllocate.capacity());
            randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                throw new zzf("No APK Signing Block before ZIP Central Directory");
            }
            long j4 = byteBufferAllocate.getLong(0);
            if (j4 < byteBufferAllocate.capacity() || j4 > 2147483639) {
                throw new zzf("APK Signing Block size out of range: " + j4);
            }
            int i2 = (int) (8 + j4);
            long j5 = j3 - i2;
            if (j5 < 0) {
                throw new zzf("APK Signing Block offset out of range: " + j5);
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i2);
            byteBufferAllocate2.order(byteOrder);
            randomAccessFile.seek(j5);
            randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
            long j6 = j3;
            long j7 = byteBufferAllocate2.getLong(0);
            if (j7 != j4) {
                throw new zzf("APK Signing Block sizes in header and footer do not match: " + j7 + " vs " + j4);
            }
            Pair pairCreate = Pair.create(byteBufferAllocate2, Long.valueOf(j5));
            ByteBuffer byteBuffer2 = (ByteBuffer) pairCreate.first;
            long jLongValue2 = ((Long) pairCreate.second).longValue();
            if (byteBuffer2.order() != byteOrder) {
                throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
            }
            int iCapacity = byteBuffer2.capacity() - 24;
            if (iCapacity < 8) {
                throw new IllegalArgumentException("end < start: " + iCapacity + " < 8");
            }
            int iCapacity2 = byteBuffer2.capacity();
            if (iCapacity > byteBuffer2.capacity()) {
                throw new IllegalArgumentException("end > capacity: " + iCapacity + " > " + iCapacity2);
            }
            int iLimit = byteBuffer2.limit();
            int iPosition = byteBuffer2.position();
            try {
                byteBuffer2.position(0);
                byteBuffer2.limit(iCapacity);
                byteBuffer2.position(8);
                ByteBuffer byteBufferSlice = byteBuffer2.slice();
                byteBufferSlice.order(byteBuffer2.order());
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                int i3 = 0;
                while (byteBufferSlice.hasRemaining()) {
                    i3++;
                    if (byteBufferSlice.remaining() < 8) {
                        throw new zzf("Insufficient data to read size of APK Signing Block entry #" + i3);
                    }
                    long j8 = byteBufferSlice.getLong();
                    if (j8 < 4 || j8 > TTL.MAX_VALUE) {
                        throw new zzf("APK Signing Block entry #" + i3 + " size out of range: " + j8);
                    }
                    int i4 = (int) j8;
                    int iPosition2 = byteBufferSlice.position() + i4;
                    if (i4 > byteBufferSlice.remaining()) {
                        throw new zzf("APK Signing Block entry #" + i3 + " size out of range: " + i4 + ", available: " + byteBufferSlice.remaining());
                    }
                    if (byteBufferSlice.getInt() == 1896449818) {
                        X509Certificate[][] x509CertificateArrK = k(randomAccessFile.getChannel(), new zze(jLongValue2, j6, jLongValue, e(byteBufferSlice, i4 - 4), byteBuffer));
                        randomAccessFile.close();
                        return x509CertificateArrK;
                    }
                    long j9 = jLongValue2;
                    long j10 = jLongValue;
                    long j11 = j6;
                    ByteBuffer byteBuffer3 = byteBuffer;
                    byteBufferSlice.position(iPosition2);
                    jLongValue = j10;
                    byteBuffer = byteBuffer3;
                    j6 = j11;
                    jLongValue2 = j9;
                }
                throw new zzf("No APK Signature Scheme v2 block in APK Signing Block");
            } catch (Throwable th) {
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                throw th;
            }
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int b(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        throw new IllegalArgumentException(b.f(i2, "Unknown content digest algorthm: "));
    }

    public static int c(int i2) {
        if (i2 == 513) {
            return 1;
        }
        if (i2 == 514) {
            return 2;
        }
        if (i2 == 769) {
            return 1;
        }
        switch (i2) {
            case Type.CAA /* 257 */:
            case Type.DOA /* 259 */:
                return 1;
            case Type.AVC /* 258 */:
            case Type.AMTRELAY /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i2))));
        }
    }

    public static String d(int i2) {
        if (i2 == 1) {
            return MessageDigestAlgorithms.SHA_256;
        }
        if (i2 == 2) {
            return MessageDigestAlgorithms.SHA_512;
        }
        throw new IllegalArgumentException(b.f(i2, "Unknown content digest algorthm: "));
    }

    public static ByteBuffer e(ByteBuffer byteBuffer, int i2) {
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (i3 < iPosition || i3 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i3);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i3);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    public static ByteBuffer f(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException(b.f(byteBuffer.remaining(), "Remaining buffer too short to contain length of length-prefixed field. Remaining: "));
        }
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            return e(byteBuffer, i2);
        }
        throw new IOException(b.d(i2, byteBuffer.remaining(), "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: "));
    }

    public static void g(int i2, byte[] bArr) {
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 >>> 8) & 255);
        bArr[3] = (byte) ((i2 >>> 16) & 255);
        bArr[4] = (byte) (i2 >> 24);
    }

    public static byte[] h(ByteBuffer byteBuffer) throws IOException {
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IOException("Negative length");
        }
        if (i2 > byteBuffer.remaining()) {
            throw new IOException(b.d(i2, byteBuffer.remaining(), "Underflow while reading length-prefixed value. Length: ", ", available: "));
        }
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static X509Certificate[] i(ByteBuffer byteBuffer, HashMap map, CertificateFactory certificateFactory) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        Pair pairCreate;
        ByteBuffer byteBufferF = f(byteBuffer);
        ByteBuffer byteBufferF2 = f(byteBuffer);
        byte[] bArrH = h(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrH2 = null;
        byte[] bArrH3 = null;
        int i2 = -1;
        int i3 = 0;
        while (byteBufferF2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer byteBufferF3 = f(byteBufferF2);
                if (byteBufferF3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i4 = byteBufferF3.getInt();
                arrayList.add(Integer.valueOf(i4));
                if (i4 != 513 && i4 != 514 && i4 != 769) {
                    switch (i4) {
                        case Type.CAA /* 257 */:
                        case Type.AVC /* 258 */:
                        case Type.DOA /* 259 */:
                        case Type.AMTRELAY /* 260 */:
                            break;
                        default:
                            continue;
                    }
                }
                if (i2 != -1) {
                    int iC = c(i4);
                    int iC2 = c(i2);
                    if (iC != 1 && iC2 == 1) {
                    }
                }
                bArrH3 = h(byteBufferF3);
                i2 = i4;
            } catch (IOException e2) {
                e = e2;
                throw new SecurityException(b.f(i3, "Failed to parse signature record #"), e);
            } catch (BufferUnderflowException e3) {
                e = e3;
                throw new SecurityException(b.f(i3, "Failed to parse signature record #"), e);
            }
        }
        if (i2 == -1) {
            if (i3 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        if (i2 == 513 || i2 == 514) {
            str = "EC";
        } else if (i2 != 769) {
            switch (i2) {
                case Type.CAA /* 257 */:
                case Type.AVC /* 258 */:
                case Type.DOA /* 259 */:
                case Type.AMTRELAY /* 260 */:
                    str = Constants.ALG_RSA;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i2))));
            }
        } else {
            str = "DSA";
        }
        if (i2 == 513) {
            pairCreate = Pair.create("SHA256withECDSA", null);
        } else if (i2 == 514) {
            pairCreate = Pair.create("SHA512withECDSA", null);
        } else if (i2 != 769) {
            switch (i2) {
                case Type.CAA /* 257 */:
                    pairCreate = Pair.create("SHA256withRSA/PSS", new PSSParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                    break;
                case Type.AVC /* 258 */:
                    pairCreate = Pair.create("SHA512withRSA/PSS", new PSSParameterSpec(MessageDigestAlgorithms.SHA_512, "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                    break;
                case Type.DOA /* 259 */:
                    pairCreate = Pair.create("SHA256withRSA", null);
                    break;
                case Type.AMTRELAY /* 260 */:
                    pairCreate = Pair.create("SHA512withRSA", null);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown signature algorithm: 0x".concat(String.valueOf(Long.toHexString(i2))));
            }
        } else {
            pairCreate = Pair.create("SHA256withDSA", null);
        }
        String str2 = (String) pairCreate.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairCreate.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrH));
            Signature signature = Signature.getInstance(str2);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferF);
            if (!signature.verify(bArrH3)) {
                throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
            }
            byteBufferF.clear();
            ByteBuffer byteBufferF4 = f(byteBufferF);
            ArrayList arrayList2 = new ArrayList();
            int i5 = 0;
            while (byteBufferF4.hasRemaining()) {
                i5++;
                try {
                    ByteBuffer byteBufferF5 = f(byteBufferF4);
                    if (byteBufferF5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i6 = byteBufferF5.getInt();
                    arrayList2.add(Integer.valueOf(i6));
                    if (i6 == i2) {
                        bArrH2 = h(byteBufferF5);
                    }
                } catch (IOException e4) {
                    e = e4;
                    throw new IOException(b.f(i5, "Failed to parse digest record #"), e);
                } catch (BufferUnderflowException e5) {
                    e = e5;
                    throw new IOException(b.f(i5, "Failed to parse digest record #"), e);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iC3 = c(i2);
            byte[] bArr = (byte[]) map.put(Integer.valueOf(iC3), bArrH2);
            if (bArr != null && !MessageDigest.isEqual(bArr, bArrH2)) {
                throw new SecurityException(d(iC3).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            ByteBuffer byteBufferF6 = f(byteBufferF);
            ArrayList arrayList3 = new ArrayList();
            int i7 = 0;
            while (byteBufferF6.hasRemaining()) {
                i7++;
                byte[] bArrH4 = h(byteBufferF6);
                try {
                    arrayList3.add(new zzg((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrH4)), bArrH4));
                } catch (CertificateException e6) {
                    throw new SecurityException(b.f(i7, "Failed to decode certificate #"), e6);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (Arrays.equals(bArrH, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
            }
            throw new SecurityException("Public key mismatch between certificate and signature record");
        } catch (InvalidAlgorithmParameterException e7) {
            e = e7;
            throw new SecurityException(b.D("Failed to verify ", str2, " signature"), e);
        } catch (InvalidKeyException e8) {
            e = e8;
            throw new SecurityException(b.D("Failed to verify ", str2, " signature"), e);
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            throw new SecurityException(b.D("Failed to verify ", str2, " signature"), e);
        } catch (SignatureException e10) {
            e = e10;
            throw new SecurityException(b.D("Failed to verify ", str2, " signature"), e);
        } catch (InvalidKeySpecException e11) {
            e = e11;
            throw new SecurityException(b.D("Failed to verify ", str2, " signature"), e);
        }
    }

    public static byte[][] j(int[] iArr, zzb[] zzbVarArr) throws DigestException {
        long j2;
        int i2;
        int length;
        char c2;
        int i3 = 0;
        long jZza = 0;
        while (true) {
            j2 = 1048576;
            if (i3 >= 3) {
                break;
            }
            jZza += (zzbVarArr[i3].zza() + 1048575) / 1048576;
            i3++;
        }
        if (jZza >= 2097151) {
            throw new DigestException(b.i(jZza, "Too many chunks: "));
        }
        byte[][] bArr = new byte[iArr.length][];
        int i4 = 0;
        while (true) {
            length = iArr.length;
            c2 = 5;
            if (i4 >= length) {
                break;
            }
            int i5 = (int) jZza;
            byte[] bArr2 = new byte[(b(iArr[i4]) * i5) + 5];
            bArr2[0] = 90;
            g(i5, bArr2);
            bArr[i4] = bArr2;
            i4++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            String strD = d(iArr[i6]);
            try {
                messageDigestArr[i6] = MessageDigest.getInstance(strD);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(strD.concat(" digest not supported"), e2);
            }
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (i2 = 3; i7 < i2; i2 = 3) {
            zzb zzbVar = zzbVarArr[i7];
            int i10 = i7;
            long jZza2 = zzbVar.zza();
            long j3 = 0;
            while (jZza2 > 0) {
                char c3 = c2;
                int i11 = i8;
                int iMin = (int) Math.min(jZza2, j2);
                g(iMin, bArr3);
                for (int i12 = 0; i12 < length; i12++) {
                    messageDigestArr[i12].update(bArr3);
                }
                try {
                    zzbVar.zzb(messageDigestArr, j3, iMin);
                    int i13 = 0;
                    while (i13 < iArr.length) {
                        int i14 = iArr[i13];
                        byte[] bArr4 = bArr[i13];
                        int iB = b(i14);
                        zzb zzbVar2 = zzbVar;
                        MessageDigest messageDigest = messageDigestArr[i13];
                        long j4 = jZza2;
                        int iDigest = messageDigest.digest(bArr4, (i11 * iB) + 5, iB);
                        if (iDigest != iB) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i13++;
                        zzbVar = zzbVar2;
                        jZza2 = j4;
                    }
                    zzb zzbVar3 = zzbVar;
                    long j5 = iMin;
                    j3 += j5;
                    jZza2 -= j5;
                    i8 = i11 + 1;
                    c2 = c3;
                    zzbVar = zzbVar3;
                    j2 = 1048576;
                } catch (IOException e3) {
                    throw new DigestException(b.d(i11, i9, "Failed to digest chunk #", " of section #"), e3);
                }
            }
            i9++;
            i7 = i10 + 1;
            j2 = 1048576;
        }
        byte[][] bArr5 = new byte[iArr.length][];
        for (int i15 = 0; i15 < iArr.length; i15++) {
            int i16 = iArr[i15];
            byte[] bArr6 = bArr[i15];
            String strD2 = d(i16);
            try {
                bArr5[i15] = MessageDigest.getInstance(strD2).digest(bArr6);
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(strD2.concat(" digest not supported"), e4);
            }
        }
        return bArr5;
    }

    public static X509Certificate[][] k(FileChannel fileChannel, zze zzeVar) throws CertificateException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferF = f(zzeVar.f41978a);
                int i2 = 0;
                while (byteBufferF.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(i(f(byteBufferF), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        throw new SecurityException(b.g(i2, "Failed to parse/verify signer #", " block"), e2);
                    }
                }
                if (i2 <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No digests provided");
                }
                long j2 = zzeVar.f41979b;
                zzc zzcVar = new zzc(fileChannel, 0L, j2);
                long j3 = zzeVar.f41981d;
                long j4 = zzeVar.f41980c;
                zzc zzcVar2 = new zzc(fileChannel, j4, j3 - j4);
                ByteBuffer byteBufferDuplicate = zzeVar.f41982e.duplicate();
                byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                zzj.b(byteBufferDuplicate);
                int iPosition = byteBufferDuplicate.position() + 16;
                if (j2 < 0 || j2 > 4294967295L) {
                    throw new IllegalArgumentException(b.i(j2, "uint32 value of out range: "));
                }
                byteBufferDuplicate.putInt(byteBufferDuplicate.position() + iPosition, (int) j2);
                zza zzaVar = new zza(byteBufferDuplicate);
                int size = map.size();
                int[] iArr = new int[size];
                Iterator it = map.keySet().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    iArr[i3] = ((Integer) it.next()).intValue();
                    i3++;
                }
                try {
                    byte[][] bArrJ = j(iArr, new zzb[]{zzcVar, zzcVar2, zzaVar});
                    for (int i4 = 0; i4 < size; i4++) {
                        int i5 = iArr[i4];
                        if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i5)), bArrJ[i4])) {
                            throw new SecurityException(d(i5).concat(" digest of contents did not verify"));
                        }
                    }
                    return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
                } catch (DigestException e3) {
                    throw new SecurityException("Failed to compute digest(s) of contents", e3);
                }
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }
}
