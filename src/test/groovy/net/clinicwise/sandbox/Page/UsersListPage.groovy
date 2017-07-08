package net.clinicwise.sandbox.Page

/**
 * Created by artyom on 08.07.17.
 */
class UsersListPage extends BasePage {
    static at = { waitFor { $("#breadcrumbs > ul").text() == "Home Clients" } }
}
