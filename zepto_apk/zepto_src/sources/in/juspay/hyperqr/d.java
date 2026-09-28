package in.juspay.hyperqr;

import androidx.camera.core.ImageProxy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements OnCompleteListener, OnFailureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f48494a;

    public /* synthetic */ d(Object obj) {
        this.f48494a = obj;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        QRCodeAnalyzer.analyze$lambda$2((ImageProxy) this.f48494a, task);
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        InputImageScanner.scanImage$lambda$1((InputImageScanner) this.f48494a, exc);
    }
}
