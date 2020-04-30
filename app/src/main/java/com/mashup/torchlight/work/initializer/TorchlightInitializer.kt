package com.mashup.torchlight.work.initializer

class TorchlightInitializer(val initListener: ITorchlightInitializerListener) {

    fun startInit() {
        initListener.onInitializeBegin()

        // do some initialization things.
        // (version check? validation check? whatever)

        initListener.onInitializeDone()
    }

}