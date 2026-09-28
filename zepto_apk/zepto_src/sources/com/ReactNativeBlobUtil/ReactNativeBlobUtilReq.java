package com.ReactNativeBlobUtil;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilReq extends BroadcastReceiver implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final ReactNativeBlobUtilConfig f13972a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13973b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13974c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13975d;

    /* renamed from: e, reason: collision with root package name */
    public final String f13976e;

    /* renamed from: f, reason: collision with root package name */
    public String f13977f;

    /* renamed from: g, reason: collision with root package name */
    public final ReadableArray f13978g;

    /* renamed from: h, reason: collision with root package name */
    public final ReadableMap f13979h;

    /* renamed from: i, reason: collision with root package name */
    public final Callback f13980i;

    /* renamed from: j, reason: collision with root package name */
    public long f13981j;

    /* renamed from: k, reason: collision with root package name */
    public ReactNativeBlobUtilBody f13982k;

    /* renamed from: l, reason: collision with root package name */
    public RequestType f13983l;

    /* renamed from: m, reason: collision with root package name */
    public final ResponseType f13984m;
    public WritableMap o;
    public final OkHttpClient r;
    public boolean s;
    public ScheduledFuture u;
    public static final HashMap w = new HashMap();
    public static final HashMap x = new HashMap();
    public static final HashMap y = new HashMap();
    public static final HashMap z = new HashMap();
    public static final ConnectionPool A = new ConnectionPool();
    public ResponseFormat n = ResponseFormat.f13996a;
    public boolean p = false;
    public final ArrayList q = new ArrayList();
    public final ScheduledExecutorService t = Executors.newScheduledThreadPool(1);
    public final Handler v = new Handler(new Handler.Callback() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.1
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            if (message.what == 1314) {
                long j2 = message.getData().getLong("downloadManagerId");
                ReactNativeBlobUtilReq reactNativeBlobUtilReq = ReactNativeBlobUtilReq.this;
                if (j2 == reactNativeBlobUtilReq.f13981j) {
                    DownloadManager downloadManager = (DownloadManager) ReactNativeBlobUtilImpl.f13918b.getApplicationContext().getSystemService("download");
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(reactNativeBlobUtilReq.f13981j);
                    Cursor cursorQuery = downloadManager.query(query);
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        long j3 = cursorQuery.getInt(cursorQuery.getColumnIndex("bytes_so_far"));
                        long j4 = cursorQuery.getLong(cursorQuery.getColumnIndex("total_size"));
                        cursorQuery.close();
                        String str = reactNativeBlobUtilReq.f13973b;
                        HashMap map = ReactNativeBlobUtilReq.y;
                        ReactNativeBlobUtilProgressConfig reactNativeBlobUtilProgressConfig = !map.containsKey(str) ? null : (ReactNativeBlobUtilProgressConfig) map.get(str);
                        float f2 = j4 > 0 ? j3 / j4 : 0.0f;
                        if (reactNativeBlobUtilProgressConfig != null && reactNativeBlobUtilProgressConfig.a(f2)) {
                            WritableMap writableMapCreateMap = Arguments.createMap();
                            writableMapCreateMap.putString("taskId", String.valueOf(reactNativeBlobUtilReq.f13973b));
                            writableMapCreateMap.putString("written", String.valueOf(j3));
                            writableMapCreateMap.putString("total", String.valueOf(j4));
                            writableMapCreateMap.putString("chunk", "");
                            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.f13918b.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ReactNativeBlobUtilProgress", writableMapCreateMap);
                        }
                        if (j4 == j3) {
                            reactNativeBlobUtilReq.u.cancel(true);
                        }
                    }
                }
            }
            return true;
        }
    });

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RequestType {

        /* renamed from: a, reason: collision with root package name */
        public static final RequestType f13991a;

        /* renamed from: b, reason: collision with root package name */
        public static final RequestType f13992b;

        /* renamed from: c, reason: collision with root package name */
        public static final RequestType f13993c;

        /* renamed from: d, reason: collision with root package name */
        public static final RequestType f13994d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ RequestType[] f13995e;

        static {
            RequestType requestType = new RequestType("Form", 0);
            f13991a = requestType;
            RequestType requestType2 = new RequestType("SingleFile", 1);
            f13992b = requestType2;
            RequestType requestType3 = new RequestType("AsIs", 2);
            f13993c = requestType3;
            RequestType requestType4 = new RequestType("WithoutBody", 3);
            f13994d = requestType4;
            f13995e = new RequestType[]{requestType, requestType2, requestType3, requestType4, new RequestType("Others", 4)};
        }

        public static RequestType valueOf(String str) {
            return (RequestType) Enum.valueOf(RequestType.class, str);
        }

        public static RequestType[] values() {
            return (RequestType[]) f13995e.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ResponseFormat {

        /* renamed from: a, reason: collision with root package name */
        public static final ResponseFormat f13996a;

        /* renamed from: b, reason: collision with root package name */
        public static final ResponseFormat f13997b;

        /* renamed from: c, reason: collision with root package name */
        public static final ResponseFormat f13998c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ ResponseFormat[] f13999d;

        static {
            ResponseFormat responseFormat = new ResponseFormat("Auto", 0);
            f13996a = responseFormat;
            ResponseFormat responseFormat2 = new ResponseFormat("UTF8", 1);
            f13997b = responseFormat2;
            ResponseFormat responseFormat3 = new ResponseFormat("BASE64", 2);
            f13998c = responseFormat3;
            f13999d = new ResponseFormat[]{responseFormat, responseFormat2, responseFormat3};
        }

        public static ResponseFormat valueOf(String str) {
            return (ResponseFormat) Enum.valueOf(ResponseFormat.class, str);
        }

        public static ResponseFormat[] values() {
            return (ResponseFormat[]) f13999d.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ResponseType {

        /* renamed from: a, reason: collision with root package name */
        public static final ResponseType f14000a;

        /* renamed from: b, reason: collision with root package name */
        public static final ResponseType f14001b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ ResponseType[] f14002c;

        static {
            ResponseType responseType = new ResponseType("KeepInMemory", 0);
            f14000a = responseType;
            ResponseType responseType2 = new ResponseType("FileStorage", 1);
            f14001b = responseType2;
            f14002c = new ResponseType[]{responseType, responseType2};
        }

        public static ResponseType valueOf(String str) {
            return (ResponseType) Enum.valueOf(ResponseType.class, str);
        }

        public static ResponseType[] values() {
            return (ResponseType[]) f14002c.clone();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x01a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ReactNativeBlobUtilReq(com.facebook.react.bridge.ReadableMap r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, com.facebook.react.bridge.ReadableMap r15, java.lang.String r16, com.facebook.react.bridge.ReadableArray r17, okhttp3.OkHttpClient r18, com.facebook.react.bridge.Callback r19) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.<init>(com.facebook.react.bridge.ReadableMap, java.lang.String, java.lang.String, java.lang.String, com.facebook.react.bridge.ReadableMap, java.lang.String, com.facebook.react.bridge.ReadableArray, okhttp3.OkHttpClient, com.facebook.react.bridge.Callback):void");
    }

    public static void a(String str) {
        HashMap map = w;
        Call call = (Call) map.get(str);
        if (call != null) {
            call.cancel();
            map.remove(str);
        }
        HashMap map2 = x;
        if (map2.containsKey(str)) {
            ((DownloadManager) ReactNativeBlobUtilImpl.f13918b.getApplicationContext().getSystemService("download")).remove(((Long) map2.get(str)).longValue());
        }
    }

    public static String b(String str, HashMap map) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = (String) map.get(str.toLowerCase(Locale.ROOT));
        return str3 == null ? "" : str3;
    }

    public static String c(Headers headers, String str) {
        String strD = headers.d(str);
        if (strD != null) {
            return strD;
        }
        Locale locale = Locale.ROOT;
        return headers.d(str.toLowerCase(locale)) == null ? "" : headers.d(str.toLowerCase(locale));
    }

    public final void d(Object... objArr) {
        if (this.s) {
            return;
        }
        this.f13980i.invoke(objArr);
        this.s = true;
    }

    public final void e() {
        HashMap map = w;
        String str = this.f13973b;
        if (map.containsKey(str)) {
            map.remove(str);
        }
        HashMap map2 = x;
        if (map2.containsKey(str)) {
            map2.remove(str);
        }
        HashMap map3 = z;
        if (map3.containsKey(str)) {
            map3.remove(str);
        }
        HashMap map4 = y;
        if (map4.containsKey(str)) {
            map4.remove(str);
        }
        ReactNativeBlobUtilBody reactNativeBlobUtilBody = this.f13982k;
        if (reactNativeBlobUtilBody != null) {
            reactNativeBlobUtilBody.getClass();
            try {
                File file = reactNativeBlobUtilBody.f13895g;
                if (file == null || !file.exists()) {
                    return;
                }
                reactNativeBlobUtilBody.f13895g.delete();
            } catch (Exception e2) {
                ReactNativeBlobUtilUtils.a(e2.getLocalizedMessage());
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00be  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r11, android.content.Intent r12) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.onReceive(android.content.Context, android.content.Intent):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:(5:240|67|(4:69|70|238|71)|249|77)|(1:82)|83|(2:85|86)|88|(1:90)(2:91|(1:93))|230|94|(16:96|(5:98|(5:100|(4:(2:107|(5:243|109|(1:111)|112|(3:114|(1:116)|117)(2:118|119)))|103|244|124)(1:123)|122|245|124)|242|125|250)|126|236|127|131|(3:133|(4:136|(4:138|(1:140)(2:142|(1:144))|141|248)(2:145|247)|146|134)|246)|147|148|(4:156|157|(2:159|160)(2:161|(3:165|(1:167)|168))|(2:170|(1:188)(2:175|(5:181|(1:183)|184|(1:186)|187)(1:180))))(1:155)|189|(2:191|(2:193|(3:195|(2:198|(2:204|206)(1:205))|197)(1:207))(1:208))(4:209|228|210|214)|215|(1:217)|218|251)(3:234|220|221)|120|121|225|226) */
    /* JADX WARN: Removed duplicated region for block: B:234:0x055d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0258 A[Catch: Exception -> 0x02ce, TryCatch #1 {Exception -> 0x02ce, blocks: (B:94:0x0250, B:96:0x0258, B:98:0x0266, B:100:0x0278, B:124:0x02d7, B:104:0x028b, B:107:0x0292, B:109:0x029c, B:111:0x02a6, B:112:0x02a9, B:114:0x02b8, B:116:0x02c0, B:117:0x02c3, B:118:0x02c6, B:119:0x02cd, B:125:0x02e0, B:126:0x02ef, B:127:0x02f4, B:131:0x0301, B:133:0x0308, B:134:0x030c, B:136:0x0312, B:138:0x0322, B:140:0x032a, B:142:0x0331, B:144:0x0339, B:145:0x033e, B:147:0x0353, B:150:0x0361, B:152:0x0367, B:155:0x036e, B:189:0x03fa, B:215:0x04f6, B:217:0x051d, B:218:0x0527, B:198:0x041b, B:200:0x0421, B:202:0x0427, B:205:0x042f, B:206:0x0434, B:207:0x043f, B:208:0x0466, B:209:0x048c, B:214:0x04d8, B:213:0x04c0, B:156:0x037a, B:160:0x038e, B:170:0x03ac, B:172:0x03b4, B:175:0x03bd, B:177:0x03c7, B:180:0x03d4, B:181:0x03d9, B:183:0x03e9, B:184:0x03ec, B:186:0x03f2, B:187:0x03f5, B:188:0x03f8, B:163:0x0397, B:165:0x039d, B:167:0x03a3, B:168:0x03a8, B:130:0x02fe, B:223:0x0566, B:224:0x056b, B:210:0x04b2, B:220:0x055d, B:221:0x0564), top: B:230:0x0250, inners: #0, #6, #7 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.run():void");
    }
}
