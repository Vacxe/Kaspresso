package com.kaspersky.kaspresso.tutorials.test

import android.Manifest
import androidx.test.rule.ActivityTestRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorials.MainActivity
import com.kaspersky.kaspresso.tutorials.R
import com.kaspersky.kaspresso.tutorials.screen.MainScreen
import com.kaspersky.kaspresso.tutorials.screen.SimpleScreen
import org.junit.Rule
import org.junit.Test

/**
 * In this example you can see a test tuned by default Kaspresso configuration.
 * When you start the test you can see output of default Kaspresso interceptors:
 * - a lot of useful logs
 * - failure handling
 * - screenshots in the device
 * Also you can see the test DSL simplifying the writing of any test
 */
class SimpleTest : TestCase() {

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun test() =
        before {
            testLogger.i("Before section")
        }.after {
            testLogger.i("After section")
        }.run {
            step("Open Simple Screen") {
                testLogger.i("Main section")
                activityTestRule.launchActivity(null)
                device.screenshots.take("Additional_screenshot")
                
                MainScreen {
                    simpleButton {
                        isVisible()
                        click()
                    }
                }
            }

            step("Click button_1 and check button_2") {
                SimpleScreen {
                    button1 {
                        click()
                    }
                    button2 {
                        isVisible()
                    }
                }
            }

            step("Click button_2 and check edit") {
                SimpleScreen {
                    button2 {
                        click()
                    }
                    edit {
                        flakySafely(timeoutMs = 7000) { isVisible() }
                        hasText(R.string.simple_fragment_text_edittext)
                    }
                }
            }

            step("Check all possibilities of edit") {
                scenario(
                    CheckEditScenario()
                )
            }
    }
}
