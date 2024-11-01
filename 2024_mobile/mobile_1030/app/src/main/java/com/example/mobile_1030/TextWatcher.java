package com.example.mobile_1030;

import android.text.Editable;
import android.text.NoCopySpan;

public interface TextWatcher extends NoCopySpan {
    public void beforeTextChanged(CharSequence s, int start, int count, int after);
    public void onTextChanged(CharSequence s, int start, int before, int count);
    public void afterTextChanged(Editable s);
}