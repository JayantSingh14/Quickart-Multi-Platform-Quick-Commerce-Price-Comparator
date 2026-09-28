package com.airbnb.lottie.network;

import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.L;
import com.airbnb.lottie.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@RestrictTo
/* loaded from: classes3.dex */
public class NetworkCache {

    /* renamed from: a, reason: collision with root package name */
    public final a f14671a;

    public NetworkCache(a aVar) {
        this.f14671a = aVar;
    }

    public static String a(String str, FileExtension fileExtension, boolean z) throws NoSuchAlgorithmException {
        String strConcat = fileExtension.f14670a;
        if (z) {
            strConcat = ".temp".concat(strConcat);
        }
        String strReplaceAll = str.replaceAll("\\W+", "");
        int length = 242 - strConcat.length();
        if (strReplaceAll.length() > length) {
            try {
                byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(strReplaceAll.getBytes());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(String.format("%02x", Byte.valueOf(b2)));
                }
                strReplaceAll = sb.toString();
            } catch (NoSuchAlgorithmException unused) {
                strReplaceAll = strReplaceAll.substring(0, length);
            }
        }
        return b.D("lottie_cache_", strReplaceAll, strConcat);
    }

    public final File b(String str) {
        File file = new File(c(), a(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(c(), a(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        File file3 = new File(c(), a(str, FileExtension.GZIP, false));
        if (file3.exists()) {
            return file3;
        }
        return null;
    }

    public final File c() {
        a aVar = this.f14671a;
        NetworkFetcher networkFetcher = L.f14106a;
        File file = new File(aVar.f14210a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File d(String str, InputStream inputStream, FileExtension fileExtension) throws NoSuchAlgorithmException, IOException {
        File file = new File(c(), a(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } finally {
            inputStream.close();
        }
    }
}
