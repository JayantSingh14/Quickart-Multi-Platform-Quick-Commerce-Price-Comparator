package com.amazon.identity.auth.device.workflow;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.interactive.InteractiveListener;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import java.util.Objects;
import l.a;
import l.b;

/* loaded from: classes3.dex */
public abstract class BaseWorkflowListener<T, U, V> implements InteractiveListener<T, U, V> {
    public abstract void a();

    public abstract void b();

    public abstract void c();

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener
    public final void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, a aVar) {
        a();
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, i.f
    public final void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri) {
        b bVar = new b(uri);
        if (bVar.a() == null) {
            Objects.toString(bVar.f56129c);
            c();
        } else {
            bVar.a().getMessage();
            bVar.a();
            b();
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener
    public final void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc) {
        exc.getMessage();
        b();
    }
}
