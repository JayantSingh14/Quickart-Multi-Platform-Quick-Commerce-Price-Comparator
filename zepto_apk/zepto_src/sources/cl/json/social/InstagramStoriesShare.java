package cl.json.social;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import cl.json.ShareFile;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.appstate.AppStateModule;
import com.reactnativecommunity.clipboard.ClipboardModule;
import java.io.IOException;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class InstagramStoriesShare extends SingleShareIntent {
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
        String string;
        super.f(readableMap);
        if (!ShareIntent.e(readableMap, "backgroundImage") && !ShareIntent.e(readableMap, "backgroundVideo") && !ShareIntent.e(readableMap, "stickerImage")) {
            throw new IllegalArgumentException("Invalid background or sticker assets provided.");
        }
        Activity currentActivity = this.f13831a.getCurrentActivity();
        if (currentActivity == null) {
            TargetChosenReceiver.a("Something went wrong");
        } else {
            this.f13832b.putExtra("source_application", readableMap.getString(CLConstants.SALT_FIELD_APP_ID));
            this.f13832b.putExtra("bottom_background_color", "#906df4");
            this.f13832b.putExtra("top_background_color", "#837DF4");
            if (ShareIntent.e(readableMap, "attributionURL")) {
                this.f13832b.putExtra("content_url", readableMap.getString("attributionURL"));
            }
            if (ShareIntent.e(readableMap, "backgroundTopColor")) {
                this.f13832b.putExtra("top_background_color", readableMap.getString("backgroundTopColor"));
            }
            if (ShareIntent.e(readableMap, "backgroundBottomColor")) {
                this.f13832b.putExtra("bottom_background_color", readableMap.getString("backgroundBottomColor"));
            }
            Boolean boolValueOf = Boolean.FALSE;
            if (ShareIntent.e(readableMap, "useInternalStorage")) {
                boolValueOf = Boolean.valueOf(readableMap.getBoolean("useInternalStorage"));
            }
            Boolean bool = boolValueOf;
            if (ShareIntent.e(readableMap, "linkUrl")) {
                this.f13832b.putExtra("link_url", readableMap.getString("linkUrl"));
            }
            if (ShareIntent.e(readableMap, "linkText")) {
                this.f13832b.putExtra("link_text", readableMap.getString("linkText"));
            }
            boolean z = ShareIntent.e(readableMap, "backgroundImage") || ShareIntent.e(readableMap, "backgroundVideo");
            if (z) {
                String str = "image/jpeg";
                if (ShareIntent.e(readableMap, "backgroundImage")) {
                    string = readableMap.getString("backgroundImage");
                } else if (ShareIntent.e(readableMap, "backgroundVideo")) {
                    string = readableMap.getString("backgroundVideo");
                    str = "video/*";
                } else {
                    string = "";
                }
                ShareFile shareFile = new ShareFile(string, str, AppStateModule.APP_STATE_BACKGROUND, bool, this.f13831a);
                Intent intent = this.f13832b;
                Uri uriA = shareFile.a();
                String str2 = shareFile.f13821d;
                if (str2 == null) {
                    str2 = "*/*";
                }
                intent.setDataAndType(uriA, str2);
                this.f13832b.setFlags(1);
            }
            if (ShareIntent.e(readableMap, "stickerImage")) {
                ShareFile shareFile2 = new ShareFile(readableMap.getString("stickerImage"), ClipboardModule.MIMETYPE_PNG, "sticker", bool, this.f13831a);
                if (!z) {
                    this.f13832b.setType("image/*");
                }
                this.f13832b.putExtra("interactive_asset_uri", shareFile2.a());
                currentActivity.grantUriPermission("com.instagram.android", shareFile2.a(), 1);
            }
        }
        g(readableMap);
    }
}
