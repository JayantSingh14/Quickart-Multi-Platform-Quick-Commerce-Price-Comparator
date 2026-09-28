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
public class FacebookStoriesShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    public final String b() {
        return null;
    }

    @Override // cl.json.social.ShareIntent
    public final String c() {
        return "com.facebook.katana";
    }

    @Override // cl.json.social.ShareIntent
    public final String d() {
        return "market://details?id=com.facebook.katana";
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public final void f(ReadableMap readableMap) throws PackageManager.NameNotFoundException, IOException {
        super.f(readableMap);
        if (!ShareIntent.e(readableMap, CLConstants.SALT_FIELD_APP_ID)) {
            throw new IllegalArgumentException("appId was not provided.");
        }
        if (!ShareIntent.e(readableMap, "backgroundImage") && !ShareIntent.e(readableMap, "backgroundVideo") && !ShareIntent.e(readableMap, "stickerImage")) {
            throw new IllegalArgumentException("Invalid background or sticker assets provided.");
        }
        Activity currentActivity = this.f13831a.getCurrentActivity();
        if (currentActivity == null) {
            TargetChosenReceiver.a("Something went wrong");
        } else {
            this.f13832b.putExtra("com.facebook.platform.extra.APPLICATION_ID", readableMap.getString(CLConstants.SALT_FIELD_APP_ID));
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
            boolean z = ShareIntent.e(readableMap, "backgroundImage") || ShareIntent.e(readableMap, "backgroundVideo");
            if (z) {
                ShareFile shareFile = new ShareFile(ShareIntent.e(readableMap, "backgroundImage") ? readableMap.getString("backgroundImage") : ShareIntent.e(readableMap, "backgroundVideo") ? readableMap.getString("backgroundVideo") : "", "image/jpeg", AppStateModule.APP_STATE_BACKGROUND, bool, this.f13831a);
                Intent intent = this.f13832b;
                Uri uriA = shareFile.a();
                String str = shareFile.f13821d;
                if (str == null) {
                    str = "*/*";
                }
                intent.setDataAndType(uriA, str);
                this.f13832b.setFlags(1);
            }
            if (ShareIntent.e(readableMap, "stickerImage")) {
                ShareFile shareFile2 = new ShareFile(readableMap.getString("stickerImage"), ClipboardModule.MIMETYPE_PNG, "sticker", bool, this.f13831a);
                if (!z) {
                    this.f13832b.setType("image/*");
                }
                this.f13832b.putExtra("interactive_asset_uri", shareFile2.a());
                currentActivity.grantUriPermission("com.facebook.katana", shareFile2.a(), 1);
            }
        }
        g(readableMap);
    }
}
