package com.rezapour.woocertask.util

interface EntityMapper<Entity, DomailModel> {
    fun mapFromEntity(entity: Entity): DomailModel


    fun mapToEntity(domailModel: DomailModel): Entity
}