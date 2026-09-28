package com.imagepicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import androidx.constraintlayout.motion.widget.a;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class ImagePickerModuleImpl implements ActivityEventListener {

    /* renamed from: a, reason: collision with root package name */
    public Uri f45930a;

    /* renamed from: b, reason: collision with root package name */
    public ReactApplicationContext f45931b;

    /* renamed from: c, reason: collision with root package name */
    public Callback f45932c;

    /* renamed from: d, reason: collision with root package name */
    public Options f45933d;

    /* renamed from: e, reason: collision with root package name */
    public Uri f45934e;

    @Override // com.facebook.react.bridge.ActivityEventListener
    public final void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        List listSingletonList;
        switch (i2) {
            case 13001:
            case 13002:
            case 13003:
                if (this.f45932c == null) {
                    return;
                }
                if (i3 != -1) {
                    if (i2 == 13001) {
                        new File(this.f45930a.getPath()).delete();
                    }
                    try {
                        Callback callback = this.f45932c;
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putBoolean("didCancel", true);
                        callback.invoke(writableMapCreateMap);
                        return;
                    } catch (RuntimeException e2) {
                        this.f45932c.invoke(Utils.d("others", e2.getMessage()));
                    } finally {
                        this.f45932c = null;
                    }
                }
                ReactApplicationContext reactApplicationContext = this.f45931b;
                switch (i2) {
                    case 13001:
                        if (this.f45933d.f45945h.booleanValue()) {
                            Utils.l(this.f45934e, reactApplicationContext, "photo");
                        }
                        Executors.newSingleThreadExecutor().submit(new a(26, this, Collections.singletonList(this.f45930a)));
                        return;
                    case 13002:
                        if (this.f45933d.f45945h.booleanValue()) {
                            Utils.l(this.f45934e, reactApplicationContext, "video");
                        }
                        Executors.newSingleThreadExecutor().submit(new a(26, this, Collections.singletonList(this.f45930a)));
                        return;
                    case 13003:
                        if (intent.getClipData() == null) {
                            listSingletonList = Collections.singletonList(intent.getData());
                        } else {
                            ClipData clipData = intent.getClipData();
                            ArrayList arrayList = new ArrayList(clipData.getItemCount());
                            for (int i4 = 0; i4 < clipData.getItemCount(); i4++) {
                                arrayList.add(clipData.getItemAt(i4).getUri());
                            }
                            listSingletonList = arrayList;
                        }
                        Executors.newSingleThreadExecutor().submit(new a(26, this, listSingletonList));
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    @Override // com.facebook.react.bridge.ActivityEventListener
    public final void onNewIntent(Intent intent) {
    }
}
