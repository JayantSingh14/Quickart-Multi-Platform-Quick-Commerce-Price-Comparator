package com.facebook.react.modules.camera;

import android.net.Uri;
import android.util.Base64OutputStream;
import androidx.media3.exoplayer.source.h;
import com.facebook.fbreact.specs.NativeImageStoreAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = "ImageStoreManager")
@Metadata
/* loaded from: classes.dex */
public final class ImageStoreManager extends NativeImageStoreAndroidSpec {
    private static final int BUFFER_SIZE = 8192;

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "ImageStoreManager";

    @Metadata
    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final void a(Companion companion, InputStream inputStream) throws IOException {
            companion.getClass();
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }

        public static String b(InputStream inputStream) throws IOException {
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 2);
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 > -1) {
                        base64OutputStream.write(bArr, 0, i2);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } finally {
                    try {
                        base64OutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            }
            String string = byteArrayOutputStream.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageStoreManager(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getBase64ForTag$lambda$0(ImageStoreManager imageStoreManager, String str, Callback callback, Callback callback2) throws IOException {
        try {
            InputStream inputStreamOpenInputStream = imageStoreManager.getReactApplicationContext().getContentResolver().openInputStream(Uri.parse(str));
            Intrinsics.d(inputStreamOpenInputStream, "null cannot be cast to non-null type java.io.InputStream");
            try {
                try {
                    Companion companion = Companion;
                    companion.getClass();
                    callback.invoke(Companion.b(inputStreamOpenInputStream));
                    Companion.a(companion, inputStreamOpenInputStream);
                } catch (Throwable th) {
                    Companion.a(Companion, inputStreamOpenInputStream);
                    throw th;
                }
            } catch (IOException e2) {
                callback2.invoke(e2.getMessage());
                Companion.a(Companion, inputStreamOpenInputStream);
            }
        } catch (FileNotFoundException e3) {
            callback2.invoke(e3.getMessage());
        }
    }

    @Override // com.facebook.fbreact.specs.NativeImageStoreAndroidSpec
    public void getBase64ForTag(@NotNull String uri, @NotNull Callback success, @NotNull Callback error) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(error, "error");
        Executors.newSingleThreadExecutor().execute(new h(this, uri, success, error, 4));
    }
}
