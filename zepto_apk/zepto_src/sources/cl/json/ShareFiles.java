package cl.json;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import coil3.util.UtilsKt;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ShareFiles {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f13824a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13825b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13826c;

    /* renamed from: d, reason: collision with root package name */
    public String f13827d;

    /* renamed from: e, reason: collision with root package name */
    public final Boolean f13828e;

    public ShareFiles(ReadableArray readableArray, ArrayList arrayList, Boolean bool, ReactApplicationContext reactApplicationContext) {
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            String string = readableArray.getString(i2);
            if (string != null) {
                this.f13825b.add(Uri.parse(string));
            }
        }
        this.f13826c = arrayList;
        this.f13828e = bool;
        this.f13824a = reactApplicationContext;
    }

    public final boolean a(Uri uri) {
        if (uri.getScheme() == null || !uri.getScheme().equals("data")) {
            return false;
        }
        String strSubstring = uri.getSchemeSpecificPart().substring(0, uri.getSchemeSpecificPart().indexOf(";"));
        String str = this.f13827d;
        if (str == null) {
            this.f13827d = strSubstring;
            return true;
        }
        if (!str.equalsIgnoreCase(strSubstring) && this.f13827d.split("/")[0].equalsIgnoreCase(strSubstring.split("/")[0])) {
            this.f13827d = this.f13827d.split("/")[0].concat("/*");
            return true;
        }
        if (this.f13827d.equalsIgnoreCase(strSubstring)) {
            return true;
        }
        this.f13827d = "*/*";
        return true;
    }

    public final boolean b(Uri uri) {
        if ((uri.getScheme() == null || !uri.getScheme().equals("content")) && !UtilsKt.SCHEME_FILE.equals(uri.getScheme())) {
            return false;
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl) : null;
        if (mimeTypeFromExtension == null) {
            String fileExtensionFromUrl2 = MimeTypeMap.getFileExtensionFromUrl(RNSharePathUtil.c(this.f13824a, uri, this.f13828e));
            mimeTypeFromExtension = fileExtensionFromUrl2 != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl2) : null;
        }
        if (mimeTypeFromExtension == null) {
            mimeTypeFromExtension = "*/*";
        }
        String str = this.f13827d;
        if (str == null) {
            this.f13827d = mimeTypeFromExtension;
            return true;
        }
        if (!str.equalsIgnoreCase(mimeTypeFromExtension) && this.f13827d.split("/")[0].equalsIgnoreCase(mimeTypeFromExtension.split("/")[0])) {
            this.f13827d = this.f13827d.split("/")[0].concat("/*");
            return true;
        }
        if (this.f13827d.equalsIgnoreCase(mimeTypeFromExtension)) {
            return true;
        }
        this.f13827d = "*/*";
        return true;
    }
}
