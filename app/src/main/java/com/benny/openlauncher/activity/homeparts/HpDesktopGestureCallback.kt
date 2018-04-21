package com.benny.openlauncher.activity.homeparts

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import com.benny.openlauncher.R
import com.benny.openlauncher.util.AppSettings
import com.benny.openlauncher.util.LauncherAction
import com.benny.openlauncher.util.Tool
import com.benny.openlauncher.viewutil.DesktopGestureListener
import com.benny.openlauncher.widget.Desktop

class HpDesktopGestureCallback : DesktopGestureListener.DesktopGestureCallback {
    val _appSettings: AppSettings

    constructor(appSettings: AppSettings) {
        _appSettings = appSettings
    }

    override fun onDrawerGesture(desktop: Desktop, event: DesktopGestureListener.Type): Boolean {
        val context: Context = _appSettings.context
        val packageManager: PackageManager = context.packageManager
        var gestureid: Int
        when (event) {
            DesktopGestureListener.Type.SwipeUp -> {
                gestureid = _appSettings.gestureSwipeUp
                if (gestureid != 0) {
                    val gesture = LauncherAction.getActionItem(gestureid - 1)
                    if (gesture != null && _appSettings.isGestureFeedback) {
                        Tool.vibrate(desktop)
                    }
                    if (gestureid == 9) {
                        gesture._extraData = Intent(packageManager.getLaunchIntentForPackage(_appSettings.getString(context.getString(R.string.pref_key__gesture_swipe_up) + "__", "")))
                    }
                    LauncherAction.RunAction(gesture, desktop.context)
                }
                return true
            }
            DesktopGestureListener.Type.SwipeDown -> {
                gestureid = _appSettings.gestureSwipeDown
                if (gestureid != 0) {
                    val gesture = LauncherAction.getActionItem(gestureid - 1)
                    if (gesture != null && _appSettings.isGestureFeedback) {
                        Tool.vibrate(desktop)
                    }
                    if (gestureid == 9) {
                        gesture._extraData = Intent(packageManager.getLaunchIntentForPackage(_appSettings.getString(context.getString(R.string.pref_key__gesture_swipe_down) + "__", "")))
                    }
                    LauncherAction.RunAction(gesture, desktop.context)
                }
                return true
            }
            DesktopGestureListener.Type.SwipeLeft -> return false
            DesktopGestureListener.Type.SwipeRight -> return false
            DesktopGestureListener.Type.Pinch -> {
                gestureid = _appSettings.gestureSwipeDown
                if (gestureid != 0) {
                    val gesture = LauncherAction.getActionItem(gestureid - 1)
                    if (gesture != null && _appSettings.isGestureFeedback) {
                        Tool.vibrate(desktop)
                    }
                    if (gestureid == 9) {
                        gesture._extraData = Intent(packageManager.getLaunchIntentForPackage(_appSettings.getString(context.getString(R.string.pref_key__gesture_pinch) + "__", "")))
                    }
                    LauncherAction.RunAction(gesture, desktop.context)
                }
                return true
            }
            DesktopGestureListener.Type.Unpinch -> {
                gestureid = _appSettings.gestureSwipeDown
                if (gestureid != 0) {
                    val gesture = LauncherAction.getActionItem(gestureid - 1)
                    if (gesture != null && _appSettings.isGestureFeedback) {
                        Tool.vibrate(desktop)
                    }
                    if (gestureid == 9) {
                        gesture._extraData = Intent(packageManager.getLaunchIntentForPackage(_appSettings.getString(context.getString(R.string.pref_key__gesture_unpinch) + "__", "")))
                    }
                    LauncherAction.RunAction(gesture, desktop.context)
                }
                return true
            }
            DesktopGestureListener.Type.DoubleTap -> {
                gestureid = _appSettings.gestureSwipeDown
                if (gestureid != 0) {
                    val gesture = LauncherAction.getActionItem(gestureid - 1)
                    if (gesture != null && _appSettings.isGestureFeedback) {
                        Tool.vibrate(desktop)
                    }
                    if (gestureid == 9) {
                        gesture._extraData = Intent(packageManager.getLaunchIntentForPackage(_appSettings.getString(context.getString(R.string.pref_key__gesture_double_tap) + "__", "")))
                    }
                    LauncherAction.RunAction(gesture, desktop.context)
                }
                return true
            }
            else -> {
                throw RuntimeException("Type not handled!")
            }
        }
    }
}
