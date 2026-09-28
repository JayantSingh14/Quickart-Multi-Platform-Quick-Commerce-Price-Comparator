package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes5.dex */
public class c extends Exception {

    /* renamed from: a, reason: collision with root package name */
    String f57505a;

    /* renamed from: b, reason: collision with root package name */
    private String f57506b;

    /* renamed from: c, reason: collision with root package name */
    private String f57507c;

    /* renamed from: d, reason: collision with root package name */
    private Context f57508d;

    public c(Context context, String str, String str2) throws IOException {
        this.f57505a = "CLException";
        this.f57506b = str;
        this.f57507c = str2;
        this.f57508d = context;
        a(context, str2);
    }

    public String a() {
        return this.f57506b;
    }

    public String b() {
        return this.f57507c;
    }

    public c(Context context, String str, String str2, Throwable th) throws IOException {
        super(th);
        this.f57505a = "CLException";
        this.f57506b = str;
        this.f57507c = str2;
        this.f57508d = context;
        a(context, str2);
    }

    public void a(Context context, String str) throws IOException {
        InputStream inputStreamOpen;
        Properties properties = new Properties();
        try {
            inputStreamOpen = context.getAssets().open(CLConstants.PROPERTIES_FILE_NEME);
        } catch (IOException e2) {
            Log.e(this.f57505a, e2.getLocalizedMessage());
            inputStreamOpen = null;
        }
        try {
            properties.load(inputStreamOpen);
        } catch (IOException e3) {
            Log.e(this.f57505a, e3.getLocalizedMessage());
        }
        this.f57507c = properties.getProperty(str);
        Log.e(this.f57505a, "ErrorMsg: " + this.f57507c);
    }
}
