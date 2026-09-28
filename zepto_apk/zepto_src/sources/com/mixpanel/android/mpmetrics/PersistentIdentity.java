package com.mixpanel.android.mpmetrics;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import com.mixpanel.android.util.MPLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"CommitPrefEdits"})
/* loaded from: classes.dex */
class PersistentIdentity {
    public static Integer p = null;
    public static Boolean q = null;
    public static boolean r = true;
    public static final Object s = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final FutureTask f46062a;

    /* renamed from: b, reason: collision with root package name */
    public final FutureTask f46063b;

    /* renamed from: c, reason: collision with root package name */
    public final FutureTask f46064c;

    /* renamed from: d, reason: collision with root package name */
    public final FutureTask f46065d;

    /* renamed from: j, reason: collision with root package name */
    public String f46071j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f46072k;

    /* renamed from: l, reason: collision with root package name */
    public String f46073l;

    /* renamed from: m, reason: collision with root package name */
    public String f46074m;
    public boolean n;
    public Boolean o;

    /* renamed from: g, reason: collision with root package name */
    public final Object f46068g = new Object();

    /* renamed from: f, reason: collision with root package name */
    public JSONObject f46067f = null;

    /* renamed from: h, reason: collision with root package name */
    public HashMap f46069h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f46070i = false;

    /* renamed from: e, reason: collision with root package name */
    public final SharedPreferences.OnSharedPreferenceChangeListener f46066e = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.mixpanel.android.mpmetrics.PersistentIdentity.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            synchronized (PersistentIdentity.s) {
                PersistentIdentity.this.g();
                PersistentIdentity.r = false;
            }
        }
    };

    public PersistentIdentity(FutureTask futureTask, FutureTask futureTask2, FutureTask futureTask3, FutureTask futureTask4) {
        this.f46063b = futureTask;
        this.f46062a = futureTask2;
        this.f46064c = futureTask3;
        this.f46065d = futureTask4;
    }

    public final void a(JSONObject jSONObject) {
        synchronized (this.f46068g) {
            if (this.f46067f == null) {
                h();
            }
            JSONObject jSONObject2 = this.f46067f;
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObject.put(next, jSONObject2.get(next));
                } catch (JSONException e2) {
                    MPLog.c("MixpanelAPI.PIdentity", "Object read from one JSON Object cannot be written to another", e2);
                }
            }
        }
    }

    public final synchronized void b() {
        try {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f46062a.get()).edit();
            editorEdit.clear();
            editorEdit.apply();
            h();
            e();
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2.getCause());
        } catch (ExecutionException e3) {
            throw new RuntimeException(e3.getCause());
        }
    }

    public final synchronized String c() {
        try {
            if (!this.f46070i) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f46071j;
    }

    public final synchronized String d() {
        try {
            if (!this.f46070i) {
                e();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f46073l;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r4 = this;
            java.lang.String r0 = "Cannot read distinct ids from sharedPreferences."
            java.lang.String r1 = "MixpanelAPI.PIdentity"
            r2 = 0
            java.util.concurrent.FutureTask r3 = r4.f46062a     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L10
            java.lang.Object r3 = r3.get()     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L10
            android.content.SharedPreferences r3 = (android.content.SharedPreferences) r3     // Catch: java.lang.InterruptedException -> Le java.util.concurrent.ExecutionException -> L10
            goto L1e
        Le:
            r3 = move-exception
            goto L12
        L10:
            r3 = move-exception
            goto L16
        L12:
            com.mixpanel.android.util.MPLog.c(r1, r0, r3)
            goto L1d
        L16:
            java.lang.Throwable r3 = r3.getCause()
            com.mixpanel.android.util.MPLog.c(r1, r0, r3)
        L1d:
            r3 = r2
        L1e:
            if (r3 != 0) goto L21
            return
        L21:
            java.lang.String r0 = "events_distinct_id"
            java.lang.String r0 = r3.getString(r0, r2)
            r4.f46071j = r0
            java.lang.String r0 = "events_user_id_present"
            r1 = 0
            boolean r0 = r3.getBoolean(r0, r1)
            r4.f46072k = r0
            java.lang.String r0 = "people_distinct_id"
            java.lang.String r0 = r3.getString(r0, r2)
            r4.f46073l = r0
            java.lang.String r0 = "anonymous_id"
            java.lang.String r0 = r3.getString(r0, r2)
            r4.f46074m = r0
            java.lang.String r0 = "had_persisted_distinct_id"
            boolean r0 = r3.getBoolean(r0, r1)
            r4.n = r0
            java.lang.String r0 = r4.f46071j
            if (r0 != 0) goto L5f
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            r4.f46074m = r0
            r4.f46071j = r0
            r4.f46072k = r1
            r4.l()
        L5f:
            r0 = 1
            r4.f46070i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.PersistentIdentity.e():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "Cannot read opt out flag from sharedPreferences."
            java.lang.String r1 = "MixpanelAPI.PIdentity"
            java.util.concurrent.FutureTask r2 = r3.f46065d     // Catch: java.lang.InterruptedException -> Ld java.util.concurrent.ExecutionException -> Lf
            java.lang.Object r2 = r2.get()     // Catch: java.lang.InterruptedException -> Ld java.util.concurrent.ExecutionException -> Lf
            android.content.SharedPreferences r2 = (android.content.SharedPreferences) r2     // Catch: java.lang.InterruptedException -> Ld java.util.concurrent.ExecutionException -> Lf
            goto L1d
        Ld:
            r2 = move-exception
            goto L11
        Lf:
            r2 = move-exception
            goto L15
        L11:
            com.mixpanel.android.util.MPLog.c(r1, r0, r2)
            goto L1c
        L15:
            java.lang.Throwable r2 = r2.getCause()
            com.mixpanel.android.util.MPLog.c(r1, r0, r2)
        L1c:
            r2 = 0
        L1d:
            if (r2 != 0) goto L20
            return
        L20:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "opt_out_"
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r0 = 0
            boolean r4 = r2.getBoolean(r4, r0)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            r3.o = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.PersistentIdentity.f(java.lang.String):void");
    }

    public final void g() {
        this.f46069h = new HashMap();
        try {
            SharedPreferences sharedPreferences = (SharedPreferences) this.f46063b.get();
            SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.f46066e;
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                this.f46069h.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (InterruptedException e2) {
            MPLog.c("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e2);
        } catch (ExecutionException e3) {
            MPLog.c("MixpanelAPI.PIdentity", "Cannot load referrer properties from shared preferences.", e3.getCause());
        }
    }

    public final void h() {
        JSONObject jSONObject;
        try {
            try {
                String string = ((SharedPreferences) this.f46062a.get()).getString("super_properties", "{}");
                MPLog.e("MixpanelAPI.PIdentity", "Loading Super Properties " + string);
                this.f46067f = new JSONObject(string);
            } catch (InterruptedException e2) {
                MPLog.c("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e2);
                if (this.f46067f == null) {
                    jSONObject = new JSONObject();
                    this.f46067f = jSONObject;
                }
            } catch (ExecutionException e3) {
                MPLog.c("MixpanelAPI.PIdentity", "Cannot load superProperties from SharedPreferences.", e3.getCause());
                if (this.f46067f == null) {
                    jSONObject = new JSONObject();
                    this.f46067f = jSONObject;
                }
            } catch (JSONException unused) {
                MPLog.b("MixpanelAPI.PIdentity", "Cannot parse stored superProperties");
                k();
                if (this.f46067f == null) {
                    jSONObject = new JSONObject();
                    this.f46067f = jSONObject;
                }
            }
        } catch (Throwable th) {
            if (this.f46067f == null) {
                this.f46067f = new JSONObject();
            }
            throw th;
        }
    }

    public final synchronized void i(String str) {
        try {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f46065d.get()).edit();
            editorEdit.putBoolean("has_launched_" + str, true);
            editorEdit.apply();
        } catch (InterruptedException e2) {
            MPLog.c("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e2);
        } catch (ExecutionException e3) {
            MPLog.c("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e3.getCause());
        }
    }

    public final synchronized void j(String str) {
        try {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f46065d.get()).edit();
            editorEdit.putBoolean(str, true);
            editorEdit.apply();
        } catch (InterruptedException e2) {
            MPLog.c("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel from shared preferences.", e2);
        } catch (ExecutionException e3) {
            MPLog.c("MixpanelAPI.PIdentity", "Couldn't write internal Mixpanel shared preferences.", e3.getCause());
        }
    }

    public final void k() {
        JSONObject jSONObject = this.f46067f;
        if (jSONObject == null) {
            MPLog.b("MixpanelAPI.PIdentity", "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
            return;
        }
        String string = jSONObject.toString();
        MPLog.e("MixpanelAPI.PIdentity", "Storing Super Properties " + string);
        try {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f46062a.get()).edit();
            editorEdit.putString("super_properties", string);
            editorEdit.apply();
        } catch (InterruptedException e2) {
            MPLog.c("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e2);
        } catch (ExecutionException e3) {
            MPLog.c("MixpanelAPI.PIdentity", "Cannot store superProperties in shared preferences.", e3.getCause());
        }
    }

    public final void l() {
        try {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f46062a.get()).edit();
            editorEdit.putString("events_distinct_id", this.f46071j);
            editorEdit.putBoolean("events_user_id_present", this.f46072k);
            editorEdit.putString("people_distinct_id", this.f46073l);
            editorEdit.putString("anonymous_id", this.f46074m);
            editorEdit.putBoolean("had_persisted_distinct_id", this.n);
            editorEdit.apply();
        } catch (InterruptedException e2) {
            MPLog.c("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e2);
        } catch (ExecutionException e3) {
            MPLog.c("MixpanelAPI.PIdentity", "Can't write distinct ids to shared preferences.", e3.getCause());
        }
    }

    public final void m(String str) {
        try {
            SharedPreferences.Editor editorEdit = ((SharedPreferences) this.f46065d.get()).edit();
            editorEdit.putBoolean("opt_out_" + str, this.o.booleanValue());
            editorEdit.apply();
        } catch (InterruptedException e2) {
            MPLog.c("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", e2);
        } catch (ExecutionException e3) {
            MPLog.c("MixpanelAPI.PIdentity", "Can't write opt-out shared preferences.", e3.getCause());
        }
    }
}
