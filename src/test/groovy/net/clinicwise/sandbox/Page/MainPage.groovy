package net.clinicwise.sandbox.Page

import geb.Module
/**
 * Created by artyom on 07.07.17.
 */
class MainPage extends BasePage {
    static at = { waitFor { $("div#flash_notice").text() == "Signed in successfully." } }
    static content = {
        accountName { $("#user_nav_link > span") }
        sideBar { waitFor { $("div#sidebar-shortcuts").module(SideBar) } }
    }

    boolean isAccountName(String name) {
        accountName.text() == name
    }

    def goToNewClient() {
        sideBar.newClientBtn.click()
        return browser.page
    }
}


class SideBar extends Module {
    static content = {
        newClientBtn(to: NewClientPage) { $("button#shortcut_plus_client_btn") }
    }
}