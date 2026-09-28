package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

@RequiresApi
@RestrictTo
/* loaded from: classes3.dex */
final class EmojiInputConnection extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f4398a;

    /* renamed from: b, reason: collision with root package name */
    public final EmojiCompatDeleteHelper f4399b;

    public static class EmojiCompatDeleteHelper {
    }

    public EmojiInputConnection(EditText editText, InputConnection inputConnection, EditorInfo editorInfo) {
        EmojiCompatDeleteHelper emojiCompatDeleteHelper = new EmojiCompatDeleteHelper();
        super(inputConnection, false);
        this.f4398a = editText;
        this.f4399b = emojiCompatDeleteHelper;
        if (EmojiCompat.f4294k != null) {
            EmojiCompat.a().i(editorInfo);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i2, int i3) {
        Editable editableText = this.f4398a.getEditableText();
        this.f4399b.getClass();
        return EmojiCompat.c(this, editableText, i2, i3, false) || super.deleteSurroundingText(i2, i3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i2, int i3) {
        Editable editableText = this.f4398a.getEditableText();
        this.f4399b.getClass();
        return EmojiCompat.c(this, editableText, i2, i3, true) || super.deleteSurroundingTextInCodePoints(i2, i3);
    }
}
