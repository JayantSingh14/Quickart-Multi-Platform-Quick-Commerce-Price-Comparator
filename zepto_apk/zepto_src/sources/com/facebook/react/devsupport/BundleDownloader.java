package com.facebook.react.devsupport;

import coil3.network.internal.UtilsKt;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.MultipartStreamReader;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.connection.RealCall;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class BundleDownloader {

    /* renamed from: a, reason: collision with root package name */
    public final OkHttpClient f18761a;

    /* renamed from: b, reason: collision with root package name */
    public RealCall f18762b;

    /* renamed from: com.facebook.react.devsupport.BundleDownloader$2, reason: invalid class name */
    class AnonymousClass2 implements MultipartStreamReader.ChunkListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Response f18767a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f18768b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ File f18769c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BundleInfo f18770d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ DevBundleDownloadListener f18771e;

        public AnonymousClass2(Response response, String str, File file, BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) {
            this.f18767a = response;
            this.f18768b = str;
            this.f18769c = file;
            this.f18770d = bundleInfo;
            this.f18771e = devBundleDownloadListener;
        }

        public final void a(HashMap map, Buffer buffer, boolean z) throws Throwable {
            DevBundleDownloadListener devBundleDownloadListener = this.f18771e;
            if (z) {
                BundleDownloader.a(BundleDownloader.this, this.f18768b, map.containsKey("X-Http-Status") ? Integer.parseInt((String) map.get("X-Http-Status")) : this.f18767a.f56353d, Headers.j(map), buffer, this.f18769c, this.f18770d, devBundleDownloadListener);
                return;
            }
            if (map.containsKey(UtilsKt.CONTENT_TYPE) && ((String) map.get(UtilsKt.CONTENT_TYPE)).equals("application/json")) {
                try {
                    JSONObject jSONObject = new JSONObject(buffer.A1());
                    ((DevSupportManagerBase.AnonymousClass7) devBundleDownloadListener).b(jSONObject.has(CLConstants.OTP_STATUS) ? jSONObject.getString(CLConstants.OTP_STATUS) : "Bundling", jSONObject.has("done") ? Integer.valueOf(jSONObject.getInt("done")) : null, jSONObject.has("total") ? Integer.valueOf(jSONObject.getInt("total")) : null);
                } catch (JSONException e2) {
                    FLog.g("ReactNative", "Error parsing progress JSON. " + e2.toString());
                }
            }
        }
    }

    public static class BundleInfo {

        /* renamed from: a, reason: collision with root package name */
        public String f18773a;

        /* renamed from: b, reason: collision with root package name */
        public int f18774b;
    }

    public BundleDownloader(OkHttpClient okHttpClient) {
        this.f18761a = okHttpClient;
    }

    public static void a(BundleDownloader bundleDownloader, String str, int i2, Headers headers, BufferedSource bufferedSource, File file, BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) throws Throwable {
        Sink sink = null;
        debugServerException = null;
        DebugServerException debugServerException = null;
        String string = null;
        bundleDownloader.getClass();
        if (i2 != 200) {
            String strA1 = bufferedSource.A1();
            int i3 = DebugServerException.f18690a;
            if (strA1.length() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(strA1);
                    String string2 = jSONObject.getString("filename");
                    String string3 = jSONObject.getString(APayConstants.Error.MESSAGE);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    Intrinsics.c(string2);
                    debugServerException = new DebugServerException(string3 + "\n  at " + DebugServerException.Companion.b(string2) + ":" + jSONObject.getInt("lineNumber") + ":" + jSONObject.getInt("column"));
                } catch (JSONException e2) {
                    FLog.r("ReactNative", "Could not parse DebugServerException from: ".concat(strA1), e2);
                }
            }
            if (debugServerException != null) {
                ((DevSupportManagerBase.AnonymousClass7) devBundleDownloadListener).a(debugServerException);
                return;
            }
            ((DevSupportManagerBase.AnonymousClass7) devBundleDownloadListener).a(new DebugServerException("The development server returned response error code: " + i2 + "\n\nURL: " + str + "\n\nBody:\n" + strA1));
            return;
        }
        bundleInfo.f18773a = str;
        String strD = headers.d("X-Metro-Files-Changed-Count");
        if (strD != null) {
            try {
                bundleInfo.f18774b = Integer.parseInt(strD);
            } catch (NumberFormatException unused) {
                bundleInfo.f18774b = -2;
            }
        }
        File file2 = new File(file.getPath() + ".tmp");
        try {
            Sink sinkH = Okio.h(file2);
            try {
                bufferedSource.F1(sinkH);
                sinkH.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Couldn't rename " + file2 + " to " + file);
                }
                DevSupportManagerBase.AnonymousClass7 anonymousClass7 = (DevSupportManagerBase.AnonymousClass7) devBundleDownloadListener;
                DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
                devSupportManagerBase.f18827j.c();
                devSupportManagerBase.o = false;
                ReactMarkerConstants reactMarkerConstants = ReactMarkerConstants.DOWNLOAD_END;
                BundleInfo bundleInfo2 = anonymousClass7.f18837a;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("url", bundleInfo2.f18773a);
                    jSONObject2.put("filesChangedCount", bundleInfo2.f18774b);
                    string = jSONObject2.toString();
                } catch (JSONException e3) {
                    FLog.h("BundleDownloader", "Can't serialize bundle info: ", e3);
                }
                ReactMarker.logMarker(reactMarkerConstants, string);
                anonymousClass7.f18838b.onSuccess();
            } catch (Throwable th) {
                th = th;
                sink = sinkH;
                if (sink != null) {
                    sink.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void b(BundleDownloader bundleDownloader, String str, Response response, String str2, File file, BundleInfo bundleInfo, DevBundleDownloadListener devBundleDownloadListener) throws Throwable {
        boolean z;
        long j2;
        BufferedSource bufferedSource;
        ByteString byteString;
        long j3;
        MultipartStreamReader multipartStreamReader;
        long j4;
        HashMap mapB;
        boolean z2;
        long j5;
        bundleDownloader.getClass();
        MultipartStreamReader multipartStreamReader2 = new MultipartStreamReader(str2, response.f56356g.source());
        AnonymousClass2 anonymousClass2 = bundleDownloader.new AnonymousClass2(response, str, file, bundleInfo, devBundleDownloadListener);
        String strD = android.support.v4.media.b.D("\r\n--", str2, "\r\n");
        ByteString byteString2 = ByteString.f56924d;
        ByteString byteStringC = ByteString.Companion.c(strD);
        ByteString byteStringC2 = ByteString.Companion.c("\r\n--" + str2 + "--\r\n");
        ByteString byteStringC3 = ByteString.Companion.c("\r\n\r\n");
        Buffer buffer = new Buffer();
        long j6 = 0L;
        long length = 0;
        long length2 = 0;
        long j7 = 0;
        HashMap map = null;
        while (true) {
            long jMax = Math.max(j6 - byteStringC2.f56925a.length, length);
            long jD = buffer.D(jMax, byteStringC);
            if (jD == -1) {
                jD = buffer.D(jMax, byteStringC2);
                z = true;
            } else {
                z = false;
            }
            boolean z3 = z;
            HashMap map2 = map;
            long j8 = jD;
            if (j8 == -1) {
                long j9 = buffer.f56914b;
                BufferedSource bufferedSource2 = multipartStreamReader2.f18860a;
                if (map2 == null) {
                    j2 = j9;
                    long jD2 = buffer.D(jMax, byteStringC3);
                    if (jD2 >= j7) {
                        bufferedSource2.read(buffer, jD2);
                        long j10 = length;
                        Buffer buffer2 = new Buffer();
                        long j11 = jD2 - jMax;
                        j4 = j10;
                        buffer.e(buffer2, jMax, j11);
                        length2 = buffer2.f56914b + byteStringC3.f56925a.length;
                        mapB = MultipartStreamReader.b(buffer2);
                    } else {
                        j4 = length;
                        mapB = map2;
                    }
                    bufferedSource = bufferedSource2;
                    byteString = byteStringC;
                    map = mapB;
                    multipartStreamReader = multipartStreamReader2;
                    j3 = j4;
                } else {
                    j2 = j9;
                    long j12 = length;
                    bufferedSource = bufferedSource2;
                    byteString = byteStringC;
                    map = map2;
                    MultipartStreamReader multipartStreamReader3 = multipartStreamReader2;
                    j3 = j12;
                    multipartStreamReader3.a(map, j2 - length2, false, anonymousClass2);
                    multipartStreamReader = multipartStreamReader3;
                }
                if (bufferedSource.read(buffer, 4096) <= j7) {
                    ((DevSupportManagerBase.AnonymousClass7) devBundleDownloadListener).a(new DebugServerException("Error while reading multipart response.\n\nResponse code: " + response.f56353d + "\n\nURL: " + str.toString() + "\n\n"));
                    return;
                }
                length = j3;
                j6 = j2;
                byteStringC = byteString;
                multipartStreamReader2 = multipartStreamReader;
            } else {
                MultipartStreamReader multipartStreamReader4 = multipartStreamReader2;
                ByteString byteString3 = byteStringC;
                long j13 = length;
                long j14 = j8 - j13;
                if (j13 > j7) {
                    Buffer buffer3 = new Buffer();
                    buffer.j1(j13);
                    buffer.read(buffer3, j14);
                    z2 = z3;
                    multipartStreamReader4.a(map2, buffer3.f56914b - length2, true, anonymousClass2);
                    multipartStreamReader4 = multipartStreamReader4;
                    ByteString byteString4 = ByteString.f56924d;
                    ByteString bytes = ByteString.Companion.c("\r\n\r\n");
                    Intrinsics.checkNotNullParameter(bytes, "bytes");
                    j5 = j7;
                    long jD3 = buffer3.D(j5, bytes);
                    if (jD3 == -1) {
                        anonymousClass2.a(null, buffer3, z2);
                    } else {
                        Buffer buffer4 = new Buffer();
                        Buffer buffer5 = new Buffer();
                        buffer3.read(buffer4, jD3);
                        buffer3.j1(bytes.f56925a.length);
                        buffer3.F1(buffer5);
                        anonymousClass2.a(MultipartStreamReader.b(buffer4), buffer5, z2);
                    }
                    length2 = j5;
                    map = null;
                } else {
                    z2 = z3;
                    j5 = j7;
                    buffer.j1(j8);
                    map = map2;
                }
                if (z2) {
                    return;
                }
                length = byteString3.f56925a.length;
                byteStringC = byteString3;
                multipartStreamReader2 = multipartStreamReader4;
                j7 = j5;
                j6 = length;
            }
        }
    }
}
