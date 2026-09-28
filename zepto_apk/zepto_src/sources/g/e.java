package g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.amazon.identity.auth.device.api.SDKInfo;
import com.amazon.identity.auth.device.authorization.Service;
import com.amazon.identity.auth.device.dataobject.AppInfo;
import com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest;
import com.amazon.identity.auth.device.env.LWAEnvironment;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import g.r;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;

@SuppressLint({"TrustAllX509TrustManager"})
/* loaded from: classes4.dex */
public abstract class e<T extends r> extends AbstractHTTPSRequest<T> {

    /* renamed from: l, reason: collision with root package name */
    public static final String f48398l = "LWAAndroidSDK/3.0.7/Android/" + Build.VERSION.RELEASE + "/" + Build.MODEL;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f48399f;

    /* renamed from: g, reason: collision with root package name */
    public final String f48400g;

    /* renamed from: h, reason: collision with root package name */
    public final String f48401h;

    /* renamed from: i, reason: collision with root package name */
    public final String f48402i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f48403j;

    /* renamed from: k, reason: collision with root package name */
    public final AppInfo f48404k;

    public e(Context context, AppInfo appInfo) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        String str;
        this.f48403j = context;
        this.f48404k = appInfo;
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        this.f48400g = (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : context.getPackageName());
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.getMessage();
            str = "N/A";
        }
        this.f48401h = str;
        this.f48402i = SDKInfo.VERSION;
        this.f48399f = new ArrayList(10);
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final String b() {
        h.b bVar;
        String strL = l();
        Context context = this.f48403j;
        AppInfo appInfo = this.f48404k;
        synchronized (LWAEnvironment.class) {
            bVar = new h.b(context, appInfo);
        }
        bVar.f48431b = Service.PANDA;
        bVar.f48432c = o();
        return new URL(android.support.v4.media.b.k(bVar.a(), strL)).toString();
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final void f() {
        ArrayList arrayList = this.f15236c;
        arrayList.add(new Pair("User-Agent", f48398l));
        arrayList.add(new Pair("Accept-Language", Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry()));
        arrayList.add(new Pair("Accept", "application/json"));
        arrayList.add(new Pair("Accept-Charset", "UTF-8"));
        arrayList.add(new Pair("X-Amzn-RequestId", UUID.randomUUID().toString()));
        arrayList.addAll(m());
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public final void g() {
        ArrayList arrayListN = n();
        ArrayList arrayList = this.f48399f;
        arrayList.addAll(arrayListN);
        arrayList.add(new Pair("app_name", this.f48400g));
        String str = this.f48401h;
        if (str != null) {
            arrayList.add(new Pair("app_version", str));
        }
        String str2 = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str2) && !str2.equals(zzck.UNKNOWN_CONTENT_TYPE)) {
            arrayList.add(new Pair("di.hw.name", str2));
        }
        String str3 = Build.MODEL;
        if (!TextUtils.isEmpty(str3) && !str3.equals(zzck.UNKNOWN_CONTENT_TYPE)) {
            arrayList.add(new Pair("di.hw.version", str3));
        }
        arrayList.add(new Pair("di.os.name", "Android"));
        String str4 = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str4) && !str4.equals(zzck.UNKNOWN_CONTENT_TYPE)) {
            arrayList.add(new Pair("di.os.version", str4));
        }
        arrayList.add(new Pair("di.sdk.version", this.f48402i));
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public void h(HttpsURLConnection httpsURLConnection) throws ProtocolException {
        httpsURLConnection.setRequestMethod("POST");
    }

    @Override // com.amazon.identity.auth.device.endpoint.AbstractHTTPSRequest
    public void j(HttpsURLConnection httpsURLConnection) throws IOException {
        httpsURLConnection.setDoOutput(true);
        String strP = p();
        if (TextUtils.isEmpty(strP)) {
            return;
        }
        byte[] bytes = strP.getBytes("UTF-8");
        httpsURLConnection.setFixedLengthStreamingMode(bytes.length);
        OutputStream outputStream = httpsURLConnection.getOutputStream();
        try {
            outputStream.write(bytes);
            try {
                outputStream.flush();
            } catch (IOException unused) {
            }
            try {
                outputStream.close();
            } catch (IOException unused2) {
            }
        } finally {
        }
    }

    public abstract String l();

    public abstract ArrayList m();

    public abstract ArrayList n();

    public boolean o() {
        return false;
    }

    public String p() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = this.f48399f;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (pair != null) {
            }
        }
        Iterator it2 = arrayList.iterator();
        boolean z = true;
        while (it2.hasNext()) {
            Pair pair2 = (Pair) it2.next();
            if (!TextUtils.isEmpty((CharSequence) pair2.first) && !TextUtils.isEmpty((CharSequence) pair2.second)) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode((String) pair2.first, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode((String) pair2.second, "UTF-8"));
            }
        }
        return sb.toString();
    }
}
