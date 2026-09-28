package cl.json.social;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GenericShare extends ShareIntent {
    @Override // cl.json.social.ShareIntent
    public final void f(ReadableMap readableMap) throws IOException {
        ComponentName[] componentNameArr;
        super.f(readableMap);
        ReactApplicationContext reactApplicationContext = this.f13831a;
        Activity currentActivity = reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            TargetChosenReceiver.a("Something went wrong");
            return;
        }
        IntentSender intentSenderC = TargetChosenReceiver.c(reactApplicationContext);
        Intent intentCreateChooser = Intent.createChooser(this.f13832b, this.f13833c, intentSenderC);
        intentCreateChooser.addFlags(1073741824);
        if (ShareIntent.e(this.f13835e, "showAppsToView") && ShareIntent.e(this.f13835e, "url")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            String str = this.f13834d.f13821d;
            if (str == null) {
                str = "*/*";
            }
            intent.setType(str);
            Uri uriA = this.f13834d.a();
            List<ResolveInfo> listQueryIntentActivities = reactApplicationContext.getPackageManager().queryIntentActivities(intent, 0);
            Intent[] intentArr = new Intent[listQueryIntentActivities.size()];
            for (int i2 = 0; i2 < listQueryIntentActivities.size(); i2++) {
                ResolveInfo resolveInfo = listQueryIntentActivities.get(i2);
                String str2 = resolveInfo.activityInfo.packageName;
                Intent intent2 = new Intent();
                intent2.setComponent(new ComponentName(str2, resolveInfo.activityInfo.name));
                intent2.setAction("android.intent.action.VIEW");
                intent2.setDataAndType(uriA, intent.getType());
                intent2.addFlags(1);
                intentArr[i2] = new Intent(intent2);
            }
            intentCreateChooser.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
        }
        if (ShareIntent.e(this.f13835e, "excludedActivityTypes")) {
            ReadableArray array = this.f13835e.getArray("excludedActivityTypes");
            if (array == null) {
                componentNameArr = null;
            } else {
                Intent intent3 = new Intent(this.f13832b.getAction());
                intent3.setType(this.f13832b.getType());
                ArrayList arrayList = new ArrayList();
                List<ResolveInfo> listQueryIntentActivities2 = reactApplicationContext.getPackageManager().queryIntentActivities(intent3, 0);
                for (int i3 = 0; i3 < array.size(); i3++) {
                    String string = array.getString(i3);
                    for (ResolveInfo resolveInfo2 : listQueryIntentActivities2) {
                        if (resolveInfo2.activityInfo.packageName.equals(string)) {
                            ActivityInfo activityInfo = resolveInfo2.activityInfo;
                            arrayList.add(new ComponentName(activityInfo.packageName, activityInfo.name));
                        }
                    }
                }
                componentNameArr = (ComponentName[]) arrayList.toArray(new ComponentName[0]);
            }
            intentCreateChooser.putExtra("android.intent.extra.EXCLUDE_COMPONENTS", componentNameArr);
            currentActivity.startActivityForResult(intentCreateChooser, 16845);
        } else {
            currentActivity.startActivityForResult(intentCreateChooser, 16845);
        }
        if (intentSenderC == null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putBoolean(APayConstants.SUCCESS, true);
            writableMapCreateMap.putString(APayConstants.Error.MESSAGE, "OK");
            TargetChosenReceiver.b(writableMapCreateMap);
        }
    }
}
