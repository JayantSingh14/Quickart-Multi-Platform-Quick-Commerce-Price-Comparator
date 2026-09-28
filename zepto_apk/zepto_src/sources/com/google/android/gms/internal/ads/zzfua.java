package com.google.android.gms.internal.ads;

import android.os.Build;
import in.juspay.hyper.constants.LogSubCategory;
import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzfua {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f31862c = {61, 122, 18, 35, 1, -102, -93, -99, -98, -96, -29, 67, 106, -73, -64, -119, 107, -5, 79, -74, 121, -12, -34, 95, -25, -62, 63, 50, 108, -113, -103, 74};

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f31863d = {-110, -13, -34, 70, -83, 43, 97, 21, -44, 16, -54, -125, -28, -57, -125, -127, -7, 17, 102, -69, 116, -121, -79, 43, -13, 120, 58, 55, -29, -108, 95, 83};

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f31864a = f31863d;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f31865b = f31862c;

    public final boolean a(File file) throws GeneralSecurityException {
        try {
            X509Certificate[][] x509CertificateArrA = zzaqq.a(file.getAbsolutePath());
            if (x509CertificateArrA.length != 1) {
                throw new GeneralSecurityException("APK has more than one signature.");
            }
            byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(x509CertificateArrA[0][0].getEncoded());
            return Arrays.equals(this.f31865b, bArrDigest) || (!LogSubCategory.Action.USER.equals(Build.TYPE) && Arrays.equals(this.f31864a, bArrDigest));
        } catch (zzaqn e2) {
            throw new GeneralSecurityException("Package is not signed", e2);
        } catch (IOException e3) {
            e = e3;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        } catch (RuntimeException e4) {
            e = e4;
            throw new GeneralSecurityException("Failed to verify signatures", e);
        }
    }
}
