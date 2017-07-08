package net.clinicwise.sandbox.Page

import geb.Module
import net.clinicwise.sandbox.Base.User

/**
 * Created by artyom on 08.07.17.
 */
class NewClientPage extends BasePage {
    static at = { waitFor { $("#new_client > fieldset > legend").text() == "New client" } }
    static content = {
        practitioner { $("select#doctor_id") }
        newUserForm { waitFor { $("div#patient_summary_details").module(UserForm) } }
        submitBtn(to: UsersListPage) { $("input#create_client_btn") }
    }

    def submitForm(User user) {
        newUserForm.lastName = user.lastName
        newUserForm.firstName = user.firstName
        user.gender ? newUserForm.genderMale.click() : newUserForm.genderFemale.click()
        newUserForm.dob = user.birth
        newUserForm.avatar = user.avatar
        newUserForm.mobile = user.phone
        newUserForm.email = user.email
        newUserForm.address = user.address
        submitBtn.click()
    }
}

class UserForm extends Module {
    static content = {
        lastName { $("input#client_last_name") }
        firstName { $("input#client_first_name") }
        genderMale { $("input#client_gender_male") }
        genderFemale { $("input#client_gender_female") }
        vip { $("input#client_is_vip") }
        dob { $("input#client_birth_date") }
        medicare { $("input#client_medicare_number") }
        irn { $("input#client_medicare_irn") }
        avatar { $("input#client_avatar") }
        mobile { $("input#client_mobile") }
        email { $("input#client_email") }
        address { $("input#client_address_line_1") }
    }
}