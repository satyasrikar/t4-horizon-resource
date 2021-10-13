package com.resource.horizon.service

import com.resource.horizon.model.Partner
import com.resource.horizon.repository.PartnerRepository
import org.springframework.stereotype.Service

@Service
class PartnerService(val partnerRepository: PartnerRepository) {

    fun viewAllPartners(): List<Partner>{
        return partnerRepository.findAll()
    }

    fun addNewPartner(partner: Partner): Partner {
        return partnerRepository.save(partner)
    }

    fun viewPartnerById(partnerId: String): Partner {
        return partnerRepository.findPartnerByPartnerId(partnerId)
    }

    fun updatePartner(partner: Partner) :Partner {
        return partnerRepository.save(partner)
    }

    fun deletePartnerByPartnerId(partnerId: String): String {
        partnerRepository.deletePartnerByPartnerId(partnerId)
        return "Deleted"
    }
}