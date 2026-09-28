package com.facebook.react.modules.network;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeNetworkingAndroidSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.RequestBodyUtil;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@ReactModule(name = "Networking")
/* loaded from: classes.dex */
public final class NetworkingModule extends NativeNetworkingAndroidSpec {
    private static final int CHUNK_TIMEOUT_NS = 100000000;
    private static final String CONTENT_ENCODING_HEADER_NAME = "content-encoding";
    private static final String CONTENT_TYPE_HEADER_NAME = "content-type";
    private static final int MAX_CHUNK_SIZE_BETWEEN_FLUSHES = 8192;
    private static final String REQUEST_BODY_KEY_BASE64 = "base64";
    private static final String REQUEST_BODY_KEY_FORMDATA = "formData";
    private static final String REQUEST_BODY_KEY_STRING = "string";
    private static final String REQUEST_BODY_KEY_URI = "uri";
    private static final String TAG = "Networking";
    private static final String USER_AGENT_HEADER_NAME = "user-agent";

    @Nullable
    private static com.facebook.react.modules.network.CustomClientBuilder customClientBuilder;
    private final OkHttpClient mClient;
    private final ForwardingCookieHandler mCookieHandler;

    @Nullable
    private final CookieJarContainer mCookieJarContainer;

    @Nullable
    private final String mDefaultUserAgent;
    private final List<RequestBodyHandler> mRequestBodyHandlers;
    private final Set<Integer> mRequestIds;
    private final List<ResponseHandler> mResponseHandlers;
    private boolean mShuttingDown;
    private final List<UriHandler> mUriHandlers;

    /* renamed from: com.facebook.react.modules.network.NetworkingModule$3, reason: invalid class name */
    public class AnonymousClass3 implements ProgressListener {

        /* renamed from: a, reason: collision with root package name */
        public long f19140a = System.nanoTime();

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ReactApplicationContext f19141b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f19142c;

        public AnonymousClass3(ReactApplicationContext reactApplicationContext, int i2) {
            this.f19141b = reactApplicationContext;
            this.f19142c = i2;
        }

        @Override // com.facebook.react.modules.network.ProgressListener
        public final void a(long j2, long j3, boolean z) {
            long jNanoTime = System.nanoTime();
            if (z || NetworkingModule.shouldDispatch(jNanoTime, this.f19140a)) {
                WritableArray writableArrayCreateArray = Arguments.createArray();
                writableArrayCreateArray.pushInt(this.f19142c);
                writableArrayCreateArray.pushInt((int) j2);
                writableArrayCreateArray.pushInt((int) j3);
                ReactApplicationContext reactApplicationContext = this.f19141b;
                if (reactApplicationContext != null) {
                    reactApplicationContext.emitDeviceEvent("didSendNetworkData", writableArrayCreateArray);
                }
                this.f19140a = jNanoTime;
            }
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface CustomClientBuilder extends com.facebook.react.modules.network.CustomClientBuilder {
    }

    public interface RequestBodyHandler {
        boolean a(ReadableMap readableMap);

        RequestBody b(ReadableMap readableMap, String str);
    }

    public interface ResponseHandler {
        WritableMap a(ResponseBody responseBody);

        boolean b(String str);
    }

    public interface UriHandler {
        WritableMap a(Uri uri);

        boolean b(Uri uri, String str);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, @Nullable String str, OkHttpClient okHttpClient, @Nullable List<NetworkInterceptorCreator> list) {
        super(reactApplicationContext);
        this.mCookieHandler = new ForwardingCookieHandler();
        this.mRequestIds = new HashSet();
        this.mRequestBodyHandlers = new ArrayList();
        this.mUriHandlers = new ArrayList();
        this.mResponseHandlers = new ArrayList();
        this.mShuttingDown = false;
        if (list != null) {
            OkHttpClient.Builder builderC = okHttpClient.c();
            Iterator<NetworkInterceptorCreator> it = list.iterator();
            while (it.hasNext()) {
                Interceptor interceptor = it.next().create();
                Intrinsics.checkNotNullParameter(interceptor, "interceptor");
                builderC.f56313d.add(interceptor);
            }
            okHttpClient = new OkHttpClient(builderC);
        }
        this.mClient = okHttpClient;
        CookieJar cookieJar = okHttpClient.f56306j;
        if (cookieJar instanceof CookieJarContainer) {
            this.mCookieJarContainer = (CookieJarContainer) cookieJar;
        } else {
            this.mCookieJarContainer = null;
        }
        this.mDefaultUserAgent = str;
    }

    private synchronized void addRequest(int i2) {
        this.mRequestIds.add(Integer.valueOf(i2));
    }

    private static void applyCustomBuilder(OkHttpClient.Builder builder) {
        com.facebook.react.modules.network.CustomClientBuilder customClientBuilder2 = customClientBuilder;
        if (customClientBuilder2 != null) {
            customClientBuilder2.apply();
        }
    }

    private synchronized void cancelAllRequests() {
        try {
            Iterator<Integer> it = this.mRequestIds.iterator();
            while (it.hasNext()) {
                cancelRequest(it.next().intValue());
            }
            this.mRequestIds.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    private void cancelRequest(int i2) {
        OkHttpCallUtil.a(this.mClient, Integer.valueOf(i2));
    }

    @Nullable
    private MultipartBody.Builder constructMultipartBody(ReadableArray readableArray, String str, int i2) {
        MediaType mediaTypeB;
        MultipartBody.Builder builder = new MultipartBody.Builder();
        Pattern pattern = MediaType.f56278d;
        builder.d(MediaType.Companion.b(str));
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        int size = readableArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            ReadableMap map = readableArray.getMap(i3);
            Headers headersExtractHeaders = extractHeaders(map.getArray("headers"), null);
            if (headersExtractHeaders == null) {
                ResponseUtil.a(reactApplicationContextIfActiveOrWarn, i2, "Missing or invalid header format for FormData part.", null);
                return null;
            }
            String strD = headersExtractHeaders.d(CONTENT_TYPE_HEADER_NAME);
            if (strD != null) {
                Pattern pattern2 = MediaType.f56278d;
                mediaTypeB = MediaType.Companion.b(strD);
                Headers.Builder builderI = headersExtractHeaders.i();
                builderI.g(CONTENT_TYPE_HEADER_NAME);
                headersExtractHeaders = builderI.e();
            } else {
                mediaTypeB = null;
            }
            if (map.hasKey(REQUEST_BODY_KEY_STRING)) {
                builder.a(headersExtractHeaders, RequestBody.create(mediaTypeB, map.getString(REQUEST_BODY_KEY_STRING)));
            } else if (!map.hasKey(REQUEST_BODY_KEY_URI)) {
                ResponseUtil.a(reactApplicationContextIfActiveOrWarn, i2, "Unrecognized FormData part.", null);
            } else {
                if (mediaTypeB == null) {
                    ResponseUtil.a(reactApplicationContextIfActiveOrWarn, i2, "Binary FormData part needs a content-type header.", null);
                    return null;
                }
                String string = map.getString(REQUEST_BODY_KEY_URI);
                InputStream inputStreamC = RequestBodyUtil.c(getReactApplicationContext(), string);
                if (inputStreamC == null) {
                    ResponseUtil.a(reactApplicationContextIfActiveOrWarn, i2, "Could not retrieve file for uri " + string, null);
                    return null;
                }
                builder.a(headersExtractHeaders, new RequestBodyUtil.AnonymousClass1(mediaTypeB, inputStreamC));
            }
        }
        return builder;
    }

    @Nullable
    private Headers extractHeaders(@Nullable ReadableArray readableArray, @Nullable ReadableMap readableMap) {
        String str;
        if (readableArray == null) {
            return null;
        }
        Headers.Builder builder = new Headers.Builder();
        int size = readableArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            ReadableArray array = readableArray.getArray(i2);
            if (array == null || array.size() != 2) {
                return null;
            }
            String string = array.getString(0);
            StringBuilder sb = new StringBuilder(string.length());
            int length = string.length();
            boolean z = false;
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = string.charAt(i3);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    z = true;
                } else {
                    sb.append(cCharAt);
                }
            }
            if (z) {
                string = sb.toString();
            }
            String string2 = array.getString(1);
            if (string == null || string2 == null) {
                return null;
            }
            builder.d(string, string2);
        }
        if (builder.f(USER_AGENT_HEADER_NAME) == null && (str = this.mDefaultUserAgent) != null) {
            builder.a(USER_AGENT_HEADER_NAME, str);
        }
        if (readableMap == null || !readableMap.hasKey(REQUEST_BODY_KEY_STRING)) {
            builder.g(CONTENT_ENCODING_HEADER_NAME);
        }
        return builder.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response lambda$sendRequestInternal$0(final String str, final ReactApplicationContext reactApplicationContext, final int i2, Interceptor.Chain chain) throws IOException {
        Response responseA = chain.a(chain.r());
        ProgressResponseBody progressResponseBody = new ProgressResponseBody(responseA.f56356g, new ProgressListener() { // from class: com.facebook.react.modules.network.NetworkingModule.1

            /* renamed from: a, reason: collision with root package name */
            public long f19131a = System.nanoTime();

            @Override // com.facebook.react.modules.network.ProgressListener
            public final void a(long j2, long j3, boolean z) {
                long jNanoTime = System.nanoTime();
                if ((z || NetworkingModule.shouldDispatch(jNanoTime, this.f19131a)) && !str.equals("text")) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    writableArrayCreateArray.pushInt(i2);
                    writableArrayCreateArray.pushInt((int) j2);
                    writableArrayCreateArray.pushInt((int) j3);
                    ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
                    if (reactApplicationContext2 != null) {
                        reactApplicationContext2.emitDeviceEvent("didReceiveNetworkDataProgress", writableArrayCreateArray);
                    }
                    this.f19131a = jNanoTime;
                }
            }
        });
        Response.Builder builderE = responseA.e();
        builderE.f56369g = progressResponseBody;
        return builderE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readWithProgress(int i2, ResponseBody responseBody) throws IOException {
        long j2;
        long jE = -1;
        try {
            ProgressResponseBody progressResponseBody = (ProgressResponseBody) responseBody;
            j2 = progressResponseBody.f19152e;
            try {
                jE = progressResponseBody.f19149b.e();
            } catch (ClassCastException unused) {
            }
        } catch (ClassCastException unused2) {
            j2 = -1;
        }
        ProgressiveStringDecoder progressiveStringDecoder = new ProgressiveStringDecoder(responseBody.l() == null ? StandardCharsets.UTF_8 : responseBody.l().a(StandardCharsets.UTF_8));
        InputStream inputStreamA = responseBody.a();
        try {
            byte[] bArr = new byte[8192];
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            while (true) {
                int i3 = inputStreamA.read(bArr);
                if (i3 == -1) {
                    return;
                }
                String strA = progressiveStringDecoder.a(i3, bArr);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                writableArrayCreateArray.pushInt(i2);
                writableArrayCreateArray.pushString(strA);
                writableArrayCreateArray.pushInt((int) j2);
                writableArrayCreateArray.pushInt((int) jE);
                if (reactApplicationContextIfActiveOrWarn != null) {
                    reactApplicationContextIfActiveOrWarn.emitDeviceEvent("didReceiveNetworkIncrementalData", writableArrayCreateArray);
                }
            }
        } finally {
            inputStreamA.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void removeRequest(int i2) {
        this.mRequestIds.remove(Integer.valueOf(i2));
    }

    public static void setCustomClientBuilder(com.facebook.react.modules.network.CustomClientBuilder customClientBuilder2) {
        customClientBuilder = customClientBuilder2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldDispatch(long j2, long j3) {
        return j3 + 100000000 < j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static WritableMap translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i2 = 0; i2 < headers.size(); i2++) {
            String strF = headers.f(i2);
            if (bundle.containsKey(strF)) {
                bundle.putString(strF, bundle.getString(strF) + ", " + headers.m(i2));
            } else {
                bundle.putString(strF, headers.m(i2));
            }
        }
        return Arguments.fromBundle(bundle);
    }

    private RequestBody wrapRequestBodyWithProgressEmitter(RequestBody requestBody, int i2) {
        if (requestBody == null) {
            return null;
        }
        return new ProgressRequestBody(requestBody, new AnonymousClass3(getReactApplicationContextIfActiveOrWarn(), i2));
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void abortRequest(double d2) {
        int i2 = (int) d2;
        cancelRequest(i2);
        removeRequest(i2);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void addListener(String str) {
    }

    public void addRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.add(requestBodyHandler);
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.add(responseHandler);
    }

    public void addUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.add(uriHandler);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    @ReactMethod
    public void clearCookies(final Callback callback) {
        ForwardingCookieHandler forwardingCookieHandler = this.mCookieHandler;
        forwardingCookieHandler.getClass();
        Intrinsics.checkNotNullParameter(callback, "callback");
        CookieManager cookieManagerA = forwardingCookieHandler.a();
        if (cookieManagerA != null) {
            cookieManagerA.removeAllCookies(new ValueCallback() { // from class: com.facebook.react.modules.network.a
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    int i2 = ForwardingCookieHandler.f19129b;
                    callback.invoke((Boolean) obj);
                }
            });
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        CookieJarContainer cookieJarContainer = this.mCookieJarContainer;
        if (cookieJarContainer != null) {
            cookieJarContainer.c(new JavaNetCookieJar(this.mCookieHandler));
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        this.mShuttingDown = true;
        cancelAllRequests();
        this.mCookieHandler.getClass();
        CookieJarContainer cookieJarContainer = this.mCookieJarContainer;
        if (cookieJarContainer != null) {
            cookieJarContainer.a();
        }
        this.mRequestBodyHandlers.clear();
        this.mResponseHandlers.clear();
        this.mUriHandlers.clear();
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void removeListeners(double d2) {
    }

    public void removeRequestBodyHandler(RequestBodyHandler requestBodyHandler) {
        this.mRequestBodyHandlers.remove(requestBodyHandler);
    }

    public void removeResponseHandler(ResponseHandler responseHandler) {
        this.mResponseHandlers.remove(responseHandler);
    }

    public void removeUriHandler(UriHandler uriHandler) {
        this.mUriHandlers.remove(uriHandler);
    }

    @Override // com.facebook.fbreact.specs.NativeNetworkingAndroidSpec
    public void sendRequest(String str, String str2, double d2, ReadableArray readableArray, ReadableMap readableMap, String str3, boolean z, double d3, boolean z2) {
        int i2 = (int) d2;
        try {
            sendRequestInternal(str, str2, i2, readableArray, readableMap, str3, z, (int) d3, z2);
        } catch (Throwable th) {
            FLog.h("Networking", "Failed to send url request: " + str2, th);
            ResponseUtil.a(getReactApplicationContextIfActiveOrWarn(), i2, th.getMessage(), th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void sendRequestInternal(java.lang.String r7, java.lang.String r8, final int r9, com.facebook.react.bridge.ReadableArray r10, com.facebook.react.bridge.ReadableMap r11, final java.lang.String r12, final boolean r13, int r14, boolean r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.modules.network.NetworkingModule.sendRequestInternal(java.lang.String, java.lang.String, int, com.facebook.react.bridge.ReadableArray, com.facebook.react.bridge.ReadableMap, java.lang.String, boolean, int, boolean):void");
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, @Nullable String str, OkHttpClient okHttpClient) {
        this(reactApplicationContext, str, okHttpClient, null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, null, OkHttpClientProvider.b(), null);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, List<NetworkInterceptorCreator> list) {
        this(reactApplicationContext, null, OkHttpClientProvider.b(), list);
    }

    public NetworkingModule(ReactApplicationContext reactApplicationContext, String str) {
        this(reactApplicationContext, str, OkHttpClientProvider.b(), null);
    }
}
