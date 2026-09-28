package com.ReactNativeBlobUtil.Response;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilDefaultResp extends ResponseBody {

    /* renamed from: b, reason: collision with root package name */
    public final String f14007b;

    /* renamed from: c, reason: collision with root package name */
    public final ReactApplicationContext f14008c;

    /* renamed from: d, reason: collision with root package name */
    public final ResponseBody f14009d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14010e;

    public class ProgressReportingSource implements Source {

        /* renamed from: a, reason: collision with root package name */
        public final BufferedSource f14011a;

        /* renamed from: b, reason: collision with root package name */
        public long f14012b = 0;

        public ProgressReportingSource(BufferedSource bufferedSource) {
            this.f14011a = bufferedSource;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
        }

        @Override // okio.Source
        public final long read(Buffer buffer, long j2) {
            long j3 = this.f14011a.read(buffer, j2);
            this.f14012b += j3 > 0 ? j3 : 0L;
            ReactNativeBlobUtilDefaultResp reactNativeBlobUtilDefaultResp = ReactNativeBlobUtilDefaultResp.this;
            String str = reactNativeBlobUtilDefaultResp.f14007b;
            HashMap map = ReactNativeBlobUtilReq.y;
            ReactNativeBlobUtilProgressConfig reactNativeBlobUtilProgressConfig = !map.containsKey(str) ? null : (ReactNativeBlobUtilProgressConfig) map.get(str);
            long jE = reactNativeBlobUtilDefaultResp.f14009d.e();
            if (reactNativeBlobUtilProgressConfig != null && jE != 0 && reactNativeBlobUtilProgressConfig.a(this.f14012b / reactNativeBlobUtilDefaultResp.f14009d.e())) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("taskId", reactNativeBlobUtilDefaultResp.f14007b);
                writableMapCreateMap.putString("written", String.valueOf(this.f14012b));
                writableMapCreateMap.putString("total", String.valueOf(reactNativeBlobUtilDefaultResp.f14009d.e()));
                if (reactNativeBlobUtilDefaultResp.f14010e) {
                    writableMapCreateMap.putString("chunk", buffer.p1(Charset.defaultCharset()));
                } else {
                    writableMapCreateMap.putString("chunk", "");
                }
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactNativeBlobUtilDefaultResp.f14008c.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ReactNativeBlobUtilProgress", writableMapCreateMap);
            }
            return j3;
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return null;
        }
    }

    public ReactNativeBlobUtilDefaultResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, boolean z) {
        this.f14008c = reactApplicationContext;
        this.f14007b = str;
        this.f14009d = responseBody;
        this.f14010e = z;
    }

    @Override // okhttp3.ResponseBody
    public final long e() {
        return this.f14009d.e();
    }

    @Override // okhttp3.ResponseBody
    public final MediaType l() {
        return this.f14009d.l();
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return Okio.d(new ProgressReportingSource(this.f14009d.source()));
    }
}
