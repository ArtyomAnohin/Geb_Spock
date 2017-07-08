package net.clinicwise.sandbox.Page

import geb.Module
import geb.Page

/**
 * Created by artyom on 08.07.17.
 */
class BasePage extends Page {
    static content = {
        userNav { waitFor { $("ul.user-menu").module(UserDropdownMenu) } }
    }

    def logout() {
        $("#user_nav_link > span").click()
        userNav.logoutMenu.click()
    }
}

class UserDropdownMenu extends Module {
    static content = {
        logoutMenu { waitFor { $("a#sign_out_link") } }
    }
}