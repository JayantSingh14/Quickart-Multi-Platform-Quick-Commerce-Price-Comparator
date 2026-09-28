package com.facebook.react.modules.blob;

import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.media.a;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import coil3.util.UtilsKt;
import com.facebook.fbreact.specs.NativeBlobModuleSpec;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.ByteString;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = NativeBlobModuleSpec.NAME)
/* loaded from: classes.dex */
public class BlobModule extends NativeBlobModuleSpec {
    private final Map<String, byte[]> mBlobs;
    private final NetworkingModule.RequestBodyHandler mNetworkingRequestBodyHandler;
    private final NetworkingModule.ResponseHandler mNetworkingResponseHandler;
    private final NetworkingModule.UriHandler mNetworkingUriHandler;
    private final WebSocketModule.ContentHandler mWebSocketContentHandler;

    public BlobModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mBlobs = new HashMap();
        this.mWebSocketContentHandler = new WebSocketModule.ContentHandler() { // from class: com.facebook.react.modules.blob.BlobModule.1
            @Override // com.facebook.react.modules.websocket.WebSocketModule.ContentHandler
            public final void a(ByteString byteString, WritableMap writableMap) {
                byte[] bArrY = byteString.y();
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("blobId", BlobModule.this.store(bArrY));
                writableMapCreateMap.putInt("offset", 0);
                writableMapCreateMap.putInt("size", bArrY.length);
                writableMap.putMap("data", writableMapCreateMap);
                writableMap.putString("type", "blob");
            }

            @Override // com.facebook.react.modules.websocket.WebSocketModule.ContentHandler
            public final void b(String str, WritableMap writableMap) {
                writableMap.putString("data", str);
            }
        };
        this.mNetworkingUriHandler = new NetworkingModule.UriHandler() { // from class: com.facebook.react.modules.blob.BlobModule.2
            @Override // com.facebook.react.modules.network.NetworkingModule.UriHandler
            public final WritableMap a(Uri uri) throws IOException {
                BlobModule blobModule = BlobModule.this;
                byte[] bytesFromUri = blobModule.getBytesFromUri(uri);
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("blobId", blobModule.store(bytesFromUri));
                writableMapCreateMap.putInt("offset", 0);
                writableMapCreateMap.putInt("size", bytesFromUri.length);
                writableMapCreateMap.putString("type", blobModule.getMimeTypeFromUri(uri));
                writableMapCreateMap.putString(CLConstants.FIELD_PAY_INFO_NAME, blobModule.getNameFromUri(uri));
                writableMapCreateMap.putDouble("lastModified", blobModule.getLastModifiedFromUri(uri));
                return writableMapCreateMap;
            }

            @Override // com.facebook.react.modules.network.NetworkingModule.UriHandler
            public final boolean b(Uri uri, String str) {
                String scheme = uri.getScheme();
                return ("http".equals(scheme) || "https".equals(scheme) || !"blob".equals(str)) ? false : true;
            }
        };
        this.mNetworkingRequestBodyHandler = new NetworkingModule.RequestBodyHandler() { // from class: com.facebook.react.modules.blob.BlobModule.3
            @Override // com.facebook.react.modules.network.NetworkingModule.RequestBodyHandler
            public final boolean a(ReadableMap readableMap) {
                return readableMap.hasKey("blob");
            }

            @Override // com.facebook.react.modules.network.NetworkingModule.RequestBodyHandler
            public final RequestBody b(ReadableMap readableMap, String str) {
                if (readableMap.hasKey("type") && !readableMap.getString("type").isEmpty()) {
                    str = readableMap.getString("type");
                }
                if (str == null) {
                    str = "application/octet-stream";
                }
                ReadableMap map = readableMap.getMap("blob");
                byte[] bArrResolve = BlobModule.this.resolve(map.getString("blobId"), map.getInt("offset"), map.getInt("size"));
                Pattern pattern = MediaType.f56278d;
                return RequestBody.create(MediaType.Companion.b(str), bArrResolve);
            }
        };
        this.mNetworkingResponseHandler = new NetworkingModule.ResponseHandler() { // from class: com.facebook.react.modules.blob.BlobModule.4
            @Override // com.facebook.react.modules.network.NetworkingModule.ResponseHandler
            public final WritableMap a(ResponseBody responseBody) {
                byte[] bArrB = responseBody.b();
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putString("blobId", BlobModule.this.store(bArrB));
                writableMapCreateMap.putInt("offset", 0);
                writableMapCreateMap.putInt("size", bArrB.length);
                return writableMapCreateMap;
            }

            @Override // com.facebook.react.modules.network.NetworkingModule.ResponseHandler
            public final boolean b(String str) {
                return "blob".equals(str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] getBytesFromUri(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = getReactApplicationContext().getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            throw new FileNotFoundException(a.l(uri, "File not found for "));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStreamOpenInputStream.read(bArr);
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getLastModifiedFromUri(Uri uri) {
        if (UtilsKt.SCHEME_FILE.equals(uri.getScheme())) {
            return new File(uri.toString()).lastModified();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMimeTypeFromUri(Uri uri) {
        String fileExtensionFromUrl;
        String type = getReactApplicationContext().getContentResolver().getType(uri);
        if (type == null && (fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.getPath())) != null) {
            type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return type == null ? "" : type;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getNameFromUri(Uri uri) {
        if (UtilsKt.SCHEME_FILE.equals(uri.getScheme())) {
            return uri.getLastPathSegment();
        }
        Cursor cursorQuery = getReactApplicationContext().getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    return cursorQuery.getString(0);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return uri.getLastPathSegment();
    }

    private WebSocketModule getWebSocketModule(String str) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            return (WebSocketModule) reactApplicationContextIfActiveOrWarn.getNativeModule(WebSocketModule.class);
        }
        return null;
    }

    @Override // com.facebook.fbreact.specs.NativeBlobModuleSpec
    public void addNetworkingHandler() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            NetworkingModule networkingModule = (NetworkingModule) reactApplicationContextIfActiveOrWarn.getNativeModule(NetworkingModule.class);
            networkingModule.addUriHandler(this.mNetworkingUriHandler);
            networkingModule.addRequestBodyHandler(this.mNetworkingRequestBodyHandler);
            networkingModule.addResponseHandler(this.mNetworkingResponseHandler);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeBlobModuleSpec
    public void addWebSocketHandler(double d2) {
        int i2 = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("addWebSocketHandler");
        if (webSocketModule != null) {
            webSocketModule.setContentHandler(i2, this.mWebSocketContentHandler);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeBlobModuleSpec
    public void createFromParts(ReadableArray readableArray, String str) {
        ArrayList arrayList = new ArrayList(readableArray.size());
        int length = 0;
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            ReadableMap map = readableArray.getMap(i2);
            String string = map.getString("type");
            string.getClass();
            if (string.equals("string")) {
                byte[] bytes = map.getString("data").getBytes(Charset.forName("UTF-8"));
                length += bytes.length;
                arrayList.add(i2, bytes);
            } else {
                if (!string.equals("blob")) {
                    throw new IllegalArgumentException("Invalid type for blob: " + map.getString("type"));
                }
                ReadableMap map2 = map.getMap("data");
                int i3 = map2.getInt("size") + length;
                arrayList.add(i2, resolve(map2));
                length = i3;
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byteBufferAllocate.put((byte[]) it.next());
        }
        store(byteBufferAllocate.array(), str);
    }

    @DoNotStrip
    public long getLengthOfBlob(String str) {
        long length;
        synchronized (this.mBlobs) {
            try {
                length = this.mBlobs.get(str) != null ? r4.length : 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return length;
    }

    @Override // com.facebook.fbreact.specs.NativeBlobModuleSpec
    @Nullable
    public Map<String, Object> getTypedExportedConstants() {
        Resources resources = getReactApplicationContext().getResources();
        int identifier = resources.getIdentifier("blob_provider_authority", "string", getReactApplicationContext().getPackageName());
        return identifier == 0 ? new HashMap() : MapBuilder.d("BLOB_URI_SCHEME", "content", "BLOB_URI_HOST", resources.getString(identifier));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        final ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        int i2 = BlobCollector.f19030a;
        reactApplicationContext.runOnJSQueueThread(new Runnable() { // from class: com.facebook.react.modules.blob.BlobCollector.1
            @Override // java.lang.Runnable
            public final void run() {
                JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
                if (javaScriptContextHolder == null || javaScriptContextHolder.get() == 0) {
                    return;
                }
                BlobCollector.nativeInstall(this, javaScriptContextHolder.get());
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeBlobModuleSpec
    public void release(String str) {
        remove(str);
    }

    @DoNotStrip
    public void remove(String str) {
        synchronized (this.mBlobs) {
            this.mBlobs.remove(str);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeBlobModuleSpec
    public void removeWebSocketHandler(double d2) {
        int i2 = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("removeWebSocketHandler");
        if (webSocketModule != null) {
            webSocketModule.setContentHandler(i2, null);
        }
    }

    @Nullable
    public byte[] resolve(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        String queryParameter = uri.getQueryParameter("offset");
        int i2 = queryParameter != null ? Integer.parseInt(queryParameter, 10) : 0;
        String queryParameter2 = uri.getQueryParameter("size");
        return resolve(lastPathSegment, i2, queryParameter2 != null ? Integer.parseInt(queryParameter2, 10) : -1);
    }

    @Override // com.facebook.fbreact.specs.NativeBlobModuleSpec
    public void sendOverSocket(ReadableMap readableMap, double d2) {
        int i2 = (int) d2;
        WebSocketModule webSocketModule = getWebSocketModule("sendOverSocket");
        if (webSocketModule != null) {
            byte[] data = resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size"));
            if (data == null) {
                webSocketModule.sendBinary((ByteString) null, i2);
                return;
            }
            ByteString byteString = ByteString.f56924d;
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
            webSocketModule.sendBinary(new ByteString(bArrCopyOf), i2);
        }
    }

    public String store(byte[] bArr) {
        String string = UUID.randomUUID().toString();
        store(bArr, string);
        return string;
    }

    public void store(byte[] bArr, String str) {
        synchronized (this.mBlobs) {
            this.mBlobs.put(str, bArr);
        }
    }

    @Nullable
    public byte[] resolve(String str, int i2, int i3) {
        synchronized (this.mBlobs) {
            try {
                byte[] bArrCopyOfRange = this.mBlobs.get(str);
                if (bArrCopyOfRange == null) {
                    return null;
                }
                if (i3 == -1) {
                    i3 = bArrCopyOfRange.length - i2;
                }
                if (i2 > 0 || i3 != bArrCopyOfRange.length) {
                    bArrCopyOfRange = Arrays.copyOfRange(bArrCopyOfRange, i2, i3 + i2);
                }
                return bArrCopyOfRange;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public byte[] resolve(ReadableMap readableMap) {
        return resolve(readableMap.getString("blobId"), readableMap.getInt("offset"), readableMap.getInt("size"));
    }
}
