package net.clinicwise.sandbox.Page

import geb.Module
import geb.Page

/**
 * Created by artyom on 07.07.17.
 */
class LoginPage extends Page {

    static url = "http://sandbox.clinicwise.net"
    static at = {
        $("div#company_name").text() == "Wise Clinic sandbox"
    }
    static content = {
        form { $("form").module(LoginForm) }
        error { waitFor { $("div#flash_alert") } }
    }

    def submitForm(def username, def password) {
        form.username << username
        form.password << password
        form.submit.click()
    }

    boolean errorMessage(String msg) {
        error.text() == msg
    }
}

class LoginForm extends Module {
    static content = {
        username { $("input#username") }
        password { $("input#password") }
        submit { $("input#signin_button") }
    }
}