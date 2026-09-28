package com.google.ads.interactivemedia.v3.internal;

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
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.xbill.DNS.TTL;
import org.xbill.DNS.Type;

/* loaded from: classes3.dex */
public final class zzi {
    public static X509Certificate[][] zza(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        Pair pairZzc;
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
        try {
            pairZzc = zzj.zzc(randomAccessFile2);
        } catch (Throwable th) {
            th = th;
            randomAccessFile = randomAccessFile2;
        }
        try {
            if (pairZzc == null) {
                throw new zzf("Not an APK file: ZIP End of Central Directory record not found in file with " + randomAccessFile2.length() + " bytes");
            }
            ByteBuffer byteBuffer = (ByteBuffer) pairZzc.first;
            long jLongValue = ((Long) pairZzc.second).longValue();
            long j2 = jLongValue - 20;
            if (j2 >= 0) {
                randomAccessFile2.seek(j2);
                if (randomAccessFile2.readInt() == 1347094023) {
                    throw new zzf("ZIP64 APK not supported");
                }
            }
            long jZza = zzj.zza(byteBuffer);
            if (jZza >= jLongValue) {
                throw new zzf("ZIP Central Directory offset out of range: " + jZza + ". ZIP End of Central Directory offset: " + jLongValue);
            }
            if (zzj.zzb(byteBuffer) + jZza != jLongValue) {
                throw new zzf("ZIP Central Directory is not immediately followed by End of Central Directory");
            }
            if (jZza < 32) {
                throw new zzf("APK too small for APK Signing Block. ZIP Central Directory offset: " + jZza);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            byteBufferAllocate.order(byteOrder);
            randomAccessFile2.seek(jZza - byteBufferAllocate.capacity());
            randomAccessFile2.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
            if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                throw new zzf("No APK Signing Block before ZIP Central Directory");
            }
            long j3 = byteBufferAllocate.getLong(0);
            if (j3 < byteBufferAllocate.capacity() || j3 > 2147483639) {
                throw new zzf("APK Signing Block size out of range: " + j3);
            }
            int i2 = (int) (8 + j3);
            long j4 = jZza - i2;
            if (j4 < 0) {
                throw new zzf("APK Signing Block offset out of range: " + j4);
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i2);
            byteBufferAllocate2.order(byteOrder);
            randomAccessFile2.seek(j4);
            randomAccessFile2.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
            randomAccessFile = randomAccessFile2;
            long j5 = byteBufferAllocate2.getLong(0);
            if (j5 != j3) {
                throw new zzf("APK Signing Block sizes in header and footer do not match: " + j5 + " vs " + j3);
            }
            Pair pairCreate = Pair.create(byteBufferAllocate2, Long.valueOf(j4));
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
                    long j6 = byteBufferSlice.getLong();
                    if (j6 < 4 || j6 > TTL.MAX_VALUE) {
                        throw new zzf("APK Signing Block entry #" + i3 + " size out of range: " + j6);
                    }
                    int i4 = (int) j6;
                    int iPosition2 = byteBufferSlice.position() + i4;
                    if (i4 > byteBufferSlice.remaining()) {
                        throw new zzf("APK Signing Block entry #" + i3 + " size out of range: " + i4 + ", available: " + byteBufferSlice.remaining());
                    }
                    if (byteBufferSlice.getInt() == 1896449818) {
                        X509Certificate[][] x509CertificateArrZzl = zzl(randomAccessFile.getChannel(), new zze(zze(byteBufferSlice, i4 - 4), jLongValue2, jZza, jLongValue, byteBuffer, null));
                        randomAccessFile.close();
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                        return x509CertificateArrZzl;
                    }
                    long j7 = jLongValue2;
                    long j8 = jZza;
                    long j9 = jLongValue;
                    byteBufferSlice.position(iPosition2);
                    jLongValue = j9;
                    jZza = j8;
                    jLongValue2 = j7;
                }
                throw new zzf("No APK Signature Scheme v2 block in APK Signing Block");
            } catch (Throwable th2) {
                byteBuffer2.position(0);
                byteBuffer2.limit(iLimit);
                byteBuffer2.position(iPosition);
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }

    private static int zzb(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        throw new IllegalArgumentException(b.f(i2, "Unknown content digest algorthm: "));
    }

    private static int zzc(int i2) {
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

    private static String zzd(int i2) {
        if (i2 == 1) {
            return MessageDigestAlgorithms.SHA_256;
        }
        if (i2 == 2) {
            return MessageDigestAlgorithms.SHA_512;
        }
        throw new IllegalArgumentException(b.f(i2, "Unknown content digest algorthm: "));
    }

    private static ByteBuffer zze(ByteBuffer byteBuffer, int i2) throws BufferUnderflowException {
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

    private static ByteBuffer zzf(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException(b.f(byteBuffer.remaining(), "Remaining buffer too short to contain length of length-prefixed field. Remaining: "));
        }
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            return zze(byteBuffer, i2);
        }
        throw new IOException(b.d(i2, byteBuffer.remaining(), "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: "));
    }

    private static void zzg(int i2, byte[] bArr, int i3) {
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 >>> 8) & 255);
        bArr[3] = (byte) ((i2 >>> 16) & 255);
        bArr[4] = (byte) (i2 >> 24);
    }

    private static void zzh(Map map, FileChannel fileChannel, long j2, long j3, long j4, ByteBuffer byteBuffer) throws SecurityException {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        zzc zzcVar = new zzc(fileChannel, 0L, j2);
        zzc zzcVar2 = new zzc(fileChannel, j3, j4 - j3);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        zzj.zzd(byteBufferDuplicate, j2);
        zza zzaVar = new zza(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((Integer) it.next()).intValue();
            i2++;
        }
        try {
            byte[][] bArrZzk = zzk(iArr, new zzb[]{zzcVar, zzcVar2, zzaVar});
            for (int i3 = 0; i3 < size; i3++) {
                int i4 = iArr[i3];
                if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i4)), bArrZzk[i3])) {
                    throw new SecurityException(zzd(i4).concat(" digest of contents did not verify"));
                }
            }
        } catch (DigestException e2) {
            throw new SecurityException("Failed to compute digest(s) of contents", e2);
        }
    }

    private static byte[] zzi(ByteBuffer byteBuffer) throws IOException {
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

    private static X509Certificate[] zzj(ByteBuffer byteBuffer, Map map, CertificateFactory certificateFactory) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, SecurityException, InvalidAlgorithmParameterException {
        String str;
        Pair pairCreate;
        ByteBuffer byteBufferZzf = zzf(byteBuffer);
        ByteBuffer byteBufferZzf2 = zzf(byteBuffer);
        byte[] bArrZzi = zzi(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrZzi2 = null;
        byte[] bArrZzi3 = null;
        int i2 = -1;
        int i3 = 0;
        while (byteBufferZzf2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer byteBufferZzf3 = zzf(byteBufferZzf2);
                if (byteBufferZzf3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i4 = byteBufferZzf3.getInt();
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
                    int iZzc = zzc(i4);
                    int iZzc2 = zzc(i2);
                    if (iZzc != 1 && iZzc2 == 1) {
                    }
                }
                bArrZzi3 = zzi(byteBufferZzf3);
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
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrZzi));
            Signature signature = Signature.getInstance(str2);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferZzf);
            if (!signature.verify(bArrZzi3)) {
                throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
            }
            byteBufferZzf.clear();
            ByteBuffer byteBufferZzf4 = zzf(byteBufferZzf);
            ArrayList arrayList2 = new ArrayList();
            int i5 = 0;
            while (byteBufferZzf4.hasRemaining()) {
                i5++;
                try {
                    ByteBuffer byteBufferZzf5 = zzf(byteBufferZzf4);
                    if (byteBufferZzf5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i6 = byteBufferZzf5.getInt();
                    arrayList2.add(Integer.valueOf(i6));
                    if (i6 == i2) {
                        bArrZzi2 = zzi(byteBufferZzf5);
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
            int iZzc3 = zzc(i2);
            byte[] bArr = (byte[]) map.put(Integer.valueOf(iZzc3), bArrZzi2);
            if (bArr != null && !MessageDigest.isEqual(bArr, bArrZzi2)) {
                throw new SecurityException(zzd(iZzc3).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            ByteBuffer byteBufferZzf6 = zzf(byteBufferZzf);
            ArrayList arrayList3 = new ArrayList();
            int i7 = 0;
            while (byteBufferZzf6.hasRemaining()) {
                i7++;
                byte[] bArrZzi4 = zzi(byteBufferZzf6);
                try {
                    arrayList3.add(new zzg((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzi4)), bArrZzi4));
                } catch (CertificateException e6) {
                    throw new SecurityException(b.f(i7, "Failed to decode certificate #"), e6);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (Arrays.equals(bArrZzi, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
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

    private static byte[][] zzk(int[] iArr, zzb[] zzbVarArr) throws DigestException {
        long j2;
        int i2;
        int length;
        char c2;
        int i3;
        String str;
        int i4 = 0;
        int i5 = 0;
        long jZza = 0;
        while (true) {
            j2 = 1048576;
            i2 = 3;
            if (i5 >= 3) {
                break;
            }
            jZza += (zzbVarArr[i5].zza() + 1048575) / 1048576;
            i5++;
        }
        if (jZza >= 2097151) {
            throw new DigestException(b.i(jZza, "Too many chunks: "));
        }
        byte[][] bArr = new byte[iArr.length][];
        int i6 = 0;
        while (true) {
            length = iArr.length;
            c2 = 5;
            i3 = 1;
            if (i6 >= length) {
                break;
            }
            int i7 = (int) jZza;
            byte[] bArr2 = new byte[(zzb(iArr[i6]) * i7) + 5];
            bArr2[0] = 90;
            zzg(i7, bArr2, 1);
            bArr[i6] = bArr2;
            i6++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        int i8 = 0;
        while (true) {
            str = " digest not supported";
            if (i8 >= iArr.length) {
                break;
            }
            String strZzd = zzd(iArr[i8]);
            try {
                messageDigestArr[i8] = MessageDigest.getInstance(strZzd);
                i8++;
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(strZzd.concat(" digest not supported"), e2);
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < i2) {
            zzb zzbVar = zzbVarArr[i9];
            int i11 = i9;
            long jZza2 = zzbVar.zza();
            byte[][] bArr4 = bArr;
            long j3 = 0;
            while (jZza2 > 0) {
                int i12 = i10;
                String str2 = str;
                int iMin = (int) Math.min(jZza2, j2);
                zzg(iMin, bArr3, i3);
                for (int i13 = 0; i13 < length; i13++) {
                    messageDigestArr[i13].update(bArr3);
                }
                try {
                    zzbVar.zzb(messageDigestArr, j3, iMin);
                    int i14 = 0;
                    while (i14 < iArr.length) {
                        int i15 = iArr[i14];
                        byte[] bArr5 = bArr4[i14];
                        int iZzb = zzb(i15);
                        char c3 = c2;
                        MessageDigest messageDigest = messageDigestArr[i14];
                        int iDigest = messageDigest.digest(bArr5, (i12 * iZzb) + 5, iZzb);
                        if (iDigest != iZzb) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i14++;
                        c2 = c3;
                    }
                    long j4 = iMin;
                    j3 += j4;
                    jZza2 -= j4;
                    i10 = i12 + 1;
                    str = str2;
                    j2 = 1048576;
                    i3 = 1;
                } catch (IOException e3) {
                    throw new DigestException(b.d(i12, i4, "Failed to digest chunk #", " of section #"), e3);
                }
            }
            i4++;
            i9 = i11 + 1;
            bArr = bArr4;
            j2 = 1048576;
            i2 = 3;
            i3 = 1;
        }
        byte[][] bArr6 = bArr;
        String str3 = str;
        byte[][] bArr7 = new byte[iArr.length][];
        for (int i16 = 0; i16 < iArr.length; i16++) {
            int i17 = iArr[i16];
            byte[] bArr8 = bArr6[i16];
            String strZzd2 = zzd(i17);
            try {
                bArr7[i16] = MessageDigest.getInstance(strZzd2).digest(bArr8);
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(strZzd2.concat(str3), e4);
            }
        }
        return bArr7;
    }

    private static X509Certificate[][] zzl(FileChannel fileChannel, zze zzeVar) throws SecurityException, CertificateException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferZzf = zzf(zzeVar.zza);
                int i2 = 0;
                while (byteBufferZzf.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(zzj(zzf(byteBufferZzf), map, certificateFactory));
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
                zzh(map, fileChannel, zzeVar.zzb, zzeVar.zzc, zzeVar.zzd, zzeVar.zze);
                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
            } catch (IOException e3) {
                throw new SecurityException("Failed to read list of signers", e3);
            }
        } catch (CertificateException e4) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e4);
        }
    }
}
