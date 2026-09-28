package cl.json.social;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import com.facebook.react.bridge.ReadableMap;
import java.io.IOException;

/* loaded from: classes3.dex */
public class WhatsAppShare extends SingleShareIntent {
    @Override // cl.json.social.ShareIntent
    public final String b() {
        return null;
    }

    @Override // cl.json.social.ShareIntent
    public final String c() {
        return "com.whatsapp";
    }

    @Override // cl.json.social.ShareIntent
    public final String d() {
        return "market://details?id=com.whatsapp";
    }

    @Override // cl.json.social.SingleShareIntent, cl.json.social.ShareIntent
    public final void f(ReadableMap readableMap) throws InterruptedException, PackageManager.NameNotFoundException, IOException {
        super.f(readableMap);
        if (readableMap.hasKey("whatsAppNumber")) {
            try {
                this.f13832b.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                g(null);
                Thread.sleep(10L);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f13832b.setComponent(null);
        g(null);
    }
}
