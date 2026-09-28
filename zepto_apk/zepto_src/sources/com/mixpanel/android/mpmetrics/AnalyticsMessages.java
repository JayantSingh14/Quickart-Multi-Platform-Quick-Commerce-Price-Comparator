package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.mixpanel.android.mpmetrics.MPDbAdapter;
import com.mixpanel.android.util.HttpService;
import com.mixpanel.android.util.MPLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class AnalyticsMessages {

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f45961d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Worker f45962a = new Worker();

    /* renamed from: b, reason: collision with root package name */
    public final Context f45963b;

    /* renamed from: c, reason: collision with root package name */
    public final MPConfig f45964c;

    public static class EventDescription extends MixpanelMessageDescription {

        /* renamed from: c, reason: collision with root package name */
        public final String f45965c;

        /* renamed from: d, reason: collision with root package name */
        public final JSONObject f45966d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f45967e;

        public EventDescription(String str, JSONObject jSONObject, String str2, boolean z, JSONObject jSONObject2) {
            super(str2, jSONObject);
            this.f45965c = str;
            this.f45967e = z;
            this.f45966d = jSONObject2;
        }
    }

    public static class FlushDescription extends MixpanelDescription {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f45968b;

        public FlushDescription(String str, boolean z) {
            super(str);
            this.f45968b = z;
        }
    }

    /* loaded from: classes4.dex */
    public static class GroupDescription extends MixpanelMessageDescription {
        public GroupDescription(String str, JSONObject jSONObject) {
            super(str, jSONObject);
        }

        public final String toString() {
            return this.f45970b.toString();
        }
    }

    public static class MixpanelDescription {

        /* renamed from: a, reason: collision with root package name */
        public final String f45969a;

        public MixpanelDescription(String str) {
            this.f45969a = str;
        }
    }

    public static class MixpanelMessageDescription extends MixpanelDescription {

        /* renamed from: b, reason: collision with root package name */
        public final JSONObject f45970b;

        public MixpanelMessageDescription(String str, JSONObject jSONObject) {
            super(str);
            if (jSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.get(next).toString();
                    } catch (AssertionError e2) {
                        jSONObject.remove(next);
                        MPLog.c("MixpanelAPI.Messages", "Removing people profile property from update (see https://github.com/mixpanel/mixpanel-android/issues/567)", e2);
                    } catch (JSONException unused) {
                    }
                }
            }
            this.f45970b = jSONObject;
        }
    }

    public static class PeopleDescription extends MixpanelMessageDescription {
        public final String toString() {
            return this.f45970b.toString();
        }
    }

    /* loaded from: classes4.dex */
    public static class PushAnonymousPeopleDescription extends MixpanelDescription {

        /* renamed from: b, reason: collision with root package name */
        public final String f45971b;

        public PushAnonymousPeopleDescription(String str, String str2) {
            super(str2);
            this.f45971b = str;
        }

        public final String a() {
            return this.f45971b;
        }

        public final String toString() {
            return this.f45971b;
        }
    }

    /* loaded from: classes4.dex */
    public static class UpdateEventsPropertiesDescription extends MixpanelDescription {
    }

    public class Worker {

        /* renamed from: b, reason: collision with root package name */
        public Handler f45973b;

        /* renamed from: f, reason: collision with root package name */
        public SystemInformation f45977f;

        /* renamed from: a, reason: collision with root package name */
        public final Object f45972a = new Object();

        /* renamed from: c, reason: collision with root package name */
        public long f45974c = 0;

        /* renamed from: d, reason: collision with root package name */
        public long f45975d = 0;

        /* renamed from: e, reason: collision with root package name */
        public long f45976e = -1;

        public class AnalyticsMessageHandler extends Handler {

            /* renamed from: a, reason: collision with root package name */
            public MPDbAdapter f45979a;

            /* renamed from: b, reason: collision with root package name */
            public final DecideChecker f45980b;

            /* renamed from: c, reason: collision with root package name */
            public final long f45981c;

            /* renamed from: d, reason: collision with root package name */
            public long f45982d;

            /* renamed from: e, reason: collision with root package name */
            public long f45983e;

            /* renamed from: f, reason: collision with root package name */
            public int f45984f;

            public AnalyticsMessageHandler(Looper looper) {
                super(looper);
                this.f45979a = null;
                Worker.this.f45977f = SystemInformation.a(AnalyticsMessages.this.f45963b);
                AnalyticsMessages analyticsMessages = AnalyticsMessages.this;
                this.f45980b = new DecideChecker(analyticsMessages.f45963b, analyticsMessages.f45964c);
                this.f45981c = analyticsMessages.f45964c.f45999b;
            }

            /* JADX WARN: Removed duplicated region for block: B:38:0x00f9  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final org.json.JSONObject a(com.mixpanel.android.mpmetrics.AnalyticsMessages.EventDescription r11) throws org.json.JSONException {
                /*
                    Method dump skipped, instructions count: 550
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.a(com.mixpanel.android.mpmetrics.AnalyticsMessages$EventDescription):org.json.JSONObject");
            }

            public final void b(MPDbAdapter mPDbAdapter, String str) throws Throwable {
                AnalyticsMessages.this.getClass();
                HttpService httpService = new HttpService();
                AnalyticsMessages analyticsMessages = AnalyticsMessages.this;
                Context context = analyticsMessages.f45963b;
                synchronized (analyticsMessages.f45964c) {
                }
                if (!httpService.b(context)) {
                    AnalyticsMessages.a(AnalyticsMessages.this, "Not flushing data to Mixpanel because the device is not connected to the internet.");
                    return;
                }
                c(mPDbAdapter, str, MPDbAdapter.Table.EVENTS, AnalyticsMessages.this.f45964c.f46006i);
                c(mPDbAdapter, str, MPDbAdapter.Table.PEOPLE, AnalyticsMessages.this.f45964c.f46007j);
                c(mPDbAdapter, str, MPDbAdapter.Table.GROUPS, AnalyticsMessages.this.f45964c.f46008k);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:119:0x02a3  */
            /* JADX WARN: Removed duplicated region for block: B:120:0x02ad  */
            /* JADX WARN: Removed duplicated region for block: B:145:0x02c0 A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:90:0x01ff  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void c(com.mixpanel.android.mpmetrics.MPDbAdapter r30, java.lang.String r31, com.mixpanel.android.mpmetrics.MPDbAdapter.Table r32, java.lang.String r33) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 780
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.c(com.mixpanel.android.mpmetrics.MPDbAdapter, java.lang.String, com.mixpanel.android.mpmetrics.MPDbAdapter$Table, java.lang.String):void");
            }

            /* JADX WARN: Removed duplicated region for block: B:135:0x02db A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
            @Override // android.os.Handler
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void handleMessage(android.os.Message r15) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 870
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.AnalyticsMessages.Worker.AnalyticsMessageHandler.handleMessage(android.os.Message):void");
            }
        }

        public Worker() {
            HandlerThread handlerThread = new HandlerThread("com.mixpanel.android.AnalyticsWorker", 10);
            handlerThread.start();
            this.f45973b = new AnalyticsMessageHandler(handlerThread.getLooper());
        }

        public static void a(Worker worker) {
            worker.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = worker.f45974c;
            long j3 = 1 + j2;
            long j4 = worker.f45976e;
            if (j4 > 0) {
                long j5 = ((worker.f45975d * j2) + (jCurrentTimeMillis - j4)) / j3;
                worker.f45975d = j5;
                AnalyticsMessages.a(AnalyticsMessages.this, "Average send frequency approximately " + (j5 / 1000) + " seconds.");
            }
            worker.f45976e = jCurrentTimeMillis;
            worker.f45974c = j3;
        }

        public final void b(Message message) {
            synchronized (this.f45972a) {
                try {
                    Handler handler = this.f45973b;
                    if (handler == null) {
                        AnalyticsMessages.a(AnalyticsMessages.this, "Dead mixpanel worker dropping a message: " + message.what);
                    } else {
                        handler.sendMessage(message);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public AnalyticsMessages(Context context) {
        this.f45963b = context;
        this.f45964c = MPConfig.b(context);
        new HttpService().a();
    }

    public static void a(AnalyticsMessages analyticsMessages, String str) {
        analyticsMessages.getClass();
        MPLog.e("MixpanelAPI.Messages", str + " (Thread " + Thread.currentThread().getId() + ")");
    }

    public static void b(AnalyticsMessages analyticsMessages, String str, Exception exc) {
        analyticsMessages.getClass();
        String str2 = str + " (Thread " + Thread.currentThread().getId() + ")";
        if (MPLog.d(2)) {
            Log.v("MixpanelAPI.Messages", str2, exc);
        }
    }

    public final void c(FlushDescription flushDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = flushDescription.f45969a;
        messageObtain.arg1 = flushDescription.f45968b ? 1 : 0;
        this.f45962a.b(messageObtain);
    }
}
