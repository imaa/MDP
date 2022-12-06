package com.miu.student.mycv.infrastucture

import android.annotation.SuppressLint
import android.content.Context
import android.view.*
import android.view.View.OnTouchListener
import android.widget.ListView
import androidx.annotation.AttrRes
import androidx.annotation.MenuRes
import androidx.annotation.RestrictTo
import androidx.annotation.StyleRes
import androidx.appcompat.view.SupportMenuInflater
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.appcompat.view.menu.ShowableListMenu
import androidx.appcompat.widget.ForwardingListener
import androidx.appcompat.widget.PopupMenu
import com.miu.student.mycv.R


/**
 * Static library support version of the framework's [android.widget.PopupMenu].
 * Used to write apps that run on platforms prior to Android 3.0.  When running
 * on Android 3.0 or above, this implementation is still used; it does not try
 * to switch to the framework's implementation. See the framework SDK
 * documentation for a class overview.
 */
@SuppressLint("RestrictedApi")
class MyCVPopupMenu @JvmOverloads constructor(
    private val mContext: Context, private val mAnchor: View, gravity: Int = Gravity.NO_GRAVITY,
    @AttrRes popupStyleAttr: Int =  androidx.appcompat.R.attr.listMenuViewStyle , @StyleRes popupStyleRes: Int = androidx.appcompat.R.style.Base_Widget_AppCompat_ActionBar
) {
    private val mMenu: MenuBuilder
    val mPopup: MenuPopupHelper
    var mMenuItemClickListener: PopupMenu.OnMenuItemClickListener? = null
    var mOnDismissListener: PopupMenu.OnDismissListener? = null
    private var mDragListener: OnTouchListener? = null
    /**
     * Constructor a create a new popup menu with a specific style.
     *
     * @param mContext Context the popup menu is running in, through which it
     * can access the current theme, resources, etc.
     * @param mAnchor Anchor view for this popup. The popup will appear below
     * the anchor if there is room, or above it if there is not.
     * @param gravity The [Gravity] value for aligning the popup with its
     * anchor.
     * @param popupStyleAttr An attribute in the current theme that contains a
     * reference to a style resource that supplies default values for
     * the popup window. Can be 0 to not look for defaults.
     * @param popupStyleRes A resource identifier of a style resource that
     * supplies default values for the popup window, used only if
     * popupStyleAttr is 0 or can not be found in the theme. Can be 0
     * to not look for defaults.
     */
    /**
     * Constructor to create a new popup menu with an anchor view and alignment
     * gravity.
     *
     * @param mContext Context the popup menu is running in, through which it
     * can access the current theme, resources, etc.
     * @param mAnchor Anchor view for this popup. The popup will appear below
     * the anchor if there is room, or above it if there is not.
     * @param gravity The [Gravity] value for aligning the popup with its
     * anchor.
     */
    /**
     * Constructor to create a new popup menu with an anchor view.
     *
     * @param context Context the popup menu is running in, through which it
     * can access the current theme, resources, etc.
     * @param anchor Anchor view for this popup. The popup will appear below
     * the anchor if there is room, or above it if there is not.
     */
    init {
        mMenu = MenuBuilder(mContext)
        mMenu.setCallback(object : MenuBuilder.Callback {
            override fun onMenuItemSelected(menu: MenuBuilder, item: MenuItem): Boolean {
                return if (mMenuItemClickListener != null) {
                    mMenuItemClickListener!!.onMenuItemClick(item)
                } else false
            }

            override fun onMenuModeChange(menu: MenuBuilder) {}
        })
        mPopup = MenuPopupHelper(mContext, mMenu, mAnchor, false, popupStyleAttr, popupStyleRes)
        mPopup.gravity = gravity
        mPopup.setOnDismissListener {

        }
        mPopup.setForceShowIcon(true)

    }
    /**
     * @return the gravity used to align the popup window to its anchor view
     * @see .setGravity
     */
    /**
     * Sets the gravity used to align the popup window to its anchor view.
     *
     *
     * If the popup is showing, calling this method will take effect only
     * the next time the popup is shown.
     *
     * @param gravity the gravity used to align the popup window
     * @see .getGravity
     */
    var gravity: Int
        get() = mPopup.gravity
        set(gravity) {
            mPopup.gravity = gravity
        }// This will be null until show() is called.

    /**
     * Returns an [View.OnTouchListener] that can be added to the anchor view
     * to implement drag-to-open behavior.
     *
     *
     * When the listener is set on a view, touching that view and dragging
     * outside of its bounds will open the popup window. Lifting will select
     * the currently touched list item.
     *
     *
     * Example usage:
     * <pre>
     * PopupMenu myPopup = new PopupMenu(context, myAnchor);
     * myAnchor.setOnTouchListener(myPopup.getDragToOpenListener());
    </pre> *
     *
     * @return a touch listener that controls drag-to-open behavior
     */
    val dragToOpenListener: OnTouchListener
        get() {
            if (mDragListener == null) {
                mDragListener = object : ForwardingListener(mAnchor) {
                    override fun onForwardingStarted(): Boolean {
                        show()
                        return true
                    }

                    override fun onForwardingStopped(): Boolean {
                        dismiss()
                        return true
                    }

                    override fun getPopup(): ShowableListMenu {
                        // This will be null until show() is called.
                        return mPopup.popup
                    }
                }
            }
            return mDragListener!!
        }

    /**
     * Returns the [Menu] associated with this popup. Populate the
     * returned Menu with items before calling [.show].
     *
     * @return the [Menu] associated with this popup
     * @see .show
     * @see .getMenuInflater
     */
    val menu: Menu
        get() = mMenu

    /**
     * @return a [MenuInflater] that can be used to inflate menu items
     * from XML into the menu returned by [.getMenu]
     * @see .getMenu
     */
    val menuInflater: MenuInflater
        get() = SupportMenuInflater(mContext)

    /**
     * Inflate a menu resource into this PopupMenu. This is equivalent to
     * calling `popupMenu.getMenuInflater().inflate(menuRes, popupMenu.getMenu())`.
     *
     * @param menuRes Menu resource to inflate
     */
    fun inflate(@MenuRes menuRes: Int) {
        menuInflater.inflate(menuRes, mMenu)
    }

    /**
     * Show the menu popup anchored to the view specified during construction.
     *
     * @see .dismiss
     */
    fun show() {
        mPopup.show()
    }

    /**
     * Dismiss the menu popup.
     *
     * @see .show
     */
    fun dismiss() {
        mPopup.dismiss()
    }

    /**
     * Sets a listener that will be notified when the user selects an item from
     * the menu.
     *
     * @param listener the listener to notify
     */
    fun setOnMenuItemClickListener(listener: PopupMenu.OnMenuItemClickListener?) {
        mMenuItemClickListener = listener
    }

    /**
     * Sets a listener that will be notified when this menu is dismissed.
     *
     * @param listener the listener to notify
     */
    fun setOnDismissListener(listener: PopupMenu.OnDismissListener?) {
        mOnDismissListener = listener
    }

    /**
     * Sets whether the popup menu's adapter is forced to show icons in the
     * menu item views.
     *
     *
     * Changes take effect on the next call to show().
     *
     * @param forceShowIcon `true` to force icons to be shown, or
     * `false` for icons to be optionally shown
     */
    fun setForceShowIcon(forceShowIcon: Boolean) {
        mPopup.setForceShowIcon(forceShowIcon)
    }

    /**
     * Interface responsible for receiving menu item click events if the items
     * themselves do not have individual item click listeners.
     */
    interface OnMenuItemClickListener {
        /**
         * This method will be invoked when a menu item is clicked if the item
         * itself did not already handle the event.
         *
         * @param item the menu item that was clicked
         * @return `true` if the event was handled, `false`
         * otherwise
         */
        fun onMenuItemClick(item: MenuItem?): Boolean
    }

    /**
     * Callback interface used to notify the application that the menu has closed.
     */
    interface OnDismissListener {
        /**
         * Called when the associated menu has been dismissed.
         *
         * @param menu the popup menu that was dismissed
         */
        fun onDismiss(menu: PopupMenu?)
    }

    /**
     * Returns the [ListView] representing the list of menu items in the currently showing
     * menu.
     *
     * @return The view representing the list of menu items.
     * @hide
     */
    @get:RestrictTo(RestrictTo.Scope.LIBRARY_GROUP_PREFIX)
    val menuListView: ListView?
        get() = if (!mPopup.isShowing) {
            null
        } else mPopup.listView
}