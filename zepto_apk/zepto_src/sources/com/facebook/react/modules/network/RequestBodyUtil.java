package com.facebook.react.modules.network;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* loaded from: classes.dex */
class RequestBodyUtil {

    /* renamed from: com.facebook.react.modules.network.RequestBodyUtil$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 extends RequestBody {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaType f19157a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InputStream f19158b;

        public AnonymousClass1(MediaType mediaType, InputStream inputStream) {
            this.f19157a = mediaType;
            this.f19158b = inputStream;
        }

        @Override // okhttp3.RequestBody
        public final long contentLength() {
            try {
                return this.f19158b.available();
            } catch (IOException unused) {
                return 0L;
            }
        }

        @Override // okhttp3.RequestBody
        public final MediaType contentType() {
            return this.f19157a;
        }

        @Override // okhttp3.RequestBody
        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            Source sourceM = null;
            try {
                sourceM = Okio.m(this.f19158b);
                bufferedSink.g0(sourceM);
                try {
                    sourceM.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    sourceM.close();
                } catch (RuntimeException e3) {
                    throw e3;
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
    }

    public static FileInputStream a(ReactApplicationContext reactApplicationContext, Uri uri) throws IOException {
        File fileCreateTempFile = File.createTempFile("RequestBodyUtil", "temp", reactApplicationContext.getApplicationContext().getCacheDir());
        fileCreateTempFile.deleteOnExit();
        URL url = new URL(uri.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
        try {
            InputStream inputStreamOpenStream = url.openStream();
            try {
                ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(inputStreamOpenStream);
                try {
                    fileOutputStream.getChannel().transferFrom(readableByteChannelNewChannel, 0L, Long.MAX_VALUE);
                    FileInputStream fileInputStream = new FileInputStream(fileCreateTempFile);
                    if (readableByteChannelNewChannel != null) {
                        readableByteChannelNewChannel.close();
                    }
                    if (inputStreamOpenStream != null) {
                        inputStreamOpenStream.close();
                    }
                    fileOutputStream.close();
                    return fileInputStream;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public static RequestBody b(String str) {
        if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH")) {
            return RequestBody.create((MediaType) null, ByteString.f56924d);
        }
        return null;
    }

    public static InputStream c(ReactApplicationContext reactApplicationContext, String str) {
        try {
            Uri uri = Uri.parse(str);
            return uri.getScheme().startsWith("http") ? a(reactApplicationContext, uri) : str.startsWith("data:") ? new ByteArrayInputStream(Base64.decode(str.split(",")[1], 0)) : reactApplicationContext.getContentResolver().openInputStream(uri);
        } catch (Exception e2) {
            FLog.h("ReactNative", "Could not retrieve file for contentUri " + str, e2);
            return null;
        }
    }
}
