package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class ShareCompat {

    public static class IntentBuilder {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f2714a;

        /* renamed from: b, reason: collision with root package name */
        public String f2715b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f2716c;

        public IntentBuilder(Activity activity) {
            Activity activity2;
            activity.getClass();
            Intent action = new Intent().setAction("android.intent.action.SEND");
            this.f2714a = action;
            action.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", activity.getPackageName());
            action.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", activity.getPackageName());
            action.addFlags(524288);
            Object baseContext = activity;
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    activity2 = null;
                    break;
                } else {
                    if (baseContext instanceof Activity) {
                        activity2 = (Activity) baseContext;
                        break;
                    }
                    baseContext = ((ContextWrapper) baseContext).getBaseContext();
                }
            }
            if (activity2 != null) {
                ComponentName componentName = activity2.getComponentName();
                this.f2714a.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
                this.f2714a.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
            }
        }

        public final Intent a() {
            ArrayList arrayList = this.f2716c;
            Intent intent = this.f2714a;
            if (arrayList != null && arrayList.size() > 1) {
                intent.setAction("android.intent.action.SEND_MULTIPLE");
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f2716c);
                ShareCompat.a(intent, this.f2716c);
                return intent;
            }
            intent.setAction("android.intent.action.SEND");
            ArrayList arrayList2 = this.f2716c;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                intent.putExtra("android.intent.extra.STREAM", (Parcelable) this.f2716c.get(0));
                ShareCompat.a(intent, this.f2716c);
                return intent;
            }
            intent.removeExtra("android.intent.extra.STREAM");
            intent.setClipData(null);
            intent.setFlags(intent.getFlags() & (-2));
            return intent;
        }
    }

    public static class IntentReader {
    }

    public static void a(Intent intent, ArrayList arrayList) {
        ClipData clipData = new ClipData(null, new String[]{intent.getType()}, new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra("android.intent.extra.HTML_TEXT"), null, (Uri) arrayList.get(0)));
        int size = arrayList.size();
        for (int i2 = 1; i2 < size; i2++) {
            clipData.addItem(new ClipData.Item((Uri) arrayList.get(i2)));
        }
        intent.setClipData(clipData);
        intent.addFlags(1);
    }
}
