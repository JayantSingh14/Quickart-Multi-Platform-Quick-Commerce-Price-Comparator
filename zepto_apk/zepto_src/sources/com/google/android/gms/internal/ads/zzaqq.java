package com.google.android.gms.internal.ads;

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
public final class zzaqq {
    public static X509Certificate[][] a(String str) {
        RandomAccessFile randomAccessFile;
        Pair pairA;
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
        try {
            if (randomAccessFile2.length() < 22) {
                pairA = null;
            } else {
                pairA = zzaqr.a(randomAccessFile2, 0);
                if (pairA == null) {
                    pairA = zzaqr.a(randomAccessFile2, Message.MAXLENGTH);
                }
            }
            try {
                if (pairA == null) {
                    long length = randomAccessFile2.length();
                    StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 82);
                    sb.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                    sb.append(length);
                    sb.append(" bytes");
                    throw new zzaqn(sb.toString());
                }
                ByteBuffer byteBuffer = (ByteBuffer) pairA.first;
                long jLongValue = ((Long) pairA.second).longValue();
                long j2 = (-20) + jLongValue;
                if (j2 >= 0) {
                    randomAccessFile2.seek(j2);
                    if (randomAccessFile2.readInt() == 1347094023) {
                        throw new zzaqn("ZIP64 APK not supported");
                    }
                }
                zzaqr.b(byteBuffer);
                long j3 = byteBuffer.getInt(byteBuffer.position() + 16) & 4294967295L;
                if (j3 >= jLongValue) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(j3).length() + 82 + String.valueOf(jLongValue).length());
                    sb2.append("ZIP Central Directory offset out of range: ");
                    sb2.append(j3);
                    sb2.append(". ZIP End of Central Directory offset: ");
                    sb2.append(jLongValue);
                    throw new zzaqn(sb2.toString());
                }
                zzaqr.b(byteBuffer);
                if ((byteBuffer.getInt(byteBuffer.position() + 12) & 4294967295L) + j3 != jLongValue) {
                    throw new zzaqn("ZIP Central Directory is not immediately followed by End of Central Directory");
                }
                if (j3 < 32) {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(j3).length() + 67);
                    sb3.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                    sb3.append(j3);
                    throw new zzaqn(sb3.toString());
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                byteBufferAllocate.order(byteOrder);
                randomAccessFile2.seek(j3 - byteBufferAllocate.capacity());
                randomAccessFile2.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
                if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
                    throw new zzaqn("No APK Signing Block before ZIP Central Directory");
                }
                long j4 = byteBufferAllocate.getLong(0);
                if (j4 < byteBufferAllocate.capacity() || j4 > 2147483639) {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(j4).length() + 37);
                    sb4.append("APK Signing Block size out of range: ");
                    sb4.append(j4);
                    throw new zzaqn(sb4.toString());
                }
                int i2 = (int) (8 + j4);
                long j5 = j3 - i2;
                if (j5 < 0) {
                    StringBuilder sb5 = new StringBuilder(String.valueOf(j5).length() + 39);
                    sb5.append("APK Signing Block offset out of range: ");
                    sb5.append(j5);
                    throw new zzaqn(sb5.toString());
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i2);
                byteBufferAllocate2.order(byteOrder);
                randomAccessFile2.seek(j5);
                long j6 = j3;
                randomAccessFile2.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
                long j7 = byteBufferAllocate2.getLong(0);
                if (j7 != j4) {
                    StringBuilder sb6 = new StringBuilder(String.valueOf(j7).length() + 63 + String.valueOf(j4).length());
                    sb6.append("APK Signing Block sizes in header and footer do not match: ");
                    sb6.append(j7);
                    sb6.append(" vs ");
                    sb6.append(j4);
                    throw new zzaqn(sb6.toString());
                }
                Pair pairCreate = Pair.create(byteBufferAllocate2, Long.valueOf(j5));
                ByteBuffer byteBuffer2 = (ByteBuffer) pairCreate.first;
                long jLongValue2 = ((Long) pairCreate.second).longValue();
                String str2 = "APK Signing Block entry #";
                if (byteBuffer2.order() != byteOrder) {
                    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
                }
                int iCapacity = byteBuffer2.capacity() - 24;
                randomAccessFile = randomAccessFile2;
                if (iCapacity < 8) {
                    StringBuilder sb7 = new StringBuilder(String.valueOf(iCapacity).length() + 17);
                    sb7.append("end < start: ");
                    sb7.append(iCapacity);
                    sb7.append(" < 8");
                    throw new IllegalArgumentException(sb7.toString());
                }
                int iCapacity2 = byteBuffer2.capacity();
                if (iCapacity > byteBuffer2.capacity()) {
                    StringBuilder sb8 = new StringBuilder(String.valueOf(iCapacity).length() + 19 + String.valueOf(iCapacity2).length());
                    sb8.append("end > capacity: ");
                    sb8.append(iCapacity);
                    sb8.append(" > ");
                    sb8.append(iCapacity2);
                    throw new IllegalArgumentException(sb8.toString());
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
                            StringBuilder sb9 = new StringBuilder(String.valueOf(i3).length() + 59);
                            sb9.append("Insufficient data to read size of APK Signing Block entry #");
                            sb9.append(i3);
                            throw new zzaqn(sb9.toString());
                        }
                        String str3 = str2;
                        long j8 = byteBufferSlice.getLong();
                        if (j8 < 4 || j8 > TTL.MAX_VALUE) {
                            StringBuilder sb10 = new StringBuilder(String.valueOf(i3).length() + 45 + String.valueOf(j8).length());
                            sb10.append(str3);
                            sb10.append(i3);
                            sb10.append(" size out of range: ");
                            sb10.append(j8);
                            throw new zzaqn(sb10.toString());
                        }
                        int i4 = (int) j8;
                        int iPosition2 = byteBufferSlice.position() + i4;
                        if (i4 > byteBufferSlice.remaining()) {
                            int iRemaining = byteBufferSlice.remaining();
                            StringBuilder sb11 = new StringBuilder(String.valueOf(i3).length() + 45 + String.valueOf(i4).length() + 13 + String.valueOf(iRemaining).length());
                            sb11.append(str3);
                            sb11.append(i3);
                            sb11.append(" size out of range: ");
                            sb11.append(i4);
                            sb11.append(", available: ");
                            sb11.append(iRemaining);
                            throw new zzaqn(sb11.toString());
                        }
                        if (byteBufferSlice.getInt() == 1896449818) {
                            X509Certificate[][] x509CertificateArrB = b(randomAccessFile.getChannel(), new zzaqm(jLongValue2, j6, jLongValue, h(i4 - 4, byteBufferSlice), byteBuffer));
                            randomAccessFile.close();
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused) {
                            }
                            return x509CertificateArrB;
                        }
                        long j9 = j6;
                        byteBufferSlice.position(iPosition2);
                        j6 = j9;
                        str2 = str3;
                    }
                    throw new zzaqn("No APK Signature Scheme v2 block in APK Signing Block");
                } catch (Throwable th) {
                    byteBuffer2.position(0);
                    byteBuffer2.limit(iLimit);
                    byteBuffer2.position(iPosition);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = randomAccessFile2;
        }
    }

    public static X509Certificate[][] b(FileChannel fileChannel, zzaqm zzaqmVar) throws CertificateException {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferI = i(zzaqmVar.f24166a);
                int i2 = 0;
                while (byteBufferI.hasRemaining()) {
                    i2++;
                    try {
                        arrayList.add(c(i(byteBufferI), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e2) {
                        throw new SecurityException(androidx.fragment.app.e.u(new StringBuilder(String.valueOf(i2).length() + 37), "Failed to parse/verify signer #", i2, " block"), e2);
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
                long j2 = zzaqmVar.f24167b;
                zzaql zzaqlVar = new zzaql(fileChannel, 0L, j2);
                long j3 = zzaqmVar.f24169d;
                long j4 = zzaqmVar.f24168c;
                zzaql zzaqlVar2 = new zzaql(fileChannel, j4, j3 - j4);
                ByteBuffer byteBufferDuplicate = zzaqmVar.f24170e.duplicate();
                byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                zzaqr.b(byteBufferDuplicate);
                int iPosition = byteBufferDuplicate.position() + 16;
                if (j2 < 0 || j2 > 4294967295L) {
                    StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 27);
                    sb.append("uint32 value of out range: ");
                    sb.append(j2);
                    throw new IllegalArgumentException(sb.toString());
                }
                byteBufferDuplicate.putInt(byteBufferDuplicate.position() + iPosition, (int) j2);
                zzaqj zzaqjVar = new zzaqj(byteBufferDuplicate);
                int size = map.size();
                int[] iArr = new int[size];
                Iterator it = map.keySet().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    iArr[i3] = ((Integer) it.next()).intValue();
                    i3++;
                }
                try {
                    byte[][] bArrD = d(iArr, new zzaqk[]{zzaqlVar, zzaqlVar2, zzaqjVar});
                    for (int i4 = 0; i4 < size; i4++) {
                        int i5 = iArr[i4];
                        if (!MessageDigest.isEqual((byte[]) map.get(Integer.valueOf(i5)), bArrD[i4])) {
                            throw new SecurityException(f(i5).concat(" digest of contents did not verify"));
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

    public static X509Certificate[] c(ByteBuffer byteBuffer, HashMap map, CertificateFactory certificateFactory) throws InvalidKeySpecException, NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        Pair pairCreate;
        ByteBuffer byteBufferI = i(byteBuffer);
        ByteBuffer byteBufferI2 = i(byteBuffer);
        byte[] bArrJ = j(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrJ2 = null;
        byte[] bArrJ3 = null;
        int i2 = -1;
        int i3 = 0;
        while (byteBufferI2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer byteBufferI3 = i(byteBufferI2);
                if (byteBufferI3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i4 = byteBufferI3.getInt();
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
                    int iE = e(i4);
                    int iE2 = e(i2);
                    if (iE != 1 && iE2 == 1) {
                    }
                }
                bArrJ3 = j(byteBufferI3);
                i2 = i4;
            } catch (IOException e2) {
                e = e2;
                throw new SecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i3).length() + 34), i3, "Failed to parse signature record #"), e);
            } catch (BufferUnderflowException e3) {
                e = e3;
                throw new SecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i3).length() + 34), i3, "Failed to parse signature record #"), e);
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
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrJ));
            Signature signature = Signature.getInstance(str2);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferI);
            if (!signature.verify(bArrJ3)) {
                throw new SecurityException(String.valueOf(str2).concat(" signature did not verify"));
            }
            byteBufferI.clear();
            ByteBuffer byteBufferI4 = i(byteBufferI);
            ArrayList arrayList2 = new ArrayList();
            int i5 = 0;
            while (byteBufferI4.hasRemaining()) {
                i5++;
                try {
                    ByteBuffer byteBufferI5 = i(byteBufferI4);
                    if (byteBufferI5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i6 = byteBufferI5.getInt();
                    arrayList2.add(Integer.valueOf(i6));
                    if (i6 == i2) {
                        bArrJ2 = j(byteBufferI5);
                    }
                } catch (IOException e4) {
                    e = e4;
                    throw new IOException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i5).length() + 31), i5, "Failed to parse digest record #"), e);
                } catch (BufferUnderflowException e5) {
                    e = e5;
                    throw new IOException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i5).length() + 31), i5, "Failed to parse digest record #"), e);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iE3 = e(i2);
            byte[] bArr = (byte[]) map.put(Integer.valueOf(iE3), bArrJ2);
            if (bArr != null && !MessageDigest.isEqual(bArr, bArrJ2)) {
                throw new SecurityException(f(iE3).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            ByteBuffer byteBufferI6 = i(byteBufferI);
            ArrayList arrayList3 = new ArrayList();
            int i7 = 0;
            while (byteBufferI6.hasRemaining()) {
                i7++;
                byte[] bArrJ4 = j(byteBufferI6);
                try {
                    arrayList3.add(new zzaqo((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrJ4)), bArrJ4));
                } catch (CertificateException e6) {
                    throw new SecurityException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i7).length() + 30), i7, "Failed to decode certificate #"), e6);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (Arrays.equals(bArrJ, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
            }
            throw new SecurityException("Public key mismatch between certificate and signature record");
        } catch (InvalidAlgorithmParameterException e7) {
            e = e7;
            throw new SecurityException(android.support.v4.media.b.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        } catch (InvalidKeyException e8) {
            e = e8;
            throw new SecurityException(android.support.v4.media.b.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            throw new SecurityException(android.support.v4.media.b.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        } catch (SignatureException e10) {
            e = e10;
            throw new SecurityException(android.support.v4.media.b.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        } catch (InvalidKeySpecException e11) {
            e = e11;
            throw new SecurityException(android.support.v4.media.b.s(new StringBuilder(String.valueOf(str2).length() + 27), "Failed to verify ", str2, " signature"), e);
        }
    }

    public static byte[][] d(int[] iArr, zzaqk[] zzaqkVarArr) throws DigestException {
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
            jZza += (zzaqkVarArr[i3].zza() + 1048575) / 1048576;
            i3++;
        }
        if (jZza >= 2097151) {
            StringBuilder sb = new StringBuilder(String.valueOf(jZza).length() + 17);
            sb.append("Too many chunks: ");
            sb.append(jZza);
            throw new DigestException(sb.toString());
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
            byte[] bArr2 = new byte[(g(iArr[i4]) * i5) + 5];
            bArr2[0] = 90;
            k(i5, bArr2);
            bArr[i4] = bArr2;
            i4++;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i6 = 0; i6 < iArr.length; i6++) {
            String strF = f(iArr[i6]);
            try {
                messageDigestArr[i6] = MessageDigest.getInstance(strF);
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(strF.concat(" digest not supported"), e2);
            }
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (i2 = 3; i7 < i2; i2 = 3) {
            zzaqk zzaqkVar = zzaqkVarArr[i7];
            int i10 = i7;
            long jZza2 = zzaqkVar.zza();
            long j3 = 0;
            while (jZza2 > 0) {
                char c3 = c2;
                int i11 = i8;
                int iMin = (int) Math.min(jZza2, j2);
                k(iMin, bArr3);
                for (int i12 = 0; i12 < length; i12++) {
                    messageDigestArr[i12].update(bArr3);
                }
                try {
                    zzaqkVar.zzb(messageDigestArr, j3, iMin);
                    int i13 = 0;
                    while (i13 < iArr.length) {
                        int i14 = iArr[i13];
                        byte[] bArr4 = bArr[i13];
                        int iG = g(i14);
                        zzaqk zzaqkVar2 = zzaqkVar;
                        MessageDigest messageDigest = messageDigestArr[i13];
                        long j4 = jZza2;
                        int iDigest = messageDigest.digest(bArr4, (i11 * iG) + 5, iG);
                        if (iDigest != iG) {
                            String algorithm = messageDigest.getAlgorithm();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(algorithm).length() + 35 + String.valueOf(iDigest).length());
                            sb2.append("Unexpected output size of ");
                            sb2.append(algorithm);
                            sb2.append(" digest: ");
                            sb2.append(iDigest);
                            throw new RuntimeException(sb2.toString());
                        }
                        i13++;
                        zzaqkVar = zzaqkVar2;
                        jZza2 = j4;
                    }
                    zzaqk zzaqkVar3 = zzaqkVar;
                    long j5 = iMin;
                    j3 += j5;
                    jZza2 -= j5;
                    i8 = i11 + 1;
                    c2 = c3;
                    zzaqkVar = zzaqkVar3;
                    j2 = 1048576;
                } catch (IOException e3) {
                    throw new DigestException(androidx.fragment.app.e.n(i11, i9, "Failed to digest chunk #", " of section #", new StringBuilder(String.valueOf(i11).length() + 37 + String.valueOf(i9).length())), e3);
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
            String strF2 = f(i16);
            try {
                bArr5[i15] = MessageDigest.getInstance(strF2).digest(bArr6);
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(strF2.concat(" digest not supported"), e4);
            }
        }
        return bArr5;
    }

    public static int e(int i2) {
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

    public static String f(int i2) {
        if (i2 == 1) {
            return MessageDigestAlgorithms.SHA_256;
        }
        if (i2 == 2) {
            return MessageDigestAlgorithms.SHA_512;
        }
        throw new IllegalArgumentException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 33), i2, "Unknown content digest algorthm: "));
    }

    public static int g(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        throw new IllegalArgumentException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(i2).length() + 33), i2, "Unknown content digest algorthm: "));
    }

    public static ByteBuffer h(int i2, ByteBuffer byteBuffer) {
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

    public static ByteBuffer i(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            int iRemaining = byteBuffer.remaining();
            throw new IOException(androidx.fragment.app.e.r(new StringBuilder(String.valueOf(iRemaining).length() + 82), iRemaining, "Remaining buffer too short to contain length of length-prefixed field. Remaining: "));
        }
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            return h(i2, byteBuffer);
        }
        int iRemaining2 = byteBuffer.remaining();
        throw new IOException(androidx.fragment.app.e.n(i2, iRemaining2, "Length-prefixed field longer than remaining buffer. Field length: ", ", remaining: ", new StringBuilder(String.valueOf(i2).length() + 79 + String.valueOf(iRemaining2).length())));
    }

    public static byte[] j(ByteBuffer byteBuffer) throws IOException {
        int i2 = byteBuffer.getInt();
        if (i2 < 0) {
            throw new IOException("Negative length");
        }
        if (i2 <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i2];
            byteBuffer.get(bArr);
            return bArr;
        }
        int iRemaining = byteBuffer.remaining();
        throw new IOException(androidx.fragment.app.e.n(i2, iRemaining, "Underflow while reading length-prefixed value. Length: ", ", available: ", new StringBuilder(String.valueOf(i2).length() + 68 + String.valueOf(iRemaining).length())));
    }

    public static void k(int i2, byte[] bArr) {
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 >>> 8) & 255);
        bArr[3] = (byte) ((i2 >>> 16) & 255);
        bArr[4] = (byte) (i2 >> 24);
    }
}
