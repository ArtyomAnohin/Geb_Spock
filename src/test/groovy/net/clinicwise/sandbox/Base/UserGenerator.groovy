package net.clinicwise.sandbox.Base

import groovy.json.JsonSlurper

/**
 * Created by artyom on 08.07.17.
 */
class UserGenerator {
    static def getAvatar(def path) {

        String fileName = new File("").getAbsolutePath().split('src')[0] + "\\build\\${path.tokenize('/')[-1]}"
        new File(fileName).withOutputStream { out ->
            out << new URL(path).openStream()
        }
        return fileName
    }
    static def randNum(Integer n){
        Random rand = new Random()
        def randomIntegerList = []
        (1..n).each {
            randomIntegerList << rand.nextInt(10)
        }
        return randomIntegerList
    }
    static def Client() {
        User newUser = new User()
        def user = new JsonSlurper().parse(new URL("https://randomuser.me/api/"))
        if (user) {
            newUser.lastName = user.results.name.last.get(0).capitalize()
            newUser.firstName = user.results.name.first.get(0).capitalize()
            newUser.gender = (user.results.gender.get(0) == 'male')
            newUser.birth = Date.parse('yyyy-MM-dd HH:mm:ss',user.results.dob.get(0)).format('dd/MM/yyyy')
            newUser.avatar = getAvatar(user.results.picture.large.get(0))
            newUser.phone = String.format("0491 %s %s", randNum(3).join(), randNum(3).join())
            newUser.email = user.results.email.get(0)
            newUser.address = user.results.location.state.get(0).capitalize()+", " +
                    user.results.location.city.get(0).capitalize() + ", " +
                    user.results.location.street.get(0)
            newUser.postcode = user.results.location.postcode.get(0)
            newUser.yearsOld=(new Date()..Date.parse('yyyy-MM-dd HH:mm:ss',user.results.dob.get(0))).collect { it[ Calendar.YEAR ]}
                    .unique()
                    .size()-2
        }
        return newUser
    }
}
class User{
    def lastName
    def firstName
    def gender
    def birth
    def avatar
    def phone
    def email
    def address
    def postcode
    def yearsOld
}
