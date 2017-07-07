package net.clinicwise.sandbox.Page

import geb.Module
import geb.Page

/**
 * Created by artyom on 07.07.17.
 */
class MainPage extends Page {
    static at = { waitFor { $("div#flash_notice").text() == "Signed in successfully." } }
    static content = {
        accountName { $("#user_nav_link > span") }
        userNav { waitFor { $("ul.user-menu").module(UserNav) } }
    }

    boolean isAccountName(String name) {
        accountName.text() == name
    }

    def logout() {
        accountName.click()
        userNav.logoutMenu.click()
    }
}

class UserNav extends Module {
    static content = {
        logoutMenu { $("a#sign_out_link") }
    }
}