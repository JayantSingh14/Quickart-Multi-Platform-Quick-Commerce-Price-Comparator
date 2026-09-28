package androidx.emoji2.viewsintegration;

import android.text.Editable;
import androidx.emoji2.text.SpannableBuilder;

/* loaded from: classes.dex */
final class EmojiEditableFactory extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f4395a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f4396b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f4397c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f4397c;
        return cls != null ? new SpannableBuilder(cls, charSequence) : super.newEditable(charSequence);
    }
}
