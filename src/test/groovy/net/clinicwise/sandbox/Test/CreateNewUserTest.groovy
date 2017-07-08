package net.clinicwise.sandbox.Test

import geb.spock.GebSpec
import net.clinicwise.sandbox.Base.UserGenerator
import net.clinicwise.sandbox.Page.LoginPage
import net.clinicwise.sandbox.Page.MainPage
import net.clinicwise.sandbox.Page.NewClientPage
import net.clinicwise.sandbox.Page.UsersListPage
import spock.lang.Stepwise

/**
 * Created by artyom on 08.07.17.
 */
@Stepwise
class CreateNewUserTest extends GebSpec {
    def setupSpec() {
        given:
            to LoginPage
            at LoginPage
        when:
            submitForm("natalie", "test")
        then:
            at MainPage
            isAccountName "Natalie Portman"
    }

    def "User can add a new client"() {
        given:
            NewClientPage newClientPage = goToNewClient()
            at NewClientPage
        when:
            def newClient = UserGenerator.Client()
            practitioner = "Mark Huang"
            newClientPage.submitForm(newClient)
        then:
            at UsersListPage
    }
    def cleanupSpec(){
        when:
            logout()
        then:
            at LoginPage
    }
}
