package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.fragment.app.e;
import java.io.File;
import java.io.UnsupportedEncodingException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Deprecated
/* loaded from: classes4.dex */
public class InstanceIDListenerService extends zze {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f22553f = 0;

    @Override // com.google.android.gms.iid.zze
    public final void a(Intent intent) {
        String string;
        InstanceID instanceID;
        String string2;
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(CLConstants.FIELD_SUBTYPE);
            Bundle bundleI = stringExtra != null ? e.i(CLConstants.FIELD_SUBTYPE, stringExtra) : null;
            zzaj zzajVar = InstanceID.f22549b;
            synchronized (InstanceID.class) {
                if (bundleI == null) {
                    string = "";
                } else {
                    try {
                        string = bundleI.getString(CLConstants.FIELD_SUBTYPE);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (string == null) {
                    string = "";
                }
                Context applicationContext = getApplicationContext();
                if (InstanceID.f22551d == null) {
                    String packageName = applicationContext.getPackageName();
                    StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 73);
                    sb.append("Instance ID SDK is deprecated, ");
                    sb.append(packageName);
                    sb.append(" should update to use Firebase Instance ID");
                    Log.w("InstanceID", sb.toString());
                    InstanceID.f22551d = new zzak(applicationContext);
                    new ArrayMap();
                }
                int i2 = 0;
                try {
                    i2 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException e2) {
                    String strValueOf = String.valueOf(e2);
                    StringBuilder sb2 = new StringBuilder(strValueOf.length() + 38);
                    sb2.append("Never happens: can't find own package ");
                    sb2.append(strValueOf);
                    Log.w("InstanceID", sb2.toString());
                }
                Integer.toString(i2);
                ArrayMap arrayMap = InstanceID.f22550c;
                instanceID = (InstanceID) arrayMap.get(string);
                if (instanceID == null) {
                    instanceID = new InstanceID();
                    instanceID.f22552a = "";
                    applicationContext.getApplicationContext();
                    instanceID.f22552a = string;
                    arrayMap.put(string, instanceID);
                }
            }
            String stringExtra2 = intent.getStringExtra("CMD");
            if (Log.isLoggable("InstanceID", 3)) {
                StringBuilder sb3 = new StringBuilder(e.g(e.g(34, stringExtra), stringExtra2));
                sb3.append("Service command. subtype:");
                sb3.append(stringExtra);
                sb3.append(" command:");
                sb3.append(stringExtra2);
                Log.d("InstanceID", sb3.toString());
            }
            if (!"RST".equals(stringExtra2)) {
                if ("RST_FULL".equals(stringExtra2)) {
                    if (InstanceID.f22551d.f22557a.getAll().isEmpty()) {
                        return;
                    }
                    InstanceID.f22551d.b();
                    return;
                } else {
                    if ("SYNC".equals(stringExtra2)) {
                        zzak zzakVar = InstanceID.f22551d;
                        zzakVar.a(String.valueOf(stringExtra).concat("|T|"));
                        zzakVar.a(String.valueOf(stringExtra).concat("|T-timestamp|"));
                        return;
                    }
                    return;
                }
            }
            zzak zzakVar2 = InstanceID.f22551d;
            String str = instanceID.f22552a;
            synchronized (zzakVar2) {
                zzakVar2.f22559c.remove(str);
            }
            Context context = zzakVar2.f22558b;
            if (TextUtils.isEmpty(str)) {
                string2 = "com.google.InstanceId.properties";
            } else {
                try {
                    String strEncodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                    StringBuilder sb4 = new StringBuilder(String.valueOf(strEncodeToString).length() + 33);
                    sb4.append("com.google.InstanceId_");
                    sb4.append(strEncodeToString);
                    sb4.append(".properties");
                    string2 = sb4.toString();
                } catch (UnsupportedEncodingException e3) {
                    throw new AssertionError(e3);
                }
            }
            File noBackupFilesDir = context.getNoBackupFilesDir();
            if (noBackupFilesDir == null || !noBackupFilesDir.isDirectory()) {
                Log.w("InstanceID", "noBackupFilesDir doesn't exist, using regular files directory instead");
                noBackupFilesDir = context.getFilesDir();
            }
            File file = new File(noBackupFilesDir, string2);
            if (file.exists()) {
                file.delete();
            }
            zzakVar2.a(String.valueOf(str).concat(CLConstants.SALT_DELIMETER));
        }
    }
}
