package com.google.android.play.core.splitinstall.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzam {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.play.core.splitcompat.zze f41961a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f41962b;

    /* renamed from: c, reason: collision with root package name */
    public final zzal f41963c;

    /* renamed from: d, reason: collision with root package name */
    public PackageInfo f41964d;

    public zzam(Context context, com.google.android.play.core.splitcompat.zze zzeVar) {
        zzal zzalVar = new zzal();
        this.f41961a = zzeVar;
        this.f41962b = context;
        this.f41963c = zzalVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (r6.f41960a.getName().equals("manifest") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        r4 = r6.f41960a.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCode");
        r5 = r6.f41960a.getAttributeValue("http://schemas.android.com/apk/res/android", "versionCodeMajor");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
    
        if (r4 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        r4 = java.lang.Integer.parseInt(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r5 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        r4 = (java.lang.Integer.parseInt(r5) << 32) | (r4 & 4294967295L);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(android.support.v4.media.b.C("Couldn't parse versionCodeMajor to int: ", r12.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009f, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(android.support.v4.media.b.C("Couldn't parse versionCode to int: ", r12.getMessage()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a7, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("Manifest entry doesn't contain 'versionCode' attribute.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(java.io.File[] r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r11 = this;
            android.content.pm.PackageInfo r0 = r11.c()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto Lf
            long r0 = androidx.core.view.i.a(r0)
            goto L12
        Lf:
            int r0 = r0.versionCode
            long r0 = (long) r0
        L12:
            java.lang.Object r2 = com.google.android.play.core.splitinstall.internal.zzbk.b()
            android.content.res.AssetManager r2 = (android.content.res.AssetManager) r2
            int r3 = r12.length
        L19:
            int r3 = r3 + (-1)
            r4 = 1
            if (r3 < 0) goto Lb8
            r5 = r12[r3]
            com.google.android.play.core.splitinstall.internal.zzal r6 = r11.f41963c
            int r5 = com.google.android.play.core.splitcompat.zza.b(r2, r5)
            java.lang.String r7 = "AndroidManifest.xml"
            android.content.res.XmlResourceParser r5 = r2.openXmlResourceParser(r5, r7)
            r6.f41960a = r5
            if (r5 == 0) goto Lb0
        L30:
            android.content.res.XmlResourceParser r5 = r6.f41960a
            int r5 = r5.next()
            r7 = 2
            if (r5 == r7) goto L3c
            if (r5 == r4) goto La8
            goto L30
        L3c:
            android.content.res.XmlResourceParser r4 = r6.f41960a
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = "manifest"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto La8
            android.content.res.XmlResourceParser r4 = r6.f41960a
            java.lang.String r5 = "versionCode"
            java.lang.String r7 = "http://schemas.android.com/apk/res/android"
            java.lang.String r4 = r4.getAttributeValue(r7, r5)
            android.content.res.XmlResourceParser r5 = r6.f41960a
            java.lang.String r6 = "versionCodeMajor"
            java.lang.String r5 = r5.getAttributeValue(r7, r6)
            if (r4 == 0) goto La0
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L8f
            if (r5 != 0) goto L66
            long r4 = (long) r4
            goto L78
        L66:
            int r5 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.NumberFormatException -> L7e
            long r5 = (long) r5
            long r7 = (long) r4
            r4 = 32
            long r4 = r5 << r4
            r9 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r6 = r7 & r9
            long r4 = r4 | r6
        L78:
            int r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r4 == 0) goto L19
            r12 = 0
            return r12
        L7e:
            r12 = move-exception
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r12 = r12.getMessage()
            java.lang.String r1 = "Couldn't parse versionCodeMajor to int: "
            java.lang.String r12 = android.support.v4.media.b.C(r1, r12)
            r0.<init>(r12)
            throw r0
        L8f:
            r12 = move-exception
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r12 = r12.getMessage()
            java.lang.String r1 = "Couldn't parse versionCode to int: "
            java.lang.String r12 = android.support.v4.media.b.C(r1, r12)
            r0.<init>(r12)
            throw r0
        La0:
            org.xmlpull.v1.XmlPullParserException r12 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r0 = "Manifest entry doesn't contain 'versionCode' attribute."
            r12.<init>(r0)
            throw r12
        La8:
            org.xmlpull.v1.XmlPullParserException r12 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r0 = "Couldn't find manifest entry at top-level."
            r12.<init>(r0)
            throw r12
        Lb0:
            org.xmlpull.v1.XmlPullParserException r12 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r0 = "Manifest file needs to be loaded before parsing."
            r12.<init>(r0)
            throw r12
        Lb8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.internal.zzam.a(java.io.File[]):boolean");
    }

    public final boolean b(File[] fileArr) {
        String absolutePath;
        X509Certificate x509Certificate;
        PackageInfo packageInfoC = c();
        ArrayList<X509Certificate> arrayList = null;
        if (packageInfoC != null && packageInfoC.signatures != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Signature signature : packageInfoC.signatures) {
                try {
                    x509Certificate = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                } catch (CertificateException e2) {
                    Log.e("SplitCompat", "Cannot decode certificate.", e2);
                    x509Certificate = null;
                }
                if (x509Certificate != null) {
                    arrayList2.add(x509Certificate);
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            Log.e("SplitCompat", "No app certificates found.");
            return false;
        }
        int length = fileArr.length;
        loop1: while (true) {
            length--;
            if (length < 0) {
                return true;
            }
            try {
                absolutePath = fileArr[length].getAbsolutePath();
                try {
                    X509Certificate[][] x509CertificateArrA = zzi.a(absolutePath);
                    if (x509CertificateArrA == null || x509CertificateArrA.length == 0 || x509CertificateArrA[0].length == 0) {
                        break;
                    }
                    if (arrayList.isEmpty()) {
                        Log.e("SplitCompat", "No certificates found for app.");
                        break;
                    }
                    for (X509Certificate x509Certificate2 : arrayList) {
                        for (X509Certificate[] x509CertificateArr : x509CertificateArrA) {
                            int i2 = x509CertificateArr[0].equals(x509Certificate2) ? 0 : i2 + 1;
                        }
                        Log.i("SplitCompat", "There's an app certificate that doesn't sign the split.");
                    }
                } catch (Exception e3) {
                    Log.e("SplitCompat", "Downloaded split " + absolutePath + " is not signed.", e3);
                }
            } catch (Exception e4) {
                Log.e("SplitCompat", "Split verification error.", e4);
                return false;
            }
        }
        Log.e("SplitCompat", "Downloaded split " + absolutePath + " is not signed.");
        Log.e("SplitCompat", "Split verification failure.");
        return false;
    }

    public final PackageInfo c() {
        Context context = this.f41962b;
        if (this.f41964d == null) {
            try {
                this.f41964d = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return this.f41964d;
    }
}
