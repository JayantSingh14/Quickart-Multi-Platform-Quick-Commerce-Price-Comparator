package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.fragment.app.e;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.facebook.react.modules.appstate.AppStateModule;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public final class zzpo extends zzje {

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f39638i = {"firebase_", "google_", "ga_"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f39639j = {"_err"};

    /* renamed from: c, reason: collision with root package name */
    public SecureRandom f39640c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicLong f39641d;

    /* renamed from: e, reason: collision with root package name */
    public int f39642e;

    /* renamed from: f, reason: collision with root package name */
    public MeasurementManagerFutures f39643f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f39644g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f39645h;

    public zzpo(zzib zzibVar) {
        super(zzibVar);
        this.f39645h = null;
        this.f39641d = new AtomicLong(0L);
    }

    public static boolean B(String str) {
        String str2 = (String) zzfx.r0.a(null);
        return str2.equals("*") || Arrays.asList(str2.split(",")).contains(str);
    }

    public static boolean D(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(Attributes.PREDEFINED_ATTRIBUTE_PREFIX);
    }

    public static boolean E(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] J(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static ArrayList U(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzah zzahVar = (zzah) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzahVar.f38676a);
            bundle.putString("origin", zzahVar.f38677b);
            bundle.putLong("creation_timestamp", zzahVar.f38679d);
            bundle.putString(CLConstants.FIELD_PAY_INFO_NAME, zzahVar.f38678c.f39627b);
            zzjg.a(bundle, Preconditions.checkNotNull(zzahVar.f38678c.b()));
            bundle.putBoolean(AppStateModule.APP_STATE_ACTIVE, zzahVar.f38680e);
            String str = zzahVar.f38681f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzbg zzbgVar = zzahVar.f38682g;
            if (zzbgVar != null) {
                bundle.putString("timed_out_event_name", zzbgVar.f38769a);
                zzbe zzbeVar = zzbgVar.f38770b;
                if (zzbeVar != null) {
                    bundle.putBundle("timed_out_event_params", zzbeVar.A());
                }
            }
            bundle.putLong("trigger_timeout", zzahVar.f38683h);
            zzbg zzbgVar2 = zzahVar.f38684i;
            if (zzbgVar2 != null) {
                bundle.putString("triggered_event_name", zzbgVar2.f38769a);
                zzbe zzbeVar2 = zzbgVar2.f38770b;
                if (zzbeVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzbeVar2.A());
                }
            }
            bundle.putLong("triggered_timestamp", zzahVar.f38678c.f39628c);
            bundle.putLong("time_to_live", zzahVar.f38685j);
            zzbg zzbgVar3 = zzahVar.f38686k;
            if (zzbgVar3 != null) {
                bundle.putString("expired_event_name", zzbgVar3.f38769a);
                zzbe zzbeVar3 = zzbgVar3.f38770b;
                if (zzbeVar3 != null) {
                    bundle.putBundle("expired_event_params", zzbeVar3.A());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean V(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static void W(zzlt zzltVar, Bundle bundle, boolean z) {
        if (bundle != null && zzltVar != null) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzltVar.f39352a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzltVar.f39353b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzltVar.f39354c);
                return;
            }
            z = false;
        }
        if (bundle != null && zzltVar == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static final boolean Y(int i2, Bundle bundle) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i2);
        return true;
    }

    public static boolean d0(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static String l(String str, int i2, boolean z) {
        if (str != null) {
            if (str.codePointCount(0, str.length()) <= i2) {
                return str;
            }
            if (z) {
                return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i2))).concat("...");
            }
        }
        return null;
    }

    public static boolean n0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static void w(zzpn zzpnVar, String str, int i2, String str2, String str3, int i3) {
        Bundle bundle = new Bundle();
        Y(i2, bundle);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i2 == 6 || i2 == 7 || i2 == 2) {
            bundle.putLong("_el", i3);
        }
        zzpnVar.a(str, "_err", bundle);
    }

    public static MessageDigest x() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static long y(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i2 = 0;
        Preconditions.checkState(length > 0);
        long j2 = 0;
        for (int i3 = length - 1; i3 >= 0 && i3 >= bArr.length - 8; i3--) {
            j2 += (bArr[i3] & 255) << i2;
            i2 += 8;
        }
        return j2;
    }

    public static boolean z(Context context) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementJobService"), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cf A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long A() {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpo.A():long");
    }

    public final boolean C(String str) {
        g();
        zzib zzibVar = this.f39180a;
        if (Wrappers.packageManager(zzibVar.f39084a).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzgt zzgtVar = zzibVar.f39089f;
        zzib.l(zzgtVar);
        zzgtVar.f38965m.b(str, "Permission not granted");
        return false;
    }

    public final boolean F(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f39180a.f39087d.k("debug.firebase.analytics.app").equals(str);
    }

    public final Bundle G(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object objN = n(bundle.get(str), str);
                if (objN == null) {
                    zzib zzibVar = this.f39180a;
                    zzgt zzgtVar = zzibVar.f39089f;
                    zzib.l(zzgtVar);
                    zzgtVar.f38963k.b(zzibVar.f39093j.b(str), "Param value can't be null");
                } else {
                    v(bundle2, str, objN);
                }
            }
        }
        return bundle2;
    }

    public final zzbg H(String str, Bundle bundle, String str2, long j2, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (j0(str) != 0) {
            zzib zzibVar = this.f39180a;
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(zzibVar.f39093j.c(str), "Invalid conditional property event name");
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        Bundle bundleO = o(str, bundle2, CollectionUtils.listOf("_o"), true);
        if (z) {
            bundleO = G(bundleO);
        }
        Preconditions.checkNotNull(bundleO);
        return new zzbg(str, new zzbe(bundleO), str2, j2);
    }

    public final boolean I(Context context, String str) {
        Signature[] signatureArr;
        zzib zzibVar = this.f39180a;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e2) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38958f.b(e2, "Package name not found");
            return true;
        } catch (CertificateException e3) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38958f.b(e3, "Error obtaining certificate");
            return true;
        }
    }

    public final boolean K(int i2) {
        Boolean bool = this.f39180a.o().f39486e;
        if (L() < i2 / 1000) {
            return (bool == null || bool.booleanValue()) ? false : true;
        }
        return true;
    }

    public final int L() {
        if (this.f39645h == null) {
            this.f39645h = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.f39180a.f39084a) / 1000);
        }
        return this.f39645h.intValue();
    }

    public final void M(Bundle bundle, long j2) {
        long j3 = bundle.getLong("_et");
        if (j3 != 0) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(Long.valueOf(j3), "Params already contained engagement");
        } else {
            j3 = 0;
        }
        bundle.putLong("_et", j2 + j3);
    }

    public final void N(String str, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        try {
            zzcuVar.b0(e.i("r", str));
        } catch (RemoteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error returning string value to wrapper");
        }
    }

    public final void O(com.google.android.gms.internal.measurement.zzcu zzcuVar, long j2) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j2);
        try {
            zzcuVar.b0(bundle);
        } catch (RemoteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error returning long value to wrapper");
        }
    }

    public final void P(com.google.android.gms.internal.measurement.zzcu zzcuVar, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i2);
        try {
            zzcuVar.b0(bundle);
        } catch (RemoteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error returning int value to wrapper");
        }
    }

    public final void Q(com.google.android.gms.internal.measurement.zzcu zzcuVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcuVar.b0(bundle);
        } catch (RemoteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error returning byte array to wrapper");
        }
    }

    public final void R(com.google.android.gms.internal.measurement.zzcu zzcuVar, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcuVar.b0(bundle);
        } catch (RemoteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error returning boolean value to wrapper");
        }
    }

    public final void S(com.google.android.gms.internal.measurement.zzcu zzcuVar, Bundle bundle) {
        try {
            zzcuVar.b0(bundle);
        } catch (RemoteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error returning bundle value to wrapper");
        }
    }

    public final void T(com.google.android.gms.internal.measurement.zzcu zzcuVar, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcuVar.b0(bundle);
        } catch (RemoteException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Error returning bundle list to wrapper");
        }
    }

    public final String X() {
        byte[] bArr = new byte[16];
        c0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final Object Z(int i2, Object obj, boolean z, boolean z2) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return l(obj.toString(), i2, z);
        }
        if (!z2) {
            return null;
        }
        if (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[])) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if (parcelable instanceof Bundle) {
                Bundle bundleG = G((Bundle) parcelable);
                if (!bundleG.isEmpty()) {
                    arrayList.add(bundleG);
                }
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int a0(String str) {
        boolean zEquals = "_ldl".equals(str);
        zzib zzibVar = this.f39180a;
        if (zEquals) {
            zzibVar.getClass();
            return 2048;
        }
        if ("_id".equals(str)) {
            zzibVar.getClass();
            return 256;
        }
        if ("_lgclid".equals(str)) {
            zzibVar.getClass();
            return 100;
        }
        zzibVar.getClass();
        return 36;
    }

    public final long b0() {
        long andIncrement;
        long j2;
        AtomicLong atomicLong = this.f39641d;
        if (atomicLong.get() != 0) {
            AtomicLong atomicLong2 = this.f39641d;
            synchronized (atomicLong2) {
                atomicLong2.compareAndSet(-1L, 1L);
                andIncrement = atomicLong2.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (atomicLong) {
            long jNextLong = new Random(System.nanoTime() ^ this.f39180a.f39094k.currentTimeMillis()).nextLong();
            int i2 = this.f39642e + 1;
            this.f39642e = i2;
            j2 = jNextLong + i2;
        }
        return j2;
    }

    public final SecureRandom c0() {
        g();
        if (this.f39640c == null) {
            this.f39640c = new SecureRandom();
        }
        return this.f39640c;
    }

    public final Bundle e0(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            for (String str2 : uri.getQueryParameterNames()) {
                if (str2.startsWith("gad_")) {
                    String queryParameter19 = uri.getQueryParameter(str2);
                    if (!TextUtils.isEmpty(queryParameter19)) {
                        bundle.putString(str2, queryParameter19);
                    }
                }
            }
            return bundle;
        } catch (UnsupportedOperationException e2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38961i.b(e2, "Install referrer url isn't a hierarchical URI");
            return null;
        }
    }

    public final boolean f0(String str, String str2) {
        zzib zzibVar = this.f39180a;
        if (str2 == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38960h.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38960h.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            zzgt zzgtVar3 = zzibVar.f39089f;
            zzib.l(zzgtVar3);
            zzgtVar3.f38960h.c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzgt zzgtVar4 = zzibVar.f39089f;
                zzib.l(zzgtVar4);
                zzgtVar4.f38960h.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final boolean g0(String str, String str2) {
        zzib zzibVar = this.f39180a;
        if (str2 == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38960h.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.length() == 0) {
            zzgt zzgtVar2 = zzibVar.f39089f;
            zzib.l(zzgtVar2);
            zzgtVar2.f38960h.b(str, "Name is required and can't be empty. Type");
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            if (iCodePointAt != 95) {
                zzgt zzgtVar3 = zzibVar.f39089f;
                zzib.l(zzgtVar3);
                zzgtVar3.f38960h.c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                return false;
            }
            iCodePointAt = 95;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzgt zzgtVar4 = zzibVar.f39089f;
                zzib.l(zzgtVar4);
                zzgtVar4.f38960h.c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzje
    public final boolean h() {
        return true;
    }

    public final boolean h0(String str, String[] strArr, String[] strArr2, String str2) {
        zzib zzibVar = this.f39180a;
        if (str2 == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38960h.b(str, "Name is required and can't be null. Type");
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = f39638i;
        for (int i2 = 0; i2 < 3; i2++) {
            if (str2.startsWith(strArr3[i2])) {
                zzgt zzgtVar2 = zzibVar.f39089f;
                zzib.l(zzgtVar2);
                zzgtVar2.f38960h.c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !E(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && E(str2, strArr2)) {
            return true;
        }
        zzgt zzgtVar3 = zzibVar.f39089f;
        zzib.l(zzgtVar3);
        zzgtVar3.f38960h.c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final boolean i0(int i2, String str, String str2) {
        zzib zzibVar = this.f39180a;
        if (str2 == null) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38960h.b(str, "Name is required and can't be null. Type");
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i2) {
            return true;
        }
        zzgt zzgtVar2 = zzibVar.f39089f;
        zzib.l(zzgtVar2);
        zzgtVar2.f38960h.d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i2), str2);
        return false;
    }

    public final int j0(String str) {
        if (!g0("event", str)) {
            return 2;
        }
        if (!h0("event", zzjl.f39201a, zzjl.f39202b, str)) {
            return 13;
        }
        this.f39180a.getClass();
        return !i0(40, "event", str) ? 2 : 0;
    }

    public final boolean k(String str) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzib zzibVar = this.f39180a;
        if (zIsEmpty) {
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38960h.a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        zzgt zzgtVar2 = zzibVar.f39089f;
        zzib.l(zzgtVar2);
        zzgtVar2.f38960h.b(zzgt.o(str), "Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id");
        return false;
    }

    public final int k0(String str) {
        if (!g0("user property", str)) {
            return 6;
        }
        if (!h0("user property", zzjn.f39209a, null, str)) {
            return 15;
        }
        this.f39180a.getClass();
        return !i0(24, "user property", str) ? 6 : 0;
    }

    public final int l0(String str) {
        if (!f0("event param", str)) {
            return 3;
        }
        if (!h0("event param", null, null, str)) {
            return 14;
        }
        this.f39180a.getClass();
        return !i0(40, "event param", str) ? 3 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m(java.lang.String r13, java.lang.String r14, java.lang.Object r15, android.os.Bundle r16, java.util.List r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpo.m(java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final int m0(String str) {
        if (!g0("event param", str)) {
            return 3;
        }
        if (!h0("event param", null, null, str)) {
            return 14;
        }
        this.f39180a.getClass();
        return !i0(40, "event param", str) ? 3 : 0;
    }

    public final Object n(Object obj, String str) {
        boolean zEquals = "_ev".equals(str);
        int iMax = 500;
        zzib zzibVar = this.f39180a;
        if (zEquals) {
            zzibVar.f39087d.getClass();
            return Z(Math.max(500, 256), obj, true, true);
        }
        if (D(str)) {
            zzibVar.f39087d.getClass();
            iMax = Math.max(500, 256);
        } else {
            zzibVar.f39087d.getClass();
        }
        return Z(iMax, obj, false, true);
    }

    public final Bundle o(String str, Bundle bundle, List list, boolean z) {
        int iL0;
        List list2 = list;
        boolean zE = E(str, zzjl.f39204d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        zzib zzibVar = this.f39180a;
        zzpo zzpoVar = zzibVar.f39087d.f39180a.f39092i;
        zzib.j(zzpoVar);
        int i2 = zzpoVar.K(201500000) ? 100 : 25;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i3 = 0;
        boolean z2 = false;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (list2 == null || !list2.contains(str2)) {
                iL0 = !z ? l0(str2) : 0;
                if (iL0 == 0) {
                    iL0 = m0(str2);
                }
            } else {
                iL0 = 0;
            }
            if (iL0 != 0) {
                s(bundle2, iL0, str2, iL0 == 3 ? str2 : null);
                bundle2.remove(str2);
            } else {
                int iM = m(str, str2, bundle.get(str2), bundle2, list2, z, zE);
                if (iM == 17) {
                    s(bundle2, 17, str2, Boolean.FALSE);
                } else if (iM != 0 && !"_ev".equals(str2)) {
                    s(bundle2, iM, iM == 21 ? str : str2, bundle.get(str2));
                    bundle2.remove(str2);
                }
                if (d0(str2) && (i3 = i3 + 1) > i2) {
                    if (!zzibVar.f39087d.q(null, zzfx.f1) || !z2) {
                        String strU = e.u(new StringBuilder(String.valueOf(i2).length() + 37), "Event can't contain more than ", i2, " params");
                        zzgt zzgtVar = zzibVar.f39089f;
                        zzib.l(zzgtVar);
                        zzgm zzgmVar = zzibVar.f39093j;
                        zzgtVar.f38960h.c(strU, zzgmVar.a(str), zzgmVar.e(bundle));
                    }
                    Y(5, bundle2);
                    bundle2.remove(str2);
                    z2 = true;
                }
            }
            list2 = list;
        }
        return bundle2;
    }

    public final boolean o0(String str, String str2, int i2, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String string = obj.toString();
        if (string.codePointCount(0, string.length()) > i2) {
            zzgt zzgtVar = this.f39180a.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38963k.d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(string.length()));
            return false;
        }
        return true;
    }

    public final void p(zzgu zzguVar, int i2) {
        Bundle bundle = zzguVar.f38969d;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i3 = 0;
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (d0(str) && (i3 = i3 + 1) > i2) {
                zzib zzibVar = this.f39180a;
                if (!zzibVar.f39087d.q(null, zzfx.f1) || !z) {
                    String strU = e.u(new StringBuilder(String.valueOf(i2).length() + 37), "Event can't contain more than ", i2, " params");
                    zzgt zzgtVar = zzibVar.f39089f;
                    zzib.l(zzgtVar);
                    zzgm zzgmVar = zzibVar.f39093j;
                    zzgtVar.f38960h.c(strU, zzgmVar.a(zzguVar.f38966a), zzgmVar.e(bundle));
                    Y(5, bundle);
                }
                bundle.remove(str);
                z = true;
            }
        }
    }

    public final void p0(String str, String str2, Bundle bundle, List list, boolean z) {
        int iL0;
        zzgt zzgtVar;
        String str3;
        int iM;
        List list2 = list;
        if (bundle == null) {
            return;
        }
        zzib zzibVar = this.f39180a;
        zzpo zzpoVar = zzibVar.f39087d.f39180a.f39092i;
        zzib.j(zzpoVar);
        int i2 = true != zzpoVar.K(231100000) ? 0 : 35;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i3 = 0;
        boolean z2 = false;
        while (it.hasNext()) {
            String str4 = (String) it.next();
            if (list2 == null || !list2.contains(str4)) {
                iL0 = !z ? l0(str4) : 0;
                if (iL0 == 0) {
                    iL0 = m0(str4);
                }
            } else {
                iL0 = 0;
            }
            if (iL0 != 0) {
                s(bundle, iL0, str4, iL0 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                boolean zN0 = n0(bundle.get(str4));
                zzgt zzgtVar2 = zzibVar.f39089f;
                if (zN0) {
                    zzib.l(zzgtVar2);
                    zzgtVar2.f38963k.d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str, str2, str4);
                    iM = 22;
                    zzgtVar = zzgtVar2;
                    str3 = null;
                } else {
                    zzgtVar = zzgtVar2;
                    str3 = null;
                    iM = m(str, str4, bundle.get(str4), bundle, list2, z, false);
                }
                if (iM != 0 && !"_ev".equals(str4)) {
                    s(bundle, iM, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (d0(str4) && !E(str4, zzjm.f39208d)) {
                    i3++;
                    boolean zK = K(231100000);
                    zzgm zzgmVar = zzibVar.f39093j;
                    if (zK) {
                        zzgt zzgtVar3 = zzgtVar;
                        if (i3 > i2) {
                            if (!zzibVar.f39087d.q(str3, zzfx.f1) || !z2) {
                                zzib.l(zzgtVar3);
                                zzgtVar3.f38960h.c(e.u(new StringBuilder(String.valueOf(i2).length() + 55), "Item can't contain more than ", i2, " item-scoped custom params"), zzgmVar.a(str), zzgmVar.e(bundle));
                            }
                            Y(28, bundle);
                            bundle.remove(str4);
                            list2 = list;
                            z2 = true;
                        }
                    } else {
                        zzib.l(zzgtVar);
                        zzgtVar.f38960h.c("Item array not supported on client's version of Google Play Services (Android Only)", zzgmVar.a(str), zzgmVar.e(bundle));
                        Y(23, bundle);
                        bundle.remove(str4);
                    }
                }
            }
            list2 = list;
        }
    }

    public final void q(Parcelable[] parcelableArr, int i2) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i3 = 0;
            boolean z = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (d0(str) && !E(str, zzjm.f39208d) && (i3 = i3 + 1) > i2) {
                    zzib zzibVar = this.f39180a;
                    if (!zzibVar.f39087d.q(null, zzfx.f1) || !z) {
                        zzgt zzgtVar = zzibVar.f39089f;
                        zzib.l(zzgtVar);
                        String strU = e.u(new StringBuilder(String.valueOf(i2).length() + 60), "Param can't contain more than ", i2, " item-scoped custom parameters");
                        zzgm zzgmVar = zzibVar.f39093j;
                        zzgtVar.f38960h.c(strU, zzgmVar.b(str), zzgmVar.e(bundle));
                    }
                    Y(28, bundle);
                    bundle.remove(str);
                    z = true;
                }
            }
        }
    }

    public final void r(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                zzpo zzpoVar = this.f39180a.f39092i;
                zzib.j(zzpoVar);
                zzpoVar.v(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void s(Bundle bundle, int i2, String str, Object obj) {
        if (Y(i2, bundle)) {
            this.f39180a.getClass();
            bundle.putString("_ev", l(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", obj.toString().length());
                }
            }
        }
    }

    public final int t(Object obj, String str) {
        return "_ldl".equals(str) ? o0("user property referrer", str, a0(str), obj) : o0("user property", str, a0(str), obj) ? 0 : 7;
    }

    public final Object u(Object obj, String str) {
        return "_ldl".equals(str) ? Z(a0(str), obj, true, false) : Z(a0(str), obj, false, false);
    }

    public final void v(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
            return;
        }
        if (str != null) {
            String simpleName = obj != null ? obj.getClass().getSimpleName() : null;
            zzib zzibVar = this.f39180a;
            zzgt zzgtVar = zzibVar.f39089f;
            zzib.l(zzgtVar);
            zzgtVar.f38963k.c("Not putting event parameter. Invalid value type. name, type", zzibVar.f39093j.b(str), simpleName);
        }
    }
}
