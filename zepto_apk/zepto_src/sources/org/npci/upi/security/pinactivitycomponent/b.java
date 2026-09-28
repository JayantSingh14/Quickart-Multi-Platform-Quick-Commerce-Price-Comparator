package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.os.ResultReceiver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public l f57494a;

    /* renamed from: c, reason: collision with root package name */
    private Context f57496c;

    /* renamed from: g, reason: collision with root package name */
    private x f57500g;

    /* renamed from: h, reason: collision with root package name */
    private i f57501h;

    /* renamed from: i, reason: collision with root package name */
    private Locale f57502i;

    /* renamed from: j, reason: collision with root package name */
    private in.org.npci.commonlibrary.b f57503j;

    /* renamed from: k, reason: collision with root package name */
    private g f57504k;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Properties> f57495b = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Properties f57499f = a(CLConstants.CL_PROPERTIES);

    /* renamed from: d, reason: collision with root package name */
    private Properties f57497d = a(CLConstants.VALIDATION_PROPERTIES);

    /* renamed from: e, reason: collision with root package name */
    private Properties f57498e = a(CLConstants.VERSION_PROPERTIES);

    public b(Context context, l lVar) {
        this.f57494a = lVar;
        this.f57502i = lVar.b();
        this.f57496c = context;
        this.f57503j = lVar.c();
        Locale locale = this.f57502i;
        if (locale != null) {
            this.f57495b.put(locale.getLanguage(), a("cl-messages_" + this.f57502i.getLanguage() + ".properties"));
        } else {
            Locale locale2 = new Locale(CLConstants.DEFAULT_LANGUAGE_PREFERENCE);
            this.f57495b.put(locale2.getLanguage(), a("cl-messages_" + locale2.getLanguage() + ".properties"));
        }
        this.f57504k = lVar.d();
        this.f57500g = new x(this);
        if (lVar.c() == null || lVar.a() == null) {
            return;
        }
        this.f57501h = new i(this.f57503j, this.f57504k, lVar.a());
    }

    public Properties a(String str) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(this.f57496c.getAssets().open(str));
            return properties;
        } catch (IOException e2) {
            q.a("AssetsPropertyReader", e2.toString());
            return properties;
        }
    }

    public String b(String str) {
        Properties properties = this.f57498e;
        if (properties != null) {
            return properties.getProperty(str);
        }
        return null;
    }

    public ResultReceiver c() {
        l lVar = this.f57494a;
        if (lVar == null) {
            return null;
        }
        return lVar.e();
    }

    public x a() {
        return this.f57500g;
    }

    public i b() {
        l lVar;
        if (this.f57501h == null && (lVar = this.f57494a) != null) {
            this.f57503j = lVar.c();
            this.f57501h = new i(this.f57494a.c(), this.f57494a.d(), this.f57494a.a());
        }
        q.b("Common Library", "get Encryptor");
        q.b("Common Library", "Input Analyzer :" + this.f57494a);
        return this.f57501h;
    }
}
