package i;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;

/* loaded from: classes4.dex */
public interface f {
    void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri);
}
