package com.ReactNativeBlobUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.media.b;
import android.webkit.MimeTypeMap;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import java.io.File;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class ReactNativeBlobUtilMediaCollection {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class MediaType {

        /* renamed from: a, reason: collision with root package name */
        public static final MediaType f13962a;

        /* renamed from: b, reason: collision with root package name */
        public static final MediaType f13963b;

        /* renamed from: c, reason: collision with root package name */
        public static final MediaType f13964c;

        /* renamed from: d, reason: collision with root package name */
        public static final MediaType f13965d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ MediaType[] f13966e;

        static {
            MediaType mediaType = new MediaType("Audio", 0);
            f13962a = mediaType;
            MediaType mediaType2 = new MediaType("Image", 1);
            f13963b = mediaType2;
            MediaType mediaType3 = new MediaType("Video", 2);
            f13964c = mediaType3;
            MediaType mediaType4 = new MediaType("Download", 3);
            f13965d = mediaType4;
            f13966e = new MediaType[]{mediaType, mediaType2, mediaType3, mediaType4};
        }

        public static MediaType valueOf(String str) {
            return (MediaType) Enum.valueOf(MediaType.class, str);
        }

        public static MediaType[] values() {
            return (MediaType[]) f13966e.clone();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0099 -> B:70:0x00cf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.net.Uri r6, java.lang.String r7, com.facebook.react.bridge.Promise r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.a(android.net.Uri, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    public static Uri b(FileDescription fileDescription, MediaType mediaType) throws IOException {
        ContentResolver contentResolver = ReactNativeBlobUtilImpl.f13918b.getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        int i2 = Build.VERSION.SDK_INT;
        MediaType mediaType2 = MediaType.f13965d;
        MediaType mediaType3 = MediaType.f13963b;
        MediaType mediaType4 = MediaType.f13964c;
        MediaType mediaType5 = MediaType.f13962a;
        String string = i2 >= 29 ? mediaType == mediaType5 ? Environment.DIRECTORY_MUSIC : mediaType == mediaType4 ? Environment.DIRECTORY_MOVIES : mediaType == mediaType3 ? Environment.DIRECTORY_PICTURES : mediaType == mediaType2 ? Environment.DIRECTORY_DOWNLOADS : Environment.DIRECTORY_DOWNLOADS : mediaType == mediaType5 ? ReactNativeBlobUtilFS.c().get("LegacyMusicDir").toString() : mediaType == mediaType4 ? ReactNativeBlobUtilFS.c().get("LegacyMovieDir").toString() : mediaType == mediaType3 ? ReactNativeBlobUtilFS.c().get("LegacyPictureDir").toString() : mediaType == mediaType2 ? ReactNativeBlobUtilFS.c().get("LegacyDownloadDir").toString() : ReactNativeBlobUtilFS.c().get("LegacyDownloadDir").toString();
        String str = fileDescription.f14023c;
        String str2 = fileDescription.f14022b;
        String strL = fileDescription.f14021a;
        Uri contentUri = null;
        if (i2 >= 29) {
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("mime_type", str);
            contentValues.put("_display_name", strL);
            contentValues.put("relative_path", string + '/' + str2);
            if (mediaType == mediaType5) {
                contentUri = i2 >= 29 ? MediaStore.Audio.Media.getContentUri("external_primary") : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            } else if (mediaType == mediaType4) {
                contentUri = i2 >= 29 ? MediaStore.Video.Media.getContentUri("external_primary") : MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if (mediaType == mediaType3) {
                contentUri = i2 >= 29 ? MediaStore.Images.Media.getContentUri("external_primary") : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if (mediaType == mediaType2 && i2 >= 29) {
                contentUri = MediaStore.Downloads.getContentUri("external_primary");
            }
            return contentResolver.insert(contentUri, contentValues);
        }
        StringBuilder sbW = b.w(string);
        StringBuilder sbX = b.x(str2, "/");
        String str3 = fileDescription.f14023c;
        String extensionFromMimeType = str3 != null ? str3.equals("application/octet-stream") ? "bin" : MimeTypeMap.getSingleton().getExtensionFromMimeType(str3) : "";
        if (extensionFromMimeType != null && !extensionFromMimeType.isEmpty() && !strL.endsWith(CLConstants.DOT_SALT_DELIMETER.concat(extensionFromMimeType))) {
            strL = b.l(strL, CLConstants.DOT_SALT_DELIMETER, extensionFromMimeType);
            if (strL.endsWith(CLConstants.DOT_SALT_DELIMETER)) {
                strL = StringUtils.stripEnd(strL, CLConstants.DOT_SALT_DELIMETER);
            }
        }
        sbX.append(strL);
        sbW.append(sbX.toString());
        File file = new File(sbW.toString());
        if (file.exists()) {
            return Uri.fromFile(file);
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            try {
                file.createNewFile();
                return Uri.fromFile(file);
            } catch (IOException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.net.Uri r5, java.lang.String r6, com.facebook.react.bridge.Promise r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "Read only "
            com.facebook.react.bridge.ReactApplicationContext r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.f13918b
            android.content.Context r1 = r1.getApplicationContext()
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.io.InputStream r5 = r1.openInputStream(r5)     // Catch: java.io.IOException -> L8b
            int r1 = r5.available()     // Catch: java.io.IOException -> L8b
            byte[] r2 = new byte[r1]     // Catch: java.io.IOException -> L8b
            int r3 = r5.read(r2)     // Catch: java.io.IOException -> L8b
            r5.close()     // Catch: java.io.IOException -> L8b
            if (r3 >= r1) goto L39
            java.lang.String r5 = "EUNSPECIFIED"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L8b
            r6.<init>(r0)     // Catch: java.io.IOException -> L8b
            r6.append(r3)     // Catch: java.io.IOException -> L8b
            java.lang.String r0 = " bytes of "
            r6.append(r0)     // Catch: java.io.IOException -> L8b
            r6.append(r1)     // Catch: java.io.IOException -> L8b
            java.lang.String r6 = r6.toString()     // Catch: java.io.IOException -> L8b
            r7.reject(r5, r6)     // Catch: java.io.IOException -> L8b
            return
        L39:
            java.lang.String r5 = r6.toLowerCase()     // Catch: java.io.IOException -> L8b
            int r6 = r5.hashCode()     // Catch: java.io.IOException -> L8b
            r0 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
            r3 = 0
            r4 = 1
            if (r6 == r0) goto L58
            r0 = 93106001(0x58caf51, float:1.3229938E-35)
            if (r6 == r0) goto L4e
            goto L62
        L4e:
            java.lang.String r6 = "ascii"
            boolean r5 = r5.equals(r6)     // Catch: java.io.IOException -> L8b
            if (r5 == 0) goto L62
            r5 = r4
            goto L63
        L58:
            java.lang.String r6 = "base64"
            boolean r5 = r5.equals(r6)     // Catch: java.io.IOException -> L8b
            if (r5 == 0) goto L62
            r5 = r3
            goto L63
        L62:
            r5 = -1
        L63:
            if (r5 == 0) goto L82
            if (r5 == r4) goto L70
            java.lang.String r5 = new java.lang.String     // Catch: java.io.IOException -> L8b
            r5.<init>(r2)     // Catch: java.io.IOException -> L8b
            r7.resolve(r5)     // Catch: java.io.IOException -> L8b
            return
        L70:
            com.facebook.react.bridge.WritableArray r5 = com.facebook.react.bridge.Arguments.createArray()     // Catch: java.io.IOException -> L8b
        L74:
            if (r3 >= r1) goto L7e
            r6 = r2[r3]     // Catch: java.io.IOException -> L8b
            r5.pushInt(r6)     // Catch: java.io.IOException -> L8b
            int r3 = r3 + 1
            goto L74
        L7e:
            r7.resolve(r5)     // Catch: java.io.IOException -> L8b
            return
        L82:
            r5 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r2, r5)     // Catch: java.io.IOException -> L8b
            r7.resolve(r5)     // Catch: java.io.IOException -> L8b
            return
        L8b:
            r5 = move-exception
            r5.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.c(android.net.Uri, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00be A[Catch: IOException -> 0x00c2, TryCatch #7 {IOException -> 0x00c2, blocks: (B:4:0x000f, B:24:0x0081, B:30:0x008b, B:43:0x00be, B:44:0x00c1, B:40:0x00b8), top: B:96:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean d(android.net.Uri r9, java.lang.String r10, boolean r11, com.facebook.react.bridge.Promise r12, com.facebook.react.bridge.ReactApplicationContext r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.d(android.net.Uri, java.lang.String, boolean, com.facebook.react.bridge.Promise, com.facebook.react.bridge.ReactApplicationContext):boolean");
    }
}
