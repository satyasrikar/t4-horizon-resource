package com.resource.horizon.repository

import com.resource.horizon.model.Partner
import org.springframework.data.mongodb.repository.MongoRepository

interface PartnerRepository : MongoRepository<Partner, String> {

    fun findPartnerByPartnerId(partnerId: String): Partner
    fun deletePartnerByPartnerId(partnerId: String): String
}