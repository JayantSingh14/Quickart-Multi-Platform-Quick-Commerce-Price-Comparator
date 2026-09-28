package com.reactnativedocumentpicker;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.brentvatne.react.c;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.util.RNLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes4.dex */
public final class FileOperations {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f46340a;

    public FileOperations(LinkedHashMap uriMap) {
        Intrinsics.checkNotNullParameter(uriMap, "uriMap");
        this.f46340a = uriMap;
    }

    public static final WritableMap a(FileOperations fileOperations, ReadableMap readableMap, ReactApplicationContext reactApplicationContext, File file) throws IOException {
        fileOperations.getClass();
        String string = readableMap.getString("uri");
        if (string == null) {
            throw new IllegalArgumentException("URI is missing");
        }
        String string2 = readableMap.getString("fileName");
        if (string2 == null) {
            throw new IllegalArgumentException("fileName is missing");
        }
        String string3 = readableMap.getString("convertVirtualFileToType");
        Uri uri = (Uri) fileOperations.f46340a.get(string);
        if (uri == null) {
            RNLog.c(reactApplicationContext, "keepLocalCopy: You're trying to copy a file \"" + string2 + "\" that wasn't picked with this module. This can lead to permission errors because the file reference is transient to your activity's current lifecycle. See https://developer.android.com/guide/components/intents-common#GetFile . Please use the result from the picker directly.");
        }
        if (uri == null) {
            uri = Uri.parse(string);
        }
        Intrinsics.c(uri);
        File file2 = new File(file, string2);
        String canonicalPath = file2.getCanonicalPath();
        Intrinsics.c(canonicalPath);
        String canonicalPath2 = file.getCanonicalPath();
        Intrinsics.checkNotNullExpressionValue(canonicalPath2, "getCanonicalPath(...)");
        if (!StringsKt.O(canonicalPath, canonicalPath2, false)) {
            throw new IllegalArgumentException("The copied file is attempting to write outside of the target directory.");
        }
        c cVar = new c(file2, 3);
        if (string3 == null) {
            InputStream inputStreamOpenInputStream = reactApplicationContext.getContentResolver().openInputStream(uri);
            try {
                cVar.invoke(inputStreamOpenInputStream);
                CloseableKt.a(inputStreamOpenInputStream, null);
            } finally {
            }
        } else {
            ContentResolver contentResolver = reactApplicationContext.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            AssetFileDescriptor assetFileDescriptorOpenTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uri, string3, null);
            FileInputStream fileInputStreamCreateInputStream = assetFileDescriptorOpenTypedAssetFileDescriptor != null ? assetFileDescriptorOpenTypedAssetFileDescriptor.createInputStream() : null;
            try {
                cVar.invoke(fileInputStreamCreateInputStream);
                CloseableKt.a(fileInputStreamCreateInputStream, null);
            } finally {
            }
        }
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString(CLConstants.OTP_STATUS, APayConstants.SUCCESS);
        writableMapCreateMap.putString("localUri", Uri.fromFile(file2).toString());
        writableMapCreateMap.putString("sourceUri", string);
        return writableMapCreateMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(com.facebook.react.bridge.ReactApplicationContext r11, com.facebook.react.bridge.ReadableArray r12, com.reactnativedocumentpicker.CopyDestination r13, kotlin.coroutines.jvm.internal.ContinuationImpl r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$1
            if (r0 == 0) goto L13
            r0 = r14
            com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$1 r0 = (com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$1) r0
            int r1 = r0.f46343c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f46343c = r1
            goto L18
        L13:
            com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$1 r0 = new com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.f46341a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f46343c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r14)
            goto L49
        L27:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L2f:
            kotlin.ResultKt.b(r14)
            kotlinx.coroutines.scheduling.DefaultScheduler r14 = kotlinx.coroutines.Dispatchers.f54091a
            kotlinx.coroutines.scheduling.DefaultIoScheduler r14 = kotlinx.coroutines.scheduling.DefaultIoScheduler.f55150b
            com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$2 r4 = new com.reactnativedocumentpicker.FileOperations$copyFilesToLocalStorage$2
            r9 = 0
            r5 = r10
            r6 = r11
            r8 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f46343c = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.e(r14, r4, r0)
            if (r14 != r1) goto L49
            return r1
        L49:
            java.lang.String r11 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativedocumentpicker.FileOperations.b(com.facebook.react.bridge.ReactApplicationContext, com.facebook.react.bridge.ReadableArray, com.reactnativedocumentpicker.CopyDestination, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final DocumentMetadataBuilder c(Uri uri, String str, ReactApplicationContext context) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uri == null) {
            throw new IllegalArgumentException("The source URI is null. Call saveDocument() before writeDocument()");
        }
        Uri uri2 = (Uri) this.f46340a.get(str);
        if (uri2 == null) {
            String message = "writeDocument: You're trying to write from Uri \"" + str + "\" that wasn't picked with this module. Please use the result from saveDocument()";
            Intrinsics.checkNotNullParameter(message, "message");
            RNLog.b(6, context, message);
            FLog.g("ReactNative", message);
            throw new IllegalArgumentException("The provided URI is not known");
        }
        DocumentMetadataBuilder documentMetadataBuilder = new DocumentMetadataBuilder(uri2);
        ContentResolver contentResolver = context.getContentResolver();
        documentMetadataBuilder.f46334d = contentResolver.getType(uri2);
        InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
        try {
            if (inputStreamOpenInputStream == null) {
                documentMetadataBuilder.f46335e = "No output stream found for source file";
            } else {
                OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri2);
                try {
                    if (outputStreamOpenOutputStream == null) {
                        documentMetadataBuilder.f46335e = "No output stream found for destination file";
                    } else {
                        if (ByteStreamsKt.a(inputStreamOpenInputStream, outputStreamOpenOutputStream) == 0) {
                            documentMetadataBuilder.f46335e = "No data was copied to the destination file";
                        }
                        outputStreamOpenOutputStream.flush();
                        Unit unit = Unit.f53572a;
                    }
                    CloseableKt.a(outputStreamOpenOutputStream, null);
                } finally {
                }
            }
            CloseableKt.a(inputStreamOpenInputStream, null);
            return documentMetadataBuilder;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.a(inputStreamOpenInputStream, th);
                throw th2;
            }
        }
    }
}
