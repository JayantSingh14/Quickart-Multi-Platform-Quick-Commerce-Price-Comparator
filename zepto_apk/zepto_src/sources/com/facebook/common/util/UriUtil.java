package com.facebook.common.util;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import coil3.util.UtilsKt;
import com.facebook.infer.annotation.Nullsafe;
import java.net.MalformedURLException;
import java.net.URL;

@Nullsafe
/* loaded from: classes3.dex */
public class UriUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f17148a = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");

    public static String a(ContentResolver contentResolver, Uri uri) {
        Uri uri2;
        String str;
        String[] strArr;
        int columnIndexOrThrow;
        String type = contentResolver.getType(uri);
        String string = null;
        if (!d(uri)) {
            if (e(uri)) {
                return uri.getPath();
            }
            return null;
        }
        boolean z = type != null && type.startsWith("video/");
        if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
            String documentId = DocumentsContract.getDocumentId(uri);
            documentId.getClass();
            Uri uri3 = z ? MediaStore.Video.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            uri3.getClass();
            str = "_id=?";
            uri2 = uri3;
            strArr = new String[]{documentId.split(":")[1]};
        } else {
            uri2 = uri;
            str = null;
            strArr = null;
        }
        Cursor cursorQuery = contentResolver.query(uri2, new String[]{"_data"}, str, strArr, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst() && (columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data")) != -1) {
                    string = cursorQuery.getString(columnIndexOrThrow);
                }
            } finally {
                cursorQuery.close();
            }
        }
        if (cursorQuery != null) {
        }
        return string;
    }

    public static String b(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.getScheme();
    }

    public static Uri c(int i2) {
        return new Uri.Builder().scheme("res").path(String.valueOf(i2)).build();
    }

    public static boolean d(Uri uri) {
        return "content".equals(b(uri));
    }

    public static boolean e(Uri uri) {
        return UtilsKt.SCHEME_FILE.equals(b(uri));
    }

    public static boolean f(Uri uri) {
        String strB = b(uri);
        return "https".equals(strB) || "http".equals(strB);
    }

    public static URL g(Uri uri) {
        if (uri == null) {
            return null;
        }
        try {
            return new URL(uri.toString());
        } catch (MalformedURLException e2) {
            throw new RuntimeException(e2);
        }
    }
}
