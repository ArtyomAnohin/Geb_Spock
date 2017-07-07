package net.clinicwise.sandbox.Test

import geb.spock.GebSpec
import net.clinicwise.sandbox.Page.LoginPage
import net.clinicwise.sandbox.Page.MainPage
import spock.lang.Stepwise

/**
 * Created by artyom on 07.07.17.
 */
@Stepwise
class LoginTest extends GebSpec {

    def "User can successfully login"() {
        when:
        submitForm("natalie", "test")
        then:
        at MainPage
        and:
        isAccountName "Natalie Portman"
        and:
        logout()
        at LoginPage
    }

    def setupSpec() {
        when:
        to LoginPage
        then:
        at LoginPage
    }

}
