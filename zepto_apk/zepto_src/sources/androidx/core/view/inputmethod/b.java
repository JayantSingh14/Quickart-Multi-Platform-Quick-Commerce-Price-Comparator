package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements InputConnectionCompat.OnCommitContentListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatEditText f3225a;

    public /* synthetic */ b(AppCompatEditText appCompatEditText) {
        this.f3225a = appCompatEditText;
    }

    public final boolean a(InputContentInfoCompat inputContentInfoCompat, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i2 & 1) != 0) {
            try {
                inputContentInfoCompat.f3220a.c();
                Parcelable parcelable = (Parcelable) inputContentInfoCompat.f3220a.a();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e2) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e2);
                return false;
            }
        }
        ClipDescription description = inputContentInfoCompat.f3220a.getDescription();
        InputContentInfoCompat.InputContentInfoCompatImpl inputContentInfoCompatImpl = inputContentInfoCompat.f3220a;
        ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(new ClipData(description, new ClipData.Item(inputContentInfoCompatImpl.b())), 2);
        builder.d(inputContentInfoCompatImpl.d());
        builder.b(bundle);
        return ViewCompat.u(this.f3225a, builder.a()) == null;
    }
}
