package cl.json.social;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.MimeTypeMap;
import cl.json.RNSharePathUtil;
import cl.json.ShareFile;
import cl.json.ShareFiles;
import coil3.network.internal.UtilsKt;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.common.Scopes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public abstract class ShareIntent {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f13831a;

    /* renamed from: b, reason: collision with root package name */
    public Intent f13832b;

    /* renamed from: c, reason: collision with root package name */
    public String f13833c = "Share";

    /* renamed from: d, reason: collision with root package name */
    public ShareFile f13834d;

    /* renamed from: e, reason: collision with root package name */
    public ReadableMap f13835e;

    /* renamed from: cl.json.social.ShareIntent$1, reason: invalid class name */
    class AnonymousClass1 implements Comparator<HashMap<String, String>> {
        @Override // java.util.Comparator
        public final int compare(HashMap<String, String> map, HashMap<String, String> map2) {
            return map.get("simpleName").compareTo(map2.get("simpleName"));
        }
    }

    public ShareIntent(ReactApplicationContext reactApplicationContext) {
        this.f13831a = reactApplicationContext;
        Intent intent = new Intent("android.intent.action.SEND");
        this.f13832b = intent;
        intent.setType(UtilsKt.MIME_TYPE_TEXT_PLAIN);
    }

    public static boolean e(ReadableMap readableMap, String str) {
        return (readableMap == null || !readableMap.hasKey(str) || readableMap.isNull(str)) ? false : true;
    }

    public String a() {
        return null;
    }

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public void f(ReadableMap readableMap) throws IOException {
        ShareFiles shareFiles;
        ArrayList arrayList;
        ReactApplicationContext reactApplicationContext;
        String string;
        this.f13835e = readableMap;
        if (e(readableMap, "isNewTask") && readableMap.getBoolean("isNewTask")) {
            this.f13832b.addFlags(268468224);
        }
        if (e(readableMap, "subject")) {
            this.f13832b.putExtra("android.intent.extra.SUBJECT", readableMap.getString("subject"));
        }
        if (e(readableMap, Scopes.EMAIL)) {
            this.f13832b.putExtra("android.intent.extra.EMAIL", new String[]{readableMap.getString(Scopes.EMAIL)});
        }
        if (e(readableMap, "title")) {
            this.f13833c = readableMap.getString("title");
        }
        String string2 = e(readableMap, APayConstants.Error.MESSAGE) ? readableMap.getString(APayConstants.Error.MESSAGE) : "";
        String string3 = e(readableMap, "social") ? readableMap.getString("social") : "";
        if (string3.equals("sms")) {
            String string4 = readableMap.getString("recipient");
            if (!string4.isEmpty()) {
                this.f13832b.putExtra("address", string4);
            }
        }
        if (string3.equals("whatsapp") && readableMap.hasKey("whatsAppNumber")) {
            this.f13832b.putExtra("jid", b.k(readableMap.getString("whatsAppNumber"), "@s.whatsapp.net"));
        }
        if (string3.equals("whatsappbusiness") && readableMap.hasKey("whatsAppNumber")) {
            this.f13832b.putExtra("jid", b.k(readableMap.getString("whatsAppNumber"), "@s.whatsapp.net"));
        }
        boolean zE = e(readableMap, "urls");
        ReactApplicationContext reactApplicationContext2 = this.f13831a;
        int i2 = 0;
        if (!zE) {
            if (!e(readableMap, "url")) {
                if (TextUtils.isEmpty(string2)) {
                    return;
                }
                this.f13832b.putExtra("android.intent.extra.TEXT", string2);
                return;
            }
            String string5 = e(readableMap, "filename") ? readableMap.getString("filename") : null;
            Boolean boolValueOf = Boolean.FALSE;
            if (e(readableMap, "useInternalStorage")) {
                boolValueOf = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
            }
            Boolean bool = boolValueOf;
            ShareFile shareFile = e(readableMap, "type") ? new ShareFile(readableMap.getString("url"), readableMap.getString("type"), string5, bool, this.f13831a) : new ShareFile(readableMap.getString("url"), string5, bool, reactApplicationContext2);
            this.f13834d = shareFile;
            if (!(shareFile.b() || shareFile.c())) {
                if (TextUtils.isEmpty(string2)) {
                    this.f13832b.putExtra("android.intent.extra.TEXT", readableMap.getString("url"));
                    return;
                }
                Intent intent = this.f13832b;
                StringBuilder sbX = b.x(string2, StringUtils.SPACE);
                sbX.append(readableMap.getString("url"));
                intent.putExtra("android.intent.extra.TEXT", sbX.toString());
                return;
            }
            Uri uriA = this.f13834d.a();
            ClipData clipDataNewUri = ClipData.newUri(reactApplicationContext2.getContentResolver(), "File", uriA);
            Intent intent2 = this.f13832b;
            String str = this.f13834d.f13821d;
            intent2.setType(str != null ? str : "*/*");
            this.f13832b.setClipData(clipDataNewUri);
            this.f13832b.putExtra("android.intent.extra.STREAM", uriA);
            this.f13832b.addFlags(1);
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            this.f13832b.putExtra("android.intent.extra.TEXT", string2);
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (e(readableMap, "filenames")) {
            ReadableArray array = readableMap.getArray("filenames");
            for (int i3 = 0; i3 < array.size(); i3++) {
                arrayList2.add(array.getString(i3));
            }
        }
        Boolean boolValueOf2 = Boolean.FALSE;
        if (e(readableMap, "useInternalStorage")) {
            boolValueOf2 = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
        }
        if (e(readableMap, "type")) {
            ReadableArray array2 = readableMap.getArray("urls");
            String string6 = readableMap.getString("type");
            shareFiles = new ShareFiles(array2, arrayList2, boolValueOf2, reactApplicationContext2);
            shareFiles.f13827d = string6;
        } else {
            shareFiles = new ShareFiles(readableMap.getArray("urls"), arrayList2, boolValueOf2, reactApplicationContext2);
        }
        ArrayList arrayList3 = shareFiles.f13825b;
        Iterator it = arrayList3.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            z = shareFiles.a(uri) || shareFiles.b(uri);
            if (!z) {
                break;
            }
        }
        if (!z) {
            if (TextUtils.isEmpty(string2)) {
                this.f13832b.putExtra("android.intent.extra.TEXT", readableMap.getArray("urls").getString(0));
                return;
            }
            Intent intent3 = this.f13832b;
            StringBuilder sbX2 = b.x(string2, StringUtils.SPACE);
            sbX2.append(readableMap.getArray("urls").getString(0));
            intent3.putExtra("android.intent.extra.TEXT", sbX2.toString());
            return;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        ArrayList<? extends Parcelable> arrayList4 = new ArrayList<>();
        int i4 = 0;
        while (i4 < arrayList3.size()) {
            Uri uri2 = (Uri) arrayList3.get(i4);
            boolean zA = shareFiles.a(uri2);
            ArrayList arrayList5 = shareFiles.f13826c;
            ReactApplicationContext reactApplicationContext3 = shareFiles.f13824a;
            if (zA) {
                arrayList = arrayList3;
                String extensionFromMimeType = singleton.getExtensionFromMimeType(uri2.getSchemeSpecificPart().substring(i2, uri2.getSchemeSpecificPart().indexOf(";")));
                String strSubstring = uri2.getSchemeSpecificPart().substring(uri2.getSchemeSpecificPart().indexOf(";base64,") + 8);
                if (arrayList5.size() >= i4 + 1) {
                    string = (String) arrayList5.get(i4);
                    reactApplicationContext = reactApplicationContext3;
                } else {
                    StringBuilder sb = new StringBuilder();
                    reactApplicationContext = reactApplicationContext3;
                    sb.append(System.currentTimeMillis());
                    sb.append(CLConstants.DOT_SALT_DELIMETER);
                    sb.append(extensionFromMimeType);
                    string = sb.toString();
                }
                try {
                    File file = new File(shareFiles.f13828e.booleanValue() ? reactApplicationContext.getCacheDir() : reactApplicationContext.getExternalCacheDir(), Environment.DIRECTORY_DOWNLOADS);
                    if (!file.exists() && !file.mkdirs()) {
                        throw new IOException("mkdirs failed on " + file.getAbsolutePath());
                    }
                    File file2 = new File(file, string);
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    fileOutputStream.write(Base64.decode(strSubstring, 0));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    arrayList4.add(RNSharePathUtil.a(reactApplicationContext, file2));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else {
                arrayList = arrayList3;
                if (shareFiles.b(uri2) && uri2.getPath() != null) {
                    if (arrayList5.size() >= i4 + 1) {
                        arrayList4.add(RNSharePathUtil.a(reactApplicationContext3, new File(uri2.getPath(), (String) arrayList5.get(i4))));
                    } else {
                        arrayList4.add(RNSharePathUtil.a(reactApplicationContext3, new File(uri2.getPath())));
                    }
                }
            }
            i4++;
            arrayList3 = arrayList;
            i2 = 0;
        }
        String str2 = shareFiles.f13827d;
        if (str2 == null) {
            str2 = "*/*";
        }
        ClipData clipData = new ClipData(new ClipDescription("Files", new String[]{str2}), new ClipData.Item((Uri) arrayList4.get(0)));
        for (int i5 = 1; i5 < arrayList4.size(); i5++) {
            clipData.addItem(new ClipData.Item((Uri) arrayList4.get(i5)));
        }
        this.f13832b.setClipData(clipData);
        this.f13832b.setAction("android.intent.action.SEND_MULTIPLE");
        Intent intent4 = this.f13832b;
        String str3 = shareFiles.f13827d;
        intent4.setType(str3 != null ? str3 : "*/*");
        this.f13832b.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList4);
        this.f13832b.addFlags(1);
        if (TextUtils.isEmpty(string2)) {
            return;
        }
        this.f13832b.putExtra("android.intent.extra.TEXT", string2);
    }
}
