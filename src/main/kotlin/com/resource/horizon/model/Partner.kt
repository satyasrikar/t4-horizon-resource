package com.resource.horizon.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Partner {
    @Id
    var partnerId = ""
    var name = ""
    var IRDA = ""
    var insuranceOffered = ""
    var imageUrl = ""
}