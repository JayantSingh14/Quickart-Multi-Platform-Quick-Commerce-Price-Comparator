package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.media.b;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.mixpanel.android.mpmetrics.AnalyticsMessages;
import com.mixpanel.android.mpmetrics.SharedPreferencesLoader;
import com.mixpanel.android.util.MPLog;
import j$.util.DesugarTimeZone;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MixpanelAPI {

    /* renamed from: l, reason: collision with root package name */
    public static final HashMap f46030l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public static final SharedPreferencesLoader f46031m = new SharedPreferencesLoader();
    public static FutureTask n;

    /* renamed from: a, reason: collision with root package name */
    public final Context f46032a;

    /* renamed from: b, reason: collision with root package name */
    public final AnalyticsMessages f46033b;

    /* renamed from: c, reason: collision with root package name */
    public final MPConfig f46034c;

    /* renamed from: d, reason: collision with root package name */
    public final String f46035d;

    /* renamed from: e, reason: collision with root package name */
    public final PeopleImpl f46036e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f46037f;

    /* renamed from: g, reason: collision with root package name */
    public final PersistentIdentity f46038g;

    /* renamed from: h, reason: collision with root package name */
    public final DecideMessages f46039h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f46040i;

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f46041j;

    /* renamed from: k, reason: collision with root package name */
    public final SessionMetadata f46042k;

    /* renamed from: com.mixpanel.android.mpmetrics.MixpanelAPI$3, reason: invalid class name */
    class AnonymousClass3 implements SharedPreferencesLoader.OnPrefsLoadedListener {
        public AnonymousClass3() {
        }
    }

    /* loaded from: classes4.dex */
    public interface Group {
        void a(Object obj, String str);

        void b(JSONObject jSONObject);

        void c(String str);

        void d(String str, JSONArray jSONArray);

        void e(JSONObject jSONObject);

        void f();
    }

    /* loaded from: classes4.dex */
    public class GroupImpl implements Group {

        /* renamed from: a, reason: collision with root package name */
        public final String f46050a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f46051b;

        public GroupImpl(String str, Object obj) {
            this.f46050a = str;
            this.f46051b = obj;
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.Group
        public final void a(Object obj, String str) throws JSONException {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                MixpanelAPI.a(mixpanelAPI, i(jSONObject, "$remove"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception removing a property", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.Group
        public final void b(JSONObject jSONObject) {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                MixpanelAPI.a(mixpanelAPI, i(jSONObject, "$set_once"));
            } catch (JSONException unused) {
                MPLog.b("MixpanelAPI.API", "Exception setting group properties");
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.Group
        public final void c(String str) {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                MixpanelAPI.a(mixpanelAPI, i(jSONArray, "$unset"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception unsetting a property", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.Group
        public final void d(String str, JSONArray jSONArray) throws JSONException {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, jSONArray);
                MixpanelAPI.a(mixpanelAPI, i(jSONObject, "$union"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception unioning a property", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.Group
        public final void e(JSONObject jSONObject) throws JSONException {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                MixpanelAPI.a(mixpanelAPI, i(jSONObject2, "$set"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception setting group properties", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.Group
        public final void f() {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            try {
                MixpanelAPI.a(mixpanelAPI, i(JSONObject.NULL, "$delete"));
                mixpanelAPI.f46037f.remove(this.f46050a + '_' + this.f46051b);
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception deleting a group", e2);
            }
        }

        public final JSONObject i(Object obj, String str) throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, obj);
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            jSONObject.put("$token", mixpanelAPI.f46035d);
            jSONObject.put("$time", System.currentTimeMillis());
            jSONObject.put("$group_key", this.f46050a);
            jSONObject.put("$group_id", this.f46051b);
            jSONObject.put("$mp_metadata", mixpanelAPI.f46042k.a(false));
            return jSONObject;
        }
    }

    /* loaded from: classes4.dex */
    public interface InstanceProcessor {
        void a(MixpanelAPI mixpanelAPI);
    }

    public interface People {
        void a(Object obj, String str);

        void b(JSONObject jSONObject);

        void c(String str);

        void d(String str, JSONArray jSONArray);

        void e(JSONObject jSONObject);

        void f(HashMap map);

        void g(double d2, JSONObject jSONObject);

        void h();

        void i(String str);

        void j(Object obj, String str);

        void k();
    }

    public class PeopleImpl implements People {

        /* renamed from: com.mixpanel.android.mpmetrics.MixpanelAPI$PeopleImpl$1, reason: invalid class name */
        /* loaded from: classes4.dex */
        class AnonymousClass1 extends PeopleImpl {
            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl, com.mixpanel.android.mpmetrics.MixpanelAPI.People
            public final void i(String str) {
                throw null;
            }

            @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.PeopleImpl
            public final String l() {
                return null;
            }
        }

        public PeopleImpl() {
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void a(Object obj, String str) throws JSONException {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                MixpanelAPI.b(mixpanelAPI, m(jSONObject, "$remove"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception appending a property", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void b(JSONObject jSONObject) {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                MixpanelAPI.b(mixpanelAPI, m(jSONObject, "$set_once"));
            } catch (JSONException unused) {
                MPLog.b("MixpanelAPI.API", "Exception setting people properties");
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void c(String str) {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                MixpanelAPI.b(mixpanelAPI, m(jSONArray, "$unset"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception unsetting a property", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void d(String str, JSONArray jSONArray) throws JSONException {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, jSONArray);
                MixpanelAPI.b(mixpanelAPI, m(jSONObject, "$union"));
            } catch (JSONException unused) {
                MPLog.b("MixpanelAPI.API", "Exception unioning a property");
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void e(JSONObject jSONObject) throws JSONException {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(mixpanelAPI.f46040i);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                MixpanelAPI.b(mixpanelAPI, m(jSONObject2, "$set"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception setting people properties", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void f(HashMap map) {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                MixpanelAPI.b(mixpanelAPI, m(new JSONObject(map), "$add"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception incrementing properties", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void g(double d2, JSONObject jSONObject) throws JSONException {
            if (MixpanelAPI.this.n()) {
                return;
            }
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("$amount", d2);
                jSONObject2.put("$time", simpleDateFormat.format(date));
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                j(jSONObject2, "$transactions");
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception creating new charge", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void h() {
            c("$transactions");
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public void i(String str) {
            if (MixpanelAPI.this.n()) {
                return;
            }
            if (str == null) {
                MPLog.b("MixpanelAPI.API", "Can't identify with null distinct_id.");
                return;
            }
            synchronized (MixpanelAPI.this.f46038g) {
                PersistentIdentity persistentIdentity = MixpanelAPI.this.f46038g;
                synchronized (persistentIdentity) {
                    try {
                        if (!persistentIdentity.f46070i) {
                            persistentIdentity.e();
                        }
                        persistentIdentity.f46073l = str;
                        persistentIdentity.l();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                DecideMessages decideMessages = MixpanelAPI.this.f46039h;
                synchronized (decideMessages) {
                    decideMessages.f45991a = str;
                }
            }
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            AnalyticsMessages.PushAnonymousPeopleDescription pushAnonymousPeopleDescription = new AnalyticsMessages.PushAnonymousPeopleDescription(str, mixpanelAPI.f46035d);
            AnalyticsMessages analyticsMessages = mixpanelAPI.f46033b;
            analyticsMessages.getClass();
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = pushAnonymousPeopleDescription;
            analyticsMessages.f45962a.b(messageObtain);
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void j(Object obj, String str) throws JSONException {
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            if (mixpanelAPI.n()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, obj);
                MixpanelAPI.b(mixpanelAPI, m(jSONObject, "$append"));
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.API", "Exception appending a property", e2);
            }
        }

        @Override // com.mixpanel.android.mpmetrics.MixpanelAPI.People
        public final void k() {
            try {
                MixpanelAPI.b(MixpanelAPI.this, m(JSONObject.NULL, "$delete"));
            } catch (JSONException unused) {
                MPLog.b("MixpanelAPI.API", "Exception deleting a user");
            }
        }

        public String l() {
            return MixpanelAPI.this.f46038g.d();
        }

        public final JSONObject m(Object obj, String str) throws JSONException {
            String str2;
            boolean z;
            JSONObject jSONObject = new JSONObject();
            String strL = l();
            MixpanelAPI mixpanelAPI = MixpanelAPI.this;
            PersistentIdentity persistentIdentity = mixpanelAPI.f46038g;
            synchronized (persistentIdentity) {
                try {
                    if (!persistentIdentity.f46070i) {
                        persistentIdentity.e();
                    }
                    str2 = persistentIdentity.f46074m;
                } finally {
                }
            }
            jSONObject.put(str, obj);
            jSONObject.put("$token", mixpanelAPI.f46035d);
            jSONObject.put("$time", System.currentTimeMillis());
            PersistentIdentity persistentIdentity2 = mixpanelAPI.f46038g;
            synchronized (persistentIdentity2) {
                try {
                    if (!persistentIdentity2.f46070i) {
                        persistentIdentity2.e();
                    }
                    z = persistentIdentity2.n;
                } finally {
                }
            }
            jSONObject.put("$had_persisted_distinct_id", z);
            if (str2 != null) {
                jSONObject.put("$device_id", str2);
            }
            if (strL != null) {
                jSONObject.put("$distinct_id", strL);
                jSONObject.put("$user_id", strL);
            }
            jSONObject.put("$mp_metadata", mixpanelAPI.f46042k.a(false));
            return jSONObject;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0164 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0253 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MixpanelAPI(android.content.Context r10, java.util.concurrent.FutureTask r11, java.lang.String r12, boolean r13, org.json.JSONObject r14) throws org.json.JSONException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.MixpanelAPI.<init>(android.content.Context, java.util.concurrent.FutureTask, java.lang.String, boolean, org.json.JSONObject):void");
    }

    public static void a(MixpanelAPI mixpanelAPI, JSONObject jSONObject) {
        if (mixpanelAPI.n()) {
            return;
        }
        if (!jSONObject.has("$group_key") || !jSONObject.has("$group_id")) {
            MPLog.b("MixpanelAPI.API", "Attempt to update group without key and value--this should not happen.");
            return;
        }
        AnalyticsMessages.GroupDescription groupDescription = new AnalyticsMessages.GroupDescription(mixpanelAPI.f46035d, jSONObject);
        AnalyticsMessages analyticsMessages = mixpanelAPI.f46033b;
        analyticsMessages.getClass();
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = groupDescription;
        analyticsMessages.f45962a.b(messageObtain);
    }

    public static void b(MixpanelAPI mixpanelAPI, JSONObject jSONObject) {
        if (mixpanelAPI.n()) {
            return;
        }
        AnalyticsMessages.PeopleDescription peopleDescription = new AnalyticsMessages.PeopleDescription(mixpanelAPI.f46035d, jSONObject);
        AnalyticsMessages analyticsMessages = mixpanelAPI.f46033b;
        analyticsMessages.getClass();
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = peopleDescription;
        analyticsMessages.f45962a.b(messageObtain);
    }

    public static void e(InstanceProcessor instanceProcessor) {
        HashMap map = f46030l;
        synchronized (map) {
            try {
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((Map) it.next()).values().iterator();
                    while (it2.hasNext()) {
                        instanceProcessor.a((MixpanelAPI) it2.next());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void f(Context context) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (!(context instanceof Activity)) {
            MPLog.a("MixpanelAPI.AL", "Context is not an instance of Activity. To detect inbound App Links, pass an instance of an Activity to getInstance.");
            return;
        }
        try {
            Class.forName("bolts.AppLinks").getMethod("getTargetUrlFromInboundIntent", Context.class, Intent.class).invoke(null, context, ((Activity) context).getIntent());
        } catch (ClassNotFoundException e2) {
            MPLog.a("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + e2.getMessage());
        } catch (IllegalAccessException e3) {
            MPLog.a("MixpanelAPI.AL", "Unable to detect inbound App Links: " + e3.getMessage());
        } catch (NoSuchMethodException e4) {
            MPLog.a("MixpanelAPI.AL", "Please install the Bolts library >= 1.1.2 to track App Links: " + e4.getMessage());
        } catch (InvocationTargetException e5) {
            if (MPLog.d(3)) {
                Log.d("MixpanelAPI.AL", "Failed to invoke bolts.AppLinks.getTargetUrlFromInboundIntent() -- Unable to detect inbound App Links", e5);
            }
        }
    }

    public static MixpanelAPI l(Context context, String str, JSONObject jSONObject, boolean z) {
        MixpanelAPI mixpanelAPI;
        if (str == null || context == null) {
            return null;
        }
        HashMap map = f46030l;
        synchronized (map) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (n == null) {
                    n = f46031m.a(context, "com.mixpanel.android.mpmetrics.ReferralInfo", null);
                }
                Map map2 = (Map) map.get(str);
                if (map2 == null) {
                    map2 = new HashMap();
                    map.put(str, map2);
                }
                mixpanelAPI = (MixpanelAPI) map2.get(applicationContext);
                if (mixpanelAPI == null) {
                    PackageManager packageManager = applicationContext.getPackageManager();
                    String packageName = applicationContext.getPackageName();
                    if (packageManager == null || packageName == null) {
                        MPLog.f("MixpanelAPI.ConfigurationChecker", "Can't check configuration when using a Context with null packageManager or packageName");
                    } else if (packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
                        MPLog.f("MixpanelAPI.ConfigurationChecker", "Package does not have permission android.permission.INTERNET - Mixpanel will not work at all!");
                        if (MPLog.d(4)) {
                            Log.i("MixpanelAPI.ConfigurationChecker", "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
                        }
                    } else {
                        mixpanelAPI = new MixpanelAPI(applicationContext, n, str, z, jSONObject);
                        r(context, mixpanelAPI);
                        map2.put(applicationContext, mixpanelAPI);
                    }
                }
                f(context);
            } catch (Throwable th) {
                throw th;
            }
        }
        return mixpanelAPI;
    }

    public static void r(Context context, MixpanelAPI mixpanelAPI) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            LocalBroadcastManager.class.getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class).invoke(LocalBroadcastManager.class.getMethod("getInstance", Context.class).invoke(null, context), new BroadcastReceiver() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.4
                @Override // android.content.BroadcastReceiver
                public final void onReceive(Context context2, Intent intent) throws JSONException {
                    JSONObject jSONObject = new JSONObject();
                    Bundle bundleExtra = intent.getBundleExtra("event_args");
                    if (bundleExtra != null) {
                        for (String str : bundleExtra.keySet()) {
                            try {
                                jSONObject.put(str, bundleExtra.get(str));
                            } catch (JSONException e2) {
                                MPLog.c("MixpanelAPI.AL", "failed to add key \"" + str + "\" to properties for tracking bolts event", e2);
                            }
                        }
                    }
                    MixpanelAPI.this.y("$" + intent.getStringExtra("event_name"), jSONObject);
                }
            }, new IntentFilter("com.parse.bolts.measurement_event"));
        } catch (ClassNotFoundException e2) {
            MPLog.a("MixpanelAPI.AL", "To enable App Links tracking, add implementation 'androidx.localbroadcastmanager:localbroadcastmanager:1.0.0': " + e2.getMessage());
        } catch (IllegalAccessException e3) {
            MPLog.a("MixpanelAPI.AL", "App Links tracking will not be enabled due to this exception: " + e3.getMessage());
        } catch (NoSuchMethodException e4) {
            MPLog.a("MixpanelAPI.AL", "To enable App Links tracking, add implementation 'androidx.localbroadcastmanager:localbroadcastmanager:1.0.0': " + e4.getMessage());
        } catch (InvocationTargetException e5) {
            if (MPLog.d(3)) {
                Log.d("MixpanelAPI.AL", "Failed to invoke LocalBroadcastManager.registerReceiver() -- App Links tracking will not be enabled due to this exception", e5);
            }
        }
    }

    public final void A(String str) {
        if (n()) {
            return;
        }
        PersistentIdentity persistentIdentity = this.f46038g;
        synchronized (persistentIdentity.f46068g) {
            if (persistentIdentity.f46067f == null) {
                persistentIdentity.h();
            }
            persistentIdentity.f46067f.remove(str);
            persistentIdentity.k();
        }
    }

    public final void B(SuperPropertyUpdate superPropertyUpdate) {
        if (n()) {
            return;
        }
        PersistentIdentity persistentIdentity = this.f46038g;
        synchronized (persistentIdentity.f46068g) {
            if (persistentIdentity.f46067f == null) {
                persistentIdentity.h();
            }
            JSONObject jSONObject = persistentIdentity.f46067f;
            JSONObject jSONObject2 = new JSONObject();
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
                JSONObject jSONObjectA = superPropertyUpdate.a(jSONObject2);
                if (jSONObjectA == null) {
                    MPLog.f("MixpanelAPI.PIdentity", "An update to Mixpanel's super properties returned null, and will have no effect.");
                } else {
                    persistentIdentity.f46067f = jSONObjectA;
                    persistentIdentity.k();
                }
            } catch (JSONException e2) {
                MPLog.c("MixpanelAPI.PIdentity", "Can't copy from one JSONObject to another", e2);
            }
        }
    }

    public final void c(final Object obj, final String str) throws JSONException {
        if (n()) {
            return;
        }
        B(new SuperPropertyUpdate() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.1
            @Override // com.mixpanel.android.mpmetrics.SuperPropertyUpdate
            public final JSONObject a(JSONObject jSONObject) throws JSONException {
                try {
                    jSONObject.accumulate(str, obj);
                    return jSONObject;
                } catch (JSONException e2) {
                    MPLog.c("MixpanelAPI.API", "Failed to add groups superProperty", e2);
                    return jSONObject;
                }
            }
        });
        this.f46036e.d(str, new JSONArray().put(obj));
    }

    public final void d(String str, String str2) throws JSONException {
        if (n()) {
            return;
        }
        if (str2 == null) {
            str2 = this.f46038g.c();
        }
        if (str.equals(str2)) {
            MPLog.f("MixpanelAPI.API", "Attempted to alias identical distinct_ids " + str + ". Alias message will not be sent.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("alias", str);
            jSONObject.put("original", str2);
            y("$create_alias", jSONObject);
        } catch (JSONException e2) {
            MPLog.c("MixpanelAPI.API", "Failed to alias", e2);
        }
        h();
    }

    public final void g() {
        PersistentIdentity persistentIdentity = this.f46038g;
        synchronized (persistentIdentity.f46068g) {
            persistentIdentity.f46067f = new JSONObject();
            persistentIdentity.k();
        }
    }

    public final void h() {
        if (n()) {
            return;
        }
        this.f46033b.c(new AnalyticsMessages.FlushDescription(this.f46035d, true));
    }

    public final AnalyticsMessages i() {
        AnalyticsMessages analyticsMessages;
        Context context = this.f46032a;
        HashMap map = AnalyticsMessages.f45961d;
        synchronized (map) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (map.containsKey(applicationContext)) {
                    analyticsMessages = (AnalyticsMessages) map.get(applicationContext);
                } else {
                    analyticsMessages = new AnalyticsMessages(applicationContext);
                    map.put(applicationContext, analyticsMessages);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return analyticsMessages;
    }

    public final String j() {
        return this.f46038g.c();
    }

    public final Group k(Object obj, String str) {
        String str2 = str + '_' + obj;
        HashMap map = this.f46037f;
        GroupImpl groupImpl = (GroupImpl) map.get(str2);
        if (groupImpl == null) {
            groupImpl = new GroupImpl(str, obj);
            map.put(str2, groupImpl);
        }
        if (groupImpl.f46050a.equals(str) && groupImpl.f46051b.equals(obj)) {
            return groupImpl;
        }
        String strC = b.C("groups map key collision ", str2);
        if (MPLog.d(4)) {
            Log.i("MixpanelAPI.API", strC);
        }
        GroupImpl groupImpl2 = new GroupImpl(str, obj);
        map.put(str2, groupImpl2);
        return groupImpl2;
    }

    public final JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        this.f46038g.a(jSONObject);
        return jSONObject;
    }

    public final boolean n() {
        boolean zBooleanValue;
        PersistentIdentity persistentIdentity = this.f46038g;
        String str = this.f46035d;
        synchronized (persistentIdentity) {
            try {
                if (persistentIdentity.o == null) {
                    persistentIdentity.f(str);
                }
                zBooleanValue = persistentIdentity.o.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public final void o(String str, boolean z) {
        if (n()) {
            return;
        }
        if (str == null) {
            MPLog.b("MixpanelAPI.API", "Can't identify with null distinct_id.");
            return;
        }
        synchronized (this.f46038g) {
            try {
                String strC = this.f46038g.c();
                PersistentIdentity persistentIdentity = this.f46038g;
                synchronized (persistentIdentity) {
                    try {
                        if (!persistentIdentity.f46070i) {
                            persistentIdentity.e();
                        }
                        if (persistentIdentity.f46074m == null) {
                            persistentIdentity.f46074m = strC;
                            persistentIdentity.n = true;
                            persistentIdentity.l();
                        }
                    } finally {
                    }
                }
                PersistentIdentity persistentIdentity2 = this.f46038g;
                synchronized (persistentIdentity2) {
                    try {
                        if (!persistentIdentity2.f46070i) {
                            persistentIdentity2.e();
                        }
                        persistentIdentity2.f46071j = str;
                        persistentIdentity2.l();
                    } finally {
                    }
                }
                if (z) {
                    PersistentIdentity persistentIdentity3 = this.f46038g;
                    synchronized (persistentIdentity3) {
                        try {
                            if (!persistentIdentity3.f46070i) {
                                persistentIdentity3.e();
                            }
                            persistentIdentity3.f46072k = true;
                            persistentIdentity3.l();
                        } finally {
                        }
                    }
                }
                String strD = this.f46038g.d();
                if (strD == null) {
                    strD = this.f46038g.c();
                }
                DecideMessages decideMessages = this.f46039h;
                synchronized (decideMessages) {
                    decideMessages.f45991a = strD;
                }
                if (!str.equals(strC)) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("$anon_distinct_id", strC);
                        y("$identify", jSONObject);
                    } catch (JSONException unused) {
                        MPLog.b("MixpanelAPI.API", "Could not track $identify event");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void p() {
        String str = this.f46035d;
        PersistentIdentity persistentIdentity = this.f46038g;
        synchronized (persistentIdentity) {
            persistentIdentity.o = Boolean.FALSE;
            persistentIdentity.m(str);
        }
        y("$opt_in", null);
    }

    public final void q() {
        AnalyticsMessages analyticsMessagesI = i();
        AnalyticsMessages.MixpanelDescription mixpanelDescription = new AnalyticsMessages.MixpanelDescription(this.f46035d);
        analyticsMessagesI.getClass();
        Message messageObtain = Message.obtain();
        messageObtain.what = 6;
        messageObtain.obj = mixpanelDescription;
        analyticsMessagesI.f45962a.b(messageObtain);
        if (this.f46036e.l() != null) {
            this.f46036e.k();
            this.f46036e.h();
        }
        this.f46038g.b();
        synchronized (this.f46041j) {
            this.f46041j.clear();
            PersistentIdentity persistentIdentity = this.f46038g;
            persistentIdentity.getClass();
            try {
                SharedPreferences.Editor editorEdit = ((SharedPreferences) persistentIdentity.f46064c.get()).edit();
                editorEdit.clear();
                editorEdit.apply();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            } catch (ExecutionException e3) {
                e3.printStackTrace();
            }
        }
        PersistentIdentity persistentIdentity2 = this.f46038g;
        persistentIdentity2.getClass();
        synchronized (PersistentIdentity.s) {
            try {
                SharedPreferences.Editor editorEdit2 = ((SharedPreferences) persistentIdentity2.f46063b.get()).edit();
                editorEdit2.clear();
                editorEdit2.apply();
            } catch (InterruptedException e4) {
                MPLog.c("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e4);
            } catch (ExecutionException e5) {
                MPLog.c("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e5.getCause());
            }
        }
        PersistentIdentity persistentIdentity3 = this.f46038g;
        String str = this.f46035d;
        synchronized (persistentIdentity3) {
            persistentIdentity3.o = Boolean.TRUE;
            persistentIdentity3.m(str);
        }
    }

    public final void s(JSONObject jSONObject) {
        if (n()) {
            return;
        }
        PersistentIdentity persistentIdentity = this.f46038g;
        synchronized (persistentIdentity.f46068g) {
            if (persistentIdentity.f46067f == null) {
                persistentIdentity.h();
            }
            JSONObject jSONObject2 = persistentIdentity.f46067f;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObject2.put(next, jSONObject.get(next));
                } catch (JSONException e2) {
                    MPLog.c("MixpanelAPI.PIdentity", "Exception registering super property.", e2);
                }
            }
            persistentIdentity.k();
        }
    }

    public final void t(JSONObject jSONObject) {
        if (n()) {
            return;
        }
        PersistentIdentity persistentIdentity = this.f46038g;
        synchronized (persistentIdentity.f46068g) {
            if (persistentIdentity.f46067f == null) {
                persistentIdentity.h();
            }
            JSONObject jSONObject2 = persistentIdentity.f46067f;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!jSONObject2.has(next)) {
                    try {
                        jSONObject2.put(next, jSONObject.get(next));
                    } catch (JSONException e2) {
                        MPLog.c("MixpanelAPI.PIdentity", "Exception registering super property.", e2);
                    }
                }
            }
            persistentIdentity.k();
        }
    }

    public final void u(final Object obj, final String str) {
        if (n()) {
            return;
        }
        B(new SuperPropertyUpdate() { // from class: com.mixpanel.android.mpmetrics.MixpanelAPI.2
            @Override // com.mixpanel.android.mpmetrics.SuperPropertyUpdate
            public final JSONObject a(JSONObject jSONObject) throws JSONException {
                MixpanelAPI mixpanelAPI = MixpanelAPI.this;
                String str2 = str;
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(str2);
                    JSONArray jSONArray2 = new JSONArray();
                    if (jSONArray.length() <= 1) {
                        jSONObject.remove(str2);
                        mixpanelAPI.f46036e.c(str2);
                        return jSONObject;
                    }
                    int i2 = 0;
                    while (true) {
                        int length = jSONArray.length();
                        Object obj2 = obj;
                        if (i2 >= length) {
                            jSONObject.put(str2, jSONArray2);
                            mixpanelAPI.f46036e.a(obj2, str2);
                            return jSONObject;
                        }
                        if (!jSONArray.get(i2).equals(obj2)) {
                            jSONArray2.put(jSONArray.get(i2));
                        }
                        i2++;
                    }
                } catch (JSONException unused) {
                    jSONObject.remove(str2);
                    mixpanelAPI.f46036e.c(str2);
                    return jSONObject;
                }
            }
        });
    }

    public final void v() {
        PersistentIdentity persistentIdentity = this.f46038g;
        persistentIdentity.b();
        AnalyticsMessages analyticsMessagesI = i();
        AnalyticsMessages.MixpanelDescription mixpanelDescription = new AnalyticsMessages.MixpanelDescription(this.f46035d);
        analyticsMessagesI.getClass();
        Message messageObtain = Message.obtain();
        messageObtain.what = 7;
        messageObtain.obj = mixpanelDescription;
        analyticsMessagesI.f45962a.b(messageObtain);
        o(persistentIdentity.c(), false);
        h();
    }

    public final void w(String str, List list) {
        if (n()) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (Object obj : list) {
            if (obj == null) {
                MPLog.f("MixpanelAPI.API", "groupID must be non-null");
            } else {
                jSONArray.put(obj);
            }
        }
        try {
            s(new JSONObject().put(str, jSONArray));
            PeopleImpl peopleImpl = this.f46036e;
            if (!MixpanelAPI.this.n()) {
                try {
                    peopleImpl.e(new JSONObject().put(str, jSONArray));
                } catch (JSONException e2) {
                    MPLog.c("MixpanelAPI.API", "set", e2);
                }
            }
        } catch (JSONException unused) {
            MPLog.f("MixpanelAPI.API", "groupKey must be non-null");
        }
    }

    public final void x(String str) {
        if (n()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f46041j) {
            this.f46041j.put(str, Long.valueOf(jCurrentTimeMillis));
            PersistentIdentity persistentIdentity = this.f46038g;
            persistentIdentity.getClass();
            try {
                SharedPreferences.Editor editorEdit = ((SharedPreferences) persistentIdentity.f46064c.get()).edit();
                editorEdit.putLong(str, jCurrentTimeMillis);
                editorEdit.apply();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            } catch (ExecutionException e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void y(String str, JSONObject jSONObject) {
        if (n()) {
            return;
        }
        z(str, jSONObject, false);
    }

    public final void z(String str, JSONObject jSONObject, boolean z) {
        Long l2;
        String str2;
        String str3;
        boolean z2;
        if (n()) {
            return;
        }
        if (z) {
            Boolean bool = this.f46039h.f45993c;
            if (!(bool == null ? true : bool.booleanValue())) {
                return;
            }
        }
        synchronized (this.f46041j) {
            l2 = (Long) this.f46041j.get(str);
            this.f46041j.remove(str);
            PersistentIdentity persistentIdentity = this.f46038g;
            persistentIdentity.getClass();
            try {
                try {
                    SharedPreferences.Editor editorEdit = ((SharedPreferences) persistentIdentity.f46064c.get()).edit();
                    editorEdit.remove(str);
                    editorEdit.apply();
                } catch (ExecutionException e2) {
                    e2.printStackTrace();
                }
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            PersistentIdentity persistentIdentity2 = this.f46038g;
            persistentIdentity2.getClass();
            synchronized (PersistentIdentity.s) {
                try {
                    if (PersistentIdentity.r || persistentIdentity2.f46069h == null) {
                        persistentIdentity2.g();
                        PersistentIdentity.r = false;
                    }
                } finally {
                }
            }
            for (Map.Entry entry : persistentIdentity2.f46069h.entrySet()) {
                jSONObject2.put((String) entry.getKey(), (String) entry.getValue());
            }
            this.f46038g.a(jSONObject2);
            double dCurrentTimeMillis = System.currentTimeMillis() / 1000.0d;
            long j2 = (long) dCurrentTimeMillis;
            String strC = this.f46038g.c();
            PersistentIdentity persistentIdentity3 = this.f46038g;
            synchronized (persistentIdentity3) {
                try {
                    if (!persistentIdentity3.f46070i) {
                        persistentIdentity3.e();
                    }
                    str2 = persistentIdentity3.f46074m;
                } finally {
                }
            }
            PersistentIdentity persistentIdentity4 = this.f46038g;
            synchronized (persistentIdentity4) {
                try {
                    if (!persistentIdentity4.f46070i) {
                        persistentIdentity4.e();
                    }
                    str3 = persistentIdentity4.f46072k ? persistentIdentity4.f46071j : null;
                } finally {
                }
            }
            jSONObject2.put("time", j2);
            jSONObject2.put("distinct_id", strC);
            PersistentIdentity persistentIdentity5 = this.f46038g;
            synchronized (persistentIdentity5) {
                try {
                    if (!persistentIdentity5.f46070i) {
                        persistentIdentity5.e();
                    }
                    z2 = persistentIdentity5.n;
                } finally {
                }
            }
            jSONObject2.put("$had_persisted_distinct_id", z2);
            if (str2 != null) {
                jSONObject2.put("$device_id", str2);
            }
            if (str3 != null) {
                jSONObject2.put("$user_id", str3);
            }
            if (l2 != null) {
                jSONObject2.put("$duration", dCurrentTimeMillis - (l2.longValue() / 1000.0d));
            }
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
            AnalyticsMessages.EventDescription eventDescription = new AnalyticsMessages.EventDescription(str, jSONObject2, this.f46035d, z, this.f46042k.a(true));
            AnalyticsMessages analyticsMessages = this.f46033b;
            analyticsMessages.getClass();
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = eventDescription;
            analyticsMessages.f45962a.b(messageObtain);
        } catch (JSONException e4) {
            MPLog.c("MixpanelAPI.API", "Exception tracking event " + str, e4);
        }
    }
}
