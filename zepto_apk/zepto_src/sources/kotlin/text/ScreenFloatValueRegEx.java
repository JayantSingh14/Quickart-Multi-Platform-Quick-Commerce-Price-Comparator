package kotlin.text;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
final class ScreenFloatValueRegEx {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ScreenFloatValueRegEx f53999a = new ScreenFloatValueRegEx();

    /* renamed from: b, reason: collision with root package name */
    public static final Regex f54000b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
}
