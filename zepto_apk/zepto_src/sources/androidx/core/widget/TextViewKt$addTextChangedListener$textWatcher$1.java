package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;

@Metadata
/* loaded from: classes3.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function1<Editable, Unit> f3298a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, Unit> f3299b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, Unit> f3300c;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f3298a.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f3299b.d(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f3300c.d(charSequence, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }
}
