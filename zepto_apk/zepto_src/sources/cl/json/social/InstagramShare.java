package cl.json.social;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.media.b;
import android.util.Log;
import cl.json.ShareFile;
import coil3.network.internal.UtilsKt;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.IOException;

/* loaded from: classes3.dex */
public class InstagramShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    public final String b() {
        return null;
    }

    @Override // cl.json.social.ShareIntent
    public final String c() {
        return "com.instagram.android";
    }

    @Override // cl.json.social.ShareIntent
    public final String d() {
        return "https://play.google.com/store/apps/details?id=com.instagram.android";
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public final void f(ReadableMap readableMap) throws PackageManager.NameNotFoundException, IOException {
        super.f(readableMap);
        if (!ShareIntent.e(readableMap, "type")) {
            Log.e("RNShare", "No type provided");
            return;
        }
        String string = readableMap.getString("type");
        if (string.startsWith("text")) {
            this.f13832b.setPackage("com.instagram.android");
            this.f13832b.setType(UtilsKt.MIME_TYPE_TEXT_PLAIN);
            this.f13832b.setAction("android.intent.action.SEND");
            g(null);
            return;
        }
        if (!ShareIntent.e(readableMap, "url")) {
            Log.e("RNShare", "No url provided");
            return;
        }
        String string2 = readableMap.getString("url");
        if (string2.startsWith("instagram://")) {
            Uri uri = Uri.parse(string2);
            this.f13832b.setAction("android.intent.action.VIEW");
            this.f13832b.setData(uri);
            g(null);
            return;
        }
        String[] strArrSplit = string.split("/");
        String str = strArrSplit[strArrSplit.length - 1];
        boolean zStartsWith = string.startsWith("image");
        String str2 = this.f13833c;
        Boolean boolValueOf = Boolean.valueOf(ShareIntent.e(this.f13835e, "useInternalStorage") && this.f13835e.getBoolean("useInternalStorage"));
        Uri uriA = (zStartsWith ? new ShareFile(string2, b.C("image/", str), "image", boolValueOf, this.f13831a) : new ShareFile(string2, b.C("video/", str), "video", boolValueOf, this.f13831a)).a();
        Intent intent = new Intent("android.intent.action.SEND");
        if (zStartsWith) {
            intent.setType("image/*");
        } else {
            intent.setType("video/*");
        }
        intent.putExtra("android.intent.extra.STREAM", uriA);
        intent.setPackage("com.instagram.android");
        Intent intent2 = new Intent("com.instagram.share.ADD_TO_STORY");
        intent2.setDataAndType(uriA, str);
        intent2.addFlags(1);
        intent2.setPackage("com.instagram.android");
        Intent intentCreateChooser = Intent.createChooser(intent, str2);
        intentCreateChooser.addFlags(268435456);
        intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[]{intent2});
        ReactApplicationContext reactApplicationContext = this.f13831a;
        reactApplicationContext.getCurrentActivity().grantUriPermission("com.instagram.android", uriA, 1);
        reactApplicationContext.startActivity(intentCreateChooser);
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putBoolean(APayConstants.SUCCESS, true);
        writableMapCreateMap.putString(APayConstants.Error.MESSAGE, this.f13832b.getPackage());
        TargetChosenReceiver.b(writableMapCreateMap);
    }
}
