package com.resource.horizon.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class User {

    @Id
    var userId = ""
    var name = ""
    var address = ""
    var email = ""
    var phone = ""
    var insuranceType = ""

}