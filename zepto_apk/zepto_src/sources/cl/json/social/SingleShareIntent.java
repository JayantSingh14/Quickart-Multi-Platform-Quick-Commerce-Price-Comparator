package cl.json.social;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.media.b;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes3.dex */
public abstract class SingleShareIntent extends ShareIntent {
    @Override // cl.json.social.ShareIntent
    public void f(ReadableMap readableMap) throws PackageManager.NameNotFoundException, IOException {
        String strD;
        System.out.println(c());
        if (c() != null || b() != null || d() != null) {
            try {
                this.f13831a.getPackageManager().getPackageInfo(c(), 1);
                System.out.println("INSTALLED");
                if (a() != null) {
                    this.f13832b.setComponent(new ComponentName(c(), a()));
                } else {
                    this.f13832b.setPackage(c());
                }
                super.f(readableMap);
                return;
            } catch (PackageManager.NameNotFoundException unused) {
                System.out.println("NOT INSTALLED");
                if (b() != null) {
                    String strB = b();
                    String string = readableMap.getString("url");
                    try {
                        String strReplace = strB.replace("{url}", URLEncoder.encode(string, "UTF-8"));
                        String string2 = readableMap.getString(APayConstants.Error.MESSAGE);
                        try {
                            strD = strReplace.replace("{message}", URLEncoder.encode(string2, "UTF-8"));
                        } catch (UnsupportedEncodingException unused2) {
                            throw new RuntimeException(b.C("URLEncoder.encode() failed for ", string2));
                        }
                    } catch (UnsupportedEncodingException unused3) {
                        throw new RuntimeException(b.C("URLEncoder.encode() failed for ", string));
                    }
                } else {
                    strD = d() != null ? d() : "";
                }
                this.f13832b = new Intent(new Intent("android.intent.action.VIEW", Uri.parse(strD)));
            }
        }
        super.f(readableMap);
    }

    public final void g(ReadableMap readableMap) {
        boolean zHasKey = this.f13835e.hasKey("forceDialog");
        ReactApplicationContext reactApplicationContext = this.f13831a;
        if (!zHasKey || !this.f13835e.getBoolean("forceDialog")) {
            this.f13832b.addFlags(268435456);
            reactApplicationContext.startActivity(this.f13832b);
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putBoolean(APayConstants.SUCCESS, true);
            writableMapCreateMap.putString(APayConstants.Error.MESSAGE, this.f13832b.getPackage());
            TargetChosenReceiver.b(writableMapCreateMap);
            return;
        }
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            TargetChosenReceiver.a("Something went wrong");
            return;
        }
        if (readableMap != null && !ShareIntent.e(readableMap, "social")) {
            throw new IllegalArgumentException("social is empty");
        }
        Intent intentCreateChooser = Intent.createChooser(this.f13832b, this.f13833c, TargetChosenReceiver.c(reactApplicationContext));
        intentCreateChooser.addFlags(1073741824);
        currentActivity.startActivityForResult(intentCreateChooser, 16845);
    }
}
