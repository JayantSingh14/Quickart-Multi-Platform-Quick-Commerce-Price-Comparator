package cl.json.social;

import android.content.pm.PackageManager;
import android.provider.Telephony;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import java.io.IOException;

/* loaded from: classes3.dex */
public class SMSShare extends SingleShareIntent {

    /* renamed from: f, reason: collision with root package name */
    public ReactApplicationContext f13830f;

    @Override // cl.json.social.ShareIntent
    public final String b() {
        return null;
    }

    @Override // cl.json.social.ShareIntent
    public final String c() {
        return Telephony.Sms.getDefaultSmsPackage(this.f13830f);
    }

    @Override // cl.json.social.ShareIntent
    public final String d() {
        return "market://details?id=com.android.mms";
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public final void f(ReadableMap readableMap) throws PackageManager.NameNotFoundException, IOException {
        super.f(readableMap);
        g(null);
    }
}
