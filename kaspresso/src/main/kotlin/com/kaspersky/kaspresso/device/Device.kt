package com.kaspersky.kaspresso.device

import android.content.Context
import android.os.Build
import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.*
import com.kaspersky.kaspresso.configurator.Configurator
import com.kaspersky.kaspresso.device.accessibility.Accessibility
import com.kaspersky.kaspresso.device.activities.Activities
import com.kaspersky.kaspresso.device.files.Files
import com.kaspersky.kaspresso.device.internet.Internet
import com.kaspersky.kaspresso.device.apps.Apps
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.device.screenshots.Screenshots
import com.kaspersky.kaspresso.device.permissions.Permissions

/**
 * A provider of managers for all off-screen work.
 */
object Device {

    /**
     * A not caching property to get [Context].
     */
    val context: Context
        get() = InstrumentationRegistry.getInstrumentation().context

    /**
     * A not caching property to get target [Context].
     */
    val targetContext: Context
        get() = InstrumentationRegistry.getInstrumentation().targetContext

    /**
     * A property to get an instance of [UiDevice].
     */
    val uiDevice: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    /**
     * Holds an implementation of [Apps] interface. If it was not specified in [Configurator.Builder], the default
     * implementation is used.
     */
    val apps: Apps = Configurator.apps

    /**
     * Holds a reference to an implementation of [Activities] interface, held by [Configurator].
     */
    val activities: Activities = Configurator.activities

    /**
     * Holds a reference to an implementation of [Files] interface, held by [Configurator].
     */
    var files: Files = Configurator.files

    /**
     * Holds a reference to an implementation of [Internet] interface, held by [Configurator].
     */
    var internet: Internet = Configurator.internet

    /**
     * Holds a reference to an implementation of [Screenshots] interface, held by [Configurator].
     */
    var screenshots: Screenshots = Configurator.screenshots

    /**
     * Holds a reference to an implementation of [Accessibility] interface, held by [Configurator].
     */
    var accessibility: Accessibility = Configurator.accessibility

    /**
     * Holds a reference to an implementation of [Permissions] interface, held by [Configurator].
     */
    var permissions: Permissions = Configurator.permissions

    /**
     * Holds a reference to an implementation of [Exploit] interface, held by [Configurator].
     */
    var exploit: Exploit = Configurator.exploit
}