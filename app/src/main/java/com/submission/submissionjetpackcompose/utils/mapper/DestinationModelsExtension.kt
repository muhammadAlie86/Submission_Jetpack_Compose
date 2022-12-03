package com.submission.submissionjetpackcompose.utils.mapper

import com.submission.submissionjetpackcompose.data.model.DestinationEntity
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain

fun DestinationEntity.toDomain() = DestinationDomain(
    id = id, name, rate, location, description, image
)
fun DestinationDomain.toEntity() = DestinationEntity(
    id, name, rate, location, description, image
)

fun List<DestinationEntity>.toDestinationDomainList() = map { it.toDomain() }
