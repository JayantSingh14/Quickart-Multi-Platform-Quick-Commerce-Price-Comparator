package com.amazon.identity.auth.device.appid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.media.b;
import com.amazon.identity.auth.device.utils.PackageSignatureUtil;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class AppIdentifier {

    public static class a {
        /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static com.amazon.identity.auth.device.dataobject.AppInfo a(org.json.JSONObject r13) throws org.json.JSONException, com.amazon.identity.auth.device.AuthError {
            /*
                Method dump skipped, instructions count: 242
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazon.identity.auth.device.appid.AppIdentifier.a.a(org.json.JSONObject):com.amazon.identity.auth.device.dataobject.AppInfo");
        }

        public static void b(int i2, Context context, String str, String str2) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo;
            if (str == null) {
                throw new SecurityException(b.C("Decoding failed: certificate fingerprint can't be verified! pkg=", str2));
            }
            String strReplace = str.replace(":", "");
            ArrayList arrayList = new ArrayList();
            PackageManager packageManager = context.getPackageManager();
            Signature[] signatureArr = null;
            if (packageManager != null) {
                try {
                    packageInfo = packageManager.getPackageInfo(str2, 64);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    signatureArr = packageInfo.signatures;
                }
            }
            if (signatureArr != null) {
                for (Signature signature : signatureArr) {
                    try {
                        arrayList.add(PackageSignatureUtil.a(signature, i2).toLowerCase(Locale.US));
                    } catch (Exception unused2) {
                    }
                }
            }
            arrayList.size();
            arrayList.toString();
            if (!arrayList.contains(strReplace.toLowerCase(Locale.US))) {
                throw new SecurityException(b.C("Decoding failed: certificate fingerprint can't be verified! pkg=", str2));
            }
        }

        public static void c(Context context, String str, JSONObject jSONObject) throws PackageManager.NameNotFoundException {
            if (!jSONObject.getString("iss").equals("Amazon")) {
                throw new SecurityException("Decoding fails: issuer (" + jSONObject.getString("iss") + ") is not = Amazon pkg=" + str);
            }
            if (str != null && !str.equals(jSONObject.getString("pkg"))) {
                StringBuilder sbY = b.y("Decoding fails: package names don't match! - ", str, " != ");
                sbY.append(jSONObject.getString("pkg"));
                throw new SecurityException(sbY.toString());
            }
            if (jSONObject.has("appsig")) {
                b(1, context, jSONObject.getString("appsig"), str);
            }
            if (jSONObject.has("appsigSha256")) {
                b(2, context, jSONObject.getString("appsigSha256"), str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.amazon.identity.auth.device.dataobject.AppInfo a(android.content.Context r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.identity.auth.device.appid.AppIdentifier.a(android.content.Context, java.lang.String):com.amazon.identity.auth.device.dataobject.AppInfo");
    }
}
