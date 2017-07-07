package net.clinicwise.sandbox.Test

import geb.spock.GebSpec
import net.clinicwise.sandbox.Page.LoginPage
import spock.lang.Stepwise

/**
 * Created by artyom on 07.07.17.
 */
@Stepwise
class ValidateTest extends GebSpec {
    def "User can open Login Page"() {
        when:
            to LoginPage
        then:
            at LoginPage
    }

    def "Validate form"() {
        when:
            submitForm(namedata, passworddata)
        then:
            errorMessage "Incorrect password"
        where:
        namedata || passworddata
        "foo"    || "bar"
        "bar"    || "foo"
    }
}
