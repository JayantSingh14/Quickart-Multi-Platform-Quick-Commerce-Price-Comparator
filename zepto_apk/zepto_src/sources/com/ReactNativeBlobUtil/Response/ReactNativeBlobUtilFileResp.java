package com.ReactNativeBlobUtil.Response;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;
import org.xbill.DNS.TTL;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilFileResp extends ResponseBody {

    /* renamed from: b, reason: collision with root package name */
    public final String f14014b;

    /* renamed from: c, reason: collision with root package name */
    public final ResponseBody f14015c;

    /* renamed from: e, reason: collision with root package name */
    public final ReactApplicationContext f14017e;

    /* renamed from: f, reason: collision with root package name */
    public final FileOutputStream f14018f;

    /* renamed from: d, reason: collision with root package name */
    public long f14016d = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14019g = false;

    public class ProgressReportingSource implements Source {
        public ProgressReportingSource() {
        }

        public final void a(long j2, long j3, String str) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("taskId", str);
            writableMapCreateMap.putString("written", String.valueOf(j2));
            writableMapCreateMap.putString("total", String.valueOf(j3));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilFileResp.this.f14017e.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("ReactNativeBlobUtilProgress", writableMapCreateMap);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            ReactNativeBlobUtilFileResp.this.f14018f.close();
        }

        @Override // okio.Source
        public final long read(Buffer buffer, long j2) throws IOException {
            ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp = ReactNativeBlobUtilFileResp.this;
            int i2 = (int) j2;
            try {
                byte[] bArr = new byte[i2];
                long j3 = reactNativeBlobUtilFileResp.f14015c.a().read(bArr, 0, i2);
                reactNativeBlobUtilFileResp.f14016d += j3 > 0 ? j3 : 0L;
                if (j3 > 0) {
                    reactNativeBlobUtilFileResp.f14018f.write(bArr, 0, (int) j3);
                } else if (reactNativeBlobUtilFileResp.e() == -1 && j3 == -1) {
                    reactNativeBlobUtilFileResp.f14019g = true;
                }
                String str = reactNativeBlobUtilFileResp.f14014b;
                HashMap map = ReactNativeBlobUtilReq.y;
                ReactNativeBlobUtilProgressConfig reactNativeBlobUtilProgressConfig = !map.containsKey(str) ? null : (ReactNativeBlobUtilProgressConfig) map.get(str);
                if (reactNativeBlobUtilFileResp.e() != 0) {
                    float fE = reactNativeBlobUtilFileResp.e() != -1 ? reactNativeBlobUtilFileResp.f14016d / reactNativeBlobUtilFileResp.e() : reactNativeBlobUtilFileResp.f14019g ? 1.0f : 0.0f;
                    if (reactNativeBlobUtilProgressConfig != null && reactNativeBlobUtilProgressConfig.a(fE)) {
                        if (reactNativeBlobUtilFileResp.e() != -1) {
                            a(reactNativeBlobUtilFileResp.f14016d, reactNativeBlobUtilFileResp.e(), reactNativeBlobUtilFileResp.f14014b);
                            return j3;
                        }
                        if (!reactNativeBlobUtilFileResp.f14019g) {
                            a(0L, reactNativeBlobUtilFileResp.e(), reactNativeBlobUtilFileResp.f14014b);
                            return j3;
                        }
                        String str2 = reactNativeBlobUtilFileResp.f14014b;
                        long j4 = reactNativeBlobUtilFileResp.f14016d;
                        a(j4, j4, str2);
                    }
                }
                return j3;
            } catch (Exception unused) {
                return -1L;
            }
        }

        @Override // okio.Source
        public final Timeout timeout() {
            return null;
        }
    }

    public ReactNativeBlobUtilFileResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, String str2, boolean z) throws IOException {
        this.f14017e = reactApplicationContext;
        this.f14014b = str;
        this.f14015c = responseBody;
        if (str2 != null) {
            boolean z2 = !z;
            String strReplace = str2.replace("?append=true", "");
            File file = new File(strReplace);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                throw new IllegalStateException("Couldn't create dir: " + parentFile);
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            this.f14018f = new FileOutputStream(new File(strReplace), z2);
        }
    }

    @Override // okhttp3.ResponseBody
    public final long e() {
        ResponseBody responseBody = this.f14015c;
        return responseBody.e() > TTL.MAX_VALUE ? TTL.MAX_VALUE : responseBody.e();
    }

    @Override // okhttp3.ResponseBody
    public final MediaType l() {
        return this.f14015c.l();
    }

    @Override // okhttp3.ResponseBody
    public final BufferedSource source() {
        return Okio.d(new ProgressReportingSource());
    }
}
