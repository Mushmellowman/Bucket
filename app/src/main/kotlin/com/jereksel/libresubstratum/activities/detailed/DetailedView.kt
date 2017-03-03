package com.jereksel.libresubstratum.activities.detailed

import android.support.v7.app.AppCompatActivity
import com.jereksel.libresubstratum.App
import com.jereksel.libresubstratum.R
import com.jereksel.libresubstratum.domain.IPackageManager
import kotlinx.android.synthetic.main.activity_detailed.*
import org.androidannotations.annotations.AfterViews
import org.androidannotations.annotations.EActivity
import org.androidannotations.annotations.Extra
import javax.inject.Inject

@EActivity(R.layout.activity_detailed)
open class DetailedView : AppCompatActivity(), IDetailedView {

    @Extra
    lateinit var appId : String

    @Inject lateinit var presenter : IDetailedPresenter
    @Inject lateinit var pManager : IPackageManager

    @AfterViews
    fun init() {
        (application as App).getAppComponent(this).inject(this)
        imageView.setImageDrawable(pManager.getHeroImage(appId))
    }

}
