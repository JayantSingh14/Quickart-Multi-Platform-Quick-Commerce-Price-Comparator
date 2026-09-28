package cl.json;

import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import coil3.util.UtilsKt;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class ShareFile {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f13818a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13819b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f13820c;

    /* renamed from: d, reason: collision with root package name */
    public String f13821d;

    /* renamed from: e, reason: collision with root package name */
    public final String f13822e;

    /* renamed from: f, reason: collision with root package name */
    public final Boolean f13823f;

    public ShareFile(String str, String str2, String str3, Boolean bool, ReactApplicationContext reactApplicationContext) {
        this(str, str3, bool, reactApplicationContext);
        this.f13821d = str2;
    }

    public final Uri a() {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String str = this.f13821d;
        if (str == null) {
            str = "*/*";
        }
        String extensionFromMimeType = singleton.getExtensionFromMimeType(str);
        boolean zB = b();
        ReactApplicationContext reactApplicationContext = this.f13818a;
        if (!zB) {
            if (!c()) {
                return null;
            }
            Uri uri = Uri.parse(this.f13819b);
            if (uri.getPath() == null) {
                return null;
            }
            return RNSharePathUtil.a(reactApplicationContext, new File(uri.getPath()));
        }
        String strSubstring = this.f13820c.toString().substring(this.f13821d.length() + 13);
        String str2 = this.f13822e;
        if (str2 == null) {
            str2 = System.nanoTime() + "";
        }
        try {
            File file = new File(this.f13823f.booleanValue() ? reactApplicationContext.getCacheDir() : reactApplicationContext.getExternalCacheDir(), Environment.DIRECTORY_DOWNLOADS);
            if (!file.exists() && !file.mkdirs()) {
                throw new IOException("mkdirs failed on " + file.getAbsolutePath());
            }
            File file2 = new File(file, str2 + CLConstants.DOT_SALT_DELIMETER + extensionFromMimeType);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(Base64.decode(strSubstring, 0));
            fileOutputStream.flush();
            fileOutputStream.close();
            return RNSharePathUtil.a(reactApplicationContext, file2);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final boolean b() {
        Uri uri = this.f13820c;
        if (uri.getScheme() == null || !uri.getScheme().equals("data")) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        for (char c2 : uri.toString().substring(5).toCharArray()) {
            if (c2 == ';') {
                break;
            }
            sb.append(c2);
        }
        this.f13821d = sb.toString();
        return true;
    }

    public final boolean c() {
        Uri uri = this.f13820c;
        if (uri.getScheme() == null) {
            return false;
        }
        if (!uri.getScheme().equals("content") && !uri.getScheme().equals(UtilsKt.SCHEME_FILE)) {
            return false;
        }
        if (this.f13821d == null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
            String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : null;
            this.f13821d = mimeTypeFromExtension;
            if (mimeTypeFromExtension == null) {
                String strC = RNSharePathUtil.c(this.f13818a, uri, this.f13823f);
                if (strC == null) {
                    return false;
                }
                String fileExtensionFromUrl2 = MimeTypeMap.getFileExtensionFromUrl(strC);
                this.f13821d = fileExtensionFromUrl2 != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl2) : null;
            }
            if (this.f13821d == null) {
                this.f13821d = "*/*";
            }
        }
        return true;
    }

    public ShareFile(String str, String str2, Boolean bool, ReactApplicationContext reactApplicationContext) {
        this.f13819b = str;
        this.f13820c = Uri.parse(str);
        this.f13822e = str2;
        this.f13823f = bool;
        this.f13818a = reactApplicationContext;
    }
}
