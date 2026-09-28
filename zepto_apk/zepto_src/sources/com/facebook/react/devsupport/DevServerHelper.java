package com.facebook.react.devsupport;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.Settings;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes3.dex */
public class DevServerHelper {

    /* renamed from: a, reason: collision with root package name */
    public final DevInternalSettings f18797a;

    /* renamed from: b, reason: collision with root package name */
    public final PackagerConnectionSettings f18798b;

    /* renamed from: c, reason: collision with root package name */
    public final OkHttpClient f18799c;

    /* renamed from: d, reason: collision with root package name */
    public final BundleDownloader f18800d;

    /* renamed from: e, reason: collision with root package name */
    public final PackagerStatusCheck f18801e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f18802f;

    /* renamed from: g, reason: collision with root package name */
    public final String f18803g;

    /* renamed from: h, reason: collision with root package name */
    public JSPackagerClient f18804h;

    /* renamed from: i, reason: collision with root package name */
    public CxxInspectorPackagerConnection f18805i;

    /* renamed from: com.facebook.react.devsupport.DevServerHelper$3, reason: invalid class name */
    class AnonymousClass3 extends AsyncTask<Void, Void, Void> {
        public AnonymousClass3() {
        }

        @Override // android.os.AsyncTask
        public final Void doInBackground(Void[] voidArr) {
            DevServerHelper devServerHelper = DevServerHelper.this;
            Map mapB = AndroidInfoHelpers.b(devServerHelper.f18802f);
            Locale locale = Locale.US;
            String strA = devServerHelper.f18798b.a();
            String strEncode = Uri.encode(AndroidInfoHelpers.a());
            String str = devServerHelper.f18803g;
            String strEncode2 = Uri.encode(str);
            String strEncode3 = Uri.encode(devServerHelper.c());
            boolean isProfilingBuild = InspectorFlags.getIsProfilingBuild();
            StringBuilder sbV = androidx.fragment.app.e.v("http://", strA, "/inspector/device?name=", strEncode, "&app=");
            android.support.v4.media.b.B(sbV, strEncode2, "&device=", strEncode3, "&profiling=");
            sbV.append(isProfilingBuild);
            CxxInspectorPackagerConnection cxxInspectorPackagerConnection = new CxxInspectorPackagerConnection(sbV.toString(), (String) mapB.get("deviceName"), str);
            devServerHelper.f18805i = cxxInspectorPackagerConnection;
            cxxInspectorPackagerConnection.connect();
            return null;
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevServerHelper$4, reason: invalid class name */
    class AnonymousClass4 extends AsyncTask<Void, Void, Void> {
        public AnonymousClass4() {
        }

        @Override // android.os.AsyncTask
        public final Void doInBackground(Void[] voidArr) {
            DevServerHelper devServerHelper = DevServerHelper.this;
            CxxInspectorPackagerConnection cxxInspectorPackagerConnection = devServerHelper.f18805i;
            if (cxxInspectorPackagerConnection != null) {
                cxxInspectorPackagerConnection.closeQuietly();
                devServerHelper.f18805i = null;
            }
            return null;
        }
    }

    /* renamed from: com.facebook.react.devsupport.DevServerHelper$5, reason: invalid class name */
    class AnonymousClass5 implements Callback {
        @Override // okhttp3.Callback
        public final void onFailure(Call call, IOException iOException) {
        }

        @Override // okhttp3.Callback
        public final void onResponse(Call call, Response response) {
        }
    }

    public enum BundleType {
        /* JADX INFO: Fake field, exist only in values array */
        BUNDLE("bundle"),
        /* JADX INFO: Fake field, exist only in values array */
        MAP("map");

        BundleType(String str) {
        }
    }

    public interface PackagerCommandListener {
    }

    public DevServerHelper(DevInternalSettings devInternalSettings, Context context, PackagerConnectionSettings packagerConnectionSettings) {
        this.f18797a = devInternalSettings;
        this.f18798b = packagerConnectionSettings;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.b(5000L, timeUnit);
        builder.c(0L, timeUnit);
        builder.d(0L, timeUnit);
        OkHttpClient okHttpClient = new OkHttpClient(builder);
        this.f18799c = okHttpClient;
        this.f18800d = new BundleDownloader(okHttpClient);
        this.f18801e = new PackagerStatusCheck(okHttpClient);
        this.f18802f = context;
        this.f18803g = context.getPackageName();
    }

    public final String a(String str, String str2, boolean z, boolean z2) {
        DevInternalSettings devInternalSettings = this.f18797a;
        boolean zD = devInternalSettings.d();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : this.f18798b.f19211d.entrySet()) {
            if (((String) entry.getValue()).length() != 0) {
                sb.append("&" + ((String) entry.getKey()) + "=" + Uri.encode((String) entry.getValue()));
            }
        }
        StringBuilder sb2 = new StringBuilder();
        Locale locale = Locale.US;
        boolean z3 = devInternalSettings.f18795b.getBoolean("js_minify_debug", false);
        String str3 = z ? "true" : "false";
        String str4 = z2 ? "true" : "false";
        StringBuilder sbV = androidx.fragment.app.e.v("http://", str2, "/", str, ".bundle?platform=android&dev=");
        sbV.append(zD);
        sbV.append("&lazy=");
        sbV.append(zD);
        sbV.append("&minify=");
        sbV.append(z3);
        sbV.append("&app=");
        android.support.v4.media.b.B(sbV, this.f18803g, "&modulesOnly=", str3, "&runModule=");
        sbV.append(str4);
        sb2.append(sbV.toString());
        sb2.append(InspectorFlags.getFuseboxEnabled() ? "&excludeSource=true&sourcePaths=url-server" : "");
        sb2.append(sb.toString());
        return sb2.toString();
    }

    public final String b(String str) {
        return a(str, this.f18798b.a(), false, true);
    }

    public final String c() throws NoSuchAlgorithmException {
        String string = Settings.Secure.getString(this.f18802f.getContentResolver(), "android_id");
        Locale locale = Locale.US;
        String str = InspectorFlags.getFuseboxEnabled() ? "fusebox" : "legacy";
        StringBuilder sb = new StringBuilder("android-");
        android.support.v4.media.b.B(sb, this.f18803g, "-", string, "-");
        sb.append(str);
        String string2 = sb.toString();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.reset();
            try {
                byte[] bArrDigest = messageDigest.digest(string2.getBytes("UTF-8"));
                return String.format("%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x%02x", Byte.valueOf(bArrDigest[0]), Byte.valueOf(bArrDigest[1]), Byte.valueOf(bArrDigest[2]), Byte.valueOf(bArrDigest[3]), Byte.valueOf(bArrDigest[4]), Byte.valueOf(bArrDigest[5]), Byte.valueOf(bArrDigest[6]), Byte.valueOf(bArrDigest[7]), Byte.valueOf(bArrDigest[8]), Byte.valueOf(bArrDigest[9]), Byte.valueOf(bArrDigest[10]), Byte.valueOf(bArrDigest[11]), Byte.valueOf(bArrDigest[12]), Byte.valueOf(bArrDigest[13]), Byte.valueOf(bArrDigest[14]), Byte.valueOf(bArrDigest[15]), Byte.valueOf(bArrDigest[16]), Byte.valueOf(bArrDigest[17]), Byte.valueOf(bArrDigest[18]), Byte.valueOf(bArrDigest[19]));
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError("This environment doesn't support UTF-8 encoding", e2);
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError("Could not get standard SHA-256 algorithm", e3);
        }
    }

    public final void d() {
        Request.Builder builder = new Request.Builder();
        Locale locale = Locale.US;
        builder.i("http://" + this.f18798b.a() + "/launch-js-devtools");
        this.f18799c.a(builder.b()).l0(new AnonymousClass5());
    }
}
