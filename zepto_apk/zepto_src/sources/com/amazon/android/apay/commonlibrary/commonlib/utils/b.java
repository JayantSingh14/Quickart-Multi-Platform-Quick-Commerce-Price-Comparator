package com.amazon.android.apay.commonlibrary.commonlib.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f14879a = new b();

    @Metadata
    public final class a extends Lambda implements Function1<Byte, CharSequence> {

        /* renamed from: c, reason: collision with root package name */
        public static final a f14880c = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(((Number) obj).byteValue())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            return str;
        }
    }

    public static final com.amazon.android.apay.commonlibrary.interfaces.model.c a(Context context) throws PackageManager.NameNotFoundException {
        String str;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("in.amazon.mShop.android.shopping", 0);
            Objects.toString(packageInfo);
            String str5 = packageInfo.versionName;
            Integer numValueOf = null;
            List listSplit$default = str5 != null ? StringsKt__StringsKt.split$default(str5, new String[]{CLConstants.DOT_SALT_DELIMETER}, false, 0, 6, null) : null;
            Integer numValueOf2 = (listSplit$default == null || (str4 = (String) listSplit$default.get(0)) == null) ? null : Integer.valueOf(Integer.parseInt(str4));
            Integer numValueOf3 = (listSplit$default == null || (str3 = (String) listSplit$default.get(1)) == null) ? null : Integer.valueOf(Integer.parseInt(str3));
            Integer numValueOf4 = (listSplit$default == null || (str2 = (String) listSplit$default.get(2)) == null) ? null : Integer.valueOf(Integer.parseInt(str2));
            if (listSplit$default != null && (str = (String) listSplit$default.get(3)) != null) {
                numValueOf = Integer.valueOf(Integer.parseInt(str));
            }
            return new com.amazon.android.apay.commonlibrary.interfaces.model.c(true, numValueOf2, numValueOf3, numValueOf4, numValueOf);
        } catch (Exception unused) {
            return new com.amazon.android.apay.commonlibrary.interfaces.model.c(false, 0, 0, 0, 0);
        }
    }

    public static String b(Signature signature) throws IOException, CertificateEncodingException {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(MessageDigestAlgorithms.SHA_256, "hashingAlgorithm");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
        try {
            Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream);
            byteArrayInputStream.close();
            Intrinsics.checkNotNullExpressionValue(certificateGenerateCertificate, "ByteArrayInputStream(cer…Certificate(it)\n        }");
            byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(certificateGenerateCertificate.getEncoded());
            if (bArrDigest != null) {
                return ArraysKt.C(bArrDigest, "", a.f14880c, 30);
            }
            return null;
        } finally {
        }
    }

    public static final boolean c(PackageInfo packageInfo) {
        Signature[] apkContentsSigners;
        boolean zEqualsIgnoreCase;
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        if (Build.VERSION.SDK_INT >= 28) {
            apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners();
            Intrinsics.checkNotNullExpressionValue(apkContentsSigners, "packageInfo.signingInfo.apkContentsSigners");
        } else {
            apkContentsSigners = packageInfo.signatures;
            Intrinsics.checkNotNullExpressionValue(apkContentsSigners, "packageInfo.signatures");
        }
        if (apkContentsSigners.length != 1) {
            return false;
        }
        Signature signature = apkContentsSigners[0];
        f14879a.getClass();
        try {
            zEqualsIgnoreCase = "2f19adeb284eb36f7f07786152b9a1d14b21653203ad0b04ebbf9c73ab6d7625".equalsIgnoreCase(b(signature));
        } catch (Exception unused) {
            zEqualsIgnoreCase = false;
        }
        return zEqualsIgnoreCase;
    }
}
