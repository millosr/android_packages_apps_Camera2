/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gallery3d.filtershow.editors;

import android.content.Context;
import android.widget.FrameLayout;

import com.android.gallery3d.R;
import com.android.gallery3d.filtershow.CropExtras;
import com.android.gallery3d.filtershow.imageshow.ImageCrop;
import com.android.gallery3d.filtershow.imageshow.MasterImage;

public class EditorCrop extends Editor implements EditorInfo {
    public static final int ID = R.id.editorCrop;
    private static final String LOGTAG = "EditorCrop";

    ImageCrop mImageCrop;
    private String mAspectString = null;
    private boolean mCropActionFlag = false;
    private CropExtras mCropExtras = null;

    public EditorCrop() {
        super(ID);
    }

    @Override
    public void createEditor(Context context, FrameLayout frameLayout) {
        super.createEditor(context, frameLayout);
        mView = mImageShow = mImageCrop = new ImageCrop(context);
        mImageCrop.setExtras(mCropExtras);
        mImageCrop.setAspectString(mAspectString);
        mImageCrop.setCropActionFlag(mCropActionFlag);
        mImageCrop.setImageLoader(MasterImage.getImage().getImageLoader());
        mImageCrop.setEditor(this);
        mImageCrop.syncLocalToMasterGeometry();
    }

    @Override
    public int getTextId() {
        return R.string.crop;
    }

    @Override
    public int getOverlayId() {
        return R.drawable.filtershow_button_geometry_crop;
    }

    @Override
    public boolean getOverlayOnly() {
        return true;
    }

    public void setExtras(CropExtras cropExtras) {
        mCropExtras = cropExtras;
    }

    public void setAspectString(String s) {
        mAspectString = s;
    }

    public void setCropActionFlag(boolean b) {
        mCropActionFlag = b;
    }

}
